package fr.eni.encheres.ihm.utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class AjouterUtilisateur
 */
public class AjouterUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/creationUtilisateur.jsp") // on délégue a la jsp
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String penom = request.getParameter("penom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasse = request.getParameter("motDePasse");
			String confirmation = request.getParameter("confirmation");
			
			
	//TODO  Attention, id à suprimer après mise à jour des BO. 
			if (motDePasse.equals(confirmation)) {
				Utilisateur utilisateur = new Utilisateur(pseudo, nom, penom, email,telephone, rue, codePostal, ville, motDePasse, 0, false);
				System.out.println(utilisateur);
		//	TODO	UtilisateurManager.getInstance().addUser(utilisateur);
				if(utilisateur.getNoUtilisateur()>0) {//TODO ajoute messega de réussite si utilisateur créer
					
						//		Flash.send("success", "l'utilisateur à bien été créé", request.getSession());
						//		response.sendRedirect(request.getContextPath()+"/truc/detail/"+truc.getId());
							}
			}else {
				//TODO ajouter erreure mot de passe != de confirmation
			}
			;
			
	
		
		
	}

}
