package kulmedslojd.hearinggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Thomas on 2016-10-01.
 */

public class SubTone {
    private Bitmap mBitmap;
    private float mPositionX;
    private float mPositionY;
    private String mId;

    public SubTone(Bitmap bitmap, float positionX, float positionY, String id)
    {
        mBitmap = bitmap;
        mPositionX = positionX;
        mPositionY = positionY;
        mId = id;
    }

    public void drawNote(Canvas canvas)
    {
        canvas.drawBitmap(mBitmap, mPositionX, mPositionY, null);
    }
}
