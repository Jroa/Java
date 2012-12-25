package pe.com.jroa.ventas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import pe.com.jroa.ventas.entities.Local;
import pe.com.jroa.ventas.entities.Vendedor;
import pe.com.jroa.ventas.service.LocalService;
import pe.com.jroa.ventas.service.VendedorService;
import pe.com.jroa.ventas.service.VentasFactoryService;
import pe.com.jroa.ventas.service.VentasServiceException;
import pe.com.jroa.ventas.util.Fecha;
import pe.com.jroa.ventas.util.Sexo;

@WebServlet(name="VendedorServlet", urlPatterns={"/vendedorsavenew.htm",
												"/vendedorsaveedit.htm",
												"/vendedordelete.htm",
												"/vendedorconsultarpornombre.htm",
												"/vendedorlista.htm",
												"/vendedorviewedit.htm",
												"/vendedorviewnew.htm"})
public class VendedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(VendedorServlet.class);

	protected void service(HttpServletRequest req, 
		HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		
		if(path.equals("/vendedorsavenew.htm")){
			saveNew(req, resp);
		}else if (path.equals("/vendedorsaveedit.htm")){
			saveEdit(req, resp);
		}else if (path.equals("/vendedordelete.htm")){
			delete(req, resp);
		}else if (path.equals("/vendedorconsultarpornombre.htm")){
			consultarPorNombre(req, resp);
		}else if (path.equals("/vendedorlista.htm")){
			abrirVendedorLista(req, resp);
		}else if (path.equals("/vendedorviewedit.htm")){
			abrirVendedorViewEdit(req, resp);
		}else if (path.equals("/vendedorviewnew.htm")){
			abrirVendedorViewNew(req, resp);
		}
		
	}
	
	private void redirectServlet(String path, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher(path).forward(req, resp);
	}
	
	public void saveNew(HttpServletRequest req, 
						HttpServletResponse resp)
						throws ServletException, IOException {

		try {
			VendedorService vendedorService = VentasFactoryService.getFactory().getVendedorService();
			Vendedor vendedor = new Vendedor();
			vendedor.setNombre(req.getParameter("txtNombre"));
			vendedor.setApellido(req.getParameter("txtApellido"));
			vendedor.setTelefono(req.getParameter("txtTelefono"));
			vendedor.setDireccion(req.getParameter("txtDireccion"));
			vendedor.setFecnac(Fecha.getDateFromString(req.getParameter("txtFecNac")));
			vendedor.setSexo(Sexo.convertStringToBoolean(req.getParameter("rbtnSexo")));
			Local local = new Local();
			local.setId(Integer.parseInt(req.getParameter("cboLocal")));
			vendedor.setLocal(local);

			vendedorService.crear(vendedor);
			//redirectServlet("/vendedorlista.htm", req, resp);
			mostrarVendedores(req, resp);
		} catch (VentasServiceException ex) {
			logger.error(ex.getMessage());
		} catch (Exception ex){
			ex.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}

	public void saveEdit(HttpServletRequest req, 
						HttpServletResponse resp)
						throws ServletException, IOException {

		try {
			VendedorService vendedorService = VentasFactoryService.getFactory().getVendedorService();
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.parseInt(req.getParameter("txtId")));
			vendedor.setNombre(req.getParameter("txtNombre"));
			vendedor.setApellido(req.getParameter("txtApellido"));
			vendedor.setTelefono(req.getParameter("txtTelefono"));
			vendedor.setDireccion(req.getParameter("txtDireccion"));
			vendedor.setFecnac(Fecha.getDateFromString(req.getParameter("txtFecNac")));
			vendedor.setSexo(Sexo.convertStringToBoolean(req.getParameter("rbtnSexo")));
			
			Local local = new Local();
			local.setId(Integer.parseInt(req.getParameter("cboLocal")));
			vendedor.setLocal(local);
			
			vendedorService.modificar(vendedor);
			//redirectServlet("/vendedorlista.htm", req, resp);
			mostrarVendedores(req, resp);
		} catch (VentasServiceException ex) {
			logger.error(ex.getMessage());
		} catch (Exception ex){
			ex.printStackTrace();
			resp.sendRedirect("error.jsp");
		}		
	}

	public void delete(HttpServletRequest req, 
						HttpServletResponse resp)
						throws ServletException, IOException {
		
		try{
			VendedorService vendedorService = VentasFactoryService.getFactory().getVendedorService();
			Vendedor vendedor = new Vendedor();
			int id = Integer.parseInt(req.getParameter("id"));
			vendedor.setId(id);
			vendedorService.eliminar(vendedor);
			
			//redirectServlet("/vendedorlista.htm", req, resp);
			mostrarVendedores(req, resp);
		}catch(VentasServiceException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex){
			ex.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}

	public void consultarPorNombre(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
			try {
				VendedorService vendedorService = VentasFactoryService.getFactory().getVendedorService();
				String nombre = req.getParameter("txtNombre");
				List<Vendedor> vendedores = null;
				vendedores = vendedorService.traerPorNombre(nombre);
				req.setAttribute("vendedores", vendedores);
				req.setAttribute("nombre", nombre);
				
				redirectServlet("/jsp/vendedorlist.jsp",req,resp);
			} catch (VentasServiceException ex) {
				logger.error(ex.getMessage());
			} catch (Exception ex){
				ex.printStackTrace();
				resp.sendRedirect("error.jsp");
			}
	}
	
	public void mostrarVendedores(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException{
		try{
			VendedorService vendedorService = VentasFactoryService.getFactory().getVendedorService();
			List<Vendedor> vendedores = null;
			vendedores = vendedorService.traerPorNombre("");
			req.setAttribute("vendedores", vendedores);
			
			redirectServlet("/jsp/vendedorlist.jsp", req, resp);
		}catch(VentasServiceException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex){
			ex.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}
	
	public void abrirVendedorLista(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException{

		redirectServlet("/jsp/vendedorlist.jsp",req,resp);
	}
	
	
	public void abrirVendedorViewEdit(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException{
	
		try {
			List<Local> locales = new ArrayList<Local>();
			LocalService localService = VentasFactoryService.getFactory().getLocalService();
			locales = localService.traerTodos();
			String vendedorAction = "vendedorsaveedit.htm";
			
			VendedorService vendedorService = VentasFactoryService.getFactory().getVendedorService();
			Vendedor vendedor = new Vendedor();
			int vendedorId = Integer.parseInt(req.getParameter("id"));
			vendedor.setId(vendedorId);
			vendedor = vendedorService.traerPorId(vendedor);
			
			req.setAttribute("locales", locales);
			req.setAttribute("vendedorAction", vendedorAction);
			
			req.setAttribute("vendedor", vendedor);
			
			redirectServlet("/jsp/vendedorview.jsp", req, resp);
		} catch (VentasServiceException ex) {
			logger.error(ex.getMessage());
		} catch (Exception ex){
			ex.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}
	
	public void abrirVendedorViewNew(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException{
	
		try {
			LocalService localService = VentasFactoryService.getFactory().getLocalService();
			List<Local> locales = new ArrayList<Local>();
			locales = localService.traerTodos();
			String vendedorAction = "vendedorsavenew.htm";
			
			req.setAttribute("locales", locales);
			req.setAttribute("vendedorAction", vendedorAction);
			
			redirectServlet("/jsp/vendedorview.jsp", req, resp);
		} catch (VentasServiceException ex) {
			logger.error(ex.getMessage());
		} catch (Exception ex){
			resp.sendRedirect("error.jsp");
		}
	}
	
}
