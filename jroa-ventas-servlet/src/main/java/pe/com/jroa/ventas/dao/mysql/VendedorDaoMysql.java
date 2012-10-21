package pe.com.jroa.ventas.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.com.jroa.ventas.dao.VendedorDao;
import pe.com.jroa.ventas.dao.VentasDaoException;
import pe.com.jroa.ventas.entities.Local;
import pe.com.jroa.ventas.entities.Vendedor;
import pe.com.jroa.ventas.util.Fecha;

import com.mysql.jdbc.PreparedStatement;

public class VendedorDaoMysql implements VendedorDao{

	private final static Logger logger = Logger.getLogger(VendedorDaoMysql.class);
	
	@Override
	public void crear(Vendedor vendedor) throws VentasDaoException {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql = null;
		Date fechaNacimiento = null;
		try{
			connection = ConexionMysql.getInstance().getConnection();
			sql = "insert into vendedor(ven_nom, ven_ape, ven_tel, ven_dir, ven_fec_nac, ven_sexo, loc_id)" +
					"values(?, ?, ?, ?, ?, ?, ?)";
			
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
			prepareStatement.setString(1, vendedor.getNombre());
			prepareStatement.setString(2, vendedor.getApellido());
			prepareStatement.setString(3, vendedor.getTelefono());
			prepareStatement.setString(4, vendedor.getDireccion());
			fechaNacimiento = Fecha.dateFromUtilToSql(vendedor.getFecnac());
			prepareStatement.setDate(5, fechaNacimiento);
			prepareStatement.setBoolean(6, vendedor.isSexo());
			prepareStatement.setInt(7, vendedor.getLocal().getId());
			
			int registrosAfectados = prepareStatement.executeUpdate();
			if(registrosAfectados!=1){
				throw new VentasDaoException("Error: 0 registros afectados");
			}else{
				logger.info("Vendedor creado correctamente");
			}
		}catch(VentasDaoException ex){
			logger.error(ex.getMessage());
			throw ex;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: No se pudo crear el registro");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: Desconocido");
		}finally{
			ConexionMysql.getInstance().closeStatement(prepareStatement);
			ConexionMysql.getInstance().closeConnection(connection);
		}
	}

	@Override
	public void modificar(Vendedor vendedor) throws VentasDaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		Date fechaNacimiento = null;
		try{
			connection = ConexionMysql.getInstance().getConnection();
			sql = "update vendedor "+ 
					"set ven_nom = ?, ven_ape = ?, ven_tel = ?, ven_dir = ?, ven_fec_nac = ?, ven_sexo = ?, loc_id = ? "+
					"where ven_id = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, vendedor.getNombre());
			preparedStatement.setString(2, vendedor.getApellido());
			preparedStatement.setString(3, vendedor.getTelefono());
			preparedStatement.setString(4, vendedor.getDireccion());
			fechaNacimiento = Fecha.dateFromUtilToSql(vendedor.getFecnac());
			preparedStatement.setDate(5, fechaNacimiento);
			preparedStatement.setBoolean(6, vendedor.isSexo());
			preparedStatement.setInt(7, vendedor.getLocal().getId());
			preparedStatement.setInt(8, vendedor.getId());
			
			int registrosAfectados = preparedStatement.executeUpdate();
			logger.info("El vendedor se actualizo con exito");
			if (registrosAfectados!=1){
				throw new VentasDaoException("Error: 0 registros afectados");
			}
		}catch(VentasDaoException ex){
			logger.error(ex.getMessage());
			throw ex;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: No se pudo modificar el vendedor");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: Desconocido");
		}finally{
			ConexionMysql.getInstance().closeStatement(preparedStatement);
			ConexionMysql.getInstance().closeConnection(connection);
		}
	}

	@Override
	public void eliminar(Vendedor vendedor) throws VentasDaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		try{
			connection = ConexionMysql.getInstance().getConnection();
			sql = "delete from vendedor where ven_id = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, vendedor.getId());
			
			int registrosAfectados = preparedStatement.executeUpdate();
			if (registrosAfectados!=1){
				throw new VentasDaoException("Error: 0 registros afectados");
			}
			logger.info("Se elimino el vendedor con exito");
		}catch(VentasDaoException ex){
			logger.error(ex.getMessage());
			throw ex;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: No se pudo eliminar el registro");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: Desconocido");
		}finally{
			ConexionMysql.getInstance().closeStatement(preparedStatement);
			ConexionMysql.getInstance().closeConnection(connection);
		}
				
	}

	@Override
	public Vendedor traerPorId(Vendedor vendedor) throws VentasDaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		Vendedor vendedorEncontrado = null;
		try{
			connection = ConexionMysql.getInstance().getConnection();
			sql = "select * from vendedor,local where vendedor.loc_id = local.loc_id and vendedor.ven_id = ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, vendedor.getId());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				vendedorEncontrado = new Vendedor();
				vendedorEncontrado.setId(resultSet.getInt("ven_id"));
				vendedorEncontrado.setNombre(resultSet.getString("ven_nom"));
				vendedorEncontrado.setApellido(resultSet.getString("ven_ape"));
				vendedorEncontrado.setDireccion(resultSet.getString("ven_dir"));
				vendedorEncontrado.setFecnac(resultSet.getDate("ven_fec_nac"));
				vendedorEncontrado.setSexo(resultSet.getBoolean("ven_sexo"));
				vendedorEncontrado.setLocal(new Local(resultSet.getInt("loc_id"),resultSet.getString("loc_nom")));
				logger.info("Se lleno datos del vendedor");
			}
		}catch(VentasDaoException ex){
			logger.error(ex.getMessage());
			throw ex;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: No se pudo recuperar los datos del vendedor");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: Desconocido");
		}finally{
			ConexionMysql.getInstance().closeResult(resultSet);
			ConexionMysql.getInstance().closeStatement(preparedStatement);
			ConexionMysql.getInstance().closeConnection(connection);
		}
		return vendedorEncontrado;
	}

	@Override
	public List<Vendedor> traerTodos() throws VentasDaoException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = null;
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		Vendedor vendedor =null;
		try{
			connection = ConexionMysql.getInstance().getConnection();
			sql = "select * from vendedor, local where vendedor.loc_id = local.loc_id";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				vendedor = new Vendedor();
				vendedor.setId(resultSet.getInt("ven_id"));
				vendedor.setNombre(resultSet.getString("ven_nom"));
				vendedor.setApellido(resultSet.getString("ven_ape"));
				vendedor.setTelefono(resultSet.getString("ven_tel"));
				vendedor.setDireccion(resultSet.getString("ven_dir"));
				vendedor.setFecnac(resultSet.getDate("ven_fec_nac"));
				vendedor.setSexo(resultSet.getBoolean("ven_sexo"));
				vendedor.setLocal(new Local(resultSet.getInt("loc_id"),resultSet.getString("loc_nom")));
				vendedores.add(vendedor);
			}
		}catch(VentasDaoException ex){
			throw ex;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: no se puede recuperar todos los empleados");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: Desconocido");
		}finally{
			ConexionMysql.getInstance().closeResult(resultSet);
			ConexionMysql.getInstance().closeStatement(statement);
			ConexionMysql.getInstance().closeConnection(connection);
		}
		return vendedores;
	}

	@Override
	public List<Vendedor> traerPorNombre(String nombre)
			throws VentasDaoException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		Vendedor vendedor = null;
		try{
			connection = ConexionMysql.getInstance().getConnection();
			sql = "select * from vendedor, local where vendedor.loc_id = local_loc_id and vendedor.ven_nom like ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, nombre + "%");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				vendedor = new Vendedor();
				vendedor.setId(resultSet.getInt("ven_id"));
				vendedor.setNombre(resultSet.getString("ven_nom"));
				vendedor.setApellido(resultSet.getString("ven_ape"));
				vendedor.setTelefono(resultSet.getString("ven_tel"));
				vendedor.setDireccion(resultSet.getString("ven_dir"));
				vendedor.setFecnac(resultSet.getDate("ven_fec_nac"));
				vendedor.setSexo(resultSet.getBoolean("ven_sexo"));
				vendedor.setLocal(new Local(resultSet.getInt("loc_id"),resultSet.getString("loc_nom")));
				vendedores.add(vendedor);				
			}
		}catch(VentasDaoException ex){
			throw ex;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: al recuperar por nombre");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: desconocido");
		}finally{
			ConexionMysql.getInstance().closeResult(resultSet);
			ConexionMysql.getInstance().closeStatement(preparedStatement);
			ConexionMysql.getInstance().closeConnection(connection);
		}
		
		return vendedores;
	}

	@Override
	public List<Vendedor> traerPorLocal(int ind) throws VentasDaoException {
		return null;
	}

	@Override
	public List<Map<String, Object>> traerPorNombreMap(String nombre)
			throws VentasDaoException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		List<Map<String,Object>> vendedores = new ArrayList<Map<String,Object>>();
		Map<String,Object> vendedor = null;
		try{
			connection = ConexionMysql.getInstance().getConnection();
			sql = "select * from vendedor, local where vendedor.loc_id = local_loc_id and vendedor.ven_nom like ?";
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, nombre + "%");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				vendedor = new HashMap<String, Object>();
				vendedor.put("id",resultSet.getInt("ven_id"));
				vendedor.put("nombre",resultSet.getString("ven_nom"));
				vendedor.put("apellido",resultSet.getString("ven_ape"));
				vendedor.put("telefono",resultSet.getString("ven_tel"));
				vendedor.put("local",resultSet.getString("loc_nom"));
				vendedores.add(vendedor);				
			}
		}catch(VentasDaoException ex){
			throw ex;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: No se puedo traer los datos");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw new VentasDaoException("Error: desconocido");
		}finally{
			ConexionMysql.getInstance().closeResult(resultSet);
			ConexionMysql.getInstance().closeStatement(preparedStatement);
			ConexionMysql.getInstance().closeConnection(connection);
		}
		
		return vendedores;

	}

}
