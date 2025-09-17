package Classes;

import Enums.VisibleSymptom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadiologyWaitingListTest {

    public static final String PATIENT_NAME = "Patient1";
    public static final int GRAVITY = 5;
    public static final String PATIENT_2 = "Patient2";
    public static final String PATIENT_3 = "Patient3";
    public static final String PATIENT_4 = "Patient4";
    RadiologyWaitingList radiologyWaitingList;
    @BeforeEach
    void setUp() {
        radiologyWaitingList = new RadiologyWaitingList();
    }

    @Test
    void givenAnEmptyWaitingList_whenAddingPatient_thenThePatientIsAddedToTheList() {
        radiologyWaitingList.add(PATIENT_NAME, GRAVITY, VisibleSymptom.BROKEN_BONE);
       assertEquals(1, radiologyWaitingList.getNumberOfPatients());
    }

    @Test
    void givenAnEmptyList_whenRetrievingPatient_thenShouldReturnNull() {
        assertNull(radiologyWaitingList.retrievePatient());
    }

   @Test
    void givenOnePatientInTheList_whenRetrievingPatient_thenShouldReturnPatient() {
        radiologyWaitingList.add(PATIENT_NAME, GRAVITY, VisibleSymptom.BROKEN_BONE);
        String patient = radiologyWaitingList.retrievePatient();
        assertEquals(PATIENT_NAME, patient);
    }

    @Test
    void givenManyPatientsInTheList_whenRetrievingPatients_thenShouldBeInOrder() {
        radiologyWaitingList.add(PATIENT_NAME, GRAVITY, VisibleSymptom.BROKEN_BONE);
        radiologyWaitingList.add(PATIENT_2, GRAVITY, VisibleSymptom.BROKEN_BONE);
        radiologyWaitingList.add(PATIENT_3, GRAVITY, VisibleSymptom.BROKEN_BONE);

        assertEquals(PATIENT_NAME, radiologyWaitingList.retrievePatient());
        assertEquals(PATIENT_2, radiologyWaitingList.retrievePatient());
        assertEquals(PATIENT_3, radiologyWaitingList.retrievePatient());
        assertNull(radiologyWaitingList.retrievePatient());
    }

    @Test
    void GivenAnEmptyList_whenAddingAPatientWithSymptomsDifferent_FromBrokenBoneOrSprain_ThenThePatientShouldNoteAddedToTheList() {
        radiologyWaitingList.add(PATIENT_NAME, GRAVITY, VisibleSymptom.MIGRAINE);
        assertEquals(0, radiologyWaitingList.getNumberOfPatients());
    }

    @Test
    void GivenManyPatientsInTheList_whenAddingPatientsWithSymptomsDifferent_FromBrokenBoneOrSprain_ThenThePatientsShouldNotBeAddedToTheList() {
        radiologyWaitingList.add(PATIENT_NAME, GRAVITY, VisibleSymptom.BROKEN_BONE);
        radiologyWaitingList.add(PATIENT_2, GRAVITY, VisibleSymptom.MIGRAINE);
        radiologyWaitingList.add(PATIENT_3, GRAVITY, VisibleSymptom.SPRAIN);
        radiologyWaitingList.add(PATIENT_4, GRAVITY, VisibleSymptom.CHEST_PAIN);

        assertEquals(2, radiologyWaitingList.getNumberOfPatients());
        assertEquals(PATIENT_NAME, radiologyWaitingList.retrievePatient());
        assertEquals(PATIENT_3, radiologyWaitingList.retrievePatient());
        assertNull(radiologyWaitingList.retrievePatient());
    }
}