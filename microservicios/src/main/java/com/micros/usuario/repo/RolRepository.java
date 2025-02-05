package com.micros.usuario.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micros.usuario.entity.Rol;

//Repositorio para interactuar con la base de datos
public interface RolRepository extends JpaRepository<Rol, Long> {

	Rol findByNombre(String rolNombre);
}
