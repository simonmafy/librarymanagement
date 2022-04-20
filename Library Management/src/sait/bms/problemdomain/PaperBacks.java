package sait.bms.problemdomain;

/**
 * The PaperBacks has all the assessor and mutators. It also has helps creates the objects while
 * the books.txt is being scanned into the arraylist. 
 * 
 * @author Simon Ma 562187
 * @version February 13/2020
 */

public class PaperBacks extends Book {
	
	String author;
	String year;
	String genre;

	public PaperBacks(){


		year = "";
		genre = "";
	}

	public PaperBacks(long getISBN, String getCall, int getAvailable, int getTotal, String getTitle, String getAuthor, String getYear, String getGenre) {

		ISBN = getISBN;
		call = getCall;
		available = getAvailable;
		total = getTotal;
		title = getTitle;
		year = getYear;
		genre = getGenre;
		author = getAuthor;
	}
	
/**
 * Uses the genre string value
 * @return the genre string value
 */
	public String getGenre() {
		return genre;
	}
	
	/**
	 * Uses the year string value
	 * @return year;
	 */
	public String getYear() {
		return year;
	}
	
	public String getAuthor() {
		return author;
	}
	
	
	/**
	 * Changes a specific format as the ArrayList is printed onto books.txt
	 * 
	 * @return format (ISBN + ";" + call + ";" + available + ";" + total + ";" + title + ";" + author + ";" + year + ";" + genre"\n")
	 */
	public String toPrintFormat() {
		return String.format(ISBN + ";" + call + ";" + available + ";" + total + ";" + title + ";" + author + ";" + year + ";" + genre + "\n");
	}
	
	/**
	 * Overrides the default toString and makes this new format the new toString
	 * 
	 * @return ("%-16s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n\n", 
	 * " ISBN: ", ISBN, 
	 * "Call Number: ", call, 
	 * "Availability: ", available, 
	 * "Total: ", total, 
	 * "Title: ", title, 
	 * "Author: ", author, 
	 * "Year: ", year
	 * "Genre: ", genre);
	 */
	@Override 
	public String toString() {
		return String.format("%-16s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n\n", 
				" ISBN: ", ISBN, 
				"Call Number: ", call, 
				"Availability: ", available, 
				"Total: ", total, 
				"Title: ", title, 
				"Author: ", author, 
				"Year: ", year,
				"Genre: ", genre);
	}

}
