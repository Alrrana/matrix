
function ictrl($scope) {

}

var inputDirect = angular.module("inputDirect", [])
    .directive('inputF', function() {
    return{
        restrict: 'E',
        scope: {},
        link: function (scope, element, attrs) {
            scope.ColMax = attrs.ColMax;
            scope.RowMax = attrs.RowMax;
            scope.wow = attrs.wow;
            scope.check = attrs.check;
        },
        template: '<p>HFJSkaf</p><table>  <tr ng-repeat="i in {{ColMax}}">    <td ng-repeat="j in {{RowMax}}">   <input ng-model="{{wow}}[i][j]" ng-change="{{check()}}" type="text" col={{i}} row={{j}}\n' +
            '                   placeholder="_">    </td>  </tr></table>'
    }
});




// app.directive("inputF", function () {
//     return {
//         restrict: 'E',
//         scope: {},
//         link: function (scope, element, attrs) {
//             scope.ColMax = attrs.ColMax;
//             scope.RowMax = attrs.RowMax;
//             scope.wow = attrs.wow;
//             scope.check = attrs.check;
//         },
//         template: '<p>HFJSkaf</p><table>  <tr ng-repeat="i in {{ColMax}}">    <td ng-repeat="j in {{RowMax}}">   <input ng-model="{{wow}}[i][j]" ng-change="{{check()}}" type="text" col={{i}} row={{j}}\n' +
//             '                   placeholder="_">    </td>  </tr></table>'
//     }
// })