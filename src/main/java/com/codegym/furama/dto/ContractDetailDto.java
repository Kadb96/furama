package com.codegym.furama.dto;

import com.codegym.furama.model.ContractDetail;

public class ContractDetailDto extends ContractDetail {
    private String AttachServiceName;

    public ContractDetailDto(int contractDetailId, int contractId, int attachServiceId, int quantity,
                             String attachServiceName) {
        super(contractDetailId, contractId, attachServiceId, quantity);
        this.AttachServiceName = attachServiceName;
    }

    public ContractDetailDto(int contractId, int attachServiceId, int quantity,
                             String attachServiceName) {
        super(contractId, attachServiceId, quantity);
        this.AttachServiceName = attachServiceName;
    }

    public ContractDetailDto() {
    }

    public String getAttachServiceName() {
        return AttachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        AttachServiceName = attachServiceName;
    }
}
