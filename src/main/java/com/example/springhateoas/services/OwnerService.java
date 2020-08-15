package com.example.springhateoas.services;

import com.example.springhateoas.exceptions.OwnerNotFoundException;
import com.example.springhateoas.model.Owner;
import com.example.springhateoas.repositories.OwnerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class OwnerService {
    OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Set<Owner> getOwners(Pageable page){
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll(page).forEach(owner -> owners.add(owner));
        return owners;
    }
    public Set<Owner> getOwners(){
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owner -> owners.add(owner));
        return owners;
    }

    public void save(Owner owner){
        ownerRepository.save(owner);
    }

    public Owner findById(Long id) throws OwnerNotFoundException {
       return ownerRepository.findById(id).orElseThrow(OwnerNotFoundException::new);
    }
}
