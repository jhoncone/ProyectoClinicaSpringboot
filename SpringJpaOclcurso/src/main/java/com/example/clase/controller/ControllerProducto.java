package com.example.clase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clase.entity.Producto;
import com.example.clase.service.impl.ServiceImplProductos;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins="http://localhost:3000/")
public class ControllerProducto {

	@Autowired
	@Qualifier("productosServiceImpl")
	
	private ServiceImplProductos  productosService;
	
	@GetMapping(path="/list/",produces= {"application/json"})
	public List<Producto> listProductos(){
		return productosService.listAllProductos();
	}
	
	@GetMapping(path="/get/{id}",produces= {"application/json"})
	public Optional<Producto> getProductos(@PathVariable Integer id){
		return productosService.findByIdProducto(id);
	}
	
	@PutMapping(path="/upd/",produces= {"application/json"})
	public Producto updProductos(@RequestBody Producto producto){
		//
		producto.setId(producto.getId());
		producto.setTipo(producto.getTipo());
		producto.setNombre(producto.getNombre());
		producto.setStock(producto.getStock());
		//
		return productosService.updateProducto(producto);
	}
	
	
	@DeleteMapping(path="/del/{id}",produces= {"application/json"})
	public int delProductos(@PathVariable Integer id){
		return productosService.removeProducto(id);
	}
	
	@PostMapping(path="/new/",produces= {"application/json"})
	public Producto addProductos(@RequestBody Producto producto){
		return productosService.addProducto(producto);
	}
	
	
	
	
}
