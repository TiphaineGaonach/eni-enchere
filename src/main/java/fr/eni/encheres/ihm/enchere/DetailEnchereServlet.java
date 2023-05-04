package fr.eni.encheres.ihm.enchere;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.encheres.bll.EnchereManageur;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/enchere/detailEnchere")
public class DetailEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String params = request.getPathInfo();
		int id= Integer.parseInt(params.substring(1));// substring pour se débarasser du / + ParseInt pour caster en entier
		// récupère l'utilisateur
		Utilisateur enchere = EnchereManageur.getInstance().getEnchere(id); UtilisateurManager.getInstance().getUtilisateur(id); 
		request.setAttribute("enchere", enchere);
		request.getRequestDispatcher("/WEB-INF/jsp/enchere/detailEnchere.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
