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

	private Integer noArticle;
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
	
	public ArticleVendu(Integer noArticle) {
		super();
		this.noArticle = noArticle;
	}


	// *** SYLVAIN -> constructeur pour le selectOneEnchere de EnchereDaoImpl
	public ArticleVendu(Integer noArticle, @NonNull String nomArticle, @NonNull LocalDate dateFinEncheres) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.dateFinEncheres = dateFinEncheres;
	}
	
	

	//constructeur pour le user de l'articleVendu pour la requete selectAllEnchere
//	public ArticleVendu(Integer noArticle, @NonNull String nomArticle, @NonNull LocalDate dateFinEncheres, Integer miseAPrix,Integer prixVente, char etatVente,@NonNull Utilisateur utilisateur,@NonNull Categorie categorie) {
//		super();
//		this.noArticle = noArticle;
//		this.nomArticle = nomArticle;
//		this.dateFinEncheres = dateFinEncheres;
//		this.utilisateur = utilisateur;
//		this.miseAPrix = miseAPrix;
//	}

	public ArticleVendu(Integer noArticle, @NonNull String nomArticle, @NonNull LocalDate dateFinEncheres,
			Integer miseAPrix, Integer prixVente, char etatVente, @NonNull Categorie categorie,
			@NonNull Utilisateur utilisateur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
	}
	
	
	/**
	 * Pour extraction de la BDD de l'article avec sa categorie et son utilisateur; return un utilisateur
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 */
	public ArticleVendu(Integer noArticle, @NonNull String nomArticle, @NonNull String description,
			@NonNull LocalDate dateDebutEncheres, @NonNull LocalDate dateFinEncheres, Integer miseAPrix,
			Integer prixVente, char etatVente, @NonNull Categorie categorie, @NonNull Utilisateur utilisateur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
	}



	public ArticleVendu(Integer noArticle, @NonNull String nomArticle, @NonNull String description,
			@NonNull LocalDate dateDebutEncheres, @NonNull LocalDate dateFinEncheres, Integer miseAPrix,
			Integer prixVente, char etatVente) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}







	
	
	
}
