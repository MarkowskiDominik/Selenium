angular.module('app.booksList')
.factory('bookRestFactory', function($http){
    'use strict';

    return {
        add: function(book){
            $http.post('', book).then(function(response) {
                console.log('factory: ' + response.data);
            }, function (response) {
                console.log('factory: ' + response.data);
            });
        },

        update: function(book){
            $http.put('', book).then(function(response) {
                console.log('factory: ' + response.data);
            }, function (response) {
                console.log('factory: ' + response.data);
            });
        },

        delete: function(book){
            $http.delete('', book).then(function(response) {
                console.log('factory: ' + response.data);
            }, function (response) {
                console.log('factory: ' + response.data);
            });
        }
    };
});
