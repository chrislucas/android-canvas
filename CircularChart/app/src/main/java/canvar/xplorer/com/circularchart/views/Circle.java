package canvar.xplorer.com.circularchart.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import canvar.xplorer.com.circularchart.R;

public class Circle extends View {


    private Paint paint;
    private int cx, cy;
    private float radius;

    public Circle(Context context) {
        super(context);
        initPaint();
    }

    public Circle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Circle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.cx = w / 2;
        this.cy = h / 2;
        SweepGradient gradient = new SweepGradient(cx, cy
                , getResources().getColor(R.color.a), getResources().getColor(R.color.b));

        this.paint.setShader(gradient);
        this.radius = Math.min(w, h) * .7f *.5f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(radius * 0.3f);
        paint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawCircle(cx, cy, radius, paint);
    }
}
