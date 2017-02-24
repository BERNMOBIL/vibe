package ch.bernmobil.vibe.gtfs.entity;


import javax.persistence.Id;

public class Service {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}