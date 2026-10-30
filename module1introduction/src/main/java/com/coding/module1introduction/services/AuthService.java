package com.coding.module1introduction.services;

import com.coding.module1introduction.dto.LoginDTO;
import com.coding.module1introduction.dto.SignUpDTO;
import com.coding.module1introduction.dto.UserDTO;
import com.coding.module1introduction.entities.UserEntity;
import com.coding.module1introduction.repositories.AuthRepository;
import com.coding.module1introduction.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    AuthRepository authRepository;
    @Autowired
     ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private  final JWTService jwtService;

    public UserDTO signUp(SignUpDTO signUpDTO) {
        Optional<UserEntity> user= authRepository.findByEmail(signUpDTO.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("User already exists pls Login..!!"+signUpDTO.getEmail());
        }else {
            UserEntity createNewUserEntity = modelMapper.map(signUpDTO, UserEntity.class);
            createNewUserEntity.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
            UserEntity savedUserEntity = authRepository.save(createNewUserEntity);
            return modelMapper.map(savedUserEntity,UserDTO.class);
        }
    }

    public String login(LoginDTO loginDTO) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        UserEntity user=(UserEntity) authenticate.getPrincipal();

        return jwtService.generateToken(user);
    }
}
