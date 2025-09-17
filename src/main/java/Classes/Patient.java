package Classes;

import Enums.VisibleSymptom;

public class Patient {

    private VisibleSymptom symptom;
    private String name;
    private int gravity;
    public Patient(String name, int gravity, VisibleSymptom symptom) {
        this.name = name;
        this.gravity = gravity;
        this.symptom = symptom;
    }

    public VisibleSymptom getSymptom() {
        return symptom;
    }
    public String getName() {
        return name;
    }
    public int getGravity() {
        return gravity;
    }
}
