angular.module('app.booksList')
.controller('deleteBookController', function($scope, $modalInstance){
    'use strict';

    $scope.delete = function() {
        $modalInstance.close('true');
    };

    $scope.cancel = function() {
        $modalInstance.close();
    };
});
