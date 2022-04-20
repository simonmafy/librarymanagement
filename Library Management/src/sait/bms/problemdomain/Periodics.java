package sait.bms.problemdomain;

/**
 * The Periodics has all the assessor and mutators. It also has helps creates
 * the objects while the books.txt is being scanned into the arraylist.
 * 
 * @author Simon Ma 562187
 * @version February 13/2020
 */

public class Periodics extends Book {

	String frequency;

	public Periodics() {
		frequency = "";
	}

	public Periodics(long getISBN, String getCall, int getAvailable, int getTotal, String getTitle,
			String getFrequency) {

		ISBN = getISBN;
		call = getCall;
		available = getAvailable;
		total = getTotal;
		title = getTitle;
		frequency = getFrequency;

	}

	/**
	 * Changes a specific format as the ArrayList is printed onto books.txt
	 * 
	 * @return format (ISBN + ";" + call + ";" + available + ";" + total + ";" +
	 *         title + ";" + frequency + "\n")
	 */
	public String toPrintFormat() {
		return String.format(ISBN + ";" + call + ";" + available + ";" + total + ";" + title + ";" + frequency + "\n");
	}

	/**
	 * Overrides the default toString and makes this new format the new toString
	 * 
	 * @return ("%-16s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n
	 *         %-15s%-20s\n %-15s%-20s\n\n", " ISBN: ", ISBN, "Call Number: ", call,
	 *         "Availability: ", available, "Total: ", total, "Title: ", title,
	 *         "Frequency: ", frequency);
	 */
	@Override
	public String toString() {
		return String.format("%-16s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n %-15s%-20s\n\n",
				" ISBN: ", ISBN, "Call Number: ", call, "Availability: ", available, "Total: ", total, "Title: ", title,
				"Frequency: ", frequency);
	}

	public String getFrequency() {
		return frequency;
	}

}
