package rnr.servlets.training.util;

public class TagConversor {
	
		//TipoCelda.CAJA_TEXTO
	public static void main(String[] args) { //\
		String toConvert = "agruJustificacion.addElemento(0, 0, new CampoAgrupacion(\"X_JUSGASCEN\", \"Justificación:\", null, mlJustificaciones, TipoCelda.LISTA_DESPLEGABLE, false, TipoDato.CADENA));";
		String resultConversion = null;
		if(toConvert.indexOf("CampoAgrupacion") >= 0){
			resultConversion = TagConversor.convertirCampoAgrupacion(toConvert);
		}else if(toConvert.indexOf("CampoAgrupacionBD") >= 0){
			resultConversion = TagConversor.convertirCampoAgrupacionBD(toConvert);
		}else if(toConvert.indexOf("addValidacionCampo") >= 0){
			resultConversion = TagConversor.convertirValidacion(toConvert);
		}else if(toConvert.indexOf("addAccionPosteriorCampo") >= 0){
			resultConversion = TagConversor.convertirAccionPosterior(toConvert);
		}else if(toConvert.indexOf("addCampoOculto") >= 0){
			resultConversion = TagConversor.convertirCampoOculto(toConvert);
		}else if(toConvert.indexOf("addPropiedadCampo") >= 0){
			resultConversion = TagConversor.convertirCampoPropiedad(toConvert);
		}
		
		System.out.println(resultConversion);
	}
	
	//agruPago.addValidacionCampo("F_APUNTE", new Validacion("validarFechaEjeEco('F_APUNTE')", "La 'Fecha de pago' debe estar comprendida dentro del ejercicio económico."));
	
	
	public static String convertirCampoPropiedad(String toConvert) {
		String [] campOcultoArgs = toConvert.substring(toConvert.indexOf("(") + 1 , toConvert.lastIndexOf(")")).split(",");
		String nombreCampo = null;
		String nombrePropiedad = null;
		String valorPropiedad = null;
		for(int i = 0; i < campOcultoArgs.length ; i++){
			campOcultoArgs[i] = campOcultoArgs[i].trim();
			switch(i){
				case(0):
					nombreCampo = campOcultoArgs[i];
					break;
				case(1):
					nombrePropiedad = campOcultoArgs[i];
					break;
				case(2):
					valorPropiedad = campOcultoArgs[i];
					break;
			}
		}
		System.out.println("=>" + nombreCampo + ";" + nombrePropiedad + ";" + valorPropiedad);
		String resultConversion = String.format(Plantillas.PLANTILLA_PROPIEDAD_CAMPO, nombreCampo, nombrePropiedad, valorPropiedad);
		return resultConversion;
	}
	
	public static String convertirCampoOculto(String toConvert) {
		String [] campOcultoArgs = toConvert.substring(toConvert.indexOf("(") + 1 , toConvert.lastIndexOf(")")).split(",");
		String nombreCampo = null;
		String valor = null;
		for(int i = 0; i < campOcultoArgs.length ; i++){
			campOcultoArgs[i] = campOcultoArgs[i].trim();
			switch(i){
				case(0):
					nombreCampo = campOcultoArgs[i];
					break;
				case(1):
					valor = campOcultoArgs[i];
					break;
			}
		}
		System.out.println("=>" + nombreCampo + ";" + valor);
		String resultConversion = String.format(Plantillas.PLANTILLA_CAMPO_OCULTO, nombreCampo, valor);
		return resultConversion;
	}

