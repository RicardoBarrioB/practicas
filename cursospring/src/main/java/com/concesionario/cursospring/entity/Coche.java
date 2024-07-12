package com.concesionario.cursospring.entity;

import java.io.Serializable;
import java.time.YearMonth;

import com.concesionario.cursospring.entity.enumeration.Combustible;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coche")
public class Coche implements Serializable{

	private Long id;
	private String marca;
	private String modelo;
	private String color;
	private String matricula;
	@Enumerated(EnumType.STRING)
	private Combustible combustible;
	private String pegatina;
	private String numeroSerie;
	private Double precio = 0.0;
	private Boolean exposicion;
	private YearMonth fechaItv;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "marca")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Column(name = "modelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "matricula")
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Column(name = "combustible")
	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}

	@Column(name = "pegatina")
	public String getPegatina() {
		return pegatina;
	}

	public void setPegatina(String pegatina) {
        this.pegatina = pegatina;
    }

	@Column(name = "numSerie")
	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	@Column(name = "precio")
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Column(name = "exposicion")
	public Boolean getExposicion() {
		return exposicion;
	}

	public void setExposicion(Boolean exposicion) {
		this.exposicion = exposicion;
	}

	@Column(name = "Fecha_ITV")
	public YearMonth getFechaItv() {
		return fechaItv;
	}

	public void setFechaItv(YearMonth fechaItv) {
		this.fechaItv = fechaItv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Coche other = (Coche) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + "]";
	}

}
