/**
 * 
 */
package com.jaiber.ereservation.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * clase que representa la tabla cliente
 * 
 * @author jsernai
 *
 */
@Data
/**
 * Anotacion Entity que le da soporte a nuestra clase para que represente una tabla de la base de datos, sin esta anotacion todo el mapeo no tendria
 * ningun objetivo
 */
@Entity
/**
 * anotacion que me indica a cual tabla va a mapearse
 */
@Table(name = "cliente")
/**
 * Anotacion para escribir nuestro propio sql en lenguaje JPQL, la diferencia de SQL es que este no trabaja con tablas sino con los objetos
 */
@NamedQuery(name = "Cliente.findByIdentificacion", query = "SELECT c FROM Cliente c WHERE c.identificacion = ?1")
public class Cliente {
	/**
	 * Anotacion utilizada para manejar todo el tema del id de la tabla
	 */
	@Id
	/**
	 * anotacion para generar el id autoincremental en (generator=)va el correspondiente a la base de datos, para postgres, oracle, sqlserver entre
	 * otras. es la manera en como se va a generar este valor
	 */
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCliente;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String direccion;
	private String telefono;
	private String email;
	/**
	 * Con esta anotacion indicamos la relacion entre tablas, en este caso es uno a muchos indicando que un cliente puede tener muchas reservas, pero
	 * esto es bidireccional así que en la clase reserva debe estar marcada la llave de muchos a uno
	 */
	@OneToMany(mappedBy = "cliente")
	private Set<Reserva> listReserva;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
}
