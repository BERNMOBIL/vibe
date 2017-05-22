package ch.bernmobil.vibe.presentationlayer.viewmodel;

import java.time.LocalTime;

public class ScheduleViewModel {
    private String plannedDeparture;
    private String platform;
    private boolean hasPlatform;
    private String destination;
    private String line;
    private String actualDeparture;

    public String getPlannedDeparture() {
        return plannedDeparture;
    }

    public void setPlannedDeparture(String plannedDeparture) {
        this.plannedDeparture = plannedDeparture;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(String actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public boolean getHasPlatform() {
        return hasPlatform;
    }

    public void setHasPlatform(boolean hasPlatform) {
        this.hasPlatform = hasPlatform;
    }
}