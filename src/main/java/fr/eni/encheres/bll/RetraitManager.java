package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait ;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;


public class RetraitManager {
	
	/** start Singleton */	
	// étape 1

	private static RetraitManager instance;
	// étape 2
	private RetraitManager() {}
	// étape 3
	public static RetraitManager getInstance() {		
		if( instance == null) {
			instance = new RetraitManager();
		}
		return instance;
	}
/** end Singleton */
	
	/**  get all Retrait s  **/
	public List<Retrait > getAllRetrait(){
		return DaoFactory.getRetraitDao().selectAll();
	}
	
	/** recup un Retrait  **/
	public Retrait  getRetrait (int id) {
		return DaoFactory.getRetraitDao().selectOne(id);
	}	
	
	public void addRetrait (Retrait  Retrait )  {
		//checkRetrait (Retrait );
		DaoFactory.getRetraitDao().insert(Retrait );
	}
	
	public void deleteRetrait (Retrait  Retrait ) {
		DaoFactory.getRetraitDao().delete(Retrait );
		
	}
	public void updateRetrait (Retrait  Retrait )  {
		//checkRetrait (Retrait );
		DaoFactory.getRetraitDao().update(Retrait );
	}
	

	public boolean isRetraitPermis(ArticleVendu article, Utilisateur utilisateurConnecte) {
			
			Integer noUtilisateurEnchereMAX = article.getEnchereMax().getUtilisateur().getNoUtilisateur() ;
			Integer noUtilisateurConnecte = utilisateurConnecte.getNoUtilisateur() ;
			Integer noVendeur = article.getUtilisateur().getNoUtilisateur() ;
	
					
			boolean retraitPermis = article.getEtatVente() == 'T'
									&& noUtilisateurEnchereMAX == noUtilisateurConnecte
									&& noUtilisateurEnchereMAX != noVendeur;
		    return retraitPermis ;
	}
	

}
