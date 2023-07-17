package com.geekster.InstagramApplication.Service;

import com.geekster.InstagramApplication.Dto.SignUpInput;
import com.geekster.InstagramApplication.Dto.SignUpOutput;
import com.geekster.InstagramApplication.Model.AuthenticationToken;
import com.geekster.InstagramApplication.Model.User;
import com.geekster.InstagramApplication.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    TokenService tokenService;

    public SignUpOutput signUp(SignUpInput signUpInput) {
        User user1 = userRepo.findFirstByEmail(signUpInput.getEmail());

        if(user1 != null){
            throw new IllegalStateException("Patient already exists by this details..");
        }

        //encryption
        String encryptedPassword = null;
        try{
            encryptedPassword = PasswordEncrypter.encryptPassword(signUpInput.getPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        //save the user
        User user = new User(signUpInput.getFirstName(),signUpInput.getLastName(),signUpInput.getAge(),signUpInput.getEmail(),encryptedPassword,signUpInput.getPhoneNumber());

        userRepo.save(user);

        AuthenticationToken token = new AuthenticationToken(user);
        tokenService.saveToken(token);
        return new SignUpOutput(HttpStatus.ACCEPTED,"User registered Successfully");
    }


    public SignUpOutput signIn(SignUpInput signUpInput){
        User user = userRepo.findFirstByEmail(signUpInput.getEmail());
        if(user == null){
            throw new IllegalStateException("User invalid..!!!");
        }
        //encrypt the password
        String encryptedPassword = null;
        try{
            encryptedPassword = PasswordEncrypter.encryptPassword(signUpInput.getPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        //match it with database encryption
        boolean isPasswordValid = encryptedPassword.equals(user.getUserPassword());
        if(!isPasswordValid){
            throw new IllegalStateException("User invalid..!!!!!!!!");
        }
        AuthenticationToken token = tokenService.getToken(user);
        return new SignUpOutput(HttpStatus.OK,token.getToken());

    }

    public void updateUser(SignUpInput signUpInput) {
        User user1 = userRepo.findFirstByEmail(signUpInput.getEmail());
        if(user1 == null){
            throw new IllegalStateException("User invalid..!!!");
        }
        String encryptedPassword = null;
        if(signUpInput.getEmail() != null)
        {
            try {
                encryptedPassword = PasswordEncrypter.encryptPassword(signUpInput.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        //save the user
        User user = new User(signUpInput.getFirstName(),signUpInput.getLastName(),signUpInput.getAge(),signUpInput.getEmail(),encryptedPassword,signUpInput.getPhoneNumber());

        userRepo.save(user);
    }
}
