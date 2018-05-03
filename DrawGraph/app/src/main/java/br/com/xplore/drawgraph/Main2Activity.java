package br.com.xplore.drawgraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity implements View.OnTouchListener {

    private int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /*
        WindowManager windowManager = getWindow().getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        */

        width = getWindow().getDecorView().getWidth();
        height = getWindow().getDecorView().getHeight();


        Log.i("DIMENSION", String.format(Locale.getDefault(), "(%d, %d)", width, height));


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        /**
         * https://stackoverflow.com/questions/17384983/in-android-what-is-the-difference-between-getaction-and-getactionmasked-in
         * */
        int actionMasked = motionEvent.getActionMasked();
        int action = motionEvent.getAction();   // action and pointer index
        int actionAfterMasked = action & MotionEvent.ACTION_MASK;
        Log.i("ON_TOUCH",
                String.format(Locale.getDefault()
                ,"ActionMasked: %d.\nAction: %d.\nAction & Mask: %d"
                , actionMasked, action, actionAfterMasked)
        );

        return true;
    }
}
