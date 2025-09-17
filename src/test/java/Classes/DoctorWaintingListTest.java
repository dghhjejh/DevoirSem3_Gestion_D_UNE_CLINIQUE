package Classes;

import Enums.VisibleSymptom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorWaintingListTest {

    public static final String PATIENT_NAME = "Patate";
    public static final int GRAVITY = 4;
    public static final VisibleSymptom SYMPTOM = VisibleSymptom.MIGRAINE;
    public static final String PATIENT_1 = "Patate1";
    public static final String PATIENT_2 = "Patate2";
    public static final String PATIENT_3 = "Patate3";
    DoctorWaintingList doctorWaintingList;

    @BeforeEach
    void setUp() {
        doctorWaintingList = new DoctorWaintingList();
    }
    @Test
    void GivenAnEmptyWaitingList_WhenAddingPatient_thenShouldBeAddedInTheList(){
        doctorWaintingList.add(PATIENT_NAME, GRAVITY, SYMPTOM);
        assertEquals(1, doctorWaintingList.getNumberOfPatients());
    }

    @Test
    void GivenOnePatientInTheList_WhenRetrievingPatient_thenPatientShouldBeRetrieved(){
        doctorWaintingList.add(PATIENT_NAME, GRAVITY, SYMPTOM);
        String patient = doctorWaintingList.retrievePatient();
        assertEquals(PATIENT_NAME, patient);
    }
    @Test
    void GivenAnEmptyList_WhenRetrievingPatient_thenShouldReturnNull(){
        assertNull(doctorWaintingList.retrievePatient());
    }

    @Test
    void GivenManyElementsInTheList_WhenRetrievingPatients_thenPatientsShouldBeRetrievedInOrder(){
        doctorWaintingList.add(PATIENT_1, GRAVITY, SYMPTOM);
        doctorWaintingList.add(PATIENT_2, GRAVITY, SYMPTOM);
        doctorWaintingList.add(PATIENT_3, GRAVITY, SYMPTOM);

        assertEquals(PATIENT_1, doctorWaintingList.retrievePatient());
        assertEquals(PATIENT_2, doctorWaintingList.retrievePatient());
        assertEquals(PATIENT_3, doctorWaintingList.retrievePatient());
        assertNull(doctorWaintingList.retrievePatient());
    }


}