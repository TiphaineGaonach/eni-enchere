package fr.eni.encheres.bll;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.exception.BLLException;
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
	public Enchere chercheEnchereByArtAndUser(Integer noArticle, Integer noUtilisateur) {
	    List<Enchere> encheres = EnchereManager.getInstance().getAllEnchere();
	    for (Enchere enchere : encheres) {
	        if (enchere.getArticleVendu().getNoArticle().equals(noArticle) 
	                && enchere.getUtilisateur().getNoUtilisateur().equals(noUtilisateur)) {
	            return enchere;
	        }
	    }
	    return null;
	}
	

	public void miseAJourEnchere(Integer surenchere, ArticleVendu article, Utilisateur utilisateur, Utilisateur session) throws BusinessException {
	    Enchere enchere = chercheEnchereByArtAndUser(article.getNoArticle(), utilisateur.getNoUtilisateur());
	    
	    //check si l'enchere est realisable
			controleSurenchere(surenchere, utilisateur,article,session);
	

	    if (enchere != null) {
	        enchere.setMontantEnchere(surenchere);
	        EnchereManager.getInstance().updateEnchere(enchere);
	    } else {
	        Enchere newEnchere = new Enchere(surenchere, utilisateur, article);
	        EnchereManager.getInstance().addEnchere(newEnchere);
	    }
	}
	
	public void controleSurenchere (Integer surenchere,Utilisateur utilisateur,ArticleVendu article,Utilisateur session) throws BusinessException {
	    if (surenchere > utilisateur.getCredit()) {
	    	throw new BusinessException("Vous n'avez pas assez de crédit pour enchérir");	    	
	    }
	    
	    if (article.getUtilisateur().getNoUtilisateur()!=session.getNoUtilisateur()
				&& article.getEnchereMax().getUtilisateur().getNoUtilisateur() == session.getNoUtilisateur()) {
	    	throw new BusinessException("Vous avez deja la meilleure enchère sur cet article ;)");
	    };
	}

	
}
