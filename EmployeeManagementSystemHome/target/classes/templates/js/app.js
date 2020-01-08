var myApp = angular.module("myApp", []);

myApp.controller("myController", function($scope,$http){
	console.log("in controller...");
	$scope.newUser = {};
	$scope.info = "";

	/*$scope.users = [
		{username: "rimon", fullName: "Md. Mamunur Rashid Rimon", email:"rimonmath@gmail.com"},
		{username: "shamim", fullName: "Md. Tamim Hossain", email:"shamim@gmail.com"},
		{username: "tamim", fullName: "Tamim Iqbal", email:"tamim@gmail.com"}
	];*/
	                    $scope.users = [];
							refreshCourseData();
							function refreshCourseData() {
								$http({
					     			method : 'GET',
									url : 'http://localhost:8080/users'
								}).then(function(response) {
									$scope.users = response.data;
								});
							}

	/*$scope.saveUser = function(){
		console.log("Saving...");
		$scope.users.push($scope.newUser);
		$scope.info = "New User Added Successfully!";
		$scope.newUser = {};
	};
*/
							
							   $scope.saveUser = function() {
								   
							        var method = "";
							        var url = "";
						            method = "POST";
							        url = 'http://localhost:8080/save';
							       
							 
							        $http({
							            method: method,
							            url: url,
							            data: angular.toJson($scope.users.push($scope.newUser)),
							            headers: {
							                'Content-Type': 'application/json'
							            }
							        }).then(_success, _error);
							    };
							 
							 
							 
							
 ///
							
	$scope.selectUser = function(user){
		$scope.clickedUser = user;
	};

	$scope.deleteUser = function(){
		console.log($scope.users.indexOf($scope.clickedUser));
		$scope.users.splice($scope.users.indexOf($scope.clickedUser), 1);
		$scope.info = "User Deleted Successfully!";
	};

	$scope.clearInfo = function(){
		$scope.info = "";
	};
});