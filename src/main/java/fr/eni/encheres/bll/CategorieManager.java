package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DaoFactory;

public class CategorieManager {

	/** start Singleton */	
	// étape 1

	private static CategorieManager instance;
	// étape 2
	private CategorieManager() {}
	// étape 3
	public static CategorieManager getInstance() {		
		if( instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}
	/** end Singleton */
	
	
	
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return DaoFactory.getCategorieDao().selectAll();
	}

}
