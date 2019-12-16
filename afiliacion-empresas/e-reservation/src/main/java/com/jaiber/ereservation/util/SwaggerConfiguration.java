package com.jaiber.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase para configurar Swagger
 * 
 * @author jsernai
 *
 */
@Configuration
// SE HABILITA LA CONFIGURACION DE SWAGGER
@EnableSwagger2
public class SwaggerConfiguration {

	/*
	 * Docket es un objeto que permite habilitar la documentacion--Un generador que pretende ser la interfaz principal en el marco de Springfox.
	 * Proporciona valores predeterminados razonables y métodos convenientes para la configuración.
	 */
	public Docket documentation() {
		/*
		 * Se define a donde vamos a enlazar la documentacion, decimos que las clases con anotaciones RestController se le haga la documentacion
		 */
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any()).build();
	}
}
