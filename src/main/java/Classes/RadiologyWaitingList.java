package Classes;

import Enums.VisibleSymptom;

import java.util.ArrayDeque;
import java.util.Deque;

public class RadiologyWaitingList implements WaitingList{
    String patient = null;
    final Deque<String> waitingList;
    public RadiologyWaitingList() {
        waitingList = new ArrayDeque<>();
    }
    @Override
    public void add(String patientName, int gravity, VisibleSymptom visibleSymptom) {
        if(visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN){
            waitingList.addLast(patientName);
        }
    }

    public int getNumberOfPatients() {
        return waitingList.size();
    }

    public String retrievePatient() {
        return waitingList.pollFirst();
    }
}
