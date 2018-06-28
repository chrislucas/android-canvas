package canvas.xplorer.com.circularchart.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class OvalView extends View {

    private Paint paint;
    private RectF rectF;
    private float padding;
    public OvalView(Context context) {
        super(context);
        initializePaint();
    }

    public OvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializePaint();
    }

    public OvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializePaint();
    }

    private void initializePaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(padding / 20.0f);
        paint.setColor(Color.BLUE);

        /**
         * Usamos um retangulo para desenhar um elemento Oval. Se as medidas
         * dos lados do retangulo forem iguais (um quadrado) o metodo drawOval
         * desenhara um circulo
         * */
        canvas.drawOval(rectF, paint);

        paint.setStrokeWidth(padding / 15.0f);
        paint.setColor(Color.RED);
        canvas.drawRect(rectF, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        padding = Math.max(w, h) * 0.1f;
        rectF.left = padding;
        rectF.top = padding;
        rectF.right = w-padding;
        rectF.bottom = w-padding;
        //rectF = new RectF(padding, padding, w-padding, h-padding);
    }
}
