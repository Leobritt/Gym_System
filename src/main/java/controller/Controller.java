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

@WebServlet(urlPatterns = { "/Controller", "/login","/goToList","/goToCreate"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GymMemberDAO gymMemberDAO = new GymMemberDAO(); 
	
	static {
		/*Espaço para add novos logins*/
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.salvar(new Login("adm","1234"));

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/goToList")) {
			/*método ir para pagina lista*/
			
		}else if(action.equals("/goToCreate")) {
			/*método ir para add pag*/
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		/* Parametros vindos do login.html */
		String login = request.getParameter("login");
		String senha = request.getParameter("pwd");
		
		System.out.println(login);
		System.out.println(senha);

		LoginDAO loginDAO = new LoginDAO();

		/* O método findByLogin retorna um obj */
		Login l = loginDAO.findByLogin(login, senha);

		if (action.equals("/login")) {
			if (l != null) {
				/* redirecionar para pagina de explicacao */
				RequestDispatcher rd = request.getRequestDispatcher("txt.html");
				rd.forward(request, response);
				System.out.println("sucesso");
			}else {
				/*redirecionar para a pagina de login*/
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
			}
		}
	}
	protected void acessarLista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<GymMember> listaGym = gymMemberDAO.listar();	
		
		
	}
}
