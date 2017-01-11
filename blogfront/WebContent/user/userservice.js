app.factory('UserService',function($http){
	var BASE_URL="http://localhost:8093/blogback";
		var userService=this;
		
	userService.getAllUsers=function(){
		return $http.get(BASE_URL + "/allUsers")
		
	}
	
	userService.authenticate=function(user){
		return $http.post(BASE_URL + "/login",user);
	}
	
	userService.registerUser=function(user){
		return $http.post(BASE_URL + "/signup" , user);
	}
	
	
	userService.logout=function(){
		//console.log('entering logout service')
		return $http.put(BASE_URL + "/logout")
	}
	  return userService;
})