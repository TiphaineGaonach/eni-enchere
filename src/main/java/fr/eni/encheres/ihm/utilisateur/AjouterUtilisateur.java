package fr.eni.encheres.ihm.utilisateur;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/ajouterUtilisateur")
public class AjouterUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/creationUtilisateur.jsp") // on délégue a la jsp
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email,telephone, rue, codePostal, ville, motDePasse, 0, false);
				System.out.println(utilisateur);
				
				
					try {
						UtilisateurManager.getInstance().addUser(utilisateur);
					
					} catch (BusinessException e) {
					    request.setAttribute("erreur", "Le pseudo ou l'email est déjà utilisé. Veuillez en choisir un autre");
					    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/creationUtilisateur.jsp");
					    rd.forward(request, response);
					}
					if(utilisateur.getNoUtilisateur()>0) {//TODO ajoute messega de réussite si utilisateur créer
						HttpSession session = request.getSession();
						session.setAttribute("pseudo", utilisateur);
						//		Flash.send("success", "l'utilisateur à bien été créé", request.getSession());
							response.sendRedirect(request.getContextPath()+"");
					}
					
					
				

		//			else {
		//				//TODO ajouter erreure mot de passe != de confirmation
		//			}
			};
			
	
			
		
	}

}
