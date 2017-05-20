package ch.bernmobil.vibe.presentationlayer.viewmodel;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import java.util.List;

public class DeparturesViewModel {
    private StopViewModel departure;
    private List<ScheduleViewModel> departures;

    public DeparturesViewModel(StopViewModel departure, List<ScheduleViewModel> departures) {
        this.departure = departure;
        this.departures = departures;
    }

    public StopViewModel getDeparture() {
        return departure;
    }

    public List<ScheduleViewModel> getDepartures() {
        return departures;
    }
}
