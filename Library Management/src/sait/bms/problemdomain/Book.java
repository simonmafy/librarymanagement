package sait.bms.problemdomain;

/**
 * The Book class has all the assessor and mutators. It also has helps creates
 * the objects while the books.txt is being scanned into the arraylist.
 * 
 * @author Simon Ma 562187
 * @version February 13/2020
 */
public abstract class Book {

	long ISBN;
	String call;
	int available;
	int total;
	String publisher;
	String title;

	public abstract String toPrintFormat();

	public Book() {

		ISBN = 0;
		call = "";
		available = 0;
		total = 0;
		call = "";
		title = "";

	}

	public long getISBN() {
		return ISBN;
	}

	public String getCall() {
		return call;
	}

	public String getTitle() {
		return title;
	}

	public void setAvailable(int setAvailable) {
		available = setAvailable;
	}

	public int getAvailable() {
		return available;
	}

	public int getTotal() {
		return total;
	}

}
