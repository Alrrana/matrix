//==============================
function goA() {

    var row = $(document).find('input[name="row"]').val();
    var col = $(document).find('input[name="col"]').val();
    var container = document.getElementById("containerA");
    while (container.hasChildNodes()) {
        container.removeChild(container.lastChild);
    }
    if ($(document).find('input[name="row"]').val() !== "" && $(document).find('input[name="col"]').val() !== ""
        && $(document).find('input[name="row"]').val() > 0 && $(document).find('input[name="col"]').val() > 0) {

        // $('#containerA').append('<div class="form"> ' +
        //     '<form action="input" method="post"> <input type="hidden" name="forResponseA" id="forResponseA"/>' +
        //     '<button name="inputA" onclick="inpA()">Ввести матрицу</button>' +
        //     '</form> '
        //     + '</div>');
        for (i = 0; i < col; i++) {
            $('#containerA').append('<div class="item"></div>');
        }
        for (i = 0; i < row; i++) {
            $('#containerA .item').each(function (index) {
                $(this).append('<div class="col"><input onkeyup="inpA()" type="text" col="' + index + '" row="' + i + '" placeholder="_"></div>');
            })
        }
        sessionStorage.setItem("matrixAcols", col);
        sessionStorage.setItem("matrixArows", row);
        // $('#containerA').append();}

    } else {
        // $('#containerA').append(
        //     '<form action="input" method="post"> <input type="hidden" name="forResponseA" id="forResponseA"/>' +
        //     '</form> ');
    }
}


function goB() {
    var row = $(document).find('input[name="rowB"]').val();
    var col = $(document).find('input[name="colB"]').val();
    var container = document.getElementById("containerB");
    while (container.hasChildNodes()) {
        container.removeChild(container.lastChild);
    }

    if ($(document).find('input[name="rowB"]').val() !== "" && $(document).find('input[name="colB"]').val() !== ""
        && $(document).find('input[name="rowB"]').val() > 0 && $(document).find('input[name="colB"]').val() > 0) {

        sessionStorage.setItem("matrixBcols", col);
        sessionStorage.setItem("matrixBrows", row);
        // $('#containerB').append('<div class="form"> ' +
        //     '<form action="input" method="post"> <input type="hidden" name="forResponseB" id="forResponseB"/>' +
        //     '<button name="inputB" onclick="inpB()">Ввести матрицу</button>' +
        //     '</form> '
        //     + '</div>');
        for (i = 0; i < col; i++) {
            $('#containerB').append('<div class="item"></div>');
        }
        for (i = 0; i < row; i++) {


            $('#containerB .item').each(function (index) {
                $(this).append('<input onkeyup="inpB()" type="text" col="' + index + '" row="' + i + '" placeholder="_">');
                // alert("123");
            })
        }
    } else {
        // $('#containerB').append(
        //     '<form action="input" method="post"> <input type="hidden" name="forResponseB" id="forResponseB"/>' +
        //     '</form> ');

    }
}

function inpA() {
    var mas = [];
    var can = true;

    $('#containerA input').each(function () {
        if ($(this).attr("col") !== undefined) {
            if ($(this).val() === "") {
                // alert("Не введено поле row: " + $(this).attr("row") + " column: " + $(this).attr("col"));
                can = false;
            }
            mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
        }
    })
 alert(can);
    if (can) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST','InputServlet',true);
        $('#forResponseA').val(JSON.stringify(mas));
    }
}

function inpB() {
    var mas = [];
    var can = true;

    $('#containerB input').each(function () {
        if ($(this).attr("col") !== undefined) {
            if ($(this).val() === "") {
                // alert("Не введено поле row: " + $(this).attr("row") + " column: " + $(this).attr("col"));
                can = false;
            }
            mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
        }
    })

    if (can) {
        $('#forResponseB').val(JSON.stringify(mas));
    }
}

function multFunc() {
    var Acols = sessionStorage.getItem("matrixAcols");
    var Arows = sessionStorage.getItem("matrixArows");
    var Bcols = sessionStorage.getItem("matrixBcols");
    var Brows = sessionStorage.getItem("matrixBrows");

    // alert(Acols + " " + Arows + "        " + Bcols + " " + Brows);

    if ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
        (Acols === Brows) || (Arows === Bcols)
        || (Acols === Bcols && Arows === Brows)) {

        $('#mult').val("yes");
    } else {
        alert("Умножение невозможно, так как матрицы разной размерности");
        $('#mult').val("no");
    }
}


function sumFunc() {
    var Acols = sessionStorage.getItem("matrixAcols");
    var Arows = sessionStorage.getItem("matrixArows");
    var Bcols = sessionStorage.getItem("matrixBcols");
    var Brows = sessionStorage.getItem("matrixBrows");

    // alert(Acols + " " + Arows + "        " + Bcols + " " + Brows);

    if ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
        (Acols === Bcols && Arows === Brows)) {
    } else {
        alert("Сложение невозможно, так как матрицы разной размерности");
    }
}

function subFunc() {
    var Acols = sessionStorage.getItem("matrixAcols");
    var Arows = sessionStorage.getItem("matrixArows");
    var Bcols = sessionStorage.getItem("matrixBcols");
    var Brows = sessionStorage.getItem("matrixBrows");

    // alert(Acols + " " + Arows + "        " + Bcols + " " + Brows);

    if ((Acols !== "") && (Bcols !== "") && (Arows !== "") && (Brows !== "") &&
        (Acols === Bcols && Arows === Brows)) {

    } else {
        alert("Вычитание невозможно, так как матрицы разной размерности");
    }
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