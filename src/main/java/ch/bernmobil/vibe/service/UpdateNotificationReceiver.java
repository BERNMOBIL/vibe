package ch.bernmobil.vibe.service;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateNotificationReceiver {
    private final Logger logger = Logger.getLogger(UpdateNotificationReceiver.class);

    private UpdateTimestampService updateTimestampService;

    @Autowired
    public UpdateNotificationReceiver(UpdateTimestampService updateTimestampService) {
        this.updateTimestampService = updateTimestampService;
    }

    @RabbitListener(queues = "#{autoDeleteQueue.name}")
    public void receive(String message) {
        if(!message.equals("update successful")) {
            logger.warn(String.format("Unknown message: %s", message));
            return;
        }
        logger.info("Received update notification");
        updateTimestampService.checkTimestamp();
    }
}
