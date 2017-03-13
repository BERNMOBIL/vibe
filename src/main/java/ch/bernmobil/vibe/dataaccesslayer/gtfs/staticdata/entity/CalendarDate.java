package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class CalendarDate {
    @Id
    @Column(name = "service_id")
    private long id;

    @ManyToOne
    private Calendar calendar;
    private LocalDate date;
    private ExceptionType exceptionType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public enum ExceptionType {
        ADDED(1), REMOVED(2);

        private final int type;
        ExceptionType(int type) {
            this.type = type;
        }
        public int getValue() {
            return type;
        }
    }
}
