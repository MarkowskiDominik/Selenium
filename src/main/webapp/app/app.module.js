angular.module('app', ['ngRoute',  'app.main', 'app.booksList', 'app.component2'])
    .config(function ($locationProvider) {
        'use strict';
        $locationProvider.html5Mode(false);
    });