	public static String convertirAccionPosterior(String toConvert){
		//toConvert = toConvert.substring(toConvert.indexOf("(") + 1, toConvert.lastIndexOf(")"));
		String [] accPostArgs = toConvert.substring(toConvert.indexOf("(") + 1 , toConvert.lastIndexOf(")") - 1).split(",");
		
		String campo = null;
		String accion = null;
		String ejecutarDesdeValPantalla = null;
		for(int i = 0; i < accPostArgs.length ; i++){
			accPostArgs[i] = accPostArgs[i].trim();
			switch(i){
				case(0):
					campo = accPostArgs[i];
				
					break;
				case(1):
					
					accion = accPostArgs[i].substring(
							accPostArgs[i].indexOf("(") + 1 , 
							accPostArgs[i].lastIndexOf(")") + 1);
					break;
				case(2):
					ejecutarDesdeValPantalla = accPostArgs[i];
					break;
			}
			
		}
		
		System.out.println("=>" + campo + ";" + accion+  ";" + ejecutarDesdeValPantalla);
		String resultConversion = String.format(Plantillas.PLANTILLA_ACC_POSTERIOR, campo, accion, ejecutarDesdeValPantalla);
		return resultConversion;
	}
	
	public static String convertirValidacion(String toConvert){
		//toConvert = toConvert.substring(toConvert.indexOf("(") + 1, toConvert.lastIndexOf(")"));
		String [] validacionArgs = toConvert.substring(toConvert.indexOf("(") + 1 , toConvert.lastIndexOf(")") - 1).split(",");
		
		String campo = null;
		String accion = null;
		String msg = null;
		for(int i = 0; i < validacionArgs.length ; i++){
			validacionArgs[i] = validacionArgs[i].trim();
			switch(i){
				case(0):
					campo = validacionArgs[i];
				
					break;
				case(1):
					
					accion = validacionArgs[i].substring(
							validacionArgs[i].indexOf("(") + 1 , 
							validacionArgs[i].lastIndexOf(")") + 1);
					break;
				case(2):
					msg = validacionArgs[i];
					break;
			}
			
		}
		System.out.println("=>" + campo + ";" + accion+  ";" + msg);
		String resultConversion = String.format(Plantillas.PLANTILLA_CAMPO_VALIDACION, campo, accion, msg);
		return resultConversion;
	}
	
	public static String convertirCampoAgrupacion(String toConvert){
		
		toConvert = toConvert.substring(toConvert.indexOf("(") + 1, toConvert.lastIndexOf(")"));
		String [] rowCol = toConvert.split(",");
		int row = Integer.parseInt(rowCol[0].trim());
		int col = Integer.parseInt(rowCol[1].trim());
		System.out.println(row + ", " + col);
		
		String [] campAgruArgs = toConvert.substring(toConvert.indexOf("(") + 1 , toConvert.lastIndexOf(")")).split(",");
		System.out.println("Campos detectados...");
		
		String nombre = null;
		String titulo = null;
		String dato = null;
		String requerido = null;
		String tipoCelda = null;
		String tipoDato = null;
		String propiedades = null;
		int numArgs = campAgruArgs.length;
		
		for(int i = 0; i < campAgruArgs.length ; i++){
			campAgruArgs[i] = campAgruArgs[i].trim();
		}	
		if(numArgs >6){
			nombre = campAgruArgs[0];
			titulo = campAgruArgs[1];
			propiedades = "null".equals(campAgruArgs[2])?"":campAgruArgs[2];
			dato = campAgruArgs[3];
			tipoCelda = campAgruArgs[4];
			requerido = campAgruArgs[5];
			tipoDato = campAgruArgs[6];
		}else{
			nombre = campAgruArgs[0];
			titulo = campAgruArgs[1];
			dato = campAgruArgs[2];
			tipoCelda = campAgruArgs[3];
			requerido = campAgruArgs[4];
			tipoDato = campAgruArgs[5];
		}
		
		System.out.println(nombre + " " + titulo + " " + dato + " " 
				+ tipoCelda + " " + requerido + " " + tipoDato);
		//CampoAgrupacion(String nombre, String titulo, Object dato, int tipoCampo, boolean requerido, int tipoDato)
		String plantilla = Plantillas.PLANTILLAS_CELDAS.get(tipoCelda);
		String resultConversion = null;
		if(plantilla != null){
			//int posProp = plantilla.indexOf(Plantillas.ATTR_PROPIEDADES);
			if(numArgs >6){
				plantilla = plantilla.replace(Plantillas.ATTR_PROPIEDADES, " propiedad=\"%s\" ");
				resultConversion = String.format(plantilla, nombre, titulo, propiedades, dato, requerido, tipoDato);
			}else{
				plantilla = plantilla.replace(Plantillas.ATTR_PROPIEDADES, "");
				resultConversion = String.format(plantilla, nombre, titulo, dato, requerido, tipoDato);
			}
		}
		else{
			System.out.println("No se encontro plantilla");
		}
		return resultConversion;
	}
	
