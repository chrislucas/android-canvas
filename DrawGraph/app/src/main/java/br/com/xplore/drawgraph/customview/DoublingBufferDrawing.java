package br.com.xplore.drawgraph.customview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by r028367 on 12/01/2018.
 */

public class DoublingBufferDrawing {
    // Bitmap que eh usado de cache para pintar uma View ou surfaceview
    private final Bitmap mCacheBitmap;
    // canvas que eh usado de cache para pintar uma view ou surfaceview
    private final Canvas mCacheCanvas;
    private final Paint mPaintDrawing;
    // dimensao da view que sera pintada
    private final int widthCanvas, heightCanvas;
    // retangulo usando para repintar uma view com um tamanho especifico
    private final RectF rectFBlankCanvas;

    private Matrix mIdentity;

    public DoublingBufferDrawing(Paint mPaintDrawing, int widthCanvas, int heightCanvas) {
        this.mPaintDrawing = mPaintDrawing;
        this.widthCanvas = widthCanvas;
        this.heightCanvas = heightCanvas;
        rectFBlankCanvas = new RectF(0,0, widthCanvas, heightCanvas);
        mCacheBitmap = Bitmap.createBitmap(widthCanvas, heightCanvas, Bitmap.Config.ARGB_8888);
        mCacheCanvas = new Canvas();
        mCacheCanvas.setBitmap(mCacheBitmap);
        mIdentity = new Matrix();
    }

    public Bitmap getCacheBitmap() {
        return mCacheBitmap;
    }

    public Canvas getCacheCanvas() {
        return mCacheCanvas;
    }

    public RectF getRectFBlankCanvas() {
        return rectFBlankCanvas;
    }

    public int getHeightCanvas() {
        return heightCanvas;
    }

    public int getWidthCanvas() {
        return widthCanvas;
    }

    public Paint getmPaintDrawing() {
        return mPaintDrawing;
    }

    public Matrix getMatrixIdentity() {
        return mIdentity;
    }
}
