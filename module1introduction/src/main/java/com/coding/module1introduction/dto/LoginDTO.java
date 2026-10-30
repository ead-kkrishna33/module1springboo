package com.coding.module1introduction.dto;

import lombok.*;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@Getter
@Setter
@ToString
public class LoginDTO {
    private String email;
    private String password;
}
