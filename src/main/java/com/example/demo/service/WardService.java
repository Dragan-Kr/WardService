package com.example.demo.service;

import com.example.demo.entity.Ward;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface WardService {


    Collection<Ward> findAll();

    Ward findByNameContainingIgnoreCase(String name);

    Ward saveObject(Ward ward);

    Ward getOneObject(Integer id);

    Ward save(Ward ward);


    boolean existsObjectById(Integer id);

    void deleteObjectById(Integer id);
}
