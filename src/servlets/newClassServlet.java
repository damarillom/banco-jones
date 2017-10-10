/**
 * 
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import dao.ClienteDAO;

/**
 * @author iaw26509397
 *
 */
public class newClassServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newClassServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String fecha_nacimiento = request.getParameter("fecha_nacimiento");
		String sexo = request.getParameter("sexo");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String pass = request.getParameter("pass");
		
		Cliente c = ClienteDAO.newUser(dni, nombre, apellidos, fecha_nacimiento, sexo, direccion, telefono, pass);
		
		if(c.isValid()) {
			request.getRequestDispatcher("loginok.jsp").include(request, response);
		} else {
			request.getRequestDispatcher("loginko.jsp").include(request, response);
		}
	
	}
}
