package ch.bernmobil.vibe;

import java.time.temporal.ChronoUnit;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class helps the Configuration-Processor of Spring resolving the types of configuration properties.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
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
         * The timezone in which the departures are taking place.
         * Refer to {@link java.time.ZoneId} for information about valid values
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
         * The delay with which a vehicle is traveling until it is considered delayed, in minutes.
         * Changing the {@link ChronoUnit} in {@link ch.bernmobil.vibe.presentationlayer.dto.Converter}
         * affects this unit.
         *
         * @see ch.bernmobil.vibe.presentationlayer.dto.Converter
         */
        private int delay;

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }

    }

}
