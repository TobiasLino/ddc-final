package com.tecsus.ddc.restapi;

import com.tecsus.ddc.model.identification.Identification;
import com.tecsus.ddc.model.identification.IdentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/identity")
public class IdentificationController {

    @Autowired
    private IdentificationService identificationService;

    @GetMapping("/all")
    public List<Identification> findAll() {
        return identificationService.findAll();
    }

    @GetMapping("/get/{id}")
    public Identification findById(@PathVariable Long id) throws Exception {
        return identificationService.findById(id);
    }
}
