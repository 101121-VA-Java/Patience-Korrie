package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Users;

import util.ConnectionUtil;


public class UserPostgres implements UserDao{
	private static Logger log = LogManager.getRootLogger();
	
	@Override
	public List<Users> getAllEmployee() {
		String sql = "select * from users;";
		List<Users> employees = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			Statement ps = connect.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("u_id");
				String firstName = rs.getString("u_first_name");
				String lastName = rs.getString("u_last_name");
				String username = rs.getString("u_username");
				String password = rs.getString("u_password");
				String email = rs.getString("u_email");
				int role = rs.getInt("u_role");
				
				Users emp = new Users(id, firstName, lastName,username,password,email,role);
				employees.add(emp);
				}
		
		} catch (SQLException |IOException e) {
			log.error("Error while trying to get item.");
			e.printStackTrace();
		} 
	return employees;
	}

	@Override
	public Users getEmployeeById(int id) {
		String sql = "select * from users where u_id = ? ";
		Users emp = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id1 = rs.getInt("u_id");
				String firstName = rs.getString("u_first_name");
				String lastName = rs.getString("u_last_name");
				String username = rs.getString("u_username");
				String password = rs.getString("u_password");
				String email = rs.getString("u_email");
				int role = rs.getInt("u_role");
				
				emp = new Users(id1, firstName, lastName, username, password, email, role);
				
			}
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Users addEmployee(Users employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployee(Users employee) {
		String sql = "update users set u_first_name = ?, u_last_name = ?, u_username = ?, u_password = ?, u_email = ?, u_role = ?" + "Where u_id = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getUsername());
			ps.setString(4, employee.getPassword());
			ps.setString(5, employee.getEmail());
//			ps.setInt(6, employee.getRole());
			
			rowsChanged = ps.executeUpdate();
			
		}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}



}
