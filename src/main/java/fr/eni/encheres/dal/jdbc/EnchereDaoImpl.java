package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.config.ConnectionProvider;
import fr.eni.encheres.dal.EnchereDAO;

//commentaire
public class EnchereDaoImpl implements EnchereDAO {
	private final static String SELECT_ALL_ENCHERE = "SELECT e.*, c.pseudo, a.nom_article , a.date_fin_encheres FROM ENCHERES e "
												+ "INNER JOIN UTILISATEURS c ON e.no_utilisateur=c.no_utilisateur "
												+ "INNER JOIN ARTICLES_VENDUS a ON e.no_article=a.no_article ";

	@Override
	public List<Enchere> selectAllEnchere() {
		try(Connection connection = ConnectionProvider.getConnection()){
			List<Enchere> encheres = new ArrayList<>();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERE);
			
			while(rs.next()) {
				encheres.add(new Enchere(
						rs.getInt("no_enchere"),
						rs.getInt("montant_enchere"),
						new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo")),
						new ArticleVendu(rs.getInt("no_article"),rs.getString("nom_article"),rs.getDate("date_fin_encheres").toLocalDate())));
			}
						
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
