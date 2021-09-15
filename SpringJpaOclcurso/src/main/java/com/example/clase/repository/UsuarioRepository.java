package com.example.clase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.clase.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

	//@Query(value="{call _procedure()}",nativeQuery=true)
	//List<Usuario> listaProcedure();
	
	//Optional<Usuario> idProcedure(int id);
}
