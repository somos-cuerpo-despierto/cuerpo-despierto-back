package com.cuerpodespierto.demo.controller;

import com.cuerpodespierto.demo.model.Usuario;
import com.cuerpodespierto.demo.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
        Usuario usuario = usuarioService.findByEmail(loginRequest.getEmail());
        if (usuario != null && usuario.getPassword().equals(loginRequest.getPassword())) {
            String token = jwtUtil.generateToken(usuario.getEmail(), "USER");
            return ResponseEntity.ok().body(Map.of("token", token, "rol", "USER"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    private String nombre;
    private String apellido;
    private String email;
    private String password;
}