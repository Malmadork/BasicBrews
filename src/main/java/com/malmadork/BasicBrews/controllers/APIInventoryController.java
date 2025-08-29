package com.malmadork.BasicBrews.controllers;

import com.malmadork.BasicBrews.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIInventoryController extends APIController {

    @Autowired
    private InventoryService inventoryService;


}
