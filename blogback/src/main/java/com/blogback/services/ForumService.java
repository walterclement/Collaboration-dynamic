package com.blogback.services;

import java.util.List;

import com.blogback.model.Forum;

public interface ForumService {
	List<Forum> getAllForums();
	Forum addForum(Forum forum);

}
