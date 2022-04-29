package edu.ucjc.damdaw.lengmarcas.appweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase con utilidades para gestionar la conexion con la base de datos
 * @author josel
 *
 */
public class UtilsBD {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";        //MySQL
	static final String JDBC_DRIVER_SQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";        //Configure the driver needed
	/**
	 * M�todo para obtener la conexi�n de la base de datos
	 * @param connectionUrl
	 * @return
	 */
	public static Connection getConnection(String connectionUrl)	{
		Connection connection = null;
		System.out.println("Estableciendo conexi�n");
		try  {
			try {
				Class.forName(JDBC_DRIVER_SQLSERVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	connection = DriverManager.getConnection(connectionUrl);
        	System.out.println("Conexi�n establecida");
		}
        catch (SQLException e) {
        	System.err.println("Error al establecer la conexion");
            e.printStackTrace();
        }
		
        return connection;
	}
	
}
