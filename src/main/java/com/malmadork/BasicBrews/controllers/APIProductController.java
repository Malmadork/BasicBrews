package com.malmadork.BasicBrews.controllers;

import com.malmadork.BasicBrews.services.InventoryService;
import com.malmadork.BasicBrews.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIProductController extends APIController {

    @Autowired
    private ProductService productService;

    @Autowired
    private InventoryService inventoryService;
}
