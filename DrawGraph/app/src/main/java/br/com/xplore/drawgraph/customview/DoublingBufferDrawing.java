package br.com.xplore.drawgraph.customview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.Random;

/**
 * Created by r028367 on 12/01/2018.
 */

public class DoublingBufferDrawing {
    // Bitmap que eh usado de cache para pintar uma View ou surfaceview
    private final Bitmap cacheBitmap;
    // canvas que eh usado de cache para pintar uma view ou surfaceview
    private final Canvas cacheCanvas;
    private final Paint mPaintDrawing;
    // dimensao da view que sera pintada
    private final int widthCanvas, heightCanvas;
    // retangulo usando para repintar uma view com um tamanho especifico
    private final RectF rectFBlankCanvas;

    public DoublingBufferDrawing(Paint mPaintDrawing, int widthCanvas, int heightCanvas) {
        this.mPaintDrawing = mPaintDrawing;
        this.widthCanvas = widthCanvas;
        this.heightCanvas = heightCanvas;
        rectFBlankCanvas = new RectF(0,0, widthCanvas, heightCanvas);
        cacheBitmap = Bitmap.createBitmap(widthCanvas, heightCanvas, Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        cacheCanvas.setBitmap(cacheBitmap);
    }

    public Bitmap getCacheBitmap() {
        return cacheBitmap;
    }

    public Canvas getCacheCanvas() {
        return cacheCanvas;
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
}
