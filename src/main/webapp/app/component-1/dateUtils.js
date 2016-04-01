angular.module('app.booksList')
.service('dateService', function() {
    'use strict';

    this.getNextYear = function() {
        return new Date().getFullYear()+1;
    };
})
.factory('dateFactory', function() {
    'use strict';

    return {
        getNextYear: function(){
            return new Date().getFullYear()+1;
        }
    };
});
