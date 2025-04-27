<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/25/2025
  Time: 2:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add New Contract Detail</title>
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
                                <h3 class="mb-0">Add Contract Detail</h3>
                            </div>
                            <div class="card-body">
                                <form class="needs-validation" action="/contract_detail_add_forms" method="post">
                                    <div class="row g-3">
                                        <input type="hidden" name="action" value="addNewContractDetail">
                                        <div class="col-md-6">
                                            <label for="contract" class="form-label">Contract</label>
                                            <c:if test="${contractId == 0}">
                                                <select class="form-select" id="contract" name="contractId"
                                                        required>
                                                    <option value="" selected disabled>Select contract</option>
                                                    <c:forEach items="${contractList}" var="contract">
                                                        <option value="${contract.getContractId()}">
                                                                ${contract.getContractId()} - ${contract.getCustomerName()} - ${contract.getServiceName()} - ${contract.getContractStartDateString()}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </c:if>
                                            <c:if test="${contractId > 0}">
                                                <input type="text" class="form-control" name="contractId" id="contract"
                                                       value="${contractId}" readonly>
                                            </c:if>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="attachService" class="form-label">Attach Service</label>
                                            <select class="form-select" id="attachService" name="attachServiceId"
                                                    required>
                                                <option value="" selected disabled>Select attach service</option>
                                                <c:forEach items="${attachServiceList}" var="attachService">
                                                    <option value="${attachService.getAttachServiceId()}">
                                                            ${attachService.getAttachServiceName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="quantity" class="form-label">Quantity</label>
                                            <input type="number" class="form-control" id="quantity"
                                                   placeholder="Enter quantity" name="quantity" required min="0">
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
