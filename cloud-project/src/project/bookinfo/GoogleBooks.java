package project.bookinfo;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;

/**
 * Uses Google Books API to run queries on books
 */
public class GoogleBooks {
	// Google API objects
	private JsonFactory jsonFactory;
	private Books books;
	private static final String API_KEY = "AIzaSyCYoA48GD3OwD-7n3cyGQYG_DwPX2OQWkQ";

	private BookInfo bookInfo = null;

	public GoogleBooks() throws GeneralSecurityException, IOException {
		jsonFactory = JacksonFactory.getDefaultInstance();

		// Set up Books client.
		books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(),
				jsonFactory, null)
		// .setApplicationName(APPLICATION_NAME)
				.setGoogleClientRequestInitializer(
						new BooksRequestInitializer(API_KEY)).build();
	}

	/**
	 * Execute a search query with the Google Books API
	 * 
	 * @param query
	 *            Query format:
	 *            "[<inauthor|isbn|intitle|inpublisher|subject>:]<query>"
	 * @return The first result as a BookInfo object, or null if no books found
	 * @throws IOException
	 */
	public BookInfo query(String query) throws IOException {
		// Set query string (and filter)
		List volumesList = books.volumes().list(query);
		// volumesList.setFilter("ebooks");

		// Execute the query.
		Volumes volumes = volumesList.execute();
		if (volumes.getTotalItems() != 0 && volumes.getItems() != null) {
			constructBookInfo(volumes.getItems().get(0));
			return bookInfo;
		}

		return null;
	}

	private void constructBookInfo(Volume volume) {
		bookInfo = new BookInfo();

		Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
		// Volume.SaleInfo saleInfo = volume.getSaleInfo();

		// Title
		bookInfo.setTitle(volumeInfo.getTitle());
		// Authors
		bookInfo.setAuthors(volumeInfo.getAuthors());
		// Description
		if (volumeInfo.getDescription() != null
				&& volumeInfo.getDescription().length() > 0) {
			System.out.println("Description: " + volumeInfo.getDescription());
		}
		// Ratings
		bookInfo.setGoogleRating(volumeInfo.getAverageRating());
		bookInfo.setGoogleRatingsCount(volumeInfo.getRatingsCount());
	}

	/**
	 * @return the result of the last query
	 */
	public BookInfo getBookInfo() {
		return bookInfo;
	}
}