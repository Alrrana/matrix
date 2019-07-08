<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Permyakova
  Date: 08.07.2019
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app='test'>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/js.js"></script>
    <script type="text/javascript" src="js/angular.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Play:400,700&display=swap&subset=cyrillic" rel="stylesheet">
</head>
<body ng-init="init()">
<div class="wrapper" ng-controller="testController">
    <div class="custom">
        <div class="form">
            <div class="custom">

                <button name="AplusColA" ng-click="plusColA()">+ plusColA</button>
                <button name="AplusRowA" ng-click="plusRowA()">+ plusRowA</button>
                <button name="AminusColA" ng-click="minusColA()">- minusColA</button>
                <button name="AminusRowA" ng-click="minusRowA()">- minusRowA</button>
                <form action="clearMA" method="post"><input type="hidden"/>
                    <button  ng-click="clearM('#matrixA','Acols','Arows','plusOneA')">Очистить</button>
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

            <form action="input" method="post"><input type="hidden" name="forResponseA" id="forResponseA"/>
                <button name="inputA" id="inputA" ng-click="allChecks('plusOneA')">Ввести матрицу</button>
            </form>
            <form action="plusMA" method="post">
                <button name="plusOneA" id="plusOneA" >Плюс один ко всем ячейкам матрицы</button>
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

                <%--                <form action="input" method="post">--%>
                <%--                    <input type="hidden" name="forResponseA" id="forResponseA"/>--%>
                <%--                </form>--%>

            </div>
        </div>
    </div>
    <div class="custom">
        <div class="form">

            <div class="custom">

                <button name="BplusColB" ng-click="plusColB()">+ plusColB</button>
                <button name="BplusRowB" ng-click="plusRowB()">+ plusRowB</button>
                <button name="BminusColB" ng-click="minusColB()">- minusColB</button>
                <button name="BminusRowB" ng-click="minusRowB()">- minusRowB</button>
                <form action="clearMB" method="post"><input type="hidden"/>
                    <button  ng-click="clearM('#matrixB','Bcols','Brows','plusOneB')">Очистить</button>
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
            <form action="input" method="post"><input type="hidden" name="forResponseB" id="forResponseB"/>
                <button name="inputB" id="inputB" ng-click="allChecks('plusOneB')">Ввести матрицу</button>
            </form>
            <form action="plusMB" method="post">
                <button name="plusOneB" id="plusOneB" >Плюс один ко всем ячейкам матрицы</button>
            </form>
        </div>
        <div class="block">
            <div id="containerB">
                <%--                <form action="input" onkeyup="inpB()" method="post">--%>
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
                    <form action="sum" method="post"><input type="hidden" name="sum"/>
                        <button name="sum" id="sum" ng-click="sumFunc()">Sum</button>
                    </form>
                    <form action="sub" method="post"><input type="hidden" name="sub"/>
                        <button name="sub" id="sub" ng-click="subFunc()">Subtract</button>
                    </form>
                    <form action="mult" method="post"><input type="hidden" name="mult"/>
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
</html>
