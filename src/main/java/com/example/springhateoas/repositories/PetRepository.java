package com.example.springhateoas.repositories;


import com.example.springhateoas.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
