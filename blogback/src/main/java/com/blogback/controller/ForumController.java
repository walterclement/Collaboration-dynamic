package com.blogback.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogback.dao.ForumDao;
import com.blogback.model.Forum;
import com.blogback.model.User;
import com.blogback.model.UserErr;
import com.blogback.services.ForumService;

@RestController
public class ForumController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private ForumService forumService;
	
	public ForumDao getForumDao() {
		return forumDao;
	}

	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}

	public ForumService getForumService() {
		return forumService;
	}

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}
	
	@RequestMapping(value="/allForums",method=RequestMethod.GET)
	public @ResponseBody List<Forum> getAllForums(){
		return forumService.getAllForums();
	}
	
	@RequestMapping(value="/forum",method=RequestMethod.POST)
	public ResponseEntity<?> addblog(@RequestBody Forum forum){
	
		logger.debug("FORUMCONTROLLER=>ADD " + forum);
		forum.setCreationDate(new Date());
		Forum savedForum=forumDao.addForum(forum);
		return new ResponseEntity<Forum>(savedForum,HttpStatus.OK);
			}

}
