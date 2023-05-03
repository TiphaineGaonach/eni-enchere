package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;



public interface UtilisateurDAO {

	
	List<Utilisateur> selectAll();
	
	Utilisateur selectOne(int id);

	void insert(Utilisateur utilisateur);

	void delete(int id);

	void update(Utilisateur utilisateur);

	Utilisateur selectByUser(String username);

	

}
