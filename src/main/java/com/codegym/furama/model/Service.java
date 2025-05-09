package com.codegym.furama.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Service {
    private String serviceId;
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private int rentTypeId;
    private int serviceTypeId;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;

    public Service(String serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople,
                   int rentTypeId, int serviceTypeId, String standardRoom, String descriptionOtherConvenience,
                   double poolArea, int numberOfFloors) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Service(String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople,
                   int rentTypeId, int serviceTypeId, String standardRoom, String descriptionOtherConvenience,
                   double poolArea, int numberOfFloors) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Service() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getServiceAreaString() {
        if (serviceArea > 0) {
            NumberFormat formatter = new DecimalFormat("###,###.###");
            return formatter.format(serviceArea) + "m\u00B2";
        } else {
            return null;
        }

    }

    public String getServiceCostString() {
        NumberFormat formatter = new DecimalFormat("###,###.###");
        return formatter.format(serviceCost) + "đ";
    }

    public String getPoolAreaString() {
        if (poolArea > 0) {
            NumberFormat formatter = new DecimalFormat("###,###.###");
            return formatter.format(poolArea) + "m\u00B2";
        } else {
            return null;
        }
    }

    public String getNumberOfFloorsString() {
        NumberFormat formatter = new DecimalFormat("###,###.###");

        if (numberOfFloors > 1) {
            return formatter.format(numberOfFloors) + " floors";
        } else if (numberOfFloors == 1) {
            return formatter.format(numberOfFloors) + " floor";
        } else {
            return null;
        }
    }
}
