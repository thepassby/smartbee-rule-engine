/**
 * 
 */
package cc.nolink.rule.configuration;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import cc.nolink.rule.listener.RuleMessageDispatcher;

/**
 * @author reset
 *
 */
@Configuration
public class AmqcConfig {
	@Autowired
	Environment env;
    
    @Bean
    public ConnectionFactory connectionFactory() {
    	CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    	
    	System.out.println("custom.rabbitmq.address=" + env.getProperty("custom.rabbitmq.address"));
    	
    	connectionFactory.setAddresses(env.getProperty("custom.rabbitmq.address"));
    	connectionFactory.setUsername(env.getProperty("custom.rabbitmq.username"));
    	connectionFactory.setPassword(env.getProperty("custom.rabbitmq.password"));
    	connectionFactory.setVirtualHost(env.getProperty("custom.rabbitmq.virtualHost"));
    	connectionFactory.setPublisherConfirms(true); // 消息的回调
    	
    	return connectionFactory;
    }
    
    @Bean
    public DirectExchange defaultExchange() {
    	return new DirectExchange(env.getProperty("custom.rabbitmq.exchange"));
    }
    
    @Bean
    public Queue queue() {
    	return new Queue("logic-queue", true); //队列持久
    }
    
    @Bean
    public Binding binding() {
    	return BindingBuilder.bind(queue()).to(defaultExchange()).with(env.getProperty("custom.rabbitmq.routingKey"));
    }
    
    @Bean
    public SimpleMessageListenerContainer messageContainer() {
    	SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
    	
    	container.setQueues(queue());
    	container.setExposeListenerChannel(true);
    	container.setMaxConcurrentConsumers(1);
    	container.setConcurrentConsumers(1);
    	container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
    	container.setMessageListener(new RuleMessageDispatcher()); // custom listener
    	
    	return container;
    }
}
