package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

public interface ArticleDAO {
	
	List<ArticleVendu> selectAll();
	
	ArticleVendu selectOne(int id);

	void insert(ArticleVendu articleVendu);

	void delete(ArticleVendu articleVendu);

	void update(ArticleVendu articleVendu);

}
