package com.example.clase.repository.sps;

import org.springframework.stereotype.Repository;

import com.example.clase.entity.Usuario;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UsuarioRepositorySP extends CrudRepository<Usuario,Integer>, UsuarioRepositoryCustom{
	//@Procedure(name="listaproce")
	//@Transactional
	
	
}
