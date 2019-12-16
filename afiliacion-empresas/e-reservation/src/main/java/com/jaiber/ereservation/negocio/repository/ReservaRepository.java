/**
 * 
 */
package com.jaiber.ereservation.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaiber.ereservation.modelo.Reserva;

/**
 * Interface para definir las operaciones de bd relacionadas con Reserva
 * 
 * @author jsernai
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva, String> {

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFinal
	 * @return
	 */
	@Query("SELECT r FROM Reserva r WHERE r.fechaIngreso =:fechaInicio and r.fechaIngreso =:fechaFinal")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaInicio") Date fechaFinal);
}
