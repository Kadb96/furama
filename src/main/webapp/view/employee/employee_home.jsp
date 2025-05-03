<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/17/2025
  Time: 1:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
    <c:import url="/view/layout/library.jsp"/>
    <c:import url="/view/layout/css_style.jsp"/>
</head>
<body>
<c:import url="/view/layout/header.jsp"/>
<c:import url="/view/layout/navbar.jsp"/>
<main class="container py-4">
    <div class="row">
        <c:import url="/view/layout/employee_navbar.jsp"/>
        <div class="col-lg-9">
            <div class="bg-white p-2 shadow-sm rounded">
                <h2>Employee List</h2>
                <form action="/employees" method="get">
                    <div class="row mb-3">
                        <div class="col">
                            <div class="input-group">
                                <input type="hidden" name="action" value="showEmployeeByPage">
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
                            <th>Birthday</th>
                            <th>ID Card</th>
                            <th>Salary</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Position</th>
                            <th>Education Degree</th>
                            <th>Division</th>
                            <th>Username</th>
                            <th>Action</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${employeeList}" var="employee">
                            <tr>
                                <td>${employee.getEmployeeId()}</td>
                                <td>${employee.getEmployeeName()}</td>
                                <td>${employee.getEmployeeBirthdayString()}</td>
                                <td>${employee.getEmployeeIdCard()}</td>
                                <td>${employee.getEmployeeSalaryString()}</td>
                                <td>${employee.getEmployeePhone()}</td>
                                <td>${employee.getEmployeeEmail()}</td>
                                <td>${employee.getEmployeeAddress()}</td>
                                <td>${employee.getPositionName()}</td>
                                <td>${employee.getEducationDegreeName()}</td>
                                <td>${employee.getDivisionName()}</td>
                                <td>${employee.getUsername()}</td>
                                <td>
                                    <button class="btn btn-sm btn-primary me-1" data-bs-toggle="modal"
                                            data-bs-target="#editModal"
                                            onclick="getEditingEmployeeInfo(`${employee.getEmployeeId()}`,
                                                    `${employee.getEmployeeName()}`,
                                                    `${employee.getEmployeeBirthdayString()}`,
                                                    `${employee.getEmployeeIdCard()}`, `${employee.getEmployeeSalary()}`,
                                                    `${employee.getEmployeePhone()}`, `${employee.getEmployeeEmail()}`,
                                                    `${employee.getEmployeeAddress()}`, '${employee.getPositionId()}',
                                                    `${employee.getEducationDegreeId()}`, `${employee.getDivisionId()}`,
                                                    `${employee.getUsername()}`)">
                                        Edit
                                    </button>
                                    <button class="btn btn-sm btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#deleteModal"
                                            onclick="getDeletingEmployeeInfo(`${employee.getEmployeeId()}`)">
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
                            <a class="page-link" href="/employees?page=1&keyword=${keyword}" aria-label="Next">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:if test="${pageNum > 2}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/employees?page=${pageNum - 2}&keyword=${keyword}">${pageNum - 2}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageNum > 1}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/employees?page=${pageNum - 1}&keyword=${keyword}">${pageNum - 1}</a>
                            </li>
                        </c:if>
                        <li class="page-item active">
                            <a class="page-link"
                               href="/employees?page=${pageNum}&keyword=${keyword}">${pageNum}</a>
                        </li>
                        <c:if test="${pageNum < lastPageNum}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/employees?page=${pageNum + 1}&keyword=${keyword}">${pageNum + 1}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageNum < lastPageNum - 1}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/employees?page=${pageNum + 2}&keyword=${keyword}">${pageNum + 2}</a>
                            </li>
                        </c:if>
                        <li class="page-item">
                            <a class="page-link" href="/employees?page=${lastPageNum}&keyword=${keyword}" aria-label="Next">
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
                <h5 class="modal-title">Edit Employee</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form id="editForm" action="/employees" method="post">
                    <input type="hidden" name="action" value="updateEmployee">
                    <div class="mb-3">
                        <label class="form-label" for="editingEmployeeId">Employee ID</label>
                        <input type="text" class="form-control" id="editingEmployeeId" name="employeeId" readonly>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingEmployeeName">Name</label>
                        <input type="text" class="form-control" id="editingEmployeeName" name="employeeName" required
                               maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label for="editingEmployeeBirthday" class="form-label">Birthday</label>
                        <div class="input-group">
                            <input type="text" class="form-control datepicker" id="editingEmployeeBirthday"
                                   name="employeeBirthday" placeholder="dd/mm/yyyy" required
                                   pattern="^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$"
                                   aria-label="Date">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingEmployeeIdCard">ID Card</label>
                        <input type="text" class="form-control" id="editingEmployeeIdCard" name="employeeIdCard"
                               required pattern="[0-9]+" maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingEmployeeSalary">Salary</label>
                        <input type="number" class="form-control" id="editingEmployeeSalary" name="employeeSalary"
                               required pattern="[0-9]+" maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingEmployeePhone">Phone</label>
                        <input type="tel" class="form-control" id="editingEmployeePhone" name="employeePhone" required
                               pattern="[+][0-9]{1,4}\s?[(]?[0-9]{1,4}[)]?[-\s]?[0-9]{1,10}" maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingEmployeeEmail">Email</label>
                        <input type="email" class="form-control" id="editingEmployeeEmail" name="employeeEmail"
                               maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingEmployeeAddress">Address</label>
                        <input type="text" class="form-control" id="editingEmployeeAddress" name="employeeAddress"
                               maxlength="45">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingPositionId">Position</label>
                        <select class="form-select" name="positionId" id="editingPositionId">
                            <c:forEach items="${positionList}" var="position">
                                <option value="${position.getPositionId()}"
                                        id="optionPosition${position.getPositionId()}">
                                        ${position.getPositionName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingEducationDegreeId">Education Degree</label>
                        <select class="form-select" name="educationDegreeId" id="editingEducationDegreeId">
                            <c:forEach items="${educationDegreeList}" var="educationDegree">
                                <option value="${educationDegree.getEducationDegreeId()}"
                                        id="optionEducationDegree${educationDegree.getEducationDegreeId()}">
                                        ${educationDegree.getEducationDegreeName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingDivisionId">Division</label>
                        <select class="form-select" name="divisionId" id="editingDivisionId">
                            <c:forEach items="${divisionList}" var="division">
                                <option value="${division.getDivisionId()}"
                                        id="optionDivision${division.getDivisionId()}">
                                        ${division.getDivisionName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="editingUsername">Username</label>
                        <input type="text" class="form-control" id="editingUsername" name="username"
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
                <p>Are you sure you want to delete this employee? This action cannot be undone.</p>
            </div>
            <div class="modal-footer">
                <form action="/employees" method="post">
                    <input type="hidden" name="action" value="deleteEmployee">
                    <input type="hidden" name="employeeId" id="deletingEmployeeId">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
<c:import url="/view/layout/footer.jsp"/>
<script>
    function getDeletingEmployeeInfo(deletingEmployeeId) {
        document.getElementById("deletingEmployeeId").value = deletingEmployeeId;
    }

    function getEditingEmployeeInfo(editingEmployeeId, editingEmployeeName, editingEmployeeBirthday,
                                    editingEmployeeIdCard, editingEmployeeSalary, editingEmployeePhone,
                                    editingEmployeeEmail, editingEmployeeAddress, editingPositionId,
                                    editingEducationDegreeId, editingDivisionId, editingUsername) {
        document.getElementById("editingEmployeeId").value = editingEmployeeId;
        document.getElementById("editingEmployeeName").value = editingEmployeeName;
        document.getElementById("editingEmployeeBirthday").value = editingEmployeeBirthday;
        document.getElementById("editingEmployeeIdCard").value = editingEmployeeIdCard;
        document.getElementById("editingEmployeeSalary").value = editingEmployeeSalary;
        document.getElementById("editingEmployeePhone").value = editingEmployeePhone;
        document.getElementById("editingEmployeeEmail").value = editingEmployeeEmail;
        document.getElementById("editingEmployeeAddress").value = editingEmployeeAddress;
        let selectOptionPosition = "optionPosition" + editingPositionId;
        document.getElementById(selectOptionPosition).selected = true;
        let selectOptionEducationDegree = "optionEducationDegree" + editingEducationDegreeId;
        document.getElementById(selectOptionEducationDegree.selected = true);
        let selectOptionDivision = "optionDivision" + editingDivisionId;
        document.getElementById(selectOptionDivision).selected = true;
        document.getElementById("editingUsername").value = editingUsername;
    }
</script>
<script>
    $(document).ready(function(){
        $('#editingEmployeeBirthday').datepicker({
            format: 'dd/mm/yyyy',
            autoclose: true,
            todayHighlight: true,
            orientation: 'bottom auto',
            templates: {
                leftArrow: '&laquo;',
                rightArrow: '&raquo;'
            }
        });
    });
</script>
</body>
</html>
