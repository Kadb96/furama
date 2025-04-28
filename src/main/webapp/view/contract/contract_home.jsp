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
                            <th>Detail</th>
                            <th>ID</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Deposit</th>
                            <th>Total Money</th>
                            <th>Employee</th>
                            <th>Customer</th>
                            <th>Service</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${contractList}" var="contract" varStatus="loop">
                            <tr>
                                <td>
                                    <button class="btn btn-sm btn-info" data-bs-toggle="collapse"
                                            data-bs-target="#contracts${loop.index}">
                                        Detail
                                    </button>
                                </td>
                                <td>${contract.getContractId()}</td>
                                <td>${contract.getContractStartDateString()}</td>
                                <td>${contract.getContractEndDateString()}</td>
                                <td>${contract.getContractDepositString()}</td>
                                <td>${contract.getContractTotalMoneyString()}</td>
                                <td>${contract.getEmployeeName()}</td>
                                <td>${contract.getCustomerName()}</td>
                                <td>${contract.getServiceName()}</td>
                                <td>
                                    <form action="/contract_detail_add_forms" method="post" class="my-0">
                                        <input type="hidden" name="contractIdToDetail"
                                               value="${contract.getContractId()}">
                                        <button class="btn btn-sm btn-success" type="submit">
                                            Add Attach Service
                                        </button>
                                    </form>
                                    <button class="btn btn-sm btn-primary me-1"
                                            data-bs-toggle="modal"
                                            data-bs-target="#editContractModal"
                                            onclick="getEditingContractInfo(`${contract.getContractId()}`,
                                                    `${contract.getContractStartDateString()}`,
                                                    `${contract.getContractEndDateString()}`,
                                                    `${contract.getContractDeposit()}`,
                                                    `${contract.getContractTotalMoney()}`,
                                                    `${contract.getEmployeeId()}`, `${contract.getCustomerId()}`,
                                                    `${contract.getServiceId()}`)">
                                        Edit
                                    </button>
                                    <button class="btn btn-sm btn-danger"
                                            data-bs-toggle="modal"
                                            data-bs-target="#deleteContractModal">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="11" class="p-0">
                                    <div id="contracts${loop.index}" class="collapse">
                                        <div class="bg-light p-3">
                                            <h6 class="mb-3">Attach Services</h6>
                                            <div class="table-responsive">
                                                <table class="table table-sm">
                                                    <thead>
                                                    <tr>
                                                        <th>Contract Detail ID</th>
                                                        <th>Contract Id</th>
                                                        <th>Attach Service ID</th>
                                                        <th>Attach Service Name</th>
                                                        <th>Quantity</th>
                                                        <th>Action</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${contractDetailList}" var="contractDetail">
                                                        <c:if test="${contract.getContractId() == contractDetail.getContractId()}">
                                                            <tr>
                                                                <td>${contractDetail.getContractDetailId()}</td>
                                                                <td>${contractDetail.getContractId()}</td>
                                                                <td>${contractDetail.getAttachServiceId()}</td>
                                                                <td>${contractDetail.getAttachServiceName()}</td>
                                                                <td>${contractDetail.getQuantity()}</td>
                                                                <td>
                                                                    <button class="btn btn-sm btn-primary me-1"
                                                                            data-bs-toggle="modal"
                                                                            data-bs-target="#editModal">
                                                                        Edit
                                                                    </button>
                                                                    <button class="btn btn-sm btn-danger"
                                                                            data-bs-toggle="modal"
                                                                            data-bs-target="#deleteModal">
                                                                        Delete
                                                                    </button>
                                                                </td>
                                                            </tr>
                                                        </c:if>
                                                    </c:forEach>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </td>
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

<%--edit contract modal--%>
<div class="modal fade" id="editContractModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit Contract</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form id="editForm" action="/contracts" method="post">
                    <input type="hidden" name="action" value="updateContract">
                    <div class="mb-3">
                        <label class="form-label" for="editingContractId">Contract ID</label>
                        <input type="text" class="form-control" id="editingContractId" name="contractId" readonly>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingContractStartDate">Start Date</label>
                        <input type="text" class="form-control" id="editingContractStartDate" name="contractStartDate"
                               required pattern="^[0-9]{2}/[0-9]{2}/[0-9]{4}$">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingContractEndDate">End Date</label>
                        <input type="text" class="form-control" id="editingContractEndDate" name="contractEndDate"
                               required pattern="^[0-9]{2}/[0-9]{2}/[0-9]{4}$">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingContractDeposit">Deposit</label>
                        <input type="number" class="form-control" id="editingContractDeposit" name="contractDeposit"
                               required pattern="[0-9]+" maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingContractTotalMoney">Total Money</label>
                        <input type="number" class="form-control" id="editingContractTotalMoney" name="contractTotalMoney"
                               required pattern="[0-9]+" maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingEmployeeId">Employee</label>
                        <select class="form-select" name="employeeId" id="editingEmployeeId">
                            <c:forEach items="${employeeList}" var="employee">
                                <option value="${employee.getEmployeeId()}"
                                        id="optionEmployee${employee.getEmployeeId()}">
                                        ${employee.getEmployeeName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerId">Customer</label>
                        <select class="form-select" name="customerId" id="editingCustomerId">
                            <c:forEach items="${customerList}" var="customer">
                                <option value="${customer.getCustomerId()}"
                                        id="optionCustomer${customer.getCustomerId()}">
                                        ${customer.getCustomerName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingServiceId">Service</label>
                        <select class="form-select" name="serviceId" id="editingServiceId">
                            <c:forEach items="${serviceList}" var="service">
                                <option value="${service.getServiceId()}"
                                        id="optionService${service.getServiceId()}">
                                        ${service.getServiceName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-primary" form="editForm">Save Changes</button>
            </div>
        </div>
    </div>
</div>
<script>
    function getEditingContractInfo(editingContractId, editingContractStartDate, editingContractEndDate,
                                    editingContractDeposit, editingContractTotalMoney, editingEmployeeId,
                                    editingCustomerId, editingServiceId) {
        document.getElementById("editingContractId").value = editingContractId;
        document.getElementById("editingContractStartDate").value = editingContractStartDate;
        document.getElementById("editingContractEndDate").value = editingContractEndDate;
        document.getElementById("editingContractDeposit").value = editingContractDeposit;
        document.getElementById("editingContractTotalMoney").value = editingContractTotalMoney;
        document.getElementById("optionEmployee" + editingEmployeeId).selected = true;
        document.getElementById("optionCustomer" + editingCustomerId).selected = true;
        document.getElementById("optionService" + editingServiceId).selected = true;
    }
</script>
</body>
</html>
