package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Enchere;

public interface EnchereDAO {

	
	//crud
	public List<Enchere> selectAllEnchere();
	
	public Enchere selectOneEnchere (int id);
	
	public void insertEnchere (Enchere enchere);

	public void updateEnchere (Enchere enchere);
	
	public void deleteEnchere (Enchere enchere);
	
}
