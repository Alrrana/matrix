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
    <div class="form">
        <input type="text" name="row" placeholder="Количество полей">
        <input type="text" name="col" placeholder="Количество колонок">
        <button name="goA">Задать размерность</button>

    </div>
    <div class="block"><div id="containerA"></div></div>

    <div class="form">
        <input type="text" name="rowB" placeholder="Количество полей">
        <input type="text" name="colB" placeholder="Количество колонок">
        <button name="goB">Задать размерность</button>
        <input type="hidden" id="forResponseB"/>
    </div>
    <div class="block"><div id="containerB"></div></div>
</div>

</body>
</html>