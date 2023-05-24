package fr.eni.encheres.ihm.utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/utilisateur/modifierMonCompte")
public class ModifierUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/modifierUtilisateur.jsp")
		.forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur ancienUtilisateur = (Utilisateur) session.getAttribute("pseudo");
		int id = ancienUtilisateur.getNoUtilisateur();
		int credit = ancienUtilisateur.getCredit();
		boolean administrateur = ancienUtilisateur.isAdministrateur();
		
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation = request.getParameter("confirmation");
		
		if (motDePasse.equals(confirmation)) {
			Utilisateur utilisateur = new Utilisateur(id, pseudo, nom, prenom, email,telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
			
				try {
					UtilisateurManager.getInstance().updateUtilisateur(utilisateur);
					//TODO ajoute message de réussite si utilisateur modifier + modifie la session
					session.setAttribute("pseudo", utilisateur);
					
				} catch (BusinessException e) {
					request.setAttribute("erreur", "Le pseudo ou l'email est déjà utilisé. Veuillez en choisir un autre");
					request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/modifierUtilisateur.jsp")
					.forward(request, response);
					return;
				}
		}else {
			 request.setAttribute("erreur", "Les mots de passe ne sont pas identiques");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/detailUtilisateur.jsp")
		.forward(request, response);
	}

}
