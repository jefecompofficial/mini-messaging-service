/**
 * 
 */
package org.jefecomp.datamodel.entities.data;

/**
 * @author jefecomp
 *
 */
public class Post {
    
    private Long id;
    
    private String owner;
        
    private String data;

    public Post() {
    }
    
    public Post(String owner, String data){
	
	this.owner = owner;
	
	this.data = data;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}