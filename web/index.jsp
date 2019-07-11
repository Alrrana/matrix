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
    <%--    <script type="text/javascript" src="js/angular.js"></script>--%>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    <script type="text/javascript" src="js/ang_test.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/js.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="description" content="title"/>
    <meta name="keywords" content="title"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Matrix Calculator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" link href="css/style.css"/>

    <link href="https://fonts.googleapis.com/css?family=Play:400,700&display=swap&subset=cyrillic" rel="stylesheet">
</head>
<body>
<div class="wrapper" ng-controller="testController">
    <%--    <div ng-init="testText = blabla('rrr')">--%>
    <%--        <span ng-click="checkInputContainerA()"> {{testText}} </span>--%>
    <%--    </div>--%>
    <%--    <input ng-change="checkInputContainerA()" ng-model="testModel" type="text" col="' + index + '" row="' + i + '" placeholder="_">--%>
    <div class="custom">
        <div class="form">
            <div class="custom">

                <button name="AplusColA" ng-click="plusColA()">+ plusColA</button>
                <button name="AplusRowA" ng-click="plusRowA()">+ plusRowA</button>
                <button name="AminusColA" ng-click="minusColA()">- minusColA</button>
                <button name="AminusRowA" ng-click="minusRowA()">- minusRowA</button>
                <form>
                    <button ng-click="clearM('A','plusOneA')">Очистить</button>
                </form>
                <%--            <button type="hidden" name="goA">Задать размерность</button>--%>
            </div>
            <div class="custom"
            <%--             style="position: relative; left: 384px; top: -7px;"--%>
            >
                <p>Введенная матрица A:</p>
<%--                <p> {{aRow}}, {{aCol}} </p>--%>
                <%--<p> {{matrixA}} </p>--%>
                <div ng-repeat="i in lenmatrixA">
                    <p> {{matrixA[i]}} </p>
                </div>

            </div>

            <form><input type="hidden" name="forResponseA" id="forResponseA"/>
                <button style="visibility:hidden;" name="inputA" id="inputA" ng-click="inputAFunc()">Ввести матрицу
                </button>
            </form>
            <form>
                <button style="visibility:hidden;" name="plusOneA" id="plusOneA" ng-click="plusOneA()">Плюс один ко всем
                    ячейкам матрицы
                </button>
            </form>

        </div>



        <div class="form">
            <div class="block" id="containerA">
                <table>
                    <tr ng-repeat="i in aColMax">
                        <td ng-repeat="j in aRowMax">
                            <input ng-model="wow[i][j]" ng-change="checkInputContainerA()" type="text" col={{i}} row={{j}}
                                   placeholder="_">
                        </td>
                    </tr>
                </table>

                <p>{{wow[0][0]}}     {{wow[0][1]}}    {{wow[1][0]}}        </p>
            </div>
        </div>

        <p> {{$scope}}</p>


    </div>




    <div class="custom">
        <div class="form">

            <div class="custom">

                <button name="BplusColB" ng-click="plusColB()">+ plusColB</button>
                <button name="BplusRowB" ng-click="plusRowB()">+ plusRowB</button>
                <button name="BminusColB" ng-click="minusColB()">- minusColB</button>
                <button name="BminusRowB" ng-click="minusRowB()">- minusRowB</button>
                <form><input type="hidden"/>
                    <button ng-click="clearM('B','plusOneB')">Очистить</button>
                </form>
                <%--            <button name="plusB">Задать размерность</button>--%>
            </div>


            <div class="custom"
            <%--             style="position: relative; left: 384px; top: -7px;"--%>
            >
                <p>Введенная матрица B:</p>
<%--                <p>{{bRow}} , {{bCol}} </p>--%>
                <%--  <p> {{matrixB}} </p>--%>
                <div ng-repeat="i in lenmatrixB">
                    <p> {{matrixB[i]}} </p>
                </div>
            </div>


            <form><input type="hidden" name="forResponseB" id="forResponseB"/>
                <button style="visibility:hidden;" name="inputB" id="inputB" ng-click="inputBFunc()">Ввести матрицу
                </button>
            </form>
            <form>
                <button style="visibility:hidden;" name="plusOneB" id="plusOneB"  ng-click="plusOneB()">Плюс один ко
                    всем ячейкам матрицы
                </button>
            </form>


        </div>



        <div class="form">
            <div class="block" id="containerB">
                <table>
                    <tr ng-repeat="i in bColMax">
                        <td ng-repeat="j in bRowMax">
                            <input ng-keyup="checkInputContainerB()" type="text" col={{i}} row={{j}} placeholder="_">
                        </td>
                    </tr>
                </table>

            </div>
        </div>



    </div>





    <div class="custom" style="vertical-align:top">
        <div class="block1">
            <div id="containerRes">
                <div class="form">

                    <button style="visibility:hidden;" name="sum" id="sum" ng-click="sumFunc()">Sum</button>

                    <form>
                        <button style="visibility:hidden;" name="sub" id="sub" ng-click="subFunc()">Subtract</button>
                    </form>
                    <form>
                        <button style="visibility:hidden;" name="mult" id="mult" ng-click="multFunc()">Mult</button>
                    </form>
                </div>


            </div>
        </div>

        <div class="form">
            <p>Result:</p>

            <%--  <p>{{masRes}} </p>--%>
            <div ng-repeat="i in lenmatrixRes">
                <p> {{matrixRes[i]}} </p>
            </div>
            <%--            <table>--%>
            <%--                <tr ng-repeat="i in resColMax">--%>
            <%--                    <td ng-repeat="j in resRowMax">--%>
            <%--                        <input type="text" col={{i}} row={{j}} placeholder="_">--%>
            <%--                    </td>--%>
            <%--                </tr>--%>
            <%--            </table>--%>
        </div>
    </div>


</div>
<%--<div ng-repeat="i in [0,1,2]">--%>
<%--    <input type="text" name="kjdhfgkjds" ng-model="wow[i]"/>--%>
<%--    <span>{{wow[i]}}</span>--%>
<%--</div>--%>
</body>
</html>