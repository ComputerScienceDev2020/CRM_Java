package cyber.java.crmApp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;


import cyber.java.crmApp.dao.AuthDao;
import cyber.java.crmApp.dao.UserDao;
import cyber.java.crmApp.dto.UserLoginDto;
import cyber.java.crmApp.dbconnection.MySqlConnection;

public class AuthService {
	private AuthDao dao;
	
	public AuthService() {
		dao = new AuthDao();
	}

//	public boolean login(String email, String password) {
//		UserLoginDto dto = null;
//		
//		try {
//			dto = dao.findUserLogin(email);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//		if(dto == null)
//			return false;
//		
//		return BCrypt.checkpw(password, dto.getPassword());
//	}
//	
//}

public UserLoginDto login(String email, String password) {
		
		try {
			String query = "SELECT email, password FROM user email=? and password =?";
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserLoginDto account = new UserLoginDto(result.getString(1), result.getString(2));
				return account;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
