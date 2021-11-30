/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.webm.Repository.services;

import com.web.webm.Repository.LaptopRepository;
import com.web.webm.entities.Laptop;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repository;

    /**
     * GET
     *
     * @return Lista de Laptop.
     */
    public List<Laptop> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param LaptopId
     * @return
     */
    public Optional<Laptop> getLaptop(int LaptopId) {
        return repository.getLaptop(LaptopId);
    }

    /**
     * POST
     *
     * @param Laptop
     * @return
     */
    public Laptop save(Laptop Laptop) {
        //Consultar si se envía el ID
        if (Laptop.getId()== null) {
            return repository.save(Laptop);
        } else {
            //Consultar si existe el registro.
            Optional<Laptop> existLaptop = repository.getLaptop(Laptop.getId());
            if (existLaptop.isPresent()) {
                return Laptop;
            } else {
                return repository.save(Laptop);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param Laptop
     * @return
     */
    public Laptop update(Laptop Laptop) {
        if (Laptop.getId() != null) {
            Optional<Laptop> existLaptop = repository.getLaptop(Laptop.getId());
            if (existLaptop.isPresent()) {
                if (Laptop.getBrand()!= null) {
                    existLaptop.get().setBrand(Laptop.getBrand());
                }
                
                if (Laptop.getModel() != null) {
                    existLaptop.get().setModel(Laptop.getModel());
                }
                
                if (Laptop.getProcesor() != null) {
                    existLaptop.get().setProcesor(Laptop.getProcesor());
                }
                
                if (Laptop.getOs() != null) {
                    existLaptop.get().setOs(Laptop.getOs());
                }
                
                if (Laptop.getDescription() != null) {
                    existLaptop.get().setDescription(Laptop.getDescription());
                }
                
                if (Laptop.getMemory() != null) {
                    existLaptop.get().setMemory(Laptop.getMemory());
                }
                
                if (Laptop.getHardDrive() != null) {
                    existLaptop.get().setHardDrive(Laptop.getHardDrive());
                }
                
                if (Laptop.getPrice() != 0.0) {
                    existLaptop.get().setPrice(Laptop.getPrice());
                }
                
                if (Laptop.getQuantity() != 0) {
                    existLaptop.get().setQuantity(Laptop.getQuantity());
                }
                if (Laptop.getPhotography() != null) {
                    existLaptop.get().setPhotography(Laptop.getPhotography());
                }
                return repository.save(existLaptop.get());
            } else {
                return Laptop;
            }
        } else {
            return Laptop;
        }
    }

    /**
     * DELETE
     *
     * @param LaptopId
     * @return
     */
    public boolean delete(int LaptopId) {
        Boolean respuesta = (Boolean) getLaptop(LaptopId).map(Laptop -> {
            repository.delete(Laptop);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
