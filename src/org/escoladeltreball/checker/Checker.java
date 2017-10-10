package org.escoladeltreball.checker;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Servlet implementation class Checker
 */
@WebServlet("/Checker")
public class Checker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		String name = request.getParameter("nombre");
		String surname = request.getParameter("apellido");
		String date = request.getParameter("fecha");
		int nif = Integer.parseInt(request.getParameter("nif"));
		String newNif = "" + nif;
		String dni = request.getParameter("dni");
		String letterList = "TRWAGMYFPDXBNJZSQVHLCKE";
		char letter = letterList.charAt(nif%23);
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test1", "daniel", "jupiter");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM cliente");
			ResultSet rs = (ResultSet) stmt.executeQuery();
		while (rs.next()) {
			
			System.out.println("nombre " + rs.getString("nombre"));
			System.out.println("pass " + rs.getString("contraseña"));
			System.out.println("dni " + rs.getString("dni"));
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
				
		name.replace(" ", "");
		surname.replace(" ", "");
			if (!name.matches("[a-z A-Z]*")) {
				name = "\"Incorrect name\"";
			}
			if (!surname.matches("[a-zA-Z]* [a-zA-Z]*")) {
				surname = "\"Incorrect surname\"";
			}
			if (!date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
				date = "\"Incorrect date\"";
			}
			if (dni.matches("[0-9]{8}[A-Z]")) {
				if (dni.charAt(8) != letter) {
					dni = "\"Incorrect dni\"";
				}
			} else {
				dni = "\"Incorrect dni\"";
			}
			if (!newNif.matches("[0-9]{8}")) {
				newNif = "\"Incorrect nif\"";
			}
		
		
		request.setAttribute("name", name);
		request.setAttribute("surname", surname);
		request.setAttribute("date", date);
		request.setAttribute("nif", newNif+""+letter);
		request.setAttribute("dni", dni);
		
		request.getRequestDispatcher("/form.jsp").forward(request, response);
	} catch (Exception e) {
		request.getRequestDispatcher("/form.jsp").forward(request, response);
	}
	}
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
