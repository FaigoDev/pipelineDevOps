package com.ms1.ms1user.service;

import  com.ms1.ms1user.model.user;
import java.util.List;

public interface userService {

    List<user> findAll();

    user save(user user);

    user update(user user);

    void delete(Long id);
}