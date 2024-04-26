package com.example.HWSpring3.repository;


import com.example.HWSpring3.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2Repository extends CrudRepository<User, Long> {}
