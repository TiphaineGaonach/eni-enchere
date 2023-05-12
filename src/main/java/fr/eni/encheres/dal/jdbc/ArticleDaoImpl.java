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
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.config.ConnectionProvider;
import fr.eni.encheres.dal.ArticleDAO;

public class ArticleDaoImpl implements ArticleDAO{
	
	private final static String SELECT_ALL_ARTICLES =	"SELECT "
			+ "    e.montant_enchere AS prix_enchere_max, " // prix le plus haut de l'enchere
			+ "    a.no_article, "
			+ "    a.nom_article, "
			+ "    a.description, "
			+ "    a.date_fin_encheres, "
			+ "	   a.no_utilisateur AS noVendeur, "
			+ "    e.no_utilisateur AS noAcheteur, "
			+ "	   u2.pseudo AS pseudoAcheteur, "
			+ "    u.pseudo AS pseudoVendeur, "
			+ "    a.etat_vente, "
			+ "    a.prix_initial, "
			+ "    u.pseudo, "
			+ "	   c.no_categorie, "
			+ "    c.libelle "
			
			+ " FROM ARTICLES_VENDUS a "
			+ " LEFT JOIN ENCHERES e ON e.no_article = a.no_article "
			+ " INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur "
			+ " INNER JOIN UTILISATEURS u2 ON u2.no_utilisateur = e.no_utilisateur  "
			+ " INNER JOIN CATEGORIES c On a.no_categorie= c.no_categorie "
			+ " INNER JOIN RETRAITS r on r.no_article = a.no_article "
			
			+ "WHERE ( "
			+ "    e.montant_enchere = ( "
			+ "        SELECT MAX(montant_enchere) "
			+ "        FROM ENCHERES "
			+ "        WHERE no_article = a.no_article "
			+ "    ) "
			+ "    OR e.montant_enchere IS NULL )";



	private final static String SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS";
	
	

	private final static String SELECT_ONE_ARTICLE = "SELECT "
			+ " e.montant_enchere AS prix_enchere_max, "
			+ " a.no_article, "
			+ " a.nom_article, "
			+ " a.description, "
			+ " a.date_fin_encheres, "
			+ " a.no_utilisateur AS noVendeur, "
			+ " e.no_utilisateur AS noAcheteur, "
			+ "	u2.pseudo AS pseudoAcheteur, "
			+ " u.pseudo AS pseudoVendeur, "
			+ " a.etat_vente, "
			+ " a.prix_initial, "
			+ " c.no_categorie, "
			+ " c.libelle ,"
			+ " r.rue, "
			+ " r.code_postal, "
			+ " r.ville "
			
			+ " FROM ARTICLES_VENDUS a "
			+ " LEFT JOIN ENCHERES e ON e.no_article = a.no_article "
			+ " INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur "
			+ " INNER JOIN UTILISATEURS u2 ON u2.no_utilisateur = e.no_utilisateur  "
			+ " INNER JOIN CATEGORIES c On a.no_categorie= c.no_categorie "
			+ " INNER JOIN RETRAITS r on r.no_article = a.no_article "
			
			+ " WHERE ("
			+ "		(e.montant_enchere = ("
			+ "   		SELECT MAX(montant_enchere) "
			+ "  		FROM ENCHERES  "
			+ "			 WHERE no_article = a.no_article  "
			+ "		) "
			+ "     OR e.montant_enchere IS NULL) "
			+ "		 AND a.no_article=?)"; 
			
	
			
			
			
			

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
				
				Utilisateur vendeur = new Utilisateur(
						rs.getInt("noVendeur"),
						rs.getString("pseudoVendeur"));
				
				Utilisateur acheteur = new Utilisateur(
						rs.getInt("noAcheteur"),
						rs.getString("pseudoAcheteur"));
						
				Enchere enchere = new Enchere(
						rs.getInt("no_categorie"),
						acheteur);
						
						
			
				articleVendus.add( new ArticleVendu(
						rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getString("description"),
						rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"),
						rs.getInt("prix_enchere_max"),   // on remplace le prix de vente par le prix enchere le plus haut
						rs.getString("etat_vente").charAt(0),
						categorie,
						vendeur,
						enchere
						));	
				
						
						
			}
			//DEBUG :
			//for (ArticleVendu articleVendu : articleVendus) {
			//	System.out.println(" article extraient de la bdd : " + articleVendu);
			//}
			
			return articleVendus;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	
	@Override
	/**
	 * 
	 */
	public ArticleVendu selectOne(int id) {
		try(Connection connection = ConnectionProvider.getConnection()){
			//DEBUG :System.out.println(" bien arrivé dans dao article impl, select on by id");
			PreparedStatement stmt = connection.prepareStatement(SELECT_ONE_ARTICLE);
			
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			//DEBUG :System.out.println("requete bien exécutée");
			ArticleVendu article = new ArticleVendu();
			
			while(rs.next()) {				

				Categorie categorie= new Categorie(
						rs.getInt("no_categorie"),
						rs.getString("libelle")
						);
				
				Utilisateur vendeur = new Utilisateur(
						rs.getInt("noVendeur"),
						rs.getString("pseudoVendeur"));
				
				Utilisateur acheteur = new Utilisateur(
						rs.getInt("noAcheteur"),
						rs.getString("pseudoAcheteur"));
						
				Enchere enchere = new Enchere(
						rs.getInt("no_categorie"),
						acheteur);	
				
				Retrait retrait = new Retrait(
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville")
						);
			
				article = new ArticleVendu(
						rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getString("description"),
						rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"),
						rs.getInt("prix_enchere_max"),   // on remplace le prix de vente par le prix enchere le plus haut
						rs.getString("etat_vente").charAt(0),
						categorie,
						vendeur,
						enchere,
						retrait);					
						
						
			}
			//DEBUG :System.out.println("dao Article, article à rendre : " + article);
			return article;

			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	



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


}
