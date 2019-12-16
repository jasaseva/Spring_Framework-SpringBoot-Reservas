package com.comfenalcoantioquia.transversal.constantes;

/**
 * Archivo de constantes <br>
 * Creado el 25/05/2012 a las 8:37:21 <br>
 * 
 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
 */
public class Constantes {

	public static class AccionCrud {
		public static final int CREATE = 1;
		public static final int READER = 2;
		public static final int UPDATE = 3;
		public static final int DELETE = 4;
	}

	public static class AutenticacionAnonima {
		// public static final String USUARIO_ANONIMO = "USER_ANONIMO";
		public static final String USUARIO_ANONIMO = "usuarioportal";
		public static final String PERFIL_FUNCIONES_PUBLICAS = "PERFIL PÚBLICO";
		public static final int ID_USUARIO_ANONIMO = 0;
	}

	/**
	 * @deprecated Se reemplaza con {@link co.com.quipux.core.model.Constantes.CodigoEstadoComucacion}
	 */
	public static class CodigoEstadoComucacion {
		/**
		 * Constante cuando el resultado es exitoso desde el WS.
		 */
		public static final int RESULTADO_EXITOSO = 1;

		/**
		 * Constante cuando el proceso es exitoso pero no genera resultados desde el WS.
		 */
		@Deprecated
		public static final int RESULTADO_EXITOSO_SIN_RESULTADO = 2;

		/**
		 * Constante cuando el proceso es exitoso pero no genera resultados desde el WS.
		 */
		public static final int EXITOSO_SIN_RESULTADO = 2;

		/**
		 * Constante cuando sucede un error en la la ejecucion del caso de uso desde el WS.
		 */
		public static final int ERROR_COMUNICACION = 3;

		/**
		 * Constante cuando sucede un error en la la ejecucion del caso de uso, por datos desde el WS.
		 */
		public static final int ERROR_DATOS = 4;

		/**
		 * Constante cuando sucede un error de autenticacion.
		 * 
		 */
		public static final int ERROR_AUTENTICACION = 5;
	}

	public class CodigosFirmaDigital {
		public static final int EXITOSO = 1;
		public static final int ERROR = 2;
		public static final int USUARIO_INVALIDO = 3;
	}

	public static class Column {
		public static final int SMALL = 8;
		public static final int MEDIUM = 10;
		public static final int BIG = 20;
	}

	public static class comp_tipo_comparendo {
		public static final String Electronico = "12";
	}

	public static class conceptosCuentaVehiculo {
		public static final int JUDICIAL = 0;
		public static final int PIGNORACIONES = 1;
		public static final int MULTAS = 2;
		public static final int SEMAFORIZACION = 3;
		public static final int SOAT = 4;
	}

	/**
	 * Permite agrupar las constantes de todos los criterios de búsqueda utilizados en los módulos QITS siempre y cuando <br>
	 * no tengan relación con tablas tipo <br>
	 * Creado el 18/07/2012 a las 11:27:52 <br>
	 * 
	 * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
	 */
	public static class ConstantesComunes {
		public static final int CRITERIO_SERIAL = 1;
		public static final int CRITERIO_MARCA = 2;
		public static final int CRITERIO_MODELO = 3;
		public static final int CRITERIO_FECHA_REGISTRO = 4;
		public static final int CRITERIO_FECHA_ASIGNACION = 5;
		public static final int CRITERIO_NRO_TALONARIO = 6;
		public static final int CRITERIO_TIPO_TALONARIO = 7;
		public static final int CRITERIO_ENTIDAD = 8;
		public static final int CRITERIO_CEDULA = 9;
		public static final int CRITERIO_COMPARENDO = 10;
		public static final int CRITERIO_RANGO_INFRACCIONES = 11;
		public static final int CRITERIO_FECHA_CREACION = 12;

		public static final int CRITERIO_NRO_EXPEDIENTE = 13;
		public static final int CRITERIO_IDENTIFICACION = 14;
		public static final int CRITERIO_IDENTIFICACION_DEUDA = 15;
		public static final int CRITERIO_FECHA_PRESCRIPCION = 16;

		public static final int CRITERIO_MOTIVO_DEVOLUCION = 17;
		public static final int CRITERIO_FECHA_ENVIO_CORRESPONDENCIA = 18;
		public static final int CRITERIO_NRO_GUIA = 19;
		public static final int CRITERIO_FECHA_RESULTADO = 20;
		public static final int CRITERIO_DOCUMENTO = 21;
		public static final int CRITERIO_ESTADO = 22;

