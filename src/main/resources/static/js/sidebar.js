angular
    .module('MyApp',['ngMaterial', 'ngMessages', 'material.svgAssetsCache','ngRoute'])
    .config(function ($routeProvider,$locationProvider) {
        $routeProvider
            .when("/create", {
                templateUrl : "/create",
                controller: 'AppCtrl'
            })
            .when("/", {
                templateUrl : "/content",
                controller: 'AppCtrl'
            })
            .otherwise({
                redirectTo:'/'
            });
        // $locationProvider.html5Mode(true);
    })
    .controller('AppCtrl', function ($scope, $timeout, $mdSidenav, $log,$http) {
        angular.element(document).ready(function () {
            CKEDITOR.replace('editor1');
            CKEDITOR.config.codeSnippet_theme = 'idea';
        });
        $scope.toggleLeft = buildDelayedToggler('left');
        $scope.toggleRight = buildToggler('right');
        $scope.isOpenRight = function(){
            return $mdSidenav('right').isOpen();
        };

        $scope.test=null;
        $http.get('/stand/test')
            .success(function (data) {
                $scope.test=data;
            });
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
                timer = $timeout(function() {
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
            return debounce(function() {
                // Component lookup should always be available since we are not using `ng-if`
                $mdSidenav(navID)
                    .toggle()
                    .then(function () {
                        $log.debug("toggle " + navID + " is done");
                    });
            }, 200);
        }

        function buildToggler(navID) {
            return function() {
                // Component lookup should always be available since we are not using `ng-if`
                $mdSidenav(navID)
                    .toggle()
                    .then(function () {
                        $log.debug("toggle " + navID + " is done");
                    });
            };
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
