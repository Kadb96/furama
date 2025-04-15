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
                                            data-bs-target="#editModal">
                                        Edit
                                    </button>
                                    <button class="btn btn-sm btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#deleteModal" onclick="getDeletingCustomerInfo(`${customer.getCustomerId()}`)">
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
                            <a class="page-link" href="/customers?page=1" aria-label="Next">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:if test="${pageNum > 1}">
                            <li class="page-item"><a class="page-link"
                                                     href="/customers?page=${pageNum - 1}">${pageNum - 1}</a></li>
                        </c:if>
                        <li class="page-item active"><a class="page-link"
                                                        href="/customers?page=${pageNum}">${pageNum}</a></li>
                        <c:if test="${pageNum < lastPageNum}">
                            <li class="page-item"><a class="page-link"
                                                     href="/customers?page=${pageNum + 1}">${pageNum + 1}</a></li>
                        </c:if>
                        <li class="page-item">
                            <a class="page-link" href="/customers?page=${lastPageNum}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</main>

<div class="modal fade" id="editModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit Customer</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label class="form-label">Customer Type</label>
                        <select class="form-select">
                            <option value="Premium">Premium</option>
                            <option value="Regular">Regular</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" class="form-control" value="Jane Smith">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Birthday</label>
                        <input type="date" class="form-control" value="1990-05-15">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Gender</label>
                        <select class="form-select">
                            <option value="Female">Female</option>
                            <option value="Male">Male</option>
                            <option value="Other">Other</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">ID Card</label>
                        <input type="text" class="form-control" value="ID123456">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Phone</label>
                        <input type="tel" class="form-control" value="555-0123">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" class="form-control" value="jane@email.com">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Address</label>
                        <textarea class="form-control">123 Main St</textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">Save Changes</button>
            </div>
        </div>
    </div>
</div>

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
        document.getElementById("deletingCustomerId").value = deletingCustomerID
    }
</script>
</body>
</html>
