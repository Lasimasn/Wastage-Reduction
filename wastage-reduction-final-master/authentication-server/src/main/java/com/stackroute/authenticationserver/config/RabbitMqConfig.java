package com.stackroute.authenticationserver.config;

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
public class RabbitMqConfig {

    @Value("${restaurant.queue}")
    String restaurantQueueName;

    @Value("${restaurant.exchange}")
    String restaurantExchange;

    @Value("${restaurant.routingkey}")
    private String restaurantRoutingkey;

    @Bean
    Queue restaurantQueue() {
        System.out.println("inside queue");
        return new Queue(restaurantQueueName, true);
    }

    @Bean
    DirectExchange restaurantExchange() {
        System.out.println("inside exchange");
        return new DirectExchange(restaurantExchange);
    }

    @Bean
    Binding binding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(restaurantQueue()).to(restaurantExchange()).with(restaurantRoutingkey);
    }



    @Value("${charity.queue}")
    String charityQueueName;

    @Value("${charity.exchange}")
    String charityExchange;

    @Value("${charity.routingkey}")
    private String charityRoutingkey;

    @Bean
    Queue charityQueue() {
        System.out.println("inside queue");
        return new Queue(charityQueueName, true);
    }

    @Bean
    DirectExchange charityExchange() {
        System.out.println("inside exchange");
        return new DirectExchange(charityExchange);
    }

    @Bean
    Binding charityBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(charityQueue()).to(charityExchange()).with(charityRoutingkey);
    }

    @Value("${deliveryBoy.queue}")
    String deliveryBoyQueueName;

    @Value("${deliveryBoy.exchange}")
    String deliveryBoyExchange;

    @Value("${deliveryBoy.routingkey}")
    private String deliveryBoyRoutingkey;

    @Bean
    Queue deliveryBoyQueue() {
        System.out.println("inside queue");
        return new Queue(deliveryBoyQueueName, true);
    }

    @Bean
    DirectExchange deliveryBoyExchange() {
        System.out.println("inside exchange");
        return new DirectExchange(deliveryBoyExchange);
    }

    @Bean
    Binding deliveryBoyBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(deliveryBoyQueue()).to(deliveryBoyExchange()).with(deliveryBoyRoutingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        System.out.println("inside jsonMessageConverter");
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        System.out.println("inside rabbitTemplate");
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
