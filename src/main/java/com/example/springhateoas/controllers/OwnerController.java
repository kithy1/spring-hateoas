package com.example.springhateoas.controllers;

import com.example.springhateoas.exceptions.OwnerNotFoundException;
import com.example.springhateoas.model.Owner;
import com.example.springhateoas.representatiommodel.OwnerModel;
import com.example.springhateoas.representatiommodel.OwnerModelAssembler;
import com.example.springhateoas.services.OwnerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequestMapping("owners")
@RestController
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public CollectionModel<OwnerModel> showOwners() {
        Pageable page = PageRequest.of(0,4, Sort.by("firstName"));
        Set<Owner> owners = ownerService.getOwners(page);
        CollectionModel<OwnerModel> ownerModels = new OwnerModelAssembler().toCollectionModel(owners);

        ownerModels.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OwnerController.class).showOwners()).withRel("owners"));
        return ownerModels;
    }
    @GetMapping("/{id}")
    public OwnerModel showOwner(@PathVariable Long id) {
        OwnerModel ownerModel = new OwnerModelAssembler().toModel(ownerService.findById(id));
        ownerModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OwnerController.class).showOwner(id)).withSelfRel());
        return ownerModel;
    }


}
