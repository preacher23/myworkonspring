package com.example.student.repository;

import com.example.student.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addressrepo extends JpaRepository<Address,Integer> {
}
