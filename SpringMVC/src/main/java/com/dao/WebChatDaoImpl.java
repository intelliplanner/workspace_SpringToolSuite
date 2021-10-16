package com.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Student;
import com.bean.WebChat;


@Repository
public class WebChatDaoImpl implements WebChatDao {
	private static final Logger logger = LoggerFactory.getLogger(WebChatDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insert(WebChat webChat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(webChat);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WebChat> getMsg() {
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria c = session.createCriteria(WebChat.class);
		c.addOrder(Order.desc("id"));
		
		List<WebChat> list = c.list();//session.createQuery(" from WebChat").list();
		
		for (WebChat p : list) {
			logger.info("WebChat List::" + p);
		}
		return list;
	}
//	public List<WebChat> getMsg() {
//		Session session = this.sessionFactory.getCurrentSession();
//		List<WebChat> webChatlist = session.createQuery("from WebChat").list();
//		return webChatlist;
//	}

}
