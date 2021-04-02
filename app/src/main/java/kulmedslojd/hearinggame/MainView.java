package kulmedslojd.hearinggame;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Thomas on 2017-02-07.
 */

public class MainView extends View{
    private Bitmap mBitmapNeck;
    private float mWidth;
    private float  mHeight;
    private float mScreenWidth;
    private MainActivity mMainActivity;
    public MainView(Context context)
    {
        super(context);
    }

    public MainView(Context context, AttributeSet attrib)
    {
        super(context, attrib);
        mMainActivity = (MainActivity)context;
    }

    private void initBimapNeck()
    {
                mBitmapNeck = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.greppbrada_stor), (int)mWidth, (int)mHeight, true);
    }

    @Override
    public void onDraw(final Canvas canvas)
    {
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
                mWidth = getWidth();
            }
            else
            {
                mWidth = mScreenWidth / 2;
            }

        }
        recycleBitmapFingerboard();
        initBimapNeck();
        canvas.drawBitmap(mBitmapNeck, getXposition(), 0, null);
    }
    // hej
    public float getXposition()
    {
        float mPositionX;
        mPositionX = (mScreenWidth - mWidth) /  2f;
        return  mPositionX;
    }
    private void recycleBitmapFingerboard()
    {
        if (mBitmapNeck != null){
            mBitmapNeck.recycle();
            mBitmapNeck = null;
        }
    }
}
