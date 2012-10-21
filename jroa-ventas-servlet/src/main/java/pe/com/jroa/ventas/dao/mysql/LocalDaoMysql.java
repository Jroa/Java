package pe.com.jroa.ventas.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.com.jroa.ventas.dao.LocalDao;
import pe.com.jroa.ventas.dao.VentasDaoException;
import pe.com.jroa.ventas.entities.Local;

public class LocalDaoMysql implements LocalDao{
	private final static Logger logger = Logger.getLogger(LocalDaoMysql.class);
	
	
	@Override
	public void crear(Local entidad) throws VentasDaoException {
		
	}

	@Override
	public void modificar(Local entidad) throws VentasDaoException {
		
	}

	@Override
	public void eliminar(Local entidad) throws VentasDaoException {
		
	}

	@Override
	public Local traerPorId(Local entidad) throws VentasDaoException {
		return null;
	}

	@Override
	public List<Local> traerTodos() throws VentasDaoException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = null;
		List<Local> locales = new ArrayList<Local>();
		Local local=null;
		try{
			connection = ConexionMysql.getInstance().getConnection();
			sql = "select * from local";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			logger.info("Datos de los locales devuelto con exito");
			while(resultSet.next()){
				local = new Local();
				local.setId(resultSet.getInt("loc_id"));
				local.setNombre(resultSet.getString("loc_nom"));
				locales.add(local);
			}
		}catch(VentasDaoException ex){
			logger.error(ex.getMessage());
			throw ex;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: No se pudo traer los datos");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: Desconocido");
		}finally{
			ConexionMysql.getInstance().closeResult(resultSet);
			ConexionMysql.getInstance().closeStatement(statement);
			ConexionMysql.getInstance().closeConnection(connection);
		}
		return locales;
	}

	@Override
	public List<Local> traerPorNombre(String nombre) throws VentasDaoException {
		return null;
	}
	
}
