package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Recherche;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.NonNull;


public class ArticleManager {
	
	/** start Singleton */	
	// étape 1

	private static ArticleManager instance;
	// étape 2
	private ArticleManager() {}
	// étape 3
	public static ArticleManager getInstance() {		
		if( instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	/** end Singleton */
	
	/**  get all ArticleVendus  **/
	public List<ArticleVendu> getAllArticleVendus(){
		List<ArticleVendu> articlesRechercher = DaoFactory.getArticleDao().selectAll();
		List<ArticleVendu> articlesAfficher = new ArrayList<>();

		for (ArticleVendu articleVendu : articlesRechercher) {
			if (articleVendu.getEtatVente()!='C' ) {
		    	articleVendu.setAfficherBoolean(false);
		    }
		}
		for (ArticleVendu articleVendu : articlesRechercher) {
			if (articleVendu.getAfficherBoolean()) {
				//System.out.println(articleVendu);
				articlesAfficher.add(articleVendu);
			}
		}
		return articlesRechercher;
	}
	
	public List<ArticleVendu> getRechercheArticleVendus(Recherche recherche) {
		// TODO Auto-generated method stub
		System.out.println(recherche);
		
		List<ArticleVendu> articlesRechercher = DaoFactory.getArticleDao().selectAll();
		List<ArticleVendu> articlesAfficher = new ArrayList<>();
		
		//System.out.println("Article manager,getRechercheArticleVendus, liste à filtrer"+ articlesRechercher);
		//System.out.println(" categorie à tester est : " + recherche.getCategorie());
		//System.out.println("entrer dans la boucle for");
		for (ArticleVendu articleVendu : articlesRechercher) {
			//System.out.println("test d'un article " +articleVendu.getAfficherBoolean());
//******************************* recherche par categorie **********************************************************		    
		    
			
			
			if (recherche.getCategorie().getNoCategorie() != null
				&& recherche.getCategorie().getNoCategorie() != articleVendu.getCategorie().getNoCategorie()) {
			        //System.out.println("l'article retirer est : " + articleVendu);
			        articleVendu.setAfficherBoolean(false);
			        //System.out.println("l'article retirer est : " + articleVendu);
			        continue;
		    }
		    //System.out.println(articleVendu.getDescription());
 //******************************* recherche par mots clef **********************************************************
		    if (recherche.getMotClef() != null && (
		    		!articleVendu.getDescription().toLowerCase().contains(recherche.getMotClef().toLowerCase())
		    		&& 
		    		!articleVendu.getNomArticle().toLowerCase().contains(recherche.getMotClef().toLowerCase())
		    		
		            )) {
		    	articleVendu.setAfficherBoolean(false);
		    	continue;
		    }
// ********************** rechercher par état et utilisateur *******************************	
		    
		    if (recherche.getBoutonActif()!=null) {

		    
			    if (recherche.getBoutonActif().equals("achatOuvert")
			    		&&articleVendu.getEtatVente()!='C'
			            ) {
			    		
			    	articleVendu.setAfficherBoolean(false);
			    	continue;
			    }
			    
			    if (recherche.getBoutonActif().equals("achatEnCours")	
			    		&&(
			    				recherche.getUtilisateur().getNoUtilisateur()!=articleVendu.getEnchereMax().getUtilisateur().getNoUtilisateur()
			    				||
			    				articleVendu.getEtatVente()!='C'
					    )) {
			    	articleVendu.setAfficherBoolean(false);
			    	continue;
			    }
			    	//System.out.println("article à tester dans les achat " + articleVendu);
			    if (recherche.getBoutonActif().equals("achatRemporter")	
			    		&&(
			    				recherche.getUtilisateur().getNoUtilisateur()!=articleVendu.getEnchereMax().getUtilisateur().getNoUtilisateur()
			    				||(
				    				articleVendu.getEtatVente()!='T'
				    				&&
				    				articleVendu.getEtatVente()!='R'
				    			)
					    )) {
			    	articleVendu.setAfficherBoolean(false);
			    	continue;
			    }
//**********************************mes Ventes *****************************************************************************
			    if (recherche.getBoutonActif().equals("VenteEnCours")
			    	&& (
	    				(recherche.getUtilisateur().getNoUtilisateur()!=articleVendu.getUtilisateur().getNoUtilisateur())
	    				||
	    				(articleVendu.getEtatVente()!='C')
			    )){
			    	articleVendu.setAfficherBoolean(false);
			    	continue;
			    };
		
			    
			    if (recherche.getBoutonActif().equals("VenteNonDebuter")	
			    		&&(
			    				(recherche.getUtilisateur().getNoUtilisateur()!=articleVendu.getUtilisateur().getNoUtilisateur())
			    				||
			    				(articleVendu.getEtatVente()!='N')
					    )) {
			    	articleVendu.setAfficherBoolean(false);
			    	continue;
			    }
			    
			    if (recherche.getBoutonActif().equals("VenteTerminer")	
		
			    		&&(
			    				(recherche.getUtilisateur().getNoUtilisateur()!=articleVendu.getUtilisateur().getNoUtilisateur())
			    				||(
				    				(articleVendu.getEtatVente()!='T')
//				    				||
//				    				(articleVendu.getEtatVente()=='C')
				    			)
					    )) {
			    	System.out.println("dans le if VenteTerminer" + articleVendu.getEtatVente());
			    	articleVendu.setAfficherBoolean(false);
			    	continue;
			    }
		    
		    
		    }
		    
		    
		  // System.out.println(" article gardé ");
		}
		//System.out.println(" je suis sorti de la boucle for");
		
		//System.out.println(" la liste à affiché est : ");
		for (ArticleVendu articleVendu : articlesRechercher) {
			if (articleVendu.getAfficherBoolean()) {
				//System.out.println(articleVendu);
				articlesAfficher.add(articleVendu);
			}
		}

		return articlesAfficher;
	}
	
	/** recup un ArticleVendu **/
	public ArticleVendu getArticleVendu(int id) {
		return DaoFactory.getArticleDao().selectOne(id);
	}	
	
	
	
	public void addArticleVendu(ArticleVendu ArticleVendu) throws BusinessException {
		checkArticleVendu(ArticleVendu);
		DaoFactory.getArticleDao().insert(ArticleVendu);
	}
	
	
	public void deleteArticleVendu(ArticleVendu ArticleVendu) {
		DaoFactory.getArticleDao().delete(ArticleVendu);
		
	}
	public void updateArticleVendu(ArticleVendu ArticleVendu) throws BusinessException {
		checkArticleVendu(ArticleVendu);
		DaoFactory.getArticleDao().update(ArticleVendu);
	}
	
	public void terminerVente(ArticleVendu articleVendu) throws BusinessException {
		DaoFactory.getArticleDao().etatArticleT(articleVendu);
		
	}
	
	
	
	/************************* Check *************************/
	
	/** checkArticle **/
	
	public void checkArticleVendu(ArticleVendu ArticleVendu) throws BusinessException {
		BusinessException be = new BusinessException();
		checkField(ArticleVendu.getNomArticle(), "nomArticle", be);
		checkField(ArticleVendu.getDescription(), "description", be);
		checkCategorie(ArticleVendu.getCategorie(), "categorie", be);
		checkField(String.valueOf(ArticleVendu.getMiseAPrix()), "miseAPrix", be);
		checkDateDebutEncheres(ArticleVendu.getDateDebutEncheres(), "dateDebutEncheres", be);
		checkField(String.valueOf(ArticleVendu.getDateFinEncheres()), "dateFinEncheres", be);
		
		if(be.getErreurs().size()>0) {			
			throw be;
		}
	}
	/** checkField **/
	private void checkField(String field,String name,BusinessException be ) {
		if(field.isBlank()) {
			be.ajouterErreur("Le champs %s ne peut pas etre vide!".formatted(name));
		}
	}
	/** checkCatégorie **/
	private void checkCategorie(Categorie categorie, String name, BusinessException be) {
		if (categorie == null) {
			be.ajouterErreur("Le champs %s ne peut pas etre vide!".formatted(name));
		}
	}
	/** checkDateDébutEnchere **/
	private void checkDateDebutEncheres(LocalDate dateDebutEncheres, String name, BusinessException be) {
	    if (dateDebutEncheres == null) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate currentDate = LocalDate.now();
	        String currentDateFormatted = currentDate.format(formatter);
	        be.ajouterErreur("La date de début d'enchères ne peut pas être vide! Elle est définie par défaut à la date du jour : %s".formatted(currentDateFormatted));
	    }else if (dateDebutEncheres.isBefore(LocalDate.now())) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String currentDateFormatted = LocalDate.now().format(formatter);
	        be.ajouterErreur("La date de début des enchères ne peut pas être antérieure à la date du jour (%s) !".formatted(currentDateFormatted));
	    }
	}


		
	
}
