package Classes;

import Enums.VisibleSymptom;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Clinic {

    private ArrayDeque<String> doctorWaitingList;
    private ArrayDeque<String> radioWaitingList;

    public Clinic() {
        this.doctorWaitingList = new ArrayDeque<>();
        this.radioWaitingList = new ArrayDeque<>();
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if (visibleSymptom == VisibleSymptom.SPRAIN || visibleSymptom == VisibleSymptom.BROKEN_BONE) {
            radioWaitingList.add(name);
        }
        doctorWaitingList.add(name);
    }

    public boolean isDoctorWaitingListEmpty() {
        return doctorWaitingList.isEmpty();
    }

    public boolean isRadioWaitingListEmpty() {
        return radioWaitingList.isEmpty();
    }

    public String getFirstPatientInDoctorWaitingList() {
        return doctorWaitingList.removeFirst();
    }

    public String getFirstPatientInRadioWaitingList() {
        return radioWaitingList.removeFirst();
    }



}