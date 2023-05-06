package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DaoFactory;


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
	
	/** recup un ArticleVendu **/
	public ArticleVendu getArticleVendu(int id) {
		return DaoFactory.getArticleDao().selectOne(id);
	}	
	
	public void addArticleVendu(ArticleVendu ArticleVendu) throws BLLException {
		checkArticleVendu(ArticleVendu);
		DaoFactory.getArticleDao().insert(ArticleVendu);
	}
	
	public void deleteArticleVendu(ArticleVendu ArticleVendu) {
		DaoFactory.getArticleDao().delete(ArticleVendu);
		
	}
	public void updateArticleVendu(ArticleVendu ArticleVendu) throws BLLException {
		checkArticleVendu(ArticleVendu);
		DaoFactory.getArticleDao().update(ArticleVendu);
	}
	
	public void checkArticleVendu(ArticleVendu ArticleVendu) throws BLLException {
		BLLException bll = new BLLException();
//		checkFiled(ArticleVendu.getTitle(), "Titre",bll);
//		checkFiled(ArticleVendu.getContent(), "Contenu",bll);
//		checkFiled(ArticleVendu.getAuthor(), "Auteur",bll);
		if(bll.getErreurs().size()>0) {			
			throw bll;
		}
	}
	
	private void checkFiled(String field,String name,BLLException bll ) {
		if(field.isBlank()) {
			bll.ajouterErreur("Le champs %s ne peut pas etre vide!".formatted(name));
		}
	}
	

	

}
