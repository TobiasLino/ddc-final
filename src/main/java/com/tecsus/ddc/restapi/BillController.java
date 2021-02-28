package com.tecsus.ddc.restapi;

import com.tecsus.ddc.model.bill.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/get")
    public String findALl() {
        return billService.findAll();
    }
}
