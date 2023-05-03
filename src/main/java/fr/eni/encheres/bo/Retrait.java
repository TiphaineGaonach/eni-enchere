package fr.eni.encheres.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Retrait {
	
	@NonNull private String rue;
	@NonNull private String codePostal;
	@NonNull private String ville;
	@NonNull private ArticleVendu articleVendu;
	//comm
	
	
}
