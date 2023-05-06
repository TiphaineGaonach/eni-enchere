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
import java.time.LocalDate;

import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/enchere/ajouterEnchere")
public class AjouterEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categories", CategorieManager.getAll());
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/enchere/nouvelleVente.jsp") // on délégue a la jsp
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");// extraire la catégorie de l'article
		Integer miseAPrix = Integer.parseInt(request.getParameter("miseAPrix")) ;
		
		
		
		LocalDate dateDebutEncheres = request.getParameter("dateDebutEncheres");
		LocalDate dateFinEncheres = request.getParameter("dateFinEncheres");
		
		ArticleVendu article = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, null, (Utilisateur)session.getAttribute("pseudo") )
		;
		
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
		

			
		}
	

}
