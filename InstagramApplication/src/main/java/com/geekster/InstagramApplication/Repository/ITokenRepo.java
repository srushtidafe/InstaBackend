package com.geekster.InstagramApplication.Repository;

import com.geekster.InstagramApplication.Model.AuthenticationToken;
import com.geekster.InstagramApplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken ,Long> {


    AuthenticationToken findFirstByToken(String token);

    AuthenticationToken findByUser(User user);

}
