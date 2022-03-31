package edu.ucjc.damdaw.lengmarcas.appweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculaEdadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entrando doGet");
		String edadString =  req.getParameter("edad");
		if(edadString!=null) {
			int edad = Integer.parseInt(edadString);
			//int edad = Integer.parseInt(req.getParameter("edad"));
			String ciudad = req.getParameter("ciudad");
			
			int anioNacimiento = 2022 - edad;
			
			
			String contenidoHtml = generaContenidoHtml(ciudad, anioNacimiento);
			resp.getWriter().append(  contenidoHtml );
		}else {
			resp.getWriter().append(  "<H1><u>FALTA EL PARAMETRO EDAD</u></H1>" );
		}
		
	}
	
	private String generaContenidoHtml(String ciudad, int anioNacimiento) {
		String pagina = "";
		
		pagina = "<h1>HOLA eres de " +
				ciudad + " y has nacido en " + anioNacimiento + "</H1>";
		
		System.out.println(pagina);
		return pagina;
	}
	
	
	
}





