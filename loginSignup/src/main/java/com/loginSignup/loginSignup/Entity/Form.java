package com.loginSignup.loginSignup.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "userdetails")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
}
