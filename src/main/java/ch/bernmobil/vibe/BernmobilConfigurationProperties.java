package ch.bernmobil.vibe;

import org.springframework.boot.context.properties.ConfigurationProperties;

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

}
