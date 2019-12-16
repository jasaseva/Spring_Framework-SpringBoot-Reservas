package com.comfenalcoantioquia.transversal.utilidades;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.io.IOUtils;

import com.comfenalcoantioquia.transversal.constantes.Constantes.ExpresionesRegulares;

public class QxUtil extends QxDate {

	private static final int LIMITE_EXPEPTION_CODE = 99999;

	private static final int NUMBER_CEROS_CODE_EXCEPTION = 5;

	/**
	 * Longitud del <code>salt</code>. Igual al tamao del resultado del algoritmo.
	 */
	public static final int SALT_LENGTH = 16;

	/**
	 * Metodo que se encarga de agregar a la izquierda del valor recibido una cantidad de ceros
	 * 
	 * @param numericValue
	 * @param numberCeros
	 * @return value
	 */
	public static String addCerosLeft(int numericValue, int numberCeros) {
		StringBuilder formato = new StringBuilder();
		for (int i = 0; i < numberCeros; i++) {
			formato.append("0");
		}
		DecimalFormat format = new DecimalFormat(formato.toString());

		return format.format(numericValue);
	}

	/**
	 * Metodo que se encarga de agregar a la izquierda del valor recibido una cantidad de ceros
	 * 
	 * @param numericValue
	 * @param numberCeros
	 * @return value
	 */
	public static String addCerosLeft(long numericValue, int numberCeros) {
		StringBuilder formato = new StringBuilder();
		for (int i = 0; i < numberCeros; i++) {
			formato.append("0");
		}
		DecimalFormat format = new DecimalFormat(formato.toString());

		return format.format(numericValue);
	}

	/**
	 * Metodo que se encarga de agregar a la izquierda del valor recibido una cantidad de ceros
	 * 
	 * @param numericValue
	 * @param numberCeros
	 * @return value
	 */
	public static String addCerosLeft(String numericValue, int numberCeros) {
		String value = numericValue;
		if (value.length() < numberCeros) {
			while (value.length() < numberCeros) {
				value = "0" + value;
			}
		}
		return value;
	}

	public static String addEspacioLeft(String texto, int espacios) {
		StringBuilder build = new StringBuilder();
		while (texto.length() < espacios) {
			build.append(" ");
		}
		build.append(texto);
		return build.toString();
	}

	/**
	 * Calcula el descuento de un valor determinado Creado el 27/09/2013 a las 18:58:00 <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param valorTotal valor al que se le desea calcular el descuento
	 * @param porcentajeDescuento porcentaje descuento
	 * @param cifrasRedondeo cantidad de cifras que se desea aproximar
	 * @return
	 */
	public static BigDecimal calcularDescuento(BigDecimal valorTotal, Double porcentajeDescuento, int cifrasRedondeo) {
		double valorPorcentaje = porcentajeDescuento / 100;
		BigDecimal x = new BigDecimal(valorPorcentaje);
		MathContext mc = new MathContext(cifrasRedondeo);
		return x.multiply(valorTotal).round(mc);
	}

	/**
	 * Crea un directorio. En caso de que ya exista retorna true. Retorna true si fue posible crearlo, de lo contrario retorna false.
	 * 
	 * @param path
	 * @return
	 */
	public static boolean createDirectory(String path) {
		File myDir = new File(path);
		if (!myDir.isDirectory()) {
			return myDir.mkdir();
		}
		return true;
	}

	public static void fileCopy(String sourceFile, String destinationFile, File myDir) {
		FileInputStream entrada = null;
		FileOutputStream salida = null;
		try {
			File inFile = new File(sourceFile);
			File outFile = new File(myDir, destinationFile);
			entrada = new FileInputStream(inFile);
			salida = new FileOutputStream(outFile);
			FileChannel in = entrada.getChannel();
			FileChannel out = salida.getChannel();
			in.transferTo(0, inFile.length(), out);
			in.close();
			out.close();
		} catch (IOException e) {
			e.getMessage();
		} finally {
			IOUtils.closeQuietly(salida);
			IOUtils.closeQuietly(entrada);
		}
	}

	/**
	 * Metodo que se encarga de generar el Salt para el cifrado de los documentos
	 * 
	 * @return salt
	 */
	public static byte[] generateSalt() {

		final byte[] salt = new byte[SALT_LENGTH];
		final SecureRandom rnd = new SecureRandom();
		rnd.nextBytes(salt);
		return salt;
	}

