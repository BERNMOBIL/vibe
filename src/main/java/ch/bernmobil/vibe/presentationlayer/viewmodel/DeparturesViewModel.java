package ch.bernmobil.vibe.presentationlayer.viewmodel;

import java.util.List;

public class DeparturesViewModel {
    private StopViewModel station;
    private List<ScheduleViewModel> departures;

    public DeparturesViewModel(StopViewModel departure, List<ScheduleViewModel> departures) {
        this.station = departure;
        this.departures = departures;
    }

    public StopViewModel getStation() {
        return station;
    }

    public List<ScheduleViewModel> getDepartures() {
        return departures;
    }
}
