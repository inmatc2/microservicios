package com.micros.usuario.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micros.usuario.entity.Rol;
import com.micros.usuario.entity.Usuario;
import com.micros.usuario.repo.RolRepository;
import com.micros.usuario.repo.UsuarioRepository;

//Servicio para encapsular la lógica de negocio
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolRepository rolRepository;

	// Solo cliente
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// Solo cliente
	public Usuario actualizarUsuario(UUID id, Usuario usuario) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
		if (usuarioExistente != null) {
			usuarioExistente.setNombre(usuario.getNombre());
			usuarioExistente.setPrimerApellido(usuario.getPrimerApellido());
			usuarioExistente.setSegundoApellido(usuario.getSegundoApellido());
			usuarioExistente.setCorreo(usuario.getCorreo());
			usuarioExistente.setProvincia(usuario.getProvincia());
			usuarioExistente.setEdad(usuario.getEdad());
			return usuarioRepository.save(usuarioExistente);
		} else {
			return null;
		}
	}

	// Solo adminitrador
	public Usuario obtenerUsuario(UUID id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	// Solo adminitrador
	public void eliminarUsuario(UUID id) {
		usuarioRepository.deleteById(id);
	}
	
	public void asignarRol(Usuario usuario, String rolNombre) {
        Rol rol = rolRepository.findByNombre(rolNombre);
        if (rol != null) {
            usuario.getRoles().add(rol);
            usuarioRepository.save(usuario);
        }
    }
}
