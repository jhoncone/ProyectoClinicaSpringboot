package com.example.clase.repository.sps;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.example.clase.entity.Usuario;


public class UsuarioRepositoryCustomImpl implements UsuarioRepositoryCustom{
 
	
	@PersistenceContext
	private EntityManager um;
	
	@Override
	
	public List<Usuario> getUsuarioDetail(){
		List<Usuario> usuarios=new ArrayList<Usuario>();
		
		try {
			StoredProcedureQuery query =this.um.createNamedStoredProcedureQuery("listaproce");
			query.execute();
			
			ResultSet rs=(ResultSet) query.getOutputParameterValue("cur_c");
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}
		return usuarios;
	}
	
	
	
}
