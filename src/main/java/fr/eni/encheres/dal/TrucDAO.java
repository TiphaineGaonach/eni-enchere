package fr.eni.encheres.dal;

import java.util.List;

import bo.Truc;



public interface TrucDAO {

	
	List<Truc> selectAll();
	
	Truc selectOne(int id);

	void insert(bo.Truc truc);

	void delete(bo.Truc truc);

	void update(bo.Truc truc);

	

}
