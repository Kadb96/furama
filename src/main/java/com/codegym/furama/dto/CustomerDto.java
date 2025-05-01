package com.codegym.furama.dto;

import com.codegym.furama.model.Customer;

import java.time.LocalDate;
import java.util.Date;

public class CustomerDto extends Customer {
    private String customerTypeName;

    public CustomerDto() {}

    public CustomerDto(String customerId, int customerTypeId, String customerName, LocalDate customerBirthday,
                       boolean customerGender, String customerIdCard, String customerPhone, String customerEmail,
                       String customerAddress, String customerTypeName) {
        super(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        this.customerTypeName = customerTypeName;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
