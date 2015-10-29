package chat;

import java.io.Serializable;
import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jmx.export.naming.SelfNaming;




public class ChatPublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jmsProvider = "tcp://localhost:61616";
		ConnectionFactory factory = new ActiveMQConnectionFactory(jmsProvider);
		try {
//			while(true){
//				Thread.sleep(800);
//				Connection conn = factory.createConnection();
//				Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
//				Destination dest = session.createQueue("Topic_A");
//				//创建producer
//				MessageProducer mp = session.createProducer(dest);
//				//创建消息，textMessage
//				Message msg = session.createTextMessage(new Date().toLocaleString());
//				//发送消息
//				mp.send(msg);
//				System.out.println("Sent successfully!");
//				mp.close();
//				session.close();
//				conn.close();
//			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public void sendAMessage(String content, String title) throws JMSException {
		String jmsProvider = "tcp://localhost:61616";
		ConnectionFactory factory = new ActiveMQConnectionFactory(jmsProvider);
		Connection conn = factory.createConnection();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		ChatMessage tmpMessage = new ChatMessage();
		tmpMessage.setContent(content);
		tmpMessage.setTitle(title);
		
		Destination dest = session.createQueue("Topic_A");
		//创建producer
		MessageProducer mp = session.createProducer(dest);
		//创建消息，textMessage
//		Message msg = session.createTextMessage(new Date().toLocaleString());
		//创建可序列化的objectMessage
		ObjectMessage objectMessage = session.createObjectMessage((Serializable) tmpMessage);
		//发送消息
		mp.send(objectMessage);
		System.out.println("Sent successfully!");
		mp.close();
		session.close();
		conn.close();
	}

}
