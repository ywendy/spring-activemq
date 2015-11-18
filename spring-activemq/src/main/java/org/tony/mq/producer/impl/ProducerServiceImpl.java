package org.tony.mq.producer.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.tony.mq.producer.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendMessage(Destination destination, final String message) {

		logger.info("send {} .....",message);
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}


}
