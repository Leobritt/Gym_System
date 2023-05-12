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
			
			pst.executeUpdate();
		} catch (Exception e) { 	
			System.out.println(e);
		}
	}
	/*Método Buscar pelo id*/
	public GymMember findById(int id) {
		GymMember gymMember = new GymMember();
		String query = "SELECT * FROM gym_record WHERE gym_member_id = ?";
		
		try {
			Connection con = new Conexao().conectar();

			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Integer idGymMember = rs.getInt("gym_member_id");
				String nameGymMember = rs.getString("gym_member_name");
				String sexGymMember = rs.getString("gym_member_sex");
				String weightGymMember = rs.getString("gym_member_weight");
				
				gymMember.setId(idGymMember);
				gymMember.setNome(nameGymMember);
				gymMember.setPeso(weightGymMember);
				gymMember.setSexo(sexGymMember);
				
				
				return gymMember;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/*Método editar*/
	public void alterarGymMember(GymMember gymMember) {
		String query = "UPDATE gym_record SET gym_member_name = ?, gym_member_sex = ?, gym_member_weight = ? WHERE gym_member_id = ?";
		
		try {
			Connection con = new Conexao().conectar();
			
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, gymMember.getNome());
			pst.setString(2, gymMember.getSexo());
			pst.setString(3, gymMember.getPeso());
			pst.setInt(4, gymMember.getId());

			pst.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*Método deletar*/
	public void deletarGymMember(GymMember gymMember) {
		String query = "DELETE FROM gym_record WHERE gym_member_id = ?";
		
		try {
			Connection con = new Conexao().conectar();

			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, gymMember.getId());
			
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
