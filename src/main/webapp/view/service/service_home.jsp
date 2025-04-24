<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/22/2025
  Time: 9:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service List</title>
    <c:import url="/view/layout/library.jsp"/>
    <c:import url="/view/layout/css_style.jsp"/>
</head>
<body>
<c:import url="/view/layout/header.jsp"/>
<c:import url="/view/layout/navbar.jsp"/>
<main class="container py-4">
    <div class="row">
        <c:import url="/view/layout/service_navbar.jsp"/>
        <div class="col-lg-9">
            <div class="bg-white p-2 shadow-sm rounded">
                <h2>Service List</h2>
                <form action="/services" method="get">
                    <div class="row mb-3">
                        <div class="col">
                            <div class="input-group">
                                <input type="hidden" name="action" value="showServiceByPage">
                                <input type="text" class="form-control" id="tableSearch" name="keyword"
                                       value="${keyword}">
                                <button class="btn btn-sm btn-secondary me-1" type="submit">Search</button>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Service Area</th>
                            <th>Service Cost</th>
                            <th>Service Max People</th>
                            <th>Rent Type</th>
                            <th>Service Type</th>
                            <th>Standard Room</th>
                            <th>Description Other Convenience</th>
                            <th>Pool Area</th>
                            <th>Number Of Floors</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${serviceList}" var="service">
                            <tr>
                                <td>${service.getServiceId()}</td>
                                <td>${service.getServiceName()}</td>
                                <td>${service.getServiceAreaString()}</td>
                                <td>${service.getServiceCostString()}</td>
                                <td>${service.getServiceMaxPeople()}</td>
                                <td>${service.getRentTypeName()}</td>
                                <td>${service.getServiceTypeName()}</td>
                                <td>${service.getStandardRoom()}</td>
                                <td>${service.getDescriptionOtherConvenience()}</td>
                                <td>${service.getPoolAreaString()}</td>
                                <td>${service.getNumberOfFloorsString()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <nav aria-label="Page navigation" class="mt-4">
                    <ul class="pagination justify-content-end">
                        <li class="page-item">
                            <a class="page-link" href="/services?page=1&keyword=${keyword}" aria-label="Next">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:if test="${pageNum > 2}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/services?page=${pageNum - 2}&keyword=${keyword}">${pageNum - 2}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageNum > 1}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/services?page=${pageNum - 1}&keyword=${keyword}">${pageNum - 1}</a>
                            </li>
                        </c:if>
                        <li class="page-item active">
                            <a class="page-link"
                               href="/services?page=${pageNum}&keyword=${keyword}">${pageNum}</a>
                        </li>
                        <c:if test="${pageNum < lastPageNum}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/services?page=${pageNum + 1}&keyword=${keyword}">${pageNum + 1}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageNum < lastPageNum - 1}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/services?page=${pageNum + 2}&keyword=${keyword}">${pageNum + 2}</a>
                            </li>
                        </c:if>
                        <li class="page-item">
                            <a class="page-link" href="/services?page=${lastPageNum}&keyword=${keyword}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</main>
<c:import url="/view/layout/footer.jsp"/>
</body>
</html>