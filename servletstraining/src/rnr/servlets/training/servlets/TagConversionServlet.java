package rnr.servlets.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rnr.servlets.training.util.TagConversor;

/**
 * Servlet implementation class TagConversionServlet
 */
public class TagConversionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String toConvert = request.getParameter("entrada");
		PrintWriter out = response.getWriter();
		String resultConversion = null;
		try {
			if(toConvert.indexOf("CampoAgrupacionBD") >= 0){
				resultConversion = TagConversor.convertirCampoAgrupacionBD(toConvert);
			}
			else if(toConvert.indexOf("CampoAgrupacion") >= 0){
				resultConversion = TagConversor.convertirCampoAgrupacion(toConvert);
			}
			else if(toConvert.indexOf("addValidacionCampo") >= 0){
				resultConversion = TagConversor.convertirValidacion(toConvert);
			}else if(toConvert.indexOf("addAccionPosteriorCampo") >= 0){
				resultConversion = TagConversor.convertirAccionPosterior(toConvert);
			}else if(toConvert.indexOf("addCampoOculto") >= 0){
				resultConversion = TagConversor.convertirCampoOculto(toConvert);
			}else if(toConvert.indexOf("addPropiedadCampo") >= 0){
				resultConversion = TagConversor.convertirCampoPropiedad(toConvert);
			}
			//String resultConversion = convertirValidacion(toConvert);
			System.out.println(resultConversion);
			
			RequestDispatcher rd = request.getRequestDispatcher("conversor.jsp");
			request.setAttribute("resultado", resultConversion);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}finally{
			out.close();
		}
		
	}

}
