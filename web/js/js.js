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
        $('#containerA').append('<div class="item"></div>');
    }
    for (let i = 0; i < 3; i++) {
        $('#containerA .item').each(function (index) {
            $(this).append('<input onkeyup="inpA()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
        })
    }
    for (let i = 0; i < 3; i++) {
        $('#containerB').append('<div class="item"></div>');
    }

    for (let i = 0; i < 3; i++) {
        $('#containerB .item').each(function (index) {
            $(this).append('<input onkeyup="inpB()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
        })
    }
    document.getElementById('inputA').style.visibility = 'hidden';  document.getElementById('plusOneA').style.visibility = 'visible';// ToDo
    document.getElementById('inputB').style.visibility = 'hidden';
    subCheck();
    multCheck();
    sumCheck();

}

function clearM(matrixId, col, row) {

    $(matrixId).val(null);
    allChecks();
    init();
    sessionStorage.setItem(col, null);
    sessionStorage.setItem(row, null);
}


function plusRowA() {
    var row = parseInt(sessionStorage.getItem("matrixArows")) + 1;

    $('#containerA .item').each(function (index) {
        $(this).append('<div class="col"><input onkeyup="inpA()" type="text" col="' + index + '" row="' + row + '" placeholder="_"></div>');
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
            $(this).append('<input onkeyup="inpA()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
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
            $(this).append('<input onkeyup="inpA()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
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
        $(this).append('<div class="col"><input onkeyup="inpB()" type="text" col="' + index + '" row="' + row + '" placeholder="_"></div>');
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
            $(this).append('<input onkeyup="inpB()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
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
            $(this).append('<input onkeyup="inpB()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
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


function inpA() {
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
        document.getElementById('inputA').style.visibility = 'hidden';  document.getElementById('plusOneA').style.visibility = 'visible';// ToDo
    } else {
        var res = mascheckA(JSON.stringify(mas));
        if (res[0]) {
            sessionStorage.setItem("Acols", res[1]);
            sessionStorage.setItem("Arows", res[2]);
            $('#forResponseA').val(JSON.stringify(mas));
            document.getElementById('inputA').style.visibility = 'visible'; document.getElementById('plusOneA').style.visibility = 'visible';

        } else {
            document.getElementById('inputA').style.visibility = 'hidden';  document.getElementById('plusOneA').style.visibility = 'visible';// ToDo
        }
    }

}

function inpB() {
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
            sessionStorage.setItem("Bcols", res[1]);
            sessionStorage.setItem("Brows", res[2]);
            $('#forResponseB').val(JSON.stringify(mas));
            document.getElementById('inputB').style.visibility = 'visible';
        } else {
            document.getElementById('inputB').style.visibility = 'hidden';
        }
    }


}

function allChecks() {
    subCheck();
    multCheck();
    sumCheck();
}


function multFunc() {
    var Acols = sessionStorage.getItem("Acols");
    var Arows = sessionStorage.getItem("Arows");
    var Bcols = sessionStorage.getItem("Bcols");
    var Brows = sessionStorage.getItem("Brows");

    // alert(Acols + " " + Arows + "        " + Bcols + " " + Brows);

    if ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
        (Acols === Brows) || (Arows === Bcols)
        || (Acols === Bcols && Arows === Brows)) {

        $('#mult').val("yes");


    } else {

        $('#mult').val("no");

    }
}

function sumFunc() {
    var Acols = sessionStorage.getItem("Acols");
    var Arows = sessionStorage.getItem("Arows");
    var Bcols = sessionStorage.getItem("Bcols");
    var Brows = sessionStorage.getItem("Brows");
    // alert(Acols + " " + Arows + "        " + Bcols + " " + Brows);

    if ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
        (Acols === Bcols && Arows === Brows)) {


    } else {


    }
}

function subFunc() {
    var Acols = sessionStorage.getItem("Acols");
    var Arows = sessionStorage.getItem("Arows");
    var Bcols = sessionStorage.getItem("Bcols");
    var Brows = sessionStorage.getItem("Brows");

    // alert(Acols + " " + Arows + "        " + Bcols + " " + Brows);

    if ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
        (Acols === Bcols && Arows === Brows)) {


    } else {

    }
}


function multCheck() {
    var Acols = sessionStorage.getItem("Acols");
    var Arows = sessionStorage.getItem("Arows");
    var Bcols = sessionStorage.getItem("Bcols");
    var Brows = sessionStorage.getItem("Brows");

    // alert(Acols + " " + Arows + "        " + Bcols + " " + Brows);

    if ((Acols != null) && (Bcols != null) && ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
        (Acols === Brows) || (Arows === Bcols)
        || (Acols === Bcols && Arows === Brows))) {

        $('#mult').val("yes");
        document.getElementById('mult').style.visibility = 'visible';
    } else {

        $('#mult').val("no");
        document.getElementById('mult').style.visibility = 'hidden';
    }
}


function sumCheck() {
    var Acols = sessionStorage.getItem("Acols");
    var Arows = sessionStorage.getItem("Arows");
    var Bcols = sessionStorage.getItem("Bcols");
    var Brows = sessionStorage.getItem("Brows");
    // alert(Acols + " " + Arows + "        " + Bcols + " " + Brows);

    if ((Acols != null) && (Bcols != null) && ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
        (Acols === Bcols && Arows === Brows))) {
        document.getElementById('sum').style.visibility = 'visible';

    } else {
        document.getElementById('sum').style.visibility = 'hidden';

    }
}

