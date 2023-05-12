package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GymMemberDAO;
import dao.LoginDAO;
import model.GymMember;
import model.Login;

@WebServlet(urlPatterns = { "/Controller", "/login", "/goToList", "/goToCreate", "/createGM", "/goToUpdate",
		"/updateGM", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GymMemberDAO gymMemberDAO = new GymMemberDAO();
	GymMember gymMember = new GymMember();

	static {
		/* Space to add new logins */
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.salvar(new Login("adm", "1234"));

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/goToList")) {
			/* method go to page list */
			acessarLista(request, response);

		} else if (action.equals("/goToCreate")) {
			/* method go to add page */
			telaAdd(request, response);
		} else if (action.equals("/createGM")) {
			/* method add GM */
			createGM(request, response);
		} else if (action.equals("/goToUpdate")) {
			/* method to go to page update */
			telaUpdateGM(request, response);
		} else if (action.equals("/delete")) {
			/* method delete */
			deleteGM(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		/* Parameters from login.html */
		String login = request.getParameter("login");
		String senha = request.getParameter("pwd");

		System.out.println(login);
		System.out.println(senha);

		LoginDAO loginDAO = new LoginDAO();

		/* The findByLogin method returns an obj */
		Login l = loginDAO.findByLogin(login, senha);

		if (action.equals("/login")) {
			if (l != null) {
				/* redirect to explanation page */
				RequestDispatcher rd = request.getRequestDispatcher("txt.html");
				rd.forward(request, response);
			} else {
				/* redirect to login page */
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);

			}
		} else if (action.equals("/updateGM")) {
			/* method to do Update */
			updateGM(request, response);

		}
	}

	/* Method to access the list */
	protected void acessarLista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<GymMember> listaGymMember = gymMemberDAO.list();
		request.setAttribute("listaGM", listaGymMember);
		RequestDispatcher rd = request.getRequestDispatcher("listGymMember.jsp");
		rd.forward(request, response);
	}

	/* Method to go to add screen */
	protected void telaAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<GymMember> listaGymMember = gymMemberDAO.list();
		request.setAttribute("listaGM", listaGymMember);
		RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
		rd.forward(request, response);
	}

	/* GM create method */
	protected void createGM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		gymMember.setName(request.getParameter("name"));
		gymMember.setSex(request.getParameter("sexOption"));
		gymMember.setWeight(request.getParameter("weight"));

		gymMemberDAO.addGymMember(gymMember);

		response.sendRedirect("txt.html");

	}

	/* Method to go to update screen */
	protected void telaUpdateGM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		gymMember = gymMemberDAO.findById(id);

		ArrayList<GymMember> listaGymMember = gymMemberDAO.list();
		request.setAttribute("listaGM", listaGymMember);
		request.setAttribute("gymMember", gymMember);

		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);

	}
	/* GM update method */
	protected void updateGM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		gymMember.setId(Integer.parseInt(request.getParameter("id")));
		gymMember.setName(request.getParameter("name"));
		gymMember.setSex(request.getParameter("sexOption"));
		gymMember.setWeight(request.getParameter("weight"));

		gymMemberDAO.updateGymMember(gymMember);

		response.sendRedirect("txt.html");

	}
	/* GM delete method */
	protected void deleteGM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		gymMember.setId(id);

		gymMemberDAO.deleteGymMember(gymMember);

		response.sendRedirect("txt.html");

	}

}
