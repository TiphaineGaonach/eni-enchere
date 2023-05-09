package fr.eni.encheres.ihm.enchere;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.EnchereManager;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/enchere/detailEnchere")
public class DetailEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Integer noArticle =Integer.parseInt(request.getParameter("article"));
	    //Integer noUtilisateur = Integer.parseInt(request.getParameter("user"));
	    System.out.println("article = " + noArticle);
	    //Enchere enchere = EnchereManager.getInstance().getEnchere(noUtilisateur,noArticle);
	    ArticleVendu article = ArticleManager.getInstance().getArticleVendu(noArticle);
	    System.out.println("article :" + article);
	    request.setAttribute("article", article);
	    request.getRequestDispatcher("/WEB-INF/jsp/enchere/detailEnchere.jsp").forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
