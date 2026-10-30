package com.coding.module1introduction.controllers;

import com.coding.module1introduction.dto.LoginDTO;
import com.coding.module1introduction.dto.SignUpDTO;
import com.coding.module1introduction.dto.UserDTO;
import com.coding.module1introduction.services.AuthService;
import com.coding.module1introduction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO>  signup(@RequestBody SignUpDTO signUpDTO) {

     UserDTO userDTo = authService.signUp(signUpDTO);
     return ResponseEntity.ok(userDTo);
    }
    @PostMapping("/login")
    public ResponseEntity<String>  login(@RequestBody LoginDTO loginDTO) {
        String token = authService.login(loginDTO);
        return ResponseEntity.ok(token);
    } 

}
