package chat;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

public class ChatListener implements MessageListener{
	
	private ChatMessage tmpMessage = new ChatMessage();

	public void onMessage(ObjectMessage msg) {
		try {
			tmpMessage = (ChatMessage) msg;
			System.out.println(tmpMessage.getContent());
			System.out.println(tmpMessage.getTitle());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

}
