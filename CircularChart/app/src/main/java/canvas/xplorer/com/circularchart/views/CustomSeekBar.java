package canvas.xplorer.com.circularchart.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

import java.util.Locale;


public class CustomSeekBar extends android.support.v7.widget.AppCompatSeekBar {

    private Paint mPaint;

    public CustomSeekBar(Context context) {
        super(context);
        initializePaint();
    }

    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializePaint();
    }

    public CustomSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializePaint();
    }

    private void initializePaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float value = (float) Math.floor((getProgress() * 1.0f / getMax() * 1.0f) * (getWidth() * 1.0f));
        mPaint.setTextSize(35.0f);
        int h = getHeight();
        int b = getBottom();
        int t = getTop();
        int w = getWidth();
        Rect thumb = getThumb().getBounds();
        Log.i("THUMB_SEEK_BAR"
                , String.format("Center x: %d, Center y: %d.\nLeft: %d.\nTop: %d." +
                                "\nRight: %d.\nBottom: %d"
                    , thumb.centerX()
                    , thumb.centerY()
                    , thumb.left
                    , thumb.top
                    , thumb.right
                    , thumb.bottom
                )
        );
        value = value - Math.abs(thumb.left - thumb.right);
        Log.i("SEEK_BAR"
                , String.format("%d %d %d %d Value: %f", h, b, t, w, value));
        canvas.drawText(String.format(Locale.getDefault()
                , "%d", getProgress()), thumb.centerX(), thumb.centerY() - 60, mPaint);
    }
}
