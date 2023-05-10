package fr.eni.encheres.filter;

import java.io.IOException;

import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter (
		dispatcherTypes = {
			DispatcherType.REQUEST	
		},
		urlPatterns = {
			"/enchere/detailEnchere",
			"/utilisateur/mon-compte",
			"/utilisateur/mon-compte/*",
			"/utilisateur/modifierMonCompte",
			"/utilisateur/suprimerMonCompte",
			"/enchere/ajouterEnchere",
			"/enchere/detailEnchere",
			"/enchere/ModifierUneVente",
			"/enchere/suprimer",
		}	
)

public class GuardFilter extends HttpFilter implements Filter {
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("pseudo");
		
		if (utilisateur == null) {
			response.sendRedirect(request.getContextPath()+"/utilisateur/connexion");
			return;
		}
		
		// passe la requête au filtre
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Starting Filtre Guard");
	}
	
}
