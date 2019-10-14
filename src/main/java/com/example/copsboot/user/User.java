package com.example.copsboot.user;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table("copsboot_user")
public class User {
    @Id
    private UUID id;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<UserRole> roles;

    protected User(){

    }
}
