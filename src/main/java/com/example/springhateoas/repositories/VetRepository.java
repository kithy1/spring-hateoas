package com.example.springhateoas.repositories;


import com.example.springhateoas.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends JpaRepository<Vet,Long> {
}
