/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.webm.Repository.Crud;

import com.web.webm.entities.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author pc
 */
public interface LaptopCrudRepository extends MongoRepository<Laptop,Integer>{
}
