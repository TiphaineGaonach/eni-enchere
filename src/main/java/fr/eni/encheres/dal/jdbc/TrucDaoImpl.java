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

import bo.Truc;
import config.ConnectionProvider;
import dal.TrucDAO;

public class TrucDaoImpl implements TrucDAO{
	private final static String SELECT_ALL_TRUC = "SELECT * FROM trucs";
	private final static String SELECT_ONE_TRUC = "SELECT * FROM trucs WHERE id = ?";
	private final static String UPDATE_TRUC = "UPDATE trucs SET unMachinEnInt = ?, unMachinEnFloat = ?, unMachinEnString = ?, unMachinEnLocalDate = ?, unMachinEnBoolean = ?, WHERE id = ?";
	private final static String INSERT_TRUC = "INSERT INTO trucs (unMachinEnInt, unMachinEnFloat, unMachinEnString, unMachinEnLocalDate, unMachinEnBoolean) VALUES (?,?,?,?,?)";
	private final static String DELETE_TRUC = "DELETE FROM trucs WHERE id = ?";
	
	@Override
	public List<Truc> selectAll() {
		System.out.println("dao select all");
		try(Connection connection = ConnectionProvider.getConnection()){
			List<Truc> trucs = new ArrayList<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_TRUC);
			while(rs.next()) {
				trucs.add( new Truc(
						rs.getInt("id"),
						rs.getInt("unMachinEnInt"),
						rs.getFloat("unMachinEnFloat"),
						rs.getString("unMachinEnString"),
						rs.getDate("unMachinEnLocalDate").toLocalDate(),
						rs.getBoolean("unMachinEnBoolean"))) ;
			}
			return trucs;
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public Truc selectOne(int id) {
		try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement  stmt = connection.prepareStatement(SELECT_ONE_TRUC);
			stmt.setInt(1, id);
			System.out.println("id à trouver dans la bdd= " + id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				
				return new Truc(
						rs.getInt("unMachinEnInt"),
						rs.getFloat("unMachinEnFloat"),
						rs.getString("unMachinEnString"),
						rs.getDate("unMachinEnLocalDate").toLocalDate(),
						rs.getBoolean("unMachinEnBoolean")) ;
			}		
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public void insert(Truc truc) { // passage par ref
		System.out.println("DAOIMPL insert un truc");
		try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement  stmt = connection.prepareStatement(
											INSERT_TRUC,
											PreparedStatement.RETURN_GENERATED_KEYS
										);
			prepareTrucSQL(truc, stmt);// Extrait les info de l'objet Truc pour le stmt
			
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				truc.setId(rs.getInt(1));// Récup de l'ID pour redirection ou complesion de l'objet Truc
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Truc truc) {
		try(Connection connection = ConnectionProvider.getConnection()){					
			PreparedStatement  stmt = connection.prepareStatement(DELETE_TRUC);
			stmt.setInt(1, truc.getId());
			stmt.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void update(Truc truc) {
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(UPDATE_TRUC);
			prepareTrucSQL(truc, stmt);// Extrait les info de l'objet Truc pour le stmt
			
			// ajoute l'id au Where
			stmt.setInt(6, truc.getId());// remplacer 6 par le numeros du ? qui correspond au Wherre
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();// levee DAL Exception
		}
		
	}
	/**
	 * Extrait les Attributs de l'objet Truc pour le PrepareStatement stmt
	 * @param truc : Objet à insérer ou a modifier dans la base SQL 
	 * @param stmt : PrepareStatement de l'instruction SQL à préparer
	 * @throws SQLException
	 */
	private void prepareTrucSQL(Truc truc, PreparedStatement stmt) throws SQLException {
		
		stmt.setInt(1, truc.getUnMachinEnInt());// pour ajouter un int
		stmt.setFloat(2, truc.getUnMachinEnFloat());// pour ajouter un Float
		stmt.setString(3, truc.getUnMachinEnString());// pour ajouter un String
		stmt.setDate(4,Date.valueOf(truc.getUnMachinEnLocalDate()));// ajouter une date venant de l'objet Truc
		stmt.setBoolean(5, truc.isUnMachinEnBoolean()); // pour ajouter un boolean vraix
	}

	

}
