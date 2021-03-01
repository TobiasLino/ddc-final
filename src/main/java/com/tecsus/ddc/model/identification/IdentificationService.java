package com.tecsus.ddc.model.identification;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentificationService {

    @Autowired
    private IdentificationRepository identificationRepository;

    public List<Identification> findAll() {
        return identificationRepository.findAll();
    }

    public Identification findById(long id) throws Exception {
        return identificationRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("NOT_FOUND","Identification " + id + " not found."));
    }
}
