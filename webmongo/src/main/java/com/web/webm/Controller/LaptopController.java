/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.webm.Controller;

import com.web.webm.Repository.services.LaptopService;
import com.web.webm.entities.Laptop;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fdomoreno
 */
@RestController
@RequestMapping("/api/laptop")
@CrossOrigin(origins = "*")
public class LaptopController {

    @Autowired
    private LaptopService service;
    
    /**
     * GET
     *
     * @return
     */
    @GetMapping("/all")
    public List<Laptop> getLaptops() {
        return service.getAll();
    }

    /**
     * GET/{id}
     *
     * @param LaptopId
     * @return
     
    @GetMapping("/{id}")
    public Optional<Laptop> getLaptop(@PathVariable("id") int LaptopId) {
        return service.getLaptop(LaptopId);
    }
    */
    
    /**
     * POST
     *
     * @param Laptop
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop save(@RequestBody Laptop Laptop) {
        return service.save(Laptop);
    }

    /**
     * PUT
     *
     * @param Laptop
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop Laptop) {
        return service.update(Laptop);
    }

    /**
     * DELETE
     *
     * @param Laptop
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int LaptopId) {
        return service.delete(LaptopId);
    }
 
}

