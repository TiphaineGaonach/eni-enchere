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
	private char etatVente; 
	@NonNull private Categorie categorie;
	@NonNull private Utilisateur utilisateur;
	private Enchere enchereMax;
	private Retrait retrait;
	private Boolean afficherBoolean = true;
	
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
	
	


	/**
	 * Pour ArticleDaoImpl, selectAll() rend un article avec son utilisateur Vendeur, son enchète, et son utilisateur Acheteur
	 * @param noArticle
	 * @param nomArticle
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param categorie
	 * @param utilisateur
	 */
	public ArticleVendu(Integer noArticle, @NonNull String nomArticle,String description, @NonNull LocalDate dateFinEncheres,
			Integer miseAPrix, Integer prixVente, char etatVente, @NonNull Categorie categorie,
			@NonNull Utilisateur utilisateur, Enchere enchereMax) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
		this.enchereMax = enchereMax;
	}
	
	
	/**
	 * Pour ArticleDaoImpl, SelectOneArticle. constructeur de  l'article avec sa categorie et son utilisateur; 
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


	/**
	 * Contructeur article à afficher pour servlet détaille article 
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 */
	public ArticleVendu(Integer noArticle, @NonNull String nomArticle, @NonNull String description,
			 @NonNull LocalDate dateFinEncheres, Integer miseAPrix,
			Integer prixVente, char etatVente, 
			Categorie categorie, Utilisateur utilisateur, Enchere enchereMax, Retrait retrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
		this.enchereMax = enchereMax;
		this.retrait = retrait;
	}
	
	public ArticleVendu(Integer noArticle, @NonNull String nomArticle, @NonNull String description,
			 @NonNull LocalDate dateFinEncheres, Integer miseAPrix,
			Integer prixVente, char etatVente, 
			Categorie categorie, Utilisateur utilisateur,  Retrait retrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
		this.retrait = retrait;
	}

	/**
	 * Contructeur des articles à vendre pour la servlet Nouvelle Article DoPost
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param categorie
	 * @param utilisateur
	 * @param retrait
	 */
	public ArticleVendu(@NonNull String nomArticle, @NonNull String description, @NonNull LocalDate dateDebutEncheres,
			@NonNull LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, char etatVente,
			@NonNull Categorie categorie, @NonNull Utilisateur utilisateur) {
		super();
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


	
	
	


	




	
	
	
}
