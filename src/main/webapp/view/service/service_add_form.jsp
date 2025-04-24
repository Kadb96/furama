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
    <title>Add New Service</title>
    <c:import url="/view/layout/library.jsp"/>
    <c:import url="/view/layout/css_style.jsp"/>
</head>
<body>
<c:import url="/view/layout/header.jsp"/>
<c:import url="/view/layout/navbar.jsp"/>
<main class="container py-4">
    <div class="row">
        <c:import url="/view/layout/service_navbar.jsp"/>
        <div class="bg-white p-2 shadow-sm rounded col-lg-9">
            <div class="container py-3">
                <div class="row justify-content-center">
                    <div class="col-md-12">
                        <div class="card shadow-lg">
                            <div class="card-header bg-primary text-white">
                                <h3 class="mb-0">Add A New Service</h3>
                            </div>
                            <div class="card-body">
                                <form class="needs-validation" action="/service_add_forms" method="post">
                                    <div class="row g-3">
                                        <input type="hidden" name="action" value="addNewService">
                                        <div class="col-md-6">
                                            <label for="serviceName" class="form-label">Service Name</label>
                                            <input type="text" name="serviceName" class="form-control"
                                                   id="serviceName" placeholder="Enter service's name" required
                                                   maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="serviceArea" class="form-label">Service's Area</label>
                                            <input type="number" class="form-control" id="serviceArea"
                                                   placeholder="Enter service's area" name="serviceArea" min="0">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="serviceCost" class="form-label">Service's Cost</label>
                                            <input type="number" class="form-control" id="serviceCost"
                                                   placeholder="Enter service's cost" name="serviceCost" required
                                                   min="0">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="serviceMaxPeople" class="form-label">Max People</label>
                                            <input type="number" class="form-control" id="serviceMaxPeople"
                                                   placeholder="Enter service's max people" name="serviceMaxPeople"
                                                   min="1">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="rentType" class="form-label">Rent Type</label>
                                            <select class="form-select" id="rentType" name="rentTypeId" required>
                                                <option value="" selected disabled>Select rent type</option>
                                                <c:forEach items="${rentTypeList}" var="rentType">
                                                    <option value="${rentType.getRentTypeId()}">
                                                        ${rentType.getRentTypeName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="serviceType" class="form-label">Service Type</label>
                                            <select class="form-select" id="serviceType" name="serviceTypeId" required>
                                                <option value="" selected disabled>Select service type</option>
                                                <c:forEach items="${serviceTypeList}" var="serviceType">
                                                    <option value="${serviceType.getServiceTypeId()}">
                                                            ${serviceType.getServiceTypeName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="standardRoom" class="form-label">Standard Room</label>
                                            <input type="text" name="standardRoom" class="form-control"
                                                   id="standardRoom" placeholder="Enter standard room" maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="descriptionOtherConvenience" class="form-label">
                                                Description Other Convenience
                                            </label>
                                            <input type="text" name="descriptionOtherConvenience" class="form-control"
                                                   id="descriptionOtherConvenience" placeholder="Enter other convenience"
                                                   maxlength="45">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="poolArea" class="form-label">Pool Area</label>
                                            <input type="number" class="form-control" id="poolArea"
                                                   placeholder="Enter pool's area" name="poolArea" min="0">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="numberOfFloors" class="form-label">Number Of Floors</label>
                                            <input type="number" class="form-control" id="numberOfFloors"
                                                   placeholder="Enter number of floors" name="numberOfFloors" min="0">
                                        </div>
                                        <div class="col-12 mt-4 d-flex gap-2 justify-content-end">
                                            <button type="reset" class="btn btn-secondary">Clear Form</button>
                                            <button type="submit" class="btn btn-primary">Add A Service</button>
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