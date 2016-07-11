/**
 * 
 */
package org.jefecomp.datamodel.entities.user.dao.query;

/**
 * @author jefecomp
 *
 */
public enum UserNamedQuery {
	
	GET_BY_USERNAME("Select username, password from User Where username = :username"),
    	
    	DELETE_BY_USERNAME("Delete from User Where username = :username"),
    	
    	INSERT_USER("Insert into User(username,password) values(:username, :password)");
	
	private String query;
	
	private UserNamedQuery(String query) {
		
		this.query = query;
	}
	
	public String query(){
		
		return this.query;
	}
}