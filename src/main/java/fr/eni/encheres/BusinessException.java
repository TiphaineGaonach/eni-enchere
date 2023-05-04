package fr.eni.encheres;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	private List<String> erreurs = new ArrayList<>();
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String msg) {
		super();
		erreurs.add(msg);
	}
	
	public void ajouterErreur(String msg) {
		erreurs.add(msg);
	}

	public List<String> getErreurs() {
		return erreurs;
	}
	
	@Override
	public String getMessage() {		
		return erreurs.toString();
	}

	public boolean hasErreur() {
		return !erreurs.isEmpty();
	}
}
