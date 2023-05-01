package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.GymMember;

public class GymMemberDAO {
	Connection con = new Conexao().conectar();
	
	
	/*Método Read*/
	public ArrayList<GymMember> listar(){
		ArrayList<GymMember> lista =  new ArrayList<>();
		String query = "SELECT * FROM gym_record";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			while (rs.next()) {
				Integer idGymMember = rs.getInt("gym_member_id");
				String nomeGymMember = rs.getString("gym_member_name");
				String sexGymMember = rs.getString("gym_member_sex");
				String weightGymMember = rs.getString("gym_member_weight");
				
				lista.add(new GymMember(idGymMember,nomeGymMember,sexGymMember,weightGymMember));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lista;
	}
	
	
}
