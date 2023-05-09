package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.config.ConnectionProvider;
import fr.eni.encheres.dal.UtilisateurDAO;



public class UtilisateurDaoImpl implements UtilisateurDAO{
	private final static String SELECT_ALL_UTILISATEUR = "SELECT * FROM UTILISATEURS";
	private final static String SELECT_ONE_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	private final static String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET "
			+ "pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? "
			+ "WHERE no_utilisateur = ?";
	private final static String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur  ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final static String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String SELECT_BY_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE pseudo = ? OR email = ?";
	

	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException { 
		try(Connection connection = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = connection.prepareStatement(INSERT_UTILISATEUR,PreparedStatement.RETURN_GENERATED_KEYS);
			
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getCredit());
			pStmt.setBoolean(11, utilisateur.isAdministrateur());
			
			
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				utilisateur.setNoUtilisateur(1);    //pour la redirection
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException ("Erreur insertion");
		}

		
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		try(Connection connection = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = connection.prepareStatement(DELETE_UTILISATEUR);			
			pStmt.setInt(1, utilisateur.getNoUtilisateur());
			
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void update(Utilisateur utilisateur) {
		try(Connection connection = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = connection.prepareStatement(UPDATE_UTILISATEUR);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getCredit());
			pStmt.setBoolean(11, utilisateur.isAdministrateur());
			pStmt.setInt(12, utilisateur.getNoUtilisateur());
			
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	
	
	
	@Override
	public List<Utilisateur> selectAll() {
		try(Connection connection = ConnectionProvider.getConnection()){
			List<Utilisateur> articles = new ArrayList<>();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_UTILISATEUR);
			
			
			while(rs.next()) {
				articles.add(new Utilisateur(rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getBoolean("administrateur")));
			}
			return articles;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur selectOne(int id) {
		try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = connection.prepareStatement(SELECT_ONE_UTILISATEUR);
			
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
						return new Utilisateur(rs.getInt("no_utilisateur"),
								rs.getString("pseudo"),
								rs.getString("nom"),
								rs.getString("prenom"),
								rs.getString("email"),
								rs.getString("telephone"),
								rs.getString("rue"),
								rs.getString("code_postal"),
								rs.getString("ville"),
								rs.getString("mot_de_passe"),
								rs.getInt("credit"),
								rs.getBoolean("administrateur"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public Utilisateur selectByUser(String identifiant) {
		try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = connection.prepareStatement(SELECT_BY_UTILISATEUR);
			
			stmt.setString(1,identifiant);
			stmt.setString(2,identifiant);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
						return new Utilisateur(rs.getInt("no_utilisateur"),
								rs.getString("pseudo"),
								rs.getString("nom"),
								rs.getString("prenom"),
								rs.getString("email"),
								rs.getString("telephone"),
								rs.getString("rue"),
								rs.getString("code_postal"),
								rs.getString("ville"),
								rs.getString("mot_de_passe"),
								rs.getInt("credit"),
								rs.getBoolean("administrateur"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	

}
