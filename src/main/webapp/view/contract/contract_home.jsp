<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/23/2025
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contract List</title>
    <c:import url="/view/layout/library.jsp"/>
    <c:import url="/view/layout/css_style.jsp"/>
</head>
<body>
<c:import url="/view/layout/header.jsp"/>
<c:import url="/view/layout/navbar.jsp"/>
<main class="container py-4">
    <div class="row">
        <c:import url="/view/layout/contract_navbar.jsp"/>
        <div class="col-lg-9">
            <div class="bg-white p-2 shadow-sm rounded">
                <h2>Contract List</h2>
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Deposit</th>
                            <th>Total Money</th>
                            <th>Employee</th>
                            <th>Customer</th>
                            <th>Service</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${contractList}" var="contract">
                            <tr>
                                <td>${contract.getContractId()}</td>
                                <td>${contract.getContractStartDateString()}</td>
                                <td>${contract.getContractEndDateString()}</td>
                                <td>${contract.getContractDepositString()}</td>
                                <td>${contract.getContractTotalMoneyString()}</td>
                                <td>${contract.getEmployeeName()}</td>
                                <td>${contract.getCustomerName()}</td>
                                <td>${contract.getServiceName()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <nav aria-label="Page navigation" class="mt-4">
                    <ul class="pagination justify-content-end">
                        <li class="page-item">
                            <a class="page-link" href="/contracts?page=1" aria-label="Next">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:if test="${pageNum > 2}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/contracts?page=${pageNum - 2}">${pageNum - 2}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageNum > 1}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/contracts?page=${pageNum - 1}">${pageNum - 1}</a>
                            </li>
                        </c:if>
                        <li class="page-item active">
                            <a class="page-link"
                               href="/contracts?page=${pageNum}&keyword=${keyword}">${pageNum}</a>
                        </li>
                        <c:if test="${pageNum < lastPageNum}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/contracts?page=${pageNum + 1}">${pageNum + 1}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageNum < lastPageNum - 1}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/contracts?page=${pageNum + 2}">${pageNum + 2}</a>
                            </li>
                        </c:if>
                        <li class="page-item">
                            <a class="page-link" href="/contracts?page=${lastPageNum}"
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
