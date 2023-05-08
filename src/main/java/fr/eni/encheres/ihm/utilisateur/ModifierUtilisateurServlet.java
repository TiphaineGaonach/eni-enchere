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
		
//		//int id = Integer.parseInt(request.getParameter("id"));
//			String params = request.getPathInfo();
//			int noUtilisateur = Integer.parseInt(params.substring(1));// substring pour se débarasser du / + ParseInt pour caster en entier
//		// récupere l'utilisateur pour la suppression
//			Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateur(noUtilisateur);
//			request.setAttribute("utilisateur", utilisateur);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur ancienUtilisateur = (Utilisateur) session.getAttribute("pseudo");
		int id = ancienUtilisateur.getNoUtilisateur();
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String penom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation = request.getParameter("confirmation");
		
		if (motDePasse.equals(confirmation)) {
			Utilisateur utilisateur = new Utilisateur(id, pseudo, nom, penom, email,telephone, rue, codePostal, ville, motDePasse, 0, false);
			System.out.println(utilisateur);
			
			//try {
				UtilisateurManager.getInstance().updateUtilisateur(utilisateur);
				//TODO ajoute messega de réussite si utilisateur modifier + modifie la session
				session.setAttribute("pseudo", utilisateur);
//			} catch (BusinessException e) {
//				// TODO message d'erreur + retour à la modification
//				request.setAttribute("erreurs", e.getErreurs());
//				doGet(request, response);
//			}
			
			
		}
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/detailUtilisateur.jsp")
		.forward(request, response);
	}

}
