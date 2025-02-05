package com.micros.usuario.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micros.usuario.entity.Usuario;

//Repositorio para interactuar con la base de datos
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
