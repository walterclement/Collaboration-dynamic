package com.blogback.services;

import java.util.List;

import com.blogback.model.Blog;

public interface BlogService {
	List<Blog> getAllBlogs();
	Blog addBlog(Blog blog);

}
