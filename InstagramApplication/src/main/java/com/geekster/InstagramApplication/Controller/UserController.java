package com.geekster.InstagramApplication.Controller;


import com.geekster.InstagramApplication.Dto.SignUpInput;
import com.geekster.InstagramApplication.Dto.SignUpOutput;
import com.geekster.InstagramApplication.Service.PostService;
import com.geekster.InstagramApplication.Service.TokenService;
import com.geekster.InstagramApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpInput){

        return userService.signUp(signUpInput);
    }

    @PostMapping("/signin")
    public SignUpOutput signIn(@RequestBody SignUpInput signUpInput){
        return userService.signIn(signUpInput);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestParam String email, @RequestParam String token, @RequestBody SignUpInput signUpInput){
        HttpStatus status;
        String message = "";
        if(tokenService.authenticate(email,token)){
            userService.updateUser(signUpInput);
            message = "Updated Successully";
            status = HttpStatus.ACCEPTED;
        }else{
            message ="Invalid Details to update";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(message,status);

    }


}
