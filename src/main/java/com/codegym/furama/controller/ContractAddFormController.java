package com.codegym.furama.controller;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.dto.ServiceDto;
import com.codegym.furama.model.Contract;
import com.codegym.furama.service.contract_service.ContractService;
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

@WebServlet(name = "ContractAddFormController", value = "/contract_add_forms")
public class ContractAddFormController extends HttpServlet {
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
        //lay danh sach employee
        List<EmployeeDto> employeeList = employeeService.showAll();

        //lay danh sach customer
        List<CustomerDto> customerList = customerService.showAll();

        //lay danh sach service
        List<ServiceDto> serviceList = serviceService.showAll();

        //tao attribute cho jsp
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("customerList", customerList);
        req.setAttribute("serviceList", serviceList);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/contract/contract_add_form.jsp").forward(req, resp);
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
            case "addNewContract":
                addNewContract(req, resp);
                break;
        }
    }

    private void addNewContract(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //lay thong tin Contract
        String contractStartDateString = req.getParameter("contractStartDate");
        String contractEndDateString = req.getParameter("contractEndDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate contractStartDate = LocalDate.parse(contractStartDateString, formatter);
        LocalDate contractEndDate = LocalDate.parse(contractEndDateString, formatter);
        double contractDeposit = Double.parseDouble(req.getParameter("contractDeposit"));
        double contractTotalMoney = Double.parseDouble(req.getParameter("contractTotalMoney"));
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        int serviceId = Integer.parseInt(req.getParameter("serviceId"));

        //tao contract moi
        Contract contract = new Contract(contractStartDate, contractEndDate, contractDeposit, contractTotalMoney,
                employeeId, customerId, serviceId);
        contractService.add(contract);

        // chuyen tiep sang customer home
        resp.sendRedirect(req.getContextPath() + "/contracts");
    }
}
