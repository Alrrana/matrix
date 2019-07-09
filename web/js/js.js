//==============================
function sinit() {
}



function init() {
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
        $('#containerA').append('<div class="item" ng-init="checkInputContainerA()"></div>');
    }
    for (let i = 0; i < 3; i++) {
        $('#containerA .item').each(function (index) {
            $(this).append('<input ng-change="checkInputContainerA()" ng-model="testModel" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
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
    document.getElementById('mult').style.visibility = 'hidden';
    document.getElementById('sub').style.visibility = 'hidden';
    document.getElementById('sum').style.visibility = 'hidden';
    document.getElementById('plusOneA').style.visibility = 'hidden';
    document.getElementById('plusOneB').style.visibility = 'hidden';

}
//
// function clearM(matrixId, col, row, plus) {
//
//     $(matrixId).val(null);
//     sessionStorage.setItem(col, null);
//     sessionStorage.setItem(row, null);
//     document.getElementById(plus).style.visibility = 'hidden';
//     allChecks();
//     init();
// }


function plusRowA() {
    var row = parseInt(sessionStorage.getItem("matrixArows")) + 1;

    $('#containerA .item').each(function (index) {
        $(this).append('<div class="col"><input ng-change="checkInputContainerA()" ng-model="testModel" type="text" col="' + index + '" row="' + row + '" placeholder="_"></div>');
    })
    sessionStorage.setItem("matrixArows", row);
}

function plusColA() {
    var row = sessionStorage.getItem("matrixArows");
    var col = parseInt(sessionStorage.getItem("matrixAcols")) + 1;
    while (containerA.hasChildNodes()) {
        containerA.removeChild(containerA.lastChild);
    }

    for (let i = 0; i < col; i++) {
        $('#containerA').append('<div class="item"></div>');
    }
    for (let i = 0; i < row; i++) {
        $('#containerA .item').each(function (index) {
            $(this).append('<input ng-change="checkInputContainerA()" ng-model="testModel" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
        })
    }
    sessionStorage.setItem("matrixAcols", col);


    // var t = '<div class="item">';
    //
    // for (i = 0; i < row; i++) {
    //     t += '<div class=\"col\"><input type=\"text\" col=\"' + col - 1 + '\" row=\"' + i + '" placeholder="_"></div>';
    // }
    // t += '</div>';
    // $('#containerA').append(t);
}

function minusColA() {
    var col = parseInt(sessionStorage.getItem("matrixArows")) - 1;

    containerA.removeChild(containerA.lastChild);

    sessionStorage.setItem("matrixAcols", col);
}

function minusRowA() {
    var row = parseInt(sessionStorage.getItem("matrixArows")) - 1;
    var col = sessionStorage.getItem("matrixAcols");
    while (containerA.hasChildNodes()) {
        containerA.removeChild(containerA.lastChild);
    }

    for (let i = 0; i < col; i++) {
        $('#containerA').append('<div class="item"></div>');
    }
    for (let i = 0; i < row; i++) {
        $('#containerA .item').each(function (index) {
            $(this).append('<input ng-change="checkInputContainerA()" ng-model="testModel" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
        })
    }
    sessionStorage.setItem("matrixArows", row);


    // var t = '<div class="item">';
    //
    // for (i = 0; i < row; i++) {
    //     t += '<div class=\"col\"><input type=\"text\" col=\"' + col - 1 + '\" row=\"' + i + '" placeholder="_"></div>';
    // }
    // t += '</div>';
    // $('#containerA').append(t);
}


//=====================================================================================================


function plusRowB() {
    var row = parseInt(sessionStorage.getItem("matrixBrows")) + 1;

    $('#containerB .item').each(function (index) {
        $(this).append('<div class="col"><input ng-keyup="checkInputContainerB()" type="text" col="' + index + '" row="' + row + '" placeholder="_"></div>');
    })
    sessionStorage.setItem("matrixBrows", row);
}

function plusColB() {
    var row = sessionStorage.getItem("matrixBrows");
    var col = parseInt(sessionStorage.getItem("matrixBcols")) + 1;
    while (containerB.hasChildNodes()) {
        containerB.removeChild(containerB.lastChild);
    }

    for (let i = 0; i < col; i++) {
        $('#containerB').append('<div class="item"></div>');
    }
    for (let i = 0; i < row; i++) {
        $('#containerB .item').each(function (index) {
            $(this).append('<input ng-keyup="checkInputContainerB()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
        })
    }
    sessionStorage.setItem("matrixBcols", col);


    // var t = '<div class="item">';
    //
    // for (i = 0; i < row; i++) {
    //     t += '<div class=\"col\"><input type=\"text\" col=\"' + col - 1 + '\" row=\"' + i + '" placeholder="_"></div>';
    // }
    // t += '</div>';
    // $('#containerB').append(t);
}

function minusColB() {
    var col = parseInt(sessionStorage.getItem("matrixBrows")) - 1;

    containerB.removeChild(containerB.lastChild);

    sessionStorage.setItem("matrixBcols", col);
}

function minusRowB() {
    var row = parseInt(sessionStorage.getItem("matrixBrows")) - 1;
    var col = sessionStorage.getItem("matrixBcols");
    while (containerB.hasChildNodes()) {
        containerB.removeChild(containerB.lastChild);
    }

    for (let i = 0; i < col; i++) {
        $('#containerB').append('<div class="item"></div>');
    }
    for (let i = 0; i < row; i++) {
        $('#containerB .item').each(function (index) {
            $(this).append('<input ng-keyup="checkInputContainerB()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
        })
    }
    sessionStorage.setItem("matrixBrows", row);


    // var t = '<div class="item">';
    //
    // for (i = 0; i < row; i++) {
    //     t += '<div class=\"col\"><input type=\"text\" col=\"' + col - 1 + '\" row=\"' + i + '" placeholder="_"></div>';
    // }
    // t += '</div>';
    // $('#containerB').append(t);
}


//=====================================================================================================

function isEmpty(obj) {
    for (var key in obj) {
        if (obj.hasOwnProperty(key))
            return false;
    }
    return true;
}

function mascheckA(input) {

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

function mascheckB(input) {

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


//
//
// function checkInputContainerA() {
//     var mas = [];
//     var can = true;
//     var t = "";
//
//     $('#containerA input').each(function () {
//         if ($(this).attr("col") !== undefined) {
//             if ($(this).val() === "") {
//                 t += "Не введено поле row: " + $(this).attr("row") + " column: " + $(this).attr("col") + "\n";
//                 // can = false;
//             } else {
//                 mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
//             }
//         }
//     })
//
//
//     if (JSON.stringify(mas) === "[]") {
//         alert("No input");
//         document.getElementById('inputA').style.visibility = 'hidden';
//     } else {
//         var res = mascheckA(JSON.stringify(mas));
//         if (res[0]) {
//             sessionStorage.setItem("Acols", res[1]);
//             sessionStorage.setItem("Arows", res[2]);
//             $('#forResponseA').val(JSON.stringify(mas));
//             document.getElementById('inputA').style.visibility = 'visible';
//
//         } else {
//             document.getElementById('inputA').style.visibility = 'hidden';
//         }
//     }
//
// }
//
// function checkInputContainerB() {
//     var mas = [];
//     var t = "";
//     $('#containerB input').each(function () {
//         if ($(this).attr("col") !== undefined) {
//             if ($(this).val() === "") {
//                 t += "Не введено поле row: " + $(this).attr("row") + " column: " + $(this).attr("col") + "\n";
//                 // can = false;
//             } else {
//                 mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
//             }
//         }
//     })
//
//     if (JSON.stringify(mas) === "[]") {
//         alert("No input");
//         document.getElementById('inputB').style.visibility = 'hidden';
//     } else {
//         var res = mascheckB(JSON.stringify(mas));
//         if (res[0]) {
//             sessionStorage.setItem("Bcols", res[1]);
//             sessionStorage.setItem("Brows", res[2]);
//             $('#forResponseB').val(JSON.stringify(mas));
//             document.getElementById('inputB').style.visibility = 'visible';
//         } else {
//             document.getElementById('inputB').style.visibility = 'hidden';
//         }
//     }
//
//
// }
