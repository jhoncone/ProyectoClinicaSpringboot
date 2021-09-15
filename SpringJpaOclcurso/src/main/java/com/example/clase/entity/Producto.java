package com.example.clase.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="PRODUCTO")


public class Producto {
	 @Id
		// @Column(name="id")
		private int id;
		private String tipo;
		private String nombre;
		private int stock;

		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


		public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}

		@Override
		public String toString() {
			return "productos [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", stock=" + stock + "]";
		}

}
