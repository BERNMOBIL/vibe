package ch.bernmobil.vibe.presentationlayer.dto;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.testenvironment.MockDataConfiguration;
import ch.bernmobil.vibe.testenvironment.data.ScheduleMockData;
import ch.bernmobil.vibe.testenvironment.data.ScheduleUpdateMockData;
import ch.bernmobil.vibe.testenvironment.data.StopMockData;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("TestConfiguration")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MockDataConfiguration.class})
public class ConverterTest {
    private final DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

    private StopMockData stopMockData;
    private ScheduleMockData scheduleMockData;
    private ScheduleUpdateMockData scheduleUpdateMockData;


    @Test
    public void convertSchedule() throws Exception {
        Schedule s = scheduleMockData.get(0);
        s.setScheduleUpdate(null);

        Converter converter = new Converter();
        ScheduleDto dto = converter.convertSchedule(s);

        assertThat(dto.getHasPlatform(), is(true));
        assertThat(dto.getHasDelay(), is(false));
        assertThat(dto.getPlatform(), is(s.getPlatform()));
        assertThat(dto.getDestination(), is(s.getJourney().getHeadsign()));
        assertThat(dto.getPlannedDeparture(), is(s.getPlannedDeparture().format(dateTimeFormatter)));
        assertThat(dto.getLine(), is(s.getJourney().getRoute().getLine()));
    }

    @Test
    public void convertScheduleWithDelay() throws Exception {
        Schedule s = scheduleMockData.get(0);
        ScheduleUpdate su = scheduleUpdateMockData.get(0);
        s.setScheduleUpdate(su);
        long delay = ChronoUnit.MINUTES.between(s.getPlannedDeparture(), su.getActualDeparture());
        Converter converter = new Converter();
        ScheduleDto dto = converter.convertSchedule(s);

        assertThat(dto.getHasPlatform(), is(true));
        assertThat(dto.getHasDelay(), is(true));
        assertThat(dto.getPlatform(), is(s.getPlatform()));
        assertThat(dto.getDestination(), is(s.getJourney().getHeadsign()));
        assertThat(dto.getPlannedDeparture(), is(s.getPlannedDeparture().format(dateTimeFormatter)));
        assertThat(dto.getLine(), is(s.getJourney().getRoute().getLine()));
        assertThat(dto.getActualDeparture(), is(Long.toString(delay)));
    }

    @Test
    public void convertStop() throws Exception {
        Stop s = stopMockData.get(0);
        Converter converter = new Converter();
        StopDto dto = converter.convertStop(s);

        assertThat(dto.getId(), is(s.getId()));
        assertThat(dto.getName(), is(s.getName()));
    }

    @Test
    public void convertScheduleList() throws Exception {
        List<Schedule> list = scheduleMockData.getDataSource();
        Converter converter = new Converter();
        List<ScheduleDto> result = converter.convertScheduleList(list);
        List<ScheduleDto> expected = list.stream()
            .sorted(Comparator.comparing(Schedule::getPlannedDeparture))
            .map(this::convertDto)
            .collect(Collectors.toList());
        assertThat(result, equalTo(expected));
    }

    private ScheduleDto convertDto(Schedule schedule) {
        ScheduleDto dto = new ScheduleDto();
        dto.setPlannedDeparture(schedule.getPlannedDeparture().format(dateTimeFormatter));
        dto.setLine(schedule.getJourney().getRoute().getLine());
        dto.setDestination(schedule.getJourney().getHeadsign());
        dto.setPlatform(schedule.getPlatform());
        dto.setHasPlatform(true);
        return dto;
    }

    @Autowired
    public void setStopMockData(StopMockData stopMockData) {
        this.stopMockData = stopMockData;
    }

    @Autowired
    public void setScheduleMockData(ScheduleMockData scheduleMockData) {
        this.scheduleMockData = scheduleMockData;
    }

    @Autowired
    public void setScheduleUpdateMockData(
        ScheduleUpdateMockData scheduleUpdateMockData) {
        this.scheduleUpdateMockData = scheduleUpdateMockData;
    }
}