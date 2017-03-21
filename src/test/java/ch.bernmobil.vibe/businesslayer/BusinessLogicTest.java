package ch.bernmobil.vibe.businesslayer;



import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import ch.bernmobil.vibe.businesslayer.mock.data.ScheduleMockData;
import ch.bernmobil.vibe.businesslayer.mock.data.StopMockData;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ActiveProfiles("RepositoryTestConfiguration")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BusinessLogic.class, RepositoryTestConfiguration.class})
public class BusinessLogicTest {

    @Autowired
    BusinessLogic businessLogic;


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
        Stop stop = mockedStops.get(0);

        List<Schedule> expectedResult = mockedSchedules.subList(0, 2);

        List<Schedule> nextDepartures =  businessLogic.getNextDeparturesByStopName(stop.getName());

        assertThat(nextDepartures.size(), is(2));
        assertThat(nextDepartures, is(expectedResult));
    }
}
