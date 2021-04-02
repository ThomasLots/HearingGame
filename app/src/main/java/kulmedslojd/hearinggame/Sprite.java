package kulmedslojd.hearinggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;

import java.util.Timer;
import java.util.TimerTask;

public class Sprite {
    private Bitmap mBitmap;
    private int mCurrentFrame = 0;
    private Timer mTimer;
    private int count = 0;
    private float mXPosition;
    private float mX;
    private int mId;
    private boolean mIsRendering = false;
    private Handler mHandler;

    public Sprite(Bitmap bitmap, int id, float x)
    {
        mX = x;
        mBitmap = bitmap;
        mId = id;
        mHandler = new Handler(Looper.getMainLooper());
    }
    public Sprite(Bitmap bitmap, float x)
    {
        mBitmap = bitmap;
        mX = x;
        mHandler = new Handler();
    }
    private void upDateAndCheckBoundaries()
    {

        if (mCurrentFrame == 4)
        {
            mCurrentFrame = 0;
        }
        if (mCurrentFrame == 0)
        {
            mXPosition = mX;
        }
        else if (mCurrentFrame == 1)
        {
            mXPosition = mX + 4;
        }
        else if (mCurrentFrame == 2)
        {
            mXPosition = mX;
        }
        else if (mCurrentFrame == 3)
        {
            mXPosition = mX - 4;
        }

    }
    public void drawSprite(Canvas canvas)
    {
        if (!mIsRendering)
        {
            startTimer();
            mIsRendering = true;
        }
        upDateAndCheckBoundaries();
        canvas.drawBitmap(mBitmap, mXPosition, 0, null);
        mCurrentFrame++;

    }
    public void drawSpriteGameView(Canvas canvas)
    {
        if (!mIsRendering)
        {
            startTimerGameView();
            mIsRendering = true;
        }
        upDateAndCheckBoundaries();
        canvas.drawBitmap(mBitmap, mXPosition, 0, null);
        mCurrentFrame++;
    }

    private void startTimer() {

        mTimer = new Timer();
        TimerTask mTimerTask = new TimerTask() {
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count == 1)
                        {
                            for (int i = 0; i< PracticeView.mSpriteList.size(); i++)
                            {
                                if (PracticeView.mSpriteList.get(i).equals(Sprite.this))
                                {
                                    mTimer.cancel();
                                    mTimer= null;
                                    PracticeView.mSpriteList.remove(i);
                                    break;
                                }
                            }
                        }
                        count++;
                    }
                });
            }
        }; // TimerTask
        mTimer.schedule(mTimerTask, 0, 3000); //start timer
    }
    private void startTimerGameView() {

        mTimer = new Timer();
        TimerTask mTimerTask = new TimerTask() {
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count == 1)
                        {
                            for (int i = 0; i< GameView.mSpriteList.size(); i++)
                            {
                                if (GameView.mSpriteList.get(i).equals(Sprite.this))
                                {
                                    mTimer.cancel();
                                    mTimer= null;
                                    GameView.mSpriteList.remove(i);
                                    break;
                                }
                            }
                        }
                        count++;
                    }
                });
            }
        }; // TimerTask
        mTimer.schedule(mTimerTask, 0, 3000); //start timer
    }

    public int getId()
    {
        return mId;
    }
}
