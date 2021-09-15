package com.example.clase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.clase.service.UsuarioService;

import java.util.List;
import java.util.Optional;

import com.example.clase.entity.Producto;
import com.example.clase.entity.Usuario;

@RestController
@RequestMapping("/usuario")

@CrossOrigin(origins="http://localhost:3000/")
public class ControllerUsuario {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Usuario>> lista(){
		List<Usuario> lista=usuarioService.lista();
		return new ResponseEntity(lista,HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Usuario> userbyid(@PathVariable("id") int id){
		Usuario usuari;
	
		usuari=usuarioService.getByIdusuario(id);
		
		return new ResponseEntity(usuari,HttpStatus.OK);
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> save(@RequestBody Usuario usuario){
	 usuarioService.addusuario(usuario);
		
		return new ResponseEntity("usuari guardado",HttpStatus.CREATED);
	}
	
	
	@DeleteMapping(path="/del/{id}")
	public  ResponseEntity<Usuario> delet(@PathVariable("id") int id){
		usuarioService.delusuario(id);
		return new ResponseEntity("del",HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/upd")
	public ResponseEntity<?> upduser(@RequestBody Usuario usuario){
	 usuarioService.updusuario(usuario);
		
		return new ResponseEntity("usuari modificado",HttpStatus.ACCEPTED);
	}
	
}
