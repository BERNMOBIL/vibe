package ch.bernmobil.vibe.dataaccesslayer.entity;

import java.time.LocalTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ScheduleUpdate {

    @Id
    private UUID id;
    private LocalTime actualArrival;
    private LocalTime actualDeparture;

    @OneToOne
    @JoinColumn(name = "schedule")
    private Schedule schedule;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalTime getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(LocalTime actualArrival) {
        this.actualArrival = actualArrival;
    }

    public LocalTime getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(LocalTime actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
