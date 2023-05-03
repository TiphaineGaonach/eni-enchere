package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> 82964e7762027af421364b38039dc4b8d7a292fb
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.config.ConnectionProvider;
import fr.eni.encheres.dal.ArticleDAO;

public class ArticleDaoImpl implements ArticleDAO{
<<<<<<< HEAD
=======
	private final static String SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS";
	private final static String SELECT_ONE_ARTICLE = "SELECT * FROM ARTICLES_VENDUS WHERE id = ?";
	private final static String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET  = ?, unMachinEnFloat = ?, unMachinEnString = ?, unMachinEnLocalDate = ?, unMachinEnBoolean = ?, WHERE id = ?";
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (unMachinEnInt, unMachinEnFloat, unMachinEnString, unMachinEnLocalDate, unMachinEnBoolean) VALUES (?,?,?,?,?)";
	private final static String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE id = ?";
	
//	@Override
//	public List<ArticleVendu> selectAll() {
//		System.out.println("dao select all");
//		try(Connection connection = fr.eni.encheres.config.ConnectionProvider.getConnection()){
//			List<ArticleVendu> articles = new ArrayList<>();
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLE);
//			while(rs.next()) {
//				articles.add( new ArticleVendu(
//						rs.getInt("id"),
//						rs.getInt("unMachinEnInt"),
//						rs.getFloat("unMachinEnFloat"),
//						rs.getString("unMachinEnString"),
//						rs.getDate("unMachinEnLocalDate").toLocalDate(),
//						rs.getBoolean("unMachinEnBoolean"))) ;
//			}
//			return articles;
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}		
//		return null;
//	}
//
//	@Override
//	public ArticleVendu selectOne(int id) {
//		try(Connection connection = ConnectionProvider.getConnection()){
//			
//			PreparedStatement  stmt = connection.prepareStatement(SELECT_ONE_TRUC);
//			stmt.setInt(1, id);
//			System.out.println("id à trouver dans la bdd= " + id);
//			ResultSet rs = stmt.executeQuery();
//			if(rs.next()) {
//				
//				return new ArticleVendu(
//						rs.getInt("unMachinEnInt"),
//						rs.getFloat("unMachinEnFloat"),
//						rs.getString("unMachinEnString"),
//						rs.getDate("unMachinEnLocalDate").toLocalDate(),
//						rs.getBoolean("unMachinEnBoolean")) ;
//			}		
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}		
//		return null;
//	}
//
//	@Override
//	public void insert(ArticleVendu truc) { // passage par ref
//		System.out.println("DAOIMPL insert un truc");
//		try(Connection connection = ConnectionProvider.getConnection()){
//			
//			PreparedStatement  stmt = connection.prepareStatement(
//											INSERT_TRUC,
//											PreparedStatement.RETURN_GENERATED_KEYS
//										);
//			prepareTrucSQL(truc, stmt);// Extrait les info de l'objet Truc pour le stmt
//			
//			
//			stmt.executeUpdate();
//			ResultSet rs = stmt.getGeneratedKeys();
//			if(rs.next()) {
//				truc.setId(rs.getInt(1));// Récup de l'ID pour redirection ou complesion de l'objet Truc
//			}
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	@Override
//	public void delete(ArticleVendu truc) {
//		try(Connection connection = ConnectionProvider.getConnection()){					
//			PreparedStatement  stmt = connection.prepareStatement(DELETE_TRUC);
//			stmt.setInt(1, truc.getId());
//			stmt.executeUpdate();		
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}	
//	}
//
//	@Override
//	public void update(ArticleVendu truc) {
//		try(Connection connection = ConnectionProvider.getConnection()){
//			PreparedStatement stmt = connection.prepareStatement(UPDATE_TRUC);
//			prepareTrucSQL(truc, stmt);// Extrait les info de l'objet Truc pour le stmt
//			
//			// ajoute l'id au Where
//			stmt.setInt(6, truc.getId());// remplacer 6 par le numeros du ? qui correspond au Wherre
//			stmt.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();// levee DAL Exception
//		}
//		
//	}
//	/**
//	 * Extrait les Attributs de l'objet Truc pour le PrepareStatement stmt
//	 * @param truc : Objet à insérer ou a modifier dans la base SQL 
//	 * @param stmt : PrepareStatement de l'instruction SQL à préparer
//	 * @throws SQLException
//	 */
//	private void prepareTrucSQL(ArticleVendu truc, PreparedStatement stmt) throws SQLException {
//		
//		stmt.setInt(1, truc.getUnMachinEnInt());// pour ajouter un int
//		stmt.setFloat(2, truc.getUnMachinEnFloat());// pour ajouter un Float
//		stmt.setString(3, truc.getUnMachinEnString());// pour ajouter un String
//		stmt.setDate(4,Date.valueOf(truc.getUnMachinEnLocalDate()));// ajouter une date venant de l'objet Truc
//		stmt.setBoolean(5, truc.isUnMachinEnBoolean()); // pour ajouter un boolean vraix
//	}

