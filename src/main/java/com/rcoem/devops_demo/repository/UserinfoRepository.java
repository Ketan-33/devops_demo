package com.rcoem.devops_demo.repository;

import com.rcoem.devops_demo.dto.UserInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserinfoRepository {
    Map<String, UserInfo> userInfoTable;

    @PostConstruct
    public void init(){
        userInfoTable = new HashMap<>();
    }

    public List<UserInfo> getAllUsers(){
        return new ArrayList<>(userInfoTable.values());
    }

    public UserInfo createUser(UserInfo userInfo){
        String userId = UUID.randomUUID().toString();
        UserInfo userInfoWithId = userInfo.toBuilder().id(userId).build();
        this.userInfoTable.put(userId, userInfoWithId);
        return userInfoWithId;
    }

    public UserInfo getUserById(String id){
        UserInfo userInfo = this.userInfoTable.get(id);
        return userInfo != null ? userInfo.toBuilder().id(id).build() : null;
    }
}