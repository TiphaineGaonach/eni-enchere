package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Retrait;

public interface RetraitDAO {

	Retrait selectOne(int id);

	List<Retrait> selectAll();

	void insert(Retrait retrait);

	void delete(Retrait retrait);

	void update(Retrait retrait);

}
