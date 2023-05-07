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


@WebServlet("/utilisateur/connexion")
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
			
			if (utilisateur!=null) {

			//Connection / Création session

			HttpSession session = request.getSession();
			session.setAttribute("pseudo", utilisateur);
//			session.setAttribute("ip", request.getRemoteAddr());// verif adresse IP
//			session.setAttribute("useragent", request.getHeader("user-agent")); // verif du navigateur
			response.sendRedirect(request.getContextPath()+"/");
			}
			
			
			//response.sendRedirect(request.getContextPath()+"/connexion");
			
		} catch (BusinessException e) {
		    String message = e.getMessage();
		    System.out.println(e.getMessage());
		    if ("[Utilisateur non trouvé]".equals(message)) {
		        request.setAttribute("erreur", "Utilisateur non trouvé");
		    } else if ("[Mot de Passe erroné]".equals(message)) {
		        request.setAttribute("erreur", "Mot de passe invalide");
		    } else {
		        request.setAttribute("erreur", "Erreur inconnue");
		    }
		    request.getRequestDispatcher("/WEB-INF/jsp/securite/connexion.jsp").forward(request, response);

		}
	}

}
