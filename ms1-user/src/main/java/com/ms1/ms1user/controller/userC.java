package com.ms1.ms1user.controller;

import com.ms1.ms1user.service.userService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ms1.ms1user.model.user;
import com.ms1.ms1user.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/ms-/user")
    public class userC {
    Logger logger = LoggerFactory.getLogger(userC.class);
        @Autowired
        private repository userR;

        private userService userS;
        @Autowired
        public userC(repository userR) {
            this.userR = userR;
        }

        @GetMapping("/all")
        Iterable<user> all() {
            logger.info("Trayendo todos los usuarios");
            return userR.findAll();
        }

        @GetMapping("/{id}")
        public user findItemById(@PathVariable Long id){
                user user = userR.findById(id).orElse(null);
                if(user!=null)
                    logger.info("Usuario traido: id=" + id);
                else
                    logger.error("Error al traer usuario inexistente: id=" + id);
            return user;
        }
            //return userR.findById(id).orElseThrow(() -> new ResponseStatusException(
              //      HttpStatus.NOT_FOUND)
           // );

        @PostMapping("/save")
        user save(@RequestBody user user) {
            logger.info("Guardando Usuario");
            return userR.save(user);
        }

        @PostMapping("/update")
        user update(@RequestBody user user){
            Optional<user> optionaluser = userR.findById(user.getId());
            try {
                if (!optionaluser.isPresent());
                logger.info("Actualizando Usuario");
            }
            catch (Exception e){
                logger.error("Usuario no encontrado para actualizar: " + user.getId());
            }
            return userR.save(user);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id){
            Optional<user> optionaluser = userR.findById(id);
            try {
                if (!optionaluser.isPresent());
            }
            catch (Exception e){
                logger.error("Usuario no encontrado para eliminar: " + id);
            }
            logger.info("Eliminando Usuario");
            userR.deleteById(id);
        }
    }
