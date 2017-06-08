package ch.bernmobil.vibe.businesslayer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleUpdateRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.StopRepository;
import ch.bernmobil.vibe.service.UpdateTimestampService;
import ch.bernmobil.vibe.testenvironment.MockConfiguration;
import ch.bernmobil.vibe.testenvironment.MockDataConfiguration;
import ch.bernmobil.vibe.testenvironment.RepositoryConfiguration;
import ch.bernmobil.vibe.testenvironment.ServiceConfiguration;
import ch.bernmobil.vibe.testenvironment.repository.ScheduleRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.ScheduleUpdateRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.StopRepositoryMock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("TestConfiguration")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfiguration.class, MockDataConfiguration.class,
    ServiceConfiguration.class, MockConfiguration.class})
public class BusinessLogicTest {

    private ScheduleRepositoryMock scheduleRepositoryMock;
    private ScheduleUpdateRepositoryMock scheduleUpdateRepositoryMock;
    private StopRepositoryMock stopRepositoryMock;
    private UpdateTimestampService updateTimestampService;

    @Test
    public void findStopsByName() {
        StopRepository stopRepository = stopRepositoryMock.getMock();
        LocalDateTime timestamp = LocalDateTime.now();
        String stopName = "Rapperswil";
        List<Stop> expected = stopRepositoryMock.getDataSource()
            .stream()
            .filter(s -> s.getName().equals(stopName))
            .collect(Collectors.toList());

        when(updateTimestampService.getCurrentTimestamp()).thenReturn(timestamp);
        when(stopRepository.findAllByNameWithIgnoreCase(eq(stopName), eq(timestamp), any(Sort.class))).thenReturn(expected);

        BusinessLogic logic = new BusinessLogic(scheduleRepositoryMock.getMock(), scheduleUpdateRepositoryMock.getMock(), stopRepository, updateTimestampService);
        List<Stop> stops = logic.findStops(stopName);
        assertThat(stops, equalTo(expected));
    }

    @Test
    public void findStopById() {
        StopRepository stopRepository = stopRepositoryMock.getMock();
        Stop expected = stopRepositoryMock.getDataSource().get(0);
        when(stopRepository.findOne(eq(expected.getId()))).thenReturn(expected);

        BusinessLogic logic = new BusinessLogic(scheduleRepositoryMock.getMock(), scheduleUpdateRepositoryMock.getMock(), stopRepository, updateTimestampService);
        Stop result = logic.getStopById(expected.getId());
        assertThat(result, is(expected));
    }

    @Test
    public void departuresByStopId() {
        StopRepository stopRepository = stopRepositoryMock.getMock();
        ScheduleRepository scheduleRepository = scheduleRepositoryMock.getMock();
        List<Schedule> scheduleList = scheduleRepositoryMock.getDataSource();
        Stop stop = stopRepositoryMock.getDataSource().get(0);
        LocalDateTime timestamp = LocalDateTime.now();

        when(stopRepository.findOne(stop.getId())).thenReturn(stop);
        when(updateTimestampService.getCurrentTimestamp()).thenReturn(timestamp);
        when(scheduleRepository.findSchedulesByStop(eq(stop), any(LocalTime.class), eq(timestamp), any(Pageable.class)))
            .thenReturn(new PageImpl<>(scheduleList));

        BusinessLogic logic = new BusinessLogic(scheduleRepository, scheduleUpdateRepositoryMock.getMock(), stopRepository, updateTimestampService);
        List<Schedule> result = logic.getDeparturesByStopId(stop.getId(), LocalTime.now(), 10);
        assertThat(result, equalTo(scheduleList));
    }

    @Test
    public void getNewestStopVersion() {
        StopRepository stopRepository = stopRepositoryMock.getMock();
        List<Stop> stops = stopRepositoryMock.getDataSource();
        LocalDateTime timestamp = LocalDateTime.now();
        Stop expected = stops.get(0);
        expected.setUpdateTimestamp(timestamp);

        when(stopRepository.findAllByName(anyString())).thenReturn(stops);
        when(updateTimestampService.getCurrentTimestamp()).thenReturn(timestamp);

        BusinessLogic logic = new BusinessLogic(scheduleRepositoryMock.getMock(), scheduleUpdateRepositoryMock.getMock(), stopRepository, updateTimestampService);
        Stop result = logic.getNewestStopVersion(expected);

        assertThat(result, is(expected));
    }

    @Test
    public void getAllScheduleUpdates() {
        ScheduleUpdateRepository scheduleUpdateRepository = scheduleUpdateRepositoryMock.getMock();
        List<ScheduleUpdate> updates = scheduleUpdateRepositoryMock.getDataSource();

        when(scheduleUpdateRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(updates));
        BusinessLogic logic = new BusinessLogic(scheduleRepositoryMock.getMock(), scheduleUpdateRepository, stopRepositoryMock.getMock(), updateTimestampService);

        Collection<ScheduleUpdate> result = logic.getNextScheduleUpdates();
        assertThat(result, equalTo(updates));
    }

    @Autowired
    public void setStopRepositoryMock(StopRepositoryMock stopRepositoryMock) {
        this.stopRepositoryMock = stopRepositoryMock;
    }

    @Autowired
    public void setScheduleRepositoryMock(
        ScheduleRepositoryMock scheduleRepositoryMock) {
        this.scheduleRepositoryMock = scheduleRepositoryMock;
    }

    @Autowired
    public void setScheduleUpdateRepositoryMock(
        ScheduleUpdateRepositoryMock scheduleUpdateRepositoryMock) {
        this.scheduleUpdateRepositoryMock = scheduleUpdateRepositoryMock;
    }

    @Autowired
    public void setUpdateTimestampService(
        UpdateTimestampService updateTimestampService) {
        this.updateTimestampService = updateTimestampService;
    }
}
