package Classes;

import Enums.VisibleSymptom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {

    final static String PATIENT_NAME = "Jimothy";
    final static String OTHER_PATIENT_NAME = "Jimin";
    final static int GRAVITY = 38763487;
    Clinic clinic;

    @BeforeEach
    void setUp() {
        clinic = new Clinic();
    }

    @Test
    void GivenNewClinic_WhenNoPatients_ThenWaitingListsAreEmpty() {
        assertTrue(clinic.isRadioWaitingListEmpty());
        assertTrue(clinic.isDoctorWaitingListEmpty());
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
        clinic.triagePatient(PATIENT_NAME, GRAVITY, symptom);
        assertFalse(clinic.isDoctorWaitingListEmpty());
        assertTrue(clinic.isRadioWaitingListEmpty());
    }

    @ParameterizedTest
    @EnumSource(value = VisibleSymptom.class, names = {
            "SPRAIN",
            "BROKEN_BONE"})
    void WhenPatientWithSprainBrokenBoneArrives_ThenRadioListNotEmpty(VisibleSymptom symptom) {
        clinic.triagePatient(PATIENT_NAME, GRAVITY, symptom);
        assertFalse(clinic.isDoctorWaitingListEmpty());
        assertFalse(clinic.isRadioWaitingListEmpty());
    }


    @Test
    void WhenPatientSprainArrives_ThenBothWaitingListsNotEmpty(){
        clinic.triagePatient(PATIENT_NAME, GRAVITY, VisibleSymptom.SPRAIN);
        assertFalse(clinic.isDoctorWaitingListEmpty());
        assertFalse(clinic.isRadioWaitingListEmpty());
    }

    @Test
    void GivenPatientsInDoctorWaitingList_WhenPatientArrives_ThenPatientsAreInOrder() {
        clinic.triagePatient(PATIENT_NAME, GRAVITY, VisibleSymptom.FLU);
        clinic.triagePatient(OTHER_PATIENT_NAME, GRAVITY, VisibleSymptom.MIGRAINE);
        assertEquals(PATIENT_NAME, clinic.getFirstPatientInDoctorWaitingList());
        assertEquals(OTHER_PATIENT_NAME, clinic.getFirstPatientInDoctorWaitingList());
    }

    @Test
    void GivenPatientsInRadioWaitingList_WhenPatientArrives_ThenPatientsAreInOrder() {
        clinic.triagePatient(PATIENT_NAME, GRAVITY, VisibleSymptom.SPRAIN);
        clinic.triagePatient(OTHER_PATIENT_NAME, GRAVITY, VisibleSymptom.BROKEN_BONE);
        assertEquals(PATIENT_NAME, clinic.getFirstPatientInDoctorWaitingList());
        assertEquals(OTHER_PATIENT_NAME, clinic.getFirstPatientInDoctorWaitingList());
    }



}

