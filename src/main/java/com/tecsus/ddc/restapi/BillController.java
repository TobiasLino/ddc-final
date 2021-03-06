package com.tecsus.ddc.restapi;

import com.tecsus.ddc.model.bill.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/all")
    public String findALl() {
        return billService.findAll();
    }
}
