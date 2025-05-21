package com.cuerpodespierto.demo.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "administrators")
@Getter
@Setter
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

}