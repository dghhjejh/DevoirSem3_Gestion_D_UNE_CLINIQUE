package Classes;

import Enums.VisibleSymptom;

public interface WaitingList {
    void add(String patientName, int gravity, VisibleSymptom visibleSymptom);
}
