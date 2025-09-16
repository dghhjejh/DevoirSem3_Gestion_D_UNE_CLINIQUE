package Classes;

import Enums.TriageType;
import Enums.VisibleSymptom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {

    final static String PATIENT_NAME = "Jimothy";
    final static String OTHER_PATIENT_NAME = "Jimin";
    final static int GRAVITY = 7;
    Clinic gravityClinic;
    Clinic FIFOClinic;

    @BeforeEach
    void setUp() {
        gravityClinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);
        FIFOClinic = new Clinic(TriageType.FIFO, TriageType.FIFO);
    }

    @Test
    void GivenNewClinic_WhenNoPatients_ThenWaitingListsAreEmpty() {
        assertTrue(FIFOClinic.isRadioWaitingListEmpty());
        assertTrue(FIFOClinic.isDoctorWaitingListEmpty());
    }

    @ParameterizedTest
    @EnumSource(value = VisibleSymptom.class, names = {
            "COLD",
            "FLU",
            "EBOLA",
            "CHEST_PAIN",
            "MIGRAINE",
            "CORONAVIRUS"})
    void WhenPatientWithoutSprainBrokenBoneArrives_ThenDoctorListNotEmptyAndRadioListEmpty(VisibleSymptom symptom) {
        FIFOClinic.triagePatient(PATIENT_NAME, GRAVITY, symptom);
        assertFalse(FIFOClinic.isDoctorWaitingListEmpty());
        assertTrue(FIFOClinic.isRadioWaitingListEmpty());
    }

    @ParameterizedTest
    @EnumSource(value = VisibleSymptom.class, names = {
            "SPRAIN",
            "BROKEN_BONE"})
    void WhenPatientWithSprainBrokenBoneArrives_ThenRadioListNotEmpty(VisibleSymptom symptom) {
        FIFOClinic.triagePatient(PATIENT_NAME, GRAVITY, symptom);
        assertFalse(FIFOClinic.isDoctorWaitingListEmpty());
        assertFalse(FIFOClinic.isRadioWaitingListEmpty());
    }

    @Test
    void WhenPatientSprainArrives_ThenBothWaitingListsNotEmpty(){
        FIFOClinic.triagePatient(PATIENT_NAME, GRAVITY, VisibleSymptom.SPRAIN);
        assertFalse(FIFOClinic.isDoctorWaitingListEmpty());
        assertFalse(FIFOClinic.isRadioWaitingListEmpty());
    }

    @Test
    void GivenPatientsInDoctorWaitingList_WhenPatientArrives_ThenPatientsAreInOrder() {
        FIFOClinic.triagePatient(PATIENT_NAME, GRAVITY, VisibleSymptom.FLU);
        FIFOClinic.triagePatient(OTHER_PATIENT_NAME, GRAVITY, VisibleSymptom.MIGRAINE);
        assertEquals(PATIENT_NAME, FIFOClinic.getFirstPatientInDoctorWaitingList());
        assertEquals(OTHER_PATIENT_NAME, FIFOClinic.getFirstPatientInDoctorWaitingList());
    }

    @Test
    void GivenPatientsInRadioWaitingList_WhenPatientArrives_ThenPatientsAreInOrder() {
        FIFOClinic.triagePatient(PATIENT_NAME, GRAVITY, VisibleSymptom.SPRAIN);
        FIFOClinic.triagePatient(OTHER_PATIENT_NAME, GRAVITY, VisibleSymptom.BROKEN_BONE);
        assertEquals(PATIENT_NAME, FIFOClinic.getFirstPatientInDoctorWaitingList());
        assertEquals(OTHER_PATIENT_NAME, FIFOClinic.getFirstPatientInDoctorWaitingList());
    }

    @Test
    void GivenGravitySortingClinic_WhenGravityMoreThan5_ThenPatientPutFirstInDoctorList(){


    }


}

