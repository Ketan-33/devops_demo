package com.rcoem.devops_demo.services;

import com.rcoem.devops_demo.dto.UserInfo;
import com.rcoem.devops_demo.repository.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserinfoRepository userinfoRepository;
    public List<UserInfo> getAllUsers(){
        return userinfoRepository.getAllUsers();
    }
    public UserInfo createUser(UserInfo userInfo){
        return userinfoRepository.createUser(userInfo);
    }
    public UserInfo getUser(String id) throws Exception{
        UserInfo userInfo = userinfoRepository.getUserById(id);
        if(userInfo != null){
            return userInfo;
        }
        else{
            throw new Exception("User not found");
        }
    }
}
