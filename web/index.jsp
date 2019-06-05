<%--
  Created by IntelliJ IDEA.
  User: Permyakova
  Date: 05.06.2019
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>

    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="name">Ввод матрицы</div>
<div class="block-round">
    <span class="r1"></span><span class="r2"></span><span class="r3"></span><span class="r4"></span>
    <div class="block-round-content">

        <label>1</label>
        <input type="text" name="matrixA" id="matrixA" value="${matrixA}">
        <form action="${pageContext.request.contextPath}/input" method="post">
            <button>Ввести</button>
        </form>

        <label>2</label>
        <input type="text" name="matrixB" id="matrixB" value="${matrixB}">
        <form action="${pageContext.request.contextPath}/input" method="post">
            <button>Ввести</button>
        </form>

    <span class="r4"></span><span class="r3"></span><span class="r2"></span><span class="r1"></span>
</div>
</div>
$END$
</body>
</html>