package com.chat;


import java.util.List;
import com.chat.bean.WebChat;


public interface WebChatService {

	public void insert(WebChat webChat);
	public List<WebChat> getMsg();

}
