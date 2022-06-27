package com.revature.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UserDAO {

	@Override
	public User createUser(User u) {
		
		String sql = "insert into users (firstname, lastname, username, password) values (?,?,?,?) returning id;";
		try(Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public User retrieveUserById(int id) {
		
		String sql = "SELECT * FROM users WHERE id = ?";
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public User retrieveUserByUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";
		User u = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return u;
	}

	@Override
	public Boolean updateUser(User u) {
		return null;
	}

	@Override
	public Boolean deleteUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User retrieveUserByName(String firstname, String lastname) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
