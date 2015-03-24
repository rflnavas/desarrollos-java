package rnr.servlets.training.util;

public class Test {
	public static void main(String[] args) { //\
		String toConvert = "agrupacion.addElemento(0, 0, new CampoAgrupacion(\"\", Mensajes.EJERCICIO_ECONOMICO+\": \",cAnno+\"-\"+ cAnnoSig, TipoCelda.TEXTO, false, TipoDato.CADENA))";
		
		String resultConversion = null;
		if(toConvert.indexOf("CampoAgrupacion") >= 0){
			resultConversion = TagConversor.convertirCampoAgrupacion(toConvert);
		}else if(toConvert.indexOf("addValidacionCampo") >= 0){
			//resultConversion = convertirValidacion(toConvert);
		}
		//String resultConversion = convertirValidacion(toConvert);
		System.out.println(resultConversion);
		
	}
}
