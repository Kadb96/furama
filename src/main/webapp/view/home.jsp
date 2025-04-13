<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/11/2025
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Homepage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <style>
        :root {
            --primary: #0d6efd;
            --primary-foreground: #ffffff;
            --secondary: #6c757d;
            --secondary-foreground: #ffffff;
            --accent: #e9ecef;
            --accent-foreground: #212529;
            --background: #f8f9fa;
            --foreground: #212529;
            --card: #ffffff;
            --card-foreground: #212529;
            --border: #dee2e6;
            --input: #ced4da;
            --ring: rgba(13, 110, 253, 0.25);
        }

        body {
            background-color: var(--background);
            color: var(--foreground);
        }

        .navbar {
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .navbar-nav .nav-link {
            transition: color 0.3s ease;
        }

        .navbar-nav .nav-link:hover {
            color: var(--primary);
        }

        .list-group-item {
            border-color: var(--border);
            transition: all 0.3s ease;
        }

        .list-group-item:hover {
            background-color: var(--accent);
            color: var(--accent-foreground);
        }

        .list-group-item.active {
            background-color: var(--primary);
            border-color: var(--primary);
            color: var(--primary-foreground);
        }

        .input-group .form-control:focus {
            border-color: var(--primary);
            box-shadow: 0 0 0 0.25rem var(--ring);
        }

        .social-links a {
            transition: opacity 0.3s ease;
        }

        .social-links a:hover {
            opacity: 0.8;
        }

        .badge {
            font-weight: 500;
            padding: 0.5em 1em;
        }

        .shadow-sm {
            box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075);
        }
    </style>
</head>
<body>
<c:import url="../view/layout/header.jsp"/>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Employee</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Customer</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Service</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Contract</a></li>
            </ul>
            <form class="d-flex">
                <div class="input-group">
                    <input type="search" class="form-control" placeholder="Search...">
                    <button class="btn btn-outline-primary" type="submit"><i class="bi bi-search"></i></button>
                </div>
            </form>
        </div>
    </div>
</nav>
<main class="container py-4">
    <div class="row">
        <div class="col-lg-3">
            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-action active">Item One</a>
                <a href="#" class="list-group-item list-group-item-action">Item Two</a>
                <a href="#" class="list-group-item list-group-item-action">Item Three</a>
            </div>
        </div>
        <div class="col-lg-9">
            <div class="bg-white p-4 shadow-sm rounded">
                <h2>Content</h2>
            </div>
        </div>
    </div>
</main>
<footer class="bg-dark text-light py-4 mt-4">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h5>Footer</h5>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
