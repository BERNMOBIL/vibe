package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ScheduleUpdate {

    @Id
    private UUID id;
    private Time actualArrival;
    private Time actualDeparture;

    @OneToOne
    @JoinColumn(name = "schedule")
    private Schedule schedule;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Time getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(Time actualArrival) {
        this.actualArrival = actualArrival;
    }

    public Time getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(Time actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
