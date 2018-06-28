package canvas.xplorer.com.circularchart.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

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
        //drawOutsidecircle();
    }

    private void drawBorderLine() {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mPaint.setColor(Color.RED);
        this.mCanvas.drawArc(rectF, startAngle, sweepAngle, false, mPaint);
    }

    private void drawCentralCircle() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        this.mCanvas.drawOval(rectF, mPaint);
    }

    private void drawOutsidecircle() {
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.GREEN);
        this.mCanvas.drawArc(rectF, 270, 90, true, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w * 0.5f;
        cy = h * 0.5f;
        radius = Math.min(w, h) * 0.7f * 0.5f;

        mPaint.setStrokeWidth(radius * 0.3f);

        rectF.left = cx - radius;
        rectF.top = cy - radius;
        rectF.right = cx + radius;
        rectF.bottom = cy + radius;
    }
}
