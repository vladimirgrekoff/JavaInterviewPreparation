app.controller('studentsController', function ($scope, $rootScope, $http, $location, $templateCache) {
    const contextPath = 'http://localhost:8189/lesson7/api/v1';

    $scope.loadStudents = function () {
            $http({
                url: contextPath + '/students',
                method: 'GET',
                params: {
                    min_age: $scope.filter ? $scope.filter.min_age : null,
                    max_price: $scope.filter ? $scope.filter.max_age : null,
                    max_age: $scope.filter ? $scope.filter.part_name : null
                }
            }).then(function (response) {
                $scope.studentsList = response.data;
        });
    };

    $scope.addNewStudent = function () {
        if ($scope.isEmptyStudentData() == false){
            $http.post(contextPath + '/students', $scope.newStudent)
                .then(function (response) {
                    alert("ДОБАВЛЕН НОВЫЙ СТУДЕНТ: \nID: "
                    + response.data.id + "\nИмя: "
                    + response.data.name + "\nВозраст: "
                    + response.data.age);

                    $scope.newStudent.name = null;
                    $scope.newStudent.age = null;
                    $scope.loadStudents();
            });
        }
    };

    $scope.isEmptyStudentData = function(){
        if($scope.newStudent == undefined || $scope.newStudent == null){
            alert("При добавлении нового студента все поля должны быть заполнены!");
            return true;
        }
        if($scope.newStudent.name == undefined || $scope.newStudent.name == null || $scope.newStudent.name == ''){
            alert("Поле 'Имя студента' должно быть заполнено!");
            return true;
        }
        if($scope.newStudent.age == undefined || $scope.newStudent.age == null || $scope.newStudent.age == ''){
            alert("Поле 'Возраст' должно быть заполнено!");
            return true;
        }
        return false;
    };

    $scope.clearForm = function () {
        $scope.newStudent.name = null;
        $scope.newStudent.age = null;
    };

    $scope.deleteStudent = function (studentId) {
        $http.delete(contextPath + '/students/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    };



    $scope.showEditStudentsPage = function(student) {
        $rootScope.editStudent = student;
        $location.path("edit");
    };

    $scope.loadStudents();

});