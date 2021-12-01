/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.webm.Repository;

import com.web.webm.Repository.Crud.UserCrudRepository;
import com.web.webm.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public class UserRepository {
@Autowired
    private UserCrudRepository repository;
    
    
    /**
     * SELECT * FROM
     * @return Retorna todos los registros de la tabla
     */
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }
    
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID
     */
    public Optional<User> getUser(int id){
        return repository.findById(id);
    }    
    
    /**
     * INSERT & UPDATE
     * @param User
     * @return User Actualiza registro ya existente o Crea un nuevo registro
     */
    public User save(User User){
        return repository.save(User);
    }
    
    /**
     * DELETE FROM TABLE
     * @param User 
     */
    public void delete (User User){
        repository.delete(User);
    }
    
}