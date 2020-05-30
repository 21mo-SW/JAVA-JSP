package models;

import lombok.Data;

@Data
public class Users {
	
	private int id;
	private String userId;
	private String password;
	
	public Users() {}

	public Users(int id, String userId, String password) {
		this.id = id;
		this.userId = userId;
		this.password = password;
	}
}
