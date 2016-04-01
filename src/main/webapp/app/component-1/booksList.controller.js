angular.module('app.booksList')
.controller('booksListController', function($scope, $modal, books, bookRestService) {
    'use strict';

    $scope.data = {
        helloWorld: 'Hello world!',
        books: []
    };

    angular.copy(books.data, $scope.data.books);

    $scope.selectedRow = function(index) {
        $scope.selectedRowIndex = ($scope.selectedRowIndex != index) ? index :  undefined;
    };

    $scope.add = function(){
        $modal.open({
            templateUrl: '/component-1/dialog-add/dialog-add.tpl.html',
            controller: 'addBookController'
        }).result.then(function(result) {
            if (result !== undefined) {
                bookRestService.add(result);
                console.log(result);
                $scope.data.books.push(result);
            }
        });
    };

    $scope.edit = function(){
        $modal.open({
            templateUrl: '/component-1/dialog-edit/dialog-edit.tpl.html',
            controller: 'editBookController',
            resolve: {
                selectedBook: function() {
                    return $scope.data.books[$scope.selectedRowIndex];
                }
            }
        }).result.then(function(result) {
            if (result !== undefined) {
                bookRestService.update(result);
                console.log(result);
                $scope.data.books[$scope.selectedRowIndex] = result;
            }
        });
    };

    $scope.delete = function(){
        $modal.open({
            templateUrl: '/component-1/dialog-delete/dialog-delete.tpl.html',
            controller: 'deleteBookController'
        }).result.then(function(result) {
            if (result !== undefined) {
                bookRestService.delete($scope.data.books[$scope.selectedRowIndex]);
                $scope.data.books.splice($scope.selectedRowIndex, 1);
            }
        });
    };
});
