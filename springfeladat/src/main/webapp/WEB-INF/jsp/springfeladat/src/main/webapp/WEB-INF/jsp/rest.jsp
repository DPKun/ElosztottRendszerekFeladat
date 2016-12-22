<!DOCTYPE html>
<html lang="en-US">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);
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
</div>




</body>
</html>