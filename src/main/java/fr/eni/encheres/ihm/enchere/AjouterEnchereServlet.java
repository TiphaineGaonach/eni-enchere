package fr.eni.encheres.ihm.enchere;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/enchere/ajouterEnchere")
public class AjouterEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("categories", CategorieManager.getInstance().getAll());
		List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();
		request.setAttribute("categories", categories);
		
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = formatter.format(date);
        request.setAttribute("currentDate", currentDate);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/enchere/nouvelleVente.jsp") // on délégue a la jsp
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// recup des string
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		Integer miseAPrix = Integer.parseInt(request.getParameter("miseAPrix")) ;
		
		// recup de la categorie
		List<Categorie> categories= CategorieManager.getInstance().getAllCategorie();		
		String categorieVente = request.getParameter("categorie");// extraire la catégorie de l'article
		Categorie categorie = new Categorie(); 
		for (Categorie c : categories) {
				if (c.getLibelle().equals(categorieVente)) {
					categorie=c;
				}
		}
		//System.out.println("la categorie créé est : " + categorie);
		
		
		// recup des dates
		String date = request.getParameter("dateDebutEncheres");
		String[] dates = date.split("/");
		LocalDate dateDebutEncheres =LocalDate.of(Integer.parseInt(dates[2]), Integer.parseInt(dates[1]), Integer.parseInt(dates[0]));
		
		date = request.getParameter("dateFinEncheres");
		 dates = date.split("/");
		 LocalDate dateFinEncheres =LocalDate.of(Integer.parseInt(dates[2]), Integer.parseInt(dates[1]), Integer.parseInt(dates[0]));

		 // creation de l'article et recup de l'id
		ArticleVendu article = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, miseAPrix, 'N', categorie, (Utilisateur)session.getAttribute("pseudo"));
		//DEBUG : System.out.println(" l'article créé est : "+ article);
		
		try {
			
			ArticleManager.getInstance().addArticleVendu(article);
			
		
			if(article.getNoArticle()>0) {

				
				Enchere enchere = new Enchere(article.getMiseAPrix(),new Utilisateur(article.getUtilisateur().getNoUtilisateur()),article);
				
				EnchereManager.getInstance().addEnchere(enchere);
				
		

				// l'article à bien un id ( et donc a été enregistré, ) création du retrait
				
				String rue = request.getParameter("rue");
				String codePostal = request.getParameter("codePostal");
				String ville = request.getParameter("ville");
				Retrait retrait = new Retrait(rue, codePostal, ville, article);
				// enregistre le retrait
				RetraitManager.getInstance().addRetrait(retrait);
				
			}
		} catch (BusinessException e) {
			request.setAttribute("erreur", e.getMessage());

			request.setAttribute("categories", categories);

			request.getRequestDispatcher("/WEB-INF/jsp/enchere/nouvelleVente.jsp")
			.forward(request, response);
			return;
		}	
			
//	DEBUG:	System.out.println("***********************no article "+article.getNoArticle());
//	DEBUG:	System.out.println("***********************prix vente "+article.getPrixVente());
		
			response.sendRedirect(request.getContextPath()+"/enchere/detailEnchere/"+article.getNoArticle());
		}
				
	

}
