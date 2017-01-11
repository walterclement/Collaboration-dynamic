app.factory('ForumService',function($http){
	var BASE_URL="http://localhost:8093/blogback";
		var forumService=this;
		
		forumService.getAllForums=function(){
		return $http.get(BASE_URL + "/allForums")
		
	}
	
	
		forumService.addForum=function(forum){
		return $http.post(BASE_URL + "/forum" , forum);
	}

	  return forumService;
})