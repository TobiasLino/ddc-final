package com.tecsus.ddc.restapi;

import com.tecsus.ddc.model.client.Client;
import com.tecsus.ddc.model.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/all")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/get/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }
}
