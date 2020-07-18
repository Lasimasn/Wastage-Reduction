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


    @Value("${restaurant.exchange}")
    String restaurantExchange;

    @Bean
    DirectExchange resExchange() {
        System.out.println("inside restaurant exchange");
        return new DirectExchange(restaurantExchange);
    }

    @Value("${restaurantLogs.queue}")
    String restaurantQueue;

    @Value("${restaurantLogs.routingkey}")
    private String restaurantRoutingkey;

    @Bean
    Queue resQueue() {
        System.out.println("inside restaurant queue");
        return new Queue(restaurantQueue, true);
    }

    @Bean
    Binding resBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(resQueue()).to(resExchange()).with(restaurantRoutingkey);
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
        return BindingBuilder.bind(restaurantUpdateQueue()).to(resExchange()).with(restaurantUpdateRoutingkey);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Value("${charity.exchange}")
    String charityExchange;

    @Bean
    DirectExchange chrExchange() {
        System.out.println("inside charity exchange");
        return new DirectExchange(charityExchange);
    }

    @Value("${charityLogs.queue}")
    String charityQueue;

    @Value("${charityLogs.routingkey}")
    private String charityRoutingkey;

    @Bean
    Queue chrQueue() {
        System.out.println("inside charity queue");
        return new Queue(charityQueue, true);
    }

    @Bean
    Binding chrBinding() {
        System.out.println("inside charity binding");
        return BindingBuilder.bind(chrQueue()).to(chrExchange()).with(charityRoutingkey);
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
        return BindingBuilder.bind(charityUpdateQueue()).to(chrExchange()).with(charityUpdateRoutingkey);
    }

////////////////////////////////////////////////////////////////////////////////////////////////

    @Value("${deliveryBoy.exchange}")
    String deliveryBoyExchange;

    @Bean
    DirectExchange dbExchange() {
        System.out.println("inside delivery boy exchange");
        return new DirectExchange(deliveryBoyExchange);
    }

    @Value("${deliveryBoyLogs.queue}")
    String deliveryBoyQueue;

    @Value("${deliveryBoyLogs.routingkey}")
    private String deliveryBoyRoutingkey;

    @Bean
    Queue dbQueue() {
        System.out.println("inside delivery boy queue");
        return new Queue(deliveryBoyQueue, true);
    }

    @Bean
    Binding dbBinding() {
        System.out.println("inside delivery boy binding");
        return BindingBuilder.bind(dbQueue()).to(dbExchange()).with(deliveryBoyRoutingkey);
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
        return BindingBuilder.bind(deliveryBoyUpdateQueue()).to(dbExchange()).with(deliveryBoyUpdateRoutingkey);
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
