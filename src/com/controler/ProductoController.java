package com.controler;

import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UsuarioDao;
import com.modelo.Usuario;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(name = "UsuarioController", description = "administra peticiones para la tabla usuario", urlPatterns = { "/Usuario" })
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String opcion=request.getParameter("opcion");
		
		if (opcion.equals("crear")) {
			System.out.println("usted a precionado crear");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		}
		else if (opcion.equals("listar")) {
			System.out.println("usted a precionado listar");
			UsuarioDao usuarioDao=new UsuarioDao();
			ArrayList<Usuario> lista=new ArrayList<>();
			try {
				lista=usuarioDao.consultar();
				for (Usuario usuario : lista) {
					System.out.println("lista"+usuario);
				}
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);
				
				
			} catch (Exception e) {
			System.out.println(e);
			}
		
		}
		else if (opcion.contentEquals("consula") ) {
			
			UsuarioDao pDao=new UsuarioDao();
			Usuario usuario=new Usuario();
			
			int id;
			try {
				usuario=pDao.consultaId(id=Integer.parseInt(request.getParameter("id")));
				System.out.println("el id es este : "+id);
				System.out.println(usuario);
				request.setAttribute("usuario", usuario);
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/editar.jsp");
				requestDispatcher.forward(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
else if (opcion.contentEquals("eliminar")) {
			
			UsuarioDao pDao=new UsuarioDao();
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				pDao.eliminar(id);
				System.out.println("Registro eliminado");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		String opcionString=request.getParameter("opcion");
		if (opcionString.equals("guardar")) {
			UsuarioDao usuarioDao=new UsuarioDao();
			Usuario usuario=new Usuario();
			
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setApellido(request.getParameter("apellido"));
			usuario.setDireccion(request.getParameter("direccion"));
			
			try {
				usuarioDao.guardar(usuario);
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (opcionString.equals("actualizar")) {
			 Usuario usuario=new Usuario();
			 UsuarioDao usuarioDao=new UsuarioDao();
			 
			 usuario.setId(Integer.parseInt(request.getParameter("id")));
			 usuario.setNombre(request.getParameter("nombre"));
				usuario.setApellido(request.getParameter("apellido"));
				usuario.setDireccion(request.getParameter("direccion"));
				
			 try {
				 usuarioDao.editar(usuario);
				 RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
					requestDispatcher.forward(request, response);
			
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

		
		
		
		
		
		
	}

}
