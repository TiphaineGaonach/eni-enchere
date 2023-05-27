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

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.SecuriteManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bll.exception.BLLException;
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
			
			Utilisateur utilisateurConnecte = (Utilisateur) request.getSession().getAttribute("pseudo");
			
			//on recupere l'etat de l'enchère pour l'afficher dans la JSP
			String etatEnchere = EnchereManager.getInstance().affichageEtatEnchere(article, utilisateurConnecte);
			request.setAttribute("etatEnchere", etatEnchere);
			
	    
			//on definit le montant minimum de surenchère (montant max de l'enchere +10)
			request.setAttribute("surenchere", article.getPrixVente()+10);		
	    
			request.getRequestDispatcher("/WEB-INF/jsp/enchere/detailEnchere.jsp").forward(request, response);
	

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer surenchere =   Integer.parseInt(request.getParameter("enchere"));
		Integer noArticle = Integer.parseInt(request.getParameter("no_article"));		
		Utilisateur utilisateurConnecte = (Utilisateur) request.getSession().getAttribute("pseudo");
		
		Integer noUtilisateurConnecte = utilisateurConnecte.getNoUtilisateur();
		//Integer creditUtilisateur = utilisateurConnecte.getCredit();
		
		
		//Recuperation de l'user connecté et de l'article selectionné
		Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateur(noUtilisateurConnecte);			
		ArticleVendu article = ArticleManager.getInstance().getArticleVendu(noArticle);
			

		
		/**
		 * MISE A JOUR DE L'ENCHERE
		 */
	    try {
	        EnchereManager.getInstance().miseAJourEnchere(surenchere, article, utilisateur,utilisateurConnecte);
	        
	    } catch (BusinessException e) {
	    	//Suppression des crochets en début et fin de message
	        String errorMessage = e.getMessage().substring(1, e.getMessage().length() - 1);
	        request.setAttribute("erreur", errorMessage);
	    }

	    doGet(request, response);
	}




}
