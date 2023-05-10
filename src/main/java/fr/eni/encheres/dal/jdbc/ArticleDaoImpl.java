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
import com.mysql.cj.exceptions.PasswordExpiredException;


import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Recherche;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.config.ConnectionProvider;
import fr.eni.encheres.dal.ArticleDAO;

public class ArticleDaoImpl implements ArticleDAO{
	
	private final static String SELECT_ALL_ARTICLES =	"SELECT "
			+ "    e.montant_enchere AS prix_enchere_max, " // prix le plus haut de l'enchere
			+ "    a.no_article, "
			+ "    a.nom_article, "
			+ "    a.date_fin_encheres, "
			+ "    a.no_utilisateur, "
			+ "    a.etat_vente, "
			+ "    a.prix_initial, "
			+ "    u.pseudo, "
			+ "	   c.no_categorie, "
			+ "    c.libelle "
			+ "FROM ARTICLES_VENDUS a "
			+ "LEFT JOIN ENCHERES e ON e.no_article = a.no_article "
			+ "INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur "
			+ "Inner join CATEGORIES c On a.no_categorie= c.no_categorie " 
			+ "WHERE ( "
			+ "    e.montant_enchere = ( "
			+ "        SELECT MAX(montant_enchere) "
			+ "        FROM ENCHERES "
			+ "        WHERE no_article = a.no_article "
			+ "    ) "
			+ "    OR e.montant_enchere IS NULL )";



	private final static String SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS";

	private final static String SELECT_ONE_ARTICLE = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";

	private final static String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET  "
			+ "no_article = ?, nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, etat_vente=? "
			+ "WHERE id = ?,?,?,?,?,?,?";
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS ("
			+ "nom_article, description,"
			+ " date_debut_encheres, date_fin_encheres,"
			+ " prix_initial,prix_vente, "
			+ "no_utilisateur, no_categorie, "
			+ "etat_vente  ) VALUES (?,?,?,?,?,?,?,?,?)";
	private final static String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE id = ?";
	
	
	

	
	@Override
	public List<ArticleVendu> selectAll() {
		try(Connection connection = ConnectionProvider.getConnection()){
			List<ArticleVendu> articleVendus = new ArrayList<>();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLES);
			
			while(rs.next()) {				

				Categorie categorie= new Categorie(
						rs.getInt("no_categorie"),
						
						rs.getString("libelle")
						);
				
				Utilisateur utilisateur = new Utilisateur(
						rs.getInt("no_utilisateur"),
						rs.getString("pseudo"));		
						
						
			
				articleVendus.add( new ArticleVendu(
						rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"),
						rs.getInt("prix_enchere_max"),   // on remplace le prix de vente par le prix enchere le plus haut
						rs.getString("etat_vente").charAt(0),
						categorie,
						utilisateur));					
						
						
			}
			return articleVendus;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	
	@Override
	public ArticleVendu selectOne(int id) {
		try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = connection.prepareStatement(SELECT_ONE_ARTICLE);
			
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
						return new ArticleVendu(rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getString("description"),
						rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"),
						rs.getInt("prix_vente"),						
						rs.getString("etat_vente").charAt(0));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//	@Override
//	public List<ArticleVendu> selectAll() {
//		try(Connection connection = fr.eni.encheres.config.ConnectionProvider.getConnection()){
//			List<ArticleVendu> articles = new ArrayList<>();
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLE);
//			while(rs.next()) {
//				List<Utilisateur> utilisateurs = UtilisateurManager.getInstance().getAllUtilisateur();
//				Utilisateur utilisateur = new Utilisateur();
//				for (Utilisateur u : utilisateurs) {
//					if (u.getNoUtilisateur()==rs.getInt("no_utilisateur")) {
//						utilisateur = u;
//					}
//				}
//				List<Categorie> categoris = CategorieManager.getInstance().getAllCategorie();
//				Categorie categorie = new Categorie();
//				for (Categorie c : categoris) {
//					if (c.getNoCategorie()==rs.getInt("no_categorie")) {
//						categorie = c;
//					}
//				}
//				
//				articles.add( new ArticleVendu(
//						rs.getInt("no_article"),
//						rs.getString("nom_article"),
//						rs.getString("description"),
//						rs.getDate("date_debut_encheres").toLocalDate(),
//						rs.getDate("date_fin_encheres").toLocalDate(),
//						rs.getInt("prix_initial"),
//						rs.getInt("prix_vente"),
//						rs.getString("etat_vente").charAt(0),
//						categorie,
//						utilisateur));
//				
//						
//			}
//			return articles;
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}		
//		return null;
//	}



	@Override
	public void insert(ArticleVendu articleVendu) {
		
		try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement  stmt = connection.prepareStatement(
											INSERT_ARTICLE,
											PreparedStatement.RETURN_GENERATED_KEYS
										);
			prepareArticleSQL(articleVendu, stmt);// Extrait les info de l'objet Truc pour le stmt
			
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				articleVendu.setNoArticle(rs.getInt(1));// Récup de l'ID pour redirection ou complesion de l'objet Truc
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub
		
	}
	
	private void prepareArticleSQL(ArticleVendu articleVendu, PreparedStatement stmt) throws SQLException {
		stmt.setString(1, articleVendu.getNomArticle());// pour ajouter un String
		stmt.setString(2, articleVendu.getDescription());
		stmt.setDate(3,Date.valueOf(articleVendu.getDateDebutEncheres()));
		stmt.setDate(4,Date.valueOf(articleVendu.getDateFinEncheres()));
		stmt.setInt(5, articleVendu.getMiseAPrix());
		stmt.setInt(6, articleVendu.getPrixVente());
		stmt.setInt(7, articleVendu.getUtilisateur().getNoUtilisateur());
		stmt.setInt(8, articleVendu.getCategorie().getNoCategorie());
		stmt.setString(9, Character.toString(articleVendu.getEtatVente()));
		
		
	}





//	@Override
//	public List<Enchere> selectAllEnchere() {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
	

	
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
