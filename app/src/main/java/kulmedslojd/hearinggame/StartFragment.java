package kulmedslojd.hearinggame;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.widget.Toolbar;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentFormListener;
import com.google.ads.consent.ConsentInfoUpdateListener;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {

    private int mButtonHeight;
    private View mView;
    private String TAG = this.getClass().getSimpleName();
    private ConsentForm form;
    private boolean adFree = false;
    private boolean mIsTextView = false;
    public static String ISTEXTVIEW = "isTextView";
    public static String ISBUTTONPRACTICECLICK = "isButtonPracticeClick";
    private int nCounts;
    private Timer mTimer;
    private InterstitialAd mInterstitialAd2;
    private ImageView imageView;
    private ProgressBar progressbar;
    private  View view;
    protected Button mButtonPractice;
    protected Button mButtonPlayGame;
    private TextView mTextView;
    private boolean isButtonPracticeClick = false;
    private BroadcastReceiver mBroadcastReceiver;
    private boolean mDoNotClose = false;
    private boolean isLoading = false;


    public StartFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        changeStateWithBroadCast();
        checkForConsent();
        loadAds();
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_start, container, false);
        Toolbar toolbar = mView.findViewById(R.id.my_toolbar);
        if (getActivity() != null)
        {
            ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        }

        if (getActivity() != null)
        {
            getActivity().setTitle(getString(R.string.app_name));
        }

        return mView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ISTEXTVIEW, mIsTextView);
        outState.putBoolean(ISBUTTONPRACTICECLICK, isButtonPracticeClick);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        initWelcomeImage();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isLoading)
        {
            enableButtons();
            isLoading = false;
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onPause() {
        super.onPause();
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (mBroadcastReceiver != null)
        {
            if (getActivity() != null)
            {
                (getActivity()).unregisterReceiver(mBroadcastReceiver);
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        if (savedInstanceState != null)
        {
            mIsTextView = savedInstanceState.getBoolean(ISTEXTVIEW);
            isButtonPracticeClick = savedInstanceState.getBoolean(ISBUTTONPRACTICECLICK);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.menu_start_activity, menu);//Menu Resource, Menu

        MenuItem mConsentItem = menu.findItem(R.id.consent);
        if (!ConsentInformation.getInstance(getContext())
                .isRequestLocationInEeaOrUnknown())
        {
            mConsentItem.setVisible(false);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.help:
                showDialog(getString(R.string.help_info_start),getString(R.string.help) );
                return true;

            case R.id.consent:
                requestConsent();
                return true;

            case R.id.privacy_policy:
                startWebViewActivity();
                return true;

            default:
                return onOptionsItemSelected(item);
        }
    }

    public void showDialog(String message, String title)
    {
        if (getActivity() != null)
        {
            FragmentManager fm =  getActivity().getSupportFragmentManager();
            DialogOkFragment alertDialog = DialogOkFragment.newInstance(title, message, adFree);
            alertDialog.setTargetFragment(StartFragment.this,1);
            alertDialog.setCancelable(false);
            alertDialog.show(fm, "fragment_alert");
        }
    }
    public int getOrientation()
    {
        if(getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().heightPixels)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    private void initWelcomeImage() {
        imageView = mView.findViewById(R.id.welcome_Image);

        if (mIsTextView)
        {
            imageView.setVisibility(View.INVISIBLE);
            initStartView();
            initButtonPractice();
            initButtonPlayGame();
            initButtonHelp();

        }
        else
        {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView.setVisibility(View.INVISIBLE);
                    initStartView();
                    initButtonPractice();
                    initButtonPlayGame();
                    initButtonHelp();
                    mIsTextView = true;
                }
            });
        }
    }

    private void startTimerPractice()
    {
        nCounts = 0;
        if (mTimer != null)
        {
            mTimer.cancel();
            mTimer = null;
        }
        mTimer = new Timer();
        TimerTask mTimerTask = new TimerTask()
        {
            public void run()
            {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run()
                    {
                        if (nCounts == 5 || mInterstitialAd2.isLoaded())
                        {
                            mTimer.cancel();
                            mTimer = null;
                            mTextView.setVisibility(View.INVISIBLE);
                            progressbar.setVisibility(View.INVISIBLE);
                            showInterstitial2();

                        }
                        nCounts++;
                    }
                });
            }
        }; // TimerTask
        mTimer.schedule(mTimerTask, 16, 1000); //start timer
    }
    private void startTimerPlayGame()
    {
        nCounts = 0;
        if (mTimer != null)
        {
            mTimer.cancel();
            mTimer = null;
        }
        mTimer = new Timer();

        TimerTask mTimerTask = new TimerTask()
        {
            public void run()
            {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run()
                    {
                        if (nCounts == 5 || mInterstitialAd2.isLoaded())
                        {
                            mTimer.cancel();
                            mTimer = null;
                            progressbar.setVisibility(View.INVISIBLE);
                            mTextView.setVisibility(View.INVISIBLE);
                            showInterstitial2();
                        }
                        nCounts++;
                    }
                });
            }
        }; // TimerTask
        mTimer.schedule(mTimerTask, 16, 1000); //start timer
    }

    private void initStartView()
    {
        view = mView.findViewById(R.id.game_view);
        view.setVisibility(View.VISIBLE);
    }

    private void initButtonHelp()
    {
        Button mButtonHelp = mView.findViewById(R.id.help_button_main);
        mButtonHeight = mButtonHelp.getLineHeight() + mButtonHelp.getPaddingBottom() + mButtonHelp.getPaddingTop();
    }
    private void loadPractice()
    {
        PracticeFragment mPracticeFragment = new PracticeFragment();
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_left, R.anim.exit_to_right )
                    .replace(R.id.placeholder, mPracticeFragment, "practice_fragment")
                    .addToBackStack("practice_fragment")
                    .commit();
    }
    private void initButtonPractice()
    {
        mButtonPractice = mView.findViewById(R.id.button_practice_main);
        mButtonPractice.setVisibility(View.VISIBLE);
        mButtonPractice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                isLoading = true;
                mDoNotClose = true;
                if (getActivity() != null)
                {
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
                }
                mButtonPractice.setEnabled(false);
                mButtonPlayGame.setEnabled(false);
                Random random = new Random();
                int number = random.nextInt(2);
                if (number == 0)
                {
                    if (mInterstitialAd2 != null && mInterstitialAd2.isLoaded())
                    {
                        mInterstitialAd2.show();
                        isButtonPracticeClick = true;
                    }
                    else
                    {

                        progressbar = mView.findViewById(R.id.progressBar);
                        progressbar.setVisibility(View.VISIBLE);
                        mTextView = mView.findViewById(R.id.textView);
                        mTextView.setText(getString(R.string.loading_ad_message));
                        mTextView.setVisibility(View.VISIBLE);
                        isButtonPracticeClick = true;
                        startTimerPractice();
                    }
                }
                else
                {
                    loadPractice();
                }
            }
        });
    }

    private void initButtonPlayGame()
    {
        mButtonPlayGame = mView.findViewById(R.id.button_play_main);
        mButtonPlayGame.setVisibility(View.VISIBLE);
        mButtonPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                isLoading = true;
                mDoNotClose = true;
                if (getActivity() != null)
                {
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
                }
                mButtonPractice.setEnabled(false);
                mButtonPlayGame.setEnabled(false);
                if (mInterstitialAd2.isLoaded())
                {
                    mInterstitialAd2.show();
                    isButtonPracticeClick = false;
                }
                else
                {
                    progressbar = mView.findViewById(R.id.progressBar);
                    progressbar.setVisibility(View.VISIBLE);
                    mTextView = mView.findViewById(R.id.textView);
                    mTextView.setVisibility(View.VISIBLE);
                    mTextView.setText(getString(R.string.loading_ad_message));
                    isButtonPracticeClick = false;
                    startTimerPlayGame();
                }
            }
        });
    }
    public void loadGameActivity()
    {
        Intent intent = new Intent(getActivity(), GameActivity.class);
        intent.putExtra(GameActivity.BUTTONHEIGHT, mButtonHeight);
        startActivity(intent);
    }
    private void startWebViewActivity()
    {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        startActivity(intent);
    }

    private void requestConsent() {
        URL privacyUrl = null;
        try {
            /*
            watch this video how to create privacy policy in mint
            https://www.youtube.com/watch?v=lSWSxyzwV-g&t=140s
            */
            privacyUrl = new URL("https://docs.google.com/document/d/1dNHZ8yTSTdrc8AcJMKUO39c5yEcobryA8RZuET8-l3o/edit?usp=sharing");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // Handle error.
        }
        form = new ConsentForm.Builder(getContext(), privacyUrl)
                .withListener(new ConsentFormListener() {
                    @Override
                    public void onConsentFormLoaded() {
                        // Consent form loaded successfully.
                        Log.d(TAG, "Requesting Consent: onConsentFormLoaded");
                        showForm();
                    }

                    @Override
                    public void onConsentFormOpened() {
                        // Consent form was displayed.
                        Log.d(TAG, "Requesting Consent: onConsentFormOpened");
                    }

                    @Override
                    public void onConsentFormClosed(
                            ConsentStatus consentStatus, Boolean userPrefersAdFree) {
                        Log.d(TAG, "Requesting Consent: onConsentFormClosed");
                        if (userPrefersAdFree) {
                            // Buy or Subscribe
                            Log.d(TAG, "Requesting Consent: User prefers AdFree");
                            adFree = true;
                            //ConsentInformation.getInstance(getContext()).setConsentStatus(ConsentStatus.UNKNOWN);
                            showDialog(getString(R.string.adfree_message), getString(R.string.message));
                        } else
                            {
                            Log.d(TAG, "Requesting Consent: Requesting consent again");
                            switch (consentStatus) {
                                case PERSONALIZED:

                                    loadInterstitial2Personal();
                                    break;

                                case NON_PERSONALIZED:

                                    loadInterstitial2();
                                    break;

                                case UNKNOWN:
                                    if (ConsentInformation.getInstance(getContext())
                                            .isRequestLocationInEeaOrUnknown()) {
                                        requestConsent();
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        // Consent form was closed.
                    }

                    @Override
                    public void onConsentFormError(String errorDescription) {
                        Log.d(TAG, "Requesting Consent: onConsentFormError. Error - " + errorDescription);
                        // Consent form error.
                    }
                })
                .withPersonalizedAdsOption()
                .withNonPersonalizedAdsOption()
                .withAdFreeOption()
                .build();
        form.load();
    }

    private void showForm() {
        if (form == null) {
            Log.d(TAG, "Consent form is null");
        }
        if (form != null) {
            Log.d(TAG, "Showing consent form");
            form.show();
        } else {
            Log.d(TAG, "Not Showing consent form");
        }
    }

    private void loadInterstitial2()
    {
        if (mInterstitialAd2 != null)
        {
            mInterstitialAd2 = null;
        }
        if (getActivity() != null)
        mInterstitialAd2 = new InterstitialAd(getActivity());
        mInterstitialAd2.setAdUnitId(getString(R.string.interstitial_full_screen));
        Bundle extras = new Bundle();
        extras.putString("npa", "1");

        List<String> testDevices = new ArrayList<>();
        testDevices.add(AdRequest.DEVICE_ID_EMULATOR);
        testDevices.add("4EFEC458E4A804759AE4EBBAF9BCA8FC");
        testDevices.add("CDB7F5FFECC27E712AD992EA72C397F9");
        RequestConfiguration mRequestConfiguration
                = new RequestConfiguration.Builder()
                .setTestDeviceIds(testDevices)
                .build();
        MobileAds.setRequestConfiguration(mRequestConfiguration);

        AdRequest adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class,extras)
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd2.loadAd(adRequest);

        mInterstitialAd2.setAdListener(new AdListener()
        {
            @Override
            public void onAdLoaded() {

            }
            @Override
            public void onAdClosed()
            {
                if (getActivity() != null)
                {
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                }

                if (!isButtonPracticeClick)
                {
                    loadGameActivity();
                }
                else
                {
                    loadPractice();
                }
                mInterstitialAd2 = null;
                loadAds();
            }
        });
    }
    private void loadInterstitial2Personal()
    {
        if (mInterstitialAd2 != null)
        {
            mInterstitialAd2 = null;
        }
        if (getActivity() != null)
        {
            mInterstitialAd2 = new InterstitialAd(getActivity());
            mInterstitialAd2.setAdUnitId(getString(R.string.interstitial_full_screen_practice_view));
            //Bundle extras = new Bundle();
            //extras.putString("max_ad_content_rating", "G");

            List<String> testDevices = new ArrayList<>();
            testDevices.add(AdRequest.DEVICE_ID_EMULATOR);
            testDevices.add("4EFEC458E4A804759AE4EBBAF9BCA8FC");
            testDevices.add("CDB7F5FFECC27E712AD992EA72C397F9");
            RequestConfiguration mRequestConfiguration
                    = new RequestConfiguration.Builder()
                    .setTestDeviceIds(testDevices)
                    .build();
            MobileAds.setRequestConfiguration(mRequestConfiguration);

            final AdRequest adRequest = new AdRequest.Builder()
                    //.addNetworkExtrasBundle(AdMobAdapter.class,extras)
                    .build();
            // Load ads into Interstitial Ads
            mInterstitialAd2.loadAd(adRequest);

            mInterstitialAd2.setAdListener(new AdListener()
            {
                @Override
                public void onAdLoaded() {

                }
                @Override
                public void onAdClosed()
                {
                    if (getActivity() != null)
                    {
                        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                    }

                    if (!isButtonPracticeClick)
                    {
                        loadGameActivity();
                    }
                    else
                    {
                        loadPractice();
                    }
                    mInterstitialAd2 = null;
                    loadAds();
                }
            });
        }
    }
    public void showInterstitial2() {

        if (mInterstitialAd2 != null && mInterstitialAd2.isLoaded())
        {
            mInterstitialAd2.show();
            //getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        }
        else
        {
            if (!isButtonPracticeClick)
            {

                loadGameActivity();
                if (getActivity() != null)
                {
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                }

            }
            else
            {
                loadPractice();
                if (getActivity() != null)
                {
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                }

            }
        }
    }
    private void loadAds()
    {
        if (ConsentInformation.getInstance(getActivity())
                .isRequestLocationInEeaOrUnknown())
        {
            ConsentStatus consentStatus =ConsentInformation.getInstance(getContext()).getConsentStatus();
            if (consentStatus.toString().matches("NON_PERSONALIZED"))
            {
                loadInterstitial2();
            }
            else
            {
                loadInterstitial2Personal();
            }
        }
        else
        {
            loadInterstitial2Personal();
        }
    }
    private void checkForConsent()
    {
        String[] publisherIds = {getString(R.string.publisher_id)};
        /*ConsentInformation.getInstance(getContext()).
                setDebugGeography(DebugGeography.DEBUG_GEOGRAPHY_NOT_EEA);
        ConsentInformation.getInstance(getContext()).addTestDevice("CDB7F5FFECC27E712AD992EA72C397F9");
        ConsentInformation.getInstance(getContext()).addTestDevice(AdRequest.DEVICE_ID_EMULATOR);*/
        ConsentInformation consentInformation = ConsentInformation.getInstance(getActivity());
        consentInformation.requestConsentInfoUpdate(publisherIds, new ConsentInfoUpdateListener()
        {
            @Override
            public void onConsentInfoUpdated(ConsentStatus consentStatus) {
                // User's consent status successfully updated.
                switch (consentStatus) {
                    case PERSONALIZED:

                        break;
                    case NON_PERSONALIZED:

                        break;
                    case UNKNOWN:
                        // Log.d(TAG, "Requesting Consent");
                        Log.d(TAG, "Requesting Consent");
                        if (ConsentInformation.getInstance(getActivity())
                                .isRequestLocationInEeaOrUnknown()) {
                            requestConsent();
                        }
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onFailedToUpdateConsentInfo(String errorDescription) {
                // User's consent status failed to update.
            }
        });

    }
    private void enableButtons()
    {
        mButtonPractice.setEnabled(true);
        mButtonPlayGame.setEnabled(true);
    }
    public void changeStateWithBroadCast()
    {
        if (mBroadcastReceiver != null)
        {
            if (getActivity() != null)
            {
                getActivity().unregisterReceiver(mBroadcastReceiver);
            }

            mBroadcastReceiver = null;
        }
        mBroadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context arg0, Intent intent) {
                String action = intent.getAction();
                assert action != null;
                if (action.equals("change_button_state")) {
                    enableButtons();
                    mDoNotClose = false;
                    isLoading = false;

                }
            }
        };
        if (getActivity() != null)
        {
            getActivity().registerReceiver(mBroadcastReceiver, new IntentFilter("change_button_state"));
        }

    }

    public boolean getdoNotClose()
    {
        return mDoNotClose;
    }
}
