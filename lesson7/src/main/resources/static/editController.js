app.controller('editController', function ($scope, $rootScope, $http, $location, $templateCache ) {
    const contextPath = 'http://localhost:8189/lesson7/api/v1';


    $scope.$on('routeChangeStart', function(event, next, current) {
        if (typeof(current) !== 'undefined') {
            $templateCache.remove(next.templateUrl);
        }
    });


    var oldName = $rootScope.editStudent.name;
    var oldAge = $rootScope.editStudent.age;

    $scope.updateStudent = function (student) {
        if ($scope.isEmptyStudentData(student) == false){
            $http.put(contextPath + '/students', student)
                .then(function (response) {
                    alert("ИЗМЕНЕНЫ ДАННЫЕ СТУДЕНТА: \nID: "
                    + response.data.id + "\nИмя: "
                    + response.data.name + "\nВозраст: "
                    + response.data.age);
                    $scope.editStudent = null;
            });
        }
    };

    $scope.isEmptyStudentData = function(student){
        if(oldName == student.name && oldAge == student.age){
            alert("Делать запрос в базу данных нет смысла," +
            "\nпотому что в данных нет изменений!");
            return true;
        }
        if(student == undefined || student == null){
            alert("Все поля должны быть заполнены!");
            return true;
        }
        if(student.name == undefined || student.name == null || student.name == ''){
            alert("Поле 'Имя студента' должно быть заполнено!");
            return true;
        }
        if(student.age == undefined || student.age == null || student.age == ''){
            alert("Поле 'Возраст' должно быть заполнено!");
            return true;
        }
        return false;
    };

    $scope.showStudentsPage = function() {
        $location.path("students");
    };


});