package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CalendarException {

    @Id
    private Long id;
    private LocalDate date;
    private String type;
    private Timestamp update;

    @OneToOne
    @JoinColumn(name = "calendarDate")
    private CalendarDate calendarDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CalendarDate getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(CalendarDate calendarDate) {
        this.calendarDate = calendarDate;
    }
}
