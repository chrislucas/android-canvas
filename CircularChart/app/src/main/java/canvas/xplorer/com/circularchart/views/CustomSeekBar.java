package canvas.xplorer.com.circularchart.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

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
        float value = (getProgress() * 1.0f / getMax() * 1.0f) * (getWidth() * 1.0f);
        mPaint.setTextSize(35.0f);

        int h = getHeight();
        int b = getBottom();
        int t = getTop();
        int w = getWidth();

        canvas.drawText(String.format(Locale.getDefault(), "%d", getProgress()), value, getHeight(), mPaint);
    }
}
