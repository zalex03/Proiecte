package teme.w09_exceptions_files.ex1_sensor;

import java.util.ArrayList;
import java.util.List;

//TODO!
public class AverageSensor implements Sensor {
    private int avgValue = 0;
    private boolean avgsensor;
    private List<Sensor> holdSensors = new ArrayList<>();


    public void addSensor(Sensor s) {
        holdSensors.add(s);
    }

    @Override
    public boolean isOn() {
        for (Sensor search : holdSensors
        ) {
            if (search.isOn() == false) {
                return avgsensor = false;
            }

        }
        return true;
    }

    @Override
    public void on() {
        avgsensor = true;
        for (Sensor search : holdSensors
        ) {
            if (search.isOn() == false) {
                search.on();
            }

        }
    }

    @Override
    public void off() {
        avgsensor = false;
        for (int i = 0; i < holdSensors.size(); i++) {
            if (holdSensors.get(i).isOn() == true) {
                holdSensors.get(i).off();
                if (i == 3) {
                    break;
                }
            }
        }
    }

    @Override
    public int measure() throws MeasurementException {

        if (avgsensor == false || holdSensors.isEmpty()) {
            throw new MeasurementException("SensorOffException");
        }
        /*for (Sensor search:holdSensors
             ) {
          avgValue = avgValue +  search.measure();

        }*/
        avgValue = holdSensors.stream().mapToInt(Sensor::measure).sum();
        return avgValue / holdSensors.size();
    }
}
