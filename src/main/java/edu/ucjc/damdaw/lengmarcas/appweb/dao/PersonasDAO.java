package edu.ucjc.damdaw.lengmarcas.appweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.ucjc.damdaw.lengmarcas.appweb.clases.Persona;

/**
 * Clase para gestionar los datos de la tabla TB_PERSONAS
 * @author josel
 *
 */
public class PersonasDAO {
	private Connection connection;

	public PersonasDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void insertarPersonas(Persona persona) throws SQLException{
		insertarPersonas(persona.getId(),persona.getNombre(),persona.getEdad());
	}
	
	public void insertarPersonas(String id, String nombre, int edad) throws SQLException{
		String insertQuery = "INSERT INTO TB_PERSONAS VALUES ( ?, ?, ?)";
		
        PreparedStatement psInsert;
        
		psInsert = connection.prepareStatement(insertQuery);
        psInsert.setString(1, id);
        psInsert.setString(2, nombre);
        psInsert.setInt(3, edad);
        
        System.out.println("Insertando registro");
        psInsert.executeUpdate();
        System.out.println("Registro insertado");
	        
		
        System.out.println("Added another row of test data to the database");
	}
	
}
