<%--
  Created by IntelliJ IDEA.
  User: Permyakova
  Date: 05.06.2019
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="description" content="title"/>
    <meta name="keywords" content="title"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>$Title$</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" link href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/js.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Play:400,700&display=swap&subset=cyrillic" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <div class="custom">
        <div class="form">

            <div class="custom">
                <input type="text" onkeyup="goA()" name="row" placeholder="Количество полей">
                <input type="text" onkeyup="goA()" name="col" placeholder="Количество колонок">
                <%--            <button type="hidden" name="goA">Задать размерность</button>--%>
            </div>
            <div class="custom"
            <%--             style="position: relative; left: 384px; top: -7px;"--%>
            >
                <p>Введенная матрица A:</p>
                <c:forEach var="List1" items="${matrixA.getContent()}">
                    <p>${List1.toString()}</p>
                </c:forEach>
            </div>
        </div>

        <div class="block">
            <div id="containerA">

                <form action="input"  method="post">
                    <input type="hidden" name="forResponseA" id="forResponseA"/>
                </form>

            </div>
        </div>
    </div>
    <div class="custom">
        <div class="form">
            <div class="custom">
                <input type="text" onkeyup="goB()" name="rowB" placeholder="Количество полей">
                <input type="text" onkeyup="goB()" name="colB" placeholder="Количество колонок">
                <%--            <button name="goB">Задать размерность</button>--%>
            </div>
            <div class="custom"
            <%--             style="position: relative; left: 384px; top: -7px;"--%>
            >
                <p>Введенная матрица B:</p>
                <c:forEach var="List1" items="${matrixB.getContent()}">
                    <p>${List1.toString()}</p>
                </c:forEach>
            </div>

        </div>
        <div class="block">
            <div id="containerB">
                <form action="input" onkeyup="inpB()" method="post">
                    <input type="hidden" name="forResponseB" id="forResponseB"/>
                </form>
            </div>
        </div>
    </div>
    <div class="block">
        <div id="containerRes">
            <div class="form">
                <form action="sum" method="post"><input type="hidden" name="sum" id="sum"/>
                    <button name="sum" onclick="sumFunc()">Sum</button>
                </form>
                <form action="sub" method="post"><input type="hidden" name="sub" id="sub"/>
                    <button name="sub" onclick="subFunc()">Subtract</button>
                </form>
                <form action="mult" method="post"><input type="hidden" name="mult" id="mult"/>
                    <button name="mult" onclick="multFunc()">Mult</button>
                </form>
            </div>

        </div>
    </div>

    <div class="form">
        <p>Result:</p>
        <c:forEach var="List1" items="${MatrixRes.getContent()}">
            <%--        <c:forEach var="num" items="${List1}">--%>
            <p>${List1.toString()}</p>
            <%--        </c:forEach>--%>
            <%--        <p></p>--%>
        </c:forEach>
    </div>


    <%--    <c:if test="${MatrixRes!=null}">--%>
    <%--    </c:if>--%>
    ${matrixA.printStr()}
    ${matrixB.printStr()}
</div>

</body>
</html>