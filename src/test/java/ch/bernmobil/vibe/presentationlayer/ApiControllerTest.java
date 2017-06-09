package ch.bernmobil.vibe.presentationlayer;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.presentationlayer.dto.Converter;
import ch.bernmobil.vibe.presentationlayer.dto.DeparturesDto;
import ch.bernmobil.vibe.presentationlayer.dto.ScheduleDto;
import ch.bernmobil.vibe.testenvironment.MockConfiguration;
import ch.bernmobil.vibe.testenvironment.MockDataConfiguration;
import ch.bernmobil.vibe.testenvironment.RepositoryConfiguration;
import ch.bernmobil.vibe.testenvironment.repository.ScheduleRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.StopRepositoryMock;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
@ActiveProfiles("TestConfiguration")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfiguration.class, MockDataConfiguration.class,
    BusinessLogic.class, MockConfiguration.class})
public class ApiControllerTest {
    private ScheduleRepositoryMock scheduleRepositoryMock;
    private StopRepositoryMock stopRepositoryMock;

    @Test
    public void departures() {
        BusinessLogic businessLogic = mock(BusinessLogic.class);
        Converter converter = new Converter();
        Stop s = stopRepositoryMock.getDataSource().get(0);
        List<Schedule> scheduleList = scheduleRepositoryMock.getDataSource();

        when(businessLogic.getStopById(eq(s.getId()))).thenReturn(s);
        when(businessLogic.getDeparturesByStopId(eq(s.getId()), any(LocalTime.class), anyInt()))
            .thenReturn(scheduleList);
        when(businessLogic.getNewestStopVersion(eq(s))).thenReturn(s);

        ApiController controller = new ApiController(businessLogic, converter);
        SetTimezoneInController(controller);

        ResponseEntity response = controller.apiDepartures(s.getId(), 10);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        DeparturesDto result = (DeparturesDto) response.getBody();
        List<ScheduleDto> vmList = result.getDepartures();
        List<ScheduleDto> expected = converter.convertScheduleList(scheduleList);
        assertThat(vmList, equalTo(expected));
    }

    @Test
    public void departuresStopNotFound() {
        BusinessLogic businessLogic = mock(BusinessLogic.class);
        Converter converter = new Converter();
        when(businessLogic.getStopById(any(UUID.class))).thenReturn(null);

        ApiController controller = new ApiController(businessLogic, converter);
        SetTimezoneInController(controller);

        UUID id = UUID.randomUUID();
        ResponseEntity response = controller.apiDepartures(id, 10);
        assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
        String message = (String)response.getBody();
        assertThat(message, containsString(id.toString()));
    }

    @Test
    public void departureNewerVersionError() {
        BusinessLogic businessLogic = mock(BusinessLogic.class);
        Converter converter = new Converter();
        Stop s = stopRepositoryMock.getDataSource().get(0);
        List<Schedule> scheduleList = scheduleRepositoryMock.getDataSource();

        when(businessLogic.getStopById(eq(s.getId()))).thenReturn(s);
        when(businessLogic.getDeparturesByStopId(eq(s.getId()), any(LocalTime.class), anyInt()))
            .thenReturn(scheduleList);
        when(businessLogic.getNewestStopVersion(eq(s))).thenReturn(null);

        ApiController controller = new ApiController(businessLogic, converter);
        SetTimezoneInController(controller);

        ResponseEntity response = controller.apiDepartures(s.getId(), 10);
        assertThat(response.getStatusCode(), is(HttpStatus.GONE));
        String message = (String)response.getBody();
        assertThat(message, containsString(s.getId().toString()));
    }

    @Test
    public void departuresAtTime() {
        BusinessLogic businessLogic = mock(BusinessLogic.class);
        Converter converter = new Converter();
        Stop s = stopRepositoryMock.getDataSource().get(0);
        List<Schedule> scheduleList = scheduleRepositoryMock.getDataSource();
        String timeString = "10:10";
        LocalTime time = LocalTime.parse(timeString);
        when(businessLogic.getStopById(eq(s.getId()))).thenReturn(s);
        when(businessLogic.getDeparturesByStopId(eq(s.getId()), eq(time), anyInt()))
            .thenReturn(scheduleList);
        when(businessLogic.getNewestStopVersion(eq(s))).thenReturn(s);

        ApiController controller = new ApiController(businessLogic, converter);
        SetTimezoneInController(controller);

        ResponseEntity response = controller.apiDeparturesAtTime(s.getId(), timeString,  10);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        DeparturesDto result = (DeparturesDto) response.getBody();
        List<ScheduleDto> vmList = result.getDepartures();
        List<ScheduleDto> expected = converter.convertScheduleList(scheduleList);
        assertThat(vmList, equalTo(expected));
    }

    @Test
    public void departuresAtTimeInvalidTime() {
        BusinessLogic businessLogic = mock(BusinessLogic.class);
        Converter converter = new Converter();
        String timeString = "10.10";

        ApiController controller = new ApiController(businessLogic, converter);
        SetTimezoneInController(controller);

        ResponseEntity response = controller.apiDeparturesAtTime(null, timeString,  10);
        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
        String message = (String)response.getBody();
        assertThat(message, containsString(timeString));
    }

    private void SetTimezoneInController(ApiController controller) {
        ReflectionTestUtils.setField(controller, "timezone", "Europe/Paris", String.class);
    }

    @Autowired
    public void setStopRepositoryMock(
        StopRepositoryMock stopRepositoryMock) {
        this.stopRepositoryMock = stopRepositoryMock;
    }

    @Autowired
    public void setScheduleRepositoryMock(
        ScheduleRepositoryMock scheduleRepositoryMock) {
        this.scheduleRepositoryMock = scheduleRepositoryMock;
    }
}