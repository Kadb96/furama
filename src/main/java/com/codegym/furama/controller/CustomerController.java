package com.codegym.furama.controller;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.Customer;
import com.codegym.furama.model.CustomerType;
import com.codegym.furama.service.customer_repository.CustomerService;
import com.codegym.furama.service.customer_repository.CustomerTypeService;
import com.codegym.furama.service.customer_repository.ICustomerService;
import com.codegym.furama.service.customer_repository.ICustomerTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/customers")
public class CustomerController extends HttpServlet {
    //ket noi CustomerService
    ICustomerService customerService = new CustomerService();

    //ket noi CustomerTypeService
    ICustomerTypeService customerTypeService = new CustomerTypeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay du lieu action
        String action = req.getParameter("action");
        if (action == null) {
            action = "showCustomerByPage";
        }

        //function cho moi action
        switch (action) {
            case "showCustomerByPage":
                showCustomerByPage(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay du lieu action
        String action = req.getParameter("action");
        if (action == null) {
            action = "showCustomerByPage";
        }

        //function cho moi action
        switch (action) {
            case "deleteCustomer":
                deleteCustomer(req, resp);
                break;
            case "updateCustomer":
                updateCustomer(req, resp);
                break;
        }
    }

    private void showCustomerByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin keyword de tim kiem
        String keyword = req.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }

        //lay customer list tu CustomerService
        List<CustomerDto> customerFullList = customerService.searchAll(keyword);

        //tinh trang cuoi
        int lastPageNum;
        if (customerFullList.isEmpty()) {
            lastPageNum = 1;
        } else if (customerFullList.size() % 5 == 0) {
            lastPageNum = customerFullList.size() / 5;
        } else {
            lastPageNum = (customerFullList.size() - customerFullList.size() % 5) / 5 + 1;
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

        //lay customer list theo trang tu CustomerService
        List<CustomerDto> customerList = customerService.searchByPage(pageNum, keyword);

        //lay customer type list tu CustomerTypeService
        List<CustomerType> customerTypeList = customerTypeService.showAll();

        //tao attribute cho jsp
        req.setAttribute("customerList", customerList);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("customerTypeList", customerTypeList);
        req.setAttribute("keyword", keyword);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/customer/customer_home.jsp").forward(req, resp);
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin customerId cua khach hang can xoa
        int customerId = Integer.parseInt(req.getParameter("customerId"));

        //xoa khach hang
        customerService.delete(customerId);

        //chuyen tiep toi jsp
        showCustomerByPage(req, resp);
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin customerId cua khach hang can chinh sua
        int customerId = Integer.parseInt(req.getParameter("customerId"));
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

        //update thong tin moi cua khach hang
        Customer customer = new Customer(customerTypeId, customerName, customerBirthday, customerGender, customerIdCard,
                customerPhone, customerEmail, customerAddress);

        customerService.update(customerId, customer);

        //chuyen tiep toi jsp
        showCustomerByPage(req, resp);
    }

}
