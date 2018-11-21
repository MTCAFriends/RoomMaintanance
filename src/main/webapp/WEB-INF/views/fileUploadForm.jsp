<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>User Management</title>
  <script
     src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script type="text/javascript">
  var app = angular.module('myapp', []);
  
  
  app.service('UserCRUDService', [ '$http', function($http) {
	  this.addUser = function addUser(name, email,password) {
		    return $http({
		        method : 'POST',
		        url : 'user',
		        headers: { 
		        	'Accept': 'application/json',
		        	'Content-Type': 'application/json' 
		        	},
		        data : {
		        	appUserName : name,
		        	appUserEmailID: email,
		        	appUserPassword : password
		        }
		    });
		}

	} ]);
  app.controller('myappcontroller', ['$scope','UserCRUDService', 
	  function ($scope,UserCRUDService) {
	  $scope.addUser = function () {
		    if ($scope.user != null && $scope.user.name) {
		        UserCRUDService.addUser($scope.user.name, $scope.user.email,$scope.user.password)
		          .then (function success(response){
		              $scope.message = 'User added!';
		              $scope.errorMessage = '';
		          },
		          function error(response){
		              $scope.errorMessage = 'Error adding user!';
		              $scope.message = '';
		        });
		    }
		    else {
		        $scope.errorMessage = 'Please enter a name!';
		        $scope.message = '';
		    }
		}
	}]);
  
</script>
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-app="myapp" ng-controller="myappcontroller">
<table>
    <tr>
        <td width="100">ID:</td>
        <td><input type="text" id="name" ng-model="user.name" /></td>
    </tr>
    <tr>
        <td width="100">Name:</td>
        <td><input type="text" id="email" ng-model="user.email" /></td>
    </tr>
    <tr>
        <td width="100">Age:</td>
        <td><input type="password" id="age" ng-model="user.password" /></td>
    </tr>
    <button ng-click="addUser()">Add User</button>
</table>
</body>
</html>