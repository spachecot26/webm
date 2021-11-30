/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.webm.Repository.services;


import com.web.webm.Repository.UserRepository;
import com.web.webm.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    /**
     * GET
     *
     * @return Lista de User.
     */
    public List<User> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param UserId
     * @return
     */
    public Optional<User> getUser(int UserId) {
        return repository.getUser(UserId);
    }

    /**
     * POST
     *
     * @param User
     * @return
     */
    public User save(User User) {
        //Consultar si se envía el ID
        if (User.getId()== null) {
            return repository.save(User);
        } else {
            //Consultar si existe el registro.
            Optional<User> existUser = repository.getUser(User.getId());
            if (existUser.isPresent()) {
                return User;
            } else {
                return repository.save(User);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param User
     * @return
     */
    public User update(User User) {
        if (User.getId() != null) {
            Optional<User> existUser = repository.getUser(User.getId());
            if (existUser.isPresent()) {
            if (User.getIdentification() != null) {
                    existUser.get().setIdentification(User.getIdentification());
                }
                if (User.getName() != null) {
                    existUser.get().setName(User.getName());
                }
                if (User.getAddress() != null) {
                    existUser.get().setAddress(User.getAddress());
                }
                if (User.getCellPhone() != null) {
                    existUser.get().setCellPhone(User.getCellPhone());
                }
                if (User.getEmail() != null) {
                    existUser.get().setEmail(User.getEmail());
                }
                if (User.getPassword() != null) {
                    existUser.get().setPassword(User.getPassword());
                }
                if (User.getZone() != null) {
                    existUser.get().setZone(User.getZone());
                }
                return repository.save(existUser.get());
            } else {
                return User;
            }
        } else {
            return User;
        }
    }

    /**
     * DELETE
     *
     * @param UserId
     * @return
     */
    public boolean delete(int UserId) {
        Boolean respuesta = (Boolean) getUser(UserId).map(User -> {
            repository.delete(User);
            return true;
        }).orElse(false);
        return respuesta;
    }

    public boolean findEmail(List<User> usuarios, String email) {
        
        User u = null;
        String correo="";
        boolean res = false;
        for (int i=0;i<usuarios.size();i++) {
            u=usuarios.get(i);
            correo = u.getEmail();
            if(correo.equals(email)){
                res = true;
            }
        }

        return res;
    }

    public User authUser(List<User> usuarios, String email, String psw) {
        User u = null; 
        User res=new User(null,null,null,null,null,null,null,null,null);;
        String correo="";
        String clave="";
        for (int i=0;i<usuarios.size();i++) {
            u=usuarios.get(i);
            correo = u.getEmail();
            clave = u.getPassword();
            if(correo.equals(email) && clave.equals(psw)){
                res = u;
            }
        }

        return res;
    }
}