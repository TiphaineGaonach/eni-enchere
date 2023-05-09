package fr.eni.encheres.ihm.utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;


@WebServlet(name ="profilUtilisateur" , urlPatterns = {"/utilisateur/mon-compte","/utilisateur/mon-compte/*" })
public class DetailUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String params = request.getPathInfo();
		
		//si il y a un paramètre : consultation d'un profil autre d'un autre utilisateur
		if (params != null && params.length() > 1) {	//si on recupere un ID {
			int noUtilisateur = Integer.parseInt(params.substring(1));
			request.setAttribute("noUtilisateur", noUtilisateur);
			
			
			Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateur(noUtilisateur);
			request.setAttribute("utilisateur", utilisateur);
		}
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/detailUtilisateur.jsp")
		.forward(request, response);
	}



}
