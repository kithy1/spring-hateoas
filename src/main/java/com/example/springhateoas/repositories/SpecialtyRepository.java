package com.example.springhateoas.repositories;


import com.example.springhateoas.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty,Long> {
}
