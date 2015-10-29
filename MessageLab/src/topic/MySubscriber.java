package topic;

import java.util.Date;
import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import chat.ChatListener;

public class MySubscriber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jmsProvider = "tcp://localhost:61616";
		ConnectionFactory factory = new ActiveMQConnectionFactory(jmsProvider);
		try {
			while(true){
				Connection conn = factory.createConnection();
				Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
				Destination dest = session.createTopic("Topic_A");
				//创建consumer
				MessageConsumer mc = session.createConsumer(dest);
				conn.start();
				//拿到消息，textMessage
//				Message msg = mc.receive(2000);
//				if (msg!= null) {
//					System.out.println(((TextMessage)msg).getText());
//					System.out.println("Get successfully!");
//				}else{
//					System.out.println("Nothing received...");
//				}
				//打印消息
//				mc.receive(msg);
//				System.out.println(((TextMessage)msg).getText());
//				System.out.println("Get successfully!");
				
				mc.setMessageListener(new ChatListener());
				System.out.println("Wating for messages..Press ENTER to exit.");
				Scanner s = new Scanner(System.in);
				s.next();
				mc.setMessageListener(null);
				
				mc.close();
				session.close();
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
