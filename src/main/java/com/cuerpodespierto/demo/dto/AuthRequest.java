package com.cuerpodespierto.demo.dto;

import lombok.*;

@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
}