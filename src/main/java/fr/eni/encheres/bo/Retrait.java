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
	
	
	/**
	 * contructeur du point de retrain pour le DoPodt du Servlet créer une nouvelle vente
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(@NonNull String rue, @NonNull String codePostal, @NonNull String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	
	
	
	
	
	
}
