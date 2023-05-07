package fr.eni.encheres.ihm.enchere;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.bll.EnchereManager;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/enchere/detailEnchere")
public class DetailEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Integer noArticle =Integer.parseInt(request.getParameter("article"));
	    Integer noUtilisateur = Integer.parseInt(request.getParameter("user"));
	    
	    Enchere enchere = EnchereManager.getInstance().getEnchere(noUtilisateur,noArticle);
	    request.setAttribute("enchere", enchere);
	    request.getRequestDispatcher("/WEB-INF/jsp/enchere/detailEnchere.jsp").forward(request, response);

	    
	    
		//int id= Integer.parseInt(params.substring(1));// substring pour se débarasser du / + ParseInt pour caster en entier
		// récupère l'utilisateur
	//	Utilisateur enchere = EnchereManager.getInstance().getEnchere(id); UtilisateurManager.getInstance().getUtilisateur(id); 
		//request.setAttribute("enchere", enchere);
		request.getRequestDispatcher("/WEB-INF/jsp/enchere/detailEnchere.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
