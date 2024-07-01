package com.curso.examen.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    
	int idProducto;
	String producto;
	double precio;
	int idFabricante;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	@Column(name = "producto")
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	@Column(name = "precio")
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Column(name = "fk_fabricante")
	public int getIdFabricante() {
		return idFabricante;
	}
	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", producto=" + producto + ", precio=" + precio + "]";
	}

}
