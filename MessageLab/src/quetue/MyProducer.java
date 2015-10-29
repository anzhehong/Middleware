package quetue;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;




public class MyProducer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jmsProvider = "tcp://localhost:61616";
		ConnectionFactory factory = new ActiveMQConnectionFactory(jmsProvider);
		try {
			while(true){
				Thread.sleep(800);
				Connection conn = factory.createConnection();
				Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
				Destination dest = session.createQueue("MyQueue_A");
				//创建producer
				MessageProducer mp = session.createProducer(dest);
				//创建消息，textMessage
				Message msg = session.createTextMessage(new Date().toLocaleString());
				//发送消息
				mp.send(msg);
				System.out.println("Sent successfully!");
				mp.close();
				session.close();
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
