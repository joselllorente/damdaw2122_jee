package edu.ucjc.damdaw.lengmarcas.appweb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucjc.damdaw.lengmarcas.appweb.clases.Persona;
import edu.ucjc.damdaw.lengmarcas.appweb.dao.PersonasDAO;
import edu.ucjc.damdaw.lengmarcas.appweb.utils.UtilsBD;

/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
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

		//Recogemos los parametros del cliente
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		System.out.println(""+ id);
		System.out.println(""+ nombre);
		System.out.println(""+ edad);
		
		//Guardamos en la base de datos
		String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=dam1;"
                       // + "user=testuser;"
                       // + "password=testpassword;"
                       // + "encrypt=true;"
                        //Para autenticación con Windows
                        + "integratedSecurity=true;"
                        + "trustServerCertificate=true;";
                       // + "loginTimeout=10;";
		
		
		Connection connection = UtilsBD.getConnection(connectionUrl);
		
		
		if (connection!=null) {
			System.out.println("CONECTADO A LA BASE DE DATOS");
			
			//Creo el objeto de tipo persona con los datos del html
			Persona persona = new Persona(id, nombre, edad);
			
			//Creo objeto de la clase PersonasDAO pasandole el objeto connection 
			//para insertar informacion
			PersonasDAO personaDAO = new PersonasDAO(connection);
			
			//Invoco metodo insertar pasandole un objeto de tipo Persona
			try {
				personaDAO.insertarPersonas(persona);
				response.getWriter().append("INSERTADO CORRECTAMENTE PERSONA CON ID " + persona.getId());
			} catch (SQLException e1) {
				response.getWriter().append("ERROR INSERTADO LA PERSONA CON ID " + persona.getId() + " " +e1.getMessage());
				e1.printStackTrace();
			}
			
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}

}
