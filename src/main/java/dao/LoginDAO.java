package dao;

import java.util.ArrayList;
import java.util.Optional;

import model.Login;

public class LoginDAO {

	public static ArrayList<Login> listaLogin = new ArrayList<>();


	public void salvar(Login login) {
		listaLogin.add(login);
	}

	/* Retorna um obj com login e senha compativeis com condicao */
	public Login findByLogin(String login, String senha) {
		Optional<Login> loginOptional = listaLogin.stream().filter(e -> e != null && e.getLogin() != null
				&& e.getSenha() != null && e.getLogin().equals(login) && e.getSenha().equals(senha)).findFirst();
		return loginOptional.orElse(null);
	}

}
