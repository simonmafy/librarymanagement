package sait.bms.managers;

import sait.bms.problemdomain.*;
import sait.bms.application.*;
import java.util.*;
import java.io.*;

/**
 * The LibraryManagement class has multiple methods that is the backbone to this
 * program. It also loads the books.txt into the arraylist. The displayMenu
 * method displays the menu on the terminal. The checkout method checks out a
 * book from the books.txt list The findBooksByTitle method finds all the book
 * titles that the user inputs The booksByType method finds all the books by
 * there type from the user input The produceRandomBook method shows random
 * number of books base the the number the user inputs. The saveExit method
 * saves the new arraylist into the books.txt if the user checked out a book.
 * 
 * @author Simon Ma 562187
 * @version February 13/2020
 */

public class LibraryManagements {

	static String fileName = "./res/books.txt";

	/**
	 * Use this to test if books.txt is being scanned properly. It prints to the
	 * screen if successful. Only use it for testing and debugging purpose.
	 * 
	 * @param libraryList
	 * @throws IOException
	 */
	public static void test(ArrayList<Book> libraryList) throws IOException {

		for (int i = 0; i < libraryList.size(); i++) {

			System.out.print(libraryList.get(i).toPrintFormat());

		}

	}

	/**
	 * The displayMenu method displays the menu on the terminal.
	 * 
	 * @param Scanner input
	 * @return the user input
	 */
	static public int displayMenu(Scanner input) {
		System.out.println();
		System.out.println("Welcome to ABC Book Company. How May We Assist You?");
		System.out.printf("%-5s %-13s \n", "1", "Checkout Book");
		System.out.printf("%-5s %-13s \n", "2", "Find Books by Title");
		System.out.printf("%-5s %-13s \n", "3", "Display Books by Type");
		System.out.printf("%-5s %-13s \n", "4", "Produce Random Book List");
		System.out.printf("%-5s %-13s \n", "5", "Save & Exit");
		System.out.print("\n");
		System.out.print("Enter option: ");
		int answer = input.nextInt();
		return answer;
	}

	/**
	 * The saveExit method saves the new arraylist into the books.txt if the user
	 * checked out a book.
	 * 
	 * @param bookList
	 * @throws IOException
	 */
	public static void saveExit(ArrayList<Book> bookList) throws IOException {
		Scanner input = new Scanner(System.in);

		System.out.println();
		System.out.println("Goodbye =)");
		System.out.println();

		// String fileName = "./res/books.txt";
		FileWriter libraryFile = new FileWriter(fileName, false);
		PrintWriter printFile = new PrintWriter(libraryFile);
		for (int i = 0; i < bookList.size(); i++) {

			printFile.print(bookList.get(i).toPrintFormat());

		}

		printFile.close();

	}

	/**
	 * The checkout method checks out a book from the Book.txt list.
	 * 
	 * @param bookList
	 */
	public static void checkOut(ArrayList<Book> bookList) {
		Scanner input = new Scanner(System.in);

		Boolean pass1 = false;
		while (pass1 != true) {
			// Error check with try catch. If the input causes an error, it catches it.
			try {

				System.out.print("Enter ISBN of book: ");
				long bookISBN = input.nextLong();

				Boolean exist = false;

				// for loop to iterate through the list and compare if input ISBN exists. If
				// exists, get available if greater than 0.
				for (int i = 0; i < bookList.size(); i++) {
					if (bookList.get(i).getISBN() == bookISBN && bookList.get(i).getAvailable() > 0) {

						System.out.println();
						System.out.println(
								"The book " + '"' + bookList.get(i).getTitle() + '"' + " has been checked out.");
						System.out.println("It can be located using a call number: " + bookList.get(i).getCall());

						bookList.get(i).setAvailable(bookList.get(i).getAvailable() - 1);

						exist = true;

					}

					// if ISBN has an availability of 0, it will tell the user the book does not
					// exist.
					if (bookList.get(i).getISBN() == bookISBN && bookList.get(i).getAvailable() == 0) {

						System.out.println();
						System.out.println("The item is not available at the moment. Please check back again later.");

						exist = true;

					}

				}

				// If the user input does not match any of the ISBN, gives message.
				if (exist == false) {

					System.out.println();
					System.out.println("This ISBN does not exist.");
				}

				// Prompts the user to press enter to continue.
				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				pass1 = true;

			} catch (Exception e) {

				System.out.println();
				System.out.println("Invalid input, please try again. \n");
				input.next();
			}
		}
	}