		public static final int CRITERIO_PLACA = 23;

		public static final int CRITERIO_NRO_MANDAMIENTO = 24;
		public static final int CRITERIO_NOMBRES = 25;
		public static final int CRITERIO_NRO_SOLICITUD = 26;
		public static final int CRITERIO_FECHA = 27;
		public static final int CRITERIO_PROCESO = 28;
		public static final int CRITERIO_SEDE = 29;
		public static final int CRITERIO_INFRACTOR = 30;
		public static final int CRITERIO_NRO_RECIBO = 31;
		public static final int CRITERIO_RESTRICCION = 32;
		public static final int CRITERIO_TODOS = 33;
		public static final int CRITERIO_FUNCIONARIO = 34;

		public static final int CRITERIO_NRO_IMPRESION = 35;
	}

	public static class ExpresionesRegulares {

		/* Esta expresión regular valida que la cadena ingresada contenga solo caracteres alfanuméricos, sin saltos de linea. */
		public static final String RE_ALFANUMERICOS_CEROMUCHOS = "^(\\w)*$";
		/* Esta expresión regular valida que la cadena ingresada contenga solo caracteres numéricos, sin saltos de linea. */
		public static final String RE_NUMERICOS_CEROMUCHOS = "^([0-9])*$";

		/*
		 * Esta expresión regular valida que la cadena ingresada contenga solo caracteres alfanuméricos, sin saltos de linea, además debe contener
		 * como mínimo 1 caracter.
		 */
		public static final String RE_ALFANUMERICOS_UNOMUCHOS = "^(\\w)+$";
		/*
		 * Esta expresión regular valida que la cadena ingresada contenga solo caracteres numéricos, sin saltos de linea, además debe contener como
		 * mínimo 1 caracter.
		 */
		public static final String RE_NUMERICOS_UNOMUCHOS = "^([0-9])+$";

		/** Valida que la cadena contenga un correo electronico valido. */
		public static final String RE_EMAIL = "^(\\w+([+-.]\\w+)*@\\w+([+-.]\\w+)*([.][a-zA-Z]{2,3}))?$";
	}

	public static class Filtro {
		public static final int FECHA = 1;
		public static final int IDENTIFICACION = 2;
		public static final int TODOS = 3;
		public static final int CARPETA = 4;
		public static final int SECCION = 5;
		public static final int ENTIDAD = 6;
	}

	public static class LogError {
		public static final String ERROR_VALIDACION_ESTRUCTURA = "ES";
		public static final String ERROR_VALIDACION_REGLA_NEGOCIO = "VA";
	}

	public class MaestroSolicitud {
		public static final String RADICADO = "SL";
	}

	public class PersonaNatural {
		public static final String ENVIO_INFORMACION_S = "S";
	}

	public static class ProcesoCargaInformacion {
		public static final int FILTRO_CRITERIO_ARCHIVO = 1;
		public static final int FILTRO_CRITERIO_PROCESO_CARGA = 2;
	}

	public class RegistroComparendera {
		public static final int CRITERIO_SERIAL = 1;
		public static final int CRITERIO_MARCA = 2;
		public static final int CRITERIO_MODELO = 3;
		public static final int CRITERIO_FECHAREGISTRO = 4;

	}

	public static class SemillaSimpleCrypto {
		public static final String SEMILLA_CRYPTO = "UXVJcFV4K0M4L2hCKj8tLSovQDI=";
	}

	public static class ServicioPlataforma {
		public static final int NOTIFICACION_MANDAMIENTO_PAGO = 1;
		public static final int CONSULTA_INTERESES_COBRO_COACTIVO = 2;
		public static final int NOTIFICACION_RECURSO_A_MODULO = 3;
		public static final int CONSULTA_INTERESES_LIQUIDACION = 4;
		public static final int ENVIO_CONTACTOS_GIC = 5;
		public static final int SINCRONIZAR_COMPARENDOS_OT = 6;
	}

	public static class TipoArchivoCarga {

		/* Archivos asociados al módulo de cobro coactivo */
		public static final int FORMULARIO_DE_INV_BIENES_SIN_MC = 1;
		public static final int FORMULARIO_DE_INV_BIENES_CON_MC = 2;
		public static final int FORMULARIO_DE_EMBARGOS = 3;
		public static final int PLANTILLA_PAQUETES = 4;
		public static final int CARGA_IMAGENES_FOTODETECION = 5;
	}

