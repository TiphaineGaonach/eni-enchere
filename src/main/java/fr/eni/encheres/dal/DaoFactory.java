package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleDaoImpl;
import fr.eni.encheres.dal.jdbc.EnchereDaoImpl;
import fr.eni.encheres.dal.jdbc.RetraitDAOImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDaoImpl;

public class DaoFactory {
	

	public static UtilisateurDAO getUtilisateurDao() {
		return new UtilisateurDaoImpl();
	}


	public static ArticleDAO getArticleDao() {
		return new ArticleDaoImpl();
	}	
	
	public static EnchereDAO getEnchereDao() {
		
		return new EnchereDaoImpl();
	}


	public static RetraitDAO getRetraitDao() {
		// TODO Auto-generated method stub
		return new RetraitDAOImpl();
	}


	
}
