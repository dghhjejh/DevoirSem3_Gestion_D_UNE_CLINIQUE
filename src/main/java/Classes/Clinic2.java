package Classes;

import Enums.VisibleSymptom;

public class Clinic2 {
    WaitingList doctorWaitingList;
    WaitingList radiologyWaitingList;
    public Clinic2(WaitingList doctorWaitingList, WaitingList radiologyWaitingList) {
        this.doctorWaitingList = doctorWaitingList;
        this.radiologyWaitingList = radiologyWaitingList;
    }
    public void triagePatient(String patate, int i, VisibleSymptom visibleSymptom) {
        doctorWaitingList.add(patate, i, visibleSymptom);
        radiologyWaitingList.add(patate, i, visibleSymptom);
    }
}
