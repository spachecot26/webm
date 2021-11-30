/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.webm.Controller;

import com.web.webm.Repository.services.UserService;
import com.web.webm.entities.User;
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
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{email}")
    public boolean getemail(@PathVariable("email") String email) {
        List<User> usuarios = service.getAll();
        return service.findEmail(usuarios, email);
    }
    
    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String psw) {
        List<User> usuarios = service.getAll();
        return service.authUser(usuarios, email, psw);
    }
    
    /**
     * GET
     *
     * @return
     */
    @GetMapping("/all")
    public List<User> getUsers() {
        return service.getAll();
    }

    /**
     * GET/{id}
     *
     * @param UserId
     * @return
     
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int UserId) {
        return service.getUser(UserId);
    }
    */
    
    /**
     * POST
     *
     * @param User
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User User) {
        return service.save(User);
    }

    /**
     * PUT
     *
     * @param User
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User User) {
        return service.update(User);
    }

    /**
     * DELETE
     *
     * @param User
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int UserId) {
        return service.delete(UserId);
    }
 
}

