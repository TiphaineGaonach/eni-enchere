package fr.eni.encheres.ihm.securite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.SecuriteManager;
import fr.eni.encheres.bo.Utilisateur;


@WebServlet("/connexion")
public class ConnexionUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/securite/connexion.jsp")
		.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String pseudo = request.getParameter("pseudo");
			String motDePasse = request.getParameter("motDePasse");
			Utilisateur utilisateur = SecuriteManager.getInstance().connexion(pseudo, motDePasse);
			
			System.out.println("utilisateur " +utilisateur);
			System.out.println(pseudo);
			System.out.println("user saisi "+pseudo);
			//System.out.println("user bdd " +utilisateur.getPseudo());
			
			// on teste que l'utilisateur existe et que le mot de passe est ok
			if ((utilisateur == null) || !(utilisateur.getMotDePasse().equals(motDePasse)) ) { 
				request.setAttribute("erreur", "Pseudo ou mot de passe invalide");
				request.getRequestDispatcher("/WEB-INF/jsp/securite/connexion.jsp").forward(request, response);
				return;
			}
			
			//Création session
			HttpSession session = request.getSession();
			session.setAttribute("pseudo", utilisateur);
//			session.setAttribute("ip", request.getRemoteAddr());// verif adresse IP
//			session.setAttribute("useragent", request.getHeader("user-agent")); // verif du navigateur
			response.sendRedirect(request.getContextPath()+"/");
				
			
			
			//response.sendRedirect(request.getContextPath()+"/connexion");
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
		}
	}

}
