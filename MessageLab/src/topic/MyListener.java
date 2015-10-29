package topic;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyListener implements MessageListener{
	
	public void onMessage(Message msg) {
		try {
			System.out.println(((TextMessage) msg).getText());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
