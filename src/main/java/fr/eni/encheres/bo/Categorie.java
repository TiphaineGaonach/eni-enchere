package fr.eni.encheres.bo;

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
public class Categorie {
	
	@NonNull private Integer noCategorie;
	@NonNull private String libelle;
	private List<ArticleVendu> articleVendus;
	
}
