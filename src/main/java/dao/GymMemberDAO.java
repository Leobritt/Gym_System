package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.GymMember;

public class GymMemberDAO {
	Connection con = new Conexao().conectar();

	/* Método Read */
	public ArrayList<GymMember> listar() {
		ArrayList<GymMember> lista = new ArrayList<>();
		String query = "SELECT * FROM gym_record";
		try {
			Connection con = new Conexao().conectar();
			if (con != null) {
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Integer idGymMember = rs.getInt("gym_member_id");
					String nomeGymMember = rs.getString("gym_member_name");
					String sexGymMember = rs.getString("gym_member_sex");
					String weightGymMember = rs.getString("gym_member_weight");
					lista.add(new GymMember(idGymMember, nomeGymMember, sexGymMember, weightGymMember));
				}
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lista;
	}
	/*Método Create*/
	public void addGymMember(GymMember gymMember) {
		String query = "INSERT INTO gym_record (gym_member_name, gym_member_sex, gym_member_weight) VALUES (?,?,?)";
		try {
			Connection con = new Conexao().conectar();
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, gymMember.getNome());
			pst.setString(2, gymMember.getSexo());
			pst.setString(3, gymMember.getPeso());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
