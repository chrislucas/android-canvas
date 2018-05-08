package br.com.xplore.drawgraph.customview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
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

import br.com.xplore.drawgraph.geometry.TrigonometryAdjustDeviceCoordinate;

public class CircleTrigonometryView extends View {

    private Point dimension, touched;
    private Paint mPaintDrawOnCanvas;
    private DisplayMetrics displayMetrics;

    private DoublingBufferDrawing mDoublingBufferDrawing;
    private Matrix mIdentity = new Matrix();

    private static final int OFFSET_DRAW_RECT_PX = 30; // px
    private static final int OFFSET_DRAW_TEXT_PX = 15; // px
    private static final float FONT_SIZE = 23f;


    private static final String BUNDLE_LAST_POINT_TOUCHED = "BUNDLE_LAST_POINT_TOUCHED";

    private Paint defaultConfig() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setDither(true);
        return paint;
    }

    private void init() {
        mPaintDrawOnCanvas = defaultConfig();
        touched = new Point(-1, -1);
    }

    private void setDoublingBufferDrawing() {
        mDoublingBufferDrawing = new DoublingBufferDrawing(mPaintDrawOnCanvas, dimension.x, dimension.y);
    }

    public CircleTrigonometryView(Context context) {
        super(context);
        init();
    }

    public CircleTrigonometryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public CircleTrigonometryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * Executado depois do onMeasure
     * Executado antes do OnDraw
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        w -= (getPaddingLeft() + getPaddingRight());
        h -= (getPaddingTop() + getPaddingBottom());
        // definir dimensao da area de dsenho
        setDimensionCanvas(w, h);
        // preparar o buffer de desenho para recebe-lo
        setDoublingBufferDrawing();
        // desenhar o ponto no centro da tela sempre que rotaciona-la
        drawDotOnCenterScreen();
        if (touched.x != -1 && touched.y != -1) {
            // desenhar o ponto que foi tocado na tela
            drawDotOnTouch();
        }
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mDoublingBufferDrawing.getCacheBitmap(), mIdentity, mPaintDrawOnCanvas);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        /*
        if (state instanceof  Bundle) {
            touched = ((Bundle) state).getParcelable(BUNDLE_LAST_POINT_TOUCHED);
        }
        */
        if (state instanceof  SaveStateTrigonometryCustomView) {
            SaveStateTrigonometryCustomView s = (SaveStateTrigonometryCustomView) state;
            touched = s.getPoint();
        }
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable p = super.onSaveInstanceState();
        /*
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_LAST_POINT_TOUCHED, touched);
        return bundle;
        */
        SaveStateTrigonometryCustomView savedState = new SaveStateTrigonometryCustomView(p);
        savedState.setPoint(touched);
        return savedState;
    }

    private void setDimensionCanvas(int w, int h) {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        setDimension(new Point(w, h));
    }


    /**
     * Configuracao padrao para desenhar
     * */
    private void defaultPaintToDraw() {
        mPaintDrawOnCanvas.setStyle(Paint.Style.FILL);
        mPaintDrawOnCanvas.setStrokeWidth(Math.min(dimension.x, dimension.y) * 0.6f);
        mPaintDrawOnCanvas.setColor(Color.RED);
    }

    /**
     * Paint para desenhar:
     * 1) o ponto central na tela
     * 2) a sua coordena
     * 3) Limpar a tela
     * */

    private void preparePaintToDrawCenterPoint() {
        defaultPaintToDraw();
    }

    /**
     * Paint para desenhar o ponto onde o usuario toca
     * */
    private void preparePaintToDrawOnTouch() {
        defaultPaintToDraw();
    }

    private void preparePaintToWriteTextAngle() {
        defaultPaintToDraw();
    }

    private void clearCanvas() {
        int bg = getBackground() == null ? Color.WHITE
                : ((ColorDrawable) getBackground()).getColor();
        // configurando a canera para pintar a area de desenho inteira
        mPaintDrawOnCanvas.setStyle(Paint.Style.FILL);
        // com a cor de fundo padrao da view
        mPaintDrawOnCanvas.setColor(bg);
        // definindo buffer de pintura com as definicoes da caneta (COR, DIMENSAO)
        // e o formato do desenho (Um retangulo que vai preencher a tela inteira)
        mDoublingBufferDrawing.getCacheCanvas()
                .drawRect(mDoublingBufferDrawing.getRectFBlankCanvas(), mPaintDrawOnCanvas);
        // invalida a view inteira para ser recriada
        invalidate();
        setDoublingBufferDrawing();
    }

    public void setDimension(Point dimension) {
        this.dimension = dimension;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        /**
         * https://stackoverflow.com/questions/17384983/in-android-what-is-the-difference-between-getaction-and-getactionmasked-in
         * */
        int actionMasked = motionEvent.getActionMasked();
        double cx = dimension.x/2;
        double cy = dimension.y/2;
        double px = Math.floor(motionEvent.getX());
        double py = Math.floor(motionEvent.getY());
        touched.x = (int)px;
        touched.y = (int)py;

        double angleA   = TrigonometryAdjustDeviceCoordinate.circularAngleDegBetweenPoints(cx, cy, px, py);
        double angleB   = TrigonometryAdjustDeviceCoordinate.angleDegreeBetweenPointsUsingDotProduct(cx, cy, px, py);
        double radians  = TrigonometryAdjustDeviceCoordinate.circularAngleRadBetweenPoints(cx, cy, px, py);
        String text = String.format(Locale.getDefault()
                ,"\nCentro (%f, %f).\nToque (%f, %f)\nÂngulo: %f.\nÂngulo PV: %f.\nRadianos: %f"
                , cx
                , cy
                , px
                , py
                , angleA
                , angleB
                , radians
        );

        switch (actionMasked) {
            case MotionEvent.ACTION_DOWN:
                Log.i("ON_TOUCH", text.concat("\nACTION_DOWN"));
            case MotionEvent.ACTION_MOVE:
                Log.i("ON_TOUCH", text.concat("\nACTION_MOVE"));
                clearCanvas();
                drawDotOnTouch();
                drawDotOnCenterScreen();
                drawTextAngle(angleA, angleB, radians);
                break;
        }

        return true;
    }

    private void drawDotOnTouch() {
        preparePaintToDrawOnTouch();
        float tx = touched.x, ty = touched.y;
        float offsetX = tx + OFFSET_DRAW_RECT_PX;
        float offsetY = ty + OFFSET_DRAW_RECT_PX;
        Canvas canvas = mDoublingBufferDrawing.getCacheCanvas();
        drawDot(canvas, tx, ty, offsetX, offsetY);

        // mudando a configuracao da caneta para escrever o local do ponto tocado na tela
        mPaintDrawOnCanvas.setTextSize(FONT_SIZE);
        mPaintDrawOnCanvas.setTypeface(Typeface.DEFAULT_BOLD);
        String textPositionPoint = String.format(Locale.getDefault(), "p(%.0f, %.0f)", tx, ty);
        canvas.drawText(textPositionPoint
                , offsetX + OFFSET_DRAW_TEXT_PX, offsetY, mPaintDrawOnCanvas);
    }

    private void drawDotOnCenterScreen() {
        // prepara a caneta para desenhar um ponto no centro da tela
        preparePaintToDrawCenterPoint();
        // marcar um ponto no centro
        if (displayMetrics != null) {
            float cx = dimension.x / 2;
            float cy = dimension.y / 2;
            float offsetX = cx + OFFSET_DRAW_RECT_PX;
            float offsetY = cy + OFFSET_DRAW_RECT_PX;
            Canvas canvas = mDoublingBufferDrawing.getCacheCanvas();
            drawDot(canvas, cx, cy, offsetX, offsetY);

            // Mudando a configuracao da caneta para escrever um texto
            mPaintDrawOnCanvas.setTextSize(FONT_SIZE);
            mPaintDrawOnCanvas.setTypeface(Typeface.DEFAULT_BOLD);
            String textPositionPoint = String.format(Locale.getDefault(), "c(%.0f, %.0f)", cx, cy);
            canvas.drawText(textPositionPoint
                    , offsetX + OFFSET_DRAW_TEXT_PX, offsetY, mPaintDrawOnCanvas);
        }
    }

    private void drawDot(Canvas canvas, float left, float top, float right, float bottom) {
        RectF dot = new RectF(left, top, right, bottom);
        canvas.drawRect(dot, mPaintDrawOnCanvas);
    }

    private void drawTextAngle(double angleA, double angleB, double radians) {
        preparePaintToWriteTextAngle();
        float offsetX = dimension.x / 2 + OFFSET_DRAW_RECT_PX;
        float offsetY = dimension.y / 2 + OFFSET_DRAW_RECT_PX;
        // Mudando a configuracao da caneta para escrever um texto
        mPaintDrawOnCanvas.setTextSize(FONT_SIZE);
        mPaintDrawOnCanvas.setTypeface(Typeface.DEFAULT_BOLD);
        Canvas canvas = mDoublingBufferDrawing.getCacheCanvas();

        String textPositionPoint = String.format(Locale.getDefault(), "atan2: %f", angleA);
        drawText(canvas
                , mPaintDrawOnCanvas
                , textPositionPoint
                , offsetX + OFFSET_DRAW_TEXT_PX * 2
                , offsetY - OFFSET_DRAW_TEXT_PX * 3);

        textPositionPoint = String.format(Locale.getDefault(), "Radianos: %f", radians);
        drawText(canvas
                , mPaintDrawOnCanvas
                , textPositionPoint
                , offsetX + OFFSET_DRAW_TEXT_PX * 2
                , offsetY - OFFSET_DRAW_TEXT_PX * 6);


        textPositionPoint = String.format(Locale.getDefault(), "Angulo PV: %f", angleB);
        drawText(canvas
                , mPaintDrawOnCanvas
                , textPositionPoint
                , offsetX + OFFSET_DRAW_TEXT_PX * 2
                , offsetY - OFFSET_DRAW_TEXT_PX * 9);
    }

    private void drawText(Canvas canvas, Paint paint, String text, float offsetX, float offsetY) {
        canvas.drawText(text, offsetX, offsetY, paint);
    }


    private void logMetrics() {
        int wi = dimension.x / displayMetrics.densityDpi;
        int he = dimension.y / displayMetrics.densityDpi;
        double diagonal =  Math.sqrt(wi*wi+he*he);
        // displayMetrics.density
        double diagonalInch = diagonal * displayMetrics.scaledDensity; //;
        double ppi = diagonal / diagonalInch;
        Log.i("METRICS"
                , String.format("Diagonal %f, DiagonalInch %f, PPI %f"
                        , diagonal, diagonalInch, ppi)
        );
    }

    private void logMptionEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();   // action and pointer index
        int actionAfterMasked = action & MotionEvent.ACTION_MASK;
        int pointerIndentifier = action & 0xf;
        int actionMasked = motionEvent.getActionMasked();
        Log.i("ON_TOUCH",
                String.format(Locale.getDefault()
                        ,"ActionMasked: %d.\nAction: %d.\nAction & Mask: %d\nPointer Indentifier %d"
                        , actionMasked
                        , action
                        , actionAfterMasked
                        , pointerIndentifier
                )
        );
    }

}
