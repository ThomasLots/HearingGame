package kulmedslojd.hearinggame;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentFormListener;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private boolean mIsHelpDialogVisible = false;
    private GameView mGameView;
    private GameActivity mGameActivity;
    private Context mContext;
    private Button mButtonPlay;
    private Button mButtonBack;
    private TextView mTextViewPoitInfo;
    private boolean mIsSelectedLevelItem = false;
    private int mSelectedItem;
    private int mAtempts = 0;
    private int mTotalAtemts = 0;
    private final String mFilename = "GameLevel";
    private int mGameLevel = 0;
    private boolean mSucceededAllLevels = false;
    private int mButtonHeight;
    private InterstitialAd mInterstitialAd2;
    private boolean mIsplaying = false;
    private int mResult = 0;
    private Timer mTimer;
    private Handler mHandler;
    private int mCounts = 0;
    private TextView mTextViewEncourageText;
    private boolean mIsDialogOkVisible = false;
    private ImageView mImageViewOkGreen;
    private ImageView mImageViewOkGreen2;
    private ImageView mImageViewGreenRight;
    private ImageView mImageViewGreenRight2;
    private ImageView mImageViewRedWrong;
    private ImageView mImageViewRedWrong2;

    public final static String HELP_DIALOG_VISIBLE = "helpDialogVisible";
    public final static String CURRENT_SOUND_PLAYING = "currentSoundPlaying";
    public final static String IS_BUTTON_PLAY_CLICKED = "isButtonPlayClicked";
    public final static String TITLE = "title";
    public final static String MESSENGER = "messenger";
    public final static String ISDIALOG_OK_VISIBLE = "IsDialogOk2Visible";
    public final static String BUTTONHEIGHT = "buttonHeight";
    public final static String GAMELEVEL_PLAYING = "gameLevel";
    public final static String ATTEMTS = "attemts";
    public final static String ISPLAING = "isplaying";
    public final static String IS_GAME_STARTED = "isGameStarted";
    public final static String PREVIOUS_NUMBER = "previousNumber";
    public final static String TOTAL_ATEMTS = "totalAttemts";

    private Animation animationGreenRight;
    private Animation animationGreenRight2;
    private String TAG = this.getClass().getSimpleName();
    private ConsentForm form;
    private boolean adFree = false;
    private boolean mIsShowingNotesGame = false;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setIsShowingNotes();

        /*if ((getResources().getConfiguration().screenLayout &
            Configuration.SCREENLAYOUT_SIZE_MASK) ==
            Configuration.SCREENLAYOUT_SIZE_SMALL || (getResources().getConfiguration().screenLayout &
            Configuration.SCREENLAYOUT_SIZE_MASK) ==
            Configuration.SCREENLAYOUT_SIZE_NORMAL)
    {
        //setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }*/
        if (savedInstanceState != null)
        {
            mIsplaying = savedInstanceState.getBoolean(ISPLAING);
            if (!mIsplaying){
                start();
            }
            else
            {
                mContext = this;
                mGameActivity = this;
                setContentView(R.layout.game_activity);
                initToolbar();
                mGameView = findViewById(R.id.game_view);
                initPlayButton();
                initButtonBack();
                mIsHelpDialogVisible = savedInstanceState.getBoolean(HELP_DIALOG_VISIBLE);
                mGameView.setmPreviusNumber(savedInstanceState.getInt(PREVIOUS_NUMBER));
                mGameView.setmIsGameStart(savedInstanceState.getBoolean(IS_GAME_STARTED));
                mGameView.setisPlayButtonClicked(savedInstanceState.getBoolean(IS_BUTTON_PLAY_CLICKED));
                mGameView.setmCurrentSoundPlaying(savedInstanceState.getString(CURRENT_SOUND_PLAYING));
                mIsDialogOkVisible = savedInstanceState.getBoolean(ISDIALOG_OK_VISIBLE);
                mTotalAtemts = savedInstanceState.getInt(TOTAL_ATEMTS);
                String mTitle;
                mTitle = savedInstanceState.getString(TITLE);
                String mMessenger;
                mMessenger = savedInstanceState.getString(MESSENGER);
                mButtonHeight = savedInstanceState.getInt(BUTTONHEIGHT);
                mAtempts = savedInstanceState.getInt(ATTEMTS);
                initPointInfoTextView();
                setText(mAtempts);

                mGameView.setGameLevel(savedInstanceState.getInt(GAMELEVEL_PLAYING));
                try
                {
                    setLevel(mFilename);
                }
                catch(Exception e)
                {
                }

                if(mGameLevel == 12)
                {
                    try
                    {
                        setSucceededAllLevels("doneAllLevels");
                    }
                    catch(Exception e)
                    {
                    }
                }
                if (mIsDialogOkVisible)
                {
                    mButtonPlay.setEnabled(false);
                    mGameView.setMessage(mMessenger);
                    mGameView.setTitle(mTitle);
                    //showOkDialog(mMessenger,mTitle);
                }
                if (mGameView.getIsplayButtonClicked())
                {
                    mButtonPlay.setEnabled(false);
                }
                if (mIsHelpDialogVisible)
                {
                    showOkDialog2(getString(R.string.help_info_game), getString(R.string.help));
                }
                if (mAtempts == 10)
                {
                    mButtonPlay.setEnabled(false);
                    mButtonBack.setEnabled(false);
                }
                mImageViewOkGreen = findViewById(R.id.imageView);
                mImageViewOkGreen2 = findViewById(R.id.imageView2);
                mImageViewGreenRight = findViewById(R.id.imageView4);
                mImageViewGreenRight2 = findViewById(R.id.imageView5);
                mImageViewRedWrong = findViewById(R.id.imageView3);
                mImageViewRedWrong2 = findViewById(R.id.imageView6);
                this.setTitle(this.getString(R.string.game_view_level) + " " + mGameView.getGameLevel());
                loadAds();
            }
        }
        else
        {
                start();
        }

    }
    public void start()
    {
        try
        {
            mButtonHeight = getIntent().getIntExtra(BUTTONHEIGHT, mButtonHeight);
        }
        catch(Exception e)
        {
            //Do nothing
        }
        setContentView(R.layout.game_activity);
        mContext = this;
        loadAds();
        initToolbar();
        mGameView = findViewById(R.id.game_view);

        initPlayButton();
        initButtonBack();
        initPointInfoTextView();
        try
        {
            setLevel(mFilename);
        }
        catch(Exception e)
        {
        }

        if(mGameLevel == 12)
        {
            try
            {
                setSucceededAllLevels("doneAllLevels");
            }
            catch(Exception e)
            {
            }
        }
        setGameLevel();
        mGameActivity = this;
        mImageViewOkGreen = findViewById(R.id.imageView);
        mImageViewOkGreen2 = findViewById(R.id.imageView2);
        mImageViewGreenRight = findViewById(R.id.imageView4);
        mImageViewGreenRight2 = findViewById(R.id.imageView5);
        mImageViewRedWrong = findViewById(R.id.imageView3);
        mImageViewRedWrong2 = findViewById(R.id.imageView6);
    }
    private void initToolbar()
    {
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void setImageViewOkGreen(final float x, final float y)
    {
        float xDifference = mImageViewOkGreen.getWidth() - mGameView.getBitmapWidth();
        float xPosition = xDifference / 2;
        float yDifference = mImageViewOkGreen.getWidth() - mGameView.getBitmapWidth();
        float yPosition = yDifference / 2;
        mImageViewOkGreen.setY(y - yPosition);
        mImageViewOkGreen.setX(x - xPosition);
        mImageViewOkGreen.setVisibility(View.VISIBLE);
        //setmButtonPlayEnabled();
    }
    public void setImageViewOkGreen2(final float x, final float y)
    {
        float xDifference = mImageViewOkGreen2.getWidth() - mGameView.getBitmapWidth();
        float xPosition = xDifference / 2;
        float yDifference = mImageViewOkGreen2.getWidth() - mGameView.getBitmapWidth();
        float yPosition = yDifference / 2;
        mImageViewOkGreen2.setY(y - yPosition / 2);
        mImageViewOkGreen2.setX(x - xPosition);
        mImageViewOkGreen2.setVisibility(View.VISIBLE);
        //setmButtonPlayEnabled();
    }
    public void setmImageViewGreenRight(final float x, final float y)
    {
        float xDifference = mImageViewGreenRight.getWidth() - mGameView.getBitmapWidth();
        float xPosition = xDifference / 2;
        float yDifference = mImageViewGreenRight.getWidth() - mGameView.getBitmapWidth();
        float yPosition = yDifference / 2;
        mImageViewGreenRight.setY(y - yPosition);
        mImageViewGreenRight.setX(x - xPosition);
        mImageViewGreenRight.setVisibility(View.VISIBLE);

        animationGreenRight = new AlphaAnimation(1, 0);
        animationGreenRight.setDuration(1000);
        animationGreenRight.setInterpolator(new LinearInterpolator());
        animationGreenRight.setRepeatCount(Animation.INFINITE);
        animationGreenRight.setRepeatMode(Animation.REVERSE);
        mImageViewGreenRight.startAnimation(animationGreenRight);
        //setmButtonPlayEnabled();
    }
    public void setmImageViewRedWrong(final float x, final float y)
    {
        float xDifference = mImageViewRedWrong.getWidth() - mGameView.getBitmapWidth();
        float xPosition = xDifference / 2;
        float yDifference = mImageViewRedWrong.getWidth() - mGameView.getBitmapWidth();
        float yPosition = yDifference / 2;
        mImageViewRedWrong.setY(y - yPosition);
        mImageViewRedWrong.setX(x - xPosition);
        mImageViewRedWrong.setVisibility(View.VISIBLE);
        //setmButtonPlayEnabled();
    }
    public void setmImageViewRedWrong2(float x, float y)
    {
        float xDifference = mImageViewRedWrong2.getWidth() - mGameView.getBitmapWidth();
        float xPosition = xDifference / 2;
        float yDifference = mImageViewRedWrong2.getWidth() - mGameView.getBitmapWidth();
        float yPosition = yDifference / 2;
        mImageViewRedWrong2.setY(y - yPosition);
        mImageViewRedWrong2.setX(x - xPosition);
        mImageViewRedWrong2.setVisibility(View.VISIBLE);
        //setmButtonPlayEnabled();
    }
    public void setmImageViewGreenRight2(final float x, final float y)
    {

        float xDifference = mImageViewGreenRight2.getWidth() - mGameView.getBitmapWidth();
        float xPosition = xDifference / 2;
        float yDifference = mImageViewGreenRight2.getWidth() - mGameView.getBitmapWidth();
        float yPosition = yDifference / 2;
        mImageViewGreenRight2.setY(y - yPosition);
        mImageViewGreenRight2.setX(x - xPosition);
        mImageViewGreenRight2.setVisibility(View.VISIBLE);

        animationGreenRight2 = new AlphaAnimation(1, 0);
        animationGreenRight2.setDuration(1000);
        animationGreenRight2.setInterpolator(new LinearInterpolator());
        animationGreenRight2.setRepeatCount(Animation.INFINITE);
        animationGreenRight2.setRepeatMode(Animation.REVERSE);
        mImageViewGreenRight2.startAnimation(animationGreenRight2);
        //setmButtonPlayEnabled();
    }
    public void initImageViews()
    {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)mGameView.getBitmapWidth() + (int)mGameView.getBitmapWidth() / 8, (int)mGameView.getBitmapHeight() + (int)mGameView.getBitmapHeight() /4);
        mImageViewGreenRight.setLayoutParams(layoutParams);
        mImageViewRedWrong.setLayoutParams(layoutParams);
        mImageViewOkGreen2.setLayoutParams(layoutParams);
        mImageViewRedWrong2.setLayoutParams(layoutParams);
        mImageViewGreenRight2.setLayoutParams(layoutParams);
        mImageViewOkGreen.setLayoutParams(layoutParams);
    }
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        outState.putBoolean(HELP_DIALOG_VISIBLE, mIsHelpDialogVisible);
        outState.putString(CURRENT_SOUND_PLAYING, mGameView.getmCurrentSoundPlaying());
        outState.putBoolean(IS_BUTTON_PLAY_CLICKED , mGameView.getIsplayButtonClicked() );
        outState.putString(TITLE,mGameView.getTitle());
        outState.putString(MESSENGER, mGameView.getMessage());
        outState.putBoolean(ISDIALOG_OK_VISIBLE, mIsDialogOkVisible);
        outState.putInt(GAMELEVEL_PLAYING, mGameView.getGameLevel());
        outState.putInt(BUTTONHEIGHT, mButtonHeight);
        outState.putInt(ATTEMTS, mAtempts);
        outState.putBoolean(ISPLAING, mIsplaying);
        outState.putBoolean(IS_GAME_STARTED, mGameView.getGameIsStarted());
        outState.putInt(PREVIOUS_NUMBER, mGameView.getPreviousNumber());
        outState.putInt(TOTAL_ATEMTS, mTotalAtemts);
        super.onSaveInstanceState(outState);
    }
    private void loadAds()
    {
        if (ConsentInformation.getInstance(this)
                .isRequestLocationInEeaOrUnknown())
        {
            ConsentStatus consentStatus =ConsentInformation.getInstance(mContext).getConsentStatus();
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

    private void loadInterstitial2()
    {

        mInterstitialAd2 = new InterstitialAd(mContext);
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
            public void onAdClosed() {
                restartGame();
            }
        });

    }
    private void loadInterstitial2Personal()
    {
        mInterstitialAd2 = new InterstitialAd(mContext);
        mInterstitialAd2.setAdUnitId(getString(R.string.interstitial_full_screen));
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

        AdRequest adRequest = new AdRequest.Builder()
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
                restartGame();
            }
        });

    }

    public void showInterstitial2() {
        if (mGameView.getSoundPool() != null)
        {
            mGameView.stopSucceedSound();
        }
        if (mInterstitialAd2 != null && mInterstitialAd2.isLoaded())
        {
            mInterstitialAd2.show();
        }
        else
        {
            restartGame();
        }
    }

    private void initPlayButton()
    {
        mButtonPlay = findViewById(R.id.play);
        mButtonPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                stopAnimationImageViews();
                makeImageViewsInvisible();
                mGameView.setisPlayButtonClicked(true);
                mButtonPlay.setEnabled(false);
                mGameView.playRandomSound();
            }
        });

    }
    public void setmButtonPlayEnabled()
    {
        mButtonPlay.setEnabled(true);
    }

    public void setButtonPlayDisable()
    {
        mButtonPlay.setEnabled(false);
    }
    public void setButtonLevelDisable()
    {
        mButtonBack.setEnabled(false);
    }

    public void setText(int atemtsLeft)
    {
        String message = Integer.toString(atemtsLeft);
        message = message + " " + "/ 10p";
        mTextViewPoitInfo.setText(message);
        mTextViewPoitInfo.setTextColor(Color.BLACK);
    }

    private void initButtonBack()
    {
        mButtonBack = findViewById(R.id.button_back);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimationImageViews();
                restartGame();
            }
        });
    }
    public void initPointInfoTextView()
    {
        mTextViewPoitInfo = findViewById(R.id.point_button);
        mTextViewPoitInfo.setBackgroundColor( Color.WHITE);
        setText(mAtempts);
    }

    private void loadMainActivity()
    {
        Intent intent = new Intent("change_button_state");
        sendBroadcast(intent);
        this.finish();

    }

    /*public void showOkDialog(final String message, final String title)
    {
        mIsDialogOkVisible = true;
        mGameView.setisPlayButtonClicked(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setIcon(R.drawable.happy_note);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mIsDialogOkVisible = false;
                mButtonPlay.setEnabled(true);
                if(mAtempts == 10)
                {
                    try
                    {
                        mGameView.stopSucceedSound();
                    }
                    catch(Exception e)
                    {
                    }
                    showInterstitial2();
                }
            }
        });
        AlertDialog mInfoDialog;
        mInfoDialog = builder.create();
        mInfoDialog.show();
        mInfoDialog.setCanceledOnTouchOutside(false);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_activity, menu);//Menu Resource, Menu
        MenuItem mConsentItem = menu.findItem(R.id.consent);
        if (!ConsentInformation.getInstance(GameActivity.this)
                .isRequestLocationInEeaOrUnknown())
        {
            mConsentItem.setVisible(false);
        }
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.help:
                showOkDialog2( getString(R.string.help_info_game), getString(R.string.help) );
                return true;

            case R.id.consent:
                requestConsent();
                return true;

            case R.id.privacy_policy:
                startWebViewActivity();
                return true;

            case R.id.change_notes:
                if (!mIsShowingNotesGame)
                {
                    mIsShowingNotesGame = true;
                    saveIsShowingNotes();
                    this.recreate();
                }
                else
                {
                    mIsShowingNotesGame = false;
                    saveIsShowingNotes();
                    this.recreate();

                }

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    public void showOkDialog2(final String message, final String title) {
        mIsHelpDialogVisible = true;

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                mIsHelpDialogVisible = false;
                if (adFree)
                {
                    mGameActivity.finishAffinity();
                }

            }

        });
        AlertDialog mInfoDialog;
        mInfoDialog = builder.create();
        mInfoDialog.show();
        mInfoDialog.setCanceledOnTouchOutside(false);
        mInfoDialog.setCancelable(false);

    }

    public void setGameLevel()
    {
        AlertDialog levelDialog;
        final CharSequence[] items = new CharSequence[13];
        if (mGameLevel == 0 || mGameLevel == 1)
        {
            items[0] = "level 1";
            items[1] = "level 2 (locked)";
            items[2] = "level 3 (locked)";
            items[3] = "level 4 (locked)";
            items[4] = "level 5 (locked)";
            items[5] = "level 6 (locked)";
            items[6] = "level 7 (locked)";
            items[7] = "level 8 (locked)";
            items[8] = "level 9 (locked)";
            items[9] = "level 10 (locked)";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 2)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2";
            items[2] = "level 3 (locked)";
            items[3] = "level 4 (locked)";
            items[4] = "level 5 (locked)";
            items[5] = "level 6 (locked)";
            items[6] = "level 7 (locked)";
            items[7] = "level 8 (locked)";
            items[8] = "level 9 (locked)";
            items[9] = "level 10 (locked)";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 3)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2 complete";
            items[2] = "level 3";
            items[3] = "level 4 (locked)";
            items[4] = "level 5 (locked)";
            items[5] = "level 6 (locked)";
            items[6] = "level 7 (locked)";
            items[7] = "level 8 (locked)";
            items[8] = "level 9 (locked)";
            items[9] = "level 10 (locked)";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 4)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2 complete";
            items[2] = "level 3 complete";
            items[3] = "level 4";
            items[4] = "level 5 (locked)";
            items[5] = "level 6 (locked)";
            items[6] = "level 7 (locked)";
            items[7] = "level 8 (locked)";
            items[8] = "level 9 (locked)";
            items[9] = "level 10 (locked)";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 5)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2 complete";
            items[2] = "level 3 complete";
            items[3] = "level 4 complete";
            items[4] = "level 5";
            items[5] = "level 6 (locked)";
            items[6] = "level 7 (locked)";
            items[7] = "level 8 (locked)";
            items[8] = "level 9 (locked)";
            items[9] = "level 10 (locked)";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 6)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2 complete";
            items[2] = "level 3 complete";
            items[3] = "level 4 complete";
            items[4] = "level 5 complete";
            items[5] = "level 6";
            items[6] = "level 7 (locked)";
            items[7] = "level 8 (locked)";
            items[8] = "level 9 (locked)";
            items[9] = "level 10 (locked)";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 7)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2 complete";
            items[2] = "level 3 complete";
            items[3] = "level 4 complete";
            items[4] = "level 5 complete";
            items[5] = "level 6 complete";
            items[6] = "level 7";
            items[7] = "level 8 (locked)";
            items[8] = "level 9 (locked)";
            items[9] = "level 10 (locked)";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 8)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2 complete";
            items[2] = "level 3 complete";
            items[3] = "level 4 complete";
            items[4] = "level 5 complete";
            items[5] = "level 6 complete";
            items[6] = "level 7 complete";
            items[7] = "level 8";
            items[8] = "level 9 (locked)";
            items[9] = "level 10 (locked)";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 9)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2 complete";
            items[2] = "level 3 complete";
            items[3] = "level 4 complete";
            items[4] = "level 5 complete";
            items[5] = "level 6 complete";
            items[6] = "level 7 complete";
            items[7] = "level 8 complete";
            items[8] = "level 9";
            items[9] = "level 10 (locked)";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 10)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2 complete";
            items[2] = "level 3 complete";
            items[3] = "level 4 complete";
            items[4] = "level 5 complete";
            items[5] = "level 6 complete";
            items[6] = "level 7 complete";
            items[7] = "level 8 complete";
            items[8] = "level 9 complete";
            items[9] = "level 10";
            items[10] = "level 11 (locked)";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 11)
        {
            items[0] = "level 1 complete";
            items[1] = "level 2 complete";
            items[2] = "level 3 complete";
            items[3] = "level 4 complete";
            items[4] = "level 5 complete";
            items[5] = "level 6 complete";
            items[6] = "level 7 complete";
            items[7] = "level 8 complete";
            items[8] = "level 9 complete";
            items[9] = "level 10 complete";
            items[10] = "level 11";
            items[11] = "level 12 (locked)";
            items[12] = "reset";
        }
        else if (mGameLevel == 12)
        {
            if(!mSucceededAllLevels)
            {
                items[0] = "level 1 complete";
                items[1] = "level 2 complete";
                items[2] = "level 3 complete";
                items[3] = "level 4 complete";
                items[4] = "level 5 complete";
                items[5] = "level 6 complete";
                items[6] = "level 7 complete";
                items[7] = "level 8 complete";
                items[8] = "level 9 complete";
                items[9] = "level 10 complete";
                items[10] = "level 11 complete";
                items[11] = "level 12";
                items[12] = "reset";
            }
            else
            {
                items[0] = "level 1 complete";
                items[1] = "level 2 complete";
                items[2] = "level 3 complete";
                items[3] = "level 4 complete";
                items[4] = "level 5 complete";
                items[5] = "level 6 complete";
                items[6] = "level 7 complete";
                items[7] = "level 8 complete";
                items[8] = "level 9 complete";
                items[9] = "level 10 complete";
                items[10] = "level 11 complete";
                items[11] = "level 12 complete";
                items[12] = "reset";
            }

        }
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Select level and press start!");

        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 0;
                        break;
                    case 1:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 1;
                        break;
                    case 2:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 2;
                        break;
                    case 3:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 3;
                        break;
                    case 4:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 4;
                        break;
                    case 5:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 5;
                        break;
                    case 6:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 6;
                        break;
                    case 7:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 7;
                        break;
                    case 8:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 8;
                        break;
                    case 9:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 9;
                        break;
                    case 10:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 10;
                        break;
                    case 11:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 11;
                        break;
                    case 12:
                        mIsSelectedLevelItem = true;
                        mSelectedItem = 12;
                        break;
                }
            }
        });

        builder.setPositiveButton(getString(R.string.start), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                if(mIsSelectedLevelItem)
                {
                    if (mSelectedItem == 0 )
                    {
                        mGameView.setGameLevel(1);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 1");
                        mIsplaying = true;

                    } else if (mSelectedItem == 1 && mGameLevel > 1) {
                        mGameView.setGameLevel(2);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) +" 2");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 2 && mGameLevel > 2) {
                        mGameView.setGameLevel(3);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 3");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 3 && mGameLevel > 3) {
                        mGameView.setGameLevel(4);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 4");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 4 && mGameLevel > 4) {
                        mGameView.setGameLevel(5);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 5");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 5 && mGameLevel > 5) {
                        mGameView.setGameLevel(6);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 6");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 6 && mGameLevel > 6) {
                        mGameView.setGameLevel(7);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 7");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 7 && mGameLevel > 7) {
                        mGameView.setGameLevel(8);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 8");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 8 && mGameLevel > 8) {
                        mGameView.setGameLevel(9);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 9");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 9 && mGameLevel > 9) {
                        mGameView.setGameLevel(10);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 10");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 10 && mGameLevel > 10) {
                        mGameView.setGameLevel(11);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 11");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 11 && mGameLevel > 11) {
                        mGameView.setGameLevel(12);
                        mGameView.invalidate();
                        mGameActivity.setTitle(getString(R.string.game_view_level) + " 12");
                        mIsplaying = true;
                    }
                    else if (mSelectedItem == 12) {

                        saveLevel(mContext, mFilename, 0);
                        saveSucceededAllLevels(mContext, "doneAllLevels", false);
                        restartGame();
                    }
                    else
                    {
                        setGameLevel();
                    }
                }
                else
                {
                    setGameLevel();
                }

            }

        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                loadMainActivity();
            }

        });
        levelDialog = builder.create();
        levelDialog.show();
        levelDialog.setCanceledOnTouchOutside(false);
        levelDialog.setCancelable(false);

    }

    public int getAtemps()
    {
        return  mAtempts;
    }
    public int getmTotalAtemts()
    {
        int extraAtemts;
        extraAtemts = mTotalAtemts - 10;
        return extraAtemts;
    }

    public void decreaseAtemps()
    {
        if (mAtempts > 0)
        {
            mAtempts = mAtempts -1;
        }

        mTotalAtemts ++;
        getEncourageMessage();
    }

    public void increaseAtempts()
    {
        mAtempts++;
        mTotalAtemts++;
        getEncourageMessage();
    }
    public void getEncourageMessage()
    {

        if (mAtempts >= mResult)
        {
            mResult = mAtempts;
        }

        int result;
        result = mResult - mAtempts;
        if (result >= 4)
        {
            mGameActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
            mTextViewEncourageText = findViewById(R.id.encourageText);
            mTextViewEncourageText.setVisibility(View.VISIBLE);
            mButtonPlay.setEnabled(false);
            mButtonBack.setEnabled(false);
            startTimerShowEncourageText();
            mResult = 0;
        }
    }
    private void startTimerShowEncourageText()
    {
        mTimer = new Timer();
        mHandler = new Handler(Looper.getMainLooper());
        mCounts = 0;
        TimerTask mTimerTask = new TimerTask()
        {
            public void run()
            {
                mHandler.post(new Runnable() {
                    @Override
                    public void run()
                    {
                        if (mCounts == 3)
                        {
                            mTimer.cancel();
                            mTimer = null;
                            mTextViewEncourageText.setVisibility(View.INVISIBLE);
                            mButtonBack.setEnabled(true);
                            mButtonPlay.setEnabled(true);
                            mGameActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                        }
                        mCounts++;
                    }
                });
            }
        }; // TimerTask
        mTimer.schedule(mTimerTask, 16, 1000); //start timer
    }

    public void saveLevel(Context context, String fileName, int level)
    {
        FileOutputStream fos;
        try
        {
            fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(level);

            fos.close();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveSucceededAllLevels(Context context, String fileName, boolean isAllLevels)
    {
        FileOutputStream fos;
        try
        {
            fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(isAllLevels);

            fos.close();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLevel(String fileName)
    {
        FileInputStream inStream = null;
        ObjectInputStream objectInStream = null;

        try
        {
            inStream = this.openFileInput(fileName);
            objectInStream = new ObjectInputStream(inStream);
            if(fileName.contentEquals(fileName) )
            {
                mGameLevel = (int) objectInStream.readObject();
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
    public void setSucceededAllLevels(String fileName)
    {
        FileInputStream inStream = null;
        ObjectInputStream objectInStream = null;

        try
        {
            inStream = this.openFileInput(fileName);
            objectInStream = new ObjectInputStream(inStream);
            if(fileName.contentEquals(fileName) )
            {
                mSucceededAllLevels = (boolean) objectInStream.readObject();
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

    public int getSavedGameLevel()
    {
        return mGameLevel;
    }

    public void restartGame()
    {
        Intent intent = new Intent(GameActivity.this, GameActivity.class);
        intent.putExtra(GameActivity.BUTTONHEIGHT, getButtonHeight());
        startActivity(intent);
        GameActivity.this.finish();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent = new Intent("change_button_state");
        sendBroadcast(intent);
        mGameView.onBackPressed();
        stopAnimationImageViews();

        //mIsBackPressed = true;
    }

    @Override
    public void onPause() {
        super.onPause();

        //mGameView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (broadcastReceiver != null)
    {
        unregisterReceiver(broadcastReceiver);
    }
        if (mImageViewGreenRight != null)
        {
            mImageViewGreenRight = null;
        }
        if (mImageViewGreenRight2 != null)
        {
            mImageViewGreenRight2 = null;
        }
        if (mImageViewOkGreen != null)
        {
            mImageViewOkGreen = null;
        }
        if (mImageViewOkGreen2 != null)
        {
            mImageViewOkGreen2 = null;
        }
        if (mImageViewRedWrong != null)
        {
            mImageViewRedWrong = null;
        }
        if (mImageViewRedWrong2 != null)
        {
            mImageViewRedWrong2 = null;
        }

        mGameView.onDestroy();
    }
    public int getButtonHeight()
    {
        return mButtonHeight;
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

    private void stopAnimationImageViews()
    {

        if (animationGreenRight != null)
        {
            mImageViewGreenRight.setAnimation(null) ;
            animationGreenRight = null;
        }
        if (animationGreenRight2 != null)
        {
            mImageViewGreenRight2.setAnimation(null);
            animationGreenRight2 = null;
        }
    }

    private void makeImageViewsInvisible()
    {
        mImageViewOkGreen.setVisibility(View.INVISIBLE);
        mImageViewOkGreen2.setVisibility(View.INVISIBLE);
        mImageViewGreenRight.setVisibility(View.INVISIBLE);
        mImageViewGreenRight2.setVisibility(View.INVISIBLE);
        mImageViewRedWrong.setVisibility(View.INVISIBLE);
        mImageViewRedWrong2.setVisibility(View.INVISIBLE);
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
        form = new ConsentForm.Builder(mContext, privacyUrl)
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
                            //ConsentInformation.getInstance(mContext).setConsentStatus(ConsentStatus.UNKNOWN);
                            showOkDialog2(getString(R.string.adfree_message), getString(R.string.message));
                        } else {
                            Log.d(TAG, "Requesting Consent: Requesting consent again");
                            switch (consentStatus) {
                                case PERSONALIZED:
                                    if (mInterstitialAd2 != null)
                                    {
                                        mInterstitialAd2 = null;
                                    }
                                    loadInterstitial2Personal();
                                    break;

                                case NON_PERSONALIZED:
                                    if (mInterstitialAd2 != null)
                                    {
                                        mInterstitialAd2 = null;
                                    }
                                    loadInterstitial2();

                                    break;
                                case UNKNOWN:
                                    if (ConsentInformation.getInstance(GameActivity.this)
                                            .isRequestLocationInEeaOrUnknown()) {
                                        requestConsent();
                                    }
                                    else
                                    {
                                        if (mInterstitialAd2 != null)
                                        {
                                            mInterstitialAd2 = null;
                                        }
                                        loadInterstitial2Personal();
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
    private void startWebViewActivity()
    {
        Intent intent = new Intent(GameActivity.this, WebViewActivity.class);
        startActivity(intent);
    }

    public boolean getmIsShowingNotesGame()
    {
        return mIsShowingNotesGame;
    }
    private void saveIsShowingNotes()
    {
        FileOutputStream fos;
        try
        {
            String fileName = "isNotesGame";
            fos = this.openFileOutput(fileName, Context.MODE_PRIVATE);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mIsShowingNotesGame);

            fos.close();
            oos.close();

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
            String fileName = "isNotesGame";
            inStream = this.openFileInput(fileName);
            objectInStream = new ObjectInputStream(inStream);
            if(fileName.contentEquals(fileName) )
            {
                mIsShowingNotesGame =((boolean) objectInStream.readObject());
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
    public void changeStateWithBroadCast()
    {
        broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context arg0, Intent intent) {
                String action = intent.getAction();
                assert action != null;
                if (action.equals("show_interstitial")) {
                    mGameActivity.showInterstitial2();
                    // DO WHATEVER YOU WANT.
                }
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("show_interstitial"));
    }

}

