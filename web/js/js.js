//==============================
$(document).ready(function () {
    $('.form').on('click', 'button[name="goA"]', function () {

        var row = $(this).parent().find('input[name="row"]').val();
        var col = $(this).parent().find('input[name="col"]').val();
        var container = document.getElementById("containerA");
        while (container.hasChildNodes()) {
            container.removeChild(container.lastChild);
        }
        if ($(document).find('input[name="row"]').val() !== "" && $(document).find('input[name="col"]').val() !== ""
            && $(document).find('input[name="row"]').val() > 0 && $(document).find('input[name="col"]').val() > 0) {

            $('#containerA').append('<div class="form"> ' +
                '<form action="input" method="post"> <input type="hidden" name="forResponseA" id="forResponseA"/>' +
                '<button name="inputA" onclick="inpA()">Ввести матрицу</button>' +
                '</form> '
                + '</div>');
            for (i = 0; i < col; i++) {
                $('#containerA').append('<div class="item"></div>');
            }
            for (i = 0; i < row; i++) {
                $('#containerA .item').each(function (index) {
                    $(this).append('<div class="col"><input type="text" col="' + index + '" row="' + i + '" placeholder="_"></div>');
                })
            }
            // $('#containerA').append();}

        } else {
            $('#containerA').append(
                '<form action="input" method="post"> <input type="hidden" name="forResponseA" id="forResponseA"/>' +
                '</form> ');
        }
    });


});

$(document).ready(function () {
    $('.form').on('click', 'button[name="goB"]', function () {
        var row = $(this).parent().find('input[name="rowB"]').val();
        var col = $(this).parent().find('input[name="colB"]').val();
        var container = document.getElementById("containerB");
        while (container.hasChildNodes()) {
            container.removeChild(container.lastChild);
        }

        if ($(document).find('input[name="rowB"]').val() !== "" && $(document).find('input[name="colB"]').val() !== ""
            && $(document).find('input[name="rowB"]').val() > 0 && $(document).find('input[name="colB"]').val() > 0) {

            $('#containerB').append('<div class="form"> ' +
                '<form action="input" method="post"> <input type="hidden" name="forResponseB" id="forResponseB"/>' +
                '<button name="inputB" onclick="inpB()">Ввести матрицу</button>' +
                '</form> '
                + '</div>');
            for (i = 0; i < col; i++) {
                $('#containerB').append('<div class="item"></div>');
            }
            for (i = 0; i < row; i++) {


                $('#containerB .item').each(function (index) {
                    $(this).append('<div class="col"><input type="text" col="' + index + '" row="' + i + '" placeholder="_"></div>');
                    // alert("123");
                })
            }
        } else {
            $('#containerB').append(
                '<form action="input" method="post"> <input type="hidden" name="forResponseB" id="forResponseB"/>' +
                '</form> ');

        }
    });

});

function inpA() {
    var mas = [];
    var can = true;

    $('#containerA input').each(function () {
        if ($(this).attr("col") !== undefined) {
            if ($(this).val() === "") {
                alert("Не введено поле row: " + $(this).attr("row") + " column: " + $(this).attr("col"));
                can = false;
            }
            mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
        }
    })

    if (can) {
        $('#forResponseA').val(JSON.stringify(mas));
    }
}

function inpB() {
    var mas = [];
    var can = true;

    $('#containerB input').each(function () {
        if ($(this).attr("col") !== undefined) {
            if ($(this).val() === "") {
                alert("Не введено поле row: " + $(this).attr("row") + " column: " + $(this).attr("col"));
                can = false;
            }
            mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
        }
    })

    if (can) {
        $('#forResponseB').val(JSON.stringify(mas));
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