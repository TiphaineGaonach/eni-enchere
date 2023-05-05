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


@WebServlet("/utilisateur/mon-compte/*")
public class DetailUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		HttpSession session = request.getSession();
//		Utilisateur utilisateur = (Utilisateur) session.getAttribute("pseudo");
//		
//		
//		
//		String params = request.getPathInfo();
//		int id= Integer.parseInt(params.substring(1));// substring pour se débarasser du / + ParseInt pour caster en entier
//		// récupère l'utilisateur
//		
//		Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateur(id); 
//		request.setAttribute("utilisateur", utilisateur);
		request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/detailUtilisateur.jsp")
		.forward(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
