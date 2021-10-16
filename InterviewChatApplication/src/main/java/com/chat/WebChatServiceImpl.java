package com.chat;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chat.bean.WebChat;

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
