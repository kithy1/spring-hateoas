package com.example.springhateoas.controllers;

import com.example.springhateoas.model.Owner;
import com.example.springhateoas.services.OwnerService;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@RepositoryRestController
@RequestMapping("/")
public class OwnerRepositoryRestController {

    private final OwnerService ownerService;

    public OwnerRepositoryRestController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @GetMapping("owners2")
    @ResponseBody
    public Set<Owner> getAllOwners(){
        return ownerService.getOwners();
    }
}
