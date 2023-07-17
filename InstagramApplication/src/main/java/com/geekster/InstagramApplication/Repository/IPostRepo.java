package com.geekster.InstagramApplication.Repository;

import com.geekster.InstagramApplication.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Long > {

}
