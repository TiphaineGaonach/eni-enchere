package fr.eni.encheres.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	
	//*** SYLVAIN -> constructeur pour le selectAllEnchere de EnchereDaoImpl 
	public Enchere(@NonNull Integer montantEnchere, @NonNull Utilisateur utilisateur,
			@NonNull ArticleVendu articleVendu) {
		super();
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}
	
	
	
	
	
}
