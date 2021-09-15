package com.example.clase.service;

import java.util.List;
import java.util.Optional;

import com.example.clase.entity.Producto;


public interface ServiceProductos {
	  public abstract List<Producto> listAllProductos();

	  public abstract Optional<Producto> findByIdProducto(Integer id);
 
      public abstract Producto updateProducto(Producto producto);
      
      public abstract int removeProducto(Integer id);
      
      public abstract Producto addProducto(Producto producto);
      
}