	/**
	 * The produceRandomBook method shows random number of books base the the number
	 * the user inputs.
	 * 
	 * @param libraryList
	 */
	public static void produceRandomBook(ArrayList<Book> libraryList) {
		Scanner input = new Scanner(System.in);

		Boolean pass4 = false;

		// while loop just in case the user gets an error, it repeats the process for
		// the user to enter an input again.
		while (pass4 != true) {

			// Error catch. If the user input creates an error, it will catch it and print
			// out invalid input.
			try {
				Random randomNumber = new Random();

				// Prompts the user to enter the number of books.
				System.out.print("Enter Number of Books: ");
				int numberBooks = input.nextInt();

				for (int i = 0; i < numberBooks; i++) {

					int randomX = randomNumber.nextInt(libraryList.size());
					System.out.print(libraryList.get(randomX).toString());

				}

				// Press enter to continue.
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				pass4 = true;

			} catch (Exception e) {

				System.out.println();
				System.out.println("Invalid input. Please try again.");
				System.out.println();
				input.next();
			}
		}
	}

	/**
	 * The findBooksByTitle method finds all the book titles that the user inputs
	 * 
	 * @param libraryList
	 */
	public static void findBooksByTitle(ArrayList<Book> bookList) {
		Scanner input = new Scanner(System.in);

		Boolean exist2 = false;
		Boolean pass2 = false;

		// while loop just incase the user enters an error. It repeats the process for
		// the user to input again.
		while (pass2 != true) {

			// Catches the error, and prints out a message alerting the user invalid input.
			try {

				System.out.print("Enter a title to search for: ");
				String searchTitle = input.nextLine();
				String convert = searchTitle.toLowerCase();
				System.out.println();

				// Iterates through the book list. If the list contains the input, convert it to
				// lower case. This makes it case insensitive.
				for (int i = 0; i < bookList.size(); i++) {
					if (bookList.get(i).getTitle().toLowerCase().contains(convert)) {

						System.out.print(bookList.get(i).toString());

						exist2 = true;

					}

				}

				// If the user input does not match anything, the boolean turns false and it
				// will print out that the title does not exist.
				if (exist2 == false) {

					System.out.println("This title does not exist.");
					System.out.println();
				}

				System.out.print("Please press enter to continue");

				input.nextLine();

				pass2 = true;

			} catch (Exception e) {

				System.out.println("Invalid input. Please try again.");
				System.out.println();
				input.next();
			}
		}
	}

