package fr.eni.encheres.bll;

import at.favre.lib.crypto.bcrypt.BCrypt;
import fr.eni.encheres.bll.exception.BLLException;
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
	
	public Utilisateur connexion(String pseudo, String motDePasse) throws BLLException {
		Utilisateur utilisateur =	DaoFactory.getUtilisateurDao().selectByUser(pseudo);
		System.out.println(pseudo);
		System.out.println(motDePasse);
		if (utilisateur == null) {
			throw new BLLException("Utilisateur non trouvé");
		}
		
//		BCrypt.Result result = BCrypt.verifyer()
//				.verify(motDePasse.toCharArray(), utilisateur.getMotDePasse());
//		if (!result.verified) {
//			throw new BLLException("Erreur mot de passe");
//		}
		return utilisateur;
		
		
		
	}
	

}
