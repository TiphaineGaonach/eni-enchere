package fr.eni.encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import java.io.IOException;
import java.util.List;
import org.apache.tomcat.jakartaee.commons.compress.archivers.zip.X0017_StrongEncryptionHeader;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Recherche;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ArticleVendu> articleVendus=ArticleManager.getInstance().getAllArticleVendus();
		List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();
		request.setAttribute("articleVendus", articleVendus);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Fonction rechercher.
		
		// creation de la demande de recherche
		List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();
		
		HttpSession session = request.getSession();
		String motClef = request.getParameter("motClef");
		String categorieString = request.getParameter("categorie");
		Categorie categorie = new Categorie();
		
		for (Categorie c : categories) {
			if (c.getLibelle().equals(categorieString)) {
				categorie = c;
			}
		}
		
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("pseudo") ;
		String boutonActif = request.getParameter("boutonActif");;
		
		
		Recherche recherche =  new Recherche(motClef, categorie, utilisateur, boutonActif);
		
		
		
		List<ArticleVendu> articlesAfficher = ArticleManager.getInstance().getRechercheArticleVendus(recherche);
		 System.out.println("servlet accueil list article vendu " + articlesAfficher);
		request.setAttribute("articleVendus", articlesAfficher);
		
		request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
	}

}
