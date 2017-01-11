package com.blogback.dao;

import java.util.List;

import com.blogback.model.Blog;

public interface BlogDao {
	List<Blog> getAllBlogs();
	Blog addBlog(Blog blog);
}
