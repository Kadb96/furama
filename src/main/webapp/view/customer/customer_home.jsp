<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/13/2025
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
    <c:import url="/view/layout/library.jsp"/>
    <c:import url="/view/layout/css_style.jsp"/>
</head>
<body>
<c:import url="/view/layout/header.jsp"/>
<c:import url="/view/layout/navbar.jsp"/>
<main class="container py-4">
    <div class="row">
        <c:import url="/view/layout/customer_navbar.jsp"/>
        <div class="col-lg-9">
            <div class="bg-white p-2 shadow-sm rounded">
                <h2>Customer List</h2>
                <form action="/customers" method="get">
                    <div class="row mb-3">
                        <div class="col">
                            <div class="input-group">
                                <input type="hidden" name="action" value="showCustomerByPage">
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
                            <th>Customer Type</th>
                            <th>Name</th>
                            <th>Birthday</th>
                            <th>Gender</th>
                            <th>ID Card</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${customerList}" var="customer">
                            <tr>
                                <td>${customer.getCustomerId()}</td>
                                <td>${customer.getCustomerTypeName()}</td>
                                <td>${customer.getCustomerName()}</td>
                                <td>${customer.getCustomerBirthdayString()}</td>
                                <td>${customer.getCustomerGenderString()}</td>
                                <td>${customer.getCustomerIdCard()}</td>
                                <td>${customer.getCustomerPhone()}</td>
                                <td>${customer.getCustomerEmail()}</td>
                                <td>${customer.getCustomerAddress()}</td>
                                <td>
                                    <button class="btn btn-sm btn-primary me-1" data-bs-toggle="modal"
                                            data-bs-target="#editModal"
                                            onclick="getEditingCustomerInfo(`${customer.getCustomerId()}`,
                                                    `${customer.getCustomerTypeId()}`, `${customer.getCustomerName()}`,
                                                    `${customer.getCustomerBirthdayString()}`,
                                                    `${customer.getCustomerGenderString()}`,
                                                    `${customer.getCustomerIdCard()}`, `${customer.getCustomerPhone()}`,
                                                    `${customer.getCustomerEmail()}`, `${customer.getCustomerAddress()}`)">
                                        Edit
                                    </button>
                                    <button class="btn btn-sm btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#deleteModal"
                                            onclick="getDeletingCustomerInfo(`${customer.getCustomerId()}`)">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <nav aria-label="Page navigation" class="mt-4">
                    <ul class="pagination justify-content-end">
                        <li class="page-item">
                            <a class="page-link" href="/customers?page=1&keyword=${keyword}" aria-label="Next">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:if test="${pageNum > 2}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/customers?page=${pageNum - 2}&keyword=${keyword}">${pageNum - 2}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageNum > 1}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/customers?page=${pageNum - 1}&keyword=${keyword}">${pageNum - 1}</a>
                            </li>
                        </c:if>
                        <li class="page-item active">
                            <a class="page-link"
                               href="/customers?page=${pageNum}&keyword=${keyword}">${pageNum}</a>
                        </li>
                        <c:if test="${pageNum < lastPageNum}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/customers?page=${pageNum + 1}">${pageNum + 1}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageNum < lastPageNum - 1}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/customers?page=${pageNum + 2}">${pageNum + 2}</a>
                            </li>
                        </c:if>
                        <li class="page-item">
                            <a class="page-link" href="/customers?page=${lastPageNum}&keyword=${keyword}"
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

<%--edit modal--%>
<div class="modal fade" id="editModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit Customer</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form id="editForm" action="/customers" method="post">
                    <input type="hidden" name="action" value="updateCustomer">
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerId">Customer ID</label>
                        <input type="text" class="form-control bg-secondary text-white" id="editingCustomerId" name="customerId"
                               readonly>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerTypeId">Customer Type</label>
                        <select class="form-select" name="customerTypeId" id="editingCustomerTypeId">
                            <c:forEach items="${customerTypeList}" var="customerType">
                                <option value="${customerType.getCustomerTypeId()}"
                                        id="option${customerType.getCustomerTypeId()}">
                                        ${customerType.getCustomerTypeName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerName">Name</label>
                        <input type="text" class="form-control" id="editingCustomerName" name="customerName" required
                               maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerBirthday">Birthday</label>
                        <input type="text" class="form-control" id="editingCustomerBirthday" name="customerBirthday"
                               required pattern="^[0-9]{2}/[0-9]{2}/[0-9]{4}$">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerGender">Gender</label>
                        <select class="form-select" id="editingCustomerGender" name="customerGender">
                            <option value="true" id="editingCustomerGenderMale">Male</option>
                            <option value="false" id="editingCustomerGenderFemale">Female</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerIdCard">ID Card</label>
                        <input type="text" class="form-control" id="editingCustomerIdCard" name="customerIdCard"
                               required pattern="[0-9]+" maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerPhone">Phone</label>
                        <input type="tel" class="form-control" id="editingCustomerPhone" name="customerPhone" required
                               pattern="[+][0-9]{1,4}\s?[(]?[0-9]{1,4}[)]?[-\s]?[0-9]{1,10}" maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerEmail">Email</label>
                        <input type="email" class="form-control" id="editingCustomerEmail" name="customerEmail"
                               maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingCustomerAddress">Address</label>
                        <input type="text" class="form-control" id="editingCustomerAddress" name="customerAddress"
                               maxlength="45">
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

<%--delete modal--%>
<div class="modal fade" id="deleteModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirm Delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete this customer? This action cannot be undone.</p>
            </div>
            <div class="modal-footer">
                <form action="/customers" method="post">
                    <input type="hidden" name="action" value="deleteCustomer">
                    <input type="hidden" name="customerId" id="deletingCustomerId">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
<c:import url="/view/layout/footer.jsp"/>
<script>
    function getDeletingCustomerInfo(deletingCustomerID) {
        document.getElementById("deletingCustomerId").value = deletingCustomerID;
    }

    function getEditingCustomerInfo(editingCustomerId, editingCustomerTypeId, editingCustomerName,
                                    editingCustomerBirthday, editingCustomerGender, editingCustomerIdCard,
                                    editingCustomerPhone, editingCustomerEmail, editingCustomerAddress) {
        document.getElementById("editingCustomerId").value = editingCustomerId;
        let selectOption = "option" + editingCustomerTypeId;
        document.getElementById(selectOption).selected = true;
        document.getElementById("editingCustomerName").value = editingCustomerName;
        document.getElementById("editingCustomerBirthday").value = editingCustomerBirthday;
        if (editingCustomerGender == "Male") {
            document.getElementById("editingCustomerGenderMale").selected = true;
        } else {
            document.getElementById("editingCustomerGenderFemale").selected = true;
        }
        document.getElementById("editingCustomerIdCard").value = editingCustomerIdCard;
        document.getElementById("editingCustomerPhone").value = editingCustomerPhone;
        document.getElementById("editingCustomerEmail").value = editingCustomerEmail;
        document.getElementById("editingCustomerAddress").value = editingCustomerAddress;
    }
</script>
</body>
</html>
