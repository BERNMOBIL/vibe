package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScheduleUpdate {

  @Id
  private Long id;
  private Time actualArrival;
  private Time actualDeparture;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Time getActualArrival() {
    return actualArrival;
  }

  public void setActualArrival(Time actualArrival) {
    this.actualArrival = actualArrival;
  }

  public Time getActualDeparture() {
    return actualDeparture;
  }

  public void setActualDeparture(Time actualDeparture) {
    this.actualDeparture = actualDeparture;
  }
}
