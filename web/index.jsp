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

    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Матрицы</h1>
</div>
<div class="w3-light-blue">
<%--    <span class="r1"></span><span class="r2"></span><span class="r3"></span><span class="r4"></span>--%>

    <%
        if (request.getAttribute("sizeEx")!=null) {
            response.getWriter().println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>FUCKING ERROR  HAPPENED!</h5>\n" +
                    "</div>");
        }
    %>
    <%
        if (request.getAttribute("success")!=null) {
            response.getWriter().println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Matrix successfully created!</h5>\n" +
                    "</div>");
        }
    %>

    <div class="block-round-content">
        <tr>
            <td>
                <form action="input" method="GET">
                    <br> A:
                    <textarea rows="10" cols="10" name="matrix"></textarea>
                    <br>
                    <input type="submit" value="Submit"/>
                </form>
            </td>
            <td>
                <form action="input" method="GET">
                    <br>B:
                    <textarea rows="10" cols="10" name="matrix"></textarea>
                    <br>
                    <input type="submit" value="Submit"/>
                </form>
            </td>
        </tr>
        <%--        <label>A:--%>
        <%--        <input type="text" name="matrix">--%>
        <%--            <button onclick="location.href='/input'">Ввести</button>--%>
        <%--        </label>--%>

        <%--        <label>2</label>--%>
        <%--        <input type="text" name="matrix" value="${matrix}">--%>
        <%--        <form action="${pageContext.request.contextPath}/input" method="post">--%>
        <%--            <button>Ввести</button>--%>
        <%--        </form>--%>

        <span class="r4"></span><span class="r3"></span><span class="r2"></span><span class="r1"></span>
    </div>
</div>
$END$
</body>
</html>