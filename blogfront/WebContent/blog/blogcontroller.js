app.controller('BlogController',function($scope,$location,BlogService,$rootScope){
	$scope.blogs={};
	$scope.blog={blogId:'',btitle:'',bauthor:'',btag:'',bcontent:'',creationDate:''};
	$scope.message;
	
	function getAllBlogs()
	{
console.log('Entering getAllBlogs')
BlogService.getAllBlogs()
	.then(function(response){
			console.log(response.data)
			console.log(response.status)
			return response.data;
			 
		},
		function(response){
			console.log(response.data);
			return response.data;
		})
	}
	getAllBlogs();
	
	$scope.addBlog=function(){
		console.log('Entering addBlog')
		BlogService.addBlog($scope.blog)
			.then(function(response)// success
					{
						console.log('Blog added successfully' + response.status)
						$location.path("/blog")
					},
					function(response)// Failure
					{
						console.log('add failed' +response.status)
						console.log(response.data)
						$scope.errorMessage="Blog added Failed..." + response.data.message
						$location.path("/blog")
				})
	}
	
})
	
	