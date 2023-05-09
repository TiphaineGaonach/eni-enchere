package fr.eni.encheres.bo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor


public class Recherche {
	
	String motClef;
	Categorie categorie;
	Utilisateur utilisateur;
	String boutonActif;
	
	
	
	
	
	

}
