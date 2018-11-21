<!DOCTYPE html>
<html lang="en">
<head>
<title>Reg2</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="..\Angular\css\bootstrap.min.css">
<script src="..\Angular\js\angular\jquery.min.js"></script>
<script src="..\Angular\js\angular\bootstrap.min.js"></script>
<script src="..\Angular\js\angular\angular.min.js"></script>
<script src="..\Angular\js\bootstrap-datepicker.js"></script>
<link rel="stylesheet" href="..\Angular\css\bootstrap-datetimepicker.css">
<script src="..\Angular\js\angular\angular-route.js"></script>
<script src="..\Angular\js\angular\angular-messages.js"></script>
<link rel="stylesheet" href="..\Angular\css\font-awesome.min.css">
 <link rel="stylesheet" href="..\Angular\css\custom.css">
 <script src="..\Angular\js\angular\regCtrl.js"></script>
<style>

</style>	

</head>
<body class="form-margin" ng-app="valData" ng-controller="regCtrl" oncontextmenu="return false;">
<form id="regForm" name="regForm" novalidate>
	<div class="container">
		<div class="col-lg-8 col-lg-offset-2 jumbotron" id="box-shadow">
			<div class="form-group">
				<div class="row">
					<div class="col-sm-9 col-sm-offset-3" id="reg"><h3 style="color:blue;font-weight:bold;">Registration Form</h3></div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"><a href=""><i class="glyphicon glyphicon-user"></a></i></span>
							<input type="text" class="form-control" ng-model="fname" ng-pattern="/^[A-Za-z]+$/" name="fname"id="fname" placeholder="Enter First Name" required>
							
						</div>
						<div class="has-error" id="msg1">
						<div ng-messages="regForm.fname.$error" ng-if="!regForm.fname.$pristine && regForm.fname.$invalid">
						<div ng-message="required"> First Name required</div>
						<div ng-message="pattern">Invalid Name</div>
						</div>
						
						</div>
						
					</div>
					<div class="col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"><a href=""><i class="glyphicon glyphicon-user"></a></i></span>
							<input type="text" class="form-control"ng-model="lname" ng-pattern="/^[A-Za-z]+$/" name="lname"id="lname" placeholder="Enter Last Name" required>
							
						</div>	
						<div class="has-error" id="msg2">
						<div ng-messages="regForm.lname.$error" ng-if="!regForm.lname.$pristine && regForm.lname.$invalid">
						<div ng-message="required"> Last Name required</div>
						<div ng-message="pattern">Invalid Name</div>
						</div>
			
						</div>						
					</div>
				</div>
			</div>
			<div class="form-group">
		<div class="row">
			<div class="col-lg-6 col-md-6">
			<div class="input-group">
				<span class="input-group-addon"><a href=""><i class="glyphicon glyphicon-th"></a></i></span>
				<input type="text" class="form-control" id="mobile" ng-model="mobileNumber" 
				ng-pattern="/^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/" name="mobileNumber"placeholder="Enter Mobile Number" required>
			</div>
			<div class="has-error" id="msg3">
			<div ng-messages="regForm.mobileNumber.$error" ng-if="!regForm.mobileNumber.$pristine && regForm.mobileNumber.$invalid">
					<div ng-message="required"> Mobile number required</div>
					<div ng-message="pattern">Mobile number should be 10 digits</div>
				</div>
			
			</div>	
			</div>
			<div class="col-lg-6 col-md-6">
			<div class="input-group">
				<span class="input-group-addon"><a href=""><i class="glyphicon glyphicon-envelope"></a></i></span>
				<input type="email" class="form-control"name="email" ng-model="email" id="email" placeholder="Enter Emai-id (Login ID)" required>
			</div>
				<div class="has-error" id="msg4">
				<div ng-messages="regForm.email.$error" ng-if="!regForm.email.$pristine && regForm.email.$invalid">
						<div ng-message="required">Email required</div>
						<div ng-message="email">Invalid Email</div>
						
				</div>	
			</div>
		</div>
		</div>
		</div>
		<div class="form-group">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="input-group">
				<span class="input-group-addon"><a href=""><i class="glyphicon glyphicon-lock"></a></i></span>
				<input type="password" class="form-control"name="pwd" ng-model="pwd" pattern="^[a-zA-Z]\w{3,14}$" id="pwd" placeholder="Password (Login pwd)" required>
				</div>
				<div class="has-error" id="msg5">
					<div ng-messages="regForm.pwd.$error" ng-if="!regForm.pwd.$pristine && regForm.pwd.$invalid">
						<div ng-message="required">Password required</div>
						<div ng-message="pattern">Password min 8 char atleast Alpha,Special char,number</div>
				</div>	
				</div>	
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="input-group">
				<span class="input-group-addon"><a href=""><i class="glyphicon glyphicon-lock"></a></i></span>
				<input type="password" class="form-control"name="conformpwd" ng-model="conformpwd" id="conformpwd" placeholder="Confirm Password" required>
			</div>
			<div class="has-error" id="msg6">
						<div ng-messages="regForm.conformpwd.$error" ng-if="!regForm.conformpwd.$pristine && regForm.conformpwd.$invalid">
						<div ng-message="required"> Password required</div>
						<div ng-message="notMatch"> Not Matched</div>
						</div>
	
			</div>
		</div>
		</div>
		</div>
		<div class="form-group">
		<div class="row">
			<div class="col-lg-6 col-md-6">
			<div class="input-group">
				<span class="input-group-addon"><a href=""><i class="glyphicon glyphicon-list"></a></i></span>
			<div><textarea type="text" ng-model="address" name="address" ng-minlength="20" ng-maxlength="1000" rows="5" cols="35" placeholder="Address for Communication" required></textarea></div>
					
			</div>
					<div class="has-error" id="msg7" >	
					<div ng-messages="regForm.address.$error" ng-if="!regForm.address.$pristine && regForm.address.$invalid">
						<div ng-message="required">Address Required</div>
						<div ng-message="minlength">Minimum 20 char</div>
						<div ng-message="maxlength">Maximum 1000 char</div>
						
						</div>
					</div>
			</div>
			<div class="col-lg-6 col-md-7">
				<label>UploadPhoto</label><input type="file" id="photo" ng-file-model="file_name"  ng-model="photo" name="photo">
			</div>
		</div>
		</div>
			<div class="form-group">
		<div class="row">
			<div class="col-lg-6">
				<label class="col-lg-5 label-control">Date Of Birth</label>
				 <div class="col-sm-7">
            <div class="input-group date" data-provide="datepicker">
                <input type="text" class="form-control" ng-model="dob" name="dob" id="my-dob">
                <div class="input-group-addon">
                    <span class="glyphicon glyphicon-th"></span>
                </div>
            </div>
        </div>
				<!--<div class="col-lg-7 date"><input type="text" class="form-control" ng-model="dob" name="dob" id="my-dob" required></div>-->
			</div>
			<div class="has-error" id="msg7" >	
					<div ng-messages="regForm.dob.$error" ng-if="!regForm.dob.$pristine && regForm.dob.$invalid">
						<div ng-message="required">Date of Birth Required</div>
						
						</div>
					</div>
			<div class="col-lg-6 col-md-6">
			<label class="col-lg-3 label-control">Gender</label>
				<div class="col-lg-4"><input type="radio" name="gender" class="" id="male" value="" >Male</div>
				<div class="col-lg-5"><input type="radio" name="gender"  class="" id="female" value="">Female</div>
			</div>
		</div>
		</div>
		<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
			<div class="col-lg-12 col-md-12">
			<div class="col-lg-4 col-md-4">
			<button type="submit" id="subbtn" name="submit" ng-click="sumbitRegDetails(regForm)" class="btn btn-primary">Submit</button>
			</div>
			<div class="col-lg-4 col-md-4">
				<button type="clear" id="clrbtn" name="clear" class=" btn btn-danger">Clear</button>
			</div>
			<div class="col-lg-4 col-md-4">
			<a class=" btn btn-default" href="Login2.html" >Back</a>
			</div>
			</div>
			</div>
		</div>
		</div>
			
		</div>
	</div>
</form>

</body>


</html>