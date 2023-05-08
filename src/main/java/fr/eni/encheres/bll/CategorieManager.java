package fr.eni.encheres.bll;

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

}
