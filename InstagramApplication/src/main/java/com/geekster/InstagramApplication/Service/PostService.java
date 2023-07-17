package com.geekster.InstagramApplication.Service;

import com.geekster.InstagramApplication.Model.Post;
import com.geekster.InstagramApplication.Model.User;
import com.geekster.InstagramApplication.Repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    IPostRepo postRepo;

    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

    public Post savePost(Post post) {
        return postRepo.save(post);
    }

}
