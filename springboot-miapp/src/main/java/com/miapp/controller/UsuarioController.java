package com.miapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miapp.model.Usuario;
import com.miapp.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	 @Autowired
	    private UsuarioService usuarioService;

	    @GetMapping
	    public List<Usuario> listarUsuarios() {
	        return usuarioService.obtenerTodosLosUsuarios();
	    }

	    @GetMapping("/{id}")
	    public Usuario obtenerUsuario(@PathVariable Long id) {
	        return usuarioService.obtenerUsuarioPorId(id);
	    }

	    @PostMapping
	    public Usuario crearUsuario(@RequestBody Usuario usuario) {
	        return usuarioService.guardarUsuario(usuario);
	    }

	    @DeleteMapping("/{id}")
	    public void eliminarUsuario(@PathVariable Long id) {
	        usuarioService.eliminarUsuario(id);
	    }
}
