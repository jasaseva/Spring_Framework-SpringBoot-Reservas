/*
 * PropertiesManager.java
 *
 * Creada el 16 de abril de 2007, 02:59 PM
 *
 */
package com.comfenalcoantioquia.transversal.utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * Esta clase administra la informacion contenida en los properties. Pone a disposicion la funcionalidad de consultar de un properties por una clave
 * especifica sin que el archivo tenga que ser cargado una y otra vez en los diferentes metodos de la aplicacion (como generalmente se hac�a con los
 * DAO).
 * 
 * @author Quipux S.A.
 * @modify 16/04/2007
 * @modify 28/04/2014
 * @modify 29/07/2014
 */
public class PropertiesManager {

	// private static Logger logger = LoggerFactory.getLogger(PropertiesManager.class);
	/**
	 * HashMap para almacenar los archivos, usando como llave el nombre del archivo
	 */
	private static Map<String, Properties> table = new HashMap<>();
	public static String ambiente;

	private static final String DESARROLLO = "DESARROLLO";

	/**
	 * Permite clasificar un sql deacuerdo a si se debe ejecutar en una base de datos cuya estructura contempla el uso de esquemas en cada entidad de
	 * tr�nsito.
	 * 
	 * @param sql
	 * @param idOrganismoTransito
	 * @return String
	 */
	private static String filtrarSql(String sql, String idOrganismoTransito) {
		String sqlFiltrado;
		if (idOrganismoTransito != null && !"".equals(idOrganismoTransito.trim())) {
			sqlFiltrado = sql.replaceAll("<SCHEMA>", idOrganismoTransito);
		} else {
			sqlFiltrado = sql.replaceAll("_<SCHEMA>", "");
		}
		return sqlFiltrado;
	}

	/**
	 * Creado el Sep 15, 2016 a las 6:57:34 AM <br>
	 * 
	 * @param loader
	 * @param nombreArchivo
	 * @return
	 * @throws IOException
	 */
	private static Properties loadProperties(ClassLoader loader, String nombreArchivo) throws IOException {
		Properties properties = null;
		InputStream inputStream = null;
		try {
			inputStream = loader.getResourceAsStream(nombreArchivo);
			if (inputStream == null) {
				return null;
			}
			properties = new Properties();
			// load a properties file from class path, inside static method
			properties.load(inputStream);
		} catch (IOException ex) {
			throw new IOException(ex.getMessage(), ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					throw new IOException(e.getMessage(), e);
				}
			}
		}
		return properties;
	}

	/**
	 * Creado el Sep 15, 2016 a las 6:57:46 AM <br>
	 * 
	 * @param nombreArchivo
	 * @return
	 * @throws IOException
	 */
	private static Properties loadPropertiesFile(String nombreArchivo) throws IOException {
		FileInputStream fileInputStream = null;
		Properties properties = null;
		try {
			fileInputStream = new FileInputStream(nombreArchivo.replace("%20", " "));
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			throw new IOException(e.getMessage(), e);
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					throw new IOException(e.getMessage(), e);
				}
			}
		}
		return properties;
	}

	/**
	 * Obtiene una propiedad de un archivo almacenado en disco
	 * 
	 * @param urlFile
	 * @param nombreClave
	 * @return
	 */
	public static String obtenerCadenaExterna(String urlFile, String nombreClave) {
		String propertie = "";
		// Intento obtener el archivo del hashtable
		Properties properties = table.get(urlFile);
		// Si no logr� obtener el archivo de la tabla, entonces lo cargo
		try {
			if (properties == null || DESARROLLO.equals(ambiente)) {
				properties = loadPropertiesFile(urlFile);
				table.put(urlFile, properties);
			}
			// Retorno el string asociado a la cadena especificada
			if (properties.containsKey(nombreClave)) {
				propertie = properties.getProperty(nombreClave);
			} else {
				propertie = "Propiedad " + nombreClave + " no encontrada en " + urlFile;
			}
		} catch (Exception e) {
			// logger.error(e.getMessage(), e);
			e.getMessage();
			return "Propiedad " + nombreClave + " no encontrada en " + urlFile;
		}
		return propertie;
	}

	/**
	 * Metodo que toma una cadena y un array de parametros y reemplaza los valores
	 * 
	 * @param cadena
	 * @param varArgs
	 * @return
	 */
	private static String reemplazarParametros(String cadena, Object[] varArgs) {
		String valorParametro = cadena;
		for (int i = 0; i < varArgs.length; i++) {
			valorParametro = valorParametro.replace("{" + i + "}", "" + varArgs[i]);
		}
		return valorParametro;
	}
}