package com.codegym.furama.controller;

import com.codegym.furama.dto.*;
import com.codegym.furama.model.Contract;
import com.codegym.furama.service.contract_service.ContractDetailService;
import com.codegym.furama.service.contract_service.ContractService;
import com.codegym.furama.service.contract_service.IContractDetailService;
import com.codegym.furama.service.contract_service.IContractService;
import com.codegym.furama.service.customer_repository.CustomerService;
import com.codegym.furama.service.customer_repository.ICustomerService;
import com.codegym.furama.service.employee_service.EmployeeService;
import com.codegym.furama.service.employee_service.IEmployeeService;
import com.codegym.furama.service.service_service.IServiceService;
import com.codegym.furama.service.service_service.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "ContractController", value = "/contracts")
public class ContractController extends HttpServlet {
    //ket noi ContractService
    private IContractService contractService = new ContractService();

    //ket noi EmployeeService
    private IEmployeeService employeeService = new EmployeeService();

    //ket noi CustomerService
    private ICustomerService customerService = new CustomerService();

    //ket noi ServiceService
    private IServiceService serviceService = new ServiceService();

    //ket noi ContractDetailService
    private IContractDetailService contractDetailService = new ContractDetailService();

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay du lieu action
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        //function cho moi action
        switch (action) {
            case "updateContract":
                updateContract(req, resp);
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

        //lay contractDetailList
        List<ContractDetailDto> contractDetailList = contractDetailService.showAll();

        //tao attribute cho jsp
        req.setAttribute("contractList", contractList);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("customerList", customerList);
        req.setAttribute("serviceList", serviceList);
        req.setAttribute("contractDetailList", contractDetailList);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/contract/contract_home.jsp").forward(req, resp);
    }


    private void updateContract(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin contract can chinh sua
        int contractId = Integer.parseInt(req.getParameter("contractId"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String contractStartDateString = req.getParameter("contractStartDate");
        String contractEndDateString = req.getParameter("contractEndDate");
        LocalDate contractStartDate = LocalDate.parse(contractStartDateString, formatter);
        LocalDate contractEndDate = LocalDate.parse(contractEndDateString, formatter);
        double contractDeposit = Double.parseDouble(req.getParameter("contractDeposit"));
        double contractTotalMoney = Double.parseDouble(req.getParameter("contractTotalMoney"));
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        int serviceId = Integer.parseInt(req.getParameter("serviceId"));

        //update thong tin moi cua khach hang
        Contract contract = new Contract(contractStartDate, contractEndDate, contractDeposit,
                contractTotalMoney, employeeId, customerId, serviceId);
        contractService.update(contractId, contract);

        //chuyen tiep toi jsp
        showContractByPage(req, resp);
    }
}
