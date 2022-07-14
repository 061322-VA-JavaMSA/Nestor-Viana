package com.revature.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.userDAO;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

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
		String sql = "select * from users where id = ?;";
		User user = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id); // this refers to the 1st "?" in the sql string, allows to inject data

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(Role.valueOf(rs.getString("role")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public User getUserByUsername(String username) {
		String sql = "select * from users where username  = ?;";
		User user = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); // this refers to the 1st "?" in the sql string, allows to inject data

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
//				user.setFirstname(rs.getString("firstname"));
//				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(Role.valueOf(rs.getString("role")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List<User> getUsers() {
		String sql = "select * from users;";
		List<User> users = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRole(Role.valueOf(rs.getString("role")));
				
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	

}
