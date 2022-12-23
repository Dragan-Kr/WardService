package com.example.demo.repository;

import com.example.demo.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WardRepository extends JpaRepository<Ward,Integer> {

    Collection<Ward> findByNameContainingIgnoreCase(String name);
}
