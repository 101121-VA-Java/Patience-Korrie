package com.revature.models;

import java.util.Objects;

public class Users {
	private int Id;
	private String username;
	private String password;
	private String email;
	private Users role;
	
	public Users() {
		super();
	}

	public Users(int id, String username, String password, String email, Users role) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Users getRole() {
		return role;
	}

	public void setRole(Users role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, email, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Id == other.Id && Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Users [Id=" + Id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}
	
	
}

