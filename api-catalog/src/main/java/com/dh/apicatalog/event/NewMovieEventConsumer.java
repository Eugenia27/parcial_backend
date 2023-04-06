package com.dh.apicatalog.event;

import com.dh.apicatalog.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NewMovieEventConsumer {

    //subscription to message queue
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_MOVIE)
    public void listenNewMovieEvent(NewMovieEventConsumer.Message message) {
        System.out.println("We have a notification of a new movie with genre : " + message.genre);
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
