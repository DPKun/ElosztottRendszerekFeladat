<!DOCTYPE html>
 <html lang="en-US">
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
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
 
 
 <form name="myForm" novalidate >
                <p>Course Name:</p>
                <input type="text" name="courseName" placeholder="Course Name"  ng-model="courseName" required />
                <div ng-show="myForm.username.$dirty && myForm.username.$invalid">Invalid:
<span ng-show="myForm.username.$error.required">Course name is required.</span></div>

 <p>Course Credit:</p>
   <input type="text" name="courseCredit" ng-model="courseCredit" ng-pattern="/^[0-9]{1,2}$/" value="0" ng-init="courseCredit = '0'" required>
 	<span ng-show="myForm.credit.$invalid">Please, write a valid number.</span>
 	
 	<p>Semester:</p>
   <input type="text" name="preferedSemester" ng-model="preferedSemester" ng-pattern="/^[0-9]{1,2}$/" value="0" ng-init="preferedSemester = '0'" required>
 	<span ng-show="myForm.credit.$invalid">Please, write a valid number.</span>
 	<p>
    <button type="submit" ng-disabled="myForm.courseName.$pristine || (myForm.courseCredit.$dirty && myForm.courseCredit.$invalid ) || (myForm.preferedSemester.$dirty && myForm.preferedSemester.$invalid )  || (myForm.courseName.$dirty && myForm.courseName.$invalid)" ng-click="send()">Send</button>
</p>
</form><br>
 </div>
 
 
 <script>
 var app = angular.module('myApp', []);
 app.controller('myCtrl', function($scope, $http) {
 	$http.get("angular/getCourses")
     .then(function(response) {
     	console.log(response);
         $scope.data = response.data;
         console.log(response.data);
     });
    $scope.send = function() {
        $scope.course = angular.copy($scope.master);
        $http.post("angular/addCourse", {'courseName': $scope.courseName, 'courseCredit' : $scope.courseCredit,'preferedSemester':$scope.preferedSemester }).then(function(response){
        	console.log("Lefutott")
        	window.location.reload(); 
        });
    
        
    };
    
    
});

 </script>
 
 </body>
 </html> 