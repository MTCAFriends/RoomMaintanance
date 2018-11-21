<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="..\css\custom.css"/>
	 <script>
var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    /*.when("/", {
        templateUrl : "Home-page.html"
    })*/
    .when("/c", {
          templateUrl : "Profarma.html",
		conroller:"profarmaCtrl"
		
    })
	.when("/d", {
        templateUrl : "Reports.html",
		controller:"reportsCtrl"
    });
});
function logoutBtn(){
window.location.href="logout";
}
function addAccount(){

	window.location.href="Registration.html";
}
</script>
<style>

#Img-Margin, #time{
	margin-top:5px;
}
.dropdown-menu{
		height:220px;
		width:350px;
		padding:10px;
		text-align:center;

}
</style>
<script>
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('time').innerHTML ="Time:"+" "+h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
	
}
</script>	

  </head>
  <body ng-app="myApp" ng-controller="homeCtrl" onload="startTime()">
  <nav class="nav navbar-inverse">
 <div class="container-fluid">
    <div class="navbar-header">
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#!c">Profarma</a></li>
	  <li><a href="#!d">Reports</a></li>
	  <li><div type="button" class="btn btn-primary" id="time"></div></li>
    </ul>
	
	<div class="dropdown pull-right" id="Img-Margin">
    <img  src="deva.jpg"  height="50px" width="50px" class="img-circle dropdown-toggle" type="button"  data-toggle="dropdown">
    <span class="caret"></span>
    <ul class="dropdown-menu">
     <div class="bg-primary" > <li class="dropdown-header "></li>
		<li class="text-center"><a href="#">
	  <img  src="deva.jpg"  height="50px" width="50px" class="img-circle "></a><div class="center">Change image</div></li>
	  <li><p class="text-center">Deva - Web Developer</p></li>
      <li class="dropdown-body"></li>
	  <li class="divider"></li>
	  </div>
	 <li> </li>
	 <li class="divider"></li>
	 <li class="dropdown-footer">
		<button class="pull-left btn btn-primary" onclick="addAccount()">Add Account</button>
		<button class="pull-right btn btn-primary" onclick="logoutBtn()">Logout</button>
	 </li>
	 
    </ul>
  </div>
	</div>
  </div>
  </nav>

  
   <div ng-view id=""></div>
  
   <script>
	var app=angular.module('myApp');
		app.controller('homeCtrl',function($scope){
		
		
		});
   </script>

  </body>
  </html>