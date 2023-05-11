package fr.eni.encheres.ihm.enchere;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.SecuriteManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/enchere/detailEnchere/*")
public class DetailEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		//on recupere tout ce qui est à la place de * (l'id)
		String params = request.getPathInfo();
		Integer noArticle = Integer.parseInt(params.substring(1));		
		
				
			ArticleVendu article = ArticleManager.getInstance().getArticleVendu(noArticle);

			request.setAttribute("article", article);
	    
			//on definit le montant minimum de surenchère (montant max de l'enchere +10)
			request.setAttribute("surenchere", article.getPrixVente()+10);		
	    
			request.getRequestDispatcher("/WEB-INF/jsp/enchere/detailEnchere.jsp").forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer surenchere =   Integer.parseInt(request.getParameter("enchere"));
		Integer noArticle = Integer.parseInt(request.getParameter("no_article"));		
		Utilisateur session = (Utilisateur) request.getSession().getAttribute("pseudo");
		Integer noUtilisateur = session.getNoUtilisateur();
		
		
		ArticleVendu article = new ArticleVendu(noArticle);
		Utilisateur utilisateur = new Utilisateur(noUtilisateur);		

		//Mise à jour d'une enchère
		EnchereManager.getInstance().miseAJourEnchere(surenchere, article, utilisateur);
		
		
		doGet(request, response);
	}




}
