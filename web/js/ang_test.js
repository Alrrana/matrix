var test = angular.module("test", []);
test.controller("testController", function ($scope, $http) {
    $scope.aRowMax = [0, 1, 2];
    $scope.bRowMax = [0, 1, 2];
    $scope.aColMax = [0, 1, 2];
    $scope.bColMax = [0, 1, 2];
    $scope.aRow = 0;
    $scope.bRow = 0;
    $scope.aCol = 0;
    $scope.bCol = 0;
    $scope.masA = '';
    $scope.masB = '';
    $scope.test = 0;
    $scope.wowA = [[]];
    $scope.wowB = [[]];

    $scope.$watch('testus', function (newValue, oldValue) {
        console.log(newValue);
    });

    $scope.resRowMax = [0, 1, 2];
    $scope.resColMax = [0, 1, 2];
    $scope.masRes = '';
    $scope.successMult = false;
    $scope.successSum = false;
    $scope.successSub = false;

    $scope.successPushA = false;
    $scope.successPushB = false;


    $scope.matrixA = '';
    $scope.matrixRes = '';
    $scope.matrixB = '';

    $scope.lenmatrixA = [0];
    $scope.lenmatrixRes = [0];
    $scope.lenmatrixB = [0];

    //==============================
    function sinit() {
    }

    $scope.blabla = function (input) {
        return input + 1;
    }

    $scope.setLen = function (mas, n) {
        while (mas.length > 1) {
            mas.pop();
        }
        while (mas.length < n) {
            mas.push(mas.length);
        }
    }

    $scope.parser = function (input) {
        var parsed = JSON.parse(input);
        var col = parseInt(parsed[parsed.length - 1].col) + 1;
        var row = parseInt(parsed[parsed.length - 1].row) + 1;
        var res = new Array(col);
        for (let i = 0; i < col; i++) {
            res[i] = new Array(row);
        }
        for (let i = 0; i < parsed.length; i ++
        ) {
            res[parsed[i].col][parsed[i].row] = parsed[i].value;
        }

        let resStr = [];
        for (let j = 0; j < col; j++) {
            let str = "";
            for (let i = 0; i < row; i++) {
                str += res[j][i] + " ";
            }
            resStr.push(str);
        }

        return resStr;
    };


    $scope.clearM = function (matrixId, plus) {
        if (matrixId === "A") {
            $scope.masA = '';
            $scope.aRow = 0;
            sessionStorage.setItem("matrixArows", $scope.aRow);
            $scope.aCol = 0;
            sessionStorage.setItem("matrixAcols", $scope.aCol);
            $scope.aRowMax = [0, 1, 2];
            $scope.aColMax = [0, 1, 2];

        }
        if (matrixId === "B") {
            $scope.masB = '';
            $scope.bRow = 0;
            sessionStorage.setItem("matrixBrows", $scope.bRow);
            $scope.bCol = 0;
            sessionStorage.setItem("matrixBcols", $scope.bCol);
            $scope.bRowMax = [0, 1, 2];
            $scope.bColMax = [0, 1, 2];
        }

        document.getElementById(plus).style.visibility = 'hidden';
        $scope.allChecks();
    }

    $scope.allChecks = function () {
        $scope.plusCheck("A");
        $scope.plusCheck("B");
        $scope.subCheck();
        $scope.multCheck();
        $scope.sumCheck();
    }

    $scope.inputAFunc = function () {

        $http({
            method: 'POST',
            data: "A" + $scope.masA,
            url: "/input"
        }).then(function success(response) {
            console.log(response);
            sessionStorage.setItem("matrixArows", $scope.aRow);
            sessionStorage.setItem("matrixAcols", $scope.aCol);

            $scope.setLen($scope.lenmatrixA, $scope.aCol);
            $scope.matrixA = $scope.parser($scope.masA);
            sessionStorage.setItem("masA", $scope.masA);

            $scope.successPushA = true;
        }, function error(response) {
            console.log(response);
            $scope.successPushA = false;
        });
        $scope.allChecks();
    }

    $scope.inputBFunc = function () {

        $http({
            method: 'POST',
            data: "B" + $scope.masB,
            url: "/input"
        }).then(function success(response) {
            console.log(response);
            sessionStorage.setItem("matrixBrows", $scope.bRow);
            sessionStorage.setItem("matrixBcols", $scope.bCol);

            $scope.setLen($scope.lenmatrixB, $scope.bCol);
            $scope.matrixB = $scope.parser($scope.masB);
            sessionStorage.setItem("masB", $scope.masB);

            $scope.successPushB = true;
        }, function error(response) {
            console.log(response);
            $scope.successPushB = false;
        });
        $scope.allChecks();
    }


    $scope.plusOneA = function () {

        if ($scope.successPushA && ($scope.aCol !== 0) && ($scope.aRow !== 0)) {

            $http({
                method: 'POST',
                data: $scope.masA,
                url: "/plusMA"
            }).then(function success(response) {
                $scope.masA = JSON.stringify(response.data);

                $scope.matrixA = $scope.parser($scope.masA);
                sessionStorage.setItem("masA", $scope.masA);

                console.log(response);
            }, function error(response) {
                console.log(response);
            });
        } else {

        }
    }

    $scope.plusOneB = function () {

        if ($scope.successPushA && ($scope.bCol !== 0) && ($scope.bRow !== 0)) {

            $http({
                method: 'POST',
                data: $scope.masB,
                url: "/plusMB"
            }).then(function success(response) {
                $scope.masB = JSON.stringify(response.data);

                $scope.matrixB = $scope.parser($scope.masB);
                sessionStorage.setItem("masB", $scope.masB);

                console.log(response);
            }, function error(response) {
                console.log(response);
            });
        } else {

        }
    }


    //=========================== operations ===========================================================
    //
    // $scope.stringifier = function(input){
    //     var mas = "";
    //     $(input).each(function () {
    //         if ($(this).attr("col") !== undefined) {
    //             if ($(this).val() === "") {
    //                 t += "Не введено поле row: " + $(this).attr("row") + " column: " + $(this).attr("col") + "\n";
    //                 // can = false;
    //             } else {
    //                 mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
    //             }
    //         }mas.push({value: $scope.wowA[i][j], row: j.toString(), col: i.toString()});
    //     })
    // }; var mas = [];
    //             mas.push({})

    function isSumPossible() {
        return ($scope.successPushA && $scope.successPushB &&
            ($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) && (
                ($scope.aCol === $scope.bCol && $scope.aRow === $scope.bRow)));
    }

    function isMultPossible() {
        return (($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) &&
            ($scope.aCol === $scope.bRow) || ($scope.aRow === $scope.bCol));
    }

    function hide(button) {
        document.getElementById(button).style.visibility = 'hidden';
    }

    function reveal(button) {
        document.getElementById(button).style.visibility = 'visible';
    }


    $scope.operationFunc = function (opName) {

        var possible = false;
        if (opName === "mult") {
            possible = isMultPossible();
        } else possible = isSumPossible();

        if (possible) {

            $http({
                method: 'POST',
                data: JSON.stringify([{MatrixA: $scope.masA},
                    {MatrixB: $scope.masB}]),
                url: "/" + opName
            }).then(function success(response) {
                $scope.masRes = JSON.stringify(response.data);
                console.log(response);

                $scope.setLen($scope.lenmatrixRes, $scope.aCol); // ToDo
                $scope.matrixRes = $scope.parser($scope.masRes);
                sessionStorage.setItem("masRes", $scope.masRes);

                $scope.successMult = true;
            }, function error(response) {
                console.log(response);
                $scope.successMult = false;
            });

        } else {


        }
    }


    $scope.operationFuncREST = function (opName) {

        var possible = false;
        if (opName === "mult") {
            possible = isMultPossible();
        } else possible = isSumPossible();

        if (possible) {


            $http({
                // method: 'POST',
                // data: $scope.masA + "@" + $scope.masB,
                // url: "/mult"
                method: 'GET',
                url: encodeURI("/" + opName + "?" + "A=" + $scope.masA + "&B=" + $scope.masB)

            }).then(function success(response) {
                $scope.masRes = JSON.stringify(response.data);
                console.log(response);

                $scope.setLen($scope.lenmatrixRes, $scope.aCol); // ToDo
                $scope.matrixRes = $scope.parser($scope.masRes);
                sessionStorage.setItem("masRes", $scope.masRes);

                $scope.successMult = true;
            }, function error(response) {
                console.log(response);
                $scope.successMult = false;
            });

        } else {


        }
    }


    $scope.multCheck = function () {

        if (isMultPossible()) {

            reveal('mult');
            reveal('multR');
        } else {

            hide('mult');
            hide('multR');
        }
    }


    $scope.sumCheck = function () {

        if (isSumPossible()) {

            reveal('sum');
            reveal('sumR');
        } else {

            hide('sum');
            hide('sumR');
        }
    }

    $scope.subCheck = function () {

        if (isSumPossible()) {

            reveal('sub');
            reveal('subR');
        } else {

            hide('sub');
            hide('subR');
        }
    }

    $scope.plusCheck = function (plus) {
        if (plus === "A") {
            if ($scope.successPushA && ($scope.aCol !== 0) && ($scope.aRow !== 0)) {

                reveal('plusOneA');
            } else {

                hide('plusOneA');
            }
        }
        if (plus === "B") {
            if ($scope.successPushB && ($scope.bCol !== 0) && ($scope.bRow !== 0)) {

                reveal('plusOneB');
            } else {

                hide('plusOneB');
            }
        }
    }


    //=========================================================================

//input helpers
//=====================================================================================================

    function isEmpty(obj) {
        for (var key in obj) {
            if (obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }

    $scope.mascheck = function (input) {

        var parsed = input.split('\"');
        var col = parseInt(parsed[parsed.length - 2]) + 1;
        var row = parseInt(parsed[parsed.length - 6]) + 1;
        var res = new Array(row);
        for (let i = 0; i < row; i++) {
            res[i] = new Array(col);
        }

        let logic = false;
        for (let i = 3; i < parsed.length; i += 12
        ) {
            if (parsed[i] === "")
                return false;

            try {
                res[parsed[i + 4]][parsed[i + 8]] = parsed[i];
            } catch (e) {
                logic = true;
            }
        }
        if (logic)
            return false;
        if (row > 1) {
            var lastlen = res[0].length;
            for (let c = 1; c < row; c++) {
                if (lastlen != res[c].length) {
                    // alert("ALARM");
                    return false;
                }
            }
        }

        for (let i = 0; i < row; i++) {
            for (let j = 0; j < col; j++) {
                if (isEmpty(res[i][j]))
                // alert("ALARM");
                    return false;
            }
        }

        console.log("LOL")
        return [true, col, row];
    }


    $scope.checkInputContainerA = function () {
        var mas = [];
        var t = "";

        for (let i = 0; i < $scope.aColMax.length; i++) {
            if (!$scope.wowA[i]) {
                continue;
            }

            for (let j = 0; j < $scope.aRowMax.length; j++) {
                if (!!$scope.wowA[i][j]) {
                    mas.push({value: $scope.wowA[i][j], row: j.toString(), col: i.toString()});
                }
            }

        }
        console.log("mas: " + mas);
        console.log("wowA: " + $scope.wowA);


        if (JSON.stringify(mas) === "[]") {
            console.log("No input");
            document.getElementById('inputA').style.visibility = 'hidden';
        } else {
            var res = $scope.mascheck(JSON.stringify(mas));
            if (res[0]) {
                $scope.aRow = res[2];
                $scope.aCol = res[1];
                $scope.masA = JSON.stringify(mas);
                document.getElementById('inputA').style.visibility = 'visible';

            } else {
                document.getElementById('inputA').style.visibility = 'hidden';
            }
        }

    }

    $scope.checkInputContainerB = function () {
        var mas = [];
        var t = "";


        for (let i = 0; i < $scope.bColMax.length; i++) {
            if (!$scope.wowB[i]) {
                continue;
            }

            for (let j = 0; j < $scope.bRowMax.length; j++) {
                if (!!$scope.wowB[i][j]) {
                    mas.push({value: $scope.wowB[i][j], row: j.toString(), col: i.toString()});
                }
            }

        }


        if (JSON.stringify(mas) === "[]") {
            // alert("No input");
            document.getElementById('inputB').style.visibility = 'hidden';
        } else {
            var res = $scope.mascheck(JSON.stringify(mas));
            if (res[0]) {
                $scope.bRow = res[2];
                $scope.bCol = res[1];
                $scope.masB = JSON.stringify(mas);
                document.getElementById('inputB').style.visibility = 'visible';
            } else {
                document.getElementById('inputB').style.visibility = 'hidden';
            }
        }


    }


    // input field change


    $scope.plusColA = function () {
        $scope.aColMax.push($scope.aColMax.length);
    }
    $scope.plusRowA = function () {
        $scope.aRowMax.push($scope.aRowMax.length);
    }
    $scope.minusColA = function () {
        $scope.aColMax.pop();
    }
    $scope.minusRowA = function () {
        $scope.aRowMax.pop();
    }


    $scope.plusColB = function () {
        $scope.bColMax.push($scope.bColMax.length);
    }
    $scope.plusRowB = function () {
        $scope.bRowMax.push($scope.bRowMax.length);
    }
    $scope.minusColB = function () {
        $scope.bColMax.pop();
    }
    $scope.minusRowB = function () {
        $scope.bRowMax.pop();
    }


    // init


    var init = function () {
        if (sessionStorage.getItem("matrixArows") != null && sessionStorage.getItem("matrixArows") !== "null")
            $scope.aRow = parseInt(sessionStorage.getItem("matrixArows"));

        if (sessionStorage.getItem("matrixBrows") != null && sessionStorage.getItem("matrixBrows") !== "null")
            $scope.bRow = parseInt(sessionStorage.getItem("matrixBrows"));

        if (sessionStorage.getItem("matrixAcols") != null && sessionStorage.getItem("matrixAcols") !== "null")
            $scope.aCol = parseInt(sessionStorage.getItem("matrixAcols"));

        if (sessionStorage.getItem("matrixBcols") != null && sessionStorage.getItem("matrixBcols") !== "null")
            $scope.bCol = parseInt(sessionStorage.getItem("matrixBcols"));


        $scope.successPushA = true;
        $scope.successPushB = true;

        if (sessionStorage.getItem("masA") != null && sessionStorage.getItem("masA") !== "null") {
            $scope.masA = sessionStorage.getItem("masA");
            $scope.setLen($scope.lenmatrixA, $scope.aCol);
            $scope.matrixA = $scope.parser($scope.masA);
        }
        if (sessionStorage.getItem("masRes") != null && sessionStorage.getItem("masRes") !== "null") {
            $scope.masRes = sessionStorage.getItem("masRes");
            $scope.setLen($scope.lenmatrixA, $scope.aCol);
            $scope.matrixRes = $scope.parser($scope.masRes);
        }
        if (sessionStorage.getItem("masB") != null && sessionStorage.getItem("masB") !== "null") {
            $scope.masB = sessionStorage.getItem("masB");
            $scope.setLen($scope.lenmatrixB, $scope.bCol);
            $scope.matrixB = $scope.parser($scope.masB);
        }

        // $scope.wowA = new Array(aColMax.length);
        // for (let i = 0; i < $scope.aColMax.length; i++) {
        //     $scope.wowA[i] = new Array(aRowMax.length);
        // }

        $scope.allChecks();
    };
    init();


});

// test.controller('ictrl',function($scope){
//
//     $scope.ColMax = 1;
//     $scope.RowMax = 1;
//     $scope.wow = '';
//     $scope.check = '';
// });

test.directive('matrixForm', function () {
    return {
        scope: {
            col: '@',
            row: '@',
            wow: '@',
            container: '@',
            functionName: '@'

        },
        compile: function (templateElement, templateAttrs) {
            if (!!templateAttrs.container)
                templateElement.html('<table>' +
                    '                    <tr ng-repeat="i in ' + templateAttrs.col + '">' +
                    '                        <td ng-repeat="j in ' + templateAttrs.row + '">' +
                    '                            <input ng-model="' + templateAttrs.wow + '[i][j]" ng-change="checkInputContainer' + templateAttrs.container + '()" type="text" col={{i}} row={{j}} placeholder="_">' +
                    '                        </td>' +
                    '                    </tr>' +
                    '                </table>')
            else {
                templateElement.html('<table>' +
                    '                    <tr ng-repeat="i in ' + templateAttrs.col + '">' +
                    '                        <td ng-repeat="j in ' + templateAttrs.row + '">' +
                    '                            <input ng-model="' + templateAttrs.wow + '[i][j]" ng-change="' + templateAttrs.functionName + '()" type="text" col={{i}} row={{j}} placeholder="_">' +
                    '                        </td>' +
                    '                    </tr>' +
                    '                </table>')
            }
        },
        link: function (scope, element, attrs) {

        }
    }
});






























