package edu.ucjc.damdaw.lengmarcas.appweb.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioUsuarioServlet
 */
@WebServlet(
		urlPatterns = { "/altausuario" }, 
		initParams = { 
				@WebInitParam(name = "paramIni1", value = "Valor1")
		})
public class FormularioUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String param1;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.param1 = config.getInitParameter("paramIni1");
		System.out.println("param1: "+param1);
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando en doPost");
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("contrasenia");
		String ciudad = request.getParameter("ciudad");
		
		System.out.println("Entrando en doPost" + nombre);
		System.out.println("Entrando en doPost" + usuario);
		System.out.println("Entrando en doPost" + password);
		System.out.println("Entrando en doPost" + ciudad);
		
		String html ="<H1>USUARIO</H1>";
		if (param1.equals("valor1")) {
			
			//html = html + "<p></p>"; 
			html += "<p>Nombre : "+ nombre +"</p>";
			html += "<p>Usuario : "+ usuario +"</p>";
			html += "<p>Ciudad : "+ ciudad +"</p>";
			html += "<p>Param1 : "+ param1 +"</p>";
		}
		response.getWriter().append(html);
		
	}

}














