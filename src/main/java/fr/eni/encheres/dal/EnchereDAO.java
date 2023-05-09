package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public interface EnchereDAO {

	
	//crud
	public List<Enchere> selectAllEnchere();
	
	public void insertEnchere (Enchere enchere);

	public void updateEnchere (Enchere enchere);
	
	public void deleteEnchere (Enchere enchere);

	public Enchere selectOneEnchere(Integer noUtilisateur, Integer noArticle);
	
}