	public static class TipoContacto {
		public static final int CELULAR = 1;
		public static final int TELEFONO = 2;
		public static final int EMAIL = 3;
	}

	public static class TipoDatoCampo {
		public static final int STRING = 1;
		public static final int INTEGER = 2;
		public static final int DOUBLE = 3;
		public static final int LONG = 4;
		public static final int DATE = 5;
		public static final int FLOAT = 6;
	}

	public class TipoDatoContacto {

		public static final int CELULAR = 1;
		public static final int TELEFONO = 2;
		public static final int EMAIL = 3;
	}

	public class TipoDependencia {

		public static final int RNA = 1;
		public static final int RNC = 3;

	}

	public static enum TipoDocumentoGestionDocumental {
		PDF("PDF"), JPG("JPG"), XLS("XLS"), HTML("HTML"), TXT("TXT");

		private String value;

		TipoDocumentoGestionDocumental(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

	}

	public class TipoDocumentoIdentidad {

		public static final int NN = 1;
		public static final int CEDULA = 2;
		public static final int NIT = 3;
		public static final int CEDULA_EXTRANJERIA = 4;
		public static final int PASAPORTE = 6;

	}

	public static class TipoEstadoCarpeta {
		public static final int CREADA = 1;
		public static final int PENDIENTE_ENVIO_ENTIDAD = 2;
		public static final int EXPORTADA = 3;
		public static final int ASIGNADO_PAQUETE = 4;
	}

	public static class TipoEstadoComparendo {
		public static final int SE_ADEUDA = 1;
		public static final int FALLADO = 11;
		public static final int FALLADO_ALCOHOLEMIA = 12;
		public static final int AP_INCUMPLIDO = 17;
		public static final int COBRO_ACTIVO = 28;
		public static final int PAGADO = 3;
	}

	public static class TipoEstadoDocumento {
		public static final int GENERADO_OFICIOS_DEVOLUCION = 1;
		public static final int GENERADO = 2;
		public static final int NO_GENERADO = 3;
		public static final int ENVIADO = 4;
		public static final int NO_ENVIADO = 5;
		public static final int PENDIENTE_FIRMA = 6;
		public static final int FIRMADO = 7;
		public static final int RECHAZADO = 16;

		public static final int PENDIENTE_ENVIO_CORRESPONDENCIA = 8;
		public static final int PENDIENTE_IMPRESION_CORRESPONDENCIA = 9;
		public static final int REIMPRESO_CORRESPONDENCIA = 10;
		public static final int IMPRESO_PDF = 11;
		public static final int ENVIADO_CORRESPONDENCIA = 12;
		public static final int ENTREGADO = 13;
		public static final int DEVUELTO = 14;
		public static final int IMPRESO_CORRESPONDENCIA = 15;
		public static final int PENDIENTE_IMPRESION_CHIP = 19;
		public static final String ENTREGADO_DESC = "ENTREGADO";
		public static final String DEVUELTO_DESC = "DEVUELTO";

	}

	public class TipoEstadoInforme {
		public static final int REGISTRADO = 1;
		public static final int ASIGNADO = 2;
		public static final int ENTREGADO = 3;

	}

	public class TipoError {
		public static final int STRING_NOT_NUMBER = 1;
	}

	public static class TipoEstadoLiquidacion {
		public static final int PAGADA = 4;
		public static final int LIQUIDADO = 1;
	}

	public static class TipoEstadoSolicitud {
		public static final int APROBADA = 1;
		public static final int PENDIENTE_PAGO = 2;
		public static final int SIN_REGISTRAR = 3;
		public static final int RECHAZADA = 4;
		public static final int ANULADA = 5;
		public static final int DEVUELTA = 6;
		public static final int PAGADA_IMPUESTO = 7;
		public static final int PENDIENTE_APROBACION = 8;
		public static final int PAGADA = 9;
		public static final int PENDIENTE_IMPRESION = 10;
		public static final int IMPRESA = 11;
		public static final int PENDIENTE_ENTREGA = 12;
		public static final int ENTREGADA = 13;

	}

	public class TipoEstadoTalonario {
		public static final int REGISTRADO = 1;
		public static final int ASIGNADO = 2;
		public static final int FINALIZADO = 3;
	}

