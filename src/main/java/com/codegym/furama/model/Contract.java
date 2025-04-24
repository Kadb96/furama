package com.codegym.furama.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contract {
    private int contractId;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private double contractDeposit;
    private double contractTotalMoney;
    private int employeeId;
    private int customerId;
    private int serviceId;

    public Contract(int contractId, LocalDate contractStartDate, LocalDate contractEndDate, double contractDeposit,
                    double contractTotalMoney, int employeeId, int customerId, int serviceId) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Contract(LocalDate contractStartDate, LocalDate contractEndDate, double contractDeposit,
                    double contractTotalMoney, int employeeId, int customerId, int serviceId) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Contract() {
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getContractStartDateString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return contractStartDate.format(formatter);
    }

    public String getContractStartDateStringSql() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return contractStartDate.format(formatter);
    }

    public String getContractEndDateStringSql() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return contractEndDate.format(formatter);
    }

    public String getContractEndDateString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return contractEndDate.format(formatter);
    }

    public String getContractDepositString() {
        NumberFormat formatter = new DecimalFormat("###,###.###");
        return formatter.format(contractDeposit) + "đ";
    }

    public String getContractTotalMoneyString() {
        NumberFormat formatter = new DecimalFormat("###,###.###");
        return formatter.format(contractTotalMoney) + "đ";
    }
}
