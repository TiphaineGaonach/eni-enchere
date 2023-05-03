package fr.eni.encheres.bo;

import java.time.LocalDate;
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

	@NonNull private Integer noArticle;
	@NonNull private String nomArticle;
	@NonNull private String description;
	@NonNull private LocalDate dateDebutEncheres;
	@NonNull private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private char etatVente; //TODO à vérifier Char ou Integer...
	@NonNull private Categorie categorie;
	@NonNull private Utilisateur utilisateur;
	private List<Enchere> encheres;
	private Retrait retrait;
	
	private Integer integer;
	
}
