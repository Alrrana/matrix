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
    $scope.successPushA = false;
    $scope.successPushB = false;

    //==============================
    function sinit() {
    }

    $scope.blabla = function (input) {
        return input + 1;
    }

    $scope.init = function () {
        sessionStorage.setItem("matrixAcols", 3);
        sessionStorage.setItem("matrixArows", 3);
        sessionStorage.setItem("matrixBcols", 3);
        sessionStorage.setItem("matrixBrows", 3);
        while (containerA.hasChildNodes()) {
            containerA.removeChild(containerA.lastChild);
        }
        while (containerB.hasChildNodes()) {
            containerB.removeChild(containerB.lastChild);
        }

        for (let i = 0; i < 3; i++) {
            $('#containerA').append('<div class="item"></div>');
        }
        for (let i = 0; i < 3; i++) {
            $('#containerA .item').each(function (index) {
                $(this).append('<input ng-keyup="checkInputContainerA()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
            })
        }
        for (let i = 0; i < 3; i++) {
            $('#containerB').append('<div class="item"></div>');
        }

        for (let i = 0; i < 3; i++) {
            $('#containerB .item').each(function (index) {
                $(this).append('<input ng-keyup="checkInputContainerB()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
            })
        }
        document.getElementById('inputA').style.visibility = 'hidden';
        document.getElementById('inputB').style.visibility = 'hidden';
        subCheck();
        multCheck();
        sumCheck();
        plusCheck("A");
        plusCheck("B");

    }

    $scope.clearM = function (matrixId, plus) {
        if (matrixId === "A") {
            $scope.masA = '';
            $scope.aRow = 0;
            $scope.aCol = 0;
            $scope.aRowMax = [0, 1, 2];
            $scope.aColMax = [0, 1, 2];

        }
        if (matrixId === "B") {
            $scope.masB = '';
            $scope.bRow = 0;
            $scope.bCol = 0;
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
            $scope.successPushB = true;
        }, function error(response) {
            console.log(response);
            $scope.successPushB = false;
        });
        $scope.allChecks();
    }


    $scope.multFunc = function () {

        if (($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) &&
            ($scope.aCol === $scope.bRow) || ($scope.aRow === $scope.bCol)) {


        } else {


        }
    }

    $scope.multCheck = function () {

        if ($scope.successPushA && $scope.successPushB &&
            ($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) &&
            ($scope.aCol === $scope.bRow) || ($scope.aRow === $scope.bCol)) {

            document.getElementById('mult').style.visibility = 'visible';
        } else {

            document.getElementById('mult').style.visibility = 'hidden';
        }
    }

    //


    $scope.sumFunc = function () {

        if ($scope.successPushA && $scope.successPushB &&
            ($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) && (
                ($scope.aCol === $scope.bCol && $scope.aRow === $scope.bRow))) {

            $http({
                method: 'POST',
                url: "/sum"
            }).then(function success(response) {
                $scope.message = response.getAttribute("MatrixRes");
                alert(response.getAttribute("MatrixRes"));
            }, function error(response) {
                alert("Something went wrong")
            });

        } else {
            document.getElementById('sum').style.visibility = 'hidden';

        }
    }


    $scope.subFunc = function () {

        if ($scope.successPushA && $scope.successPushB &&
            ($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) && (
                ($scope.aCol === $scope.bCol && $scope.aRow === $scope.bRow))) {


        } else {

        }
    }


    $scope.sumCheck = function () {

        if ($scope.successPushA && $scope.successPushB &&
            ($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) && (
                ($scope.aCol === $scope.bCol && $scope.aRow === $scope.bRow))) {

            document.getElementById('sum').style.visibility = 'visible';

        } else {
            document.getElementById('sum').style.visibility = 'hidden';

        }
    }

    $scope.subCheck = function () {

        if ($scope.successPushA && $scope.successPushB &&
            ($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) && (
                ($scope.aCol === $scope.bCol && $scope.aRow === $scope.bRow))) {

            document.getElementById('sub').style.visibility = 'visible';

        } else {
            document.getElementById('sub').style.visibility = 'hidden';
        }
    }

    $scope.plusCheck = function (plus) {
        if (plus === "A") {
            if ($scope.successPushA && ($scope.aCol !== 0) && ($scope.aRow !== 0)) {
                document.getElementById('plusOneA').style.visibility = 'visible';

            } else {
                document.getElementById('plusOneA').style.visibility = 'hidden';

            }
        }
        if (plus === "B") {
            if ($scope.successPushB && ($scope.bCol !== 0) && ($scope.bRow !== 0)) {

                document.getElementById('plusOneB').style.visibility = 'visible';

            } else {
                document.getElementById('plusOneB').style.visibility = 'hidden';

            }
        }
    }


    //=========================================================================


//=====================================================================================================

    function isEmpty(obj) {
        for (var key in obj) {
            if (obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }

    $scope.mascheckA = function (input) {

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


        return [true, col, row];
    }

    $scope.mascheckB = function (input) {

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

        return [true, col, row];
    }

    function mascheck(input) {

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

        return true;
        // alert(input + "\n col is " + col + "   row is" + row + "\n" + res);

        // for (let c = 0; c < col; c++) {
        //     let currentRows = 0;
        //
        //     for (let r = 0; r < row; r++) {
        //
        //         if (r * 8 + 3 + c * row < parsed.length) {
        //             currentRows++;
        //         }
        //     }
        //     if (currentRows < row) {
        //         alert(" Oops currentRows = " + currentRows + " when rows = " + row)
        //     }
        // }


        // if (res.length < (col ) * (row ))
        // {
        //     alert("Malo res.len="+res.length+" expLen="+(col ) * (row ))
        // }
        // if(res.length > (col ) * (row)){
        //     alert("Mnogo")
        // }

        // let expCol = 0;
        // for (let c = 3 + 4; c < parsed.length; c += 3 + 4) {
        //     if (parsed[c]===col)
        //     expCol++;
        // }
        // if (expCol !== col) {
        //     alert("ALARM  expCol =" + expCol+" col ="+col)
        // }
        // let expRow = 0;
        // for (let r = 3 + 8; r< parsed.length; r += 3 + 8) {
        //     expRow++;
        // }
        // if (expRow !== row) {
        //     alert("ALARM  expRow =" + expRow+" row ="+row)
        // }
    }


    $scope.checkInputContainerA = function () {
        var mas = [];
        var t = "";

        $('#containerA input').each(function () {
            if ($(this).attr("col") !== undefined) {
                if ($(this).val() === "") {
                    t += "Не введено поле row: " + $(this).attr("row") + " column: " + $(this).attr("col") + "\n";
                    // can = false;
                } else {
                    mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
                }
            }
        })


        if (JSON.stringify(mas) === "[]") {
            alert("No input");
            document.getElementById('inputA').style.visibility = 'hidden';
        } else {
            var res = mascheckA(JSON.stringify(mas));
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
        $('#containerB input').each(function () {
            if ($(this).attr("col") !== undefined) {
                if ($(this).val() === "") {
                    t += "Не введено поле row: " + $(this).attr("row") + " column: " + $(this).attr("col") + "\n";
                    // can = false;
                } else {
                    mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
                }
            }
        })

        if (JSON.stringify(mas) === "[]") {
            // alert("No input");
            document.getElementById('inputB').style.visibility = 'hidden';
        } else {
            var res = mascheckB(JSON.stringify(mas));
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


});