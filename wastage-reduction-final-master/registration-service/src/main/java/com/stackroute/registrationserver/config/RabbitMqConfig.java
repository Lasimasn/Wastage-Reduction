package com.stackroute.registrationserver.config;

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

    @Value("${restaurant.exchange}")
    String restaurantExchange;

    @Bean
    DirectExchange restaurantExchange() {
        System.out.println("inside exchange");
        return new DirectExchange(restaurantExchange);
    }

    @Value("${restaurant.queue}")
    String restaurantQueueName;

    @Value("${restaurant.routingkey}")
    private String restaurantRoutingkey;

    @Bean
    Queue restaurantQueue() {
        System.out.println("inside queue");
        return new Queue(restaurantQueueName, true);
    }

    @Bean
    Binding restaurantBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(restaurantQueue()).to(restaurantExchange()).with(restaurantRoutingkey);
    }

    @Value("${restaurant.update.queue}")
    String restaurantUpdateQueueName;

    @Value("${restaurant.update.routingkey}")
    private String restaurantUpdateRoutingkey;

    @Bean
    Queue restaurantUpdateQueue() {
        System.out.println("inside queue");
        return new Queue(restaurantUpdateQueueName, true);
    }

    @Bean
    Binding restaurantUpdateBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(restaurantUpdateQueue()).to(restaurantExchange()).with(restaurantUpdateRoutingkey);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Value("${charity.exchange}")
    String charityExchange;

    @Bean
    DirectExchange charityExchange() {
        System.out.println("inside exchange");
        return new DirectExchange(charityExchange);
    }

    @Value("${charity.queue}")
    String charityQueueName;

    @Value("${charity.routingkey}")
    private String charityRoutingkey;

    @Bean
    Queue charityQueue() {
        System.out.println("inside queue");
        return new Queue(charityQueueName, true);
    }

    @Bean
    Binding charityBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(charityQueue()).to(charityExchange()).with(charityRoutingkey);
    }

    @Value("${charity.update.queue}")
    String charityUpdateQueueName;

    @Value("${charity.update.routingkey}")
    private String charityUpdateRoutingkey;

    @Bean
    Queue charityUpdateQueue() {
        System.out.println("inside queue");
        return new Queue(charityUpdateQueueName, true);
    }

    @Bean
    Binding charityUpdateBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(charityUpdateQueue()).to(charityExchange()).with(charityUpdateRoutingkey);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Value("${deliveryBoy.exchange}")
    String deliveryBoyExchange;

    @Bean
    DirectExchange deliveryBoyExchange() {
        System.out.println("inside exchange");
        return new DirectExchange(deliveryBoyExchange);
    }

    @Value("${deliveryBoy.queue}")
    String deliveryBoyQueueName;

    @Value("${deliveryBoy.routingkey}")
    private String deliveryBoyRoutingkey;

    @Bean
    Queue deliveryBoyQueue() {
        System.out.println("inside queue");
        return new Queue(deliveryBoyQueueName, true);
    }

    @Bean
    Binding deliveryBoyBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(deliveryBoyQueue()).to(deliveryBoyExchange()).with(deliveryBoyRoutingkey);
    }

    @Value("${deliveryBoy.update.queue}")
    String deliveryBoyUpdateQueueName;

    @Value("${deliveryBoy.update.routingkey}")
    private String deliveryBoyUpdateRoutingkey;

    @Bean
    Queue deliveryBoyUpdateQueue() {
        System.out.println("inside queue");
        return new Queue(deliveryBoyUpdateQueueName, true);
    }

    @Bean
    Binding deliveryBoyUpdateBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(deliveryBoyUpdateQueue()).to(deliveryBoyExchange()).with(deliveryBoyUpdateRoutingkey);
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
