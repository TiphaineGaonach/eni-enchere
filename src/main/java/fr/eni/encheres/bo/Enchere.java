package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Enchere {


	
	
	@NonNull private LocalDateTime dateEnchere;
	@NonNull private Integer montantEnchere;
	@NonNull private Utilisateur utilisateur;
	@NonNull private ArticleVendu articleVendu;
	
	
	public Enchere(LocalDate localDate, int int1, Utilisateur utilisateur2, ArticleVendu articleVendu2) {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
