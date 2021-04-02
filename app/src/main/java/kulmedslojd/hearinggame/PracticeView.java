package kulmedslojd.hearinggame;

import android.content.Context;
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
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by Thomas on 2016-03-03.
 */
public class PracticeView extends View {
    private MainActivity mMainActivity;
    private Context mContext;
    private float mWidth;
    private float mHeight;
    private Bitmap mBitmapFingerBoard;

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

    private List<SoundInfo> mCurrentSoundIdList = new ArrayList<>();
    public SoundPool mSoundPool;
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
    private float mScreenWidth;
    private List<Tone> mTones = new ArrayList<>();
    final int HEIGHT_COSTANT = 16;
    final int WIDTH_COSTANT = 6;

    private Timer mTimer;
    private TimerTask mTimerTask;
    private Handler mHandler = new Handler();
    public static List<Sprite> mSpriteList = new ArrayList<>();
    //String G
    private boolean mIsGSounding = false;
    private boolean mIsGHighSounding = false;
    private boolean mIsASounding = false;
    private boolean mIsAHighSounding = false;
    private boolean mIsBSounding = false;
    private boolean mIsC1Sounding = false;
    private boolean mIsC1HighSounding = false;
    private boolean mIsD1GStringSounding = false;

    //String D
    private boolean mIsD1Sounding = false;
    private boolean mIsD1HighSounding = false;
    private boolean mIsE1Sounding = false;
    private boolean mIsF1Sounding = false;
    private boolean mIsF1HighSounding = false;
    private boolean mIsG1Sounding = false;
    private boolean mIsG1HighSonding = false;
    private boolean misA1DStringSounding = false;

    //String A
    private boolean mIsA1Sounding = false;
    private boolean mIsA1HighSounding = false;
    private boolean mIsB1Sounding = false;
    private boolean mIsC2Sounding = false;
    private boolean mIsC2HighSounding = false;
    private boolean mIsD2Sounding = false;
    private boolean mIsD2HighSounding = false;
    private boolean mIsE2AStringSounding = false;

    private boolean mIsE2Sounding = false;
    private boolean mIsF2Sounding;
    private boolean mIsF2HighSounding = false;
    private boolean mIsG2Sounding = false;
    private boolean mIsG2HighSonding = false;
    private boolean mIsA2Sounding = false;
    private boolean miSA2HighSounding = false;
    private boolean mIsB2Soundin = false;

    public PracticeView(Context context, AttributeSet attrib) {
        super(context, attrib);
        mContext = context;
        mMainActivity = (MainActivity) context;
        initSoundPool();
    }

