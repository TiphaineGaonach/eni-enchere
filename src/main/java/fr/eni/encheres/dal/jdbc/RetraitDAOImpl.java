package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.config.ConnectionProvider;
import fr.eni.encheres.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO{
	
	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS ("
			+ "no_article, rue, code_postal, ville  ) VALUES (?,?,?,?)";
	
	
	

	@Override
	public Retrait selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Retrait> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Retrait retrait) {
		// TODO Auto-generated method stub
			try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement  stmt = connection.prepareStatement(
											INSERT_RETRAIT
											//PreparedStatement.RETURN_GENERATED_KEYS
										);
			prepareRetraitSQL(retrait, stmt);// Extrait les info de l'objet Truc pour le stmt
			
			
			stmt.executeUpdate();
			//ResultSet rs = stmt.getGeneratedKeys();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void delete(Retrait retrait) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Retrait retrait) {
		// TODO Auto-generated method stub
		
	}
	
	private void prepareRetraitSQL(Retrait retrait, PreparedStatement stmt) throws SQLException {
		stmt.setInt(1, retrait.getArticleVendu().getNoArticle());
		stmt.setString(2, retrait.getRue());
		stmt.setString(3, retrait.getCodePostal());
		stmt.setString(4, retrait.getVille());
		
		
	}

}
