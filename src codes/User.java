package com.mcnz.jdbc.sqlserver;

public class User {
	private int id;
	private String email;
	private String username;
	private String password;

	// Constructor with ID (e.g., when retrieved from DB)

	public User(int id, String email, String username, String password) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	// Constructor without ID (e.g., before insert)
	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public int getId() { return id; }
	public String getEmail() { return email; }
	public String getUserName() { return username; }
	public String getPassword() { return password; }
}