	public class TipoEstasPagoOnLine {
		/**
		 * Indicador de transaccion pendiente
		 */
		public static final String PENDING = "PENDIENTE";

		/**
		 * Indicador de transaccion fallida
		 */
		public static final String ERROR = "FALLIDA";

		/**
		 * Indicador de transaccion exitosa
		 */
		public static final String APPROVED = "APROBADA";

		/**
		 * Indicador de transaccion declinada
		 */
		public static final String DECLINED = "DECLINADA";

		/**
		 * Indicador de transaccion duplicada (previamente aprobada)
		 */
		public static final String DUPLICATE = "DUPLICADA";
	}

	public static class TipoFormularioInvestigacionBienes {
		public static final int INVESTIGACION_BIENES = 1;
		public static final int INVESTIGACION_BIENES_MC = 2;
		public static final int EMBARGO_BIENES = 3;
	}

	public class TipoFuenteDato {

		public static final int VEHICULOS = 1;
		public static final int COBRO = 2;
		public static final int PORTAL = 3;
		public static final int MIGRACION = 4;
		public static final int MULTAS = 5;
		public static final int GIC = 7;
		public static final int FOTODETECCION = 8;

	}

	public static class TipoModulo {
		public static final int COBRO_COACTIVO = 1;
		public static final int VEHICULOS = 2;
		public static final int ADMINISTRACION = 3;
		public static final int SEGURIDAD = 4;
		public static final int BANCOS = 5;
		public static final int IMPRESIONES = 6;
		public static final int MULTAS = 7;
		public static final int PERSONA = 8;
		public static final int PORTAL = 9;
		public static final int GESTION_DOCUMENTAL = 10;
		public static final int RECURSOS = 11;
		public static final int DISPOSITIVOS_ELECTRONICOS = 12;
		public static final int GIC = 13;
		public static final int TRAMITES = 14;
		public static final int LICENCIAS = 15;
		public static final int IMPUESTOS = 16;
		public static final int GESTION_DETECCION = 17;
		public static final int ESCUELAS = 18;
		public static final int TRANSPORTE = 20;
	}

	public class TipoMotivoDefensa {
		public static final int OTRO = 10;
		public static final int PAGO_EFECTIVO = 1;
		public static final int EXISTENCIA_ACUERDO_PAGO = 2;
	}

	public static class TipoPaqueteEstado {
		public static final int PENDIENTE_ENVIO = 1;
		public static final int DEVUELTO = 2;
		public static final int ENTREGADO = 3;
		public static final int ENVIADO_CORRESPONDENCIA = 4;
		public static final int ELIMINADO = 5;
	}

	public class TipoParametro {
		public static final int CANTIDAD_DOCUMENTOS_CARPETA_GESTION = 1;
		public static final int RUTA_P12_USUARIOS = 2;
		public static final int RUTA_RAIZ_GESTION_DOCUMENTAL = 6;
		public static final int RUTA_DIRECTORIO_TEMPORAL_DOCUMENTOS = 8;
		public static final int MAXIMO_EXPEDIENTES_ASIGNADOS = 7;
		public static final int CLAVE_SEGURIDAD_CIFRADO_ARCHIVOS = 9;
		public static final int CLAVE_SEGURIDAD_CIFRADO_RUTAS = 10;
		public static final int PERIODO_PRESCRIPCION_DEUDA = 12;
		public static final int INTEGRACION_SISTEMA_EXTERNO = 17;
		public static final int HORA_SOLICITUD_MOROSOS = 18;
		public static final int CONEXION_PLATAFORMA_EXTERNA_IMPUESTOS = 19;
		public static final int HOMOLOGACION_DIVIPOLA_COLOMBIA = 20;
		public static final int CONEXION_PLATAFORMA_EXTERNA_INFRACCIONES = 21;
		public static final int CIUDAD_DEFECTO = 25;
		public static final int TAMANO_MAXIMO_ARCHIVOS_ADJUNTOS_POR_CORREO = 27;
		public static final int TIEMPO_ESPERA_WORKFLOW_COBRO_PERSUASIVO = 33;
		// parametros para el envio de correos
		public static final int SMTP = 15;
		public static final int PORT_SMTP = 16;
		public static final int EMAIL_REMI = 23;
		public static final int PASS_REMI = 24;

