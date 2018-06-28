package canvas.xplorer.com.circularchart.sensor.event;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import canvas.xplorer.com.circularchart.sensor.event.action.SensorEventListenerCallback;

public class ImpleSensorEventListener implements SensorEventListener {


    private SensorEventListenerCallback sensorEventListenerCallback;

    public ImpleSensorEventListener(SensorEventListenerCallback sensorEventListenerCallback) {
        this.sensorEventListenerCallback = sensorEventListenerCallback;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        this.sensorEventListenerCallback.onSensorChanged(event);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        this.sensorEventListenerCallback.onAccuracyChanged(sensor, accuracy);
    }
}
