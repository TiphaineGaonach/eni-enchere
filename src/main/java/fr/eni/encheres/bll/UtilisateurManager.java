package fr.eni.encheres.bll;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.User;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	// SINGLETON
	public static  UtilisateurManager instance = new UtilisateurManager();  //Lazy singleton
	
	private UtilisateurManager() {} ;
	
	public static UtilisateurManager getInstance() {
		return instance;
	}
	// FIN SINGLETON
	
	
	//Factorisation DAOFactory	
	private UtilisateurDAO daoU = DaoFactory.getUtilisateur();
	
	
	
	public Utilisateur connexion(String username, String password) {
		Utilisateur user = daoU.selectByUser(username);

		
//		CONTROLE A RAJOUTER LORS DU CRYPTAGE DU MOT DE PASSE
//		
//		if (user == null) {
//			throw new BLLException("l'utilisateur n'existe pas !");
//		}
//		
//		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),user.getMotDePasse());
//		
//		if(!result.verified) {
//			throw new BLLException("Mot de passe incorrect !!!");
//		}

		return user ;
		
	}
	
	
	public void addUser(Utilisateur utilisateur) {
		
		//cryper le mot de passe
//		user.setPassword(
//				BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
		
	}
	
	
	
}
