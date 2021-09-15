package com.example.clase.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.clase.entity.Producto;



@Repository("productosRepository")

public interface ProductoRepository extends CrudRepository<Producto,Integer> {

int deleteByid(Integer id);

}
