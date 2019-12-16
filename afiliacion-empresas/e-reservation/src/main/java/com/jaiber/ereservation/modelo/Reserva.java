package com.jaiber.ereservation.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla reserva
 * 
 * @author jsernai
 *
 */
@Data
@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idReserva;
	/**
	 * En JPA las fechas se tratan diferente por sus tipos de formatos, entonces toca definirle la fecha, si es con hora, o solo la hora o la fehca
	 * normal
	 */
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;
	@Temporal(TemporalType.DATE)
	private Date fechaSalida;
	private int cantdadPersonas;
	private String descripcion;
	@ManyToOne
	/**
	 * Se especifica la columna a la cual esta baja por base de datos como foreign key
	 */
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	public Reserva() {
		// TODO Auto-generated constructor stub
	}
}
