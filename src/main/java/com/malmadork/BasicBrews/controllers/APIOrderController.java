package com.malmadork.BasicBrews.controllers;

import com.malmadork.BasicBrews.services.InventoryService;
import com.malmadork.BasicBrews.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIOrderController extends APIController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private InventoryService inventoryService;
}
