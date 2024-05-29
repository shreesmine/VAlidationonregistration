
package com.validation.pack.entity;

public class User {
    private String name;
    private String contactNumber;
    private String username;
    private String password;

    public User() {}

    public User(String name, String contactNumber, String username, String password) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

   
}
