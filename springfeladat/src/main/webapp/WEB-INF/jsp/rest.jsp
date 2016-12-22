<!DOCTYPE html>
<html lang="en-US">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>
<script>
var app = angular.module('myApp', ['ngMaterial']);
app.factory("coursesfac", function($http){
	return {
		 list: function(callback){
			 $http.get("angular/getCourses").success(callback);
		 }
	
	};
});
app.controller('myCtrl', function($scope, $http, coursesfac) {
	coursesfac.list(function(courses){
		$scope.data=courses;
    });
});
</script>

<body>

<div ng-app="myApp" ng-controller="myCtrl"> 

<p>The courses are: </p>
<p ng-show="!data.length">No course is added!</p>


<table ng-hide= "!data.length" rules="all" frame="border" width="300">
<tr><td><b>CourseName</b></td> <td><b>CourseCredit </b></td> <td><b>PreferedSemester </b></td> </tr>
  <tr ng-repeat="x in data"  >
  <td>{{x.courseName}}</td>
  <td>{{x.courseCredit}}</td>
  <td>{{x.preferedSemester}}</td>
  </tr>
</table>

<form name="myForm">
<md-button class="md-raised" md-primary type="submit">neve a gombnak</md-button>
</div>
</form >
</body>
</html>