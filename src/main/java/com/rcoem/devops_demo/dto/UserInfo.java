package com.rcoem.devops_demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder (toBuilder = true)
public class UserInfo {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
