package ch.bernmobil.vibe.gtfs.entity;

import javax.persistence.OneToOne;
import java.util.Date;
import java.util.Map;

public class Calendar {
    @OneToOne
    private Service service;
    private Map<String, Integer> days;
    private Date startDate;
    private Date endDate;
}