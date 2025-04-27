package com.codegym.furama.controller;

import com.codegym.furama.model.*;
import com.codegym.furama.service.employee_service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "EmployeeAddFormController", value = "/employee_add_forms")
public class EmployeeAddFormController extends HttpServlet {
    //ket noi EmployeeService
    IEmployeeService employeeService = new EmployeeService();

    //ket noi PositionService
    IPositionService positionService = new PositionService();

    //ket noi EducationDegreeService
    IEducationDegreeService educationDegreeService = new EducationDegreeService();

    //ket noi Division Service
    IDivisionService divisionService = new DivisionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay danh sach Position, EducationDgree, Division
        List<Position> positionList = positionService.showAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.showAll();
        List<Division> divisionList = divisionService.showAll();

        //tao attribute cho jsp
        req.setAttribute("positionList", positionList);
        req.setAttribute("educationDegreeList", educationDegreeList);
        req.setAttribute("divisionList", divisionList);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/employee/employee_add_form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay du lieu action
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        //function cho moi action
        switch (action) {
            case "addNewEmployee":
                addNewEmployee(req, resp);
                break;
        }
    }

    private void addNewEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //lay thong tin Employee
        String employeeName = req.getParameter("employeeName");
        String employeeBirthdayString = req.getParameter("employeeBirthday");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate employeeBirthday = LocalDate.parse(employeeBirthdayString, formatter);
        String employeeIdCard = req.getParameter("employeeIdCard");
        Double employeeSalary = Double.parseDouble(req.getParameter("employeeSalary"));
        String employeePhone = req.getParameter("employeePhone");
        String employeeEmail = req.getParameter("employeeEmail");
        String employeeAddress = req.getParameter("employeeAddress");
        int positionId = Integer.parseInt(req.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(req.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(req.getParameter("divisionId"));
        String username = req.getParameter("username");

        //tao Employee moi
        Employee employee = new Employee();

        if (username == null) {
            employee = new Employee(employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone,
                    employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);
        } else {
            employee = new Employee(employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone,
                    employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username);

        }
        employeeService.add(employee);

        // chuyen tiep sang customer home
        resp.sendRedirect(req.getContextPath() + "/employees");
    }
}
