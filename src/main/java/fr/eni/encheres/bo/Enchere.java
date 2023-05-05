package fr.eni.encheres.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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


	
	@NonNull private LocalDate dateEnchere;
	@NonNull private Integer montantEnchere;
	@NonNull private Utilisateur utilisateur;
	@NonNull private ArticleVendu articleVendu;
	
	
	
}
