/**
 * 
 */
package org.jefecomp.datamodel.entities.data.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jefecomp.datamodel.dao.AbstractDao;
import org.jefecomp.datamodel.dao.Dao;
import org.jefecomp.datamodel.entities.data.Post;
import org.jefecomp.datamodel.entities.data.dao.query.PostNamedQuery;
import org.springframework.stereotype.Component;

/**
 * @author jefecomp
 *
 */
@Component
public class PostDao extends AbstractDao implements Dao<Post> {

    private String ID="id";
    
    private String OWNER="owner";
    
    private String DATA="data";
    
    private String OWNERS="owners";
    
    
    private Long getInsertedPostId(String owner, String data){
	
	Map<String,Object> params = new HashMap<>();
	
	params.put(this.OWNER, owner);
	params.put(this.DATA, data);
	
	Post post = this.getNamedParameterTemplate().query(PostNamedQuery.LAST_INSERTED_POST.query(), params, new PostMaxIdResultSetExtractor());
	
	return post != null ? post.getId() : -1L;
    }
    
    
    @Override
    public Post getById(Long id) {
	
	return this.getNamedParameterTemplate().query(PostNamedQuery.GET_BY_ID.query(), Collections.singletonMap(this.ID, id), new PostResultSetExtractor());
    }

    @Override
    public boolean deleteEntity(Long id) {
	
	return this.getNamedParameterTemplate().update(PostNamedQuery.DELETE_BY_ID.query(), Collections.singletonMap(this.ID, id)) > 0;
    }
    
    
    public boolean deleteByOwner(Long ownerId, String search){
	
	if(search == null){
	    
	    return this.deleteByOwner(ownerId);
	}
	
	StringBuilder searchBuilder = new StringBuilder();
	
	searchBuilder.append("%");
	searchBuilder.append(search);
	
	
	Map<String,Object> params = new HashMap<>();
	
	params.put(this.OWNER, ownerId);
	params.put(this.DATA, searchBuilder.toString());
	
	return this.getNamedParameterTemplate().update(PostNamedQuery.DELETE_BY_OWNER_FILTERED.query(), params) > 0;
    }
    
    
    public boolean deleteByOwner(Long ownerId){
	
	return this.getNamedParameterTemplate().update(PostNamedQuery.DELETE_BY_OWNER.query(), Collections.singletonMap(this.OWNER, ownerId)) > 0;
    }

    
    public List<Post> getPostsByOwner(String owner, String search){
	
	if(search == null){
	    
	    return this.getPostsByOwner(owner);
	}
	
	StringBuilder searchBuilder = new StringBuilder();
	
	searchBuilder.append("%");
	searchBuilder.append(search);
	searchBuilder.append("%");
	
	Map<String,Object> params = new HashMap<>();
	
	params.put(this.OWNER, owner);
	params.put(this.DATA, searchBuilder.toString());
	
	return this.getNamedParameterTemplate().query(PostNamedQuery.GET_BY_OWNER_FILTERED.query(), params,new PostRowMapper());
	
    }
    
    
    public List<Post> getPostsByOwner(String owner){
	
	return this.getNamedParameterTemplate().query(PostNamedQuery.GET_BY_OWNER.query(), Collections.singletonMap(this.OWNER, owner),new PostRowMapper());
    }
    
    
    public List<Post> getPostsByOwnerList(List<String> owners, String search){
	
	if(search == null){
	    
	    return this.getPostsByOwnerList(owners);
	}
	
	StringBuilder searchBuilder = new StringBuilder();
	
	searchBuilder.append("%");
	searchBuilder.append(search);
	searchBuilder.append("%");
	
	Map<String,Object> params = new HashMap<>();
	
	params.put(this.OWNERS, owners);
	params.put(this.DATA, searchBuilder.toString());
	
	
	return this.getNamedParameterTemplate().query(PostNamedQuery.GET_BY_OWNER_LIST_FILTERED.query(), params, new PostRowMapper());
    }
    
    
    public List<Post> getPostsByOwnerList(List<String> owners){
	
	return this.getNamedParameterTemplate().query(PostNamedQuery.GET_BY_OWNER_LIST.query(), Collections.singletonMap(this.OWNERS, owners), new PostRowMapper());
    }

    @Override
    public Long createEntity(Post entity) {
	
	Map<String,Object> params = new HashMap<>();
	
	params.put(this.OWNER, entity.getOwner());
	params.put(this.DATA, entity.getData());
	
	if(this.getNamedParameterTemplate().update(PostNamedQuery.ADD_POST.query(), params)> 0){
	    
	    return this.getInsertedPostId(entity.getOwner(), entity.getData());
	}
	
	return -1L;
    }

    @Override
    public boolean updateEntity(Post entity) {
	
	if(entity.getId() == null){
	    
	    return false;
	}
	
	Map<String,Object> params = new HashMap<>();
	
	params.put(this.ID, entity.getId());
	params.put(this.DATA, entity.getData());
	
	return this.getNamedParameterTemplate().update(PostNamedQuery.UPDATE_POST.query(), params) > 0;
    }

}
