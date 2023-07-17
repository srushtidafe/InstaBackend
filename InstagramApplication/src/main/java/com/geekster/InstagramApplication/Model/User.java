package com.geekster.InstagramApplication.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long userId;
    private String firstName;
    private String lastName;
    private String userAge;
    @Email
    private String userEmail;
    private String userPassword;
    private String userPhoneNumber;

    public User(String firstName, String lastName, String userAge, String userEmail, String userPassword, String userPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> post;

}
