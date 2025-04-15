<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/11/2025
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Homepage</title>
    <c:import url="../view/layout/library.jsp"/>
    <c:import url="../view/layout/css_style.jsp"/>
</head>
<body>
<c:import url="../view/layout/header.jsp"/>
<c:import url="../view/layout/navbar.jsp"/>

<main class="container py-4">
    <div class="row">
        <div class="col-lg-3">
            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-action active">Item One</a>
                <a href="#" class="list-group-item list-group-item-action">Item Two</a>
                <a href="#" class="list-group-item list-group-item-action">Item Three</a>
            </div>
        </div>
        <div class="col-lg-9">
            <div class="bg-white p-4 shadow-sm rounded">
                <h2>Content</h2>
            </div>
        </div>
    </div>
</main>

<c:import url="../view/layout/footer.jsp"/>
</body>
</html>