	/**
	 * Metodo que recupera un texto en capital Case
	 * 
	 * @param text
	 * @return textCapital
	 */
	public static String getCapitalCase(String text) {
		if (text.length() == 0)
			return text;
		return text.substring(0, 1).toUpperCase() + text.substring(1);
	}

	/**
	 * Metodo que tiene por responsabilidad agregar el formato adecuado a los codigo de excepcion. Sera llamado desde los try/catch de los Command y
	 * el resultado sera algo como 00001-12345: Se presento un error al insertar la informacion.
	 * 
	 * @param excepcionConstant
	 * @return exceptionCode
	 */
	public static String getErrorCode(String excepcionConstant) {
		int code = (int) (Math.random() * LIMITE_EXPEPTION_CODE + 1);
		return (excepcionConstant + "-" + addCerosLeft(code, NUMBER_CEROS_CODE_EXCEPTION));
	}

	public static String getFileExtension(String fileName) {
		fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		return extension.substring(extension.lastIndexOf(".") + 1).toLowerCase();
	}

	/**
	 * Metodo que tiene por responsabilidad generar el nombre de los documentos almacenados en gestion documental
	 * 
	 * @return fileName
	 */
	public static String getFileName() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

	public static String getLocalIPAddress() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		// Get IP Address
		return addr.getHostAddress();

	}

	public static String getNombreDataTransferObject(String nombre, boolean capitalized) {
		// Solo procesa textos que sean solo mayusculas o solo minusculas o que contengan "_"
		if ((nombre.equals(nombre.toLowerCase())) || (nombre.equals(nombre.toUpperCase())) || (nombre.indexOf("_") > -1)) {
			int i = 0;
			nombre = nombre.toLowerCase();
			if (nombre.length() == 0) {
				return nombre;
			}
			while (i != -1) {
				i = nombre.indexOf('_');
				if (i == -1) {
					break;
				}
				nombre = nombre.substring(0, i) + nombre.substring((i + 1), (i + 2)).toUpperCase() + nombre.substring((i + 2), nombre.length());
			}
		}
		if (capitalized) {
			nombre = getCapitalCase(nombre);
		} else {
			nombre = nombre.substring(0, 1).toLowerCase() + nombre.substring(1);
		}
		return nombre;
	}

	public static String getNroOficio(String oficio, long num) {
		DecimalFormat format = new DecimalFormat("0000000000");
		return oficio + format.format(num);
	}

	public static String getStringLength(String cadena, int length) {
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < length; i++) {
			build.append(cadena);
		}
		return build.toString();
	}

	public static String getStringSpaceAdd(String str, int length) {
		StringBuilder build = new StringBuilder(str);
		if (build.length() <= length) {
			build.append(getStringLength(" ", length - build.length()));
		} else {
			build = new StringBuilder(build.substring(0, length));
		}
		return build.toString();
	}

	/**
	 * Obtiene una lista de listas de T <br>
	 * Creado el 21/05/2013 a las 16:40:56 <br>
	 * 
	 * @param list
	 * @param maxRegistros
	 * @return
	 */
	public static <T> List<List<T>> getSubList(List<T> list, Integer maxRegistros) {
		List<List<T>> listPaquetes = new ArrayList<List<T>>();
		int size = list.size();
		// Se obtiene el numero de formularios necesarias para el total de registros
		if (size > maxRegistros) {
			int paquetes = size / maxRegistros;
			if (size % maxRegistros != 0) {
				++paquetes;
			}
			int regActual = 0;
			List<T> subList = null;
			// Se obtienen las sublistas para adicionar a cada paquete
			// Este ciclo genera la cantidad de formularios obtenida en la variable: paquetes
			for (int i = 0; i < paquetes; i++) {
				subList = new ArrayList<T>();
				if (i == 0) {
					subList = list.subList(i, maxRegistros);
					regActual = maxRegistros;
				} else {
					if (regActual + maxRegistros >= size) {
						subList = list.subList(regActual, size);
					} else {
						subList = list.subList(regActual, regActual + maxRegistros);
						regActual += maxRegistros;
					}
				}
				listPaquetes.add(subList);
			}
		} else {
			listPaquetes.add(list);
		}
		return listPaquetes;
	}

	public static String getUtil() {
		return "Util";
	}

	/**
	 * Metodo que valida que si el valor isEmptyNull regresa un BigDecimal con una instancia 0, sino con su valor que llega <br>
	 * Creado el 8/11/2018 a las 1:33:05 p. m. <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param newValue
	 * @param oldValue
	 * @return
	 */
	public static BigDecimal getValue(BigDecimal value) {
		BigDecimal decimal = BigDecimal.ZERO;
		if (!(value == null || value.equals(BigDecimal.ZERO))) {
			decimal = decimal.add(value);
		}
		return decimal;
	}

	/**
	 * Metodo que valida que si el valor nuevo isEmptyNull entonces regresa el valor viejo <br>
	 * Creado el 8/11/2018 a las 1:33:05 p. m. <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param newValue
	 * @param oldValue
	 * @return
	 */
	public static BigDecimal getValue(BigDecimal newValue, BigDecimal oldValue) {
		return (newValue == null || newValue.equals(BigDecimal.ZERO) ? oldValue : newValue);
	}

	/**
	 * Metodo que valida que si el valor nuevo isEmptyNull entonces regresa el valor viejo o valor que se quiera devolver por defecto en Date <br>
	 * Creado el 15/03/2019 a las 2:38:33 p. m. <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param newValue
	 * @param oldValue
	 * @return
	 */
	public static Date getValue(Date newValue, Date oldValue) {
		return (newValue == null ? oldValue : newValue);
	}

	/**
	 * Metodo que valida que si el valor nuevo isEmptyNull entonces regresa el valor viejo o valor que se quiera devolver por defecto en Integer<br>
	 * Creado el 8/11/2018 a las 1:33:05 p. m. <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param newValue
	 * @param oldValue
	 * @return
	 */
	public static Integer getValue(Integer newValue, Integer oldValue) {
		return (newValue == null || newValue == 0 ? oldValue : newValue);
	}

	/**
	 * Metodo que valida que si el valor nuevo isEmptyNull entonces regresa el valor viejo en Long<br>
	 * Creado el 8/11/2018 a las 1:33:05 p. m. <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param newValue
	 * @param oldValue
	 * @return
	 */
	public static Long getValue(Long newValue, Long oldValue) {
		return (newValue == null || newValue == 0 ? oldValue : newValue);
	}

	/**
	 * Metodo que valida que si el valor nuevo isEmptyNull entonces regresa el valor viejo en String<br>
	 * Creado el 18/11/2018 a las 6:07:55 p. m. <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param newValue
	 * @param oldValue
	 * @return
	 */
	public static String getValue(String newValue, String oldValue) {
		return (newValue == null || newValue.isEmpty() ? oldValue : newValue);
	}

	/**
	 * Retorna true si es caracter alfanumerico, incluido el de subrayado.
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isAlphabetic(String valor) {
		Pattern p = Pattern.compile("^[a-zA-Z]*$");
		Matcher matcher = p.matcher(valor);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna true si es caracter alfanumerico, incluido el de subrayado.
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isAlphanumeric(String valor) {
		boolean isValid = false;
		if (!isEmptyNull(valor)) {
			Pattern p = Pattern.compile("\\w*");
			Matcher matcher = p.matcher(valor);
			if (matcher.matches()) {
				isValid = true;
			}
		}
		return isValid;

	}

	/*
	 * Valida si una cadena es double
	 */
	public static boolean isDouble(String cadena) {
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Metodo que valida null en BigDecimal
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(BigDecimal valor) {
		return (valor == null || valor.equals(BigDecimal.ZERO) ? true : false);
	}

	/**
	 * Metodo que valida null o vacio en byte[]
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(byte[] valor) {
		return (valor == null || valor.length < 1 ? true : false);
	}

	/**
	 * Metodo que valida null en Date
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(Date valor) {
		return (valor == null ? true : false);
	}

	/**
	 * Metodo que valida null en double
	 * 
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(double valor) {
		return (valor == 0 ? true : false);
	}

	/**
	 * Metodo que valida null en Double
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(Double valor) {
		return (valor == null || valor == 0 ? true : false);
	}

	/**
	 * Metodo que valida null en Float
	 * 
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(Float valor) {
		return (valor == null || valor == 0 ? true : false);
	}

	/**
	 * Metodo que valida null o vacio en entero
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(int valor) {
		return (valor == 0 ? true : false);
	}

	/**
	 * Metodo que valida null o cero(0) en Integer <br>
	 * Creado el 5/06/2012 a las 12:10:18 <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(Integer valor) {
		return (valor == null || valor == 0 ? true : false);
	}

	/**
	 * Metodo que valida null o vacio en List
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(List<?> valor) {
		return (valor == null || valor.isEmpty() ? true : false);
	}

	/**
	 * Metodo que valida cero(0) en Integer <br>
	 * Creado el 5/06/2012 a las 12:10:18 <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(long valor) {
		return (valor == 0 ? true : false);
	}

	/**
	 * Metodo que valida null o cero(0) en Long <br>
	 * Creado el 5/06/2012 a las 12:10:18 <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(Long valor) {
		return (valor == null || valor == 0 ? true : false);
	}

	/**
	 * Metodo que valida null o vacio en Vector
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(Object[] valor) {
		return (valor == null || valor.length == 0 ? true : false);
	}

	/**
	 * Metodo que valida null o vacio en String
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isEmptyNull(String valor) {
		return (valor == null || valor.trim().isEmpty() ? true : false);
	}

	public static boolean isNull(Object obj) {
		return (obj == null);
	}

	/**
	 * Retorna true si es caracter numerico
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isNumeric(String valor) {
		Pattern p = Pattern.compile("\\d*");
		Matcher matcher = p.matcher(valor);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que permite leer un archivo desde una ruta espefica
	 * 
	 * @param pathSource
	 * @return
	 * @throws Exception
	 */
	public static byte[] readFile(String pathSource) throws Exception {
		BufferedInputStream inputStream = null;
		byte[] fileBytes = null;
		FileInputStream fis = null;
		try {
			File file = new File(pathSource);
			fis = new FileInputStream(file);
			inputStream = new BufferedInputStream(fis);
			fileBytes = new byte[(int) file.length()];
			inputStream.read(fileBytes);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return fileBytes;
	}

	public static byte[] readFileThenDelete(String pathSource) throws Exception {
		RandomAccessFile f = null;
		byte[] fileInByte = null;
		try {
			File file = new File(pathSource);
			f = new RandomAccessFile(file, "r");
			fileInByte = new byte[(int) f.length()];
			f.read(fileInByte);
			file.delete();
		} finally {
			IOUtils.closeQuietly(f);
		}
		return fileInByte;
	}

	/**
	 * Metodo utilizado para remover el ultimo caracter definido en los parametros <br>
	 * Creado el 8/08/2018 a las 2:54:16 p. m. <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param str
	 * @param caracter
	 * @return
	 */
	public static String removerUltimoCaracter(String str, String caracter) {
		String resultado = null;
		if (!QxUtil.isNull(str) && !str.isEmpty()) {
			try {
				resultado = str.substring(0, str.lastIndexOf(caracter));
			} catch (StringIndexOutOfBoundsException e) {
				resultado = str;
			}
		}
		return resultado;
	}

	/**
	 * Metodo utilizado para separar un String por determinado caracter que se encuentre en el valor del string. Ej: "Medellin,Botoga,Barranquilla" el
	 * caracter especial seria la "," y retornaría un lista por los nombres de las ciudades<br>
	 * Creado el 1/08/2018 a las 11:46:37 a. m. <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param str
	 * @param caracter
	 * @return
	 */
	public static List<String> separarStringByCaracter(String str, String caracter) {
		List<String> listString = new ArrayList<String>();

		if (!QxUtil.isNull(str)) {
			StringTokenizer tokens = new StringTokenizer(str, caracter);

			while (tokens.hasMoreTokens()) {
				listString.add(tokens.nextToken());
			}
		}
		return listString;
	}

	/**
	 * Si el entero es igual a cero, devuelve un null
	 * 
	 * @param entero
	 * @return
	 */
	public static Integer setNullInt(int entero) {
		if (entero == 0) {
			return null;
		} else {
			return entero;
		}
	}

	public static Long setNullLong(long numero) {
		if (numero == 0) {
			return null;
		} else {
			return numero;
		}
	}

	/**
	 * Si el string tiene un valor "null", devuelve null
	 * 
	 * @param string
	 * @return
	 */
	public static String setNullString(String string) {
		if ("null".equals(string)) {
			return null;
		} else {
			return string;
		}
	}

	/**
	 * Elimina los acentos del portugues y devuelve el texto normalizado en may�scula <br>
	 * Creado el 19/08/2013 a las 17:35:37 <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param string
	 * @return
	 */
	public static String setStringNormalizer(String string) {
		String strStripped = null;
		StringBuilder procesado = new StringBuilder();
		if (!isEmptyNull(string)) {
			// Normalizamos en la forma NFD (Canonical decomposition)
			string = Normalizer.normalize(string, Normalizer.Form.NFD);
			// Reemplazamos los acentos con una una expresi�n regular de Bloque Unicode
			strStripped = string.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

			for (char caracter : strStripped.toCharArray()) {
				if ((caracter >= '0' && caracter <= '9') || (caracter >= 'A' && caracter <= 'z' || (caracter == '.' || caracter == ','
						|| caracter == '-' || caracter == '(' || caracter == ')' || caracter == '/' || caracter == ' '))) {
					procesado.append(caracter);
				}

			}
		}
		return procesado.toString().toUpperCase();
	}

	public static void setUserPasswordToSOAP(BindingProvider provider, String wsUrl) {
		// String username = PropertiesManager.obtenerServidorAplicaciones("/opt/portal/wsdl.properties", "webservice.seguridad.usuario");
		// String password = PropertiesManager.obtenerServidorAplicaciones("/opt/portal/wsdl.properties", "webservice.seguridad.clave");
		String username = null;
		String password = null;
		/******************* UserName & Password ******************************/
		Map<String, Object> req_ctx = provider.getRequestContext();
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsUrl);

		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList(username));
		headers.put("Password", Collections.singletonList(password));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		/**********************************************************************/
	}

	public static void setUserPasswordToSOAP_Qits(BindingProvider provider, String wsUrl) {
		// String username = PropertiesManager.obtenerServidorAplicaciones("/opt/portal/wsdl.properties", "webservice.seguridad.usuario");
		// String password = PropertiesManager.obtenerServidorAplicaciones("/opt/portal/wsdl.properties", "webservice.seguridad.clave");
		String username = null;
		String password = null;
		/******************* UserName & Password ******************************/
		Map<String, Object> req_ctx = provider.getRequestContext();
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsUrl);

		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList(username));
		headers.put("Password", Collections.singletonList(password));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		/**********************************************************************/
	}

	public static void setUserPasswordToSOAP_Qits(BindingProvider provider, String wsUrl, String username, String password) {
		/******************* UserName & Password ******************************/
		Map<String, Object> req_ctx = provider.getRequestContext();
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsUrl);

		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("username", Collections.singletonList(username));
		headers.put("password", Collections.singletonList(password));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		/**********************************************************************/
	}

	public static void setUserPasswordToSOAP_Qits(BindingProvider provider, String wsUrl, String username, String password, String schema) {
		/******************* UserName & Password ******************************/
		Map<String, Object> req_ctx = provider.getRequestContext();
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsUrl);

		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("username", Collections.singletonList(username));
		headers.put("password", Collections.singletonList(password));
		headers.put("schema", Collections.singletonList(schema));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		/**********************************************************************/
	}

	/**
	 * Si el string tiene un valor null, devuelve cadena vacia. <br>
	 * Creado el 27/11/2013 a las 10:39:49. <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 */
	public static String setVacioString(String string) {
		if (string == null) {
			return new String();
		} else {
			return string.trim();
		}
	}

	/**
	 * Obtiene un Date a partir de un string con su respectivo formato Creado el 4/08/2013 a las 12:23:22 <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param fecha
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String fecha, String format) throws ParseException {
		SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
		return simpleFormat.parse(fecha);
	}

	/**
	 * descripcion del metodo </br>
	 * Creado el 24/07/2012 a las 17:39:47 </br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 * @param email
	 * @return true si el email es valido
	 */
	public static boolean validarEmail(String email) {
		boolean success = true;
		if (isEmptyNull(email)) {
			success = false;
		} else {
			// comprueba que no empieze por punto o @
			Pattern pattern = Pattern.compile(ExpresionesRegulares.RE_EMAIL);
			if (!pattern.matcher(email).matches()) {
				success = false;
			}
		}
		return success;
	}

	public void writeFile(String path, byte[] file) throws Exception {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;

		ByteArrayInputStream inp = null;
		FileOutputStream fileo = null;
		try {
			inp = new ByteArrayInputStream(file);
			in = new BufferedInputStream(inp);

			fileo = new FileOutputStream(path);
			out = new BufferedOutputStream(fileo);
			byte buffer[] = new byte[file.length];

			int leidos;
			while ((leidos = in.read(buffer, 0, file.length)) != -1) {
				out.write(buffer, 0, leidos);
			}
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(inp);
			IOUtils.closeQuietly(fileo);
		}
	}
}