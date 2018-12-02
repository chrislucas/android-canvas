package canvas.xplorer.com.drawingandusingsensors.views;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class HeartView extends View {


    private Paint mPaint;

    public HeartView(Context context) {
        super(context);
    }

    public HeartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    private void initializePaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }
}
