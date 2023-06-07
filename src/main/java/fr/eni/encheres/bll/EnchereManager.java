package fr.eni.encheres.bll;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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
	

	public void miseAJourEnchere(Integer surenchere, ArticleVendu article, Utilisateur utilisateur, Utilisateur utilisateurConnecte) throws BusinessException {
	    Enchere enchere = chercheEnchereByArtAndUser(article.getNoArticle(), utilisateur.getNoUtilisateur());
	    Integer Vendeur = article.getUtilisateur().getNoUtilisateur();
	    Integer DernierEncherisseur = article.getEnchereMax().getUtilisateur().getNoUtilisateur();
	    //check si l'enchere est realisable
			controleSurenchere(surenchere, utilisateur,article,utilisateurConnecte);
	

	    if (enchere != null) {
	        enchere.setMontantEnchere(surenchere);
	        EnchereManager.getInstance().updateEnchere(enchere);
	    } else {
	        Enchere newEnchere = new Enchere(surenchere, utilisateur, article);
	        EnchereManager.getInstance().addEnchere(newEnchere);
	    }
	    
	    //calcul des nouveaux soldes des 2 derniers encherisseurs
	    UtilisateurManager.getInstance().debiterAcheteur(article,utilisateurConnecte,surenchere);
	    
	    if(Vendeur != DernierEncherisseur) {
	    	UtilisateurManager.getInstance().crediterDernierEncherisseur(article,utilisateurConnecte);
	    }
	    

	}
	
	public void controleSurenchere (Integer surenchere,Utilisateur utilisateur,ArticleVendu article,Utilisateur utilisateurConnecte) throws BusinessException {
	    
	    if (article.getEtatVente()=='T' || article.getEtatVente() =='R') {
	    	throw new BusinessException("Vous ne pouvez pas enchérir sur une enchère terminée");
	    }
	    
	    if (article.getEtatVente()=='N') {
	    	throw new BusinessException("Vous ne pouvez pas enchérir sur une enchère non débutée");
	    }
	    
	    if (article.getUtilisateur().getNoUtilisateur()!=utilisateurConnecte.getNoUtilisateur()
				&& article.getEnchereMax().getUtilisateur().getNoUtilisateur() == utilisateurConnecte.getNoUtilisateur()) {
	    	throw new BusinessException("Vous avez déjà la meilleure enchère sur cet article ;)");
	    }
	    
	    if (article.getUtilisateur().getNoUtilisateur()== utilisateurConnecte.getNoUtilisateur()) {
	    	throw new BusinessException("Vous ne pouvez pas enchérir sur un article que vous vendez");
	    }

	    if (surenchere > utilisateur.getCredit()) {
	    	throw new BusinessException("Vous n'avez pas assez de crédit pour enchérir");	    	
	    }
	}
	
	
	
	public String affichageEtatEnchere (ArticleVendu article,Utilisateur utilisateurConnecte) {
		
		//formatage de la date xx mois xxxx (ex : 27 mai 2023)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("fr", "FR"));
		
		//enchere non debutée
		if (article.getEtatVente()=='N') { 	        
			if (article.getUtilisateur().getNoUtilisateur()==utilisateurConnecte.getNoUtilisateur()) {
				return "L'enchère sera ouverte le " +article.getDateDebutEncheres().format(formatter)+ " pour cet article" ;
			}
		}
		
		//enchère en cours
		if (article.getEtatVente()=='C') {
			if (article.getUtilisateur().getNoUtilisateur()==utilisateurConnecte.getNoUtilisateur()) {
				return "Vous vendez cet article" ;
			}
			if (article.getUtilisateur().getNoUtilisateur()!=utilisateurConnecte.getNoUtilisateur()
					&& article.getEnchereMax().getUtilisateur().getNoUtilisateur() ==utilisateurConnecte.getNoUtilisateur()) {
						return " Vous avez la meilleure enchère sur cet article";
			}
		}
		
		//enchère terminée
		if (article.getEtatVente()=='T') {
			if (article.getEnchereMax().getUtilisateur().getNoUtilisateur()==article.getUtilisateur().getNoUtilisateur()) {
				return "L'enchère est terminée, l'article n'a pas été vendu";
				}			
			if (article.getEnchereMax().getUtilisateur().getNoUtilisateur()==utilisateurConnecte.getNoUtilisateur()) {
				return " Vous avez remporté l'enchère";
			}			
			if (article.getEnchereMax().getUtilisateur().getNoUtilisateur()!=article.getUtilisateur().getNoUtilisateur()) {
				return " L'enchère est terminée , l'article a été vendu !";
			}
		}
		
		//enchère retirée
		if (article.getEtatVente()=='R') { 
			if (article.getUtilisateur().getNoUtilisateur()==utilisateurConnecte.getNoUtilisateur()) {
				return "l'article à été retiré et vous a rapporté "+article.getPrixVente()+" crédits";
			}

			if (article.getEnchereMax().getUtilisateur().getNoUtilisateur()==utilisateurConnecte.getNoUtilisateur()) {
				return "Vous avez retiré cet article";
			} 
			
			if (article.getUtilisateur().getNoUtilisateur()!=utilisateurConnecte.getNoUtilisateur()) {
				return "Cet article est déjà vendu";
			}
			
		}
		
		//si aucun de ces cas -> on n'affiche rien
		return null;
	}


}