>>>>>>> 82964e7762027af421364b38039dc4b8d7a292fb
	
//	private final static String SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS";
//	private final static String SELECT_ONE_ARTICLE = "SELECT * FROM ARTICLES_VENDUS WHERE id = ?";
//	private final static String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET  = ?, unMachinEnFloat = ?, unMachinEnString = ?, unMachinEnLocalDate = ?, unMachinEnBoolean = ?, WHERE id = ?";
//	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (unMachinEnInt, unMachinEnFloat, unMachinEnString, unMachinEnLocalDate, unMachinEnBoolean) VALUES (?,?,?,?,?)";
//	private final static String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE id = ?";
//	
//	@Override
//	public List<ArticleVendu> selectAll() {
//		System.out.println("dao select all");
//		try(Connection connection = fr.eni.encheres.config.ConnectionProvider.getConnection()){
//			List<ArticleVendu> articles = new ArrayList<>();
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLE);
//			while(rs.next()) {
//				articles.add( new ArticleVendu(
//						rs.getInt("id"),
//						rs.getInt("unMachinEnInt"),
//						rs.getFloat("unMachinEnFloat"),
//						rs.getString("unMachinEnString"),
//						rs.getDate("unMachinEnLocalDate").toLocalDate(),
//						rs.getBoolean("unMachinEnBoolean"))) ;
//			}
//			return articles;
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}		
//		return null;
//	}
//
//	@Override
//	public ArticleVendu selectOne(int id) {
//		try(Connection connection = ConnectionProvider.getConnection()){
//			
//			PreparedStatement  stmt = connection.prepareStatement(SELECT_ONE_TRUC);
//			stmt.setInt(1, id);
//			System.out.println("id à trouver dans la bdd= " + id);
//			ResultSet rs = stmt.executeQuery();
//			if(rs.next()) {
//				
//				return new ArticleVendu(
//						rs.getInt("unMachinEnInt"),
//						rs.getFloat("unMachinEnFloat"),
//						rs.getString("unMachinEnString"),
//						rs.getDate("unMachinEnLocalDate").toLocalDate(),
//						rs.getBoolean("unMachinEnBoolean")) ;
//			}		
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}		
//		return null;
//	}
//
//	@Override
//	public void insert(ArticleVendu truc) { // passage par ref
//		System.out.println("DAOIMPL insert un truc");
//		try(Connection connection = ConnectionProvider.getConnection()){
//			
//			PreparedStatement  stmt = connection.prepareStatement(
//											INSERT_TRUC,
//											PreparedStatement.RETURN_GENERATED_KEYS
//										);
//			prepareTrucSQL(truc, stmt);// Extrait les info de l'objet Truc pour le stmt
//			
//			
//			stmt.executeUpdate();
//			ResultSet rs = stmt.getGeneratedKeys();
//			if(rs.next()) {
//				truc.setId(rs.getInt(1));// Récup de l'ID pour redirection ou complesion de l'objet Truc
//			}
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	@Override
//	public void delete(ArticleVendu truc) {
//		try(Connection connection = ConnectionProvider.getConnection()){					
//			PreparedStatement  stmt = connection.prepareStatement(DELETE_TRUC);
//			stmt.setInt(1, truc.getId());
//			stmt.executeUpdate();		
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}	
//	}
//
//	@Override
//	public void update(ArticleVendu truc) {
//		try(Connection connection = ConnectionProvider.getConnection()){
//			PreparedStatement stmt = connection.prepareStatement(UPDATE_TRUC);
//			prepareTrucSQL(truc, stmt);// Extrait les info de l'objet Truc pour le stmt
//			
//			// ajoute l'id au Where
//			stmt.setInt(6, truc.getId());// remplacer 6 par le numeros du ? qui correspond au Wherre
//			stmt.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();// levee DAL Exception
//		}
//		
//	}
//	/**
//	 * Extrait les Attributs de l'objet Truc pour le PrepareStatement stmt
//	 * @param truc : Objet à insérer ou a modifier dans la base SQL 
//	 * @param stmt : PrepareStatement de l'instruction SQL à préparer
//	 * @throws SQLException
//	 */
//	private void prepareTrucSQL(ArticleVendu truc, PreparedStatement stmt) throws SQLException {
//		
//		stmt.setInt(1, truc.getUnMachinEnInt());// pour ajouter un int
//		stmt.setFloat(2, truc.getUnMachinEnFloat());// pour ajouter un Float
//		stmt.setString(3, truc.getUnMachinEnString());// pour ajouter un String
//		stmt.setDate(4,Date.valueOf(truc.getUnMachinEnLocalDate()));// ajouter une date venant de l'objet Truc
//		stmt.setBoolean(5, truc.isUnMachinEnBoolean()); // pour ajouter un boolean vraix
//	}
//
//	

}
