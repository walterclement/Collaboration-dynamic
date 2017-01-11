var app=angular.module("myApp",['ngRoute'])
app.config(function($routeProvider){
	console.log('entering configuration')
	$routeProvider
	
	.when('/home',{
		templateUrl:'home/home.html'
	})
	.when('/login',{
		controller:'UserController',
		templateUrl:'user/login.html'
	})     
     .when('/signup',{
    	 	controller:'UserController',
			templateUrl:'user/signup.html'
          })
          
          .when('/blog',{
    	 	controller:'BlogController',
			templateUrl:'blog/blog.html'
          })

           .when('/forum',{
    	 	controller:'ForumController',
			templateUrl:'forum/forum.html'
          })
          
           .when('/chat',{
        	controller:'ChatCtrl',
			templateUrl:'chat/chat.html'
          })

          
          
	console.log('Entering in app')
	
})
