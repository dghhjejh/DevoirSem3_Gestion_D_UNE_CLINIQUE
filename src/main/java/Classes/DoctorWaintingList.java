package Classes;

import Enums.VisibleSymptom;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoctorWaintingList implements WaitingList{
    private final Deque<String> waitingList;

    public DoctorWaintingList() {
        this.waitingList = new ArrayDeque<>();
    }

    @Override
    public void add(String patientName, int gravity, VisibleSymptom visibleSymptom) {
        waitingList.addLast(patientName);
    }


    public String retrievePatient() {
        return waitingList.pollFirst();
    }

    public int getNumberOfPatients() {
        return waitingList.size();
    }
}