		// parametros para la generacion del impuesto deptal
		public static final int PAIS_PARA_LA_GENERACION_DEL_IMPUESTO_DEPARTAMENTAL = 25;
		public static final int DEPARTAMENTO_PARA_LA_GENERACION_DEL_IMPUESTO_DEPARTAMENTAL = 28;
		public static final int PORCENTAJE_DE_DISTRIBUCION_DEPARTAMENTAL = 29;
		public static final int PORCENTAJE_DE_DISTRIBUCION_MUNICIPAL = 30;

		// mensajes para impresión de comprobante de liquidación
		public static final int CORREO_CONTACTO_ORGANISMO = 38;
		public static final int INFORMACION_PARA_CONTACT_CENTER = 39;

		public static final int TARIFA_RUNT = 31;
		public static final String DESC_TARIFA_RUNT = "Derechos RUNT";
		public static final int TARIFA_MUNICIPAL = 32;
		public static final String DESC_TARIFA_MUNICIPAL = "Derechos Ministerio";

		// parametros reglas de negocio contrasena
		public static final int PARAMETRO_PASSWORD_DEFAULT = 3;
		public static final int MIN_CARACTERES = 5;
		public static final int SPECIAL = 4;
		public static final int MAX_CARACTERES = 13;
		public static final int MAYUS = 14;
		public static final int NUM_CARACTERES = 22;

		/* Parametro para los dias habiles */
		public static final int DIAS_HABILES = 41;

		/* Tiempo duración del proceso cobro persuasivo (Días) */
		public static final int TIEMPO_PROCESO_PERSUASIVO = 43;

		public static final int ANHO_PRESCRIPCION_INFRACCIONES_CONFORMACION = 44;
		public static final int ANHO_PRESCRIPCION_OTRAS_RENTAS_CONFORMACION = 45;
		public static final int ANHO_PRESCRIPCION_INFRACCIONES_MANDAMIENTO = 46;
		public static final int ANHO_PRESCRIPCION_OTRAS_RENTAS_MANDAMIENTO = 47;

		/* Ruta donde se almacenan las imagenes requeridas para los oficios */
		public static final int RUTA_IMAGENES_OFICIOS = 54;

		/* Notificación en mandamiento de pago */
		public static final int NOTIFICACION_MANDAMIENTO_PAGO = 55;

		/* Maximo numero de intentos para notificar mandamiento de pago */
		public static final int MAXIMO_NOTIFICAR_MANDAMIENTO_PAGO = 56;

		/* Parametro para bloquear el dispositivo movil cuando se han fallado logueos */
		public static final int CANTIDAD_INTENTOS_LOGUEO_BLOQUEAR = 50;
		/* parametros para los timer de los dispositivos electronicos */
		public static final int MINUTOS_SINCRONIZACION_DISPOSITIVO = 51;
		public static final int MINUTOS_LOCALIZACION_DISPOSITIVO = 52;
		public static final int MINUTOS_MENSAJES_DISPOSITIVO = 53;
		/* Parametro para guardar las imagenes de novedades de los dispositivos moviles */
		public static final int RUTA_IMAGENES_NOVEDADES = 58;
		/* Parametro para la creacion masiva de talonarios */
		public static final int CODIGO_INFRACCION_DPVAT = 60;
		public static final int CODIGO_INFRACCION_VISTORIA = 61;
		public static final int CODIGO_INFRACCION_CRLV = 62;
		public static final int PERMITE_EDITAR_INFO_AIT = 63;

		public static final int SECRETARIA_DEFECTO = 59;

		/* Gestion Documental */
		public static final int MAX_DOCUMENTOS_ENVIO_IMPRECIONPDF = 64;
		public static final int MAX_DOCUMENTOS_ENVIO_CORRESPONDENCIA = 65;
		public static final int RUTA_BASE_CARGA_ARCHIVOS = 70;

		/* Maximo numero de dias habiles para la notificacion personal */
		public static final int MAX_DIAS_HABILES_NOTIFICACION_PERSONAL = 66;

		/* Tiempo proxima investigación de bienes a deudor */
		public static final int TIEMPO_PROXIMA_INVESTIGACION_BIENES = 67;

		/* Parametros para medidas cautelares */
		public static final int PORCENTAJE_DE_TOPE_DE_EMBARGABILIDAD_PARA_VALORES_BANCARIOS = 68;
		/* Maximo numero de registros para crear archivo xls */
		public static final int MAXIMO_NUMERO_REGISTROS_XLS = 69;

