package ch.bernmobil.vibe.presentationlayer.dto;

import java.util.List;

public class DeparturesDto {
    private final StopDto station;
    private final List<ScheduleDto> departures;

    public DeparturesDto(StopDto departure, List<ScheduleDto> departures) {
        this.station = departure;
        this.departures = departures;
    }

    public StopDto getStation() {
        return station;
    }

    public List<ScheduleDto> getDepartures() {
        return departures;
    }
}
