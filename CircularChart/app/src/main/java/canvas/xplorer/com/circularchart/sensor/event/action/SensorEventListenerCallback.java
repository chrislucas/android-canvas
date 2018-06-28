package canvas.xplorer.com.circularchart.sensor.event.action;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public interface SensorEventListenerCallback {
    void onSensorChanged(SensorEvent event);
    void onAccuracyChanged(Sensor sensor, int accuracy);
}
