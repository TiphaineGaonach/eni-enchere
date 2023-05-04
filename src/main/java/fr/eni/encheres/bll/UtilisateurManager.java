package fr.eni.encheres.bll;

import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
import fr.eni.encheres.BusinessException;
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
	private UtilisateurDAO daoU = DaoFactory.getUtilisateurDao();
	
	
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
	
	
	public void addUser(Utilisateur utilisateur) throws BusinessException {
		
		//cryper le mot de passe
//		user.setPassword(
//				BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
		checkUtilisateur(utilisateur);
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
	
	
	
	
	/************************* Check *************************/
	
	
	private void checkUtilisateur(Utilisateur utilisateur) throws BusinessException {
		BusinessException be = new BusinessException();
		checkField(utilisateur.getPseudo(), "pseudo", be);
		checkField(utilisateur.getNom(), "nom", be);
		checkField(utilisateur.getPrenom(), "prenom", be);
		checkField(utilisateur.getEmail(), "email", be);
		checkField(utilisateur.getRue(), "rue", be);
		checkField(utilisateur.getCodePostal(), "codePostal", be);
		checkField(utilisateur.getVille(), "ville", be);
		checkField(utilisateur.getMotDePasse(), "motDePasse", be);
		
		if (be.getErreurs().size()>0) {
			throw be;	
		}
		
	}

		
	/** checkField **/
	private void checkField (String field, String name, BusinessException be) {
		if (field.isBlank()) {
			be.ajouterErreur("Le champ %s ne peut pas être vide!".formatted(name));
		}
	}
	
	
	
}
