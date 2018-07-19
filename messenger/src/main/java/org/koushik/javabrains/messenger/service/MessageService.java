package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messenger.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Message;

public class MessageService {
	
	private static Map<Long,Message> messages= DatabaseClass.getMessage();
	
	public MessageService() {}
static{
		
		messages.put(1l, new Message(1l, "Hello World!" ,new Date("Thu Jul 19 10:03:18 MST 2018") , "Abhishek"));
		messages.put(2l, new Message(2l, "Hello Jersey!",new Date("Thu Jul 19 10:03:18 MST 2018"),  "Abhishek"));
}
	public List<Message> getAllMessages(){
		/*
		Message m1=new Message(1l, "Hello World!" , "Abhishek");
		Message m2=new Message(2l, "Hello Jersey!" , "Abhishek");

		List<Message> list=new ArrayList<Message>();
		list.add(m2);
		list.add(m2);
		
		return list;*/
		
		return new ArrayList<Message>(messages.values());
		
		
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
		{
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage(long id) 
	{
		return messages.remove(id);
	}
	public Message getMessage(long id) {
		// TODO Auto-generated method stub
		return messages.get(id);
	}

}
