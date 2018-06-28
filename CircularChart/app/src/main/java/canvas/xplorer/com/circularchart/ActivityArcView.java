package canvas.xplorer.com.circularchart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import canvas.xplorer.com.circularchart.views.ArcView;

public class ActivityArcView extends AppCompatActivity {

    private SeekBar barStartAngle, barSweepAngle;

    private ArcView arcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc_view);

        arcView = findViewById(R.id.arc);

        barStartAngle = findViewById(R.id.start_angle);
        setChangeListener(barStartAngle, new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                arcView.redefineStartAngle(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        barSweepAngle = findViewById(R.id.sweep_angle);
        setChangeListener(barSweepAngle, new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                arcView.redefineSweepAngle(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }


    private void setChangeListener(SeekBar seekBar, SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }
}
