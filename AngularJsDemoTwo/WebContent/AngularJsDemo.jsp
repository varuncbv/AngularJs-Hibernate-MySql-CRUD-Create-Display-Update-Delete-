
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Angular JS Demo</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
<script>
var App=angular.module('myApp',[]);
App.controller("myController",function($scope,$http,$log){
	
getEmployees();
	
	function getEmployees(){
		var success=function(response){
			$scope.employees=response.data;
			$log.info(response);
		};
		
		var error=function(reason){
			$scope.error=reason.data;
			$log.info(reason);
		};
		
		$http({
			method:'GET',
			url:'GetAllEmployees'
			}).then(success,error);
	}

	
	$scope.buttonText="Add";
	
	$scope.submit = function() {
		if($scope.buttonText=='Add'){
			$http({
				method:'POST',
				url:'CreateEmployee',
				headers: {'Content-Type': 'application/json'},
				data:  $scope.Emp
		});
			$scope.message ="Record Added successfully,press 'RESET' button to see the changes";
		}else if($scope.buttonText=='Update'){
			$http({
				method:'POST',
				url:'UpdateEmployee',
				headers: {'Content-Type': 'application/json'},
				data:  $scope.Emp
		});
			$scope.message ="Record Updated successfully,press 'RESET' button to see the changes";
		}else if($scope.buttonText=='Delete'){
			$http({
				method:'POST',
				url:'DeletePerson',
				headers: {'Content-Type': 'application/json'},
				data:  $scope.Emp
		});
			
			$scope.message ="Record deleted successfully,press 'RESET' button to see the changes";
		};
		
	};
	
	
	 $scope.reset = function(){
	       
	    	window.location.reload(); //reset Form
	    };
	    
	    
	    
	    $scope.updateEmployee = function (employee) {
			$scope.Emp=employee;
			$scope.buttonText="Update";		
		 };
	    
	    $scope.deleteEmployee = function (employee) {
			$scope.Emp=employee;
			$scope.buttonText="Delete";		
		 };
});
</script>
</head>
<body ng-app="myApp">
<div ng-controller="myController">
<form>
<h2>Add an Employee</h2>
          <input type="hidden" ng-model="Emp.id" />
            
            <table >
            
            <tr>
            <td>Name:</td>
           <td> <input type="text" name="name" id="name" ng-model="Emp.name" required /></td>
           </tr> <tr>
            <td>DESIGNATION:</td>
            <td><input type="text" name="designation" id="designation"  ng-model="Emp.designation" required /></td>
            </tr> <tr>
            <td>SALARY:</td>
            <td><input type="text" name="salary" id="salary" ng-model="Emp.salary"  required /></td>
             </tr><tr>
             
            
             <td>
                           
             <button type="button"  ng-click="submit()" class="btn btn-primary btn-sm">{{buttonText}}</button>
             <button type="button"  ng-click="reset()" class="btn btn-warning btn-sm">Reset</button></td>
           
            
            </tr>
           
            
           </table>
           
 <div>{{message}}</div>  
 
 <h2>Employee Information</h2>
<table border="2"  width="70%"  cellpadding="2">
<tr>
<td><b>id</b></td>
<td><b>name</b></td>
<td><b>designation</b></td>
<td><b>salary</b></td>
<td></td>
</tr>
<tr ng-repeat="employee in employees">
<td>{{employee.id}}</td>
<td>{{employee.name}}</td>
<td>{{employee.designation}}</td>
<td>{{employee.salary}}</td>
<td><button type="button" ng-click="updateEmployee(employee)">Edit</button>
<button type="button" ng-click="deleteEmployee(employee)">Delete</button></td>
</tr>
</table>         

</form>

</div>

</body>
</html>