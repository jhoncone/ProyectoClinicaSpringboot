package com.example.clase.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.clase.entity.Usuario;
import com.example.clase.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
@Service
public class UsuarioService {
	@Autowired
    UsuarioRepository usuarioRepository;
	@PersistenceContext
	private EntityManager um;
	
	public List<Usuario> lista(){
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
	
	public Usuario getByIdusuario(int id){
	
		Usuario usuari=null;
		try {
			StoredProcedureQuery query =this.um.createNamedStoredProcedureQuery("usuaridproce");
			query.setParameter("ids", id);
			query.execute();
			
			ResultSet rs=(ResultSet) query.getOutputParameterValue("cur_c");
			while(rs.next()) {
			usuari=new Usuario(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
			}
		    
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}
		return usuari;
		
		
	}
	
	public void addusuario(Usuario usuario ){
		
		StoredProcedureQuery query =this.um.createNamedStoredProcedureQuery("usuarisaveproce");
		query.setParameter("ids", usuario.getIdusuario());
		query.setParameter("idc", usuario.getIdclinica());
		query.setParameter("tipo", usuario.getTipousuario());
		query.setParameter("nombre", usuario.getNombre());
		query.execute();
	
	}

	public void delusuario(int id) {
		// TODO Auto-generated method stub
		StoredProcedureQuery query =this.um.createNamedStoredProcedureQuery("usuaridelproce");
		query.setParameter("ids",id);
		
		query.execute();
		
	}
	
	public void updusuario(Usuario usuario ){
		
		StoredProcedureQuery query =this.um.createNamedStoredProcedureQuery("usuariupdproce");
		query.setParameter("ids", usuario.getIdusuario());
		query.setParameter("idc", usuario.getIdclinica());
		query.setParameter("tipo", usuario.getTipousuario());
		query.setParameter("nombre", usuario.getNombre());
		query.execute();
	
	}
}
