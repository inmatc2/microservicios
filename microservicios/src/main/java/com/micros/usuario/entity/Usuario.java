package com.micros.usuario.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private UUID id;
 
    @Column(name = "nombre", nullable = false)
    private String nombre;
 
    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;
 
    @Column(name = "segundo_apellido")
    private String segundoApellido;
 
    @Column(name = "correo", unique = true, nullable = false)
    private String correo;
 
    @Column(name = "provincia", nullable = false)
    private String provincia;
 
    @Column(name = "edad", nullable = false)
    private Integer edad;
 
    private String username;
    private String password;
    
    @ManyToMany
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Rol> roles;
}
