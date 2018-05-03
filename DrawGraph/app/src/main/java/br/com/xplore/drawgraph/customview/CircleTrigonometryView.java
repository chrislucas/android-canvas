package br.com.xplore.drawgraph.customview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.Locale;

import br.com.xplore.drawgraph.geometry.Trigonometry;

public class CircleTrigonometryView extends View {

    private PointF dimension;
    private Paint mPaintCenterPoint, mPaintFloatPoint;
    private DisplayMetrics displayMetrics;

    private DoublingBufferDrawing mDoublingBufferDrawing;

    public CircleTrigonometryView(Context context) {
        super(context);
        preparePaintToDrawPointOnTouch();
    }

    public CircleTrigonometryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        preparePaintToDrawPointOnTouch();
    }

    public CircleTrigonometryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        preparePaintToDrawPointOnTouch();
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void initDoublingBufferDrawing(int w, int h, Paint paint) {
        mDoublingBufferDrawing = new DoublingBufferDrawing(paint, w, h);
    }

    // Executado antes do OnDraw
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        w -= (getPaddingLeft() + getPaddingRight());
        h -= (getPaddingTop() + getPaddingBottom());
        initDimension(w, h);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        // marcar um ponto no centro
        if (displayMetrics != null) {
            int width   = (int)dimension.x;     //displayMetrics.widthPixels;
            int height  = (int)dimension.y;     //displayMetrics.heightPixels;
            float cx = width/ 2;
            float cy = height / 2;
            int wi = width / displayMetrics.densityDpi;
            int he = height / displayMetrics.densityDpi;
            double diagonal =  Math.sqrt(wi*wi+he*he);

            // displayMetrics.density
            double diagonalInch = diagonal * displayMetrics.scaledDensity; //;
            double ppi = diagonal / diagonalInch;
            Log.i("METRICS"
                    , String.format("Diagonal %f, DiagonalInch %f, PPI %f"
                            , diagonal, diagonalInch, ppi)
            );
            float offsetX = cx + 15;
            float offsetY = cy + 15;
            canvas.drawRect(getDot(cx, cy, offsetX, offsetY), mPaintCenterPoint);
            mPaintCenterPoint.setTextSize(23.0f);
            mPaintCenterPoint.setTypeface(Typeface.DEFAULT_BOLD);
            canvas.drawText(String.format(Locale.getDefault(), "p(%.1f %.1f)", cx, cy), offsetX + 15, offsetY, mPaintCenterPoint);
        }
    }

    public RectF getDot(float left, float top, float right, float bottom) {
        return new RectF(left, top, right, bottom);
    }

    private void testMetrict() {
        // https://androidknowledgeblog.wordpress.com/2016/04/04/how-to-detect-mobile-screen-size-programatically/
        int widthPixel = displayMetrics.widthPixels;
        int heightPixel = displayMetrics.heightPixels;
        float widthDensity = widthPixel / displayMetrics.density;
        float heightDensity = heightPixel/ displayMetrics.density;
        Log.i("METRICS", String.format("W pixel %d, H pixel %d.\nDensity WH(%f, %f)"
                , widthPixel
                , heightPixel
                , widthDensity
                , heightDensity)
        );
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    private void initDimension(int w, int h) {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        preparePaintToDrawCenterPoint(w, h);
        setDimension(new PointF(w, h));
    }


    /**
     * Paint para desenhar:
     * 1) o ponto central na tela
     * 2) a sua coordena
     * 3) Limpar a tela
     * */

    private void preparePaintToDrawCenterPoint(int width, int height) {
        mPaintCenterPoint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaintCenterPoint.setStyle(Paint.Style.STROKE);
        mPaintCenterPoint.setAntiAlias(true);
        mPaintCenterPoint.setDither(true);

        mPaintCenterPoint.setStyle(Paint.Style.FILL);
        mPaintCenterPoint.setStrokeWidth(Math.min(width, height) * 0.6f);
        mPaintCenterPoint.setColor(Color.RED);
    }

    /**
     * Paint para desenhar o ponto onde o usuario toca
     * */
    private void preparePaintToDrawPointOnTouch(int width, int height) {
        mPaintFloatPoint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaintFloatPoint.setStyle(Paint.Style.STROKE);
        mPaintFloatPoint.setAntiAlias(true);
        mPaintFloatPoint.setDither(true);

        mPaintFloatPoint.setStyle(Paint.Style.FILL);
        mPaintFloatPoint.setStrokeWidth(Math.min(width, height) * 0.6f);
        mPaintFloatPoint.setColor(Color.RED);
    }


    private void clearCanvas() {
        int bg = getBackground() == null ? Color.WHITE
                : ((ColorDrawable) getBackground()).getColor();
        mPaintCenterPoint.setStyle(Paint.Style.FILL);
        mPaintCenterPoint.setColor(bg);
        mDoublingBufferDrawing.getCacheCanvas()
                .drawRect(mDoublingBufferDrawing.getRectFBlankCanvas(), mPaintCenterPoint);
        invalidate();
        initDoublingBufferDrawing((int)dimension.x, (int)dimension.y, mPaintCenterPoint);
        //preparePencilToDrawing();
    }

    public void setDimension(PointF dimension) {
        this.dimension = dimension;
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF p = new PointF(motionEvent.getX(), motionEvent.getY());
        /**
         * https://stackoverflow.com/questions/17384983/in-android-what-is-the-difference-between-getaction-and-getactionmasked-in
         * */
        int actionMasked = motionEvent.getActionMasked();
        int action = motionEvent.getAction();   // action and pointer index
        int actionAfterMasked = action & MotionEvent.ACTION_MASK;
        int pointerIndentifier = action & 0xf;
        Log.i("ON_TOUCH",
                String.format(Locale.getDefault()
                        ,"ActionMasked: %d.\nAction: %d.\nAction & Mask: %d\nPointer Indentifier %d"
                        , actionMasked, action, actionAfterMasked, pointerIndentifier)
        );
        double cx = dimension.x/2;
        double cy = dimension.y/2;
        String text = "";
        switch (actionMasked) {
            case MotionEvent.ACTION_DOWN:
                text = String.format(Locale.getDefault()
                        ,"%s\nÂngulo: %f"
                        , text, Trigonometry.angleDegBetweenPoints(cx, cy, p.x, p.y));
                Log.i("TOUCH_DOWN", text);
                break;
            case MotionEvent.ACTION_MOVE:
                break;

        }

        return true;
    }
}
