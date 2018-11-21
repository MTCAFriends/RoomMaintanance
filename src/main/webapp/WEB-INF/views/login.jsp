<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
  <title>Login Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css">


  <script src="Login.js">	   </script>
  <script>
  function forgotPassword(){
		window.location.href="Forgotpassword.html";
  }
</script>
  <style>
  #aaa{
		background-color:white;
  }
  #box-shadow{
 box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);
  }
 
  </style>
  </head>
  <body class="form-margin" onload="setDefaultValues()" ng-app="myApp" ng-controller="loginCtrl">
  <c:url var="loginUrl" value="/login" />
  <form name="Loginform" action="${loginUrl}" method="post">
	<div class="col-lg-5 col-lg-offset-3 col-lg-5 col-md-offset-3 col-sm-5 col-lg-offset-3 col-xs-5 col-xs-offset-3 jumbotron" 	id="box-shadow">
		<div class="form-group form-header">
			<div class="row">
			<div class="col-sm-7 col-sm-offset-4" id="reg"><h2 style="color:blue;font-weight:bold;">Login Form</h2></div>
			</div>
		</div>
		<div class="form-group">
		<div class="row">
			<div class="row col-lg-6 col-lg-offset-3">
			<div class="input-group">
				<span class="input-group-addon" id="sp1"><a href=""><i style="color:;" class="glyphicon glyphicon-envelope"></a></i></span>
				<div id="email-input-div"><input type="text" name="j_username" class="form-control"id="email" onkeydown="loginFormValidation()" placeholder="Enter email ID"></div>
			</div>
			<div  class="has-error" id="msg1"></div>
			</div>
		</div>
		</div>
		<div class="form-group">
		<div class="row">
			<div class="row col-lg-6 col-lg-offset-3">
			<div class="input-group">
				<span class="input-group-addon" id="sp2"><a href=""><i style="color:;" class="glyphicon glyphicon-lock"></a></i></span>
				<div id="pwd-input-div"><input type="password" name="j_password" class="form-control"id="pwd"onkeydown="loginFormValidation();passwordValidation();" placeholder="Enter Password"></div>
				<span class="input-group-addon" id="aaa"><i id="eyeOpenID" class="glyphicon glyphicon-eye-open" onclick="showPassword()"></i></span>
			</div>
			<div  class="has-error" id="msg2"></div>
			</div>
		</div>
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
		</div>
		<div class="row col-lg-6 col-lg-offset-3" >
		<div class="form-group">
					<div class="progress" id="mainProgressDiv">
						<div id="weak_progressbar"  class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" style="width:20%"></div>
						<div id="good_progressbar" class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" style="width:50%"></div>
						<div  id="strong_progressbar" class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" style="width:100%"></div>
					</div>
			</div>
		</div>
		<div class="form-group">
		<div class="row">
			<div class="col-lg-4 col-lg-offset-2">
					<div class="col-lg-4 col-lg-offset-2">
					<button type="button" class="btn btn-info btn-md" id="lbtn" onclick="openRegPage()">CreateAccount</button></div>
			</div>
			<div class="col-lg-6">
					<div class="col-lg-4 col-lg-offset-2">
					<button type="submit"  class="btn btn-success btn-md" id="lgbtn" onclick="return loginFormValidation()"href= >Login</button></div>
			</div>
			
		</div>
		</div>
		<div class="form-group">
		<div class="col-lg-6"><a type="button" class="btn btn-warning btn-md" onclick="forgotPassword()">Forgot password?</a></div>
		</div>
	</div>
  </form>
  <script>
  var app=angular.module('myapp');
  app.controller('loginCtrl',function($scope){
  
  });
  </script>
  </body>