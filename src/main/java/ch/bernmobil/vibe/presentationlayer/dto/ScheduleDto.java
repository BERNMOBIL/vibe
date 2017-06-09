package ch.bernmobil.vibe.presentationlayer.dto;

public class ScheduleDto {
    private String plannedDeparture;
    private String platform;
    private boolean hasPlatform;
    private String destination;
    private String line;
    private boolean hasDelay;
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

    public boolean getHasDelay() {
        return hasDelay;
    }

    public void setHasDelay(boolean hasDelay) {
        this.hasDelay = hasDelay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ScheduleDto that = (ScheduleDto) o;

        if (hasPlatform != that.hasPlatform) {
            return false;
        }
        if (hasDelay != that.hasDelay) {
            return false;
        }
        if (!plannedDeparture.equals(that.plannedDeparture)) {
            return false;
        }
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) {
            return false;
        }
        if (!destination.equals(that.destination)) {
            return false;
        }
        return line.equals(that.line) && (actualDeparture != null ? actualDeparture
            .equals(that.actualDeparture) : that.actualDeparture == null);
    }

    @Override
    public int hashCode() {
        int result = plannedDeparture.hashCode();
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (hasPlatform ? 1 : 0);
        result = 31 * result + destination.hashCode();
        result = 31 * result + line.hashCode();
        result = 31 * result + (hasDelay ? 1 : 0);
        result = 31 * result + (actualDeparture != null ? actualDeparture.hashCode() : 0);
        return result;
    }
}
