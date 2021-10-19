package cyber.java.crmApp.service;

import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import cyber.java.crmApp.dao.UserDao;
import cyber.java.crmApp.dto.UserCreateDto;
import cyber.java.crmApp.model.Role;
import cyber.java.crmApp.model.User;
import cyber.java.crmApp.util.PwdUtils;


public class UserService {
private UserDao dao;
	
	public UserService() {
		dao = new UserDao();
	}

	public List<User> findAll() {
		List<User> users = null;
		try {
			users = dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	public User findById(int id) {
		User user = new User();
		
		try {
			user = dao.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
	public User findByEmail(String email) {
		User user = new User();
		
		try {
			user = dao.findByEmail(email);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}

	public void deleteById(int id) {
		try {
			dao.deleteById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(UserCreateDto dto) {
		String hashedPwd = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		dto.setPassword(hashedPwd);
		
		try {
			dao.add(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(UserCreateDto dto) {
		String hashedPwd = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		dto.setPassword(hashedPwd);
		try {
			dao.update(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
