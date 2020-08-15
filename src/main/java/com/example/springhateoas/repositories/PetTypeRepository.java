package com.example.springhateoas.repositories;


import com.example.springhateoas.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends JpaRepository<PetType,Long> {
}
