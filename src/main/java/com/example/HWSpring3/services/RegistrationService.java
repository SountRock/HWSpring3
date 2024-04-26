package com.example.HWSpring3.services;

import com.example.HWSpring3.domain.User;
import com.example.HWSpring3.repository.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private  DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private H2Repository h2Repo;

    public RegistrationService() {}

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    //Метод processRegistration
    public String processRegistration(String name, int age, String email){
        User temp = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(temp);
        notificationService.notifyUser(temp);

        return "Create: " + temp.toString();
    }

    /**
     * Импортировать имющихся User-ов в h2
     */
    public void importUsersToH2(){
        h2Repo.saveAll(dataProcessingService.getRepository().getUsers());
    }
}
