package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Stop {
    @Id
    private long id;
    private String name;
    private Timestamp update;

    @OneToOne
    @JoinColumn(name = "area")
    private Area area;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
