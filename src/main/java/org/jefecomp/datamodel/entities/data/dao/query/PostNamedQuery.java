/**
 * 
 */
package org.jefecomp.datamodel.entities.data.dao.query;

/**
 * @author jefecomp
 *
 */
public enum PostNamedQuery {
    
    LAST_INSERTED_POST("Select max(id) as id from Post where owner = :owner and data = :data"),
    
    ADD_POST("Insert into Post (owner,data) values(:owner, :data)"),
    
    GET_BY_ID("Select id, owner, data from Post Where id = :id"),
    
    GET_BY_OWNER("Select id, owner, data from Post Where owner = :owner"),
    
    GET_BY_OWNER_LIST("Select id, owner, data from Post where owner in (:owners)"),
    
    GET_BY_OWNER_FILTERED("Select id, owner, data from Post Where owner = :owner AND data like :data"),
    
    GET_BY_OWNER_LIST_FILTERED("Select id, owner, data from Post Where owner in (:owners) AND data like :data order by owner"),
    
    DELETE_BY_ID("Delete from Post where id = :id"),
    
    DELETE_BY_OWNER("Delete from Post where owner = :owner"),
    
    DELETE_BY_OWNER_FILTERED("Delete from Post where owner = :owner and data like :data"),
    
    UPDATE_POST("Update Post set data = :data where id = :id");
    
    private String query;
    
    private PostNamedQuery(String query) {
	
	this.query = query;
    }

    public String query(){
	
	return this.query;
    }
    
}
