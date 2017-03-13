package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shape {
    @Id
    private long id;
    private double shapePtLatitute;
    private double shapePtLongitude;
    private int shapePtSequence;
    private int shapeDistTraveled;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getShapePtLatitute() {
        return shapePtLatitute;
    }

    public void setShapePtLatitute(double shapePtLatitute) {
        this.shapePtLatitute = shapePtLatitute;
    }

    public double getShapePtLongitude() {
        return shapePtLongitude;
    }

    public void setShapePtLongitude(double shapePtLongitude) {
        this.shapePtLongitude = shapePtLongitude;
    }

    public int getShapePtSequence() {
        return shapePtSequence;
    }

    public void setShapePtSequence(int shapePtSequence) {
        this.shapePtSequence = shapePtSequence;
    }

    public int getShapeDistTraveled() {
        return shapeDistTraveled;
    }

    public void setShapeDistTraveled(int shapeDistTraveled) {
        this.shapeDistTraveled = shapeDistTraveled;
    }
}