    private void initBitmapNeck() {
        mBitmapFingerBoard = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.greppbrada_stor), (int) mWidth, (int) mHeight, true);
        mHeight = mBitmapFingerBoard.getHeight();
    }
    public void initSpriteStrings()
    {
        float ROWS = 8;
        float constant = mHeight / 16 / 2;
        //G String
        mBitmapGStringG = getSpriteBitmapGString((int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapGStringGHigh = getSpriteBitmapGString(((int) mHeight / (int) ROWS + (int) constant) + (int) mHeight / HEIGHT_COSTANT);
        mBitmapGStringA = getSpriteBitmapGString((int) mHeight / (int) ROWS * 2 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapGStringAHigh = getSpriteBitmapGString((int) mHeight / (int) ROWS * 3 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapGStringB = getSpriteBitmapGString((int) mHeight / (int) ROWS * 4 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapGStringC1 = getSpriteBitmapGString((int) mHeight / (int) ROWS * 5 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapGStringC1High = getSpriteBitmapGString((int) mHeight / (int) ROWS * 6 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapGStringD1 = getSpriteBitmapGString((int) mHeight / (int) ROWS * 7 + (int) constant + (int) mHeight / HEIGHT_COSTANT);

        //D String
        mBitmapDStringD1 = getSpriteBitmapDString((int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapDStringD1High = getSpriteBitmapDString(((int) mHeight / (int) ROWS + (int) constant) + (int) mHeight / HEIGHT_COSTANT);
        mBitmapDStringE1 = getSpriteBitmapDString((int) mHeight / (int) ROWS * 2 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapDStringF1 = getSpriteBitmapDString((int) mHeight / (int) ROWS * 3 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapDStringF1High = getSpriteBitmapDString((int) mHeight / (int) ROWS * 4 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapDStringG1 = getSpriteBitmapDString((int) mHeight / (int) ROWS * 5 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapDStringG1High = getSpriteBitmapDString((int) mHeight / (int) ROWS * 6 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapDStringA1 = getSpriteBitmapDString((int) mHeight / (int) ROWS * 7 + (int) constant + (int) mHeight / HEIGHT_COSTANT);

        mBitmapAStringA1 = getSpriteBitmapAString((int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapAStringA1High = getSpriteBitmapAString(((int) mHeight / (int) ROWS + (int) constant) + (int) mHeight / HEIGHT_COSTANT);
        mBitmapAStringB1 = getSpriteBitmapAString((int) mHeight / (int) ROWS * 2 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapAStringC2 = getSpriteBitmapAString((int) mHeight / (int) ROWS * 3 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapAStringC2High = getSpriteBitmapAString((int) mHeight / (int) ROWS * 4 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapAStringD2 = getSpriteBitmapAString((int) mHeight / (int) ROWS * 5 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapAStringD2High = getSpriteBitmapAString((int) mHeight / (int) ROWS * 6 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapAStringE2 = getSpriteBitmapAString((int) mHeight / (int) ROWS * 7 + (int) constant + (int) mHeight / HEIGHT_COSTANT);

        mBitmapEStringE2 = getSpriteBitmapEString((int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapEStringF2 = getSpriteBitmapEString(((int) mHeight / (int) ROWS + (int) constant) + (int) mHeight / HEIGHT_COSTANT);
        mBitmapEStringF2High = getSpriteBitmapEString((int) mHeight / (int) ROWS * 2 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapEStringG2 = getSpriteBitmapEString((int) mHeight / (int) ROWS * 3 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapEStringG2High = getSpriteBitmapEString((int) mHeight / (int) ROWS * 4 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapEStringA2 = getSpriteBitmapEString((int) mHeight / (int) ROWS * 5 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapEStringA2High = getSpriteBitmapEString((int) mHeight / (int) ROWS * 6 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
        mBitmapEStringB2 = getSpriteBitmapEString((int) mHeight / (int) ROWS * 7 + (int) constant + (int) mHeight / HEIGHT_COSTANT);
    }

    public void intBitmapTones() {
        float ROWS = 8;
        float constant = mHeight / 16 / 2;


        if (!PracticeFragment.mIsShowingNotes)
        {
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.g_high);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f, mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.d1_high);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.f1_high);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.g1_high);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.d2_high);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.f2_high);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.g2_high);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));

            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
        else
        {
            mBitmapToneG = BitmapFactory.decodeResource(getResources(), R.drawable.note_g);
            mBitmapToneG = Bitmap.createScaledBitmap(mBitmapToneG, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG, getXposition() + mWidth / 100 * 5.0f, constant, "G"));

            mBitmapToneGHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_g_high);
            mBitmapToneGHigh = Bitmap.createScaledBitmap(mBitmapToneGHigh, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneGHigh, getXposition() + mWidth / 100 * 3.5f, mHeight / ROWS + constant, "G#"));

            mBitmapToneA = BitmapFactory.decodeResource(getResources(), R.drawable.note_a);
            mBitmapToneA = Bitmap.createScaledBitmap(mBitmapToneA, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA, getXposition() + mWidth / 100 * 2.4f, mHeight / ROWS * 2 + constant, "A"));

            mBitmapToneAHigh = BitmapFactory.decodeResource(getResources(), R.drawable.note_a_high);
            mBitmapToneAHigh = Bitmap.createScaledBitmap(mBitmapToneAHigh, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneAHigh, getXposition() + mWidth / 100 * 1.5f, mHeight / ROWS * 3 + constant, "A#"));

            mBitmapToneB = BitmapFactory.decodeResource(getResources(), R.drawable.note_h);
            mBitmapToneB = Bitmap.createScaledBitmap(mBitmapToneB, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB, getXposition() + mWidth / 100 * 0.45f, mHeight / ROWS * 4 + constant, "B"));

            mBitmapToneC1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1);
            mBitmapToneC1 = Bitmap.createScaledBitmap(mBitmapToneC1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC1, getXposition() + mWidth / 100 * -0.5f, mHeight / ROWS * 5 + constant, "C1"));

            mBitmapToneC1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c1_high);
            mBitmapToneC1High = Bitmap.createScaledBitmap(mBitmapToneC1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC1High, getXposition() + mWidth / 100 * -1.5f, mHeight / ROWS * 6 + constant, "C1#"));

            mBitmapToneD1GString = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1GString = Bitmap.createScaledBitmap(mBitmapToneD1GString, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1GString, getXposition() + mWidth / 100 * -3.5f, mHeight / ROWS * 7 + constant, "D1GString"));

            //Sträng D
            mBitmapToneD1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1);
            mBitmapToneD1 = Bitmap.createScaledBitmap(mBitmapToneD1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1, getXposition() + mWidth / 100 * 27.3f, constant, "D1"));

            mBitmapToneD1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_d1_high);
            mBitmapToneD1High = Bitmap.createScaledBitmap(mBitmapToneD1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD1High, getXposition() + mWidth / 100 * 27.4f, mHeight / ROWS + constant, "D1#"));

            mBitmapToneE1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e1);
            mBitmapToneE1 = Bitmap.createScaledBitmap(mBitmapToneE1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE1, getXposition() + mWidth / 100 * 27.0f, mHeight / ROWS * 2 + constant, "E1"));

            mBitmapToneF1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1);
            mBitmapToneF1 = Bitmap.createScaledBitmap(mBitmapToneF1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1, getXposition() + mWidth / 100 * 26.5f, mHeight / ROWS * 3 + constant, "F1"));

            mBitmapToneF1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_f1_high);
            mBitmapToneF1High = Bitmap.createScaledBitmap(mBitmapToneF1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF1High, getXposition() + mWidth / 100 * 26.2f, mHeight / ROWS * 4 + constant, "F1#"));

            mBitmapToneG1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1);
            mBitmapToneG1 = Bitmap.createScaledBitmap(mBitmapToneG1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1, getXposition() + mWidth / 100 * 26.0f, mHeight / ROWS * 5 + constant, "G1"));

            mBitmapToneG1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_g1_high);
            mBitmapToneG1High = Bitmap.createScaledBitmap(mBitmapToneG1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG1High, getXposition() + mWidth / 100 * 25.5f, mHeight / ROWS * 6 + constant, "G1#"));

            mBitmapToneA1DString = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1DString = Bitmap.createScaledBitmap(mBitmapToneA1DString, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1DString, getXposition() + mWidth / 100 * 25.0f, mHeight / ROWS * 7 + constant, "A1DString"));

            //String A
            mBitmapToneA1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1);
            mBitmapToneA1 = Bitmap.createScaledBitmap(mBitmapToneA1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1, getXposition() + mWidth / 100 * 53.5f, constant, "A1"));

            mBitmapToneA1High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a1_high);
            mBitmapToneA1High = Bitmap.createScaledBitmap(mBitmapToneA1High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA1High, getXposition() + mWidth / 100 * 54.5f, mHeight / ROWS + constant, "A1#"));

            mBitmapToneB1 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h1);
            mBitmapToneB1 = Bitmap.createScaledBitmap(mBitmapToneB1, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB1, getXposition() + mWidth / 100 * 55.0f, mHeight / ROWS * 2 + constant, "B1"));

            mBitmapToneC2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2);
            mBitmapToneC2 = Bitmap.createScaledBitmap(mBitmapToneC2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2, getXposition() + mWidth / 100 * 55.5f, mHeight / ROWS * 3 + constant, "C2"));

            mBitmapToneC2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_c2_high);
            mBitmapToneC2High = Bitmap.createScaledBitmap(mBitmapToneC2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneC2High, getXposition() + mWidth / 100 * 56.0f, mHeight / ROWS * 4 + constant, "C2#"));

            mBitmapToneD2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2);
            mBitmapToneD2 = Bitmap.createScaledBitmap(mBitmapToneD2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2, getXposition() + mWidth / 100 * 56.3f, mHeight / ROWS * 5 + constant, "D2"));

            mBitmapToneD2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_d2_high);
            mBitmapToneD2High = Bitmap.createScaledBitmap(mBitmapToneD2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneD2High, getXposition() + mWidth / 100 * 56.8f, mHeight / ROWS * 6 + constant, "D2#"));

            mBitmapToneE2AString = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2AString = Bitmap.createScaledBitmap(mBitmapToneE2AString, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2AString, getXposition() + mWidth / 100 * 57.0f, mHeight / ROWS * 7 + constant, "E2AString"));

            //String E
            mBitmapToneE2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_e2);
            mBitmapToneE2 = Bitmap.createScaledBitmap(mBitmapToneE2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneE2, getXposition() + mWidth / 100 * 79.0f, constant, "E2"));

            mBitmapToneF2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2);
            mBitmapToneF2 = Bitmap.createScaledBitmap(mBitmapToneF2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2, getXposition() + mWidth / 100 * 80.0f, mHeight / ROWS + constant, "F2"));

            mBitmapToneF2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_f2_high);
            mBitmapToneF2High = Bitmap.createScaledBitmap(mBitmapToneF2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneF2High, getXposition() + mWidth / 100 * 81.0f, mHeight / ROWS * 2 + constant, "F2#"));

            mBitmapToneG2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2);
            mBitmapToneG2 = Bitmap.createScaledBitmap(mBitmapToneG2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2, getXposition() + mWidth / 100 * 82.0f, mHeight / ROWS * 3 + constant, "G2"));

            mBitmapToneG2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_g2_high);
            mBitmapToneG2High = Bitmap.createScaledBitmap(mBitmapToneG2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneG2High, getXposition() + mWidth / 100 * 83.0f, mHeight / ROWS * 4 + constant, "G2#"));

            mBitmapToneA2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2);
            mBitmapToneA2 = Bitmap.createScaledBitmap(mBitmapToneA2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2, getXposition() + mWidth / 100 * 84.0f, mHeight / ROWS * 5 + constant, "A2"));

            mBitmapToneA2High = BitmapFactory.decodeResource(getResources(), R.drawable.note_a2_high);
            mBitmapToneA2High = Bitmap.createScaledBitmap(mBitmapToneA2High, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneA2High, getXposition() + mWidth / 100 * 85.0f, mHeight / ROWS * 6 + constant, "A2#"));


            mBitmapToneB2 = BitmapFactory.decodeResource(getResources(), R.drawable.note_h2);
            mBitmapToneB2 = Bitmap.createScaledBitmap(mBitmapToneB2, (int) mWidth / WIDTH_COSTANT, (int) mHeight / HEIGHT_COSTANT, true);
            mTones.add(new Tone(mBitmapToneB2, getXposition() + mWidth / 100 * 86.0f, mHeight / ROWS * 7 + constant, "B2"));
        }
    }
    private void drawNeck(Canvas canvas) {
        canvas.drawBitmap(mBitmapFingerBoard, getXposition(), 0, null);

    }

    private void drawNotes(Canvas canvas) {
        if (mTones.size() > 0) {
            for (int i = 0; i < mTones.size(); i++) {
                mTones.get(i).drawNote(canvas);
            }
        }
    }

    private void drawPressIndicator(Canvas canvas) {
        if (mCurrentSoundIdList.size() > 0) {
            for (int i = 0; i < mCurrentSoundIdList.size(); i++) {
                mCurrentSoundIdList.get(i).drawPressIndicator(canvas);
            }

        }
    }

    private void drawSprite(Canvas canvas) {

        if (mSpriteList.size() > 0) {
            for (int i = 0; i < mSpriteList.size(); i++) {
                mSpriteList.get(i).drawSprite(canvas);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mScreenWidth = getWidth();
        mHeight = getHeight();

        if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE || (getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_XLARGE)
        {
            if (mMainActivity.getOrientation() == 2)
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
            if (mMainActivity.getOrientation() == 2)
            {
                mWidth = getWidth();;
            }
            else
            {
                mWidth = mScreenWidth / 2;
            }

        }
        if (mBitmapFingerBoard == null) {
            initBitmapNeck();
            initSpriteStrings();
            intBitmapTones();

        }
        drawNeck(canvas);
        drawSprite(canvas);
        drawNotes(canvas);
        drawPressIndicator(canvas);
    }

    private void initSoundPool() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();


            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();

            mSoundG1 = mSoundPool.load(mContext, R.raw.g1, 1);
            mSoundA1 = mSoundPool.load(mContext, R.raw.a1, 1);
            mSoundH1 = mSoundPool.load(mContext, R.raw.h1, 1);
            mSoundC1 = mSoundPool.load(mContext, R.raw.c1, 1);
            mSoundD1 = mSoundPool.load(mContext, R.raw.d1, 1);
            mSoundE1 = mSoundPool.load(mContext, R.raw.e1, 1);
            mSoundF1 = mSoundPool.load(mContext, R.raw.f1, 1);
            mSoundF1High = mSoundPool.load(mContext, R.raw.f1_high_g2_low, 1);
            mSoundG2 = mSoundPool.load(mContext, R.raw.g2, 1);
            mSoundA2 = mSoundPool.load(mContext, R.raw.a2, 1);
            mSoundH2 = mSoundPool.load(mContext, R.raw.h2, 1);
            mSoundC2 = mSoundPool.load(mContext, R.raw.c2, 1);
            mSoundC2High = mSoundPool.load(mContext, R.raw.c2_high_d2_low, 1);
            mSoundD2 = mSoundPool.load(mContext, R.raw.d2, 1);
            mSoundE2 = mSoundPool.load(mContext, R.raw.e2, 1);
            mSoundF2 = mSoundPool.load(mContext, R.raw.f2, 1);
            mSoundF2High = mSoundPool.load(mContext, R.raw.f2_high_g3_low, 1);
            mSoundG3 = mSoundPool.load(mContext, R.raw.g3, 1);
            mSoundG3High = mSoundPool.load(mContext, R.raw.g3_high_a3_low, 1);
            mSoundA3 = mSoundPool.load(mContext, R.raw.a3, 1);
            mSoundH3 = mSoundPool.load(mContext, R.raw.h3, 1);
            mSoundG1High = mSoundPool.load(mContext, R.raw.g1_high_a1_low, 1);
            mSoundA1High = mSoundPool.load(mContext, R.raw.a1_high_h1_low, 1);
            mSoundC1High = mSoundPool.load(mContext, R.raw.c1_high_d1_low, 1);
            mSoundD1High = mSoundPool.load(mContext, R.raw.d1_high_e1_low, 1);
            mSoundG2High = mSoundPool.load(mContext, R.raw.g2_high_a2_low, 1);
            mSoundA2High = mSoundPool.load(mContext, R.raw.a2_high_h2_low, 1);
            mSoundD2High = mSoundPool.load(mContext, R.raw.d2_high_e2_low, 1);
            mSoundA3High = mSoundPool.load(mContext, R.raw.a3_high_h3_low, 1);
        } else {
            mSoundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 1);

            mSoundG1 = mSoundPool.load(mContext, R.raw.g1, 1);
            mSoundA1 = mSoundPool.load(mContext, R.raw.a1, 1);
            mSoundH1 = mSoundPool.load(mContext, R.raw.h1, 1);
            mSoundC1 = mSoundPool.load(mContext, R.raw.c1, 1);
            mSoundD1 = mSoundPool.load(mContext, R.raw.d1, 1);
            mSoundE1 = mSoundPool.load(mContext, R.raw.e1, 1);
            mSoundF1 = mSoundPool.load(mContext, R.raw.f1, 1);
            mSoundF1High = mSoundPool.load(mContext, R.raw.f1_high_g2_low, 1);
            mSoundG2 = mSoundPool.load(mContext, R.raw.g2, 1);
            mSoundA2 = mSoundPool.load(mContext, R.raw.a2, 1);
            mSoundH2 = mSoundPool.load(mContext, R.raw.h2, 1);
            mSoundC2 = mSoundPool.load(mContext, R.raw.c2, 1);
            mSoundC2High = mSoundPool.load(mContext, R.raw.c2_high_d2_low, 1);
            mSoundD2 = mSoundPool.load(mContext, R.raw.d2, 1);
            mSoundE2 = mSoundPool.load(mContext, R.raw.e2, 1);
            mSoundF2 = mSoundPool.load(mContext, R.raw.f2, 1);
            mSoundF2High = mSoundPool.load(mContext, R.raw.f2_high_g3_low, 1);
            mSoundG3 = mSoundPool.load(mContext, R.raw.g3, 1);
            mSoundG3High = mSoundPool.load(mContext, R.raw.g3_high_a3_low, 1);
            mSoundA3 = mSoundPool.load(mContext, R.raw.a3, 1);
            mSoundH3 = mSoundPool.load(mContext, R.raw.h3, 1);
            mSoundG1High = mSoundPool.load(mContext, R.raw.g1_high_a1_low, 1);
            mSoundA1High = mSoundPool.load(mContext, R.raw.a1_high_h1_low, 1);
            mSoundC1High = mSoundPool.load(mContext, R.raw.c1_high_d1_low, 1);
            mSoundD1High = mSoundPool.load(mContext, R.raw.d1_high_e1_low, 1);
            mSoundG2High = mSoundPool.load(mContext, R.raw.g2_high_a2_low, 1);
            mSoundA2High = mSoundPool.load(mContext, R.raw.a2_high_h2_low, 1);
            mSoundD2High = mSoundPool.load(mContext, R.raw.d2_high_e2_low, 1);
            mSoundA3High = mSoundPool.load(mContext, R.raw.a3_high_h3_low, 1);
        }
    }

    private int playSound(int id) {
        int soundId;
        soundId = mSoundPool.play(id, 0.9f, 0.9f, 1, 0, 1);
        return soundId;
    }

    private void stopSound(final int sound) {
        LoweringSound mLSound;
        mLSound = new LoweringSound(sound);
        mLSound.stopSound();
    }

    private class LoweringSound {
        private final int mSound;
        private float mVolume;
        Timer mTmr;

        private LoweringSound(int sound) {
            mSound = sound;
            mVolume = 0.05f;
        }

        private void stopSound() {
             mTmr = new Timer();
            TimerTask mTsk = new TimerTask() {
                public void run()
                {
                    new Handler(Looper.getMainLooper()).post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            if (mSoundPool != null)
                            {
                                if (mVolume >0.005f)
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
            mTmr.schedule(mTsk, 0, 100); //start timer
        }

        private void upDateVolume(float volume) {
            try {
                mVolume = volume - 0.005f;
                mSoundPool.setVolume(mSound, mVolume, mVolume);
            } catch (Exception e) {
                mSoundPool.stop(mSound);
                mTmr.cancel();
            }
        }
    }

    private float getBitmapPositionX(String id) {
        float textViewX = 0;
        for (int i = 0; i < mTones.size(); i++) {
            if (mTones.get(i).getId().matches(id)) {
                textViewX = mTones.get(i).getmPositionX();
                break;
            }
        }
        return textViewX;
    }

    private float getBitmapPositionY(String id) {
        float textViewY = 0;
        for (int i = 0; i < mTones.size(); i++) {
            if (mTones.get(i).getId().matches(id)) {
                textViewY = mTones.get(i).getmPositionY();
                break;
            }
        }
        return textViewY;
    }

    private float getBitmapXend(String id) {
        float textViewWidth = 0;
        for (int i = 0; i < mTones.size(); i++) {
            if (mTones.get(i).getId().matches(id)) {
                textViewWidth = mTones.get(i).getBitmapWidth() + mTones.get(i).getmPositionX();
                break;
            }
        }
        return textViewWidth;
    }

    private float getBitmapEndY(String id) {
        float textViewHeight = 0;
        for (int i = 0; i < mTones.size(); i++) {
            if (mTones.get(i).getId().matches(id)) {
                textViewHeight = mTones.get(i).getBitmapHeight() + mTones.get(i).getmPositionY();
                break;
            }
        }
        return textViewHeight;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        int action = event.getActionMasked();
        int pointerIndex;
        int pointerId;
        float x;
        float y;
        int constant = (int) mHeight / 16 / 2;
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:

                pointerIndex = event.getActionIndex();
                pointerId = event.getPointerId(pointerIndex);
                x = event.getX(pointerIndex);
                y = event.getY(pointerIndex);


                if (x >= getBitmapPositionX("G") && x <= getBitmapXend("G")
                        && y >= getBitmapPositionY("G") - constant && y <= getBitmapEndY("G") + constant) {
                    toneGIsPressing();
                    mIsGSounding = true;
                    int mStreamIdG1;
                    mStreamIdG1 = playSound(mSoundG1);
                    showPressIndicator(pointerId, mStreamIdG1, "G");
                    mSpriteList.add(new Sprite(mBitmapGStringG, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("A") && x <= getBitmapXend("A")
                        && y >= getBitmapPositionY("A") - constant && y <= getBitmapEndY("A") + constant) {
                    toneAIsPressing();
                    mIsASounding = true;
                    int mStreamIdA1;
                    mStreamIdA1 = playSound(mSoundA1);
                    showPressIndicator(pointerId, mStreamIdA1, "A");
                    mSpriteList.add(new Sprite(mBitmapGStringA, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("B") && x <= getBitmapXend("B")
                        && y >= getBitmapPositionY("B") - constant && y <= getBitmapEndY("B") + constant) {
                    toneBIsPressing();
                    mIsBSounding = true;
                    int mStreamIdH1;
                    mStreamIdH1 = playSound(mSoundH1);
                    showPressIndicator(pointerId, mStreamIdH1, "B");
                    mSpriteList.add(new Sprite(mBitmapGStringB, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }


                    break;
                } else if (x >= getBitmapPositionX("C1") && x <= getBitmapXend("C1")
                        && y >= getBitmapPositionY("C1") - constant && y <= getBitmapEndY("C1") + constant) {
                    toneC1IsPressing();
                    mIsC1Sounding = true;
                    int mStreamIdC1;
                    mStreamIdC1 = playSound(mSoundC1);
                    showPressIndicator(pointerId, mStreamIdC1, "C1");
                    mSpriteList.add(new Sprite(mBitmapGStringC1, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("D1") && x <= getBitmapXend("D1")
                        && y >= getBitmapPositionY("D1") - constant && y <= getBitmapEndY("D1") + constant) {
                    toneD1IsPressing();
                    mIsD1Sounding = true;
                    int mStreamIdD1;
                    mStreamIdD1 = playSound(mSoundD1);
                    showPressIndicator(pointerId, mStreamIdD1, "D1");
                    mSpriteList.add(new Sprite(mBitmapDStringD1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("D1GString") && x <= getBitmapXend("D1GString")
                        && y >= getBitmapPositionY("D1GString") - constant && y <= getBitmapEndY("D1GString") + constant) {
                    toneD1GStringIsPressing();
                    mIsD1GStringSounding = true;
                    int mStreamIdD1;
                    mStreamIdD1 = playSound(mSoundD1);
                    showPressIndicator(pointerId, mStreamIdD1, "D1GString");
                    mSpriteList.add(new Sprite(mBitmapGStringD1, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("E1") && x <= getBitmapXend("E1")
                        && y >= getBitmapPositionY("E1") - constant && y <= getBitmapEndY("E1") + constant) {
                    toneE1IsPressing();
                    mIsE1Sounding = true;
                    int mStreamIdE1;
                    mStreamIdE1 = playSound(mSoundE1);
                    showPressIndicator(pointerId, mStreamIdE1, "E1");
                    mSpriteList.add(new Sprite(mBitmapDStringE1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("F1") && x <= getBitmapXend("F1")
                        && y >= getBitmapPositionY("F1") - constant && y <= getBitmapEndY("F1") + constant) {
                    toneF1IsPressing();
                    mIsF1Sounding = true;
                    int mStreamIdF1;
                    mStreamIdF1 = playSound(mSoundF1);
                    showPressIndicator(pointerId, mStreamIdF1, "F1");
                    mSpriteList.add(new Sprite(mBitmapDStringF1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("F1#") && x <= getBitmapXend("F1#")
                        && y >= getBitmapPositionY("F1#") - constant && y <= getBitmapEndY("F1#") + constant) {
                    toneF1HighIsPressing();
                    mIsF1HighSounding = true;
                    int mStreamIdF1High;
                    mStreamIdF1High = playSound(mSoundF1High);
                    showPressIndicator(pointerId, mStreamIdF1High, "F1#");
                    mSpriteList.add(new Sprite(mBitmapDStringF1High, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("G1") && x <= getBitmapXend("G1")
                        && y >= getBitmapPositionY("G1") - constant && y <= getBitmapEndY("G1") + constant) {
                    toneG1IsPressing();
                    mIsG1Sounding = true;
                    int mStreamIdG2;
                    mStreamIdG2 = playSound(mSoundG2);
                    showPressIndicator(pointerId, mStreamIdG2, "G1");
                    mSpriteList.add(new Sprite(mBitmapDStringG1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("A1DString") && x <= getBitmapXend("A1DString")
                        && y >= getBitmapPositionY("A1DString") - constant && y <= getBitmapEndY("A1DString") + constant) {
                    toneA1DStringIsPressing();
                    misA1DStringSounding = true;
                    int mStreamIdA2;
                    mStreamIdA2 = playSound(mSoundA2);
                    showPressIndicator(pointerId, mStreamIdA2, "A1DString");
                    mSpriteList.add(new Sprite(mBitmapDStringA1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("A1") && x <= getBitmapXend("A1")
                        && y >= getBitmapPositionY("A1") - constant && y <= getBitmapEndY("A1") + constant) {
                    toneA1IsPressing();
                    mIsA1Sounding = true;
                    int mStreamIdA2;
                    mStreamIdA2 = playSound(mSoundA2);
                    showPressIndicator(pointerId, mStreamIdA2, "A1");
                    mSpriteList.add(new Sprite(mBitmapAStringA1, pointerId, getXposition() + mWidth / 100 * 59.5f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("B1") && x <= getBitmapXend("B1")
                        && y >= getBitmapPositionY("B1") - constant && y <= getBitmapEndY("B1") + constant) {
                    toneB1IsPressing();
                    mIsB1Sounding = true;
                    int mStreamIdH2;
                    mStreamIdH2 = playSound(mSoundH2);
                    showPressIndicator(pointerId, mStreamIdH2, "B1");
                    mSpriteList.add(new Sprite(mBitmapAStringB1, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("C2") && x <= getBitmapXend("C2")
                        && y >= getBitmapPositionY("C2") - constant && y <= getBitmapEndY("C2") + constant) {
                    toneC2IsPressing();
                    mIsC2Sounding = true;
                    int mStreamIdC2;
                    mStreamIdC2 = playSound(mSoundC2);
                    showPressIndicator(pointerId, mStreamIdC2, "C2");
                    mSpriteList.add(new Sprite(mBitmapAStringC2, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("C2#") && x <= getBitmapXend("C2#")
                        && y >= getBitmapPositionY("C2#") - constant && y <= getBitmapEndY("C2#") + constant) {
                    toneC2HighIsPressing();
                    mIsC2HighSounding = true;
                    int mStreamIdC2High;
                    mStreamIdC2High = playSound(mSoundC2High);
                    showPressIndicator(pointerId, mStreamIdC2High, "C2#");
                    mSpriteList.add(new Sprite(mBitmapAStringC2High, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("D2") && x <= getBitmapXend("D2")
                        && y >= getBitmapPositionY("D2") - constant && y <= getBitmapEndY("D2") + constant) {
                    toneD2IsPressing();
                    mIsD2Sounding = true;
                    int mStreamIdD2;
                    mStreamIdD2 = playSound(mSoundD2);
                    showPressIndicator(pointerId, mStreamIdD2, "D2");
                    mSpriteList.add(new Sprite(mBitmapAStringD2, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("E2") && x <= getBitmapXend("E2")
                        && y >= getBitmapPositionY("E2") - constant && y <= getBitmapEndY("E2") + constant) {
                    toneE2IsPressing();
                    mIsE2Sounding = true;
                    int mStreamIdE2;
                    mStreamIdE2 = playSound(mSoundE2);
                    showPressIndicator(pointerId, mStreamIdE2, "E2");
                    mSpriteList.add(new Sprite(mBitmapEStringE2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("F2") && x <= getBitmapXend("F2")
                        && y >= getBitmapPositionY("F2") - constant && y <= getBitmapEndY("F2") + constant) {
                    toneF2IsPressing();
                    mIsF2Sounding = true;
                    int mStreamIdF2;
                    mStreamIdF2 = playSound(mSoundF2);
                    showPressIndicator(pointerId, mStreamIdF2, "F2");
                    mSpriteList.add(new Sprite(mBitmapEStringF2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("F2#") && x <= getBitmapXend("F2#")
                        && y >= getBitmapPositionY("F2#") - constant && y <= getBitmapEndY("F2#") + constant) {
                    toneF2HighIsPressing();
                    mIsF2HighSounding = true;
                    int mStreamIdF2High;
                    mStreamIdF2High = playSound(mSoundF2High);
                    showPressIndicator(pointerId, mStreamIdF2High, "F2#");
                    mSpriteList.add(new Sprite(mBitmapEStringF2High, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("G2") && x <= getBitmapXend("G2")
                        && y >= getBitmapPositionY("G2") - constant && y <= getBitmapEndY("G2") + constant) {
                    toneG2IsPressing();
                    mIsG2Sounding = true;
                    int mStreamIdG3;
                    mStreamIdG3 = playSound(mSoundG3);
                    showPressIndicator(pointerId, mStreamIdG3, "G2");
                    mSpriteList.add(new Sprite(mBitmapEStringG2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("G2#") && x <= getBitmapXend("G2#")
                        && y >= getBitmapPositionY("G2#") - constant && y <= getBitmapEndY("G2#") + constant) {
                    toneG2HighIsPressing();
                    mIsG2HighSonding = true;
                    int mStreamIdG3High;
                    mStreamIdG3High = playSound(mSoundG3High);
                    showPressIndicator(pointerId, mStreamIdG3High, "G2#");
                    mSpriteList.add(new Sprite(mBitmapEStringG2High, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("A2") && x <= getBitmapXend("A2")
                        && y >= getBitmapPositionY("A2") - constant && y <= getBitmapEndY("A2") + constant) {
                    toneA2IsPressing();
                    mIsA2Sounding = true;
                    int mStreamIdA3;
                    mStreamIdA3 = playSound(mSoundA3);
                    showPressIndicator(pointerId, mStreamIdA3, "A2");
                    mSpriteList.add(new Sprite(mBitmapEStringA2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("B2") && x <= getBitmapXend("B2")
                        && y >= getBitmapPositionY("B2") - constant && y <= getBitmapEndY("B2") + constant) {
                    toneB2IsPressing();
                    mIsB2Soundin = true;
                    int mStreamIdH3;
                    mStreamIdH3 = playSound(mSoundH3);
                    showPressIndicator(pointerId, mStreamIdH3, "B2");
                    mSpriteList.add(new Sprite(mBitmapEStringB2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("G#") && x <= getBitmapXend("G#")
                        && y >= getBitmapPositionY("G#") - constant && y <= getBitmapEndY("G#") + constant) {
                    toneGHighIsPressing();
                    mIsGHighSounding = true;
                    int mStreamIdG1High;
                    mStreamIdG1High = playSound(mSoundG1High);
                    showPressIndicator(pointerId, mStreamIdG1High, "G#");
                    mSpriteList.add(new Sprite(mBitmapGStringGHigh, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    //}
                    break;
                } else if (x >= getBitmapPositionX("A#") && x <= getBitmapXend("A#")
                        && y >= getBitmapPositionY("A#") - constant && y <= getBitmapEndY("A#") + constant) {
                    toneAHighIsPressing();
                    mIsAHighSounding = true;
                    int mStreamIdA1High;
                    mStreamIdA1High = playSound(mSoundA1High);
                    showPressIndicator(pointerId, mStreamIdA1High, "A#");
                    mSpriteList.add(new Sprite(mBitmapGStringAHigh, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("C1#") && x <= getBitmapXend("C1#")
                        && y >= getBitmapPositionY("C1#") - constant && y <= getBitmapEndY("C1#") + constant) {
                    toneC1HighIsPressing();
                    mIsC1HighSounding = true;
                    int mStreamIdC1High;
                    mStreamIdC1High = playSound(mSoundC1High);
                    showPressIndicator(pointerId, mStreamIdC1High, "C1#");
                    mSpriteList.add(new Sprite(mBitmapGStringC1High, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    //}
                    break;
                } else if (x >= getBitmapPositionX("D1#") && x <= getBitmapXend("D1#")
                        && y >= getBitmapPositionY("D1#") - constant && y <= getBitmapEndY("D1#") + constant) {
                    toneD1HighIsPressing();
                    mIsD1HighSounding = true;
                    int mStreamIdD1High;
                    mStreamIdD1High = playSound(mSoundD1High);
                    showPressIndicator(pointerId, mStreamIdD1High, "D1#");
                    mSpriteList.add(new Sprite(mBitmapDStringD1High, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("G1#") && x <= getBitmapXend("G1#")
                        && y >= getBitmapPositionY("G1#") - constant && y <= getBitmapEndY("G1#") + constant) {
                    toneG1HighIsPressing();
                    mIsG1HighSonding = true;
                    int mStreamIdG2High;
                    mStreamIdG2High = playSound(mSoundG2High);
                    showPressIndicator(pointerId, mStreamIdG2High, "G1#");
                    mSpriteList.add(new Sprite(mBitmapDStringG1High, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("A1#") && x <= getBitmapXend("A1#")
                        && y >= getBitmapPositionY("A1#") - constant && y <= getBitmapEndY("A1#") + constant) {
                    toneA1HighIsPressing();
                    mIsA1HighSounding = true;
                    int mStreamIdA2High;
                    mStreamIdA2High = playSound(mSoundA2High);
                    showPressIndicator(pointerId, mStreamIdA2High, "A1#");
                    mSpriteList.add(new Sprite(mBitmapAStringA1High, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("D2#") && x <= getBitmapXend("D2#")
                        && y >= getBitmapPositionY("D2#") - constant && y <= getBitmapEndY("D2#") + constant) {
                    toneD2HighIsPressing();
                    mIsD2HighSounding = true;
                    int mStreamIdD2High;
                    mStreamIdD2High = playSound(mSoundD2High);
                    showPressIndicator(pointerId, mStreamIdD2High, "D2#");
                    mSpriteList.add(new Sprite(mBitmapAStringD2High, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("A2#") && x <= getBitmapXend("A2#")
                        && y >= getBitmapPositionY("A2#") - constant && y <= getBitmapEndY("A2#") + constant) {
                    toneA2HighIsPressing();
                    miSA2HighSounding = true;
                    int mStreamIdA3High;
                    mStreamIdA3High = playSound(mSoundA3High);
                    showPressIndicator(pointerId, mStreamIdA3High, "A2#");
                    mSpriteList.add(new Sprite(mBitmapEStringA2High, pointerId, getXposition() + mWidth / 100 * 85f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("E2AString") && x <= getBitmapXend("E2AString")
                        && y >= getBitmapPositionY("E2AString") - constant && y <= getBitmapEndY("E2AString") + constant) {
                    toneE2AStringIsPressing();
                    mIsE2AStringSounding = true;
                    int mStreamIdE2;
                    mStreamIdE2 = playSound(mSoundE2);
                    showPressIndicator(pointerId, mStreamIdE2, "E2AString");
                    mSpriteList.add(new Sprite(mBitmapAStringE2, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                }
                break;

            case MotionEvent.ACTION_POINTER_DOWN:

                pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                pointerId = event.getPointerId(pointerIndex);
                x = event.getX(pointerIndex);
                y = event.getY(pointerIndex);
                //constant = (int) mHeight / 16 / 2;

                if (x >= getBitmapPositionX("G") && x <= getBitmapXend("G")
                        && y >= getBitmapPositionY("G") - constant && y <= getBitmapEndY("G") + constant) {
                    toneGIsPressing();
                    mIsGSounding = true;
                    int mStreamIdG1;
                    mStreamIdG1 = playSound(mSoundG1);
                    showPressIndicator(pointerId, mStreamIdG1, "G");
                    mSpriteList.add(new Sprite(mBitmapGStringG, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("A") && x <= getBitmapXend("A")
                        && y >= getBitmapPositionY("A") - constant && y <= getBitmapEndY("A") + constant) {
                    toneAIsPressing();
                    mIsASounding = true;
                    int mStreamIdA1;
                    mStreamIdA1 = playSound(mSoundA1);
                    showPressIndicator(pointerId, mStreamIdA1, "A");
                    mSpriteList.add(new Sprite(mBitmapGStringA, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("B") && x <= getBitmapXend("B")
                        && y >= getBitmapPositionY("B") - constant && y <= getBitmapEndY("B") + constant) {
                    toneBIsPressing();
                    mIsBSounding = true;
                    int mStreamIdH1;
                    mStreamIdH1 = playSound(mSoundH1);
                    showPressIndicator(pointerId, mStreamIdH1, "B");
                    mSpriteList.add(new Sprite(mBitmapGStringB, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }


                    break;
                } else if (x >= getBitmapPositionX("C1") && x <= getBitmapXend("C1")
                        && y >= getBitmapPositionY("C1") - constant && y <= getBitmapEndY("C1") + constant) {
                    toneC1IsPressing();
                    mIsC1Sounding = true;
                    int mStreamIdC1;
                    mStreamIdC1 = playSound(mSoundC1);
                    showPressIndicator(pointerId, mStreamIdC1, "C1");
                    mSpriteList.add(new Sprite(mBitmapGStringC1, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("D1") && x <= getBitmapXend("D1")
                        && y >= getBitmapPositionY("D1") - constant && y <= getBitmapEndY("D1") + constant) {
                    toneD1IsPressing();
                    mIsD1Sounding = true;
                    int mStreamIdD1;
                    mStreamIdD1 = playSound(mSoundD1);
                    showPressIndicator(pointerId, mStreamIdD1, "D1");
                    mSpriteList.add(new Sprite(mBitmapDStringD1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("D1GString") && x <= getBitmapXend("D1GString")
                        && y >= getBitmapPositionY("D1GString") - constant && y <= getBitmapEndY("D1GString") + constant) {
                    toneD1GStringIsPressing();
                    mIsD1GStringSounding = true;
                    int mStreamIdD1;
                    mStreamIdD1 = playSound(mSoundD1);
                    showPressIndicator(pointerId, mStreamIdD1, "D1GString");
                    mSpriteList.add(new Sprite(mBitmapGStringD1, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("E1") && x <= getBitmapXend("E1")
                        && y >= getBitmapPositionY("E1") - constant && y <= getBitmapEndY("E1") + constant) {
                    toneE1IsPressing();
                    mIsE1Sounding = true;
                    int mStreamIdE1;
                    mStreamIdE1 = playSound(mSoundE1);
                    showPressIndicator(pointerId, mStreamIdE1, "E1");
                    mSpriteList.add(new Sprite(mBitmapDStringE1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("F1") && x <= getBitmapXend("F1")
                        && y >= getBitmapPositionY("F1") - constant && y <= getBitmapEndY("F1") + constant) {
                    toneF1IsPressing();
                    mIsF1Sounding = true;
                    int mStreamIdF1;
                    mStreamIdF1 = playSound(mSoundF1);
                    showPressIndicator(pointerId, mStreamIdF1, "F1");
                    mSpriteList.add(new Sprite(mBitmapDStringF1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("F1#") && x <= getBitmapXend("F1#")
                        && y >= getBitmapPositionY("F1#") - constant && y <= getBitmapEndY("F1#") + constant) {
                    toneF1HighIsPressing();
                    mIsF1HighSounding = true;
                    int mStreamIdF1High;
                    mStreamIdF1High = playSound(mSoundF1High);
                    showPressIndicator(pointerId, mStreamIdF1High, "F1#");
                    mSpriteList.add(new Sprite(mBitmapDStringF1High, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("G1") && x <= getBitmapXend("G1")
                        && y >= getBitmapPositionY("G1") - constant && y <= getBitmapEndY("G1") + constant) {
                    toneG1IsPressing();
                    mIsG1Sounding = true;
                    int mStreamIdG2;
                    mStreamIdG2 = playSound(mSoundG2);
                    showPressIndicator(pointerId, mStreamIdG2, "G1");
                    mSpriteList.add(new Sprite(mBitmapDStringG1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("A1DString") && x <= getBitmapXend("A1DString")
                        && y >= getBitmapPositionY("A1DString") - constant && y <= getBitmapEndY("A1DString") + constant) {
                    toneA1DStringIsPressing();
                    misA1DStringSounding = true;
                    int mStreamIdA2;
                    mStreamIdA2 = playSound(mSoundA2);
                    showPressIndicator(pointerId, mStreamIdA2, "A1DString");
                    mSpriteList.add(new Sprite(mBitmapDStringA1, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("A1") && x <= getBitmapXend("A1")
                        && y >= getBitmapPositionY("A1") - constant && y <= getBitmapEndY("A1") + constant) {
                    toneA1IsPressing();
                    mIsA1Sounding = true;
                    int mStreamIdA2;
                    mStreamIdA2 = playSound(mSoundA2);
                    showPressIndicator(pointerId, mStreamIdA2, "A1");
                    mSpriteList.add(new Sprite(mBitmapAStringA1, pointerId, getXposition() + mWidth / 100 * 59.5f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("B1") && x <= getBitmapXend("B1")
                        && y >= getBitmapPositionY("B1") - constant && y <= getBitmapEndY("B1") + constant) {
                    toneB1IsPressing();
                    mIsB1Sounding = true;
                    int mStreamIdH2;
                    mStreamIdH2 = playSound(mSoundH2);
                    showPressIndicator(pointerId, mStreamIdH2, "B1");
                    mSpriteList.add(new Sprite(mBitmapAStringB1, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("C2") && x <= getBitmapXend("C2")
                        && y >= getBitmapPositionY("C2") - constant && y <= getBitmapEndY("C2") + constant) {
                    toneC2IsPressing();
                    mIsC2Sounding = true;
                    int mStreamIdC2;
                    mStreamIdC2 = playSound(mSoundC2);
                    showPressIndicator(pointerId, mStreamIdC2, "C2");
                    mSpriteList.add(new Sprite(mBitmapAStringC2, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("C2#") && x <= getBitmapXend("C2#")
                        && y >= getBitmapPositionY("C2#") - constant && y <= getBitmapEndY("C2#") + constant) {
                    toneC2HighIsPressing();
                    mIsC2HighSounding = true;
                    int mStreamIdC2High;
                    mStreamIdC2High = playSound(mSoundC2High);
                    showPressIndicator(pointerId, mStreamIdC2High, "C2#");
                    mSpriteList.add(new Sprite(mBitmapAStringC2High, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("D2") && x <= getBitmapXend("D2")
                        && y >= getBitmapPositionY("D2") - constant && y <= getBitmapEndY("D2") + constant) {
                    toneD2IsPressing();
                    mIsD2Sounding = true;
                    int mStreamIdD2;
                    mStreamIdD2 = playSound(mSoundD2);
                    showPressIndicator(pointerId, mStreamIdD2, "D2");
                    mSpriteList.add(new Sprite(mBitmapAStringD2, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("E2") && x <= getBitmapXend("E2")
                        && y >= getBitmapPositionY("E2") - constant && y <= getBitmapEndY("E2") + constant) {
                    toneE2IsPressing();
                    mIsE2Sounding = true;
                    int mStreamIdE2;
                    mStreamIdE2 = playSound(mSoundE2);
                    showPressIndicator(pointerId, mStreamIdE2, "E2");
                    mSpriteList.add(new Sprite(mBitmapEStringE2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("F2") && x <= getBitmapXend("F2")
                        && y >= getBitmapPositionY("F2") - constant && y <= getBitmapEndY("F2") + constant) {
                    toneF2IsPressing();
                    mIsF2Sounding = true;
                    int mStreamIdF2;
                    mStreamIdF2 = playSound(mSoundF2);
                    showPressIndicator(pointerId, mStreamIdF2, "F2");
                    mSpriteList.add(new Sprite(mBitmapEStringF2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("F2#") && x <= getBitmapXend("F2#")
                        && y >= getBitmapPositionY("F2#") - constant && y <= getBitmapEndY("F2#") + constant) {
                    toneF2HighIsPressing();
                    mIsF2HighSounding = true;
                    int mStreamIdF2High;
                    mStreamIdF2High = playSound(mSoundF2High);
                    showPressIndicator(pointerId, mStreamIdF2High, "F2#");
                    mSpriteList.add(new Sprite(mBitmapEStringF2High, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("G2") && x <= getBitmapXend("G2")
                        && y >= getBitmapPositionY("G2") - constant && y <= getBitmapEndY("G2") + constant) {
                    toneG2IsPressing();
                    mIsG2Sounding = true;
                    int mStreamIdG3;
                    mStreamIdG3 = playSound(mSoundG3);
                    showPressIndicator(pointerId, mStreamIdG3, "G2");
                    mSpriteList.add(new Sprite(mBitmapEStringG2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("G2#") && x <= getBitmapXend("G2#")
                        && y >= getBitmapPositionY("G2#") - constant && y <= getBitmapEndY("G2#") + constant) {
                    toneG2HighIsPressing();
                    mIsG2HighSonding = true;
                    int mStreamIdG3High;
                    mStreamIdG3High = playSound(mSoundG3High);
                    showPressIndicator(pointerId, mStreamIdG3High, "G2#");
                    mSpriteList.add(new Sprite(mBitmapEStringG2High, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("A2") && x <= getBitmapXend("A2")
                        && y >= getBitmapPositionY("A2") - constant && y <= getBitmapEndY("A2") + constant) {
                    toneA2IsPressing();
                    mIsA2Sounding = true;
                    int mStreamIdA3;
                    mStreamIdA3 = playSound(mSoundA3);
                    showPressIndicator(pointerId, mStreamIdA3, "A2");
                    mSpriteList.add(new Sprite(mBitmapEStringA2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("B2") && x <= getBitmapXend("B2")
                        && y >= getBitmapPositionY("B2") - constant && y <= getBitmapEndY("B2") + constant) {
                    toneB2IsPressing();
                    mIsB2Soundin = true;
                    int mStreamIdH3;
                    mStreamIdH3 = playSound(mSoundH3);
                    showPressIndicator(pointerId, mStreamIdH3, "B2");
                    mSpriteList.add(new Sprite(mBitmapEStringB2, pointerId, getXposition() + mWidth / 100 * 85.0f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("G#") && x <= getBitmapXend("G#")
                        && y >= getBitmapPositionY("G#") - constant && y <= getBitmapEndY("G#") + constant) {
                    toneGHighIsPressing();
                    mIsGHighSounding = true;
                    int mStreamIdG1High;
                    mStreamIdG1High = playSound(mSoundG1High);
                    showPressIndicator(pointerId, mStreamIdG1High, "G#");
                    mSpriteList.add(new Sprite(mBitmapGStringGHigh, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    //}
                    break;
                } else if (x >= getBitmapPositionX("A#") && x <= getBitmapXend("A#")
                        && y >= getBitmapPositionY("A#") - constant && y <= getBitmapEndY("A#") + constant) {
                    toneAHighIsPressing();
                    mIsAHighSounding = true;
                    int mStreamIdA1High;
                    mStreamIdA1High = playSound(mSoundA1High);
                    showPressIndicator(pointerId, mStreamIdA1High, "A#");
                    mSpriteList.add(new Sprite(mBitmapGStringAHigh, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                } else if (x >= getBitmapPositionX("C1#") && x <= getBitmapXend("C1#")
                        && y >= getBitmapPositionY("C1#") - constant && y <= getBitmapEndY("C1#") + constant) {
                    toneC1HighIsPressing();
                    mIsC1HighSounding = true;
                    int mStreamIdC1High;
                    mStreamIdC1High = playSound(mSoundC1High);
                    showPressIndicator(pointerId, mStreamIdC1High, "C1#");
                    mSpriteList.add(new Sprite(mBitmapGStringC1High, pointerId, getXposition() + mWidth / 100 * 3));
                    if (mTimer == null) {
                        startTimer();
                    }
                    //}
                    break;
                } else if (x >= getBitmapPositionX("D1#") && x <= getBitmapXend("D1#")
                        && y >= getBitmapPositionY("D1#") - constant && y <= getBitmapEndY("D1#") + constant) {
                    toneD1HighIsPressing();
                    mIsD1HighSounding = true;
                    int mStreamIdD1High;
                    mStreamIdD1High = playSound(mSoundD1High);
                    showPressIndicator(pointerId, mStreamIdD1High, "D1#");
                    mSpriteList.add(new Sprite(mBitmapDStringD1High, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("G1#") && x <= getBitmapXend("G1#")
                        && y >= getBitmapPositionY("G1#") - constant && y <= getBitmapEndY("G1#") + constant) {
                    toneG1HighIsPressing();
                    mIsG1HighSonding = true;
                    int mStreamIdG2High;
                    mStreamIdG2High = playSound(mSoundG2High);
                    showPressIndicator(pointerId, mStreamIdG2High, "G1#");
                    mSpriteList.add(new Sprite(mBitmapDStringG1High, pointerId, getXposition() + mWidth / 100 * 30.25f));
                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("A1#") && x <= getBitmapXend("A1#")
                        && y >= getBitmapPositionY("A1#") - constant && y <= getBitmapEndY("A1#") + constant) {
                    toneA1HighIsPressing();
                    mIsA1HighSounding = true;
                    int mStreamIdA2High;
                    mStreamIdA2High = playSound(mSoundA2High);
                    showPressIndicator(pointerId, mStreamIdA2High, "A1#");
                    mSpriteList.add(new Sprite(mBitmapAStringA1High, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("D2#") && x <= getBitmapXend("D2#")
                        && y >= getBitmapPositionY("D2#") - constant && y <= getBitmapEndY("D2#") + constant) {
                    toneD2HighIsPressing();
                    mIsD2HighSounding = true;
                    int mStreamIdD2High;
                    mStreamIdD2High = playSound(mSoundD2High);
                    showPressIndicator(pointerId, mStreamIdD2High, "D2#");
                    mSpriteList.add(new Sprite(mBitmapAStringD2High, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("A2#") && x <= getBitmapXend("A2#")
                        && y >= getBitmapPositionY("A2#") - constant && y <= getBitmapEndY("A2#") + constant) {
                    toneA2HighIsPressing();
                    miSA2HighSounding = true;
                    int mStreamIdA3High;
                    mStreamIdA3High = playSound(mSoundA3High);
                    showPressIndicator(pointerId, mStreamIdA3High, "A2#");
                    mSpriteList.add(new Sprite(mBitmapEStringA2High, pointerId, getXposition() + mWidth / 100 * 85f));

                    if (mTimer == null) {
                        startTimer();
                    }

                    break;
                } else if (x >= getBitmapPositionX("E2AString") && x <= getBitmapXend("E2AString")
                        && y >= getBitmapPositionY("E2AString") - constant && y <= getBitmapEndY("E2AString") + constant) {
                    toneE2AStringIsPressing();
                    mIsE2AStringSounding = true;
                    int mStreamIdE2;
                    mStreamIdE2 = playSound(mSoundE2);
                    showPressIndicator(pointerId, mStreamIdE2, "E2AString");
                    mSpriteList.add(new Sprite(mBitmapAStringE2, pointerId, getXposition() + mWidth / 100 * 59.5f));

                    if (mTimer == null) {
                        startTimer();
                    }
                    break;
                }
                break;

            case MotionEvent.ACTION_UP:

                pointerIndex = event.getActionIndex();
                pointerId = event.getPointerId(pointerIndex);
                int id;
                if (mCurrentSoundIdList.size() > 0)
                {
                    for (int i = 0; i < mCurrentSoundIdList.size(); i++)
                    {
                        if (mCurrentSoundIdList.get(i).getmPointerId() == pointerId) {
                            stopSound(mCurrentSoundIdList.get(i).getmSoundId());
                            id = mCurrentSoundIdList.get(i).getmPointerId();
                            deleteSprite(id);
                            if (mCurrentSoundIdList.get(i).getId().matches("G")) {
                                mIsGSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G#")) {
                                mIsGHighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A")) {
                                mIsASounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A#")) {
                                mIsAHighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("B")) {
                                mIsBSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("C1")) {
                                mIsC1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("C1#")) {
                                mIsC1HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D1GString")) {
                                mIsD1GStringSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D1")) {
                                mIsD1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D1#")) {
                                mIsD1HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("E1")) {
                                mIsE1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("F1")) {
                                mIsF1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("F1#")) {
                                mIsF1HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G1")) {
                                mIsG1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G1#")) {
                                mIsG1HighSonding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A1DString")) {
                                misA1DStringSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A1")) {
                                mIsA1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A1#")) {
                                mIsA1HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("B1")) {
                                mIsB1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("C2")) {
                                mIsC2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("C2#")) {
                                mIsC2HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D2")) {
                                mIsD2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D2#")) {
                                mIsD2HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("E2AString")) {
                                mIsE2AStringSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("E2")) {
                                mIsE2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("F2")) {
                                mIsF2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("F2#")) {
                                mIsF2HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G2")) {
                                mIsG2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G2#")) {
                                mIsG2HighSonding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A")) {
                                mIsA2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A2#")) {
                                miSA2HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("B2")) {
                                mIsB2Soundin = false;
                            }
                            mCurrentSoundIdList.remove(i);
                            break;
                        }
                    }
                }

                if (mCurrentSoundIdList.size() == 0) {
                    stopTimer();
                    if (mSpriteList.size() > 0) {
                        mSpriteList.clear();
                    }
                    invalidate();
                }

                break;

            case MotionEvent.ACTION_POINTER_UP:

                pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                pointerId = event.getPointerId(pointerIndex);
                int id2;
                if (mCurrentSoundIdList.size() > 0)
                {
                    for (int i = 0; i < mCurrentSoundIdList.size(); i++) {
                        if (mCurrentSoundIdList.get(i).getmPointerId() == pointerId) {
                            stopSound(mCurrentSoundIdList.get(i).getmSoundId());
                            id2 = mCurrentSoundIdList.get(i).getmPointerId();
                            deleteSprite(id2);
                            if (mCurrentSoundIdList.get(i).getId().matches("G")) {
                                mIsGSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G#")) {
                                mIsGHighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A")) {
                                mIsASounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A#")) {
                                mIsAHighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("B")) {
                                mIsBSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("C1")) {
                                mIsC1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("C1#")) {
                                mIsC1HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D1GString")) {
                                mIsD1GStringSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D1")) {
                                mIsD1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D1#")) {
                                mIsD1HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("E1")) {
                                mIsE1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("F1")) {
                                mIsF1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("F1#")) {
                                mIsF1HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G1")) {
                                mIsG1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G1#")) {
                                mIsG1HighSonding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A1DString")) {
                                misA1DStringSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A1")) {
                                mIsA1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A1#")) {
                                mIsA1HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("B1")) {
                                mIsB1Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("C2")) {
                                mIsC2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("C2#")) {
                                mIsC2HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D2")) {
                                mIsD2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("D2#")) {
                                mIsD2HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("E2AString")) {
                                mIsE2AStringSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("E2")) {
                                mIsE2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("F2")) {
                                mIsF2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("F2#")) {
                                mIsF2HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G2")) {
                                mIsG2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("G2#")) {
                                mIsG2HighSonding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A")) {
                                mIsA2Sounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("A2#")) {
                                miSA2HighSounding = false;
                            } else if (mCurrentSoundIdList.get(i).getId().matches("B2")) {
                                mIsB2Soundin = false;
                            }
                            mCurrentSoundIdList.remove(i);
                            break;
                        }
                    }
                }
                if (mCurrentSoundIdList.size() == 0)
                {
                    stopTimer();
                    if (mSpriteList.size() > 0)
                    {
                        mSpriteList.clear();
                    }
                    invalidate();

                break;
            }
        }
        return true;
    }

    public void stopPlayingOnRotate(final int sound) {
        mSoundPool.stop(sound);
    }

    public void onDestroy() {
        if (mSoundPool != null) {
            mSoundPool.release();
            mSoundPool = null;
        }
        recycleBitmapsTones();
        recycleBitmapStrings();
        recycleBitmapFingerboard();
    }

    public void onPause() {
        if (mCurrentSoundIdList.size() > 0) {
            try {
                for (int i = 0; i < mCurrentSoundIdList.size(); i++) {
                    stopPlayingOnRotate(mCurrentSoundIdList.get(i).getmSoundId());
                }
            } catch (Exception e) {

            }
        }
    }

    private float getXposition() {
        float positionX;
        positionX = (mScreenWidth - mWidth) / 2f;
        return positionX;
    }

    private void showPressIndicator(int pointerId, int mStreamId, String string) {
        Bitmap mBitmapPressIndicator;
        mBitmapPressIndicator = BitmapFactory.decodeResource(getResources(), R.drawable.press_indicator2);
        int height = (int) mHeight / HEIGHT_COSTANT;
        float extra = mHeight / 16 / 2;
        float extra2 = extra * 2;
        height = height + (int) extra2;
        int width = (int) mWidth / WIDTH_COSTANT;
        mBitmapPressIndicator = Bitmap.createScaledBitmap(mBitmapPressIndicator, width, height, true);
        mCurrentSoundIdList.add(new SoundInfo(pointerId, mStreamId, mBitmapPressIndicator, getBitmapPositionX(string), getBitmapPositionY(string) - extra, string));
        invalidate();
    }

    public void startTimer() {
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            public void run() {
                //Redraw must run in background thread to prevent thread lock.
                mHandler.post(new Runnable() {
                    public void run() {
                        invalidate();
                    }
                });
            }
        }; // TimerTask
        mTimer.schedule(mTimerTask, 10, 16); //start timer
    }

    private void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel(); //kill\release timer (our only background thread)
            mTimer = null;
            mTimerTask = null;
        }

    }

    public Bitmap getSpriteBitmapGString(final int yPosition) {
        Bitmap bitmap;
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.g_string_experiment), (int) mWidth / 8, (int) mHeight, true);
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap.setHasAlpha(true);
        for (int i = 0; i < pixels.length; i++) {
            if (i <= yPosition * bitmap.getWidth()) {
                pixels[i] = Color.TRANSPARENT;
            }
        }
        try {
            bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        } catch (Exception e) {

        }
        return bitmap;
    }

    public Bitmap getSpriteBitmapDString(final int yPosition) {
        Bitmap bitmap;
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.d_string_experiment), (int) mWidth / 12, (int) mHeight, true);
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap.setHasAlpha(true);
        for (int i = 0; i < pixels.length; i++) {
            if (i <= yPosition * bitmap.getWidth()) {
                pixels[i] = Color.TRANSPARENT;
            }
        }
        try {
            bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        } catch (Exception e) {

        }

        return bitmap;
    }

    public Bitmap getSpriteBitmapAString(final int yPosition) {
        Bitmap bitmap;
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.a_string_experiment), (int) mWidth / 12, (int) mHeight, true);
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap.setHasAlpha(true);
        for (int i = 0; i < pixels.length; i++) {
            if (i <= yPosition * bitmap.getWidth()) {
                pixels[i] = Color.TRANSPARENT;
            }
        }
        try {
            bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        } catch (Exception e) {

        }

        return bitmap;
    }

    public Bitmap getSpriteBitmapEString(final int yPosition) {
        Bitmap bitmap;
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.e_string_experiment), (int) mWidth / 8, (int) mHeight, true);
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap.setHasAlpha(true);
        for (int i = 0; i < pixels.length; i++) {
            if (i <= yPosition * bitmap.getWidth()) {
                pixels[i] = Color.TRANSPARENT;
            }
        }
        try {
            bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        } catch (Exception e) {

        }
        return bitmap;
    }

    private void toneGIsPressing() {

        if (mIsGHighSounding)
        {
            deleteSoundAndSprite("G#");
            mIsGHighSounding = false;
        }
        else if (mIsASounding)
        {
            deleteSoundAndSprite("A");
            mIsASounding = false;
        } else if (mIsAHighSounding) {
            deleteSoundAndSprite("A#");
            mIsAHighSounding = false;
        } else if (mIsBSounding) {
            deleteSoundAndSprite("B");
            mIsBSounding = false;
        } else if (mIsC1Sounding) {
            deleteSoundAndSprite("C1");
            mIsC1Sounding = false;
        } else if (mIsC1HighSounding) {
            deleteSoundAndSprite("C1#");
            mIsC1HighSounding = false;
        } else if (mIsD1GStringSounding) {
            deleteSoundAndSprite("D1GString");
            mIsD1GStringSounding = false;
        }
    }

    private void toneAIsPressing() {
        if (mIsGSounding) {
            deleteSoundAndSprite("G");
            mIsGSounding = false;
        } else if (mIsGHighSounding) {
            deleteSoundAndSprite("G#");
            mIsGHighSounding = false;
        } else if (mIsAHighSounding) {
            deleteSoundAndSprite("A#");
            mIsAHighSounding = false;
        } else if (mIsBSounding) {
            deleteSoundAndSprite("B");
            mIsBSounding = false;
        } else if (mIsC1Sounding) {
            deleteSoundAndSprite("C1");
            mIsC1Sounding = false;
        } else if (mIsC1HighSounding) {
            deleteSoundAndSprite("C1#");
            mIsC1HighSounding = false;
        } else if (mIsD1GStringSounding) {
            deleteSoundAndSprite("D1GString");
            mIsD1GStringSounding = false;
        }
    }

    private void toneBIsPressing() {
        if (mIsGSounding) {
            deleteSoundAndSprite("G");
            mIsGSounding = false;
        } else if (mIsGHighSounding) {
            deleteSoundAndSprite("G#");
            mIsGHighSounding = false;
        } else if (mIsASounding) {
            deleteSoundAndSprite("A");
            mIsASounding = false;
        } else if (mIsAHighSounding) {
            deleteSoundAndSprite("A#");
            mIsAHighSounding = false;
        } else if (mIsC1Sounding) {
            deleteSoundAndSprite("C1");
            mIsC1Sounding = false;
        } else if (mIsC1HighSounding) {
            deleteSoundAndSprite("C1#");
            mIsC1HighSounding = false;
        } else if (mIsD1GStringSounding) {
            deleteSoundAndSprite("D1GString");
            mIsD1GStringSounding = false;
        }
    }

    private void toneC1IsPressing() {
        if (mIsGSounding) {
            deleteSoundAndSprite("G");
            mIsGSounding = false;
        } else if (mIsGHighSounding) {
            deleteSoundAndSprite("G#");
            mIsGHighSounding = false;
        } else if (mIsASounding) {
            deleteSoundAndSprite("A");
            mIsASounding = false;
        } else if (mIsAHighSounding) {
            deleteSoundAndSprite("A#");
            mIsAHighSounding = false;
        } else if (mIsBSounding) {
            deleteSoundAndSprite("B");
            mIsBSounding = false;
        } else if (mIsC1HighSounding) {
            deleteSoundAndSprite("C1#");
            mIsC1HighSounding = false;
        } else if (mIsD1GStringSounding) {
            deleteSoundAndSprite("D1GString");
            mIsD1GStringSounding = false;
        }
    }

    private void toneD1IsPressing() {
        if (mIsD1HighSounding) {
            deleteSoundAndSprite("D1#");
            mIsD1HighSounding = false;
        } else if (mIsE1Sounding) {
            deleteSoundAndSprite("E1");
            mIsE1Sounding = false;
        } else if (mIsF1Sounding) {
            deleteSoundAndSprite("F1");
            mIsF1HighSounding = false;
        } else if (mIsF1HighSounding) {
            deleteSoundAndSprite("F1#");
            mIsF1HighSounding = false;
        } else if (mIsG1Sounding) {
            deleteSoundAndSprite("G1");
            mIsG1Sounding = false;
        } else if (mIsG1HighSonding) {
            deleteSoundAndSprite("G1#");
            mIsG1HighSonding = false;
        } else if (misA1DStringSounding) {
            deleteSoundAndSprite("A1DString");
            misA1DStringSounding = false;
        }
    }

    private void toneD1GStringIsPressing() {
        if (mIsGSounding) {
            deleteSoundAndSprite("G");
            mIsGSounding = false;
        } else if (mIsGHighSounding) {
            deleteSoundAndSprite("G#");
            mIsGHighSounding = false;
        } else if (mIsASounding) {
            deleteSoundAndSprite("A");
            mIsASounding = false;
        } else if (mIsAHighSounding) {
            deleteSoundAndSprite("A#");
            mIsAHighSounding = false;
        } else if (mIsBSounding) {
            deleteSoundAndSprite("B");
            mIsBSounding = false;
        } else if (mIsC1Sounding) {
            deleteSoundAndSprite("C1");
            mIsC1Sounding = false;
        } else if (mIsC1HighSounding) {
            deleteSoundAndSprite("C1#");
            mIsC1HighSounding = false;
        }
    }

    private void toneE1IsPressing() {
        if (mIsD1Sounding) {
            deleteSoundAndSprite("D1");
            mIsD1Sounding = false;
        } else if (mIsD1HighSounding) {
            deleteSoundAndSprite("D1#");
            mIsD1HighSounding = false;
        } else if (mIsF1Sounding) {
            deleteSoundAndSprite("F1");
            mIsF1HighSounding = false;
        } else if (mIsF1HighSounding) {
            deleteSoundAndSprite("F1#");
            mIsF1HighSounding = false;
        } else if (mIsG1Sounding) {
            deleteSoundAndSprite("G1");
            mIsG1Sounding = false;
        } else if (mIsG1HighSonding) {
            deleteSoundAndSprite("G1#");
            mIsG1HighSonding = false;
        } else if (misA1DStringSounding) {
            deleteSoundAndSprite("A1DString");
            misA1DStringSounding = false;
        }
    }

    private void toneF1IsPressing() {
        if (mIsD1Sounding) {
            deleteSoundAndSprite("D1");
            mIsD1Sounding = false;
        } else if (mIsD1HighSounding) {
            deleteSoundAndSprite("D1#");
            mIsD1HighSounding = false;
        } else if (mIsE1Sounding) {
            deleteSoundAndSprite("E1");
            mIsE1Sounding = false;
        } else if (mIsF1HighSounding) {
            deleteSoundAndSprite("F1#");
            mIsF1HighSounding = false;
        } else if (mIsG1Sounding) {
            deleteSoundAndSprite("G1");
            mIsG1Sounding = false;
        } else if (mIsG1HighSonding) {
            deleteSoundAndSprite("G1#");
            mIsG1HighSonding = false;
        } else if (misA1DStringSounding) {
            deleteSoundAndSprite("A1DString");
            misA1DStringSounding = false;
        }
    }

    private void toneF1HighIsPressing() {
        if (mIsD1Sounding) {
            deleteSoundAndSprite("D1");
            mIsD1Sounding = false;
        } else if (mIsD1HighSounding) {
            deleteSoundAndSprite("D1#");
            mIsD1HighSounding = false;
        } else if (mIsE1Sounding) {
            deleteSoundAndSprite("E1");
            mIsE1Sounding = false;
        } else if (mIsF1Sounding) {
            deleteSoundAndSprite("F1");
            mIsF1Sounding = false;
        } else if (mIsG1Sounding) {
            deleteSoundAndSprite("G1");
            mIsG1Sounding = false;
        } else if (mIsG1HighSonding) {
            deleteSoundAndSprite("G1#");
            mIsG1HighSonding = false;
        } else if (misA1DStringSounding) {
            deleteSoundAndSprite("A1DString");
            misA1DStringSounding = false;
        }
    }

    private void toneG1IsPressing() {
        if (mIsD1Sounding) {
            deleteSoundAndSprite("D1");
            mIsD1Sounding = false;
        } else if (mIsD1HighSounding) {
            deleteSoundAndSprite("D1#");
            mIsD1HighSounding = false;
        } else if (mIsE1Sounding) {
            deleteSoundAndSprite("E1");
            mIsE1Sounding = false;
        } else if (mIsF1Sounding) {
            deleteSoundAndSprite("F1");
            mIsF1Sounding = false;
        } else if (mIsF1HighSounding) {
            deleteSoundAndSprite("F1#");
            mIsF1HighSounding = false;
        } else if (mIsG1HighSonding) {
            deleteSoundAndSprite("G1#");
            mIsG1HighSonding = false;
        } else if (misA1DStringSounding) {
            deleteSoundAndSprite("A1DString");
            misA1DStringSounding = false;
        }
    }

    private void toneA1DStringIsPressing() {
        if (mIsD1Sounding) {
            deleteSoundAndSprite("D1");
            mIsD1Sounding = false;
        } else if (mIsD1HighSounding) {
            deleteSoundAndSprite("D1#");
            mIsD1HighSounding = false;
        } else if (mIsE1Sounding) {
            deleteSoundAndSprite("E1");
            mIsE1Sounding = false;
        } else if (mIsF1Sounding) {
            deleteSoundAndSprite("F1");
            mIsF1Sounding = false;
        } else if (mIsF1HighSounding) {
            deleteSoundAndSprite("F1#");
            mIsF1HighSounding = false;
        } else if (mIsG1Sounding) {
            deleteSoundAndSprite("G1");
            mIsG1Sounding = false;
        } else if (mIsG1HighSonding) {
            deleteSoundAndSprite("G1#");
            mIsG1HighSonding = false;
        }
    }

    private void toneA1IsPressing() {
        if (mIsA1HighSounding) {
            deleteSoundAndSprite("A1#");
            mIsA1HighSounding = false;
        } else if (mIsB1Sounding) {
            deleteSoundAndSprite("B1");
            mIsB1Sounding = false;
        } else if (mIsC2Sounding) {
            deleteSoundAndSprite("C2");
            mIsC2Sounding = false;
        } else if (mIsC2HighSounding) {
            deleteSoundAndSprite("C2#");
            mIsC2HighSounding = false;
        } else if (mIsD2Sounding) {
            deleteSoundAndSprite("D2");
            mIsD2Sounding = false;
        } else if (mIsD2HighSounding) {
            deleteSoundAndSprite("D2#");
            mIsD2HighSounding = false;
        } else if (mIsE2AStringSounding) {
            deleteSoundAndSprite("E2AString");
            mIsE2AStringSounding = false;
        }
    }

    private void toneB1IsPressing() {
        if (mIsA1Sounding) {
            deleteSoundAndSprite("A1");
            mIsA1Sounding = false;
        } else if (mIsA1HighSounding) {
            deleteSoundAndSprite("A1#");
            mIsA1HighSounding = false;
        } else if (mIsC2Sounding) {
            deleteSoundAndSprite("C2");
            mIsC2Sounding = false;
        } else if (mIsC2HighSounding) {
            deleteSoundAndSprite("C2#");
            mIsC2HighSounding = false;
        } else if (mIsD2Sounding) {
            deleteSoundAndSprite("D2");
            mIsD2Sounding = false;
        } else if (mIsD2HighSounding) {
            deleteSoundAndSprite("D2#");
            mIsD2HighSounding = false;
        } else if (mIsE2AStringSounding) {
            deleteSoundAndSprite("E2AString");
            mIsE2AStringSounding = false;
        }
    }

    private void toneC2IsPressing() {
        if (mIsA1Sounding) {
            deleteSoundAndSprite("A1");
            mIsA1Sounding = false;
        } else if (mIsA1HighSounding) {
            deleteSoundAndSprite("A1#");
            mIsA1HighSounding = false;
        } else if (mIsB1Sounding) {
            deleteSoundAndSprite("B1");
            mIsB1Sounding = false;
        } else if (mIsC2HighSounding) {
            deleteSoundAndSprite("C2#");
            mIsC2HighSounding = false;
        } else if (mIsD2Sounding) {
            deleteSoundAndSprite("D2");
            mIsD2Sounding = false;
        } else if (mIsD2HighSounding) {
            deleteSoundAndSprite("D2#");
            mIsD2HighSounding = false;
        } else if (mIsE2AStringSounding) {
            deleteSoundAndSprite("E2AString");
            mIsE2AStringSounding = false;
        }
    }

    private void toneC2HighIsPressing() {
        if (mIsA1Sounding) {
            deleteSoundAndSprite("A1");
            mIsA1Sounding = false;
        } else if (mIsA1HighSounding) {
            deleteSoundAndSprite("A1#");
            mIsA1HighSounding = false;
        } else if (mIsB1Sounding) {
            deleteSoundAndSprite("B1");
            mIsB1Sounding = false;
        } else if (mIsC2Sounding) {
            deleteSoundAndSprite("C2");
            mIsC2Sounding = false;
        } else if (mIsD2Sounding) {
            deleteSoundAndSprite("D2");
            mIsD2Sounding = false;
        } else if (mIsD2HighSounding) {
            deleteSoundAndSprite("D2#");
            mIsD2HighSounding = false;
        } else if (mIsE2AStringSounding) {
            deleteSoundAndSprite("E2AString");
            mIsE2AStringSounding = false;
        }
    }

    private void toneD2IsPressing() {
        if (mIsA1Sounding) {
            deleteSoundAndSprite("A1");
            mIsA1Sounding = false;
        } else if (mIsA1HighSounding) {
            deleteSoundAndSprite("A1#");
            mIsA1HighSounding = false;
        } else if (mIsB1Sounding) {
            deleteSoundAndSprite("B1");
            mIsB1Sounding = false;
        } else if (mIsC2Sounding) {
            deleteSoundAndSprite("C2");
            mIsC2Sounding = false;
        } else if (mIsC2HighSounding) {
            deleteSoundAndSprite("C2#");
            mIsC2HighSounding = false;
        } else if (mIsD2HighSounding) {
            deleteSoundAndSprite("D2#");
            mIsD2HighSounding = false;
        } else if (mIsE2AStringSounding) {
            deleteSoundAndSprite("E2AString");
            mIsE2AStringSounding = false;
        }
    }

    private void toneE2IsPressing() {
        if (mIsF2Sounding) {
            deleteSoundAndSprite("F2");
            mIsF2Sounding = false;
        } else if (mIsF2HighSounding) {
            deleteSoundAndSprite("F2#");
            mIsF2HighSounding = false;
        } else if (mIsG2Sounding) {
            deleteSoundAndSprite("G2");
            mIsG2Sounding = false;
        } else if (mIsG2HighSonding) {
            deleteSoundAndSprite("G2#");
            mIsG2HighSonding = false;
        } else if (mIsA2Sounding) {
            deleteSoundAndSprite("A2");
            mIsA2Sounding = false;
        } else if (miSA2HighSounding) {
            deleteSoundAndSprite("A2#");
            miSA2HighSounding = false;
        } else if (mIsB2Soundin) {
            deleteSoundAndSprite("B2");
            mIsB2Soundin = false;
        }
    }

    private void toneF2IsPressing() {
        if (mIsE2Sounding) {
            deleteSoundAndSprite("E2");
            mIsE2Sounding = false;
        } else if (mIsF2HighSounding) {
            deleteSoundAndSprite("F2#");
            mIsF2HighSounding = false;
        } else if (mIsG2Sounding) {
            deleteSoundAndSprite("G2");
            mIsG2Sounding = false;
        } else if (mIsG2HighSonding) {
            deleteSoundAndSprite("G2#");
            mIsG2HighSonding = false;
        } else if (mIsA2Sounding) {
            deleteSoundAndSprite("A2");
            mIsA2Sounding = false;
        } else if (miSA2HighSounding) {
            deleteSoundAndSprite("A2#");
            miSA2HighSounding = false;
        } else if (mIsB2Soundin) {
            deleteSoundAndSprite("B2");
            mIsB2Soundin = false;
        }
    }

    private void toneF2HighIsPressing() {
        if (mIsE2Sounding) {
            deleteSoundAndSprite("E2");
            mIsE2Sounding = false;
        } else if (mIsF2Sounding) {
            deleteSoundAndSprite("F2");
            mIsF2Sounding = false;
        } else if (mIsG2Sounding) {
            deleteSoundAndSprite("G2");
            mIsG2Sounding = false;
        } else if (mIsG2HighSonding) {
            deleteSoundAndSprite("G2#");
            mIsG2HighSonding = false;
        } else if (mIsA2Sounding) {
            deleteSoundAndSprite("A2");
            mIsA2Sounding = false;
        } else if (miSA2HighSounding) {
            deleteSoundAndSprite("A2#");
            miSA2HighSounding = false;
        } else if (mIsB2Soundin) {
            deleteSoundAndSprite("B2");
            mIsB2Soundin = false;
        }
    }

    private void toneG2IsPressing() {
        if (mIsE2Sounding) {
            deleteSoundAndSprite("E2");
            mIsE2Sounding = false;
        } else if (mIsF2Sounding) {
            deleteSoundAndSprite("F2");
            mIsF2Sounding = false;
        } else if (mIsF2HighSounding) {
            deleteSoundAndSprite("F2#");
            mIsF2HighSounding = false;
        } else if (mIsG2HighSonding) {
            deleteSoundAndSprite("G2#");
            mIsG2HighSonding = false;
        } else if (mIsA2Sounding) {
            deleteSoundAndSprite("A2");
            mIsA2Sounding = false;
        } else if (miSA2HighSounding) {
            deleteSoundAndSprite("A2#");
            miSA2HighSounding = false;
        } else if (mIsB2Soundin) {
            deleteSoundAndSprite("B2");
            mIsB2Soundin = false;
        }
    }

    private void toneG2HighIsPressing() {
        if (mIsE2Sounding) {
            deleteSoundAndSprite("E2");
            mIsE2Sounding = false;
        } else if (mIsF2Sounding) {
            deleteSoundAndSprite("F2");
            mIsF2Sounding = false;
        } else if (mIsF2HighSounding) {
            deleteSoundAndSprite("F2#");
            mIsF2HighSounding = false;
        } else if (mIsG2Sounding) {
            deleteSoundAndSprite("G2");
            mIsG2Sounding = false;
        } else if (mIsA2Sounding) {
            deleteSoundAndSprite("A2");
            mIsA2Sounding = false;
        } else if (miSA2HighSounding) {
            deleteSoundAndSprite("A2#");
            miSA2HighSounding = false;
        } else if (mIsB2Soundin) {
            deleteSoundAndSprite("B2");
            mIsB2Soundin = false;
        }
    }

    private void toneA2IsPressing() {
        if (mIsE2Sounding) {
            deleteSoundAndSprite("E2");
            mIsE2Sounding = false;
        } else if (mIsF2Sounding) {
            deleteSoundAndSprite("F2");
            mIsF2Sounding = false;
        } else if (mIsF2HighSounding) {
            deleteSoundAndSprite("F2#");
            mIsF2HighSounding = false;
        } else if (mIsG2Sounding) {
            deleteSoundAndSprite("G2");
            mIsG2Sounding = false;
        } else if (mIsG2HighSonding) {
            deleteSoundAndSprite("G2#");
            mIsG2HighSonding = false;
        } else if (miSA2HighSounding) {
            deleteSoundAndSprite("A2#");
            miSA2HighSounding = false;
        } else if (mIsB2Soundin) {
            deleteSoundAndSprite("B2");
            mIsB2Soundin = false;
        }
    }

    private void toneB2IsPressing() {
        if (mIsE2Sounding) {
            deleteSoundAndSprite("E2");
            mIsE2Sounding = false;
        } else if (mIsF2Sounding) {
            deleteSoundAndSprite("F2");
            mIsF2Sounding = false;
        } else if (mIsF2HighSounding) {
            deleteSoundAndSprite("F2#");
            mIsF2HighSounding = false;
        } else if (mIsG2Sounding) {
            deleteSoundAndSprite("G2");
            mIsG2Sounding = false;
        } else if (mIsG2HighSonding) {
            deleteSoundAndSprite("G2#");
            mIsG2HighSonding = false;
        } else if (mIsA2Sounding) {
            deleteSoundAndSprite("A2");
            mIsA2Sounding = false;
        } else if (miSA2HighSounding) {
            deleteSoundAndSprite("A2#");
            miSA2HighSounding = false;
        }
    }

    private void toneGHighIsPressing() {
        if (mIsGSounding) {
            deleteSoundAndSprite("G");
            mIsGSounding = false;
        } else if (mIsASounding) {
            deleteSoundAndSprite("A");
            mIsASounding = false;
        } else if (mIsAHighSounding) {
            deleteSoundAndSprite("A#");
            mIsAHighSounding = false;
        } else if (mIsBSounding) {
            deleteSoundAndSprite("B");
            mIsBSounding = false;
        } else if (mIsC1Sounding) {
            deleteSoundAndSprite("C1");
            mIsC1Sounding = false;
        } else if (mIsC1HighSounding) {
            deleteSoundAndSprite("C1#");
            mIsC1HighSounding = false;
        } else if (mIsD1GStringSounding) {
            deleteSoundAndSprite("D1GString");
            mIsD1GStringSounding = false;
        }
    }

    private void toneAHighIsPressing() {
        if (mIsGSounding) {
            deleteSoundAndSprite("G");
            mIsGSounding = false;
        } else if (mIsGHighSounding) {
            deleteSoundAndSprite("G#");
            mIsGHighSounding = false;
        } else if (mIsASounding) {
            deleteSoundAndSprite("A");
            mIsASounding = false;
        } else if (mIsBSounding) {
            deleteSoundAndSprite("B");
            mIsBSounding = false;
        } else if (mIsC1Sounding) {
            deleteSoundAndSprite("C1");
            mIsC1Sounding = false;
        } else if (mIsC1HighSounding) {
            deleteSoundAndSprite("C1#");
            mIsC1HighSounding = false;
        } else if (mIsD1GStringSounding) {
            deleteSoundAndSprite("D1GString");
            mIsD1GStringSounding = false;
        }
    }

    private void toneC1HighIsPressing() {
        if (mIsGSounding) {
            deleteSoundAndSprite("G");
            mIsGSounding = false;
        } else if (mIsGHighSounding) {
            deleteSoundAndSprite("G#");
            mIsGHighSounding = false;
        } else if (mIsASounding) {
            deleteSoundAndSprite("A");
            mIsASounding = false;
        } else if (mIsAHighSounding) {
            deleteSoundAndSprite("A#");
            mIsAHighSounding = false;
        } else if (mIsBSounding) {
            deleteSoundAndSprite("B");
            mIsBSounding = false;
        } else if (mIsC1Sounding) {
            deleteSoundAndSprite("C1");
            mIsC1Sounding = false;
        } else if (mIsD1GStringSounding) {
            deleteSoundAndSprite("D1GString");
            mIsD1GStringSounding = false;
        }
    }

    private void toneD1HighIsPressing() {
        if (mIsD1Sounding) {
            deleteSoundAndSprite("D1");
            mIsD1Sounding = false;
        } else if (mIsE1Sounding) {
            deleteSoundAndSprite("E1");
            mIsE1Sounding = false;
        } else if (mIsF1Sounding) {
            deleteSoundAndSprite("F1");
            mIsF1Sounding = false;
        } else if (mIsF1HighSounding) {
            deleteSoundAndSprite("F1#");
            mIsF1HighSounding = false;
        } else if (mIsG1Sounding) {
            deleteSoundAndSprite("G1");
            mIsG1Sounding = false;
        } else if (mIsG1HighSonding) {
            deleteSoundAndSprite("G1#");
            mIsG1HighSonding = false;
        } else if (misA1DStringSounding) {
            deleteSoundAndSprite("A1DString");
            misA1DStringSounding = false;
        }
    }

    private void toneG1HighIsPressing() {
        if (mIsD1Sounding) {
            deleteSoundAndSprite("D1");
            mIsD1Sounding = false;
        } else if (mIsD1HighSounding) {
            deleteSoundAndSprite("D1#");
            mIsD1HighSounding = false;
        } else if (mIsE1Sounding) {
            deleteSoundAndSprite("E1");
            mIsE1Sounding = false;
        } else if (mIsF1Sounding) {
            deleteSoundAndSprite("F1");
            mIsF1Sounding = false;
        } else if (mIsF1HighSounding) {
            deleteSoundAndSprite("F1#");
            mIsF1HighSounding = false;
        } else if (mIsG1Sounding) {
            deleteSoundAndSprite("G1");
            mIsG1Sounding = false;
        } else if (misA1DStringSounding) {
            deleteSoundAndSprite("A1DString");
            misA1DStringSounding = false;
        }
    }

    private void toneA1HighIsPressing() {
        if (mIsA1Sounding) {
            deleteSoundAndSprite("A1");
            mIsA1Sounding = false;
        } else if (mIsB1Sounding) {
            deleteSoundAndSprite("B1");
            mIsB1Sounding = false;
        } else if (mIsC2Sounding) {
            deleteSoundAndSprite("C2");
            mIsC2Sounding = false;
        } else if (mIsC2HighSounding) {
            deleteSoundAndSprite("C2#");
            mIsC2HighSounding = false;
        } else if (mIsD2Sounding) {
            deleteSoundAndSprite("D2");
            mIsD2Sounding = false;
        } else if (mIsD2HighSounding) {
            deleteSoundAndSprite("D2#");
            mIsD2HighSounding = false;
        } else if (mIsE2AStringSounding) {
            deleteSoundAndSprite("E2AString");
            mIsE2AStringSounding = false;
        }
    }

    private void toneD2HighIsPressing() {
        if (mIsA1Sounding) {
            deleteSoundAndSprite("A1");
            mIsA1Sounding = false;
        } else if (mIsA1HighSounding) {
            deleteSoundAndSprite("A1#");
            mIsA1HighSounding = false;
        } else if (mIsB1Sounding) {
            deleteSoundAndSprite("B1");
            mIsB1Sounding = false;
        } else if (mIsC2Sounding) {
            deleteSoundAndSprite("C2");
            mIsC2Sounding = false;
        } else if (mIsC2HighSounding) {
            deleteSoundAndSprite("C2#");
            mIsC2HighSounding = false;
        } else if (mIsD2Sounding) {
            deleteSoundAndSprite("D2");
            mIsD2Sounding = false;
        } else if (mIsE2AStringSounding) {
            deleteSoundAndSprite("E2AString");
            mIsE2AStringSounding = false;
        }
    }

    private void toneA2HighIsPressing() {
        if (mIsE2Sounding) {
            deleteSoundAndSprite("E2");
            mIsE2Sounding = false;
        } else if (mIsF2Sounding) {
            deleteSoundAndSprite("F2");
            mIsF2Sounding = false;
        } else if (mIsF2HighSounding) {
            deleteSoundAndSprite("F2#");
            mIsF2HighSounding = false;
        } else if (mIsG2Sounding) {
            deleteSoundAndSprite("G2");
            mIsG2Sounding = false;
        } else if (mIsG2HighSonding) {
            deleteSoundAndSprite("G2#");
            mIsG2HighSonding = false;
        } else if (mIsA2Sounding) {
            deleteSoundAndSprite("A2");
            mIsA2Sounding = false;
        } else if (mIsB2Soundin) {
            deleteSoundAndSprite("B2");
            mIsB2Soundin = false;

        }
    }
    private void toneE2AStringIsPressing()
    {
        if (mIsA1Sounding)
        {
            deleteSoundAndSprite("A1");
            mIsA1Sounding = false;
        }
        else if (mIsA1HighSounding)
        {
            deleteSoundAndSprite("A1#");
            mIsA1HighSounding = false;
        }
        else if (mIsB1Sounding)
        {
            deleteSoundAndSprite("B1");
            mIsB1Sounding = false;
        }
        else if (mIsC2Sounding)
        {
            deleteSoundAndSprite("C2");
            mIsC2Sounding = false;
        }
        else if (mIsC2HighSounding)
        {
            deleteSoundAndSprite("C2#");
            mIsC2HighSounding = false;
        }
        else if (mIsD2Sounding)
        {
            deleteSoundAndSprite("D2");
            mIsD2Sounding = false;
        }
        else if (mIsD2HighSounding)
        {
            deleteSoundAndSprite("D2#");
            mIsD2HighSounding = false;
        }
    }
    private void deleteSoundAndSprite(String tone) {
        int id = 0;
        for (int i = 0; i < mCurrentSoundIdList.size(); i++)
        {
            if (mCurrentSoundIdList.get(i).getId().matches(tone))
            {
                stopSound(mCurrentSoundIdList.get(i).getmSoundId());
                id = mCurrentSoundIdList.get(i).getmPointerId();
                mCurrentSoundIdList.remove(i);
                break;
            }
        }
        for (int j = 0; j < mSpriteList.size(); j++)
        {
            if (mSpriteList.get(j).getId() == id)
            {
                mSpriteList.remove(j);
                break;
            }
        }
    }
    private void deleteSprite(int id)
    {
        if (mSpriteList.size() > 0) {
            for (int j = 0; j < mSpriteList.size(); j++) {
                if (mSpriteList.get(j).getId() == id) {
                    mSpriteList.remove(j);
                    break;
                }
            }
        }
    }
    public void recycleBitmapsTones() {
        if (mBitmapToneG != null)
        {
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
    public void recycleBitmapStrings()
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
    private void recycleBitmapFingerboard()
    {
        if (mBitmapFingerBoard != null){
            mBitmapFingerBoard.recycle();
            mBitmapFingerBoard = null;
        }
    }
    public void clearToneArray()
    {
        mTones.clear();
    }

}
