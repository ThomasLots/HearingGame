package kulmedslojd.hearinggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Thomas on 2016-02-28.
 */
public class Tone
{
    private Bitmap mBitmap;
    private float mPositionX;
    private float mPositionY;
    private String mId;

    public Tone(Bitmap bitmap, float positionX, float positionY, String id)
    {
        mBitmap = bitmap;
        mPositionX = positionX;
        mPositionY = positionY;
        mId = id;
    }

    public float getBitmapHeight()
    {
        return mBitmap.getHeight();
    }

    public float getBitmapWidth()
    {
        return mBitmap.getWidth();
    }

    public float getmPositionX()
    {
        return mPositionX;
    }

    public float getmPositionY()
    {
        return mPositionY;
    }

    public String getId()
    {
        return mId;
    }

    public void drawNote(Canvas canvas)
    {
        canvas.drawBitmap(mBitmap, mPositionX, mPositionY, null);
    }
}
