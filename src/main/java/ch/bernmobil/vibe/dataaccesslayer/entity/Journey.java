package ch.bernmobil.vibe.dataaccesslayer.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Journey {

    @Id
    private UUID id;
    private String headsign;
    @Column(name = "update")
    private LocalDateTime updateTimestamp;

    @OneToOne
    @JoinColumn(name = "route")
    private Route route;

    @OneToOne
    @JoinColumn(name = "terminal_station")
    private Stop terminalStation;

    @OneToOne(targetEntity = JourneyDisruption.class, mappedBy = "journey")
    private JourneyDisruption journeyDisruption;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHeadsign() {
        return headsign;
    }

    public void setHeadsign(String headsign) {
        this.headsign = headsign;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public JourneyDisruption getJourneyDisruption() {
        return journeyDisruption;
    }

    public void setJourneyDisruption(
        JourneyDisruption journeyDisruption) {
        this.journeyDisruption = journeyDisruption;
    }

    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Stop getTerminalStation() {
        return terminalStation;
    }

    public void setTerminalStation(Stop terminalStation) {
        this.terminalStation = terminalStation;
    }
}
