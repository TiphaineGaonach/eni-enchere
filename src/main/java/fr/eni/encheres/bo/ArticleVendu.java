package fr.eni.encheres.bo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ArticleVendu {

	private Integer noArticle;
	@NonNull private String nomArticle;
	@NonNull private String description;
	@NonNull private LocalDateTime dateDebutEncheres;
	@NonNull private LocalDateTime dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private char etatVente; //TODO à vérifier Char ou Integer...
	@NonNull private Categorie categorie;
	@NonNull private Utilisateur utilisateur;
	private List<Enchere> encheres;
	private Retrait retrait;
	
	// comm
	
}
