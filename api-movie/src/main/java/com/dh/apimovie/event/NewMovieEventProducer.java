package com.dh.apimovie.event;

import com.dh.apimovie.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewMovieEventProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishNewMovieEvent(NewMovieEventProducer.Message message) {
        //queue.publish(message)
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_MOVIE, message);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Message {
        private String name;
        private String genre;
        private String urlStream;
    }

}
