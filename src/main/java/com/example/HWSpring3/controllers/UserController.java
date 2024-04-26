package com.example.HWSpring3.controllers;

//import com.example.HWSpring3.repository.H2UserRepository;
import com.example.HWSpring3.repository.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.HWSpring3.domain.User;
import com.example.HWSpring3.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    @PostMapping("/paramCreate/{name}/{age}/{email}")
    public String userAddFromParam(@PathVariable(name = "name") String name,
                                   @PathVariable(name = "age") int age,
                                   @PathVariable(name = "email") String email){
        return service.processRegistration(name, age, email);
    }


    /**
     * Импортировать имющихся User-ов в h2
     */
    @PostMapping("/import")
    public String importUsersToH2(){
        service.importUsersToH2();

        return "successfully added users to H2 database";
    }
}
