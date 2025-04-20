package com.codegym.furama.controller;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.CustomerType;
import com.codegym.furama.service.EmployeeService;
import com.codegym.furama.service.IEmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "EmployeeController", value = "/employees")
public class EmployeeController extends HttpServlet {
    //ket noi EmployeeService
    IEmployeeService employeeService = new EmployeeService();

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

    private void showEmployeeByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay page hien tai tu req
        String page = req.getParameter("page");
        int pageNum = 1;
        if (page != null) {
            pageNum = Integer.parseInt(page);
        }

        //lay employee list tu CustomerService
        List<EmployeeDto> employeeFullList = employeeService.showAll();

        //lay employee list theo trang tu CustomerService
        List<EmployeeDto> employeeList = employeeService.showByPage(pageNum);

        //tinh trang cuoi
        int lastPageNum = pageNum;
        if (employeeFullList.isEmpty()) {
            lastPageNum = 1;
        } else if (employeeFullList.size() % 5 == 0) {
            lastPageNum = employeeFullList.size() / 5;
        } else {
            lastPageNum = ((employeeFullList.size() - (employeeFullList.size() % 5)) / 5) + 1;
        }

        //tao attribute cho jsp
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("lastPageNum", lastPageNum);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/employee/employee_home.jsp").forward(req, resp);
    }
}
