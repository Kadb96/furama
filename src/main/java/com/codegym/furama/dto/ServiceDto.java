package com.codegym.furama.dto;

import com.codegym.furama.model.Service;

public class ServiceDto extends Service {
    private String rentTypeName;
    private String serviceTypeName;

    public ServiceDto(String serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople,
                      int rentTypeId, int serviceTypeId, String standardRoom, String descriptionOtherConvenience,
                      double poolArea, int numberOfFloors, String rentTypeName, String serviceTypeName) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId,
                standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
        this.rentTypeName = rentTypeName;
        this.serviceTypeName = serviceTypeName;
    }

    public ServiceDto() {
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
