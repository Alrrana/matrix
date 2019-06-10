//==============================
$(document).ready(function () {
    $('.form').on('click', 'button[name="goA"]', function () {

        var row = $(this).parent().find('input[name="row"]').val();
        var col = $(this).parent().find('input[name="col"]').val();
        var container = document.getElementById("containerA");
        while (container.hasChildNodes()) {
            container.removeChild(container.lastChild);
        }

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
        // $('#containerA').append();

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
        //
    });

});

function inpA() {
    var mas = [];

    $('#containerA input').each(function () {
        // o.push();
        mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
    })
    alert("Матрица успешно введена");
    $('#forResponseA').val(JSON.stringify(mas));
}

function inpB() {
    var mas = [];

    $('#containerB input').each(function () {
        // o.push();
        mas.push({value: $(this).val(), row: $(this).attr("row"), col: $(this).attr("col")});
    })
    alert("Матрица успешно введена");
    $('#forResponseB').val(JSON.stringify(mas));
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