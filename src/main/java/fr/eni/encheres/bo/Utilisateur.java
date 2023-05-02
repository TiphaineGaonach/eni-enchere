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
	
	@NonNull private Integer noUtilisateur;
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
	
	
}
