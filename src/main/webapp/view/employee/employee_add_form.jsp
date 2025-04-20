<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/19/2025
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add New Employee</title>
    <c:import url="/view/layout/library.jsp"/>
    <c:import url="/view/layout/css_style.jsp"/>
</head>
<body>
<c:import url="/view/layout/header.jsp"/>
<c:import url="/view/layout/navbar.jsp"/>
<main class="container py-4">
    <div class="row">
        <c:import url="/view/layout/employee_navbar.jsp"/>
        <div class="bg-white p-2 shadow-sm rounded col-lg-9">
            <div class="container py-3">
                <div class="row justify-content-center">
                    <div class="col-md-12">
                        <div class="card shadow-lg">
                            <div class="card-header bg-primary text-white">
                                <h3 class="mb-0">Add A New Employee</h3>
                            </div>
                            <div class="card-body">
                                <form class="needs-validation" action="/employee_add_forms" method="post">
                                    <div class="row g-3">
                                        <input type="hidden" name="action" value="addNewEmployee">
                                        <div class="col-md-6">
                                            <label for="employeeName" class="form-label">Employee Name</label>
                                            <input type="text" name="employeeName" class="form-control"
                                                   id="employeeName" placeholder="Enter full employee name" required
                                                   maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="employeeBirthday" class="form-label">Birthday</label>
                                            <input type="text" class="form-control" id="employeeBirthday"
                                                   placeholder="dd/mm/yyyy" name="employeeBirthday"
                                                   required pattern="^[0-9]{2}/[0-9]{2}/[0-9]{4}$">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="employeeIdCard" class="form-label">ID Card Number</label>
                                            <input type="text" class="form-control" id="employeeIdCard"
                                                   placeholder="Enter ID card number" name="employeeIdCard" required
                                                   pattern="[0-9]+" maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="employeeSalary" class="form-label">Salary</label>
                                            <input type="number" class="form-control" id="employeeSalary"
                                                   placeholder="Enter employee's salary" name="employeeSalary" required
                                                   min="0">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="employeePhone" class="form-label">Phone Number</label>
                                            <input type="tel" class="form-control" id="employeePhone"
                                                   name="employeePhone" placeholder="+84 353-682-333" required
                                                   pattern="[+][0-9]{1,4}\s?[(]?[0-9]{1,4}[)]?[-\s]?[0-9]{1,10}"
                                                   maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="employeeEmail" class="form-label">Email Address</label>
                                            <input type="email" class="form-control" id="employeeEmail"
                                                   name="employeeEmail" placeholder="example@domain.com" maxlength="45">
                                        </div>
                                        <div class="col-6">
                                            <label for="employeeAddress" class="form-label">Address</label>
                                            <input type="text" class="form-control" id="employeeAddress"
                                                   name="employeeAddress" placeholder="Enter full address" maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="position" class="form-label">Position</label>
                                            <select class="form-select" id="position" name="positionId"
                                                    required>
                                                <option value="" selected disabled>Select position</option>
                                                <c:forEach items="${positionList}" var="position">
                                                    <option value="${position.getPositionId()}">
                                                            ${position.getPositionName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="educationDegree" class="form-label">Education Degree</label>
                                            <select class="form-select" id="educationDegree" name="educationDegreeId"
                                                    required>
                                                <option value="" selected disabled>Select education degree</option>
                                                <c:forEach items="${educationDegreeList}" var="educationDegree">
                                                    <option value="${educationDegree.getEducationDegreeId()}">
                                                            ${educationDegree.getEducationDegreeName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="division" class="form-label">Division</label>
                                            <select class="form-select" id="division" name="divisionId"
                                                    required>
                                                <option value="" selected disabled>Select division</option>
                                                <c:forEach items="${divisionList}" var="division">
                                                    <option value="${division.getDivisionId()}">
                                                            ${division.getDivisionName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-6">
                                            <label for="username" class="form-label">Username</label>
                                            <input type="text" class="form-control" id="username"
                                                   name="username" placeholder="Enter username" maxlength="45">
                                        </div>
                                        <div class="col-12 mt-4 d-flex gap-2 justify-content-end">
                                            <button type="reset" class="btn btn-secondary">Clear Form</button>
                                            <button type="submit" class="btn btn-primary">Register Employee</button>
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
