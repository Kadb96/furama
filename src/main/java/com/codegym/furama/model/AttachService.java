package com.codegym.furama.model;

public class AttachService {
    private int attachServiceId;
    private String attachServiceName;
    private double attachServicePrice;
    private String attachServiceUnit;
    private String attachServiceStatus;

    public AttachService(int attachServiceId, String attachServiceName, double attachServicePrice,
                         String attachServiceUnit, String attachServiceStatus) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServicePrice = attachServicePrice;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public AttachService() {
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public double getAttachServicePrice() {
        return attachServicePrice;
    }

    public void setAttachServicePrice(double attachServicePrice) {
        this.attachServicePrice = attachServicePrice;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
