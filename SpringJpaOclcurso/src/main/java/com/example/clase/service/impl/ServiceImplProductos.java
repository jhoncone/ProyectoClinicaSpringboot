package com.example.clase.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.clase.entity.Producto;
import com.example.clase.repository.ProductoRepository;
import com.example.clase.service.ServiceProductos;



@Service("productosServiceImpl")
@Transactional
public class ServiceImplProductos implements ServiceProductos{

	@Autowired
	@Qualifier("productosRepository")
	
	private ProductoRepository repositoryProductos;
	
	@Override
	public List<Producto> listAllProductos() {
		// TODO Auto-generated method stub
		return (List<Producto>) repositoryProductos.findAll();
	}


	@Override
	public Optional<Producto> findByIdProducto(Integer id) {
		
		// TODO Auto-generated method stub
		return repositoryProductos.findById(id);
	}


	@Override
	public Producto updateProducto(Producto producto) {
		// TODO Auto-generated method stub
		return repositoryProductos.save(producto);
	}


	@Override
	public int removeProducto(Integer id) {
		// TODO Auto-generated method stub
		return repositoryProductos.deleteByid(id);
	}


	@Override
	public Producto addProducto(Producto producto) {
		// TODO Auto-generated method stub
		
		return repositoryProductos.save(producto);
	}

}
