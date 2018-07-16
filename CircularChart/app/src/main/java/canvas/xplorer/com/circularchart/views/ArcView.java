package canvas.xplorer.com.circularchart.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Locale;

import canvas.xplorer.com.circularchart.R;

public class ArcView extends View {

    private Paint mPaint;
    private RectF rectF;

    private Canvas mCanvas;

    private float cx, cy, radius, startAngle, sweepAngle;

    public ArcView(Context context) {
        super(context);
        initializePaint();
    }

    public ArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializePaint();
    }

    private void initializePaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        rectF = new RectF();
        startAngle = 90;
        sweepAngle = 90;
    }

    public void redefineStartAngle(float startAngle) {
        this.startAngle = startAngle;
        invalidate();
    }

    public void redefineSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
        invalidate();
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mCanvas = canvas;
        drawCentralCircle();
        drawBorderLine();
        //drawOutsideCircle();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ContextCompat.getColor(getContext(), R.color.LIGHT_VIOLET));
        this.mPaint.setTextSize(28f);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        String message =String.format(Locale.getDefault(), "%.2f"
                , sweepAngle / 360.0f * 100.0f);
        Log.i("ON_DRAW", message);
        this.mCanvas.drawText(message, cx, cy, mPaint);
    }

    private void drawBorderLine() {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mPaint.setColor(ContextCompat.getColor(getContext(), R.color.LIGHT_GREEN));
        this.mCanvas.drawArc(rectF, startAngle, sweepAngle, false, mPaint);
    }

    private void drawCentralCircle() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.LIGHT_VIOLET));
        this.mCanvas.drawOval(rectF, mPaint);
    }

    private void drawOutsideCircle() {
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mCanvas.drawArc(rectF, startAngle, sweepAngle, true, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w * 0.5f;
        cy = h * 0.5f;
        radius = Math.min(w, h) * 0.7f * 0.5f;
        mPaint.setStrokeWidth(radius * 0.3f);
        rectF.left      = cx - radius;
        rectF.top       = cy - radius;
        rectF.right     = cx + radius;
        rectF.bottom    = cy + radius;
    }
}
