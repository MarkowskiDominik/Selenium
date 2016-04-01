angular.module('app.booksList')
.service('bookRestService', function($http){
    'use strict';

    this.add = function(book){
        $http.post('', book).then(function(response) {
            console.log('service: ' + response.data);
        }, function (response) {
            console.log('service: ' + response.data);
        });
    };

    this.update = function(book){
        $http.put('', book).then(function(response) {
            console.log('service: ' + response.data);
        }, function (response) {
            console.log('service: ' + response.data);
        });
    };

    this.delete = function(book){
        $http.delete('', book).then(function(response) {
            console.log('service: ' + response.data);
        }, function (response) {
            console.log('service: ' + response.data);
        });
    };
});
