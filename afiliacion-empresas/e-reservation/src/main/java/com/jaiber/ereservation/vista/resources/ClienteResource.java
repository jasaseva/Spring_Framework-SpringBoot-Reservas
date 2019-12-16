/**
 * 
 */
package com.jaiber.ereservation.vista.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que representa el servicio web de cliente
 * 
 * @author jsernai
 *
 */
// Es la anotacion en la cual determinamos que nuestra clase va hacer tratada como servicio web
@RestController
/*
 * Para poder recibir el tema de las peticiones ya que un servicio web se disponibiliza en una url y es utilizado o consumido por otras aplicaciones,
 * entonces para poder habilitar el tema de que pueda ser consumido por otras aplicaciones u otros programas utilizamos esta anotacion
 */
@RequestMapping("/api/cliente")
public class ClienteResource {

}
