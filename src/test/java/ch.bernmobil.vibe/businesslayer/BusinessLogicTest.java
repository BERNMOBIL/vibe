package ch.bernmobil.vibe.businesslayer;


import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Agency;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.AgencyRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopTimeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ActiveProfiles("RepositoryTestConfiguration")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryTestConfiguration.class, BusinessLogic.class})
public class BusinessLogicTest {
    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private StopTimeRepository stopTimeRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private BusinessLogic logic;

    @Test
    public void nextDeparture() throws Exception {
        Stop stopMock = new Stop();
        String stopName = "Generic Stop";
        when(stopRepository.findFirstByStopName(stopName)).thenReturn(stopMock);
        StopTime stopTimeMock = mock(StopTime.class);
        List<StopTime> expected = Collections.singletonList(stopTimeMock);
        when(stopTimeRepository.getNextDeparturesBy(stopMock)).thenReturn(expected);
        List<StopTime> actual = logic.getNextDeparturesByStopName(stopName);
        assertThat(expected, is(actual));
    }

    @Test
    public void getAgencyName() throws Exception {
        Agency agencyMock = mock(Agency.class);
        String agencyName = "Generic agency";
        when(agencyMock.getName()).thenReturn(agencyName);
        when(agencyRepository.findFirstByOrderById()).thenReturn(agencyMock);
        String actual = logic.getName();
        assertThat(agencyName, is(actual));
    }
}
