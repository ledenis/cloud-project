package project.bookinfo;

import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.User;

public class UserLibrary {

	List<Bookshelf> shelves;
	User user;
	
	public UserLibrary(User user)
	{
		this.user = user;
		shelves = new LinkedList<>();		
	}
	
	public void retrieveInfos()
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		String userId = user.getUserId();
		Key userKey = KeyFactory.createKey("User", userId);
		Query query = new Query("Bookshelf", userKey);
		
		List<Entity> bookshelves = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		
		for(Entity shelf : bookshelves)
		{
			Bookshelf bs = new Bookshelf(shelf);
			
			shelves.add(bs);
		}
	}
	
	public void createBS(String name)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		String userId = user.getUserId();
		Key userKey = KeyFactory.createKey("User", userId);
		
		Entity bs = new Entity("Bookshelf", userKey);
		bs.setProperty("name", name);
		
		datastore.put(bs);
	}

	/*
	 * xxx: Untested deleteBS
	 */
	public void deleteBS(String name)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		String userId = user.getUserId();
	    Key userKey = KeyFactory.createKey("User", userId);

		Entity bs = new Entity("Bookshelf", userKey);
		if (bs.hasProperty(name)) {
			bs.removeProperty(name);
			datastore.put(bs);
		}
	}
	
	public List<Bookshelf> getBookshelves()
	{
		return shelves;
	}
	
	public User getUser()
	{
		return user;
	}
	
}
