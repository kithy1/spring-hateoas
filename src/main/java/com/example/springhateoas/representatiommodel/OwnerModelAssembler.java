package com.example.springhateoas.representatiommodel;

import com.example.springhateoas.controllers.OwnerController;
import com.example.springhateoas.model.Owner;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class OwnerModelAssembler extends RepresentationModelAssemblerSupport<Owner, OwnerModel> {


    public OwnerModelAssembler() {
        super(OwnerController.class, OwnerModel.class);
    }

    @Override
    protected OwnerModel instantiateModel(Owner owner){
        return new OwnerModel(owner);
    }

    @Override
    public OwnerModel toModel(Owner owner) {
        return createModelWithId(owner.getId(), owner);
    }
}
