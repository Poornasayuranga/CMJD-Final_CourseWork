package com.example.demo.Security;

import com.example.demo.Entity.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsRequest {

    private String username;

    private String password;

    private String email;

    private UserRoles userRole;
}