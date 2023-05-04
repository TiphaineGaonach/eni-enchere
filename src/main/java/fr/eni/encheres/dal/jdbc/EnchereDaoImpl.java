package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.config.ConnectionProvider;
import fr.eni.encheres.dal.EnchereDAO;

//commentaire
public class EnchereDaoImpl implements EnchereDAO {
	private final static String SELECT_ALL_ENCHERE = "SELECT * FROM ENCHERES";

	@Override
	public List<Enchere> selectAllEnchere() {
		try(Connection connection = ConnectionProvider.getConnection()){
			List<Enchere> encheres = new ArrayList<>();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERE);
			
//			while(rs.next()) {
//				encheres.add(new Enchere(rs.getInt("no_utilisateur"),
//						rs.getInt("no_article"),
//						rs.getDate("date_enchere").toLocalDate(),
//						rs.getInt("montant_enchere");
//			}
			
			
			return encheres;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Enchere selectOneEnchere(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

}
