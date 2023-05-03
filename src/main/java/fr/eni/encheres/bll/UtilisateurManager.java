package fr.eni.encheres.bll;

import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
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
	
	
	//recuperer un utilisateur par son nom pour la connexion
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
		
		daoU.insert(utilisateur);
		
	}
	
	
	//Afficher tous les utilisateurs
	public List<Utilisateur> getAllUtilisateur(){
		
		return daoU.selectAll();
		
	}
	
	
	
	/** recuperer un utilisateur par son id **/
	public Utilisateur getUtilisateur(int id) {
		return daoU.selectOne(id);
	}
	
	
	
	public void updateUtilisateur(Utilisateur utilisateur){
		//checkUtilisateur(utilisateur);
		daoU.update(utilisateur);
		
	}
	
	public void deleteUtilisateur(int id) {
		daoU.delete(id);
	}
	
}
