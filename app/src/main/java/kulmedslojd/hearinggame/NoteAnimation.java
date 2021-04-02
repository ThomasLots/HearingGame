package kulmedslojd.hearinggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class NoteAnimation {

    private Bitmap mBitmap;
    private int mXposition;
    private int mYposition;
    private int mWidth;
    private int mHeight;
    private static final int BMP_ROWS = 1;
    private static final int BMP_COLUMNS = 16;
    private int mUpdate = 0;
    private int mCurrentFrame = 0;

    public NoteAnimation(Bitmap bitmap, int xPosition, int yPosition)
    {
        mBitmap = bitmap;
        mXposition = xPosition;
        mYposition = yPosition;
        this.mWidth = mBitmap.getWidth() / BMP_COLUMNS ;
        this.mHeight = mBitmap.getHeight() / BMP_ROWS;
    }
    private void update()
    {
        mUpdate++;
        if (mCurrentFrame == 15)
        {
            mCurrentFrame = 0;
            mUpdate = 0;
        }
        else if(mUpdate == 10)
        {
            mCurrentFrame +=1;
            mUpdate = 0;
        }
    }
    public void drawNote(Canvas canvas)
    {

        int srcX = mCurrentFrame * mWidth;
        int srcY = 0;

        Rect src = new Rect(srcX, srcY, srcX + mWidth, srcY + mHeight);
        Rect dst = new Rect(mXposition, mYposition, mXposition + mWidth, mYposition + mHeight);
        canvas.drawBitmap(mBitmap, src, dst, null);
        update();
    }



}
