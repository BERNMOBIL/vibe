package ch.bernmobil.vibe.businesslayer;



import ch.bernmobil.vibe.businesslayer.mock.data.ScheduleMockData;
import ch.bernmobil.vibe.businesslayer.mock.data.StopMockData;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@ActiveProfiles("RepositoryTestConfiguration")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryTestConfiguration.class})
public class BusinessLogicTest {

    @Autowired
    private BusinessLogic businessLogic;


    private boolean isFirstInitialization = true;
    private static List<Stop> mockedStops;
    private static List<Schedule> mockedSchedules;


    //BeforeClass executed before @Autowired
    @Before
    public void loadMockedDataSources() {
        if(isFirstInitialization) {
            isFirstInitialization = false;

            mockedStops = StopMockData.getDataSource();
            mockedSchedules = ScheduleMockData.getDataSource();
        }
    }


    @Test
    public void nextDeparture() throws Exception {
        /*Stop stop = mockedStops.get(0);

        List<Schedule> expectedResult = mockedSchedules.subList(0, 2);

        List<Schedule> nextDepartures =  businessLogic.getNextDeparturesByStopId(stop.getId());*/

        //assertThat(nextDepartures.size(), is(2)); TODO: fixit
        //assertThat(nextDepartures, is(expectedResult));
    }
}
