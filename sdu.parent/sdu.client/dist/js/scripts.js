angular.module('MyApp', ['ui.router','ngCookies','btford.socket-io', 'ngMessages','mgcrea.ngStrap'])
  .config(['$locationProvider','$urlRouterProvider', '$stateProvider' ,function($locationProvider,$urlRouterProvider,$stateProvider) {
    $locationProvider.html5Mode(true);
    $urlRouterProvider.otherwise('/');
    $stateProvider
      .state('any', {
        url: '/',
        templateUrl: '../templates/views/log.html',
        controller: function($rootScope,$state){
          // if($rootScope.currentUser){
          //   if($rootScope.currentUser.role){
          //     $state.go('users-list');
          //   }else{
          //     $state.go('manager-add');
          //   }
          // }else{
          //   $state.go('log');
          // }
            console.log("OKKK");
        }
      })
      .state('log', {
        url: '/log',
        templateUrl: '../templates/views/log.html',
        controller: 'LoginCtrl'
      })
      
      .state('reg',{
        url:'/reg',
        templateUrl:'../templates/views/reg.html',
        controller:'RegisCtrl'
      })
      .state('manager-add',{
        url:'/manager-add',
        templateUrl:'../templates/views/manager-add.html',
        controller:'ManagerAddCtrl'
      })
      .state('users-leads',{
        url:'/users-leads',
        templateUrl:'../templates/views/users-leads.html',
        controller:'UsersLeadsCtrl'
      })
      .state('leads-history',{
        url:'/leads-history',
        templateUrl:'../templates/views/leads-history.html',
        controller:'AdminAllLeadsCtrl'
      })
      .state('admin-leads',{
        url:'/admin-leads',
        templateUrl:'../templates/views/admin-leads.html',
        controller:'AdminLeadsCtrl'
      })
      
      .state('users-list',{
        url:'/users-list',
        templateUrl:'../templates/views/users-list.html',
        controller:'UsersListCtrl'
      });
  }]);

