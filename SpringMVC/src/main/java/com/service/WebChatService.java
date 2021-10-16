package com.service;


import java.util.List;

import com.bean.WebChat;


public interface WebChatService {

	public void insert(WebChat webChat);
	public List<WebChat> getMsg();

}
