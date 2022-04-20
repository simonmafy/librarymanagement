package sait.bms.problemdomain;

/**
 * The ChildrenBooks class has all the assessor and mutators. It also has helps
 * creates the objects while the books.txt is being scanned into the arraylist.
 * 
 * @author Simon Ma 562187
 * @version February 13/2020
 *
 */

public class ChildrenBooks extends Book {

	String author;
	String format;

	public ChildrenBooks() {

		author = "";
		format = "";

	}

	/**
	 * Gets the all the information from the books.txt and puts it into this class.
	 * 
	 * @param getISBN
	 * @param getCall
	 * @param getAvailable
	 * @param getTotal
	 * @param getTitle
	 * @param getAuthor
	 * @param getFormat
	 */
	public ChildrenBooks(long getISBN, String getCall, int getAvailable, int getTotal, String getTitle,
			String getAuthor, String getFormat) {

		ISBN = getISBN;
		call = getCall;
		available = getAvailable;
		total = getTotal;
		title = getTitle;
		author = getAuthor;
		format = getFormat;
	}

	/**
	 * Uses the format string value
	 * 
	 * @return the format string value
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Uses the author string value
	 * 
	 * @return the author string value
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Changes a specific format as the ArrayList is printed onto books.txt
	 * 
	 * @return format (ISBN + ";" + call + ";" + available + ";" + total + ";" +
	 *         title + ";" + author + ";" + format + "\n")
	 */
	public String toPrintFormat() {
		return String.format(
				ISBN + ";" + call + ";" + available + ";" + total + ";" + title + ";" + author + ";" + format + "\n");
	}

	/**
	 * Overrides the default toString and makes this new format the new toString
	 * 
	 * @return ("%-16s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n
	 *         %-15s%-20s\n %-15s%-20s\n\n", " ISBN: ", ISBN, "Call Number: ", call,
	 *         "Availability: ", available, "Total: ", total, "Title: ", title,
	 *         "Author: ", author, "Format: ", format);
	 */
	@Override
	public String toString() {
		return String.format(
				"%-16s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n\n",
				" ISBN: ", ISBN, "Call Number: ", call, "Availability: ", available, "Total: ", total, "Title: ", title,
				"Author: ", author, "Format: ", format);
	}

}
