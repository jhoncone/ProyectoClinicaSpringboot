package com.example.clase.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.Table;


@Entity
@Table(name="USUARIO")

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
		name = "listaproce", 
		procedureName = "lista_procedure", 
		resultClasses = Usuario.class,
		parameters={
			
			@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="cur_c", type=void.class)
			
		}),
	
	@NamedStoredProcedureQuery(
			name = "usuaridproce", 
			procedureName = "userbyid_procedure", 
			resultClasses = Usuario.class,
			parameters={
				
				@StoredProcedureParameter(mode=ParameterMode.IN, name="ids", type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="cur_c", type=void.class)
				
			}),
	@NamedStoredProcedureQuery(
			name = "usuarisaveproce", 
			procedureName = "usersave_procedure", 
			resultClasses = Usuario.class,
			parameters={
				
				@StoredProcedureParameter(mode=ParameterMode.IN, name="ids", type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="idc", type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="tipo", type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="nombre", type=String.class),
				//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="cur_c", type=void.class)
				
			}),
	@NamedStoredProcedureQuery(
			name = "usuariupdproce", 
			procedureName = "userupd_procedure", 
			resultClasses = Usuario.class,
			parameters={
				
				@StoredProcedureParameter(mode=ParameterMode.IN, name="ids", type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="idc", type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="tipo", type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="nombre", type=String.class),
				//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="cur_c", type=void.class)
				
			}),
	@NamedStoredProcedureQuery(
			name = "usuaridelproce", 
			procedureName = "userdel_procedure", 
			resultClasses = Usuario.class,
			parameters={
				
				@StoredProcedureParameter(mode=ParameterMode.IN, name="ids", type=Integer.class),
				//@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="cur_c", type=void.class)
				
			})
	
})



public class Usuario {
	@Id
private int idusuario;
private int idclinica;
private String tipousuario;
private String nombre;

public Usuario() {
	super();
	// TODO Auto-generated constructor stub
}
public Usuario(int idusuario, int idclinica, String tipousuario, String nombre) {
	super();
	this.idusuario = idusuario;
	this.idclinica = idclinica;
	this.tipousuario = tipousuario;
	this.nombre = nombre;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public int getIdclinica() {
	return idclinica;
}
public void setIdclinica(int idclinica) {
	this.idclinica = idclinica;
}
public String getTipousuario() {
	return tipousuario;
}
public void setTipousuario(String tipousuario) {
	this.tipousuario = tipousuario;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
@Override
public String toString() {
	return "Usuario [idusuario=" + idusuario + ", idclinica=" + idclinica + ", tipousuario=" + tipousuario + ", nombre="
			+ nombre + "]";
}


}
