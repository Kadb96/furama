<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/16/2025
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add New Customer</title>
    <c:import url="/view/layout/library.jsp"/>
    <c:import url="/view/layout/css_style.jsp"/>
</head>
<body>
<c:import url="/view/layout/header.jsp"/>
<c:import url="/view/layout/navbar.jsp"/>
<main class="container py-4">
    <div class="row">
        <c:import url="/view/layout/customer_navbar.jsp"/>
        <div class="bg-white p-2 shadow-sm rounded col-lg-9">
            <div class="container py-3">
                <div class="row justify-content-center">
                    <div class="col-md-12">
                        <div class="card shadow-lg">
                            <div class="card-header bg-primary text-white">
                                <h3 class="mb-0">Add A New Customer</h3>
                            </div>
                            <div class="card-body">
                                <form class="needs-validation" action="/customer_add_forms" method="post">
                                    <div class="row g-3">
                                        <input type="hidden" name="action" value="addNewCustomer">
                                        <div class="col-md-6">
                                            <label for="customerId" class="form-label">Customer Id</label>
                                            <input type="text" name="customerName" class="form-control"
                                                   id="customerId" placeholder="KH-XXXX" required
                                                   pattern="^KH-[0-9]{4}$" maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="customerName" class="form-label">Customer Name</label>
                                            <input type="text" name="customerName" class="form-control"
                                                   id="customerName" placeholder="Enter full customer name" required
                                                   maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="customerType" class="form-label">Customer Type</label>
                                            <select class="form-select" id="customerType" name="customerTypeId"
                                                    required>
                                                <option value="" selected disabled>Select customer type</option>
                                                <c:forEach items="${customerTypeList}" var="customerType">
                                                    <option value="${customerType.getCustomerTypeId()}">
                                                            ${customerType.getCustomerTypeName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="customerBirthday" class="form-label">Birthday</label>
                                            <input type="text" class="form-control" id="customerBirthday"
                                                   placeholder="dd/mm/yyyy" name="customerBirthday"
                                                   required pattern="^[0-9]{2}/[0-9]{2}/[0-9]{4}$">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="customerGender" class="form-label">Gender</label>
                                            <select class="form-select" id="customerGender" name="customerGender"
                                                    required>
                                                <option value="" selected disabled>Select gender</option>
                                                <option value="true">Male</option>
                                                <option value="false">Female</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="customerIdCard" class="form-label">ID Card Number</label>
                                            <input type="text" class="form-control" id="customerIdCard"
                                                   placeholder="Enter ID card number" name="customerIdCard" required
                                                   pattern="[0-9]+" maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="customerPhone" class="form-label">Phone Number</label>
                                            <input type="tel" class="form-control" id="customerPhone"
                                                   name="customerPhone" placeholder="+84 353-682-333" required
                                                   pattern="[+][0-9]{1,4}\s?[(]?[0-9]{1,4}[)]?[-\s]?[0-9]{1,10}"
                                                   maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="customerEmail" class="form-label">Email Address</label>
                                            <input type="email" class="form-control" id="customerEmail"
                                                   name="customerEmail" placeholder="example@domain.com" maxlength="45">
                                        </div>
                                        <div class="col-6">
                                            <label for="customerAddress" class="form-label">Address</label>
                                            <input type="text" class="form-control" id="customerAddress"
                                                   name="customerAddress" placeholder="Enter full address" maxlength="45">
                                        </div>
                                        <div class="col-12 mt-4 d-flex gap-2 justify-content-end">
                                            <button type="reset" class="btn btn-secondary">Clear Form</button>
                                            <button type="submit" class="btn btn-primary">Register Customer</button>
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