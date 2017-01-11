app.controller('ForumController',function($scope,$location,ForumService,$rootScope){
	$scope.forums={};
	$scope.forum={forumId:'',question:'',author:'',summary:'',creationDate:''};
	$scope.message;
	
	function getAllForums()
	{
console.log('Entering getAllForums')
ForumService.getAllForums()
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
	getAllForums();
	
	$scope.addForum=function(){
		console.log('Entering addForum')
		ForumService.addForum($scope.forum)
			.then(function(response)// success
					{
						console.log('Forum added successfully' + response.status)
						$location.path("/forum")
					},
					function(response)// Failure
					{
						console.log('add failed' +response.status)
						console.log(response.data)
						$scope.errorMessage="Forum added Failed..." + response.data.message
						$location.path("/forum")
				})
	}
	
})
	
	