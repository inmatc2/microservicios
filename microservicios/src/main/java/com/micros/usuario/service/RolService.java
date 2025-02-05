package com.micros.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micros.usuario.entity.Rol;
import com.micros.usuario.repo.RolRepository;

//Servicio para encapsular la lógica de negocio
@Service
public class RolService {
	@Autowired
	private RolRepository rolRepository;

	public void crearRoles() {
		Rol administrador = new Rol();
		administrador.setNombre("ADMIN");
		rolRepository.save(administrador);

		Rol cliente = new Rol();
		cliente.setNombre("CLIENTE");
		rolRepository.save(cliente);
	}
}
