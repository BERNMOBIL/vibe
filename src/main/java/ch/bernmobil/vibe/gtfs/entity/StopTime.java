package ch.bernmobil.vibe.gtfs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StopTime {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Trip trip;
    private String arrivalTime;
    private String departureTime;
    @ManyToOne
    private Stop stop;
    private int stopSequence;
    private int pickupType;
    private int dropOffType;
}
