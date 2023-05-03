package fr.eni.encheres.bll;

import java.util.List;

import bll.Exception.BLLException;

import bo.Truc;
import dal.DaoFactory;

public class ArticleManager {
	
	/** start Singleton */	
	// étape 1
	private static TrucManager instance;
	// étape 2
	private TrucManager() {}
	// étape 3
	public static TrucManager getInstance() {		
		if( instance == null) {
			instance = new TrucManager();
		}
		return instance;
	}
/** end Singleton */
	
	/**  get all trucs  **/
	public List<Truc> getAllTrucs(){
		return DaoFactory.getTrucDao().selectAll();
	}
	
	/** recup un truc **/
	public Truc getTruc(int id) {
		return DaoFactory.getTrucDao().selectOne(id);
	}	
	
	public void addTruc(Truc truc) throws BLLException {
		checkTruc(truc);
		DaoFactory.getTrucDao().insert(truc);
	}
	
	public void deleteTruc(Truc truc) {
		DaoFactory.getTrucDao().delete(truc);
		
	}
	public void updateTruc(Truc truc) throws BLLException {
		checkTruc(truc);
		DaoFactory.getTrucDao().update(truc);
	}
	
	public void checkTruc(Truc truc) throws BLLException {
		BLLException bll = new BLLException();
//		checkFiled(truc.getTitle(), "Titre",bll);
//		checkFiled(truc.getContent(), "Contenu",bll);
//		checkFiled(truc.getAuthor(), "Auteur",bll);
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