	/**
	 * The booksByType method finds all the books by there type from the user input.
	 * 
	 * @param libraryList
	 */
	public static void booksByType(ArrayList<Book> libraryList) {

		Scanner input = new Scanner(System.in);

		int typeChoice = 0;

		Boolean pass3 = false;

		// While loop incase the user inputs an error. It will come back to the menu.
		while (pass3 != true) {

			// Catches the error in case the user does a wrong input. Prints a message
			// saying invalid input.
			try {
				System.out.println();
				System.out.println("#type");
				System.out.println();
				System.out.printf("%-5s %-13s \n", "1", "Children's Books");
				System.out.printf("%-5s %-13s \n", "2", "Cook Books");
				System.out.printf("%-5s %-13s \n", "3", "Paperbacks");
				System.out.printf("%-5s %-13s \n", "4", "Periodicals");
				System.out.println();
				System.out.println();
				System.out.print("Enter Choice: ");
				typeChoice = input.nextInt();

				pass3 = true;

			} catch (Exception e) {

				System.out.println();
				System.out.print("Invalid input. Please try again.");
				System.out.println();
				input.next();
				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();
			}
		}

		// Prints out choices for children's books if the user picks option 1.
		if (typeChoice == 1) {

			System.out.print("Enter a format (P for Picture book, E for Early Readers, or C for Chapter book): ");
			String typeBooks = input.next();
			System.out.println();
			String conversionType = typeBooks.toLowerCase();

			switch (conversionType) {

			case "p":

				for (int i = 0; i < libraryList.size(); i++) {

					// Downcast to get ChildrenBooks information.
					try {
						if (((ChildrenBooks) (libraryList.get(i))).getFormat().contains("P")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "e":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((ChildrenBooks) (libraryList.get(i))).getFormat().contains("E")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}

				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "c":

				for (int i = 0; i < libraryList.size(); i++) {

					try {
						if (((ChildrenBooks) (libraryList.get(i))).getFormat().contains("C")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;
			}
		}

		// Prints out choices for cook books in case the user chooses option 2
		if (typeChoice == 2) {

			System.out.print(
					"Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None: ");
			String typeBooks = input.next();
			System.out.println();
			String conversionType = typeBooks.toLowerCase();

			switch (conversionType) {

			case "d":

				for (int i = 0; i < libraryList.size(); i++) {
					try {

						// Downcast to access CookBooks
						if (((CookBooks) (libraryList.get(i))).getDiet().contains("D")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "v":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((CookBooks) (libraryList.get(i))).getDiet().contains("V")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "g":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((CookBooks) (libraryList.get(i))).getDiet().contains("G")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "i":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((CookBooks) (libraryList.get(i))).getDiet().contains("I")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "n":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((CookBooks) (libraryList.get(i))).getDiet().contains("N")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;
			}
		}

		// Prints out choices for paper backs if option 3 is chosen.
		if (typeChoice == 3) {

			System.out.print(
					"Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
			String typeBooks = input.next();
			System.out.println();
			String conversionType = typeBooks.toLowerCase();

			switch (conversionType) {

			case "a":

				for (int i = 0; i < libraryList.size(); i++) {

					// Downcast to access PaperBacks.
					try {
						if (((PaperBacks) (libraryList.get(i))).getGenre().contains("A")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "d":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((PaperBacks) (libraryList.get(i))).getGenre().contains("D")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "e":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((PaperBacks) (libraryList.get(i))).getGenre().contains("E")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "c":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((PaperBacks) (libraryList.get(i))).getGenre().contains("C")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "f":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((PaperBacks) (libraryList.get(i))).getGenre().contains("F")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}

				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "s":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((PaperBacks) (libraryList.get(i))).getGenre().contains("S")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}

				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;
			}
		}

		// Prints out periodics if option 4 is chosen.
		if (typeChoice == 4) {

			System.out.print(
					"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
			String typeBooks = input.next();
			System.out.println();
			String conversionType = typeBooks.toLowerCase();

			switch (conversionType) {

			case "d":

				for (int i = 0; i < libraryList.size(); i++) {

					// Downcast to access periodics.
					try {
						if (((Periodics) (libraryList.get(i))).getFrequency().contains("D")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "w":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((Periodics) (libraryList.get(i))).getFrequency().contains("W")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "m":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((Periodics) (libraryList.get(i))).getFrequency().contains("M")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "b":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((Periodics) (libraryList.get(i))).getFrequency().contains("B")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;

			case "q":

				for (int i = 0; i < libraryList.size(); i++) {
					try {
						if (((Periodics) (libraryList.get(i))).getFrequency().contains("Q")) {

							System.out.print(libraryList.get(i).toString());
						}

					} catch (Exception e) {

					}
				}

				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				break;
			}
		}
	}

	/**
	 * This method loads the books.txt into the library arraylist.
	 * 
	 * @param libraryList
	 * @throws IOException
	 */
	public static void loadLibrary(ArrayList<Book> libraryList) throws IOException {

		// String fileName = "./res/books.txt";
		Scanner input = new Scanner(new FileInputStream(fileName), "UTF-8");

		String books = "";

		while (input.hasNextLine()) {

			books = input.nextLine() + "\n";
			String[] bookArray = books.split(";|\\n|\\r");
			String ISBN = bookArray[0];
			String getCall = bookArray[1];
			String Available = bookArray[2];
			int getAvailable = Integer.parseInt(Available);
			String total = bookArray[3];
			int getTotal = Integer.parseInt(total);
			String getTitle = bookArray[4];
			String getAuthor = "";
			String getFormat = "";
			String getPublisher = "";
			String getDiet = "";
			String getYear = "";
			String getGenre = "";
			String getFrequency = "";

			// Modulus 10 to get the very last number of the ISBN.
			long modISBN = Long.parseLong(ISBN) % 10;
			long getISBN = Long.parseLong(ISBN);

			if (modISBN == 0 || modISBN == 1) {

				getAuthor = bookArray[5];
				getFormat = bookArray[6];
				libraryList.add(
						new ChildrenBooks(getISBN, getCall, getAvailable, getTotal, getTitle, getAuthor, getFormat));
				// Arrays.fill(bookArray, null);

			}

			if (modISBN == 2 || modISBN == 3) {

				getPublisher = bookArray[5];
				getDiet = bookArray[6];
				libraryList
						.add(new CookBooks(getISBN, getCall, getAvailable, getTotal, getTitle, getPublisher, getDiet));
				// Arrays.fill(bookArray, null);
			}

			if (modISBN >= 4 && modISBN <= 7) {

				getAuthor = bookArray[5];
				getYear = bookArray[6];
				getGenre = bookArray[7];
				libraryList.add(new PaperBacks(getISBN, getCall, getAvailable, getTotal, getTitle, getAuthor, getYear,
						getGenre));
				// Arrays.fill(bookArray, null);
			}

			if (modISBN == 8 || modISBN == 9) {

				getFrequency = bookArray[5];
				libraryList.add(new Periodics(getISBN, getCall, getAvailable, getTotal, getTitle, getFrequency));
				// Arrays.fill(bookArray, null);
			}
		}
	}
}
