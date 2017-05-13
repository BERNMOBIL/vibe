package ch.bernmobil.vibe.service;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommunicationConfiguration {
    @Value("${bernmobil.amqp.fanout-queue}")
    private String fanoutQueueName;

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutQueueName);
    }

    @Bean
    public Queue autoDeleteQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding(Queue autoDeleteQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(autoDeleteQueue).to(fanoutExchange);
    }
}
