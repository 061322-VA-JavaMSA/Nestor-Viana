package com.revature.daoImplement;

import java.util.List;

import com.revature.daos.userDAO;
import com.revature.models.User;

public class UserDAOPostgres implements userDAO{

	public User insertUser(User u) {
		u.setId(-1);
		
		String sql = "insert into users (username, password, role) values (?,?,?) returning id;";
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getRole().toString());
			
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				u.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
