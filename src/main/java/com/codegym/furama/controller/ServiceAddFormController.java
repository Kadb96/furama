package com.codegym.furama.controller;

import com.codegym.furama.model.Customer;
import com.codegym.furama.model.RentType;
import com.codegym.furama.model.Service;
import com.codegym.furama.model.ServiceType;
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

@WebServlet (name = "ServiceAddFormController", value = "/service_add_forms")
public class ServiceAddFormController extends HttpServlet {
    //ket noi ServiceService
    private IServiceService serviceService = new ServiceService();

    //ket noi RentTypeService
    private IRentTypeService rentTypeService = new RentTypeService();

    //ket noi serviceTypeService
    private IServiceTypeService serviceTypeService = new ServiceTypeService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay danh sach Rent Type
        List<RentType> rentTypeList = rentTypeService.showAll();

        //lay danh sach Service Type
        List<ServiceType> serviceTypeList = serviceTypeService.showAll();

        //tao attribute cho jsp
        req.setAttribute("rentTypeList", rentTypeList);
        req.setAttribute("serviceTypeList", serviceTypeList);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/service/service_add_form.jsp").forward(req, resp);
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
            case "addNewService":
                addNewService(req, resp);
                break;
        }
    }

    private void addNewService(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //lay thong tin Service
        String serviceName = req.getParameter("serviceName");
        int serviceArea = Integer.parseInt(req.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(req.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(req.getParameter("serviceMaxPeople"));
        int rentTypeId = Integer.parseInt(req.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(req.getParameter("serviceTypeId"));
        String standardRoom = req.getParameter("standardRoom");
        String descriptionOtherConvenience = req.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(req.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(req.getParameter("numberOfFloors"));

        //tao service moi
        Service service = new Service(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId,
                serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
        serviceService.add(service);

        // chuyen tiep sang customer home
        resp.sendRedirect(req.getContextPath() + "/services");
    }
}
