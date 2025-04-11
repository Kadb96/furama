<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/12/2025
  Time: 1:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom py-3">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/">My Profile</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/owners?action=showRestaurant">My Restaurant</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link bi bi-box-arrow-right me-2" href="/orders?action=showOrder">My Orders</a>
      </li>
    </ul>
    <button class="btn btn-outline-danger ms-auto py-3">
      <a class="bi bi-box-arrow-right me-2 py-3" href="/owners?action=logout"></a>Logout
    </button>
  </div>
</nav>
