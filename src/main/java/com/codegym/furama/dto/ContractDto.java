package com.codegym.furama.dto;

import com.codegym.furama.model.Contract;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

public class ContractDto extends Contract {
    String employeeName;
    String customerName;
    String serviceName;
    double contractTotalMoney;

    public ContractDto(int contractId, LocalDate contractStartDate, LocalDate contractEndDate, double contractDeposit,
                       int employeeId, String customerId, String serviceId, String employeeName,
                       String customerName, String serviceName, double contractTotalMoney) {
        super(contractId, contractStartDate, contractEndDate, contractDeposit, employeeId,
                customerId, serviceId);
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.serviceName = serviceName;
        this.contractTotalMoney = contractTotalMoney;
    }

    public ContractDto(LocalDate contractStartDate, LocalDate contractEndDate, double contractDeposit, int employeeId,
                       String customerId, String serviceId, String employeeName, String customerName,
                       String serviceName, double contractTotalMoney) {
        super(contractStartDate, contractEndDate, contractDeposit, employeeId, customerId, serviceId);
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.serviceName = serviceName;
        this.contractTotalMoney = contractTotalMoney;
    }

    public ContractDto() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public String getContractTotalMoneyString() {
        NumberFormat formatter = new DecimalFormat("###,###.###");
        return formatter.format(contractTotalMoney) + "đ";
    }
}
