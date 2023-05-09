package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.CategorieDao;

public class CategorieDaoImpl implements CategorieDao{

	private final static String SELECT_ALL_CATEGORIE = "SELECT * FROM CATEGORIES";

	@Override
	/**
	 * retourne la liste des catégorie de la table catégorie de la BDD
	 */
	public List<Categorie> selectAll() {
		try(Connection connection = fr.eni.encheres.config.ConnectionProvider.getConnection()){
			List<Categorie> categories = new ArrayList<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_CATEGORIE);
			while(rs.next()) {

				categories.add( new Categorie(
						rs.getInt("no_categorie"),
						rs.getString("libelle")
						));
				
						
			}
			return categories;
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
}
