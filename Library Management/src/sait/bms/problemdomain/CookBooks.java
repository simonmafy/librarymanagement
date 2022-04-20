package sait.bms.problemdomain;

/**
 * The CookBooks class has all the assessor and mutators. It also has helps
 * creates the objects while the books.txt is being scanned into the arraylist.
 * 
 * @author Simon Ma 562187
 * @version February 13/2020
 */

public class CookBooks extends Book {

	String publisher;
	String diet;

	public CookBooks() {

		publisher = "";
		diet = "";

	}

	public CookBooks(long getISBN, String getCall, int getAvailable, int getTotal, String getTitle, String getPublisher,
			String getDiet) {

		ISBN = getISBN;
		call = getCall;
		available = getAvailable;
		total = getTotal;
		title = getTitle;
		publisher = getPublisher;
		diet = getDiet;

	}

	/**
	 * Uses diet string value
	 * 
	 * @return diet string value
	 */
	public String getDiet() {
		return diet;
	}

	/**
	 * Uses the publisher value
	 * 
	 * @return publisher value
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Changes a specific format as the ArrayList is printed onto books.txt
	 * 
	 * @return format (ISBN + ";" + call + ";" + available + ";" + total + ";" +
	 *         title + ";" + publisher + ";" + diet + "\n")
	 */
	public String toPrintFormat() {
		return String.format(
				ISBN + ";" + call + ";" + available + ";" + total + ";" + title + ";" + publisher + ";" + diet + "\n");
	}

	/**
	 * Overrides the default toString and makes this new format the new toString
	 * 
	 * @return ("%-16s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n
	 *         %-15s%-20s\n %-15s%-20s\n\n", " ISBN: ", ISBN, "Call Number: ", call,
	 *         "Availability: ", available, "Total: ", total, "Title: ", title,
	 *         "Publisher: ", author, "Diet: ", format);
	 */
	@Override
	public String toString() {
		return String.format(
				"%-16s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n\n",
				" ISBN: ", ISBN, "Call Number: ", call, "Availability: ", available, "Total: ", total, "Title: ", title,
				"Publisher: ", publisher, "Diet: ", diet);
	}

}
