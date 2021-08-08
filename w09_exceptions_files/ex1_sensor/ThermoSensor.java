package teme.w09_exceptions_files.ex1_sensor;

//TODO!
public class ThermoSensor implements Sensor {
    int value;
    boolean sensor;

    public int getValue() {
        return value;
    }

    public boolean isSensor() {
        return sensor;
    }

    public void setSensor(boolean sensor) {
        this.sensor = sensor;
    }

    public ThermoSensor() {
    }

    public ThermoSensor(int value) {
        this.value = value;
    }

    @Override
    public boolean isOn() {

        return sensor;
    }

    @Override
    public void on() {
        setSensor(true);
    }

    @Override
    public void off() {
        setSensor(false);
    }

    @Override
    public int measure() throws MeasurementException {
        int max = 30;
        int min = -30;
        int random = (int) (Math.random() * ((max - min) + 1)) + min;
        if (isSensor() == false) {
            throw new MeasurementException("SensorOffException");
        }

        return random;
    }
}
