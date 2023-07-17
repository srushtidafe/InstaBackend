package com.geekster.InstagramApplication.Service;

import com.geekster.InstagramApplication.Model.AuthenticationToken;
import com.geekster.InstagramApplication.Model.User;
import com.geekster.InstagramApplication.Repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenService {
    @Autowired
    ITokenRepo tokenRepo;

    public void saveToken(AuthenticationToken token){
        tokenRepo.save(token);
    }

    public AuthenticationToken getToken(User user){
        return tokenRepo.findByUser(user);
    }

    public boolean authenticate(String email,String token){
        AuthenticationToken authenticationToken = tokenRepo.findFirstByToken(token);
        Optional<String> expectedMail = Optional.ofNullable(authenticationToken.getUser().getUserEmail());
        if(expectedMail.isPresent()){
            return true;
        }else
            return false;
    }
}
