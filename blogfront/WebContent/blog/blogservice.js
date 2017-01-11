app.factory('BlogService',function($http){
	var BASE_URL="http://localhost:8093/blogback";
		var blogService=this;
		
	blogService.getAllBlogs=function(){
		return $http.get(BASE_URL + "/allBlogs")
		
	}
	
	
	blogService.addBlog=function(blog){
		return $http.post(BASE_URL + "/blog" , blog);
	}

	  return blogService;
})