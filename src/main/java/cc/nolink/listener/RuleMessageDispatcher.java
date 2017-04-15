/**
 * 
 */
package cc.nolink.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;

/**
 * @author reset
 *
 */
public class RuleMessageDispatcher implements ChannelAwareMessageListener {
	private static final Logger logger = LoggerFactory.getLogger(RuleMessageDispatcher.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.amqp.rabbit.core.ChannelAwareMessageListener#onMessage(org.springframework.amqp.core.Message, com.rabbitmq.client.Channel)
	 */
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		logger.info("receive message:" + new String(message.getBody()));
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}
}
