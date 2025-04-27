<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/23/2025
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add New Contract</title>
    <c:import url="/view/layout/library.jsp"/>
    <c:import url="/view/layout/css_style.jsp"/>
</head>
<body>
<c:import url="/view/layout/header.jsp"/>
<c:import url="/view/layout/navbar.jsp"/>
<main class="container py-4">
    <div class="row">
        <c:import url="/view/layout/contract_navbar.jsp"/>
        <div class="bg-white p-2 shadow-sm rounded col-lg-9">
            <div class="container py-3">
                <div class="row justify-content-center">
                    <div class="col-md-12">
                        <div class="card shadow-lg">
                            <div class="card-header bg-primary text-white">
                                <h3 class="mb-0">Add A New Contract</h3>
                            </div>
                            <div class="card-body">
                                <form class="needs-validation" action="/contract_add_forms" method="post">
                                    <div class="row g-3">
                                        <input type="hidden" name="action" value="addNewContract">
                                        <div class="col-md-6">
                                            <label for="contractStartDate" class="form-label">Start Date</label>
                                            <input type="text" class="form-control" id="contractStartDate"
                                                   placeholder="dd/mm/yyyy" name="contractStartDate"
                                                   required pattern="^[0-9]{2}/[0-9]{2}/[0-9]{4}$">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="contractEndDate" class="form-label">End Date</label>
                                            <input type="text" class="form-control" id="contractEndDate"
                                                   placeholder="dd/mm/yyyy" name="contractEndDate"
                                                   required pattern="^[0-9]{2}/[0-9]{2}/[0-9]{4}$">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="contractDeposit" class="form-label">Contract Deposit</label>
                                            <input type="number" class="form-control" id="contractDeposit"
                                                   placeholder="Enter contract deposit" name="contractDeposit" required
                                                   min="0">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="contractTotalMoney" class="form-label">Contract Total Money</label>
                                            <input type="number" class="form-control" id="contractTotalMoney"
                                                   placeholder="Enter contract total money" name="contractTotalMoney" required
                                                   min="0">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="employee" class="form-label">Employee</label>
                                            <select class="form-select" id="employee" name="employeeId"
                                                    required>
                                                <option value="" selected disabled>Select employee</option>
                                                <c:forEach items="${employeeList}" var="employee">
                                                    <option value="${employee.getEmployeeId()}">
                                                            ${employee.getEmployeeName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="customer" class="form-label">Customer</label>
                                            <select class="form-select" id="customer" name="customerId"
                                                    required>
                                                <option value="" selected disabled>Select customer</option>
                                                <c:forEach items="${customerList}" var="customer">
                                                    <option value="${customer.getCustomerId()}">
                                                            ${customer.getCustomerName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="service" class="form-label">Service</label>
                                            <select class="form-select" id="service" name="serviceId"
                                                    required>
                                                <option value="" selected disabled>Select service</option>
                                                <c:forEach items="${serviceList}" var="service">
                                                    <option value="${service.getServiceId()}">
                                                            ${service.getServiceName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-12 mt-4 d-flex gap-2 justify-content-end">
                                            <button type="reset" class="btn btn-secondary">Clear Form</button>
                                            <button type="submit" class="btn btn-primary">Add A Contract</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<c:import url="/view/layout/footer.jsp"/>
</body>
</html>