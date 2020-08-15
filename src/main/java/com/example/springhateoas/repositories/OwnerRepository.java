package com.example.springhateoas.repositories;


import com.example.springhateoas.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OwnerRepository extends PagingAndSortingRepository<Owner,Long> {



}
