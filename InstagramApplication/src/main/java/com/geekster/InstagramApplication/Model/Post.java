package com.geekster.InstagramApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    private Long postId;
    private Timestamp createdPost;
    private Timestamp updatedPost;
    private String postData;

    @ManyToOne
    @JoinColumn(name = "fk_post_user_id")
    private User postOwner;
}
