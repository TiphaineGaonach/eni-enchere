package fr.eni.encheres.bll;

import java.time.LocalDateTime;
import java.util.List;

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



	
}
