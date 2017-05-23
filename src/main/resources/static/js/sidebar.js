angular
    .module('MyApp', ['ngSanitize', 'ngMaterial', 'ngMessages', 'material.svgAssetsCache', 'ngRoute','cl.paging'])
    .config(function ($routeProvider, $locationProvider) {
        $routeProvider
            .when("/create", {
                templateUrl: "/create",
                controller: 'AppCtrl'
            })
            .when("/stands/:page", {
                templateUrl: "/content",
                controller: 'AppCtrl',
                resolve: {
                    stands: function ($q, $http, $route) {
                        var defer = $q.defer();
                        $http.get('/stands?page=' + $route.current.params.page).then(function (response) {
                            defer.resolve(response.data);
                        });
                        return defer.promise;
                    }
                }
            })
            .when("/", {
                templateUrl: "/content",
                controller: 'AppCtrl',
                resolve: {
                    stands: function ($q, $http) {
                        var defer = $q.defer();
                        $http.get('/stands').then(function (response) {
                            defer.resolve(response.data);
                        });
                        return defer.promise;
                    }
                }
            })
            .when("/stand/:id", {
                templateUrl : "/stand",
                controller: 'AppCtrl',
                resolve: {
                    stand: function ($q,$http,$route) {
                        var defer = $q.defer();
                        $http.get('/'+$route.current.params.id).then(function (response) {
                            defer.resolve(response.data);
                        });
                        return defer.promise;
                    }
                }
            })
            .when("stand/:id/update", {
                templateUrl : "/create",
                controller: 'AppCtrl',
                resolve: {
                    stand: function ($q,$http,$route) {
                        var defer = $q.defer();
                        $http.get('/'+$route.current.params.id+'/update').then(function (response) {
                            defer.resolve(response.data);
                        });
                        return defer.promise;
                    }
                }
            })
            .otherwise({
                redirectTo: '/'
            });
        // $locationProvider.html5Mode(true);
    })
    .controller('AppCtrl', function ($scope, $timeout, $mdSidenav, $log,$window) {
        angular.element(document).ready(function () {
            CKEDITOR.replace('editor1');
            CKEDITOR.config.codeSnippet_theme = 'idea';
        });
        $scope.toggleLeft = buildDelayedToggler('left');
        $scope.toggleRight = buildToggler('right');
        $scope.isOpenRight = function () {
            return $mdSidenav('right').isOpen();
        };
        $scope.thisPage = function (pageId) {
            $window.location.href = '/#/stands/'+pageId;
        };
        /**
         * Supplies a function that will continue to operate until the
         * time is up.
         */
        function debounce(func, wait, context) {
            var timer;

            return function debounced() {
                var context = $scope,
                    args = Array.prototype.slice.call(arguments);
                $timeout.cancel(timer);
                timer = $timeout(function () {
                    timer = undefined;
                    func.apply(context, args);
                }, wait || 10);
            };
        }

        /**
         * Build handler to open/close a SideNav; when animation finishes
         * report completion in console
         */
        function buildDelayedToggler(navID) {
            return debounce(function () {
                // Component lookup should always be available since we are not using `ng-if`
                $mdSidenav(navID)
                    .toggle()
                    .then(function () {
                        $log.debug("toggle " + navID + " is done");
                    });
            }, 200);
        }

        function buildToggler(navID) {
            return function () {
                // Component lookup should always be available since we are not using `ng-if`
                $mdSidenav(navID)
                    .toggle()
                    .then(function () {
                        $log.debug("toggle " + navID + " is done");
                    });
            };
        }
        $scope.currentPage = 0;

        $scope.paging = {
            total: 10,
            current: 1,
            onPageChanged: loadPages
        };

        function loadPages() {
            console.log('Current page is : ' + $scope.paging.current);

            $window.location.href = '/#/stands/'+$scope.paging.current;

            $scope.currentPage = $scope.paging.current;
        }
    })
    .controller('LeftCtrl', function ($scope, $timeout, $mdSidenav, $log) {
        $scope.close = function () {
            // Component lookup should always be available since we are not using `ng-if`
            $mdSidenav('left').close()
                .then(function () {
                    $log.debug("close LEFT is done");
                });

        };
    })
    .controller('RightCtrl', function ($scope, $timeout, $mdSidenav, $log) {
        $scope.close = function () {
            // Component lookup should always be available since we are not using `ng-if`
            $mdSidenav('right').close()
                .then(function () {
                    $log.debug("close RIGHT is done");
                });
        };
    });
