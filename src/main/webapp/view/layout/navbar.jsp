<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/15/2025
  Time: 1:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link active" href="/home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="/employees">Employee</a></li>
                <li class="nav-item"><a class="nav-link" href="/customers">Customer</a></li>
                <li class="nav-item"><a class="nav-link" href="/services">Service</a></li>
                <li class="nav-item"><a class="nav-link" href="/contracts">Contract</a></li>
            </ul>
            <form class="d-flex">
                <div class="input-group">
                    <input type="search" class="form-control" placeholder="Search...">
                    <button class="btn btn-outline-primary" type="submit">Search</button>
                </div>
            </form>
        </div>
    </div>
</nav>
