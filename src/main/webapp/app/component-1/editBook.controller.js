angular.module('app.booksList')
.controller('editBookController', function($scope, $modalInstance, selectedBook, dateService){
    'use strict';

    $scope.data = {
        editBook: {},
        nextYear: dateService.getNextYear()
    };
    angular.copy(selectedBook, $scope.data.editBook);

    $scope.save = function() {
        $scope.data.editBook.version++;
        $modalInstance.close($scope.data.editBook);
    };

    $scope.cancel = function() {
        $modalInstance.close();
    };
});
