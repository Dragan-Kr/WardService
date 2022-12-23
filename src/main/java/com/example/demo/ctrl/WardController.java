package com.example.demo.ctrl;

import com.example.demo.dto.WardDto;
import com.example.demo.entity.Ward;
import com.example.demo.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class WardController {

    @Autowired
    private WardService wardService;

    @GetMapping("ward")
    public Collection<Ward> findAll(){

         return wardService.findAll();
    }

    @GetMapping("ward/name/{name}")
    public Ward getWardByName(@PathVariable("name") String name){
        return  wardService.findByNameContainingIgnoreCase(name);
    }


    @GetMapping("ward/{id}")
    public Ward getWardById(@PathVariable("id") Integer id){
        return wardService.getOneObject(id);
    }

    @PostMapping("ward")
    public ResponseEntity insertWard(@RequestBody WardDto wardDto){
      Ward ward = new Ward();
      ward.setName(wardDto.getName());
      ward.setCapacity(wardDto.getCapacity());
      wardService.saveObject(ward);
      return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("ward/{id}")
    public ResponseEntity updateWard(@PathVariable("id") Integer id,@RequestBody WardDto wardDto){
        Ward ward = wardService.getOneObject(id);
        ward.setName(wardDto.getName());
        ward.setCapacity(wardDto.getCapacity());
        Ward updatedWard = wardService.save(ward);
        return  ResponseEntity.ok(updatedWard);
    }



    @DeleteMapping("ward/{id}")
    public  ResponseEntity<Ward> deleteWard(@PathVariable ("id") Integer id){
        if(!wardService.existsObjectById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        wardService.deleteObjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
