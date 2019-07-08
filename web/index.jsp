<%--
  Created by IntelliJ IDEA.
  User: Permyakova
  Date: 05.06.2019
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html ng-app="test" lang="en">
<head>
    <script type="text/javascript" src="js/angular.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="description" content="title"/>
    <meta name="keywords" content="title"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Matrix Calculator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" link href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/ang_test.js"></script>
    <script type="text/javascript" src="js/js.js"></script>

    <link href="https://fonts.googleapis.com/css?family=Play:400,700&display=swap&subset=cyrillic" rel="stylesheet">
</head>
<body onload="init()">
<div class="wrapper" ng-controller="testController">
    <div class="custom">
        <div class="form">
            <div class="custom">

                <button name="AplusColA" onclick="plusColA()">+ plusColA</button>
                <button name="AplusRowA" onclick="plusRowA()">+ plusRowA</button>
                <button name="AminusColA" onclick="minusColA()">- minusColA</button>
                <button name="AminusRowA" onclick="minusRowA()">- minusRowA</button>
                <form><input type="hidden"/>
                    <button ng-click="clearM('#matrixA','Acols','Arows','plusOneA')">Очистить</button>
                </form>
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

            <form><input type="hidden" name="forResponseA" id="forResponseA"/>
                <button name="inputA" id="inputA" ng-click="inputAFunc()">Ввести матрицу</button>
            </form>
            <form>
                <button name="plusOneA" id="plusOneA">Плюс один ко всем ячейкам матрицы</button>
            </form>

        </div>

        <div class="block">
            <div id="containerA">
                <form>
                    <input type="hidden" name="Bcols" id="Bcols"/>
                </form>
                <form>
                    <input type="hidden" name="Bcols" id="Brows"/>
                </form>

                <%--                <form >--%>
                <%--                    <input type="hidden" name="forResponseA" id="forResponseA"/>--%>
                <%--                </form>--%>

            </div>
        </div>
    </div>
    <div class="custom">
        <div class="form">

            <div class="custom">

                <button name="BplusColB" onclick="plusColB()">+ plusColB</button>
                <button name="BplusRowB" onclick="plusRowB()">+ plusRowB</button>
                <button name="BminusColB" onclick="minusColB()">- minusColB</button>
                <button name="BminusRowB" onclick="minusRowB()">- minusRowB</button>
                <form><input type="hidden"/>
                    <button ng-click="clearM('#matrixB','Bcols','Brows','plusOneB')">Очистить</button>
                </form>
                <%--            <button name="plusB">Задать размерность</button>--%>
            </div>
            <div class="custom"
            <%--             style="position: relative; left: 384px; top: -7px;"--%>
            >
                <p>Введенная матрица B:</p>
                <c:forEach var="List1" items="${matrixB.getContent()}">
                    <p>${List1.toString()}</p>
                </c:forEach>
            </div>
            <form><input type="hidden" name="forResponseB" id="forResponseB"/>
                <button name="inputB" id="inputB" ng-click="allChecks('plusOneB')">Ввести матрицу</button>
            </form>
            <form>
                <button name="plusOneB" id="plusOneB">Плюс один ко всем ячейкам матрицы</button>
            </form>
        </div>
        <div class="block">
            <div id="containerB">
                <%--                <form >--%>
                <%--                    <input type="hidden" name="forResponseB" id="forResponseB"/>--%>
                <%--                </form>--%>
                <form>
                    <input type="hidden" name="Acols" id="Acols"/>
                </form>
                <form>
                    <input type="hidden" name="Acols" id="Arows"/>
                </form>
            </div>
        </div>
    </div>
    <div class="custom" style="vertical-align:top">
        <div class="block1">
            <div id="containerRes">
                <div class="form">

                    <button name="sum" id="sum" ng-click="sumFunc()">Sum</button>

                    <form><input type="hidden" name="sub"/>
                        <button name="sub" id="sub" ng-click="subFunc()">Subtract</button>
                    </form>
                    <form><input type="hidden" name="mult"/>
                        <button name="mult" id="mult" ng-click="multFunc()">Mult</button>
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
    </div>


    <%--    <c:if test="${MatrixRes!=null}">--%>
    <%--    </c:if>--%>
    ${matrixA.printStr()}
    ${matrixB.printStr()}

    <c:forEach items="${sessionScope}" var="attr">
        ${attr.key}=${attr.value}<br>
    </c:forEach>
</div>

</body>

</body>
</html>