package ch.bernmobil.vibe.businesslayer;



import ch.bernmobil.vibe.businesslayer.mock.data.StopMockData;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.AgencyRepository;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@ActiveProfiles("RepositoryTestConfiguration")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BusinessLogic.class, RepositoryTestConfiguration.class})
public class BusinessLogicTest {

    @Autowired
    BusinessLogic businessLogic;

    @Autowired
    AgencyRepository agencyRepository;

    private boolean isFirstInitialization = true;
    private static List<StopTime> mockedStopTimes;
    private static List<Stop> mockedStops;


    //BeforeClass executed before @Autowired
    @Before
    public void loadMockedDataSources() {
        if(isFirstInitialization) {
            isFirstInitialization = false;

            mockedStopTimes = RepositoryTestConfiguration.stopTimeRepositoryMock.getDataSource();
            mockedStops = RepositoryTestConfiguration.stopRepositoryMock.getDataSource();
        }

    }

    @Test
    public void agencyName() {
        String agencyName = businessLogic.getAgencyName();

        assertThat(agencyName, is("name 1"));
    }


    @Test
    public void nextDeparture() throws Exception {
        Stop stop = mockedStops.get(0);
        List<StopTime> expectedResult = mockedStopTimes.subList(0, 2);

        List<StopTime> nextDepartures =  businessLogic.getNextDeparturesByStopName(stop.getStopName());

        assertThat(nextDepartures.size(), is(2));
        assertThat(nextDepartures, is(expectedResult));
    }



}
