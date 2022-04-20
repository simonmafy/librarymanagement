package sait.bms.application;
import sait.bms.managers.*;
import sait.bms.problemdomain.*;
import java.util.*;
import java.io.*;

/**
 * AppMain - This is the main class that calls the Arraylist from the loadLibrary method from the Library Management Class. 
 * The main class has a switch case that loads all methods that the user chooses. These options are checkout, find book by title, find books by type, 
 * produce random book and save & exit.  
 * 
 * @author Simon Ma 562187
 * @version January 23/2020
 */


public class AppMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		ArrayList<Book> libraryList = new ArrayList<>();

		/**
		 * Activates the method that loads the books.txt into the ArrayList
		 */
		LibraryManagements.loadLibrary(libraryList);
		
		//LibraryManagements objx = null;
		
		//objx.test(libraryList);
		


		/**
		 * Switch case statement used to as a menu for people to pick from options 1 to 5. 
		 * Case 1: checks out a book from the books.txt list 
		 * Case 2: finds all the book titles that the user inputs 
		 * Case 3: finds all the books by there type from the user input
		 * through an input. 
		 * Case 4: shows random number of books base the the number the user inputs. 
		 * Case 5: Saves to the books.txt and exits
		 * Default: This is when the user give an invalid input for a choice, a message would pop up
		 * that says invalid option. 
		 */
		int x = 0;
		while (x != 5) {


			try {
				switch(LibraryManagements.displayMenu(input)){
				case 1: 
					LibraryManagements.checkOut(libraryList);
					break;
				case 2:
					LibraryManagements.findBooksByTitle(libraryList);
					break;
				case 3:
					LibraryManagements.booksByType(libraryList);
					break;
				case 4:
					LibraryManagements.produceRandomBook(libraryList);
					break;
				case 5:
					LibraryManagements.saveExit(libraryList);
					x = 5;
					break;
				default: 
					System.out.println();
					System.out.println("Invalid option");
					System.out.println();
					System.out.print("Please press enter to continue");
					input.nextLine();
					input.nextLine();
				}


			}catch(Exception e) {

				System.out.println();
				System.out.println("Invalid input. Please press enter to continue.");
				input.nextLine();
				input.nextLine();

			}

		}

	}

}

