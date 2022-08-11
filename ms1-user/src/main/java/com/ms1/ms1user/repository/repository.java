package com.ms1.ms1user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ms1.ms1user.model.user;


public interface repository extends JpaRepository<user, Long>  {

}