		public static final int TAMANO_MAXIMO_ARCHIVOS_REGISTRO_CORRESPONDENCIA = 71;

		/* Ruta base para exportar archivos */
		public static final int RUTA_BASE_EXPORTAR = 72;
		public static final int TAMANO_MAXIMO_ARCHIVOS_ESCANEADO = 74;

		/* Cantidad permitida de intentos fallidos en notificación recurso */
		public static final int MAXIMO_INTENTOS_NOTIFICACION_RECURSO = 75;

		public static final int NUM_DIAS_HABILES_PRESENTAR_EXCEPCION = 76;

		public static final int RUTA_SUBREPORTES = 77;

		public static final int NUM_DIAS_HABILES_NOTIFICACION_PERS_FALLO = 78;

		public static final int PARTE_FIJA_TRANSACCION_REGISTRO_INFRACCION_TRANSITO_DETRAN = 79;

		public static final int CANTIDAD_DIAS_RECURSO_REPOSICION = 80;

		public static final int NUM_DIAS_HABILES_GEN_LIQUIDACION_CREDITO = 83;

		public static final int VALOR_PORCENTAJE_COSTAS = 84;

		public static final int MAXIMO_NUMERO_REGISTROS_PAQUETE_ENVIO = 86;

		public static final int CLIENTE_GIC = 87;

		public static final int CALCULO_PROPORCIONAL_IMPUESTOS = 98;

		public static final int EXONERA_IMPUESTOS_ANHO_MATRICULA = 99;

		public static final int PAGO_IMPUESTOS_VIGENCIAS_PARCIALES = 105;

	}

	public static class TipoPersona {
		public static final String NATURAL = "N";
		public static final String JURIDICA = "J";
	}

	public static class TipoPlaca {
		public static final String TIPO_PLACA_TEMPORAL = "Temporal";
		public static final String TIPO_PLACA_DEFINITIVA = "Definitiva";
	}

	public static class TipoPlantilla {
		public static final int PLANTILLA_OFICIO_DEVOLUCION = 1;
		public static final int PLANTILLA_MANDAMIENTO_PAGO = 2;
		public static final int PLANTILLA_CITACION_MANDAMIENTO_PAGO = 3;
		public static final int PLANTILLA_OFICIO_PERSUASIVO = 4;
		public static final int PLANTILLA_NOTIFICACION_PORTAL = 5;
		public static final int PLANTILLA_NOTIFICACION_PERSONAL = 6;
		public static final int PLANTILLA_NOTIFICACION_CONCLUYENTE = 7;
		public static final int PLANTILLA_NOTIFICACION_APODERADO = 8;
		public static final int PLANTILLA_INVESTIGACION_BIENES = 9;
		public static final int PLANTILLA_INVESTIGACION_BIENES_MC = 10;
		public static final int PLANTILLA_INVESTIGACION_EMBARGO_BIENES = 11;
		public static final int PLANTILLA_EMBARGO_SALARIO = 12;
		public static final int PLANTILLA_EMBARGO_OFICINA_INSTRUMENTOS_PUBLICOS = 13;
		public static final int PLANTILLA_EMBARGO_VEHICULOS = 14;
		public static final int PLANTILLA_EMBARGO_CAMARA_COMERCIO = 15;
		public static final int PLANTILLA_LEVANTAMIENTO_EMBARGO = 16;
		public static final int PLANTILLA_RESOLUCION_NOMBRAMIENTO_SECUESTRE = 17;
		public static final int PLANTILLA_AUTO_SECUESTRO = 18;
		public static final int PLANTILLA_AUTO_SUSPENSION_SECUESTRO = 19;
		public static final int PLANTILLA_PAQUETES = 20;
		public static final int EVIDENCIA_AVALUO = 23;
		public static final int PLANTILLA_OFICIO_AVISO_REMATE = 24;
		public static final int PLANTILLA_SOLICITUD_RECURSO_COBRO = 25;
		public static final int EVIDENCIA_RECURSO = 26;
		public static final int PLANTILLA_ORDEN_SEGUIR_ADELANTE = 27;
		public static final int PLANTILLA_AUTO_TERMINACION = 28;
		public static final int PLANTILLA_AUTO_PROCESO_ARCHIVADO = 29;
		public static final int PLANTILLA_CITACION_FALLO_RECURSO = 30;
		public static final int PLANTILLA_RESOLUCION_EXCEPCIONES = 31;
		public static final int PLANTILLA_RESOLUCION_RECURSOS = 32;
		public static final int PLANTILLA_NOTIFICACION_RESO_SOLI_DEF = 33;
		public static final int PLANTILLA_LIQUIDACION_CREDITO = 36;
	}

