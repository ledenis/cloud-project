package project.bookinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper class containing informations of a book such as author, title,
 * isbn...
 */
public class BookInfo {
	private List<String> authors;
	private String title;
	private String publisher;
	private String description;
	private String isbn;
	private double googleRating;
	private int googleRatingsCount;

	public BookInfo() {
		authors = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String author) {
		authors.add(author);
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the average user rating in Google Books, or -1.0 if none
	 */
	public double getGoogleRating() {
		return googleRating;
	}

	public void setGoogleRating(double googleRating) {
		this.googleRating = googleRating;
	}

	/**
	 * @return the number of user ratings in Google Books
	 */
	public int getGoogleRatingsCount() {
		return googleRatingsCount;
	}

	public void setGoogleRatingsCount(int googleRatingsCount) {
		this.googleRatingsCount = googleRatingsCount;
	}
}
