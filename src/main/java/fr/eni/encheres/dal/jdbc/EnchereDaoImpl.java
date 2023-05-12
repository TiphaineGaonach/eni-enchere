package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.config.ConnectionProvider;
import fr.eni.encheres.dal.EnchereDAO;

//commentaire
public class EnchereDaoImpl implements EnchereDAO {
	
	private final static String SELECT_ALL_ENCHERES = "SELECT * FROM ENCHERES";
	
	private final String INSERT_ENCHERE = "INSERT INTO ENCHERES(no_utilisateur,no_article,date_enchere,montant_enchere) VALUES (?,?,?,?);";
	
	private final String UPDATE_ENCHERE = "UPDATE ENCHERES SET date_enchere=?, montant_enchere=? WHERE no_utilisateur=? AND no_article=? ;";


	@Override
	public List<Enchere> selectAllEnchere() {
		try(Connection connection = ConnectionProvider.getConnection()){
			List<Enchere> encheres = new ArrayList<>();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERES);
			

			while(rs.next()) {
				// conversion de la date !!
				LocalDate localDate = rs.getDate("date_enchere").toLocalDate();
				LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.MIDNIGHT);
				
				encheres.add(new Enchere(localDateTime,
						rs.getInt("montant_enchere"),
						new Utilisateur (rs.getInt("no_utilisateur")),
						new ArticleVendu (rs.getInt("no_article"))));
			}
			return encheres;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public void insertEnchere(Enchere enchere) {
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			
			LocalDateTime dateTime = LocalDateTime.now();
			
			PreparedStatement pStmt = connection.prepareStatement(INSERT_ENCHERE);
			pStmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pStmt.setInt(2, enchere.getArticleVendu().getNoArticle());
			pStmt.setObject(3, dateTime);
			pStmt.setInt(4, enchere.getMontantEnchere());
			
			
			pStmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateEnchere(Enchere enchere) {
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			
			LocalDateTime dateTime = LocalDateTime.now();
			
			PreparedStatement pStmt = connection.prepareStatement(UPDATE_ENCHERE);
			pStmt.setObject(1, dateTime);
			pStmt.setInt(2, enchere.getMontantEnchere());
			pStmt.setInt(3, enchere.getUtilisateur().getNoUtilisateur());					
			pStmt.setInt(4, enchere.getArticleVendu().getNoArticle());
			
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public Enchere selectOneEnchere(Integer noUtilisateur, Integer noArticle) {

		return null;
	}


}
