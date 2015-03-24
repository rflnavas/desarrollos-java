package rnr.servlets.training.util;

import java.util.HashMap;
import java.util.Map;

public class Plantillas {
	
	private Plantillas() {
	}
	
	public static final String ATTR_PROPIEDADES = "#propiedad#";
	
	public static final Map<String, String> PLANTILLAS_CELDAS = new HashMap<String, String>();
	
	static{
		PLANTILLAS_CELDAS.put("TipoCelda.TEXTO", 
				"<item:Texto nombre=%s titulo=%s " + ATTR_PROPIEDADES + " dato=\"<%%=%s%%>\" requerido=\"%s\" tipoDato=\"<%%=%s%%>\" />");
		PLANTILLAS_CELDAS.put("TipoCelda.CAJA_TEXTO", 
				"<item:CajaTexto nombre=%s titulo=%s " + ATTR_PROPIEDADES + " dato=\"<%%=%s%%>\" requerido=\"%s\" tipoDato=\"<%%=%s%%>\" />");
		PLANTILLAS_CELDAS.put("TipoCelda.LISTA_DESPLEGABLE", 
				"<item:ListaDesplegable nombre=%s titulo=%s " + ATTR_PROPIEDADES + " dato='<%%=%s%%>' requerido=\"%s\" tipoDato=\"<%%=%s%%>\" />");
		PLANTILLAS_CELDAS.put("TipoCelda.LISTA_DESPLEGABLE_OPCIONES_PERSONALIZADAS", 
				"<item:ListaOpcionesPersonalizadas nombre=%s titulo=%s " + ATTR_PROPIEDADES + " dato='<%%=%s%%>' requerido=\"%s\" tipoDato=\"<%%=%s%%>\" />");
		PLANTILLAS_CELDAS.put("TipoCelda.CHECKBOX",
			"<item:CheckBox nombre=%s titulo=%s " + ATTR_PROPIEDADES + " dato='<%%=%s%%>' requerido=\"%s\" tipoDato=\"<%%=%s%%>\"/>"); 
		PLANTILLAS_CELDAS.put("TipoCelda.RADIO_BUTTON",
			"<item:RadioButton nombre=%s titulo=%s " + ATTR_PROPIEDADES + " dato='<%%=%s%%>' requerido=\"%s\" tipoDato=\"<%%=%s%%>\"/>"); 
		PLANTILLAS_CELDAS.put("TipoCeldaCEC.GESTOR_CC",
				"<item:GestorCuentasCorrientes nombre=%s titulo=%s dato='<%%=%s%%>' requerido=\"%s\" tipoDato=\"<%%=%s%%>\"/>"); 
		PLANTILLAS_CELDAS.put("TipoCeldaCEC.TEXTAREA_CON_TITULO",
				"<item:TextAreaTitulo nombre=%s titulo=%s dato='<%%=%s%%>' requerido=\"%s\" tipoDato=\"<%%=%s%%>\"/>");
		
	}
	
	public static final String PLANTILLA_CAMPO_AGRU_BD = "<formulario:campoAgrupacionBD nombre=%s"+
					" titulo=%s dato=\"<%%=%s%%>\" tipoCampo=\"<%%=%s%%>\""+
					" requerido=\"%s\" tipoDato=\"<%%=%s%%>\""+
					" tabla=%s campo=%s/>";
	public static final String PLANTILLA_CAMPO_VALIDACION = 
		"<formulario:validacionCampo nombreCampo=%s accion=%s\" mensaje=%s/>";
	
	public static final String PLANTILLA_ACC_POSTERIOR = 
			"<formulario:accionPosterior nombreCampo=%s accion=\"%s\" ejecutarDesdeValPantalla=\"%s\"/>";
		
	public static final String PLANTILLA_CAMPO_OCULTO = 
			"<formulario:campoOculto nombre=%s valor=%s/>";
	
	public static final String PLANTILLA_PROPIEDAD_CAMPO = 
			"<formulario:propiedadCampo nombreCampo=%s nombrePropiedad=%s valorPropiedad=%s/>";
	
	public static final String PLANTILLA_GESTOR_CCC= 
			"<item:GestorCuentasCorrientes nombre=%s></item:GestorCuentasCorrientes>";
	
	public static final String  PLANTILLA_CAJA_TEXTO_BOTON_IMG = 
			"<item:CajaTextoBotonImagen nombre=%s titulo=%s dato='<%%=%s%%>' requerido=\"%s\" tipoDato=\"<%%=%s%%>\"/> imagensrc"; 
	
}
