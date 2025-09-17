package Classes;

import Enums.VisibleSymptom;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class DoctorWaintingList implements WaitingList{
    public static final int THRESHOLD_OF_GRAVITY = 5;
    private final Deque<Patient> waitingList;
    private final ArrayList<Patient> patientsWithWorstGravity;
    public DoctorWaintingList() {
        this.waitingList = new ArrayDeque<>();
        this.patientsWithWorstGravity = new ArrayList<>();
    }

    @Override
    public void add(String patientName, int gravity, VisibleSymptom visibleSymptom) {
        Patient patient = new Patient(patientName, gravity, visibleSymptom);
        if (gravity > THRESHOLD_OF_GRAVITY) {
            patientsWithWorstGravity.add(patient);
            patientsWithWorstGravity.sort((p1, p2) -> Integer.compare(p2.getGravity(), p1.getGravity()));
            return;
        }
        waitingList.addLast(patient);
    }


    public String retrievePatient() {
        if (!patientsWithWorstGravity.isEmpty()) {
            Patient mostSeverePatient = patientsWithWorstGravity.remove(0);
            return mostSeverePatient.getName();
        }
        if (waitingList.isEmpty()) {
            return null;
        }
        return waitingList.pollFirst().getName();
    }

    public int getNumberOfPatients() {
        return waitingList.size() + patientsWithWorstGravity.size();
    }
}