	public static String convertirCampoAgrupacionBD(String toConvert){
		
		toConvert = toConvert.substring(toConvert.indexOf("(") + 1, toConvert.lastIndexOf(")"));
		String [] rowCol = toConvert.split(",");
		int row = Integer.parseInt(rowCol[0].trim());
		int col = Integer.parseInt(rowCol[1].trim());
		System.out.println(row + ", " + col);
		
		String [] campAgruArgs = toConvert.substring(toConvert.indexOf("(") + 1 , toConvert.lastIndexOf(")")).split(",");
		System.out.println("Campos detectados...");
		
		String nombre = null;
		String titulo = null;
		String dato = null;
		String requerido = null;
		String tipoCampo = null;
		String tipoDato = null;
		String tabla = null;
		String campo = null;
		String propiedades = null;
		
		for(int i = 0; i < campAgruArgs.length ; i++){
			campAgruArgs[i] = campAgruArgs[i].trim();
		}
		
		int numArgs = campAgruArgs.length;
		
		if(numArgs > 8){
			nombre = campAgruArgs[0];
			titulo = campAgruArgs[1];
			propiedades = "null".equals(campAgruArgs[2])?"":campAgruArgs[2];
			dato = campAgruArgs[3];
			tipoCampo = campAgruArgs[4];
			requerido = campAgruArgs[5];
			tipoDato = campAgruArgs[6];
			tabla = campAgruArgs[7];
			campo = campAgruArgs[8];
		}else{
			nombre = campAgruArgs[0];
			titulo = campAgruArgs[1];
			dato = campAgruArgs[2];
			tipoCampo = campAgruArgs[3];
			requerido = campAgruArgs[4];
			tipoDato = campAgruArgs[5];
			tabla = campAgruArgs[6];
			campo = campAgruArgs[7];
		}
	
		System.out.println(nombre + " " + titulo + " " + dato + " " 
				+ tipoCampo + " " + requerido + " " + tipoDato+ " " + tabla+ " " + campo);
		
		
		String resultConversion = null;
		String plantilla = Plantillas.PLANTILLA_CAMPO_AGRU_BD;
		//int posProp = plantilla.indexOf(Plantillas.ATTR_PROPIEDADES);
		if(numArgs > 8){
			
			if("".equals(propiedades)){
				resultConversion = String.format(plantilla, nombre, titulo, dato, tipoCampo, requerido, tipoDato, tabla, campo);
			}else{
				StringBuffer plantillaAux = new StringBuffer(plantilla);
				plantillaAux.insert(plantillaAux.indexOf("/>") , " propiedad=\"%s\" ");
				plantilla = plantillaAux.toString();
				resultConversion = String.format(plantilla, nombre, titulo, dato, tipoCampo, requerido, tipoDato, tabla, campo, propiedades);
			}
		}else{
			plantilla = plantilla.replace(Plantillas.ATTR_PROPIEDADES, "");
			resultConversion = String.format(plantilla, nombre, titulo, dato, tipoCampo, requerido, tipoDato, tabla, campo);
		}
		//CampoAgrupacionBD(\"F_APUNTE\", \"Fecha de pago:\", null, fApunte, TipoCelda.CAJA_TEXTO, true, TipoDato.FECHA, \"GEAPUNTES\", \"F_APUNTE\"))";
		return resultConversion;
	}
	
}
