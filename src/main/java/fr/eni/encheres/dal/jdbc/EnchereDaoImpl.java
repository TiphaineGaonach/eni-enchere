package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.config.ConnectionProvider;
import fr.eni.encheres.dal.EnchereDAO;

//commentaire
public class EnchereDaoImpl implements EnchereDAO {

	// requete imbriquée pour recupéré le vendeur et non l'user qui a enchéri (user de l'article)
	private final static String SELECT_ALL_ENCHERE = "SELECT e.*, a.nom_article , a.date_fin_encheres, a.no_utilisateur AS no_utilisateur_article,u.pseudo FROM ENCHERES e "
													+"INNER JOIN ARTICLES_VENDUS a ON e.no_article=a.no_article "
													+"INNER JOIN UTILISATEURS u ON a.no_utilisateur=u.no_utilisateur " 
													+"WHERE e.montant_enchere = ( SELECT MAX(montant_enchere) FROM ENCHERES WHERE no_article = e.no_article)";


	private final static String SELECT_ONE_ENCHERE = "SELECT * FROM ENCHERES e "
			+ "INNER JOIN UTILISATEURS u ON e.no_utilisateur=u.no_utilisateur "
			+ "INNER JOIN ARTICLES_VENDUS a ON e.no_article=a.no_article "
			+ "where e.no_utilisateur = ? AND e.no_article = ?";
	
	@Override
	public List<Enchere> selectAllEnchere() {
		try(Connection connection = ConnectionProvider.getConnection()){
			List<Enchere> encheres = new ArrayList<>();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERE);
			
			while(rs.next()) {
				encheres.add(new Enchere(
						rs.getInt("montant_enchere"),
						new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo")),
						new ArticleVendu(rs.getInt("no_article"),rs.getString("nom_article"),rs.getDate("date_fin_encheres").toLocalDate(),new Utilisateur(rs.getInt("no_utilisateur_article")))));
			}
			return encheres;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Enchere selectOneEnchere(Integer noUtilisateur, Integer noArticle) {
		try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = connection.prepareStatement(SELECT_ONE_ENCHERE);
			
			stmt.setInt(1,noUtilisateur);
			stmt.setInt(2,noArticle);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
						return new Enchere(rs.getObject("date_enchere", LocalDateTime.class),
								rs.getInt("montant_enchere"),
								new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo")),
								new ArticleVendu(rs.getInt("no_article"),rs.getString("nom_article"),rs.getDate("date_fin_encheres").toLocalDate()));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
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
