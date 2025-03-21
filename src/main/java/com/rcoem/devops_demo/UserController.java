package com.rcoem.devops_demo;

import com.rcoem.devops_demo.dto.UserInfo;
import com.rcoem.devops_demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    List<UserInfo> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    UserInfo createUser(@RequestBody UserInfo userInfo){
        return userService.createUser(userInfo);
    }
    @GetMapping("/{id}")
      ResponseEntity<UserInfo> getUser(@PathVariable String id){
        try{
            return ResponseEntity.ok().body(userService.getUser(id));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
