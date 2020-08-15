package com.example.springhateoas.repositories;

import com.example.springhateoas.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
