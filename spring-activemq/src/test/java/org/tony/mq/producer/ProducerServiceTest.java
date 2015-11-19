package org.tony.mq.producer;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/spring-context.xml","/spring-activemq.xml"})
public class ProducerServiceTest {
	
	@Autowired
	private ProducerService producerService;
	@Autowired  
    @Qualifier("queueDestination")  
    private Destination destination;  
	
	@Test
	public void testSendMessage(){
		String message = "this is tony first message";
		for (int i = 0; i < 100; i++) {
			message +="i";
			producerService.sendMessage(destination, message);
		}
	}

}
