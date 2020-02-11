package com.corp.UserFace.controller;

import com.corp.UserFace.entity.UserAccount;
import com.corp.UserFace.repository.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAccountRepo userAccountRepo;

    @GetMapping
    public List<UserAccount> allUsers(){
        return (List<UserAccount>) userAccountRepo.findAll();
    }

    @PostMapping("/{id}")
    public Optional<UserAccount> findUser(@PathVariable Long id){
        return userAccountRepo.findById(id);
    }

    @PostMapping("/new")
    public void regNewUser(@RequestBody UserAccount userAccount){
        UserAccount user = userAccountRepo.findByUserName(userAccount.getUserName());
        if(user!=null){
            System.out.println("Тут будет редирект на страницу логина");
        } else{
            userAccountRepo.save(userAccount);
        }
    }

    @PostMapping("/{id}/edit")
    public void editUser(@PathVariable Long id){
        System.out.println("тут будет эдит юзера");
    }
}
