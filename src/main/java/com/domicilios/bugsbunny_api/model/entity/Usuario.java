package com.domicilios.bugsbunny_api.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "usuario")
@ToString

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "nombres")
    private String nombres;

    @Getter @Setter @Column(name = "apellidos")
    private String apellidos;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "password")
    private String password;

    @Getter @Setter @Column(name = "celular")
    private String celular;

    @Getter @Setter @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Getter @Setter @Column(name = "genero")
    private String genero;

    @Getter @Setter @Column(name = "fecha_registro")
    private Date fecha_registro;

    @Getter @Setter @Column(name = "celular_verificado")
    private boolean celularVerificado;

    @Getter @Setter @Column(name = "perfil_completo")
    private boolean perfilCompleto;
}
