package com.micros.usuario.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micros.usuario.entity.Usuario;
import com.micros.usuario.service.UsuarioService;


//Controlador para manejar las solicitudes HTTP
@RestController
@RequestMapping("/usuarios")
/**
 *   Endpoints
 *   POST /usuarios
    PUT /usuarios/{id}
    GET /usuarios/{id}
    DELETE /usuarios/{id} 
 */
public class UsuarioController {
 
    @Autowired
    private UsuarioService usuarioService;
 
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }
 
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable UUID id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }
 
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable UUID id) {
        return usuarioService.obtenerUsuario(id);
    }
 
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable UUID id) {
        usuarioService.eliminarUsuario(id);
    }
}
