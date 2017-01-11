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

import com.blogback.dao.UserDao;
import com.blogback.model.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired 
	private SessionFactory sessionFactory;
	@Autowired
	private UserDao userDao;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User authenticate(User user) {
		logger.debug("USERDAOIMPL :: AUTHENTICATE");
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where uname=?  and pwrd=?");
		query.setString(0,user.getUname());
		query.setString(1, user.getPwrd());
		User validUser=(User) query.uniqueResult();
		session.close();
		if(validUser!=null)
			logger.debug("VALID USER IS  " + validUser.getUname() + " " + validUser.getRole() + " " + validUser.isOnline());;
			if(validUser==null)
				logger.debug("Valid USER is null");
		return validUser;
	}

	public void updateUser(User user) {
		logger.debug("USERDAOIMPL::UPDATE");
		logger.debug("ISONLINE VALUE IS [BEFORE UPDATE]" + user.isOnline());

		// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			User existingUser=(User) session.get(User.class, user.getUserid());
			existingUser.setOnline(user.isOnline());
			session.update(existingUser);
			session.getTransaction().commit();
			//session.flush();
			session.close();
			logger.debug("ISONLINE VALUE IS [AFTER UPDATE] " + existingUser.isOnline());

	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from User");
		List<User> users=query.list();
		session.close();
		return users;
	}

	public User registerUser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}

}
