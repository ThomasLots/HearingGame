package kulmedslojd.hearinggame;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Thomas on 2016-02-06.
 */
public class GameView extends View
{

    private float mScreenWidth;
    private GameActivity mGameActivity;
    private Context mContext;
    private final int HEIGHT_COSTANT = 16;
    private final int WIDTH_COSTANT = 6;
    private final int ROWS = 8;
    private float mWidth;
    private float mHeight;
    private int mGameLevel = 0;
    private int mGameLevelRotation = 0;
    private Bitmap mBitmapNeck;
    private int mPreviusNumber;
    private boolean mIsGameStart = true;
    private String mMessage = "";
    private String mTitle = "";
    private Timer mTimer;
    private TimerTask mTimerTask;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public static List<Sprite> mSpriteList = new ArrayList<>();

    //String G
    private Bitmap mBitmapToneG;
    private Bitmap mBitmapToneGHigh;
    private Bitmap mBitmapToneA;
    private Bitmap mBitmapToneAHigh;
    private Bitmap mBitmapToneB;
    private Bitmap mBitmapToneC1;
    private Bitmap mBitmapToneC1High;
    private Bitmap mBitmapToneD1GString;

    //String D
    private Bitmap mBitmapToneD1;
    private Bitmap mBitmapToneD1High;
    private Bitmap mBitmapToneE1;
    private Bitmap mBitmapToneF1;
    private Bitmap mBitmapToneF1High;
    private Bitmap mBitmapToneG1;
    private Bitmap mBitmapToneG1High;
    private Bitmap mBitmapToneA1DString;

    //String A
    private Bitmap mBitmapToneA1;
    private Bitmap mBitmapToneA1High;
    private Bitmap mBitmapToneB1;
    private Bitmap mBitmapToneC2;
    private Bitmap mBitmapToneC2High;
    private Bitmap mBitmapToneD2;
    private Bitmap mBitmapToneD2High;
    private Bitmap mBitmapToneE2AString;

    //String E
    private Bitmap mBitmapToneE2;
    private Bitmap mBitmapToneF2;
    private Bitmap mBitmapToneF2High;
    private Bitmap mBitmapToneG2;
    private Bitmap mBitmapToneG2High;
    private Bitmap mBitmapToneA2;
    private Bitmap mBitmapToneA2High;
    private Bitmap mBitmapToneB2;

    //Strings
    //G string
    private Bitmap mBitmapGStringG;
    private Bitmap mBitmapGStringA;
    private Bitmap mBitmapGStringGHigh;
    private Bitmap mBitmapGStringAHigh;
    private Bitmap mBitmapGStringB;
    private Bitmap mBitmapGStringC1;
    private Bitmap mBitmapGStringC1High;
    private Bitmap mBitmapGStringD1;

    // D string
    private Bitmap mBitmapDStringD1;
    private Bitmap mBitmapDStringD1High;
    private Bitmap mBitmapDStringE1;
    private Bitmap mBitmapDStringF1;
    private Bitmap mBitmapDStringF1High;
    private Bitmap mBitmapDStringG1;
    private Bitmap mBitmapDStringG1High;
    private Bitmap mBitmapDStringA1;

    //A string
    private Bitmap mBitmapAStringA1;
    private Bitmap mBitmapAStringA1High;
    private Bitmap mBitmapAStringB1;
    private Bitmap mBitmapAStringC2;
    private Bitmap mBitmapAStringC2High;
    private Bitmap mBitmapAStringD2;
    private Bitmap mBitmapAStringD2High;
    private Bitmap mBitmapAStringE2;

    //E string
    private Bitmap mBitmapEStringE2;
    private Bitmap mBitmapEStringF2;
    private Bitmap mBitmapEStringF2High;
    private Bitmap mBitmapEStringG2;
    private Bitmap mBitmapEStringG2High;
    private Bitmap mBitmapEStringA2;
    private Bitmap mBitmapEStringA2High;
    private Bitmap mBitmapEStringB2;

    private SoundPool mSoundPool;
    private int mSoundG1;
    private int mSoundA1;
    private int mSoundH1;
    private int mSoundC1;
    private int mSoundD1;
    private int mSoundE1;
    private int mSoundF1;
    private int mSoundF1High;
    private int mSoundG2;
    private int mSoundA2;
    private int mSoundH2;
    private int mSoundC2;
    private int mSoundC2High;
    private int mSoundD2;
    private int mSoundE2;
    private int mSoundF2;
    private int mSoundF2High;
    private int mSoundG3;
    private int mSoundG3High;
    private int mSoundA3;
    private int mSoundH3;
    private int mSoundG1High;
    private int mSoundA1High;
    private int mSoundC1High;
    private int mSoundD1High;
    private int mSoundG2High;
    private int mSoundA2High;
    private int mSoundD2High;
    private int mSoundA3High;
    private int mSoundSucceeded;
    private List<Tone> mTones = new ArrayList<>();
    private List<SubTone> mSubTones = new ArrayList<>();

    private int mStreamIdG1;
    private boolean mIsG1Clicked = false;

    private int mStreamIdA1;
    private boolean mIsA1Clicked = false;

    private int mStreamIdH1;
    private boolean mIsH1Clicked = false;

    private int mStreamIdC1;
    private boolean mIsC1Clicked = false;

    private int mStreamIdD1;
    private boolean mIsD1Clicked = false;

    private int mStreamIdE1;
    private boolean mIsE1Clicked = false;

    private int mStreamIdF1;
    private boolean mIsF1Clicked = false;

    private int mStreamIdF1High;
    private boolean mIsF1HighClicked = false;

    private int mStreamIdG2;
    private boolean mIsG2Clicked = false;

    private int mStreamIdA2;
    private boolean mIsA2Clicked = false;

    private int mStreamIdH2;
    private boolean mIsH2Clicked = false;

    private int mStreamIdC2;
    private boolean mIsC2Clicked = false;

    private int mStreamIdC2High;
    private boolean mIsC2HighClicked = false;

    private int mStreamIdD2;
    private boolean mIsD2Clicked = false;

    private int mStreamIdE2;
    private boolean mIsE2Clicked = false;

    private int mStreamIdF2;
    private boolean mIsF2Clicked = false;

    private int mStreamIdF2High;
    private boolean mIsF2HighClicked = false;

    private int mStreamIdG3;
    private boolean mIsG3Clicked = false;

    private int mStreamIdG3High;
    private boolean mIsG3HighClicked = false;

    private int mStreamIdA3;
    private boolean mIsA3Clicked = false;

    private int mStreamIdH3;
    private boolean mIsH3Clicked = false;

    private int mStreamIdG1High;
    private boolean mIsG1HighClicked = false;

    private int mStreamIdA1High;
    private boolean mIsA1HighClicked = false;

    private int mStreamIdC1High;
    private boolean mIsC1HighClicked = false;

    private int mStreamIdD1High;
    private boolean mIsD1HighClicked = false;

    private int mStreamIdG2High;
    private boolean mIsG2HighClicked = false;

    private int mStreamIdA2High;
    private boolean mIsA2HighClicked = false;

    private int mStreamIdD2High;
    private boolean mIsD2HighClicked = false;

    private int mStreamIdA3High;
    private boolean mIsA3HighClicked = false;

    private int mIdSucceedSound;

    private  Integer[] mSounds;
    private String[] mSoundIdList;
    private String mCurrentSoundPlaying = "";
    private boolean mIsPlayClicked = false;
    private int mCurrentSoundId;

    public GameView(Context context, AttributeSet attrib)
    {
        super(context, attrib);
        mGameActivity = (GameActivity)context;
        mContext = context;
        initSoundPool();
    }

