package ch.bernmobil.vibe.gtfs.entity;

import javax.persistence.Id;

public class Agency {
    @Id
    private long id;
    private String name;
    private String url;
    private String timezone;
    private String lang;
    private String phone;
}
