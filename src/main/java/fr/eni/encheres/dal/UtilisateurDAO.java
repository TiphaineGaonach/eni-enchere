package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;



public interface UtilisateurDAO {

	
	List<Utilisateur> selectAll();
	
	Utilisateur selectOne(int id);

	void insert(Utilisateur utilisateur) throws BusinessException;

	void delete(Utilisateur utilisateur);

	void update(Utilisateur utilisateur) throws BusinessException;

	Utilisateur selectByUser(String identifiant);

	void updateCreditUtilisateur(ArticleVendu article) throws BusinessException;

	void updateDebitUtilisateur(ArticleVendu article, Utilisateur utilisateurConnecte, Integer surenchere) throws BusinessException;

	void updateCreditDernierEncherisseur(ArticleVendu article, Utilisateur utilisateurConnecte) throws BusinessException;


}
