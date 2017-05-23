angular
    .module('MyApp', ['ngSanitize', 'ngMaterial', 'ngMessages', 'material.svgAssetsCache', 'ngRoute'])
    .config(function ($routeProvider, $locationProvider) {
        $routeProvider
            .when("/create", {
                templateUrl: "/create",
                controller: 'AppCtrl'
            })
            .when("/", {
                templateUrl: "/content",
                controller: 'AppCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
        // $locationProvider.html5Mode(true);
    })
    .controller('AppCtrl', function ($scope, $timeout, $mdSidenav, $log, $http) {
        angular.element(document).ready(function () {
            CKEDITOR.replace('editor1');
            CKEDITOR.config.codeSnippet_theme = 'idea';
        });
        $scope.toggleLeft = buildDelayedToggler('left');
        $scope.toggleRight = buildToggler('right');
        $scope.isOpenRight = function () {
            return $mdSidenav('right').isOpen();
        };
        $scope.stands = [{
            "id": 3,
            "body": "asdasd sadas",
            "user": null,
            "patterns": [{"id": 3, "name": "3"}],
            "images": null,
            "created_at": 1495381073773,
            "updated_at": 1495381073773,
            "title": "1231231"
        }, {
            "id": 2,
            "body": "\r\n\r\n\r\n\r\n<div class=\"blog-masthead\">\r\n    <div class=\"container\">\r\n        <nav class=\"blog-nav\">\r\n            <a class=\"blog-nav-item active\" href=\"#\">Home</a>\r\n            <a class=\"blog-nav-item\" href=\"#\">New features</a>\r\n            <a class=\"blog-nav-item\" href=\"#\">Press</a>\r\n            <a class=\"blog-nav-item\" href=\"#\">New hires</a>\r\n            <a class=\"blog-nav-item\" href=\"#\">About</a>\r\n        </nav>\r\n    </div>\r\n</div>\r\n\r\n<div class=\"container\">\r\n\r\n    <div class=\"blog-header\">\r\n        <h1 class=\"blog-title\">The Bootstrap Blog</h1>\r\n        <p class=\"lead blog-description\">The official example template of creating a blog with Bootstrap.</p>\r\n    </div>\r\n\r\n    <div class=\"row\">\r\n\r\n        <div class=\"col-sm-8 blog-main\">\r\n\r\n            <div class=\"blog-post\">\r\n                <h2 class=\"blog-post-title\">Sample blog post</h2>\r\n                <p class=\"blog-post-meta\">January 1, 2014 by <a href=\"#\">Mark</a></p>\r\n\r\n                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>\r\n                <hr>\r\n                <p>Cum sociis natoque penatibus et magnis <a href=\"#\">dis parturient montes</a>, nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum.</p>\r\n                <blockquote>\r\n                    <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                </blockquote>\r\n                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>\r\n                <h2>Heading</h2>\r\n                <p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>\r\n                <h3>Sub-heading</h3>\r\n                <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>\r\n                <pre><code>Example code block</code></pre>\r\n                <p>Aenean lacinia bibendum nulla sed consectetur. Etiam porta sem malesuada magna mollis euismod. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa.</p>\r\n                <h3>Sub-heading</h3>\r\n                <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean lacinia bibendum nulla sed consectetur. Etiam porta sem malesuada magna mollis euismod. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>\r\n                <ul>\r\n                    <li>Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</li>\r\n                    <li>Donec id elit non mi porta gravida at eget metus.</li>\r\n                    <li>Nulla vitae elit libero, a pharetra augue.</li>\r\n                </ul>\r\n                <p>Donec ullamcorper nulla non metus auctor fringilla. Nulla vitae elit libero, a pharetra augue.</p>\r\n                <ol>\r\n                    <li>Vestibulum id ligula porta felis euismod semper.</li>\r\n                    <li>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</li>\r\n                    <li>Maecenas sed diam eget risus varius blandit sit amet non magna.</li>\r\n                </ol>\r\n                <p>Cras mattis consectetur purus sit amet fermentum. Sed posuere consectetur est at lobortis.</p>\r\n            </div><!-- /.blog-post -->\r\n\r\n            <div class=\"blog-post\">\r\n                <h2 class=\"blog-post-title\">Another blog post</h2>\r\n                <p class=\"blog-post-meta\">December 23, 2013 by <a href=\"#\">Jacob</a></p>\r\n\r\n                <p>Cum sociis natoque penatibus et magnis <a href=\"#\">dis parturient montes</a>, nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum.</p>\r\n                <blockquote>\r\n                    <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                </blockquote>\r\n                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>\r\n                <p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>\r\n            </div><!-- /.blog-post -->\r\n\r\n            <div class=\"blog-post\">\r\n                <h2 class=\"blog-post-title\">New feature</h2>\r\n                <p class=\"blog-post-meta\">December 14, 2013 by <a href=\"#\">Chris</a></p>\r\n\r\n                <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean lacinia bibendum nulla sed consectetur. Etiam porta sem malesuada magna mollis euismod. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>\r\n                <ul>\r\n                    <li>Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</li>\r\n                    <li>Donec id elit non mi porta gravida at eget metus.</li>\r\n                    <li>Nulla vitae elit libero, a pharetra augue.</li>\r\n                </ul>\r\n                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>\r\n                <p>Donec ullamcorper nulla non metus auctor fringilla. Nulla vitae elit libero, a pharetra augue.</p>\r\n            </div><!-- /.blog-post -->\r\n\r\n            <nav>\r\n                <ul class=\"pager\">\r\n                    <li><a href=\"#\">Previous</a></li>\r\n                    <li><a href=\"#\">Next</a></li>\r\n                </ul>\r\n            </nav>\r\n\r\n        </div><!-- /.blog-main -->\r\n\r\n        <div class=\"col-sm-3 col-sm-offset-1 blog-sidebar\">\r\n            <div class=\"sidebar-module sidebar-module-inset\">\r\n                <h4>About</h4>\r\n                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>\r\n            </div>\r\n            <div class=\"sidebar-module\">\r\n                <h4>Archives</h4>\r\n                <ol class=\"list-unstyled\">\r\n                    <li><a href=\"#\">March 2014</a></li>\r\n                    <li><a href=\"#\">February 2014</a></li>\r\n                    <li><a href=\"#\">January 2014</a></li>\r\n                    <li><a href=\"#\">December 2013</a></li>\r\n                    <li><a href=\"#\">November 2013</a></li>\r\n                    <li><a href=\"#\">October 2013</a></li>\r\n                    <li><a href=\"#\">September 2013</a></li>\r\n                    <li><a href=\"#\">August 2013</a></li>\r\n                    <li><a href=\"#\">July 2013</a></li>\r\n                    <li><a href=\"#\">June 2013</a></li>\r\n                    <li><a href=\"#\">May 2013</a></li>\r\n                    <li><a href=\"#\">April 2013</a></li>\r\n                </ol>\r\n            </div>\r\n            <div class=\"sidebar-module\">\r\n                <h4>Elsewhere</h4>\r\n                <ol class=\"list-unstyled\">\r\n                    <li><a href=\"#\">GitHub</a></li>\r\n                    <li><a href=\"#\">Twitter</a></li>\r\n                    <li><a href=\"#\">Facebook</a></li>\r\n                </ol>\r\n            </div>\r\n        </div><!-- /.blog-sidebar -->\r\n\r\n    </div><!-- /.row -->\r\n\r\n</div><!-- /.container -->\r\n\r\n<footer class=\"blog-footer\">\r\n    <p>Blog template built for <a href=\"http://getbootstrap.com\">Bootstrap</a> by <a href=\"https://twitter.com/mdo\">@mdo</a>.</p>\r\n    <p>\r\n        <a href=\"#\">Back to top</a>\r\n    </p>\r\n</footer>\r\n\r\n\r\n<!-- Bootstrap core JavaScript\r\n================================================== -->\r\n<!-- Placed at the end of the document so the pages load faster -->\r\n<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n<script>window.jQuery || document.write('<script src=\"../../assets/js/vendor/jquery.min.js\"><\\/script>')</script>\r\n<script src=\"../../dist/js/bootstrap.min.js\"></script>\r\n<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\r\n<script src=\"../../assets/js/ie10-viewport-bug-workaround.js\"></script>\r\n\r\n",
            "user": null,
            "patterns": [],
            "images": null,
            "created_at": 1495381010512,
            "updated_at": 1495381010512,
            "title": "Hello"
        }, {
            "id": 5,
            "body": "123",
            "user": null,
            "patterns": [],
            "images": null,
            "created_at": 1495573101514,
            "updated_at": 1495486705486,
            "title": "1"
        }, {
            "id": 8,
            "body": "789",
            "user": null,
            "patterns": [],
            "images": null,
            "created_at": 1495573101514,
            "updated_at": 1495486705486,
            "title": "1"
        }, {
            "id": 6,
            "body": "345",
            "user": null,
            "patterns": [],
            "images": null,
            "created_at": 1495573101514,
            "updated_at": 1495486705486,
            "title": "1"
        }, {
            "id": 7,
            "body": "567",
            "user": null,
            "patterns": [],
            "images": {"id": 2, "filePath": "6416c622-727d-48c3-9da6-d7ba97400e75________1.jpg", "expiration": null},
            "created_at": 1495573101514,
            "updated_at": 1495486705486,
            "title": "1"
        }]
        $scope.test = null;
        $http.get('/stand/test')
            .success(function (data) {
                $scope.test = data;
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