	public static class TipoProcesoSolicitud {
		public static final int REGISTRO = 1;
		public static final int PAGO = 2;
		public static final int APROBACION = 3;
		public static final int IMPRESION = 4;
		public static final int ENTREGA = 5;
		public static final int DEVOLUCION = 6;
		public static final int FINAL = 7;
	}

	public class TipoProcesoTalonario {
		public static final int TRANSPORTE = 1;
		public static final int DISTRIBUCION = 2;
		public static final int ASIGNADO_AGENTE_ACTUADOR = 3;

	}

	public static class TipoRecursoSistema {
		public static final int ROLE_EVALUACION_EXPEDIENTE = 7;

		/**
		 * Roles para evaluación de expedientes en proceso de cobro persuasivo
		 */
		public static final int ROLE_EVALUA_EXPED_PERSUA_CANAL_LLAMADA = 42;
		public static final int ROLE_EVALUA_EXPED_PERSUA_CANAL_CORREO_CERT = 43;
		public static final int ROLE_EVALUA_EXPED_PERSUA_CANAL_CORREO_ELEC = 44;

		/**
		 * Rol para ser seleccionado como responsable de un mandamiento de pago;
		 */
		public static final int ROLE_RESPONSABLE_MANDAMIENTO = 73;
	}

	public static class TipoRegistro {
		public static final int PERSONA = 1;
		public static final int VEHICULO = 2;
	}

	public class TipoResponsableTalonario {
		public static final int ENTIDAD = 1;
		public static final int SUBSEDE = 2;
		public static final int AGENTE = 3;
		public static final int ORGANISMO_TRANSITO = 4;

	}

	public static class TipoResultadoGestion {
		public static final int LOCALIZADO = 1;
		public static final int NO_LOCALIZADO = 2;
		public static final int RENUENTE_AL_PAGO = 3;
		public static final int DISPUESTO_AL_PAGO = 4;
		public static final int PENDIENTE_GESTION = 5;
		public static final int GESTIONADO = 6;
		public static final int NO_GESTIONADO = 7;
	}

	public static class TipoSeparadorArchivo {
		public static final int COMA = 1;
		public static final int PUNTO_Y_COMA = 2;
		public static final int TABULADOR = 3;
		public static final int ESTRUCTURA = 4;
	}

	public static class TipoServicioConsultaPendiente {
		public static final int PENDIENTE_GENERACION = 1;
		public static final int PENDIENTE_NOTIFICACION_PE = 2;
	}

	public static class TipoSolicitante {
		public static final String CONDUCTOR = "C";
		public static final String PROPIETARIO = "P";
		public static final int DEUDOR_PRINCIPAL = 1;
		public static final int DEUDOR_SOLIDARIO = 2;
		public static final int APODERADO = 3;
	}

	public static class TipoTalonario {
		public static final int FISICO = 1;
		public static final int ELECTRONICO = 2;
		public static final int RADAR = 9;
	}

	public static class TipoTarifa {
		public static final int DERECHOS_RUNT = 9000;
		public static final int DERECHOS_MINISTERIO = 9001;
	}

	/**
	 * @deprecated Esta tabla tipo corresponde a tramites. <br>
	 *             Se reemplaza con {@link co.com.quipux.tramites.model.Constantes.TipoTramite}
	 */
	public static class TipoTramite {
		public static final int CERTIFICADO_PROPIEDAD = 60;
		public static final int CERTIFICADO_TRADICION = 22;
		public static final int MATRICULA_INICIAL = 1;
	}

	public static class TipoValidacion {
		public static final String NOMBRE_VALIDACION_EXISTENCIA = "EXISTENCIA";
	}

	public class UsuarioSistema {
		public static final int SUPERADMIN = 1;
		public static final int PLATAFORMAEXTERNA = 2;
		public static final int TIPOUSUARIO = 0;
		public static final int PERFIL_CIUDADANO = 1;
		public static final int SISTEMA = 3;
	}

}