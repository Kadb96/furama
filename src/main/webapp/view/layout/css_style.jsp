<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/16/2025
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
