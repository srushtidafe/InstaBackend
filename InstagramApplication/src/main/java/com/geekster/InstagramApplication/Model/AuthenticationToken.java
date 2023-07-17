package com.geekster.InstagramApplication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    private LocalDate tokenCreatedDate;

    @OneToOne
    private User user;

    public AuthenticationToken(User user)
    {
        this.user = user;
        this.token = UUID.randomUUID().toString();
        this.tokenCreatedDate = LocalDate.now();
    }
}
