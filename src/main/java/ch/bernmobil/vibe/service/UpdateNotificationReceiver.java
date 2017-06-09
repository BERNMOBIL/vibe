package ch.bernmobil.vibe.service;

import java.util.Observable;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Class to register to a AMQP Queue and handle the reception and deserialization of messages.
 * It implements {@link Observable} to notify any other class, which would like to be informed.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Component
public class UpdateNotificationReceiver extends Observable {
    private final Logger logger = Logger.getLogger(UpdateNotificationReceiver.class);

    /**
     * Recieve and check the correctness of the recieved message.
     * @param message which has been sent to the queue.
     */
    @RabbitListener(queues = "#{autoDeleteQueue.name}")
    public void receive(String message) {
        if(!"update successful".equals(message)) {
            logger.warn(String.format("Unknown message: %s", message));
            return;
        }
        logger.info("Received update notification");
        setChanged();
        notifyObservers();
    }
}
