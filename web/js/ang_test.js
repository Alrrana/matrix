var test = angular.module("test", []);
test.controller("testController", function ($scope, $http) {
    $scope.aRow = 0;
    $scope.bRow = 0;
    $scope.aCol = 0;
    $scope.bCol = 0;
    $scope.masA = '';
    $scope.masB = '';

    //==============================
    function sinit() {
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
                $(this).append('<input ng-keyup="inpA()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
            })
        }
        for (let i = 0; i < 3; i++) {
            $('#containerB').append('<div class="item"></div>');
        }

        for (let i = 0; i < 3; i++) {
            $('#containerB .item').each(function (index) {
                $(this).append('<input ng-keyup="inpB()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
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

    $scope.clearM = function (matrixId, col, row, plus) {

        $(matrixId).val(null);
        sessionStorage.setItem(col, null);
        sessionStorage.setItem(row, null);
        document.getElementById(plus).style.visibility = 'hidden';
        allChecks();
        init();
    }


    $scope.inputAFunc = function () {
        allChecks();
        $http({
            method: 'POST',
            data: "A",
            data: $('#forResponseA').val(),
            url: "/input"
        }).then(function success(response) {
            $scope.message = response.getAttribute("MatrixRes");
            alert(response.getAttribute("MatrixRes"));
        }, function error(response) {
            alert("Something went wrong")
        });
    }
    $scope.inputBFunc = function () {
        allChecks();

    }

    $scope.allChecks = function () {
        plusCheck("A");
        plusCheck("B");
        subCheck();
        multCheck();
        sumCheck();
    }


    $scope.multFunc = function () {

        if ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
            (Acols === Brows) || (Arows === Bcols)) {

            $('#mult').val("yes");


        } else {

            $('#mult').val("no");

        }
    }

    $scope.sumFunc = function () {

        if ((Acols != null) && (Acols !== "null") && (Arows !== "null") && (Bcols != null) && ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
            (Acols === Bcols && Arows === Brows))) {
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

        if ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
            (Acols === Bcols && Arows === Brows)) {


        } else {

        }
    }


    $scope.multCheck = function () {
     
        if (($scope.aCol != null) && ($scope.aCol !== "null") && (Arows !== "null") && ($scope.bCol != null) && (($scope.aCol !== "") && ($scope.bCol !== "") && (Arows !== "") && ($scope.bRow !== "") &&
            ($scope.aCol === $scope.bRow) || (Arows === $scope.bCol))) {

            document.getElementById('mult').style.visibility = 'visible';
        } else {

            document.getElementById('mult').style.visibility = 'hidden';
        }
    }


    $scope.sumCheck = function () {

        if (($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) && (($scope.aCol !== "") && ($scope.bCol !== "") && ($scope.aRow !== "") && ($scope.bRow !== "") &&
            ($scope.aCol === $scope.bCol && $scope.aRow === $scope.bRow))) {

            document.getElementById('sum').style.visibility = 'visible';

        } else {
            document.getElementById('sum').style.visibility = 'hidden';

        }
    }

    $scope.subCheck = function () {

        if (($scope.aCol !== 0) && ($scope.aRow !== 0) && ($scope.bCol !== 0) && ($scope.bRow !== 0) && (($scope.aCol !== "") && ($scope.bCol !== "") && ($scope.aRow !== "") && ($scope.bRow !== "") &&
            ($scope.aCol === $scope.bCol && $scope.aRow === $scope.bRow))) {

            document.getElementById('sub').style.visibility = 'visible';

        } else {
            document.getElementById('sub').style.visibility = 'hidden';
        }
    }

    $scope.plusCheck = function (plus) {
        if (plus === "A") {
            if (($scope.aCol !== 0) && ($scope.aRow !== 0)) {
                document.getElementById('plusOneA').style.visibility = 'visible';

            } else {
                document.getElementById('plusOneA').style.visibility = 'hidden';

            }
        }
        if (plus === "B") {
            if (($scope.bCol !== 0) && ($scope.bRow !== 0)) {

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


    $scope.inpA = function () {
        var mas = [];
        var can = true;
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
                $scope.masA = res;
                document.getElementById('inputA').style.visibility = 'visible';

            } else {
                document.getElementById('inputA').style.visibility = 'hidden';
            }
        }

    }

    $scope.inpB = function () {
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
            alert("No input");
            document.getElementById('inputB').style.visibility = 'hidden';
        } else {
            var res = mascheckB(JSON.stringify(mas));
            if (res[0]) {
                $scope.bRow = res[2];
                $scope.bCol = res[1];
                $scope.masB = res;
                document.getElementById('inputB').style.visibility = 'visible';
            } else {
                document.getElementById('inputB').style.visibility = 'hidden';
            }
        }


    }


});