package com.blogback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blogback.dao.ForumDao;
import com.blogback.model.Forum;
@Repository
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired 
	private SessionFactory sessionFactory;
	@Autowired
	private ForumDao forumDao;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ForumDao getForumDao() {
		return forumDao;
	}

	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}

	public List<Forum> getAllForums() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Forum");
		List<Forum> forums=query.list();
		session.close();
		return forums;
	}

	public Forum addForum(Forum forum) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(forum);
		session.getTransaction().commit();
		session.close();
		return forum;
	}


}
