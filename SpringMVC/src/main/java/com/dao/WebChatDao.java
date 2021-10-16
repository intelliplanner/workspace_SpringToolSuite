package com.dao;


import java.util.List;

import com.bean.WebChat;



	public interface WebChatDao {

		public void insert(WebChat webChat);
		public List<WebChat> getMsg();

	}

