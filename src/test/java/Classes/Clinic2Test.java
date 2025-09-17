package Classes;

import Enums.VisibleSymptom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Clinic2Test {
    public static final String PATIENT_NAME = "Patate";
    public static final int GRAVITY = 4;
    private WaitingList doctorWaitingList;
    private WaitingList radiologyWaitingList;
    private Clinic2 clinic2;

    @BeforeEach
    void setUp() {
        doctorWaitingList = mock(WaitingList.class);
        radiologyWaitingList = mock(WaitingList.class);
        clinic2 = new Clinic2(doctorWaitingList, radiologyWaitingList);
    }

    @Test
    void GivenClinic_WhenTriage_Patient_ThenIsPlacedInTheWaitingList(){
        clinic2.triagePatient(PATIENT_NAME, GRAVITY, VisibleSymptom.MIGRAINE);
        verify(doctorWaitingList).add(PATIENT_NAME, GRAVITY, VisibleSymptom.MIGRAINE);
        verify(radiologyWaitingList).add(PATIENT_NAME, GRAVITY, VisibleSymptom.MIGRAINE);
    }



}
