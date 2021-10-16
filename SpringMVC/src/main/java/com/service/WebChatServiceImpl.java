package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.WebChat;
import com.dao.WebChatDao;

@Service
@Transactional
public class WebChatServiceImpl implements WebChatService {

	private WebChatDao webChatDao;

	public void setWebChatDao(WebChatDao webChatDao) {
		this.webChatDao = webChatDao;
	}

	public void insert(WebChat webChat) {
		webChatDao.insert(webChat);
	}

	public List<WebChat> getMsg() {
		return webChatDao.getMsg();
	}

}
