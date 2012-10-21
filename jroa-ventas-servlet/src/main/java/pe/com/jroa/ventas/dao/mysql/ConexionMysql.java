package pe.com.jroa.ventas.dao.mysql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

import pe.com.jroa.ventas.dao.VentasDaoException;

public class ConexionMysql {
	private final static Logger logger = Logger.getLogger(ConexionMysql.class);

	private static ConexionMysql instance;

	private ConexionMysql() {

	}

	public static ConexionMysql getInstance(){
		if(instance==null){
			instance = new ConexionMysql();
		}
		return instance;
	}
	
	public Connection getConnection() throws VentasDaoException{
		Connection connection = null;
		Properties properties = null;
		try
		{
			properties = new Properties();
			InputStream inputStream = ConexionMysql.class.getResourceAsStream("/pe/com/jroa/ventas/dao/mysql/parametros.properties");
			properties.load(inputStream);
			//Cargar el driver
			Class.forName(properties.getProperty("driver"));
			//obtener la conexion a la BD
			connection = DriverManager.getConnection(
							properties.getProperty("url"), 
							properties.getProperty("user"), 
							properties.getProperty("pass"));

			logger.info("Conexion OK");
		}catch(ClassNotFoundException ex){
			logger.warn(ex.getMessage());
			throw new VentasDaoException("Error: No se pudo cargar el Driver");
		}catch(SQLException ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: No se pudo conectar a la BD");
		}catch(Exception ex){
			logger.warn(ex.getMessage());
			throw new VentasDaoException("Error: desconocido");
		}
	return connection;
	}
	
	public void closeConnection(Connection connection){
		try{
			if(connection!=null){
				connection.close();
			}
		}catch(SQLException ex){
			logger.warn(ex.getMessage());
		}
	}
	
	
	public void closeStatement(Statement statement){
		try{
			if(statement != null){
				statement.close();
			}
		}catch(SQLException ex){
			logger.warn(ex.getMessage());
		}
		
	}
	
	public void closeResult(ResultSet resultSet){
		try{
			if (resultSet != null){
				resultSet.close();
			}
		}catch(SQLException ex){
			logger.warn(ex.getMessage());
		}
	}
}
