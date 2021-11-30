/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.webm.Repository;

import com.web.webm.Repository.Crud.LaptopCrudRepository;
import com.web.webm.entities.Laptop;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public class LaptopRepository {
@Autowired
    private LaptopCrudRepository repository;
    
    
    /**
     * SELECT * FROM
     * @return Retorna todos los registros de la tabla
     */
    public List<Laptop> getAll(){
        return (List<Laptop>) repository.findAll();
    }
    
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID
     */
    public Optional<Laptop> getLaptop(int id){
        return repository.findById(id);
    }    
    
    /**
     * INSERT & UPDATE
     * @param Laptop
     * @return Laptop Actualiza registro ya existente o Crea un nuevo registro
     */
    public Laptop save(Laptop Laptop){
        return repository.save(Laptop);
    }
    
    /**
     * DELETE FROM TABLE
     * @param Laptop 
     */
    public void delete (Laptop Laptop){
        repository.delete(Laptop);
    }
    
}