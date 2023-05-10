package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Recherche;
import fr.eni.encheres.dal.DaoFactory;
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
		return DaoFactory.getArticleDao().selectAll();
	}
	
	public List<ArticleVendu> getRechercheArticleVendus(Recherche recherche) {
		// TODO Auto-generated method stub
		List<ArticleVendu> articlesRechercher = getAllArticleVendus();
		
		System.out.println(" article manager,getRechercheArticleVendus, liste à filtrer"+ articlesRechercher);
			for (ArticleVendu articleVendu : articlesRechercher) {
				// vire ce qui n'est pas de la bonne catégorie
				System.out.println(recherche.getCategorie());
				if (recherche.getCategorie()!=null && recherche.getCategorie()!=articleVendu.getCategorie()) {
					System.out.println("l'article retirer est : "+articleVendu);
					articlesRechercher.remove(articleVendu);
				}
				// vire ce qui ne comtien pas le mot clef
				if (recherche.getMotClef()!=null && (!articleVendu.getDescription().contains(recherche.getMotClef()) || !articleVendu.getNomArticle().contains(recherche.getMotClef() ))) {
					articlesRechercher.remove(articleVendu);
				}
				// Vire les article ne corespondant pas à l'utilisateur si un bouton est cocher.
//				if (recherche.getBoutonActif()!=null ) {
//					
//				}
			}
		
		System.out.println("article manager, getRechercheArticleVendus, liste à rendre: " + articlesRechercher);
		
		return articlesRechercher;
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
	/** checkRetrait **/
	
	
	
	
	
//	public List<Enchere> getAllEnchere() {
//		DaoFactory.getArticleDao().selectAllEnchere();
//		
//		return null;
//	}
	
		
	
}
