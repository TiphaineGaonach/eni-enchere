package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleDaoImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDaoImpl;

public class DaoFactory {
	

	public static UtilisateurDAO getUtilisateur() {
		return new UtilisateurDaoImpl();
	}


	public static ArticleDAO getArticle() {
		return new ArticleDaoImpl();
	}	
	
}
