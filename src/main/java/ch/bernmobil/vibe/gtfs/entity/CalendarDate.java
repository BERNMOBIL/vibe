package ch.bernmobil.vibe.gtfs.entity;

import javax.persistence.ManyToOne;
import java.util.Date;

public class CalendarDate {
    @ManyToOne
    private Service service;
    private Date date;
    private int exceptionType;
}
