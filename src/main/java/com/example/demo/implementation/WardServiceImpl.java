package com.example.demo.implementation;

import com.example.demo.entity.Ward;
import com.example.demo.repository.WardRepository;
import com.example.demo.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WardServiceImpl implements WardService {

    @Autowired
    private WardRepository wardRepository;

    @Override
    public Collection<Ward> findAll() {
        return wardRepository.findAll();
    }

    @Override
    public Ward findByNameContainingIgnoreCase(String name) {
        return (Ward) wardRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Ward saveObject(Ward ward) {
        return wardRepository.save(ward);
    }

    @Override
    public Ward getOneObject(Integer id) {
        return wardRepository.getById(id);
    }

    @Override
    public Ward save(Ward ward) {
        return wardRepository.save(ward);
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return wardRepository.existsById(id);
    }

    @Override
    public void deleteObjectById(Integer id) {
        wardRepository.deleteById(id);
    }


}
