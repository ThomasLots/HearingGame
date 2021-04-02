package kulmedslojd.hearinggame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class MessageDialog extends View {

    Bitmap mBitmap;
    private NoteAnimation mNoteAnimation;
    private int mHeight;
    private int mWidth;
    private final Handler mRedrawHandler = new Handler(Looper.getMainLooper());

    public MessageDialog(Context context)
     {
         super(context);
     }

    public MessageDialog(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    private void initAnimation()
    {
        int mWidthBitmap;
        mWidthBitmap = mWidth * 6;
        int mHeightBitmap;
        mHeightBitmap = mHeight/3;
        mBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ny_sprite1_small), mWidthBitmap, mHeightBitmap, true);
        int frameWidth = mWidthBitmap / 16;
        int frameHeight = mHeightBitmap;
        int yPosition = mHeight / 2 - frameHeight/2;
        int xPosition = mWidth/2 - frameWidth/2;
        mNoteAnimation = new NoteAnimation(mBitmap, xPosition, yPosition );
        startTimer();
    }

    public void drawNote(Canvas canvas)
    {
        mNoteAnimation.drawNote(canvas);
    }

    public void startTimer()
    {
        Timer mTmr;
        mTmr = new Timer();
        TimerTask mTsk;
        mTsk = new TimerTask()
        {
            public void run()
            {
                //Redraw must run in background thread to prevent thread lock.
                mRedrawHandler.post(new Runnable() {
                    public void run() {
                        invalidate();
                    }});
            }}; // TimerTask
        mTmr.schedule(mTsk,0,16); //start timer
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        mWidth = getWidth();
        mHeight = getHeight();

        if (mBitmap != null)
        {
            drawNote(canvas);
        }
        else
        {
            initAnimation();
        }

    }
}
