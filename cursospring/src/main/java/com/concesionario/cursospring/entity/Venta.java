package com.concesionario.cursospring.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.concesionario.cursospring.entity.enumeration.TipoPago;

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
	private Long id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDate fecha;
	@Enumerated(EnumType.STRING)
	private TipoPago tipoPago;
	private Double total;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name = "fk_coche")
	private Coche coche;
}
