package com.codegym.furama.controller;

import com.codegym.furama.model.Customer;
import com.codegym.furama.model.CustomerType;
import com.codegym.furama.service.CustomerService;
import com.codegym.furama.service.CustomerTypeService;
import com.codegym.furama.service.ICustomerService;
import com.codegym.furama.service.ICustomerTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "CustomerAddForm", value = "/customer_add_forms")
public class CustomerAddFormController extends HttpServlet {
    //ket noi CustomerTypeService
    ICustomerTypeService customerTypeService = new CustomerTypeService();
    //ket noi CustomerService
    ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay danh sach Customer Type
        List<CustomerType> customerTypeList = customerTypeService.showAll();

        //tao attribute cho jsp
        req.setAttribute("customerTypeList", customerTypeList);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/customer/customer_add_form.jsp").forward(req, resp);
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
            case "addNewCustomer":
                addNewCustomer(req, resp);
                break;
        }
    }

    private void addNewCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin khach hang
        int customerTypeId = Integer.parseInt(req.getParameter("customerTypeId"));
        String customerName = req.getParameter("customerName");
        String customerBirthdayString = req.getParameter("customerBirthday");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate customerBirthday = LocalDate.parse(customerBirthdayString, formatter);
        boolean customerGender = Boolean.parseBoolean(req.getParameter("customerGender"));
        String customerIdCard = req.getParameter("customerIdCard");
        String customerPhone = req.getParameter("customerPhone");
        String customerEmail = req.getParameter("customerEmail");
        String customerAddress = req.getParameter("customerAddress");

        //tao khach hang moi
        Customer customer = new Customer(customerTypeId, customerName, customerBirthday, customerGender, customerIdCard,
                customerPhone, customerEmail, customerAddress);
        customerService.add(customer);

        // chuyen tiep sang customer home
        resp.sendRedirect(req.getContextPath() + "/customers");
    }
}