function subCheck() {
    var Acols = sessionStorage.getItem("Acols");
    var Arows = sessionStorage.getItem("Arows");
    var Bcols = sessionStorage.getItem("Bcols");
    var Brows = sessionStorage.getItem("Brows");

    // alert(Acols + " " + Arows + "        " + Bcols + " " + Brows);

    if ((Acols != null) && (Bcols != null) && ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
        (Acols === Bcols && Arows === Brows))) {

        document.getElementById('sub').style.visibility = 'visible';

    } else {
        document.getElementById('sub').style.visibility = 'hidden';

    }
}

function plusOneAF() {
    input = $('#forResponseA').val();
    var parsed = input.split('\"');
    var col = parseInt(parsed[parsed.length - 2]) + 1;
    var row = parseInt(parsed[parsed.length - 6]) + 1;
    var res = new Array(row);
    for (let i = 0; i < row; i++) {
        res[i] = new Array(col);
    }

    for (let i = 3; i < parsed.length; i += 12
    ) {
        if (parsed[i] === "")
            return false;

        try {
            res[parsed[i + 4]][parsed[i + 8]] = parsed[i];
        } catch (e) {
        }
    }


    for (let i = 0; i < col; i++)
        for (let j = 0; j < row; j++) {
            res[i][j] = String(parseInt(res[i][j]) + 1);
        }


    var mas = [];
    for (let i = 0; i < col; i++)
        for (let j = 0; j < row; j++) {
            mas.push({value: res[i][j], row: j, col: i});
        }
    alert(mas);
    $('#forResponseA').val(JSON.stringify(mas));
}

//==============================
// function addFields(){
// 	var number = '10';
//     var container = document.getElementById("container");
//     while (container.hasChildNodes()) {
//         container.removeChild(container.lastChild);
//     }
//     for (i=0;i<number;i++){
//         container.appendChild(document.createTextNode("Member " + (i+1)));
//         var input = document.createElement("input");
//         input.type = "text";
//         container.appendChild(input);
//         container.appendChild(document.createElement("br"));
//     }         
// }

//
//
// function goA() {
//
//     var row = sessionStorage.getItem("matrixAcols") + 1;
//     var col = sessionStorage.getItem("matrixArows" + 1);
//     while (container.hasChildNodes()) {
//         container.removeChild(container.lastChild);
//     }
//     if ($(document).find('input[name="row"]').val() !== "" && $(document).find('input[name="col"]').val() !== ""
//         && $(document).find('input[name="row"]').val() > 0 && $(document).find('input[name="col"]').val() > 0) {
//
//         $('#containerA').append('<div class="form"> ' +
//             '<form action="input" method="post"> <input type="hidden" name="forResponseA" id="forResponseA"/>' +
//             '<button name="inputA" onclick="inpA()">Ввести матрицу</button>' +
//             '</form> '
//             + '</div>');
//         for (i = 0; i < col; i++) {
//             $('#containerA').append('<div class="item"></div>');
//         }
//         for (i = 0; i < row; i++) {
//             $('#containerA .item').each(function (index) {
//                 $(this).append('<div class="col"><input type="text" col="' + index + '" row="' + i + '" placeholder="_"></div>');
//             })
//         }
//         sessionStorage.setItem("matrixAcols", col);
//         sessionStorage.setItem("matrixArows", row);
//         // $('#containerA').append();}
//
//     } else {
//         $('#containerA').append(
//             '<form action="input" method="post"> <input type="hidden" name="forResponseA" id="forResponseA"/>' +
//             '</form> ');
//     }
// }
//
//
// function plusB() {
//     var row = sessionStorage.setItem("matrixBcols", 3) + 1;
//
//     var col = sessionStorage.setItem("matrixBrows", 3) + 1;
//     var container = document.getElementById("containerB");
//     while (container.hasChildNodes()) {
//         container.removeChild(container.lastChild);
//     }
//
//     if ($(document).find('input[name="rowB"]').val() !== "" && $(document).find('input[name="colB"]').val() !== ""
//         && $(document).find('input[name="rowB"]').val() > 0 && $(document).find('input[name="colB"]').val() > 0) {
//
//         sessionStorage.setItem("matrixBcols", col);
//         sessionStorage.setItem("matrixBrows", row);
//         $('#containerB').append('<div class="form"> ' +
//             '<form action="input" method="post"> <input type="hidden" name="forResponseB" id="forResponseB"/>' +
//             '<button name="inputB" onclick="inpB()">Ввести матрицу</button>' +
//             '</form> '
//             + '</div>');
//         for (i = 0; i < col; i++) {
//             $('#containerB').append('<div class="item"></div>');
//         }
//         for (i = 0; i < row; i++) {
//
//
//             $('#containerB .item').each(function (index) {
//                 $(this).append('<input type="text" col="' + index + '" row="' + i + '" placeholder="_">');
//                 // alert("123");
//             })
//         }
//     } else {
//         $('#containerB').append(
//             '<form action="input" method="post"> <input type="hidden" name="forResponseB" id="forResponseB"/>' +
//             '</form> ');
//
//     }
// }
//
