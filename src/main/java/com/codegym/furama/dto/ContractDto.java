package com.codegym.furama.dto;

import com.codegym.furama.model.Contract;

import java.time.LocalDate;

public class ContractDto extends Contract {
    String employeeName;
    String customerName;
    String serviceName;

    public ContractDto(int contractId, LocalDate contractStartDate, LocalDate contractEndDate, double contractDeposit,
                       double contractTotalMoney, int employeeId, String customerId, String serviceId, String employeeName,
                       String customerName, String serviceName) {
        super(contractId, contractStartDate, contractEndDate, contractDeposit, contractTotalMoney, employeeId,
                customerId, serviceId);
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.serviceName = serviceName;
    }

    public ContractDto(LocalDate contractStartDate, LocalDate contractEndDate, double contractDeposit,
                       double contractTotalMoney, int employeeId, String customerId, String serviceId, String employeeName,
                       String customerName, String serviceName) {
        super(contractStartDate, contractEndDate, contractDeposit, contractTotalMoney, employeeId, customerId, serviceId);
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.serviceName = serviceName;
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
}
