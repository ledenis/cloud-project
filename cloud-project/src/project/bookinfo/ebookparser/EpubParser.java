package project.bookinfo.ebookparser;

import ebook.EBook;
import ebook.Person;
import ebook.parser.InstantParser;
import ebook.parser.Parser;

/**
 * Extract informations from an epub-format e-book
 */
public class EpubParser {
	public EpubParser() {
	}

	/**
	 * Parse the e-book meta-data and return a query for a search with Google
	 * Books API
	 * 
	 * @param fileName
	 *            The e-book file
	 * @return The query, or null if parsing failed
	 */
	public static String buildGoogleBooksQuery(String fileName) {
		Parser parser = new InstantParser();
		EBook ebook = parser.parse(fileName);

		// Fail
		if (!ebook.isOk) {
			return null;
		}

		// Success
		// query format: "intitle:<title> inauthor:<authors>"
		StringBuilder sb = new StringBuilder("intitle:");
		sb.append(ebook.title).append(" inauthor:");
		for (Person auth : ebook.authors) {
			sb.append(auth.firstName == null ? "" : auth.firstName).append(" ")
					.append(auth.middleName == null ? "" : auth.middleName)
					.append(" ")
					.append(auth.lastName == null ? "" : auth.lastName)
					.append(" ")
					.append(auth.nickName == null ? "" : auth.nickName)
					.append(" ");
		}
		return sb.toString();
	}
}
