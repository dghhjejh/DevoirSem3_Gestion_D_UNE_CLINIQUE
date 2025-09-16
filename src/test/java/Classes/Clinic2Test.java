package Classes;

import Enums.VisibleSymptom;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Clinic2Test {

    @Test
    void GivenEmptyClinic_WhenTriage_ThenIsNextToSeeDoctor(){
        WaitingList waitingList = mock(WaitingList.class);
        Clinic2 clinic2 = new Clinic2();
        clinic2.triage("Patate", 4, VisibleSymptom.MIGRAINE);
        verify(waitingList).add("Patate", 4, VisibleSymptom.MIGRAINE);
    }
}
