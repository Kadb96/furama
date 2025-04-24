package com.codegym.furama.controller;

import com.codegym.furama.dto.ContractDto;
import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.dto.ServiceDto;
import com.codegym.furama.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "ContractController", value = "/contracts")
public class ContractController extends HttpServlet {
    //ket noi ContractService
    private IContractService contractService = new ContractService();

    //ket noi EmployeeService
    private IEmployeeService employeeService = new EmployeeService();

    //ket noi CustomerService
    private ICustomerService customerService = new CustomerService();

    //ket noi ServiceService
    private IServiceService serviceService = new ServiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay du lieu action
        String action = req.getParameter("action");
        if (action == null) {
            action = "showContractByPage";
        }

        //function cho moi action
        switch (action) {
            case "showContractByPage":
                showContractByPage(req, resp);
                break;
        }
    }

    private void showContractByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay contract list tu ContractService
        List<ContractDto> contractFullList = contractService.showAll();

        //tinh trang cuoi
        int lastPageNum;
        if (contractFullList.isEmpty()) {
            lastPageNum = 1;
        } else if (contractFullList.size() % 5 == 0) {
            lastPageNum = contractFullList.size() / 5;
        } else {
            lastPageNum = ((contractFullList.size() - (contractFullList.size() % 5)) / 5) + 1;
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

        //lay contract list theo trang tu ContractService
        List<ContractDto> contractList = contractService.showByPage(pageNum);

        //lay employeeList
        List<EmployeeDto> employeeList = employeeService.showAll();

        //lay customerList
        List<CustomerDto> customerList = customerService.showAll();

        //Lay serviceList
        List<ServiceDto> serviceList = serviceService.showAll();

        //tao attribute cho jsp
        req.setAttribute("contractList", contractList);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("customerList", customerList);
        req.setAttribute("serviceList", serviceList);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/contract/contract_home.jsp").forward(req, resp);
    }
}
