package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ScheduleUpdate {

  @Id
  private Long id;
  private Time actual_arrival;
  private Time actual_departure;

  @OneToOne
  @JoinColumn(name = "schedule")
  private Schedule schedule;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Time getActual_arrival() {
    return actual_arrival;
  }

  public void setActual_arrival(Time actual_arrival) {
    this.actual_arrival = actual_arrival;
  }

  public Time getActual_departure() {
    return actual_departure;
  }

  public void setActual_departure(Time actual_departure) {
    this.actual_departure = actual_departure;
  }

  public Schedule getSchedule() {
    return schedule;
  }

  public void setSchedule(Schedule schedule) {
    this.schedule = schedule;
  }
}
