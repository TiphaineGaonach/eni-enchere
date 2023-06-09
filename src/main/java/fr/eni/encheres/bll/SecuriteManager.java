package fr.eni.encheres.bll;

import at.favre.lib.crypto.bcrypt.BCrypt;
import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;

public class SecuriteManager {

	/** Singleton **/
	private static SecuriteManager instance = new SecuriteManager(); // lazy Singleton
	private SecuriteManager() {}
	public static SecuriteManager getInstance() {
		return instance;
	}
	/** Fin Singleton **/
	
	
	/** Connexion **/
	
	public Utilisateur connexion(String identifiant, String motDePasse) throws BusinessException {
		Utilisateur utilisateur =	DaoFactory.getUtilisateurDao().selectByUser(identifiant);

		
		if (utilisateur == null) {
			throw new BusinessException("Utilisateur non trouvé");
		}else if (utilisateur.getMotDePasse().equals(motDePasse)) {
			return utilisateur;
		}else {
			throw new BusinessException("Mot de Passe erroné");
		}


		
		
		
	}
	

}
