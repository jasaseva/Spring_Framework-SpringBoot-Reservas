/**
 * 
 */
package com.jaiber.ereservation.negocio.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaiber.ereservation.modelo.Cliente;
import com.jaiber.ereservation.negocio.repository.ClienteRepository;

/**
 * Clase para definir los servicios de cliente
 * 
 * @author jsernai
 *
 */

/**
 * Como bien dice la documentación de Spring, @Component es el estereotipo principal e indica que una clase con esta anotación es un component o Bean
 * de Spring.
 * 
 * @Repository, @Service y @Controller son especificaciones de la anotación @Component para casos concretos, por ejemplo, para la persistencia de
 * datos, servicios o para la capa de presentación respectivamente.
 * 
 * Por lo tanto, puedes anotar tus beans con la anotación @Component, pero al anotarlas con @Repository, @Service o @Controller obtendrás beneficios
 * adicionales ya que algunos de los Spring modules procesan de manera distinta estas anotaciones.
 * 
 * Generalmente puedes utilitzar una en lugar de otra, pero no es recomendado que lo hagas.
 * 
 * Spring ofrece una serie de anotaciones estándar para los objetos de nuestra aplicación: por ejemplo, @Service indica que la clase es un bean de la
 * capa de negocio, mientras que @Repository indica que es un DAO. Si simplemente queremos especificar que algo es un bean sin decir de qué tipo es
 * podemos usar la anotación @Component
 */
@Service
//Todos los metodos que no esten anotados con transacional se van a manejar como modo lectura
@Transactional(readOnly = true)
public class ClienteService {
	private final ClienteRepository clienteRepository;

	// Se define el constructor, para que el que lleva se asocie con el que definimos en la clase.
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	/**
	 * 
	 * Definimos metodo o servicio que creara cliente utilizando nuestra operaciones crud que expone el repository
	 * 
	 * <p>
	 * Este metodo realiza la operacion de guardar o actualizar dependiendo de de que si suo o no
	 *
	 * @author <a href="http://www.comfenalcoantioquia.com/">comfenalco antioquia</a> jsernai
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * 
	 * Se elimina cliente
	 * <p>
	 * Metodo utiliza para eliminar el cliente, se debe enviar en la entidad el id
	 *
	 * @author <a href="http://www.comfenalcoantioquia.com/">comfenalco antioquia</a> jsernai
	 */
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	/**
	 * 
	 * Consulta cliente
	 * <p>
	 * Metodo utilizado para consultar el cliente por identificacion
	 *
	 * @author <a href="http://www.comfenalcoantioquia.com/">comfenalco antioquia</a> jsernai
	 */
	public Cliente findByIdentificacion(String identificacion) {
		return this.clienteRepository.findByIdentificacion(identificacion);
	}

}
