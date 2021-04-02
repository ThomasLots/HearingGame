package kulmedslojd.hearinggame;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentFormListener;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class PracticeFragment extends Fragment /*implements MainActivity.OnBackPressedListener*/{

    private PracticeView mViewPractice;
    private boolean adFree = false;
    private String TAG = this.getClass().getSimpleName();
    private ConsentForm form;
    public static boolean mIsShowingNotes = false;
    //private InterstitialAd mInterstitialAd2;

    public PracticeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setIsShowingNotes();
        // Inflate the layout for this fragment
        View mView =inflater.inflate(R.layout.fragment_practice, container, false);
        Toolbar toolbar = mView.findViewById(R.id.my_toolbar);
        if (getActivity() != null)
        {
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getActivity() != null)
                    {
                        getActivity().onBackPressed();
                    }
                }
            });
            getActivity().setTitle(getString(R.string.practice_view));
        }
        mViewPractice = mView.findViewById(R.id.practice_view);

        /*if (getActivity() != null)
        {
            ((MainActivity)getActivity()).setOnBackPressedListener(this);
        }*/

        Intent intent = new Intent("change_button_state");
        getActivity().sendBroadcast(intent);
        return mView;
    }
    @Override
    public void  onViewCreated(@NonNull View view, Bundle savedInstanceState){
        //loadAds();
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.menu_activity, menu);//Menu Resource, Menu

        MenuItem mConsentItem = menu.findItem(R.id.consent);
        if (!ConsentInformation.getInstance(getActivity())
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
                showDialog(getString(R.string.help_info_practice), getString(R.string.help) );
                return true;

            case R.id.consent:
                requestConsent();
                return true;

            case R.id.privacy_policy:
                startWebViewActivity();
                return true;

            case R.id.change_notes:
                if(!mIsShowingNotes)
                {
                    mIsShowingNotes = true;
                }
                else
                {
                    mIsShowingNotes = false;
                }
                saveIsShowingNotes();
                mViewPractice.clearToneArray();
                mViewPractice.recycleBitmapsTones();
                mViewPractice.intBitmapTones();
                mViewPractice.invalidate();

            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }

    protected void showDialog(String message, String title)
    {
        if (getActivity() != null)
        {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            DialogOkFragment alertDialog = DialogOkFragment.newInstance(title, message, adFree);
            alertDialog.setTargetFragment(PracticeFragment.this,1);
            alertDialog.setCancelable(false);
            alertDialog.show(fm, "fragment_alert");
        }
    }

    /*@Override
    public void doBack() {
        showInterstitial2();
    }*/
    @Override
    public void onPause()
    {
        super.onPause();
        mViewPractice.onPause();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        mViewPractice.onDestroy();
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
                            showDialog(getString(R.string.adfree_message), getString(R.string.message));
                        } else {
                            Log.d(TAG, "Requesting Consent: Requesting consent again");
                            switch (consentStatus) {
                                case PERSONALIZED:
                                    break;

                                case NON_PERSONALIZED:
                                    break;

                                case UNKNOWN:
                                    if (ConsentInformation.getInstance(getContext())
                                            .isRequestLocationInEeaOrUnknown()) {
                                        requestConsent();
                                    }

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

    private void saveIsShowingNotes()
    {
        FileOutputStream fos;
        try
        {
            String fileName = "isNotes";
            if (getActivity() != null)
            {
                fos = getActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(mIsShowingNotes);
                fos.close();
                oos.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setIsShowingNotes()
    {
        FileInputStream inStream = null;
        ObjectInputStream objectInStream = null;

        try
        {
            if (getActivity() != null)
            {
                String fileName = "isNotes";
                inStream = getActivity().openFileInput(fileName);
                objectInStream = new ObjectInputStream(inStream);
                if(fileName.contentEquals(fileName) )
                {
                    mIsShowingNotes =((boolean) objectInStream.readObject());
                }
            }


        }
        catch (Exception e)
        {
        }
        finally
        {
            try
            {
                if (inStream != null)
                {
                    inStream.close();
                }
                if (objectInStream != null)
                {
                    objectInStream.close();
                }
            }
            catch(Exception e)
            {
                //Do nothing!
            }

        }
    }
    /*private void loadAds()
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
    }*/
    /*private void loadInterstitial2()
    {
        if (getActivity() != null)
        {
            mInterstitialAd2 = new InterstitialAd(getActivity());
            mInterstitialAd2.setAdUnitId(getString(R.string.interstitial_full_screen_practice_view));
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

            final AdRequest adRequest = new AdRequest.Builder()
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
                public void onAdClosed() {

                }
            });
        }

    }*/
    /*public void showInterstitial2() {
        if (mInterstitialAd2 != null && mInterstitialAd2.isLoaded()) {
            mInterstitialAd2.show();
        }
    }*/

    /*private void loadInterstitial2Personal()
    {
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
                public void onAdClosed() {

                }
            });
        }
    }*/


}
