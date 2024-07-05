package com.concesionario.cursospring.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Instant fecha;
	@Enumerated(EnumType.STRING)
	TipoPago tipoPago;
	Double total;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	Cliente cliente;
	@OneToOne
	@JoinColumn(name = "fk_coche")
	Coche coche;
}
