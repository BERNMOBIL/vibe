package ch.bernmobil.vibe;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.temporal.ChronoUnit;

/**
 * This class helps the Configuration-Processor of Spring resolving the types of configuration properties.
 */
public class BernmobilConfigurationProperties {

    @ConfigurationProperties(prefix = "bernmobil.amqp")
    public class Amqp {

        /**
         * Name of the fanout where update notifications will be sent
         */
        private String fanoutQueue;

        public String getFanoutQueue() {
            return fanoutQueue;
        }

        public void setFanoutQueue(String fanoutQueue) {
            this.fanoutQueue = fanoutQueue;
        }
    }

    @ConfigurationProperties(prefix = "bernmobil.locale")
    public class Locale {

        /**
         * The timezone in which the departures are taking place. Refer to {@link java.time.ZoneId}
         * for information about valid values
         */
        private String timezone;

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

    @ConfigurationProperties(prefix = "bernmobil.ruleset")
    public class RuleSet {
        /**
         * Die Verspätung, mit welcher ein Fahrzeug unterwegs ist, bis es als Verspätet gilt
         */
        private int delay;
        /**
         * Chronological Unit of the delay in {@link java.time.temporal.ChronoUnit}
         */
        private ChronoUnit unit;

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }

        public ChronoUnit getUnit() {
            return unit;
        }

        public void setUnit(ChronoUnit unit) {
            this.unit = unit;
        }
    }

}
