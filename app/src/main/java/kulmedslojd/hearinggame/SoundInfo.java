package kulmedslojd.hearinggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Thomas on 2016-12-28.
 */

public class SoundInfo {
    private int mPointerId;
    private int mSoundId;
    private Bitmap mBitmap;
    private float mPositionX;
    private float mPositionY;
    private String mId;

    public SoundInfo(int ponterId, int soundId , Bitmap bitmap, float positionX, float positionY, String id)
    {
        mPointerId = ponterId;
        mSoundId = soundId;
        mBitmap = bitmap;
        mPositionX = positionX;
        mPositionY = positionY;
        mId = id;
    }

    public int getmPointerId()
    {
        return mPointerId;
    }

    public int getmSoundId()
    {
        return mSoundId;
    }

    public void drawPressIndicator(Canvas canvas)
    {
        canvas.drawBitmap(mBitmap, mPositionX, mPositionY, null);
    }
    public String getId()
    {
        return mId;
    }
}
