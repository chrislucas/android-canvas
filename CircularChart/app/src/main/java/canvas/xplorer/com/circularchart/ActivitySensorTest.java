package canvas.xplorer.com.circularchart;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;

import canvas.xplorer.com.circularchart.sensor.event.ImpleSensorEventListener;
import canvas.xplorer.com.circularchart.sensor.event.action.SensorEventListenerCallback;


public class ActivitySensorTest extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor mSensorMotionDetect, mSensorRotationVector, mSensorGravity, mSensorGeomagneticRotationVector;

    private SensorEventListener sensorEventListener;


    private TextView textAccuracy, textValuesSensorRotationVector
            , textValuesGeomagneticSensorRotationVector,  textValuesSensorRotationGravity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test);
        textAccuracy = findViewById(R.id.text_view_accuracy);
        textValuesSensorRotationVector = findViewById(R.id.values_sensor_rotation_vector);
        textValuesGeomagneticSensorRotationVector = findViewById(R.id.values_geomagnetic_sensor_rotation_vector);
        textValuesSensorRotationGravity = findViewById(R.id.values_sensor_gravity);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager != null) {

            mSensorRotationVector = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            mSensorGravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
            mSensorGeomagneticRotationVector = sensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);

            sensorEventListener = new ImpleSensorEventListener(new SensorEventListenerCallback() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    int sensorType = event.sensor.getType();

                    if (sensorType == Sensor.TYPE_ROTATION_VECTOR) {
                        float [] values = event.values;
                        String message = String.format(Locale.getDefault()
                                , "Rotation Vector.\n%f (x * sin(theta/2))\n%f (y * sin(theta/2))\n" +
                                        "%f (z * sin(theta/2))\nScalar %f(cos(theta/2)"
                                , values[0], values[1], values[2], values[3]);
                        textValuesSensorRotationVector.setText(message);
                        //Log.i("SENSOR_ROTATION_VECTOR", message);
                    }

                    else if (sensorType == Sensor.TYPE_GRAVITY) {
                        float [] values = event.values;
                        String message = String.format(Locale.getDefault()
                                , "Gravity.\nG Force X %f.\nG Force Y %f.\nG Force Z %f."
                                , values[0], values[1], values[2]);
                        textValuesSensorRotationGravity.setText(message);
                        //Log.i("SENSOR_GRAVITY", message);
                    }

                    else if (sensorType == Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR) {
                        float [] values = event.values;
                        String message = String.format(Locale.getDefault()
                                , "Geomagneti Rotation Vector.\n%f (x * sin(theta/2))\n%f (y * sin(theta/2))\n" +
                                        "%f (z * sin(theta/2))\nScalar %f(cos(theta/2)"
                                , values[0], values[1], values[2], values[3]);
                        textValuesGeomagneticSensorRotationVector.setText(message);
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {
                    String message = String.format(Locale.getDefault()
                            , "Precisão %d", accuracy);
                    textAccuracy.setText(message);
                    Log.i("ACCURACY_SENSOR", message);
                }
            });


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mSensorMotionDetect = sensorManager.getDefaultSensor(Sensor.TYPE_MOTION_DETECT);
                sensorManager.registerDynamicSensorCallback(new SensorManager.DynamicSensorCallback() {
                    @Override
                    public void onDynamicSensorConnected(Sensor sensor) {
                        super.onDynamicSensorConnected(sensor);
                    }

                    @Override
                    public void onDynamicSensorDisconnected(Sensor sensor) {
                        super.onDynamicSensorDisconnected(sensor);
                    }
                });
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this
                , "Registrando Listener para o sensor de Rotation Vector"
                , Toast.LENGTH_SHORT).show();
        sensorManager.registerListener(sensorEventListener
                , mSensorRotationVector, SensorManager.SENSOR_DELAY_NORMAL);

        sensorManager.registerListener(sensorEventListener
                , mSensorGravity, 150000);


        sensorManager.registerListener(sensorEventListener
                , mSensorGeomagneticRotationVector, 200000);

        if (mSensorMotionDetect != null) {
            Toast.makeText(this
                    , "Registrando Listener para o sensor de Gravidade"
                    , Toast.LENGTH_SHORT).show();
            sensorManager.registerListener(sensorEventListener
                    , mSensorMotionDetect, 250000);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this
                , "Removendo registro do Listener para o sensor"
                , Toast.LENGTH_SHORT).show();
        sensorManager.unregisterListener(sensorEventListener);
    }
}
