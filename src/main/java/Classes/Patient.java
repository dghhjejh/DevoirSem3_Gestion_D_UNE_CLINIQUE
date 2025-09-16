package Classes;

import Enums.VisibleSymptom;

public class Patient {

    private VisibleSymptom symptom;

    public Patient(VisibleSymptom symptom) {
        this.symptom = symptom;
    }

    public VisibleSymptom getSymptom() {
        return symptom;
    }
}
