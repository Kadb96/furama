package com.codegym.furama.controller;

import com.codegym.furama.dto.ServiceDto;
import com.codegym.furama.model.*;
import com.codegym.furama.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceController", value = "/services")
public class ServiceController extends HttpServlet {
    //ket noi ServiceService
    private IServiceService serviceService = new ServiceService();

    //ket noi RentTypeService
    private IRentTypeService rentTypeService = new RentTypeService();

    //ket noi serviceTypeService
    private IServiceTypeService serviceTypeService = new ServiceTypeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay du lieu action
        String action = req.getParameter("action");
        if (action == null) {
            action = "showServiceByPage";
        }

        //function cho moi action
        switch (action) {
            case "showServiceByPage":
                showServiceByPage(req, resp);
                break;
        }
    }

    private void showServiceByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin keyword de tim kiem
        String keyword = req.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }

        //lay service list tu ServiceService
        List<ServiceDto> serviceFullList = serviceService.searchAll(keyword);

        //tinh trang cuoi
        int lastPageNum;
        if (serviceFullList.isEmpty()) {
            lastPageNum = 1;
        } else if (serviceFullList.size() % 5 == 0) {
            lastPageNum = serviceFullList.size() / 5;
        } else {
            lastPageNum = ((serviceFullList.size() - (serviceFullList.size() % 5)) / 5) + 1;
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

        //lay service list theo trang tu ServiceService
        List<ServiceDto> serviceList = serviceService.searchByPage(pageNum, keyword);

        //lay rentTypeList
        List<RentType> rentTypeList =  rentTypeService.showAll();

        //lay serviceTypeList
        List<ServiceType> serviceTypeList = serviceTypeService.showAll();

        //tao attribute cho jsp
        req.setAttribute("serviceList", serviceList);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("rentTypeList", rentTypeList);
        req.setAttribute("serviceTypeList", serviceTypeList);
        req.setAttribute("keyword", keyword);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/service/service_home.jsp").forward(req, resp);
    }
}
