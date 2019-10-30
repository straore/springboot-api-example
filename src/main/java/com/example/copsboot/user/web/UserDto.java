package com.example.copsboot.user.web;

import com.example.copsboot.user.User;
import com.example.copsboot.user.UserId;
import com.example.copsboot.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Set;

@Data
public class UserDto {

   private UserId id;
   private String email;
   private Set<UserRole> roles;

    public UserDto(UserId id, String email, Set<UserRole> roles) {
    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getRoles());
    }
}
