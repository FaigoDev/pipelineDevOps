package com.ms1.ms1user.service;

import com.ms1.ms1user.model.user;
import com.ms1.ms1user.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class userImpl implements userService {

    @Autowired
    repository userR;

    @Override
    public List<user> findAll() {
        return userR.findAll();
    }

    @Override
    public user save(user user) {
        return userR.save(user);
    }

    @Override
    public user update(user user) {
        Optional<user> optionaluser = userR.findById(user.getId());
        if (!optionaluser.isPresent()) throw new RuntimeException("No se encontro el usuario a actualizar");
        return userR.save(user);
    }

    @Override
    public void delete(Long id) {
        Optional<user> optionaluser = userR.findById(id);
        if (!optionaluser.isPresent()) throw new RuntimeException("No se encontro el usuario a eliminar");
        userR.deleteById(id);
    }
}
