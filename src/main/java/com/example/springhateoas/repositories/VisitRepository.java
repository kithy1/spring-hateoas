package com.example.springhateoas.repositories;


import com.example.springhateoas.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit,Long> {
}
