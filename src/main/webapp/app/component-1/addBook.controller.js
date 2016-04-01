angular.module('app.booksList')
.controller('addBookController', function($scope, $modalInstance, dateService){
    'use strict';

    $scope.data = {
        addBook: {
            id: 0,
            version: 0,
            genre: undefined,
            year: undefined,
            title: undefined,
            author: undefined
        },
        nextYear: dateService.getNextYear()
    };

    $scope.save = function() {
        $modalInstance.close($scope.data.addBook);
    };

    $scope.cancel = function(){
        $modalInstance.close();
    };
});
