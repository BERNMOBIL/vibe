package ch.bernmobil.vibe.presentationlayer.viewmodel;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import java.util.Collection;

public class ScheduleUpdateViewModel {
    private Collection<ScheduleUpdate> allUpdates;

    public ScheduleUpdateViewModel(Collection<ScheduleUpdate> updates) {
        allUpdates = updates;
    }

    public Collection<ScheduleUpdate> getAllUpdates() {
        return allUpdates;
    }
}
