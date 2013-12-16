package project.bookinfo;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.LinkedList;
import java.util.List;

import project.bookinfo.search.GoogleBooks;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class Bookshelf {

	private String name;
	
	List<BookInfo> books;
	public Bookshelf(Entity entity)
	{
		name = (String) entity.getProperty("name");
		
		books = new LinkedList<>();
		GoogleBooks gbooks;
		try {
			//createBook();
			
			gbooks = new GoogleBooks();
					
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
			Key bsKey = KeyFactory.createKey("Bookshelf", name);
			Query query = new Query("Book", bsKey);
			
			List<Entity> bookshelf = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
			for (Entity e : bookshelf) {
				BookInfo bookInfo = gbooks.query("isbn:"+e.getProperty("isbn"));
				books.add(bookInfo);
			}
		} catch (GeneralSecurityException | IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void createBook(String isbn)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		Key bsKey = KeyFactory.createKey("Bookshelf", name);
		
		Entity book = new Entity("Book", bsKey);
		book.setProperty("isbn", isbn);
		
		datastore.put(book);
	}
	
	public List<BookInfo> getBooks() {
		return books;
	}
	
	/*
	 * BookInfo book = new BookInfo();
		book.setAuthors((List<String>) b.getProperty("authors"));
		book.setDescription((String) b.getProperty("description"));
		book.setGoogleRating((double) b.getProperty("googleRating"));
		book.setTitle((String) b.getProperty("title"));
	 */
	
	public String getName()
	{
		return name;
	}
}
