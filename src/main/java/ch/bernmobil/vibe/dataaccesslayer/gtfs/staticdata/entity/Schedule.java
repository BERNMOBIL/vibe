package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Schedule {

    @Id
    private Long id;
    private String platform;
    private LocalTime plannedArrival;
    private LocalTime plannedDeparture;

    @OneToOne
    @JoinColumn(name = "stop")
    private Stop stop;

    @OneToOne
    @JoinColumn(name = "journey")
    private Journey journey;

    @OneToOne
    @JoinColumn(name = "schedule_update")
    private ScheduleUpdate scheduleUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public LocalTime getPlannedArrival() {
        return plannedArrival;
    }

    public void setPlannedArrival(LocalTime plannedArrival) {
        this.plannedArrival = plannedArrival;
    }

    public LocalTime getPlannedDeparture() {
        return plannedDeparture;
    }

    public void setPlannedDeparture(LocalTime plannedDeparture) {
        this.plannedDeparture = plannedDeparture;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public ScheduleUpdate getScheduleUpdate() {
        return scheduleUpdate;
    }

    public void setScheduleUpdate(
        ScheduleUpdate scheduleUpdate) {
        this.scheduleUpdate = scheduleUpdate;
    }

    @Transient
    public int compareByDepartureTime(Schedule other) {
        return plannedDeparture.compareTo(other.getPlannedDeparture());
    }

}
