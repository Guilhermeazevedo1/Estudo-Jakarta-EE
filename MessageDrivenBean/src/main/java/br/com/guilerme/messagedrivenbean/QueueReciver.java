package br.com.guilerme.messagedrivenbean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jsm/queue/SoftQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jsm/queue/SoftQueue")
public class QueueReciver implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			String mensagem = textMessage.getText();
			System.out.println("Mensagem lida da fila: " + mensagem);
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
		
	}

    

}
