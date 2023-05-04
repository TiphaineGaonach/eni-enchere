package fr.eni.encheres.bo;

import java.util.ArrayList;
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

public class Utilisateur {
	
	private Integer noUtilisateur;
	@NonNull private String pseudo;
	@NonNull private String nom;
	@NonNull private String prenom;
	@NonNull private String email;
	private String telephone;
	@NonNull private String rue;
	@NonNull private String codePostal;
	@NonNull private String ville;
	@NonNull private String motDePasse;
	@NonNull private Integer credit;
	@NonNull private boolean administrateur = false;
	private List<ArticleVendu> articleVendus = new ArrayList<>();
	private List<Enchere> encheres  = new ArrayList<>();
	
	
	
	public Utilisateur( @NonNull String pseudo, @NonNull String nom,
			@NonNull String prenom, @NonNull String email, String telephone, @NonNull String rue,
			@NonNull String codePostal, @NonNull String ville, @NonNull String motDePasse, @NonNull Integer credit,
			@NonNull boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	

	
}
