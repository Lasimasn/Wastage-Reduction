package com.stackroute.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${deliveryBoyLogs.rabbitmq.queue}")
    String deliveryBoyQueue;

    @Value("${deliveryBoy.rabbitmq.exchange}")
    String deliveryBoyExchange;

    @Value("${deliveryBoyLogs.rabbitmq.routingkey}")
    private String deliveryBoyRoutingkey;

    @Bean
    Queue dbQueue() {
        System.out.println("inside delivery boy queue");
        return new Queue(deliveryBoyQueue, true);
    }

    @Bean
    DirectExchange dbExchange() {
        System.out.println("inside delivery boy exchange");
        return new DirectExchange(deliveryBoyExchange);
    }

    @Bean
    Binding dbBinding() {
        System.out.println("inside delivery boy binding");
        return BindingBuilder.bind(dbQueue()).to(dbExchange()).with(deliveryBoyRoutingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
