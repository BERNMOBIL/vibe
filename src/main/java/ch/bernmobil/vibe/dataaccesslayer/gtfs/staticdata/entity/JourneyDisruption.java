package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JourneyDisruption {
    @Id
    private long id;
    private String message;
    private Timestamp start;
    private Timestamp plannedEnd;

    @ManyToOne
    @JoinColumn(name = "journey")
    private Journey journey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(Timestamp plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }
}
