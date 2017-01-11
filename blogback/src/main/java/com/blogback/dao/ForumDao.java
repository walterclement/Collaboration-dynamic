package com.blogback.dao;

import java.util.List;

import com.blogback.model.Forum;

public interface ForumDao {
	List<Forum> getAllForums();
	Forum addForum(Forum forum);
}
