package controller;

import java.io.IOException;
import java.lang.reflect.Array;
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
		"/updateGM","/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GymMemberDAO gymMemberDAO = new GymMemberDAO();
	GymMember gymMember = new GymMember();

	static {
		/* Espaço para add novos logins */
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.salvar(new Login("adm", "1234"));

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/goToList")) {
			/* método ir para pagina lista */
			acessarLista(request, response);

		} else if (action.equals("/goToCreate")) {
			/* método ir para add pag */
			telaAdd(request, response);
		} else if (action.equals("/createGM")) {
			createGM(request, response);
		} else if (action.equals("/goToUpdate")) {
			/* método para ir pag update */
			telaUpdateGM(request, response);
		}else if(action.equals("/delete")) {
			/*método para ir */
			deleteGM(request, response);
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
			} else if (action.equals("/updateGM")) {
				/* método para fazer Update */
				updateGM(request, response);

			} else {
				/* redirecionar para a pagina de login */
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
			}
		}
	}

	protected void acessarLista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<GymMember> listaGymMember = gymMemberDAO.listar();
		request.setAttribute("listaGM", listaGymMember);
		RequestDispatcher rd = request.getRequestDispatcher("listGymMember.jsp");
		rd.forward(request, response);
		listaGymMember.forEach(System.out::println);
	}

	protected void telaAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<GymMember> listaGymMember = gymMemberDAO.listar();
		request.setAttribute("listaGM", listaGymMember);
		RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
		rd.forward(request, response);
	}

	protected void createGM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		gymMember.setNome(request.getParameter("name"));
		gymMember.setSexo(request.getParameter("sexOption"));
		gymMember.setPeso(request.getParameter("weight"));

		gymMemberDAO.addGymMember(gymMember);

		response.sendRedirect("txt.html");

	}

	protected void telaUpdateGM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		gymMember = gymMemberDAO.findById(id);

		ArrayList<GymMember> listaGymMember = gymMemberDAO.listar();
		request.setAttribute("listaGM", listaGymMember);
		request.setAttribute("gymMember", gymMember);

		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);

	}

	protected void updateGM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		gymMember.setId(Integer.parseInt(request.getParameter("id")));
		gymMember.setNome(request.getParameter("name"));
		gymMember.setSexo(request.getParameter("sexOption"));
		gymMember.setPeso(request.getParameter("weight"));
		
		
		gymMemberDAO.alterarGymMember(gymMember);
		
		RequestDispatcher rd = request.getRequestDispatcher("listGymMember.jsp");
		rd.forward(request, response);
	}
	protected void deleteGM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		System.out.println("hello");
		gymMember.setId(id);
		
		gymMemberDAO.deletarGymMember(gymMember);
		
		response.sendRedirect("txt.html");
		
	}
	
	
}
