package fr.eni.encheres.dal;


import dal.jdbc.TrucDaoImpl;

public class DaoFactory {
	
	public static TrucDAO getTrucDao() {
		return  new TrucDaoImpl();
	}

}
