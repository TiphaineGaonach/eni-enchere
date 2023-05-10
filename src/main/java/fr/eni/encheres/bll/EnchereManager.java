package fr.eni.encheres.bll;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;
import fr.eni.encheres.dal.EnchereDAO;

public class EnchereManager {
	
	// SINGLETON
	public static  EnchereManager instance = new EnchereManager();  //Lazy singleton
	
	private EnchereManager() {} ;
	
	public static EnchereManager getInstance() {
		return instance;
	}
	// FIN SINGLETON
	
	
	//Factorisation DAOFactory	
	private EnchereDAO daoE = DaoFactory.getEnchereDao();
	
	
	//Afficher toutes les encheres
	public List<Enchere> getAllEnchere(){
		
		return daoE.selectAllEnchere();
		
	}

	public Enchere getEnchere(Integer noUtilisateur, Integer noArticle) {
		// TODO Auto-generated method stub
		return daoE.selectOneEnchere(noUtilisateur,noArticle);
	}
	
	
	public void addEnchere(Enchere enchere) {
		
		daoE.insertEnchere(enchere);
	}

	public void updateEnchere(Enchere enchere) {
		daoE.updateEnchere(enchere);
		
	}


	/* Methode surenchere
	 *  On compare l'enchere avec la liste des encheres en BDD
	 *  Si une enchere existe deja en BDD avec l'user et l'article
	 *  On fait un update
	 *  sinon on créé une nouvelle enchère
	 */
	public void surenchere(Integer surenchere, ArticleVendu article, Utilisateur utilisateur) {
		Enchere enchere = new Enchere(surenchere,utilisateur,article);		
		
		List<Enchere> encheres = EnchereManager.getInstance().getAllEnchere();
		
		boolean enchereTrouvee = false;
		
		for (Enchere enchereBDD : encheres) {
			if ((enchere.getArticleVendu().getNoArticle() == enchereBDD.getArticleVendu().getNoArticle())
				&& (enchere.getUtilisateur().getNoUtilisateur() == enchereBDD.getUtilisateur().getNoUtilisateur())) {
				
	
				EnchereManager.getInstance().updateEnchere(enchere) ;
				
				// on passe le parametre à true pour ne pas executer l'addEnchere
				enchereTrouvee = true; 
				break;
			}
		}
		// s'il n'y a pas d'enchere existante en BDD
		if (!enchereTrouvee) {  
			EnchereManager.getInstance().addEnchere(enchere) ;
			System.out.println(" JE SUIS SORTI DU FOR !!!!!!");
		}
	}
	
}
