package com.codegym.furama.service.attach_service_service;

import com.codegym.furama.model.AttachService;
import com.codegym.furama.repository.attach_service_repository.AttachServiceRepository;
import com.codegym.furama.repository.attach_service_repository.IAttachServiceRepository;

import java.util.List;

public class AttachServiceService implements IAttachServiceService {
    //ket noi AttachServiceRepository
    private IAttachServiceRepository attachServiceRepository = new AttachServiceRepository();

    @Override
    public List<AttachService> showAll() {
        return attachServiceRepository.showAll();
    }
}