    private void initBimapNeck()
    {
        if (mBitmapNeck != null)
        {
            mBitmapNeck.recycle();
        }
        mBitmapNeck = BitmapFactory.decodeResource(getResources(), R.drawable.greppbrada_stor);
        mBitmapNeck = Bitmap.createScaledBitmap(mBitmapNeck, (int)mWidth , (int)mHeight, true);
        int mButtonHeight;
        if (mGameActivity.getOrientation() == 2){
            mButtonHeight = mGameActivity.getButtonHeight();
            mHeight = mBitmapNeck.getHeight()- mButtonHeight ;
        }
        else
        {
            mHeight = mBitmapNeck.getHeight();
        }
    }
    private void initBitmapLevel1()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.g), (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.x), (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.x), (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));

            mBitmapToneAHigh = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.x), (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.x), (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.x), (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.x),(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.d1), (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.d1), (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.x), (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.x), (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
        else
        {

            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
    }
    private void initBitmapLevel2()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
    }
    private void initBitmapLevel3()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
    }

    private void initBitmapLevel4()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }

    }
    private void initBitmapLevel5()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);


            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);


            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }

    }
    private void initBitmapLevel6()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString((int)mHeight / ROWS + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString((int)mHeight / ROWS + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }

    }
    private void initBitmapLevel7()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString((int)mHeight / ROWS + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneAHigh,  getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.note_h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString((int)mHeight / ROWS + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }


    }
    private void initBitmapLevel8()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);


            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString((int)mHeight / ROWS + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.note_h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);


            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString((int)mHeight / ROWS + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }

    }
    private void initBitmapLevel9()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));
            mBitmapGStringC1High = getSpriteBitmapGString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);


            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));
            mBitmapAStringC2High = getSpriteBitmapAString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString((int)mHeight / ROWS + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.note_h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));
            mBitmapGStringC1High = getSpriteBitmapGString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);


            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));
            mBitmapAStringC2High = getSpriteBitmapAString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString((int)mHeight / ROWS + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }

    }
    private void initBitmapLevel10()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.g_high);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));
            mBitmapGStringGHigh = getSpriteBitmapGString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));
            mBitmapGStringC1High = getSpriteBitmapGString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.g1_high);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));
            mBitmapDStringG1High = getSpriteBitmapDString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));
            mBitmapAStringC2High = getSpriteBitmapAString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString((int)mHeight / ROWS + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.g2_high);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));
            mBitmapEStringG2High = getSpriteBitmapEString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_g_high);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));
            mBitmapGStringGHigh = getSpriteBitmapGString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.note_h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));
            mBitmapGStringC1High = getSpriteBitmapGString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1_high);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));
            mBitmapDStringG1High = getSpriteBitmapDString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));
            mBitmapAStringC2High = getSpriteBitmapAString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2_high);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));
            mBitmapEStringG2High = getSpriteBitmapEString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }
    }
    private void initBitmapLevel11()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.g_high);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));
            mBitmapGStringGHigh = getSpriteBitmapGString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));
            mBitmapGStringC1High = getSpriteBitmapGString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.d1_high);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));
            mBitmapDStringD1High = getSpriteBitmapDString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.g1_high);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));
            mBitmapDStringG1High = getSpriteBitmapDString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));
            mBitmapAStringC2High = getSpriteBitmapAString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.d2_high);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));
            mBitmapAStringD2High = getSpriteBitmapAString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.g2_high);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));
            mBitmapEStringG2High = getSpriteBitmapEString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_g_high);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));
            mBitmapGStringGHigh = getSpriteBitmapGString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.note_h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));
            mBitmapGStringC1High = getSpriteBitmapGString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1_high);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));
            mBitmapDStringD1High = getSpriteBitmapDString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1_high);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));
            mBitmapDStringG1High = getSpriteBitmapDString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));
            mBitmapAStringC2High = getSpriteBitmapAString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2_high);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));
            mBitmapAStringD2High = getSpriteBitmapAString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.x);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mSubTones.add(new SubTone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2_high);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));
            mBitmapEStringG2High = getSpriteBitmapEString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }
    }
    private void initBitmapLevel12()
    {
        if (!mGameActivity.getmIsShowingNotesGame())
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.g_high);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));
            mBitmapGStringGHigh = getSpriteBitmapGString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));
            mBitmapGStringC1High = getSpriteBitmapGString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.d1_high);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));
            mBitmapDStringD1High = getSpriteBitmapDString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.f1_high);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));
            mBitmapDStringF1High = getSpriteBitmapDString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.g1_high);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));
            mBitmapDStringG1High = getSpriteBitmapDString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));
            mBitmapAStringC2High = getSpriteBitmapAString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.d2_high);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));
            mBitmapAStringD2High = getSpriteBitmapAString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.f2_high);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));
            mBitmapEStringF2High = getSpriteBitmapEString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.g2_high);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));
            mBitmapEStringG2High = getSpriteBitmapEString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }
        else
        {
            float constant = mHeight / 16 /2;
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));
            mBitmapGStringG = getSpriteBitmapGString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_g_high);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));
            mBitmapGStringGHigh = getSpriteBitmapGString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));
            mBitmapGStringA = getSpriteBitmapGString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));
            mBitmapGStringAHigh = getSpriteBitmapGString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.note_h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));
            mBitmapGStringB = getSpriteBitmapGString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f , mHeight / ROWS * 5 + constant, "C1"));
            mBitmapGStringC1 = getSpriteBitmapGString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High,(int) mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));
            mBitmapGStringC1High = getSpriteBitmapGString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int)mWidth / WIDTH_COSTANT, (int)mHeight/ HEIGHT_COSTANT, true);
            mTones.add(new Tone( mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));
            mBitmapGStringD1 = getSpriteBitmapGString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));
            mBitmapDStringD1 = getSpriteBitmapDString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1_high);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));
            mBitmapDStringD1High = getSpriteBitmapDString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));
            mBitmapDStringE1 = getSpriteBitmapDString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));
            mBitmapDStringF1 = getSpriteBitmapDString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1_high);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));
            mBitmapDStringF1High = getSpriteBitmapDString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));
            mBitmapDStringG1 = getSpriteBitmapDString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1_high);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));
            mBitmapDStringG1High = getSpriteBitmapDString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));
            mBitmapDStringA1 = getSpriteBitmapDString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));
            mBitmapAStringA1 = getSpriteBitmapAString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));
            mBitmapAStringA1High = getSpriteBitmapAString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));
            mBitmapAStringB1 = getSpriteBitmapAString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));
            mBitmapAStringC2 = getSpriteBitmapAString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));
            mBitmapAStringC2High = getSpriteBitmapAString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));
            mBitmapAStringD2 = getSpriteBitmapAString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2_high);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));
            mBitmapAStringD2High = getSpriteBitmapAString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));
            mBitmapAStringE2 = getSpriteBitmapAString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));
            mBitmapEStringE2 = getSpriteBitmapEString((int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));
            mBitmapEStringF2 = getSpriteBitmapEString(((int)mHeight / ROWS + (int)constant) + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2_high);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));
            mBitmapEStringF2High = getSpriteBitmapEString((int)mHeight / ROWS * 2 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));
            mBitmapEStringG2 = getSpriteBitmapEString((int)mHeight / ROWS * 3 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2_high);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));
            mBitmapEStringG2High = getSpriteBitmapEString((int)mHeight / ROWS * 4 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));
            mBitmapEStringA2 = getSpriteBitmapEString((int)mHeight / ROWS * 5 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));
            mBitmapEStringA2High = getSpriteBitmapEString((int)mHeight / ROWS * 6 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int)mWidth / WIDTH_COSTANT, (int)mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
            mBitmapEStringB2 = getSpriteBitmapEString((int)mHeight / ROWS * 7 + (int)constant + (int)mHeight/ HEIGHT_COSTANT);
        }
    }
    private void drawNeck(Canvas canvas)
    {
        canvas.drawBitmap(mBitmapNeck, getXposition(), 0, null);
    }

    private void drawNotes(Canvas canvas)
    {
        if(mTones.size() > 0)
        {
            for(int i = 0; i < mTones.size(); i++)
            {
                mTones.get(i).drawNote(canvas);
            }
        }
    }
    private void drawSubNotes( Canvas canvas)
    {
        if(mTones.size() > 0)
        {
            for(int i = 0; i < mSubTones.size(); i++)
            {
                mSubTones.get(i).drawNote(canvas);
            }
        }
    }
    private void drawSprite(Canvas canvas)
    {
        if (mSpriteList.size() > 0)
        {
            for (int i = 0; i < mSpriteList.size(); i++)
            {
                mSpriteList.get(i).drawSpriteGameView(canvas);
            }
        }
    }

    public void updateSound()
    {
        setSoundArray();
        setSoundIdList();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        mScreenWidth = getWidth();

        if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE || (getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_XLARGE)
        {
            if (mGameActivity.getOrientation() == 2)
            {
                mWidth = mScreenWidth / 1.3f;
            }
            else
            {
                mWidth = mScreenWidth / 2;
            }
        }
        else
        {
            if (mGameActivity.getOrientation() == 2)
            {
                mWidth = getWidth();
            }
            else
            {
                mWidth = mScreenWidth / 2;
            }

        }
        mHeight = getHeight();
        if (mGameLevel == 0)
        {
            try {
                initBimapNeck();
            }catch (Exception e)
            {

            }
            if (mBitmapNeck != null)
            {
                drawNeck(canvas);
            }
        }
        if (mGameLevel == 1)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel1();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 2)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel2();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 3)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel3();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if(mGameLevel == 4)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel4();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 5)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel5();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 6)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel6();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 7)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel7();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 8)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel8();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 9)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel9();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 10)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel10();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 11)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel11();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }
        else if (mGameLevel == 12)
        {
            if (mBitmapToneG == null)
            {
                initBimapNeck();
                initBitmapLevel12();
                updateSound();
                mGameActivity.initImageViews();
            }
            drawNeck(canvas);
            drawSprite(canvas);
            drawNotes(canvas);
            drawSubNotes(canvas);
        }

    }
    private void initSoundPool()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            AudioAttributes audioAttributes;
            audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME).build();

            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .setAudioAttributes(audioAttributes)
                    .build();

            mSoundG1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g1, 1);
            mSoundA1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.a1, 1);
            mSoundH1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.h1, 1);
            mSoundC1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.c1, 1);
            mSoundD1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.d1, 1);
            mSoundE1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.e1, 1);
            mSoundF1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.f1, 1);
            mSoundF1High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.f1_high_g2_low, 1);
            mSoundG2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g2, 1);
            mSoundA2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.a2, 1);
            mSoundH2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.h2, 1);
            mSoundC2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.c2, 1);
            mSoundC2High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.c2_high_d2_low, 1);
            mSoundD2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.d2, 1);
            mSoundE2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.e2, 1);
            mSoundF2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.f2, 1);
            mSoundF2High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.f2_high_g3_low, 1);
            mSoundG3 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g3, 1);
            mSoundG3High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g3_high_a3_low, 1);
            mSoundA3 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.a3, 1);
            mSoundH3 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.h3, 1);
            mSoundG1High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g1_high_a1_low, 1);
            mSoundA1High = mSoundPool.load(mGameActivity.getApplicationContext(),R.raw.a1_high_h1_low, 1);
            mSoundC1High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.c1_high_d1_low, 1);
            mSoundD1High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.d1_high_e1_low, 1);
            mSoundG2High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g2_high_a2_low, 1);
            mSoundA2High = mSoundPool.load(mGameActivity.getApplicationContext(),R.raw.a2_high_h2_low, 1);
            mSoundD2High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.d2_high_e2_low, 1);
            mSoundA3High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.a3_high_h3_low, 1);
            mSoundSucceeded = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.succeed_tune, 1);
        }
        else
        {
            mSoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
            mSoundG1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g1,1);
            mSoundA1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.a1, 1);
            mSoundH1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.h1, 1);
            mSoundC1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.c1, 1);
            mSoundD1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.d1, 1);
            mSoundE1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.e1, 1);
            mSoundF1 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.f1, 1);
            mSoundF1High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.f1_high_g2_low, 1);
            mSoundG2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g2, 1);
            mSoundA2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.a2, 1);
            mSoundH2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.h2, 1);
            mSoundC2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.c2, 1);
            mSoundC2High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.c2_high_d2_low, 1);
            mSoundD2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.d2, 1);
            mSoundE2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.e2, 1);
            mSoundF2 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.f2, 1);
            mSoundF2High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.f2_high_g3_low, 1);
            mSoundG3 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g3, 1);
            mSoundG3High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g3_high_a3_low, 1);
            mSoundA3 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.a3, 1);
            mSoundH3 = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.h3, 1);
            mSoundG1High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g1_high_a1_low, 1);
            mSoundA1High = mSoundPool.load(mGameActivity.getApplicationContext(),R.raw.a1_high_h1_low, 1);
            mSoundC1High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.c1_high_d1_low, 1);
            mSoundD1High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.d1_high_e1_low, 1);
            mSoundG2High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.g2_high_a2_low, 1);
            mSoundA2High = mSoundPool.load(mGameActivity.getApplicationContext(),R.raw.a2_high_h2_low, 1);
            mSoundD2High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.d2_high_e2_low, 1);
            mSoundA3High = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.a3_high_h3_low, 1);
            mSoundSucceeded = mSoundPool.load(mGameActivity.getApplicationContext(), R.raw.succeed_tune, 1);
        }
    }

    public void setSoundArray()
    {
        if(mGameLevel == 1)
        {
            mSounds = new Integer[4];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
        }
        else if (mGameLevel == 2)
        {
            mSounds = new Integer[6];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
        }
        else if(mGameLevel == 3)
        {
            mSounds = new Integer[8];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
            mSounds[6] = mSoundG2;
            mSounds[7] = mSoundG3;

        }
        else if (mGameLevel == 4)
        {
            mSounds = new Integer[10];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
            mSounds[6] = mSoundG2;
            mSounds[7] = mSoundG3;
            mSounds[8] = mSoundE1;
            mSounds[9] = mSoundD2;
        }
        else if (mGameLevel == 5)
        {
            mSounds = new Integer[12];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
            mSounds[6] = mSoundG2;
            mSounds[7] = mSoundG3;
            mSounds[8] = mSoundE1;
            mSounds[9] = mSoundD2;
            mSounds[10] = mSoundC1;
            mSounds[11] = mSoundC2;
        }
        else if (mGameLevel == 6)
        {
            mSounds = new Integer[14];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
            mSounds[6] = mSoundG2;
            mSounds[7] = mSoundG3;
            mSounds[8] = mSoundE1;
            mSounds[9] = mSoundD2;
            mSounds[10] = mSoundC1;
            mSounds[11] = mSoundC2;
            mSounds[12] = mSoundF1;
            mSounds[13] = mSoundF2;
        }
        else if (mGameLevel == 7)
        {
            mSounds = new Integer[17];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
            mSounds[6] = mSoundG2;
            mSounds[7] = mSoundG3;
            mSounds[8] = mSoundE1;
            mSounds[9] = mSoundD2;
            mSounds[10] = mSoundC1;
            mSounds[11] = mSoundC2;
            mSounds[12] = mSoundF1;
            mSounds[13] = mSoundF2;
            mSounds[14] = mSoundH1;
            mSounds[15] = mSoundH2;
            mSounds[16] = mSoundH3;
        }
        else if (mGameLevel == 8)
        {
            mSounds = new Integer[20];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
            mSounds[6] = mSoundG2;
            mSounds[7] = mSoundG3;
            mSounds[8] = mSoundE1;
            mSounds[9] = mSoundD2;
            mSounds[10] = mSoundC1;
            mSounds[11] = mSoundC2;
            mSounds[12] = mSoundF1;
            mSounds[13] = mSoundF2;
            mSounds[14] = mSoundH1;
            mSounds[15] = mSoundH2;
            mSounds[16] = mSoundH3;
            mSounds[17] = mSoundA1High;
            mSounds[18] = mSoundA2High;
            mSounds[19] = mSoundA3High;
        }

        else if (mGameLevel == 9)
        {
            mSounds = new Integer[22];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
            mSounds[6] = mSoundG2;
            mSounds[7] = mSoundG3;
            mSounds[8] = mSoundE1;
            mSounds[9] = mSoundD2;
            mSounds[10] = mSoundC1;
            mSounds[11] = mSoundC2;
            mSounds[12] = mSoundF1;
            mSounds[13] = mSoundF2;
            mSounds[14] = mSoundH1;
            mSounds[15] = mSoundH2;
            mSounds[16] = mSoundH3;
            mSounds[17] = mSoundA1High;
            mSounds[18] = mSoundA2High;
            mSounds[19] = mSoundA3High;
            mSounds[20] = mSoundC1High;
            mSounds[21] = mSoundC2High;

        }
        else if(mGameLevel == 10)
        {
            mSounds = new Integer[25];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
            mSounds[6] = mSoundG2;
            mSounds[7] = mSoundG3;
            mSounds[8] = mSoundE1;
            mSounds[9] = mSoundD2;
            mSounds[10] = mSoundC1;
            mSounds[11] = mSoundC2;
            mSounds[12] = mSoundF1;
            mSounds[13] = mSoundF2;
            mSounds[14] = mSoundH1;
            mSounds[15] = mSoundH2;
            mSounds[16] = mSoundH3;
            mSounds[17] = mSoundA1High;
            mSounds[18] = mSoundA2High;
            mSounds[19] = mSoundA3High;
            mSounds[20] = mSoundC1High;
            mSounds[21] = mSoundC2High;
            mSounds[22] = mSoundG1High;
            mSounds[23] = mSoundG2High;
            mSounds[24] = mSoundG3High;
        }
        else if(mGameLevel == 11)
        {
            mSounds = new Integer[27];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundD1;
            mSounds[2] = mSoundA2;
            mSounds[3] = mSoundE2;
            mSounds[4] = mSoundA3;
            mSounds[5] = mSoundA1;
            mSounds[6] = mSoundG2;
            mSounds[7] = mSoundG3;
            mSounds[8] = mSoundE1;
            mSounds[9] = mSoundD2;
            mSounds[10] = mSoundC1;
            mSounds[11] = mSoundC2;
            mSounds[12] = mSoundF1;
            mSounds[13] = mSoundF2;
            mSounds[14] = mSoundH1;
            mSounds[15] = mSoundH2;
            mSounds[16] = mSoundH3;
            mSounds[17] = mSoundA1High;
            mSounds[18] = mSoundA2High;
            mSounds[19] = mSoundA3High;
            mSounds[20] = mSoundC1High;
            mSounds[21] = mSoundC2High;
            mSounds[22] = mSoundG1High;
            mSounds[23] = mSoundG2High;
            mSounds[24] = mSoundG3High;
            mSounds[25] = mSoundD1High;
            mSounds[26] = mSoundD2High;
        }
        else if (mGameLevel == 12) {

            mSounds = new Integer[29];
            mSounds[0] = mSoundG1;
            mSounds[1] = mSoundA1;
            mSounds[2] = mSoundH1;
            mSounds[3] = mSoundC1;
            mSounds[4] = mSoundD1;
            mSounds[5] = mSoundE1;
            mSounds[6] = mSoundF1;
            mSounds[7] = mSoundF1High;
            mSounds[8] = mSoundG2;
            mSounds[9] = mSoundA2;
            mSounds[10] = mSoundH2;
            mSounds[11] = mSoundC2;
            mSounds[12] = mSoundC2High;
            mSounds[13] = mSoundD2;
            mSounds[14] = mSoundE2;
            mSounds[15] = mSoundF2;
            mSounds[16] = mSoundF2High;
            mSounds[17] = mSoundG3;
            mSounds[18] = mSoundG3High;
            mSounds[19] = mSoundA3;
            mSounds[20] = mSoundH3;
            mSounds[21] = mSoundG1High;
            mSounds[22] = mSoundA1High;
            mSounds[23] = mSoundC1High;
            mSounds[24] = mSoundD1High;
            mSounds[25] = mSoundG2High;
            mSounds[26] = mSoundA2High;
            mSounds[27] = mSoundD2High;
            mSounds[28] = mSoundA3High;
        }
    }

    public void setSoundIdList()
    {
        if (mGameLevel == 1)
        {
            mSoundIdList = new String[4];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
        }
        else if (mGameLevel == 2)
        {
            mSoundIdList = new String[6];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
        }
        else if(mGameLevel == 3)
        {
            mSoundIdList = new String[8];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
            mSoundIdList[6] = "G1";
            mSoundIdList[7] = "G2";
        }
        else if(mGameLevel == 4)
        {
            mSoundIdList = new String[10];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
            mSoundIdList[6] = "G1";
            mSoundIdList[7] = "G2";
            mSoundIdList[8] = "E1";
            mSoundIdList[9] = "D2";
        }
        else if (mGameLevel == 5)
        {
            mSoundIdList = new String[12];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
            mSoundIdList[6] = "G1";
            mSoundIdList[7] = "G2";
            mSoundIdList[8] = "E1";
            mSoundIdList[9] = "D2";
            mSoundIdList[10] = "C1";
            mSoundIdList[11] = "C2";
        }
        else if (mGameLevel == 6)
        {
            mSoundIdList = new String[14];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
            mSoundIdList[6] = "G1";
            mSoundIdList[7] = "G2";
            mSoundIdList[8] = "E1";
            mSoundIdList[9] = "D2";
            mSoundIdList[10] = "C1";
            mSoundIdList[11] = "C2";
            mSoundIdList[12] = "F1";
            mSoundIdList[13] = "F2";
        }
        else if (mGameLevel == 7)
        {
            mSoundIdList = new String[17];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
            mSoundIdList[6] = "G1";
            mSoundIdList[7] = "G2";
            mSoundIdList[8] = "E1";
            mSoundIdList[9] = "D2";
            mSoundIdList[10] = "C1";
            mSoundIdList[11] = "C2";
            mSoundIdList[12] = "F1";
            mSoundIdList[13] = "F2";
            mSoundIdList[14] = "B";
            mSoundIdList[15] = "B1";
            mSoundIdList[16] = "B2";
        }
        else if (mGameLevel == 8)
        {
            mSoundIdList = new String[20];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
            mSoundIdList[6] = "G1";
            mSoundIdList[7] = "G2";
            mSoundIdList[8] = "E1";
            mSoundIdList[9] = "D2";
            mSoundIdList[10] = "C1";
            mSoundIdList[11] = "C2";
            mSoundIdList[12] = "F1";
            mSoundIdList[13] = "F2";
            mSoundIdList[14] = "B";
            mSoundIdList[15] = "B1";
            mSoundIdList[16] = "B2";
            mSoundIdList[17] = "A#";
            mSoundIdList[18] = "A1#";
            mSoundIdList[19] = "A2#";
        }
        else if (mGameLevel == 9)
        {
            mSoundIdList = new String[22];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
            mSoundIdList[6] = "G1";
            mSoundIdList[7] = "G2";
            mSoundIdList[8] = "E1";
            mSoundIdList[9] = "D2";
            mSoundIdList[10] = "C1";
            mSoundIdList[11] = "C2";
            mSoundIdList[12] = "F1";
            mSoundIdList[13] = "F2";
            mSoundIdList[14] = "B";
            mSoundIdList[15] = "B1";
            mSoundIdList[16] = "B2";
            mSoundIdList[17] = "A#";
            mSoundIdList[18] = "A1#";
            mSoundIdList[19] = "A2#";
            mSoundIdList[20] = "C1#";
            mSoundIdList[21] = "C2#";
        }
        else if (mGameLevel == 10)
        {
            mSoundIdList = new String[25];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
            mSoundIdList[6] = "G1";
            mSoundIdList[7] = "G2";
            mSoundIdList[8] = "E1";
            mSoundIdList[9] = "D2";
            mSoundIdList[10] = "C1";
            mSoundIdList[11] = "C2";
            mSoundIdList[12] = "F1";
            mSoundIdList[13] = "F2";
            mSoundIdList[14] = "B";
            mSoundIdList[15] = "B1";
            mSoundIdList[16] = "B2";
            mSoundIdList[17] = "A#";
            mSoundIdList[18] = "A1#";
            mSoundIdList[19] = "A2#";
            mSoundIdList[20] = "C1#";
            mSoundIdList[21] = "C2#";
            mSoundIdList[22] = "G#";
            mSoundIdList[23] = "G1#";
            mSoundIdList[24] = "G2#";
        }
        else if (mGameLevel == 11)
        {
            mSoundIdList = new String[27];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "D1";
            mSoundIdList[2] = "A1";
            mSoundIdList[3] = "E2";
            mSoundIdList[4] = "A2";
            mSoundIdList[5] = "A";
            mSoundIdList[6] = "G1";
            mSoundIdList[7] = "G2";
            mSoundIdList[8] = "E1";
            mSoundIdList[9] = "D2";
            mSoundIdList[10] = "C1";
            mSoundIdList[11] = "C2";
            mSoundIdList[12] = "F1";
            mSoundIdList[13] = "F2";
            mSoundIdList[14] = "B";
            mSoundIdList[15] = "B1";
            mSoundIdList[16] = "B2";
            mSoundIdList[17] = "A#";
            mSoundIdList[18] = "A1#";
            mSoundIdList[19] = "A2#";
            mSoundIdList[20] = "C1#";
            mSoundIdList[21] = "C2#";
            mSoundIdList[22] = "G#";
            mSoundIdList[23] = "G1#";
            mSoundIdList[24] = "G2#";
            mSoundIdList[25] = "D1#";
            mSoundIdList[26] = "D2#";
        }
        else if (mGameLevel == 12)
        {
            mSoundIdList = new String[29];
            mSoundIdList[0] = "G";
            mSoundIdList[1] = "A";
            mSoundIdList[2] = "B";
            mSoundIdList[3] = "C1";
            mSoundIdList[4] = "D1";
            mSoundIdList[5] = "E1";
            mSoundIdList[6] = "F1";
            mSoundIdList[7] = "F1#";
            mSoundIdList[8] = "G1";
            mSoundIdList[9] = "A1";
            mSoundIdList[10] = "B1";
            mSoundIdList[11] = "C2";
            mSoundIdList[12] = "C2#";
            mSoundIdList[13] = "D2";
            mSoundIdList[14] = "E2";
            mSoundIdList[15] = "F2";
            mSoundIdList[16] = "F2#";
            mSoundIdList[17] = "G2";
            mSoundIdList[18] = "G2#";
            mSoundIdList[19] = "A2";
            mSoundIdList[20] = "B2";
            mSoundIdList[21] = "G#";
            mSoundIdList[22] = "A#";
            mSoundIdList[23] = "C1#";
            mSoundIdList[24] = "D1#";
            mSoundIdList[25] = "G1#";
            mSoundIdList[26] = "A1#";
            mSoundIdList[27] = "D2#";
            mSoundIdList[28] = "A2#";
        }
    }
    public void playRandomSound()
    {
        if (mSoundIdList == null)
        {
            updateSound();
        }
        Random randomSound = new Random();
        int number;
        number = randomSound.nextInt(mSoundIdList.length);
        if(mIsGameStart)
        {
            mCurrentSoundPlaying = mSoundIdList[number];
            mCurrentSoundId = mSoundPool.play(mSounds[number], 0.9f, 0.9f, 1, 0, 1);
            mIsGameStart = false;
        }
        else
        {
            if(number == mPreviusNumber)
            {
                do
                {
                    number = randomSound.nextInt(mSoundIdList.length);

                }while(number == mPreviusNumber);
            }
            mCurrentSoundPlaying = mSoundIdList[number];
            mCurrentSoundId = mSoundPool.play(mSounds[number], 0.9f, 0.9f, 1, 0, 1);
        }
        mPreviusNumber = number;
    }

    private void checkSound(String soundId)
    {
        if(soundId.matches(mCurrentSoundPlaying))
        {
            mGameActivity.increaseAtempts();

            if(mGameActivity.getAtemps() == 10 && mGameLevel < 12)
            {
                setGreenSquare(mCurrentSoundPlaying);
                try
                {
                    mIdSucceedSound = playSound(mSoundSucceeded);
                }
                catch(Exception e)
                {
                }
                mGameActivity.setText(mGameActivity.getAtemps());

                mMessage = mGameActivity.getString(R.string.level) + " " + mGameLevel + " " + mGameActivity.getString(R.string.is_completed)
                +"\n\n" + mGameActivity.getString(R.string.attempts)+ " " + mGameActivity.getmTotalAtemts();

                mTitle = mGameActivity.getString(R.string.congatulations);

                //mMainActivity.showOkDialog(mMessage, mTitle);

                mGameLevel ++;
                if(mGameLevel > mGameActivity.getSavedGameLevel())
                {
                    mGameActivity.saveLevel(mContext, "GameLevel", mGameLevel);
                }
                mGameActivity.setButtonPlayDisable();
                mGameActivity.setButtonLevelDisable();
                mGameActivity.changeStateWithBroadCast();
                Intent intent = new Intent(mGameActivity, MessageActivity.class);
                intent.putExtra(MessageActivity.TITLE, mTitle);
                intent.putExtra(MessageActivity.MESSAGE, mMessage);
                mGameActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
                mGameActivity.startActivity(intent);

            }
            else if(mGameActivity.getAtemps() < 10 && mGameLevel <= 12)
            {
                mGameActivity.setmButtonPlayEnabled();
                mGameActivity.setText(mGameActivity.getAtemps());
                setGreenSquare(mCurrentSoundPlaying);
                mIsPlayClicked = false;

            }
            else if(mGameActivity.getAtemps() == 10 && mGameLevel == 12)
            {
                setGreenSquare(mCurrentSoundPlaying);
                mGameActivity.setButtonPlayDisable();
                try
                {
                    mIdSucceedSound = playSound(mSoundSucceeded);
                }
                catch(Exception e)
                {

                }
                mGameActivity.setText(mGameActivity.getAtemps());
                mGameActivity.saveSucceededAllLevels(mContext, "doneAllLevels", true);
                mMessage = mGameActivity.getString(R.string.level) + " " + mGameLevel +  " " + mGameActivity.getString(R.string.is_completed) + "\n\n" + mGameActivity.getString(R.string.you_have_reached_the_end_of_the_game)
                        +"\n\n" +  mGameActivity.getString(R.string.attempts) + " " + mGameActivity.getmTotalAtemts() ;

                mTitle = mGameActivity.getString(R.string.congatulations);
                mGameActivity.setButtonPlayDisable();
                mGameActivity.setButtonLevelDisable();
                mGameActivity.changeStateWithBroadCast();
                Intent intent = new Intent(mGameActivity, MessageActivity.class);
                intent.putExtra(MessageActivity.TITLE, mTitle);
                intent.putExtra(MessageActivity.MESSAGE, mMessage);
                mGameActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
                mGameActivity.startActivity(intent);
                //mGameActivity.showOkDialog("\n" +
                        //mMessage, mTitle);
            }
        }
        else
        {
            mGameActivity.setmButtonPlayEnabled();
            mGameActivity.decreaseAtemps();
            mGameActivity.setText(mGameActivity.getAtemps());
            setRedSquare(soundId);
            mIsPlayClicked = false;
        }
    }
    private int playSound(int id)
    {
        int soundId;
        soundId = mSoundPool.play(id, 0.9f, 0.9f, 1, 0, 1);

        return soundId;
    }
    private void stopSoundClicked(final int sound)
    {
        LoweringSound mLSound;
        mLSound = new LoweringSound(sound);
        mLSound.stopSound();
    }
    private void stopSound(int sound)
    {
        LoweringSound mLSound;
        mLSound = new LoweringSound(sound);
        mLSound.stopSound();
    }

    public void stopPlayingOnRotate(int sound)
    {
        mSoundPool.stop(sound);
    }

    private class LoweringSound {

        private final int mSound;
        private float  mVolume;
        //private Handler mHandler = new Handler();
        Timer mTmr;

        private LoweringSound(int sound)
        {
            mSound = sound;
            mVolume = 0.05f;
        }

        private void stopSound()
        {
            mTmr = new Timer();
            TimerTask mTsk = new TimerTask()
            {
                public void run()
                {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run()
                        {
                            if (mSoundPool != null)
                            {
                                if (mVolume > 0.005f)
                                {
                                    try {
                                        upDateVolume(mVolume);
                                    }catch(Exception e)
                                    {
                                        mSoundPool.stop(mSound);
                                        mTmr.cancel();
                                    }

                                }
                                else
                                {
                                    mSoundPool.stop(mSound);
                                    mTmr.cancel();
                                }
                            }
                        }
                    });
                }
            };
            mTmr.schedule(mTsk,0,100); //start timer
        }

        private void upDateVolume(float volume)
        {
            try {
                mVolume = volume - 0.005f;
                mSoundPool.setVolume(mSound, mVolume, mVolume);
            }
            catch(Exception e)
            {
                mSoundPool.stop(mSound);
                mTmr.cancel();
            }
        }
    }
    private float getBitmapPositionX(String id)
    {
        float textViewX = 0;
        for(int i = 0; i < mTones.size(); i++)
        {
            if(mTones.get(i).getId().matches(id))
            {
                textViewX = mTones.get(i).getmPositionX();
                break;
            }
        }
        return textViewX;
    }

    private float getBitmapPositionY(String id)
    {
        float textViewY = 0;
        for(int i = 0; i < mTones.size(); i++)
        {
            if(mTones.get(i).getId().matches(id))
            {
                textViewY = mTones.get(i).getmPositionY();
                break;
            }
        }
        return textViewY;
    }

    private float getBitmapXend(String id)
    {
        float textViewWidth = 0;
        for(int i = 0; i < mTones.size(); i++)
        {
            if(mTones.get(i).getId().matches(id))
            {
                textViewWidth = mTones.get(i).getBitmapWidth() + mTones.get(i).getmPositionX();
                break;
            }
        }
        return textViewWidth;
    }

    private float getBitmapEndY(String id)
    {
        float textViewHeight = 0;
        for(int i = 0; i < mTones.size(); i++)
        {
            if(mTones.get(i).getId().matches(id))
            {
                textViewHeight = mTones.get(i).getBitmapHeight() + mTones.get(i).getmPositionY();
                break;
            }
        }
        return textViewHeight;
    }

    /*public void onPause()
    {
        if(mIsPlayClicked)
        {
            try
            {
                stopPlayingOnRotate(mCurrentSoundId);
                stopSucceedSound();

            }
            catch(Exception e)
            {

            }
        }

    }*/
    public void onBackPressed()
    {
        if(mIsPlayClicked)
        {
            try
            {
                stopPlayingOnRotate(mCurrentSoundId);
                stopSucceedSound();

            }
            catch(Exception e)
            {

            }
        }
    }
    public void onDestroy()
    {
        if(mSoundPool != null)
        {
            try {
                mSoundPool.release();
                mSoundPool = null;
            }catch(Exception e)
            {
                //Do nothing
            }
        }
        clearBitmapTones();
        clearBitmapStrings();
        clearBitmapFingerboard();
    }

    @Override
    public boolean onTouchEvent( MotionEvent event)
    {
        if(mIsPlayClicked)
        {
            super.onTouchEvent(event);
            final int action = event.getActionMasked();
            int pointerIndex = event.getActionIndex();
            float x = event.getX(pointerIndex);
            float y = event.getY(pointerIndex);
            float constant = mHeight /16 /2;
            switch(action)
            {
                case MotionEvent.ACTION_DOWN:

                    if (x >= getBitmapPositionX("G") && x <= getBitmapXend("G")
                            && y >= getBitmapPositionY("G") - constant && y <= getBitmapEndY("G") + constant) {
                        try
                        {
                            mStreamIdG1 = playSound(mSoundG1);
                            mIsG1Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapGStringG, getXposition() + mWidth / 100 * 3));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("A") && x <= getBitmapXend("A")
                            && y >= getBitmapPositionY("A") - constant && y <= getBitmapEndY("A")+ constant)
                    {
                        try
                        {
                            mStreamIdA1 = playSound(mSoundA1);
                            mIsA1Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapGStringA, getXposition() + mWidth / 100 * 3));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("B") && x <= getBitmapXend("B")
                            && y >= getBitmapPositionY("B") - constant && y <= getBitmapEndY("B") + constant)
                    {
                        try
                        {
                            mStreamIdH1 = playSound(mSoundH1);
                            mIsH1Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapGStringB, getXposition() + mWidth / 100 * 3));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >=getBitmapPositionX("C1") && x <= getBitmapXend("C1")
                            && y >= getBitmapPositionY("C1") - constant&& y <= getBitmapEndY("C1") + constant)
                    {
                        try
                        {
                            mStreamIdC1 = playSound(mSoundC1);
                            mIsC1Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapGStringC1,getXposition() + mWidth / 100 * 3));
                            startTimer();

                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("D1") && x <= getBitmapXend("D1")
                            && y >= getBitmapPositionY("D1") - constant && y <= getBitmapEndY("D1") + constant)
                    {
                        try
                        {
                            mStreamIdD1 = playSound(mSoundD1);
                            mIsD1Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapDStringD1,getXposition() + mWidth/100 * 30.25f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("D1GString") && x <= getBitmapXend("D1GString")
                            && y >= getBitmapPositionY("D1GString") - constant && y <= getBitmapEndY("D1GString") + constant)
                    {
                        try
                        {
                            mStreamIdD1 = playSound(mSoundD1);
                            mIsD1Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapGStringD1, getXposition() + mWidth/100 * 3));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if(x >= getBitmapPositionX("E1") && x <= getBitmapXend("E1")
                            && y >= getBitmapPositionY("E1") - constant && y <= getBitmapEndY("E1") + constant)
                    {
                        try
                        {
                            mStreamIdE1 = playSound(mSoundE1);
                            mIsE1Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapDStringE1,getXposition() + mWidth/100 * 30.25f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("F1") && x <= getBitmapXend("F1")
                            && y >= getBitmapPositionY("F1") - constant && y <= getBitmapEndY("F1") + constant)
                    {
                        try
                        {
                            mStreamIdF1 = playSound(mSoundF1);
                            mIsF1Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapDStringF1, getXposition() + mWidth/100 * 30.25f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if ( x >= getBitmapPositionX("F1#") && x <= getBitmapXend("F1#")
                            && y >= getBitmapPositionY("F1#") - constant && y <= getBitmapEndY("F1#") + constant)
                    {
                        try
                        {
                            mStreamIdF1High = playSound(mSoundF1High);
                            mIsF1HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapDStringF1High,getXposition() + mWidth/100 * 30.25f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("G1") && x <= getBitmapXend("G1")
                            && y >= getBitmapPositionY("G1") - constant && y <= getBitmapEndY("G1") + constant)
                    {
                        try
                        {
                            mStreamIdG2 = playSound(mSoundG2);
                            mIsG2Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapDStringG1,getXposition() + mWidth/100 * 30.25f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("A1DString") && x <= getBitmapXend("A1DString")
                            && y >= getBitmapPositionY("A1DString") - constant && y <= getBitmapEndY("A1DString") + constant)
                    {
                        try
                        {
                            mStreamIdA2 = playSound(mSoundA2);
                            mIsA2Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapDStringA1, getXposition() + mWidth/100 * 30.25f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("A1") && x <= getBitmapXend("A1")
                            && y >= getBitmapPositionY("A1") -constant && y <= getBitmapEndY("A1") + constant)
                    {
                        try
                        {
                            mStreamIdA2 = playSound(mSoundA2);
                            mIsA2Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapAStringA1,getXposition() + mWidth/100 * 59.5f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("B1") && x <= getBitmapXend("B1")
                            && y >= getBitmapPositionY("B1") - constant && y <= getBitmapEndY("B1") + constant)
                    {
                        try
                        {
                            mStreamIdH2 = playSound(mSoundH2);
                            mIsH2Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapAStringB1,getXposition() + mWidth/100 * 59.5f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("C2") && x <= getBitmapXend("C2")
                            && y >= getBitmapPositionY("C2") - constant && y <= getBitmapEndY("C2") + constant)
                    {
                        try
                        {
                            mStreamIdC2 = playSound(mSoundC2);
                            mIsC2Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapAStringC2,getXposition() + mWidth/100 * 59.5f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("C2#") && x <= getBitmapXend("C2#")
                            && y >= getBitmapPositionY("C2#") - constant && y <= getBitmapEndY("C2#") + constant)
                    {
                        try
                        {
                            mStreamIdC2High = playSound(mSoundC2High);
                            mIsC2HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapAStringC2High, getXposition() + mWidth/100 * 59.5f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("D2") && x <= getBitmapXend("D2")
                            && y >= getBitmapPositionY("D2") - constant && y <= getBitmapEndY("D2") + constant)
                    {
                        try
                        {
                            mStreamIdD2 = playSound(mSoundD2);
                            mIsD2Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapAStringD2,getXposition() + mWidth/100 * 59.5f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("E2") && x <= getBitmapXend("E2")
                            && y >= getBitmapPositionY("E2") - constant && y <= getBitmapEndY("E2") + constant)
                    {
                        try
                        {
                            mStreamIdE2 = playSound(mSoundE2);
                            mIsE2Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapEStringE2, getXposition() + mWidth/100 * 85.0f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }

                    else if (x >= getBitmapPositionX("F2") && x <= getBitmapXend("F2")
                            && y >= getBitmapPositionY("F2") - constant && y <= getBitmapEndY("F2") + constant)
                    {
                        try
                        {
                            mStreamIdF2 = playSound(mSoundF2);
                            mIsF2Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapEStringF2,getXposition() + mWidth/100 * 85.0f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("F2#") && x <= getBitmapXend("F2#")
                            && y >= getBitmapPositionY("F2#") - constant && y <= getBitmapEndY("F2#") + constant)
                    {
                        try
                        {
                            mStreamIdF2High = playSound(mSoundF2High);
                            mIsF2HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapEStringF2High,getXposition() + mWidth/100 * 85.0f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("G2") && x <= getBitmapXend("G2")
                            && y >= getBitmapPositionY("G2") - constant && y <= getBitmapEndY("G2") + constant)
                    {
                        try
                        {
                            mStreamIdG3 = playSound(mSoundG3);
                            mIsG3Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapEStringG2,getXposition() + mWidth/100 * 85.0f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("G2#") && x <= getBitmapXend("G2#")
                            && y >= getBitmapPositionY("G2#") - constant && y <= getBitmapEndY("G2#") + constant)
                    {
                        try
                        {
                            mStreamIdG3High = playSound(mSoundG3High);
                            mIsG3HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapEStringG2High,getXposition() + mWidth/100 * 85.0f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("A2") && x <= getBitmapXend("A2")
                            && y >= getBitmapPositionY("A2") - constant && y <= getBitmapEndY("A2") + constant)
                    {
                        try
                        {
                            mStreamIdA3 = playSound(mSoundA3);
                            mIsA3Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapEStringA2, getXposition() + mWidth/100 * 85.0f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("B2") && x <= getBitmapXend("B2")
                            && y >= getBitmapPositionY("B2") - constant && y <= getBitmapEndY("B2") + constant)
                    {
                        try
                        {
                            mStreamIdH3 = playSound(mSoundH3);
                            mIsH3Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapEStringB2,getXposition() + mWidth/100 * 85.0f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }
                        break;
                    }

                    else if (x >= getBitmapPositionX("G#") && x <= getBitmapXend("G#")
                            && y >= getBitmapPositionY("G#") - constant&& y <= getBitmapEndY("G#") + constant)
                    {
                        try
                        {
                            mStreamIdG1High = playSound(mSoundG1High);
                            mIsG1HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapGStringGHigh,getXposition() + mWidth/100 * 3));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("A#") && x <= getBitmapXend("A#")
                            && y >= getBitmapPositionY("A#") - constant && y <= getBitmapEndY("A#") + constant)
                    {
                        try
                        {
                            mStreamIdA1High = playSound(mSoundA1High);
                            mIsA1HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapGStringAHigh, getXposition() + mWidth / 100 * 3));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }

                    else if (x >= getBitmapPositionX("C1#") && x <= getBitmapXend("C1#")
                            && y >= getBitmapPositionY("C1#") - constant&& y <= getBitmapEndY("C1#") + constant)
                    {
                        try
                        {
                            mStreamIdC1High = playSound(mSoundC1High);
                            mIsC1HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapGStringC1High,getXposition() + mWidth / 100 * 3));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("D1#") && x <= getBitmapXend("D1#")
                            && y >= getBitmapPositionY("D1#") - constant && y <= getBitmapEndY("D1#") + constant)
                    {
                        try
                        {
                            mStreamIdD1High = playSound(mSoundD1High);
                            mIsD1HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapDStringD1High,getXposition() + mWidth/100 * 30.25f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("G1#") && x <= getBitmapXend("G1#")
                            && y >= getBitmapPositionY("G1#") - constant&& y <= getBitmapEndY("G1#") + constant)
                    {
                        try
                        {
                            mStreamIdG2High = playSound(mSoundG2High);
                            mIsG2HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapDStringG1High,getXposition() + mWidth/100 * 30.25f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }


                        break;
                    }
                    else if (x >= getBitmapPositionX("A1#") && x <= getBitmapXend("A1#")
                            && y >= getBitmapPositionY("A1#") - constant && y <= getBitmapEndY("A1#") + constant)
                    {
                        try
                        {
                            mStreamIdA2High = playSound(mSoundA2High);
                            mIsA2HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapAStringA1High, getXposition() + mWidth/100 * 59.5f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }
                        break;
                    }
                    else if (x >= getBitmapPositionX("D2#") && x <= getBitmapXend("D2#")
                            && y >= getBitmapPositionY("D2#") - constant && y <= getBitmapEndY("D2#") + constant)
                    {
                        try
                        {
                            mStreamIdD2High = playSound(mSoundD2High);
                            mIsD2HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapAStringD2High,getXposition() + mWidth/100 * 59.5f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    else if (x >= getBitmapPositionX("A2#") && x <= getBitmapXend("A2#")
                            && y >= getBitmapPositionY("A2#") - constant&& y <= getBitmapEndY("A2#") + constant)
                    {
                        try
                        {
                            mStreamIdA3High = playSound(mSoundA3High);
                            mIsA3HighClicked = true;
                            mSpriteList.add(new Sprite(mBitmapEStringA2High,getXposition() + mWidth/100 * 85f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }

                    else if (x >= getBitmapPositionX("E2AString") && x <= getBitmapXend("E2AString")
                            && y >= getBitmapPositionY("E2AString") - constant && y <= getBitmapEndY("E2AString") + constant)
                    {
                        try
                        {
                            mStreamIdE2 = playSound(mSoundE2);
                            mIsE2Clicked = true;
                            mSpriteList.add(new Sprite(mBitmapAStringE2, getXposition() + mWidth/100 * 59.5f));
                            startTimer();
                        }
                        catch(Exception e)
                        {

                        }

                        break;
                    }
                    break;
                case MotionEvent.ACTION_UP:

                    if (mIsG1Clicked) {
                        try {
                            stopSoundClicked(mStreamIdG1);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("G");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsG1Clicked = false;
                        break;
                    } else if (mIsA1Clicked) {
                        try {
                            stopSoundClicked(mStreamIdA1);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("A");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsA1Clicked = false;
                        break;
                    } else if (mIsH1Clicked) {
                        try {
                            stopSoundClicked(mStreamIdH1);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("B");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsH1Clicked = false;
                        break;
                    } else if (mIsC1Clicked) {
                        try {
                            stopSoundClicked(mStreamIdC1);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("C1");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsC1Clicked = false;
                        break;
                    } else if (mIsD1Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdD1);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("D1");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsD1Clicked = false;
                        break;
                    } else if (mIsE1Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdE1);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("E1");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsE1Clicked = false;
                        break;
                    } else if (mIsF1Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdF1);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("F1");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsF1Clicked = false;
                        break;
                    } else if (mIsF1HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdF1High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("F1#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsF1HighClicked = false;
                        break;
                    } else if (mIsG2Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdG2);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("G1");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsG2Clicked = false;
                        break;
                    } else if (mIsA2Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdA2);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("A1");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsA2Clicked = false;
                        break;
                    } else if (mIsH2Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdH2);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("B1");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsH2Clicked = false;
                        break;
                    } else if (mIsC2Clicked) {
                        try {
                            stopSoundClicked(mStreamIdC2);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("C2");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsC2Clicked = false;

                        break;
                    } else if (mIsC2HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdC2High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("C2#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsC2HighClicked = false;
                        break;
                    } else if (mIsD2Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdD2);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("D2");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsD2Clicked = false;
                        break;
                    }
                    else if (mIsE2Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdE2);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("E2");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsE2Clicked = false;
                        break;
                    } else if (mIsF2Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdF2);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("F2");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsF2Clicked = false;
                        break;
                    } else if (mIsF2HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdF2High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("F2#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsF2HighClicked = false;
                        break;
                    } else if (mIsG3Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdG3);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("G2");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsG3Clicked = false;
                        break;
                    } else if (mIsG3HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdG3High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("G2#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsG3HighClicked = false;
                        break;
                    } else if (mIsA3Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdA3);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("A2");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsA3Clicked = false;
                        break;
                    } else if (mIsH3Clicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdH3);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("B2");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsH3Clicked = false;
                        break;
                    } else if (mIsG1HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdG1High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("G#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsG1HighClicked = false;
                        break;
                    } else if (mIsA1HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdA1High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("A#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsA1HighClicked = false;
                        break;
                    } else if (mIsC1HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdC1High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("C1#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsC1HighClicked = false;
                        break;
                    } else if (mIsD1HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdD1High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("D1#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsD1HighClicked = false;
                        break;
                    } else if (mIsG2HighClicked) {
                        try {
                            stopSoundClicked(mStreamIdG2High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("G1#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsG2HighClicked = false;
                        break;
                    } else if (mIsA2HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdA2High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("A1#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsA2HighClicked = false;
                        break;
                    } else if (mIsD2HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdD2High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("D2#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsD2HighClicked = false;
                        break;
                    } else if (mIsA3HighClicked) {
                        try
                        {
                            stopSoundClicked(mStreamIdA3High);
                            stopSound(mCurrentSoundId);
                            if (mSpriteList.size() > 0)
                            {
                                mSpriteList.clear();
                            }
                            stopTimer();
                            checkSound("A2#");
                        }
                        catch(Exception e)
                        {

                        }
                        mIsA3HighClicked = false;
                        break;
                    }
                break;
            }
        }

        return true;
    }
    public void setisPlayButtonClicked(boolean isClicked)
    {
        mIsPlayClicked = isClicked;
    }

    public void setGameLevel(int gameLevel)
    {
        mGameLevel = gameLevel;
        mGameLevelRotation = gameLevel;
    }

    public int getGameLevel()
    {
        return mGameLevelRotation;
    }

    public String getMessage()
    {
        return mMessage;
    }
    public void setMessage(String message)
    {
        mMessage = message;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title){
        mTitle = title;
    }
    public boolean getIsplayButtonClicked()
    {
        return mIsPlayClicked;
    }
    public String getmCurrentSoundPlaying()
    {
        return mCurrentSoundPlaying;
    }
    public void setmCurrentSoundPlaying(String tone){
        mCurrentSoundPlaying = tone;
    }
    public boolean getGameIsStarted()
    {
        return mIsGameStart;
    }

    public void setmIsGameStart(boolean isGameStarted)
    {
        mIsGameStart = isGameStarted;
    }

    public int getPreviousNumber()
    {
        return mPreviusNumber;
    }

    public void setmPreviusNumber(int previusNumber)
    {
        mPreviusNumber = previusNumber;
    }

    public float getXposition()
    {
        float positionX;
        positionX = (mScreenWidth - mWidth) /  2f;
        return  positionX;
    }


    public void stopSucceedSound()
    {
        mSoundPool.stop(mIdSucceedSound);
    }

    public float getBitmapWidth()
    {
        float width;
        width = mWidth / WIDTH_COSTANT;
        return width;
    }
    public float getBitmapHeight()
    {
        float height;
        height = mHeight / HEIGHT_COSTANT;
        return height;
    }

    private void setRedSquare(String soundId)
    {
        for (int i = 0; i < mTones.size(); i++)
        {
            if (mTones.get(i).getId().matches(soundId))
            {
                mGameActivity.setmImageViewRedWrong(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                if (mTones.get(i).getId().matches("D1"))
                {
                    for (i = 0; i < mTones.size(); i++) {
                        if (mTones.get(i).getId().matches("D1GString")) {
                            mGameActivity.setmImageViewRedWrong2(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                        }
                    }
                }
                else if (mTones.get(i).getId().matches("A1") )
                {
                    for (i = 0; i < mTones.size(); i++)
                    {
                        if (mTones.get(i).getId().matches("A1DString"))
                        {
                            mGameActivity.setmImageViewRedWrong2(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                        }
                    }
                }
                else if (mTones.get(i).getId().matches("E2"))
                {
                    for (i = 0; i < mTones.size(); i++)
                    {
                        if (mTones.get(i).getId().matches("E2AString"))
                        {
                            mGameActivity.setmImageViewRedWrong2(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                        }
                    }
                }
            }
        }
        for (int i = 0; i < mTones.size(); i++)
        {
            if (mTones.get(i).getId().matches(mCurrentSoundPlaying))
            {
                mGameActivity.setmImageViewGreenRight(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                String mPostionIdImageViewGreenRight;
                mPostionIdImageViewGreenRight = mCurrentSoundPlaying;
                if (mPostionIdImageViewGreenRight.matches("D1")){
                    for (i = 0; i < mTones.size(); i++)
                    {
                        if (mTones.get(i).getId().matches("D1GString"))
                        {
                            mGameActivity.setmImageViewGreenRight2(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                        }
                    }
                }
                else if (mPostionIdImageViewGreenRight.matches("A1") )
                {
                    for (i = 0; i < mTones.size(); i++)
                    {
                        if (mTones.get(i).getId().matches("A1DString"))
                        {
                            mGameActivity.setmImageViewGreenRight2(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                        }
                    }
                }
                else if (mPostionIdImageViewGreenRight.matches("E2"))
                {
                    for (i = 0; i < mTones.size(); i++)
                    {
                        if (mTones.get(i).getId().matches("E2AString"))
                        {
                            mGameActivity.setmImageViewGreenRight2(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                        }
                    }
                }

            }
        }

    }
    private void setGreenSquare(String currentSoundPlaying)
    {
        for (int i = 0; i < mTones.size(); i++)
        {
            if (mTones.get(i).getId().matches(currentSoundPlaying)) {
                mGameActivity.setImageViewOkGreen(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                if (mTones.get(i).getId().matches("D1")) {
                    for (i = 0; i < mTones.size(); i++) {
                        if (mTones.get(i).getId().matches("D1GString")) {
                            mGameActivity.setImageViewOkGreen2(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                        }
                    }
                }
                else if (mTones.get(i).getId().matches("A1"))
                {
                    for (i = 0; i < mTones.size(); i++) {
                        if (mTones.get(i).getId().matches("A1DString")) {
                            mGameActivity.setImageViewOkGreen2(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                        }
                    }
                }
                else if (mTones.get(i).getId().matches("E2"))
                {
                    for (i = 0; i < mTones.size(); i++) {
                        if (mTones.get(i).getId().matches("E2AString")) {
                            mGameActivity.setImageViewOkGreen2(mTones.get(i).getmPositionX(), mTones.get(i).getmPositionY());
                        }
                    }
                }
            }
        }
    }
    public void startTimer() {
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            public void run() {
                //Redraw must run in background thread to prevent thread lock.
                mHandler.post(new Runnable()
                {
                    public void run() {
                        invalidate();
                    }
                });
            }
        }; // TimerTask
        mTimer.schedule(mTimerTask, 10, 16); //start timer
    }
    private void stopTimer()
    {
        if (mTimer != null)
        {
            mTimer.cancel(); //kill\release timer (our only background thread)
            mTimer = null;
            mTimerTask = null;
        }
    }
    public Bitmap getSpriteBitmapGString(final int yPosition)
    {
        Bitmap bitmap;
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.g_string_experiment), (int)mWidth / 8, mBitmapNeck.getHeight(), true);
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap.setHasAlpha(true);
        for (int i = 0; i < pixels.length; i++)
        {
            if (i <= yPosition  * bitmap.getWidth())
            {
                pixels[i] = Color.TRANSPARENT;
            }
        }
        try
        {
            bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(),  bitmap.getHeight());
            //bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 8 , bitmap.getHeight() / 8, true);

        }catch(Exception e)
        {

        }
        return bitmap;
    }
    public Bitmap getSpriteBitmapDString(final int yPosition)
    {
        Bitmap bitmap;
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.d_string_experiment), (int)mWidth / 12, mBitmapNeck.getHeight(), true);
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap.setHasAlpha(true);
        for (int i = 0; i < pixels.length; i++)
        {
            if (i <= yPosition  * bitmap.getWidth())
            {
                pixels[i] = Color.TRANSPARENT;
            }
        }
        try
        {
            bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(),  bitmap.getHeight());
            //bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 8 , bitmap.getHeight() / 8, true);

        }catch(Exception e)
        {

        }

        return bitmap;
    }
    public Bitmap getSpriteBitmapAString(final int yPosition)
    {
        Bitmap bitmap;
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.a_string_experiment), (int)mWidth / 12, mBitmapNeck.getHeight(), true);
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap.setHasAlpha(true);
        for (int i = 0; i < pixels.length; i++)
        {
            if (i <= yPosition  * bitmap.getWidth())
            {
                pixels[i] = Color.TRANSPARENT;
            }
        }
        try
        {
            bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(),  bitmap.getHeight());

        }catch(Exception e)
        {

        }

        return bitmap;
    }
    public Bitmap getSpriteBitmapEString(final int yPosition)
    {
        Bitmap bitmap;
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.e_string_experiment), (int)mWidth / 8, mBitmapNeck.getHeight(), true);
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap.setHasAlpha(true);
        for (int i = 0; i < pixels.length; i++)
        {
            if (i <= yPosition  * bitmap.getWidth())
            {
                pixels[i] = Color.TRANSPARENT;
            }
        }
        try
        {
            bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(),  bitmap.getHeight());

        }catch(Exception e)
        {

        }
        return bitmap;

    }
    private void clearBitmapTones()
    {
        if (mBitmapToneG != null) {
            mBitmapToneG.recycle();
            mBitmapToneG = null;
        }
        if (mBitmapToneGHigh != null)
        {
            mBitmapToneGHigh.recycle();
            mBitmapToneGHigh = null;
        }
        if (mBitmapToneA != null)
        {
            mBitmapToneA.recycle();
            mBitmapToneA = null;
        }
        if (mBitmapToneAHigh != null)
        {
            mBitmapToneAHigh.recycle();
            mBitmapToneAHigh = null;
        }
        if (mBitmapToneB != null)
        {
            mBitmapToneB.recycle();
            mBitmapToneB = null;
        }
        if (mBitmapToneC1 != null)
        {
            mBitmapToneC1.recycle();
            mBitmapToneC1 = null;
        }
        if (mBitmapToneC1High != null)
        {
            mBitmapToneC1High.recycle();
            mBitmapToneC1High = null;
        }
        if (mBitmapToneD1GString != null)
        {
            mBitmapToneD1GString.recycle();
            mBitmapToneD1GString = null;
        }
        if (mBitmapToneD1 != null)
        {
            mBitmapToneD1.recycle();
            mBitmapToneD1 = null;
        }
        if (mBitmapToneD1High != null)
        {
            mBitmapToneD1High.recycle();
            mBitmapToneD1High = null;
        }
        if (mBitmapToneE1 != null)
        {
            mBitmapToneE1.recycle();
            mBitmapToneE1 = null;
        }
        if (mBitmapToneF1 != null)
        {
            mBitmapToneF1.recycle();
            mBitmapToneF1 = null;
        }
        if (mBitmapToneF1High != null)
        {
            mBitmapToneF1High.recycle();
            mBitmapToneF1High = null;
        }
        if (mBitmapToneG1 != null)
        {
            mBitmapToneG1.recycle();
            mBitmapToneG1 = null;
        }
        if (mBitmapToneG1High != null)
        {
            mBitmapToneG1High.recycle();
            mBitmapToneG1High = null;
        }
        if (mBitmapToneA1DString != null)
        {
            mBitmapToneA1DString.recycle();
            mBitmapToneA1DString = null;
        }
        if (mBitmapToneA1 != null)
        {
            mBitmapToneA1.recycle();
            mBitmapToneA1 = null;
        }
        if (mBitmapToneA1High != null)
        {
            mBitmapToneA1High.recycle();
            mBitmapToneA1High = null;
        }
        if (mBitmapToneB1 != null)
        {
            mBitmapToneB1.recycle();
            mBitmapToneB1 = null;
        }
        if (mBitmapToneC2 != null)
        {
            mBitmapToneC2.recycle();
            mBitmapToneC2 = null;
        }
        if (mBitmapToneC2High != null)
        {
            mBitmapToneC2High.recycle();
            mBitmapToneC2High = null;
        }
        if (mBitmapToneD2 != null)
        {
            mBitmapToneD2.recycle();
            mBitmapToneD2 = null;
        }
        if (mBitmapToneD2High != null)
        {
            mBitmapToneD2High.recycle();
            mBitmapToneD2High = null;
        }
        if (mBitmapToneE2AString != null)
        {
            mBitmapToneE2AString.recycle();
            mBitmapToneE2AString = null;
        }
        if (mBitmapToneE2 != null)
        {
            mBitmapToneE2.recycle();
            mBitmapToneE2 = null;
        }
        if (mBitmapToneF2 != null)
        {
            mBitmapToneF2.recycle();
            mBitmapToneF2 = null;
        }
        if (mBitmapToneF2High != null)
        {
            mBitmapToneF2High.recycle();
            mBitmapToneF2High = null;
        }
        if (mBitmapToneG2 != null)
        {
            mBitmapToneG2.recycle();
            mBitmapToneG2 = null;
        }
        if (mBitmapToneG2High != null)
        {
            mBitmapToneG2High.recycle();
            mBitmapToneG2High = null;
        }
        if (mBitmapToneA2 != null)
        {
            mBitmapToneA2.recycle();
            mBitmapToneA2 = null;
        }
        if (mBitmapToneA2High != null)
        {
            mBitmapToneA2High.recycle();
            mBitmapToneA2High = null;
        }
        if (mBitmapToneB2 != null)
        {
            mBitmapToneB2.recycle();
            mBitmapToneB2 = null;
        }
    }
    public void clearBitmapStrings()
    {
        if (mBitmapGStringG != null){
            mBitmapGStringG.recycle();
            mBitmapGStringG = null;
        }
        if (mBitmapGStringA != null){
            mBitmapGStringA.recycle();
            mBitmapGStringA = null;
        }
        if (mBitmapGStringGHigh != null){
            mBitmapGStringGHigh.recycle();
            mBitmapGStringGHigh = null;
        }
        if (mBitmapGStringAHigh != null){
            mBitmapGStringAHigh.recycle();
            mBitmapGStringAHigh = null;
        }
        if (mBitmapGStringB != null){
            mBitmapGStringB.recycle();
            mBitmapGStringB = null;
        }
        if (mBitmapGStringC1 != null){
            mBitmapGStringC1.recycle();
            mBitmapGStringC1 = null;
        }
        if (mBitmapGStringC1High != null){
            mBitmapGStringC1High.recycle();
            mBitmapGStringC1High = null;
        }
        if (mBitmapGStringD1 != null){
            mBitmapGStringD1.recycle();
            mBitmapGStringD1 = null;
        }
        if (mBitmapDStringD1 != null){
            mBitmapDStringD1.recycle();
            mBitmapDStringD1 = null;
        }
        if (mBitmapDStringD1High != null){
            mBitmapDStringD1High.recycle();
            mBitmapDStringD1High = null;
        }
        if (mBitmapDStringE1 != null){
            mBitmapDStringE1.recycle();
            mBitmapDStringE1 = null;
        }
        if (mBitmapDStringF1 != null){
            mBitmapDStringF1.recycle();
            mBitmapDStringF1 = null;
        }
        if (mBitmapDStringF1High != null){
            mBitmapDStringF1High.recycle();
            mBitmapDStringF1High = null;
        }
        if (mBitmapDStringG1 != null){
            mBitmapDStringG1.recycle();
            mBitmapDStringG1 = null;
        }
        if (mBitmapDStringG1High != null){
            mBitmapDStringG1High.recycle();
            mBitmapDStringG1High = null;
        }
        if (mBitmapDStringA1 != null){
            mBitmapDStringA1.recycle();
            mBitmapDStringA1 = null;
        }
        if (mBitmapAStringA1 != null){
            mBitmapAStringA1.recycle();
            mBitmapAStringA1 = null;
        }
        if (mBitmapAStringA1High != null){
            mBitmapAStringA1High.recycle();
            mBitmapAStringA1High = null;
        }
        if (mBitmapAStringB1 != null){
            mBitmapAStringB1.recycle();
            mBitmapAStringB1 = null;
        }
        if (mBitmapAStringC2 != null){
            mBitmapAStringC2.recycle();
            mBitmapAStringC2 = null;
        }
        if (mBitmapAStringC2High != null){
            mBitmapAStringC2High.recycle();
            mBitmapAStringC2High = null;
        }
        if (mBitmapAStringD2 != null){
            mBitmapAStringD2.recycle();
            mBitmapAStringD2 = null;
        }
        if (mBitmapAStringD2High != null){
            mBitmapAStringD2High.recycle();
            mBitmapAStringD2High = null;
        }
        if (mBitmapAStringE2 != null){
            mBitmapAStringE2.recycle();
            mBitmapAStringE2 = null;
        }
        if (mBitmapEStringE2 != null){
            mBitmapEStringE2.recycle();
            mBitmapEStringE2 = null;
        }
        if (mBitmapEStringF2 != null){
            mBitmapEStringF2.recycle();
            mBitmapEStringF2 = null;
        }
        if (mBitmapEStringF2High != null){
            mBitmapEStringF2High.recycle();
            mBitmapEStringF2High = null;
        }
        if (mBitmapEStringG2 != null){
            mBitmapEStringG2.recycle();
            mBitmapEStringG2 = null;
        }
        if (mBitmapEStringG2High != null){
            mBitmapEStringG2High.recycle();
            mBitmapEStringG2High = null;
        }
        if (mBitmapEStringA2 != null){
            mBitmapEStringA2.recycle();
            mBitmapEStringA2 = null;
        }
        if (mBitmapEStringA2High != null){
            mBitmapEStringA2High.recycle();
            mBitmapEStringA2High = null;
        }
        if (mBitmapEStringB2 != null){
            mBitmapEStringB2.recycle();
            mBitmapEStringB2 = null;
        }
    }
    private void clearBitmapFingerboard()
    {
        if (mBitmapNeck != null){
            mBitmapNeck.recycle();
            mBitmapNeck = null;
        }
    }
    public SoundPool getSoundPool()
    {
        return mSoundPool;
    }

}
