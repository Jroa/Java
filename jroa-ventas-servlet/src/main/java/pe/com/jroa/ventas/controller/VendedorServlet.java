package pe.com.jroa.ventas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import pe.com.jroa.ventas.entities.Local;
import pe.com.jroa.ventas.entities.Vendedor;
import pe.com.jroa.ventas.service.VendedorService;
import pe.com.jroa.ventas.service.VentasFactoryService;
import pe.com.jroa.ventas.service.VentasServiceException;
import pe.com.jroa.ventas.util.Fecha;
import pe.com.jroa.ventas.util.Sexo;

@WebServlet(name="VendedorServlet", urlPatterns={"/vendedornuevo.htm",
												"/vendedormodificar.htm",
												"/vendedoreliminar.htm",
												"/vendedorconsultarpornombre.htm"})
public class VendedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(VendedorServlet.class);

	protected void service(HttpServletRequest req, 
		HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		
		if(path.equals("/vendedornuevo.htm")){
			nuevo(req, resp);
		}else if (path.equals("/vendedormodificar.htm")){
			modificar(req, resp);
		}else if (path.equals("/vendedoreliminar.htm")){
			eliminar(req, resp);
		}else if (path.equals("/vendedorconsultarpornombre.htm")){
			consultarPorNombre(req, resp);
		}
		
	}
	
	private void redirectServlet(String path, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher(path).forward(req, resp);
	}
	
	public void nuevo(HttpServletRequest req, 
						HttpServletResponse resp)
						throws ServletException, IOException {

		try {
			VendedorService vendedorService = VentasFactoryService.getFactory().getVendedorService();
			Vendedor vendedor = new Vendedor();
			vendedor.setNombre(req.getParameter("txtNombre"));
			vendedor.setApellido(req.getParameter("txtApellido"));
			vendedor.setDireccion(req.getParameter("txtDireccion"));
			vendedor.setFecnac(Fecha.getDateFromString("txtFecNac"));
			vendedor.setSexo(Sexo.convertStringToBoolean(req.getParameter("rbtnSexo")));
			
			Local local = new Local();
			local.setId(Integer.parseInt(req.getParameter("cboLocal")));
			vendedor.setLocal(local);
			
			vendedorService.crear(vendedor);
			redirectServlet("/abrirvendedornuevo.htm", req, resp);
		} catch (VentasServiceException ex) {
			logger.error(ex.getMessage());
		} catch (Exception ex){
			resp.sendRedirect("error.jsp");
		}
	}

	public void modificar(HttpServletRequest req, 
						HttpServletResponse resp)
						throws ServletException, IOException {

		try {
			VendedorService vendedorService = VentasFactoryService.getFactory().getVendedorService();
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.parseInt(req.getParameter("txtId")));
			vendedor.setNombre(req.getParameter("txtNombre"));
			vendedor.setApellido(req.getParameter("txtApellido"));
			vendedor.setDireccion(req.getParameter("txtDireccion"));
			vendedor.setFecnac(Fecha.getDateFromString("txtFecNac"));
			vendedor.setSexo(Sexo.convertStringToBoolean(req.getParameter("rbtnSexo")));
			
			Local local = new Local();
			local.setId(Integer.parseInt(req.getParameter("cboLocal")));
			vendedor.setLocal(local);
			
			vendedorService.crear(vendedor);
			redirectServlet("/vendedorconsultarpornombre.htm?txtNombre="+req.getParameter("txtFiltro"), req, resp);
		} catch (VentasServiceException ex) {
			logger.error(ex.getMessage());
		} catch (Exception ex){
			resp.sendRedirect("error.jsp");
		}		
	}

	public void eliminar(HttpServletRequest req, 
						HttpServletResponse resp)
						throws ServletException, IOException {
		
	}

	public void consultarPorNombre(HttpServletRequest req, 
			HttpServletResponse resp)
			throws ServletException, IOException {

}
	
	
}
