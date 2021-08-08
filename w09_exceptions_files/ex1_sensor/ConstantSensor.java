package teme.w09_exceptions_files.ex1_sensor;

//TODO!
public class ConstantSensor implements Sensor {
    private int value;
    private boolean sensor = true;

    public int getValue() {
        return value;
    }


    public boolean isSensor() {
        return sensor;
    }

    public ConstantSensor(int value) {
        this.value = value;
    }

    @Override
    public boolean isOn() {
        return sensor;
    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public int measure() throws MeasurementException {
        if (sensor == false) {
            throw new MeasurementException("SensorOffException");
        }
        return getValue();
    }
}
