package cyber.java.crmApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import cyber.java.crmApp.dao.RoleDao;
import cyber.java.crmApp.dbconnection.MySqlConnection;
import cyber.java.crmApp.dto.RoleDto;
import cyber.java.crmApp.dto.UserCreateDto;
import cyber.java.crmApp.model.Role;

public class RoleDao {
	
	public List<Role> findAll(){
		List<Role> roles = new LinkedList<Role>();
		
		try {
			Connection connection = MySqlConnection.getConnection();
			
			String query ="SELECT * FROM role";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("Description"));
				roles.add(role);
			}
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		}
		return roles;
		
	}
	
	public Role findById(int id) {
		Role role = new Role();
		Connection connection = MySqlConnection.getConnection();
		String query ="SELECT * FROM role WHERE id=?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));
				
			}
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return role;
	}
	// delete
	public void deleteById(int id) throws SQLException {
		Connection connection = MySqlConnection.getConnection();
		String query = "DELETE FROM role WHERE id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		
		}
		finally {
			connection.close();
		
		}
	}
	//Role Add
	public void add(RoleDto rodto) throws SQLException {
		String query = "INSERT INTO role(name,description)"
				+ "VALUES(?,?)";
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
		
			statement.setNString(1, rodto.getName());
			statement.setNString(2, rodto.getDescription());
			
			
			statement.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		} finally {
			connection.close();
			}
		}
	
	  // Role Update
		public void update(RoleDto rodto) throws SQLException {
		
		String query = "UPDATE role set name=?, description=? WHERE id=?";
				
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			
			statement.setNString(1, rodto.getName());
			statement.setNString(2, rodto.getDescription());
			
			statement.setInt(3,rodto.getId());
			
			
			statement.executeUpdate();
			
		}catch (SQLException e) {	
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
	
}
}
