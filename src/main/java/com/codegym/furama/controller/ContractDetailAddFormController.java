package com.codegym.furama.controller;

import com.codegym.furama.dto.ContractDetailDto;
import com.codegym.furama.dto.ContractDto;
import com.codegym.furama.model.AttachService;
import com.codegym.furama.model.ContractDetail;
import com.codegym.furama.service.attach_service_service.AttachServiceService;
import com.codegym.furama.service.attach_service_service.IAttachServiceService;
import com.codegym.furama.service.contract_service.ContractDetailService;
import com.codegym.furama.service.contract_service.ContractService;
import com.codegym.furama.service.contract_service.IContractDetailService;
import com.codegym.furama.service.contract_service.IContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailAddFormController", value = "/contract_detail_add_forms")
public class ContractDetailAddFormController extends HttpServlet {
    //ket noi ContractDetailService
    private IContractDetailService contractDetailService = new ContractDetailService();

    //ket noi ContractService
    private IContractService contractService = new ContractService();

    //ket noi AttachServiceService
    private IAttachServiceService attachServiceService = new AttachServiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin contractId
        String contractIdString = req.getParameter("contractIdToDetail");
        int contractId;
        if (contractIdString == null) {
            contractId = 0;
        } else {
            contractId = Integer.parseInt(contractIdString);
        }

        //lay contract list
        List<ContractDto> contractList = contractService.showAll();

        //lay attachServiceList
        List<AttachService> attachServiceList = attachServiceService.showAll();


        //tao attribute cho jsp
        req.setAttribute("contractId", contractId);
        req.setAttribute("contractList", contractList);
        req.setAttribute("attachServiceList", attachServiceList);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/contract/contract_detail_add_form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay du lieu action
        String action = req.getParameter("action");
        if (action == null) {
            action = "showContractDetailAddForm";
        }

        //function cho moi action
        switch (action) {
            case "showContractDetailAddForm":
                showContractDetailAddForm(req, resp);
                break;
            case "addNewContractDetail":
                addNewContractDetail(req, resp);
                break;
        }
    }

    private void showContractDetailAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thong tin contractId
        String contractIdString = req.getParameter("contractIdToDetail");
        int contractId;
        if (contractIdString == null) {
            contractId = 0;
        } else {
            contractId = Integer.parseInt(contractIdString);
        }

        //lay attachServiceList
        List<AttachService> attachServiceList = attachServiceService.showAll();

        //tao attribute cho jsp
        req.setAttribute("contractId", contractId);
        req.setAttribute("attachServiceList", attachServiceList);

        //chuyen tiep toi jsp
        req.getRequestDispatcher("/view/contract/contract_detail_add_form.jsp").forward(req, resp);
    }

    private void addNewContractDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //lay thong tin ContractDetail
        int contractId = Integer.parseInt(req.getParameter("contractId"));
        int attachServiceId = Integer.parseInt(req.getParameter("attachServiceId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        //tao contractDetail moi
        ContractDetail contractDetail = new ContractDetail(contractId, attachServiceId, quantity);
        contractDetailService.add(contractDetail);

        // chuyen tiep sang customer home
        resp.sendRedirect(req.getContextPath() + "/contracts");
    }
}
