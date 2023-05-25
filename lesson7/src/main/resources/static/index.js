var app = angular.module('lesson7', ['ngRoute'])
    .config(function ($routeProvider) {
    $routeProvider.when('/students',
    {
    templateUrl:'studentsTemplate.html',
    controller:'studentsController',
    controllerAs:'students'
    })
    .when('/edit',
    {
    templateUrl:'editStudentsTemplate.html',
    controller:'editController',
    controllerAs:'edit'
    })
    .otherwise({
    redirectTo: '/students'
    });
});