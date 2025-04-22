package com.codegym.furama.controller;

import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.Division;
import com.codegym.furama.model.EducationDegree;
import com.codegym.furama.model.Employee;
import com.codegym.furama.model.Position;
import com.codegym.furama.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "EmployeeController", value = "/employees")
public class EmployeeController extends HttpServlet {
    //ket noi EmployeeService
    IEmployeeService employeeService = new EmployeeService();

    //ket noi PositionService
    IPositionService positionService = new PositionService();

    //ket noi EducationDegree
    IEducationDegreeService educationDegreeService = new EducationDegreeService();

    //ket noi Divisiom
    IDivisionService divisionService = new DivisionService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay du lieu action
        String action = req.getParameter("action");
        if (action == null) {
            action = "showEmployeeByPage";
        }

        //function cho moi action
        switch (action) {
            case "showEmployeeByPage":
                showEmployeeByPage(req, resp);
                break;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay du lieu action
        String action = req.getParameter("action");
        if (action == null) {
            action = "showEmployeeByPage";
        }

        //function cho moi action
        switch (action) {
            case "deleteEmployee":
                deleteEmployee(req, resp);
                break;
            case "updateEmployee":
                updateEmployee(req, resp);
                break;
        }
    }

    private void showEmployeeByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin keyword de tim kiem
        String keyword = req.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }

        //lay employee list tu CustomerService
        List<EmployeeDto> employeeFullList = employeeService.searchAll(keyword);

        //tinh trang cuoi
        int lastPageNum;
        if (employeeFullList.isEmpty()) {
            lastPageNum = 1;
        } else if (employeeFullList.size() % 5 == 0) {
            lastPageNum = employeeFullList.size() / 5;
        } else {
            lastPageNum = ((employeeFullList.size() - (employeeFullList.size() % 5)) / 5) + 1;
        }

        //lay page hien tai tu req
        String page = req.getParameter("page");
        int pageNum = 1;
        if (page != null) {
            pageNum = Integer.parseInt(page);
        }

        //gioi han lai trang
        if (pageNum > lastPageNum) {
            pageNum = lastPageNum;
        }

        //lay employee list theo trang tu EmployeeService
        List<EmployeeDto> employeeList = employeeService.searchByPage(pageNum, keyword);

        //lay postionList
        List<Position> positionList = positionService.showAll();

        //lay educationDegreeList
        List<EducationDegree> educationDegreeList = educationDegreeService.showAll();

        //lay division
        List<Division> divisionList = divisionService.showAll();

        //tao attribute cho jsp
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("positionList", positionList);
        req.setAttribute("educationDegreeList", educationDegreeList);
        req.setAttribute("divisionList", divisionList);
        req.setAttribute("keyword", keyword);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/employee/employee_home.jsp").forward(req, resp);
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin employeeId cua nhan vien can xoa
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));

        //xoa employee khoi danh sach
        employeeService.delete(employeeId);

        //chuyen tiep toi jsp
        showEmployeeByPage(req, resp);
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin employeeId cua nhan vien can chinh sua
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));

        //lay thong tin can chinh sua
        String employeeName = req.getParameter("employeeName");
        String employeeBirthdayString = req.getParameter("employeeBirthday");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate employeeBirthday = LocalDate.parse(employeeBirthdayString, formatter);
        String employeeIdCard = req.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(req.getParameter("employeeSalary"));
        String employeePhone = req.getParameter("employeePhone");
        String employeeEmail = req.getParameter("employeeEmail");
        String employeeAddress = req.getParameter("employeeAddress");
        int positionId = Integer.parseInt(req.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(req.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(req.getParameter("divisionId"));
        String username = req.getParameter("username");

        //update thong tin moi cua nhan vien
        Employee employee = new Employee(employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone,
                employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username);
        employeeService.update(employeeId, employee);

        //chuyen tiep toi jsp
        showEmployeeByPage(req, resp);
    }
}
