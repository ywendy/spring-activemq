package org.tony.mq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerListener implements MessageListener {
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

	@Override
	public void onMessage(Message message) {
		
		TextMessage textMessage = (TextMessage)message;
		
		try {
			logger.info("consumer resive message:{}",textMessage.getText());
		} catch (JMSException e) {
			logger.error("resive message error!",e);
		}
	

	}

}
