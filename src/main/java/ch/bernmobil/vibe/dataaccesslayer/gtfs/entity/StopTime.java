package ch.bernmobil.vibe.dataaccesslayer.gtfs.entity;

import javax.persistence.*;

@Entity
public class StopTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
