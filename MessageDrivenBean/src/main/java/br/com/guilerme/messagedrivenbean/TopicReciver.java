package br.com.guilerme.messagedrivenbean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.com.guilherme.model.Produto;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jsm/topic/SoftTopic"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "java:/jsm/topic/SoftTopic")
public class TopicReciver implements MessageListener {

	
    public void onMessage(Message message) {
       ObjectMessage objectMessage = (ObjectMessage) message;
       
       try {
		Produto p = (Produto) objectMessage.getObject();
		System.out.println(p);
	} catch (JMSException e) {
		e.printStackTrace();
	}
      
    }

}
