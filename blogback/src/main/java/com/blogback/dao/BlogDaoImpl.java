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

import com.blogback.dao.BlogDao;
import com.blogback.model.Blog;
@Repository
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired 
	private SessionFactory sessionFactory;
	@Autowired
	private BlogDao blogDao;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public BlogDao getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Blog");
		List<Blog> blogs=query.list();
		session.close();
		return blogs;
	}

	public Blog addBlog(Blog blog) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(blog);
		session.getTransaction().commit();
		session.close();
		return blog;
	}

}
