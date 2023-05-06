package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Retrait ;
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
	
//	public void checkRetrait (Retrait  Retrait ) throws BLLException {
//		BLLException bll = new BLLException();
////		checkFiled(Retrait .getTitle(), "Titre",bll);
////		checkFiled(Retrait .getContent(), "Contenu",bll);
////		checkFiled(Retrait .getAuthor(), "Auteur",bll);
//		if(bll.getErreurs().size()>0) {			
//			throw bll;
//		}
//	}
	
//	private void checkFiled(String field,String name,BLLException bll ) {
//		if(field.isBlank()) {
//			bll.ajouterErreur("Le champs %s ne peut pas etre vide!".formatted(name));
//		}
//	}
	

	

}
