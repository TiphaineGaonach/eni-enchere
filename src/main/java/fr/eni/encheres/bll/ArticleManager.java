package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.BusinessException;
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
	
	public void checkArticleVendu(ArticleVendu ArticleVendu) throws BusinessException {
		BusinessException be = new BusinessException();
//		checkFiled(ArticleVendu.getTitle(), "Titre",bll);
//		checkFiled(ArticleVendu.getContent(), "Contenu",bll);
//		checkFiled(ArticleVendu.getAuthor(), "Auteur",bll);
		if(be.getErreurs().size()>0) {			
			throw be;
		}
	}
	
	private void checkFiled(String field,String name,BusinessException be ) {
		if(field.isBlank()) {
			be.ajouterErreur("Le champs %s ne peut pas etre vide!".formatted(name));
		}
	}
	

	

}
