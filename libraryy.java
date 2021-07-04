
import java.util.Scanner;

import java.util.Arrays;
import java.util.HashMap;

public class libraryy {

	public static void main(String[] args) {
		System.out.println("enter the size of the booklist and member list");

		Scanner input = new Scanner(System.in);
		int press = 0;
		libraryy book = new libraryy();
		System.out.println("Welcom Mr Admin");
		System.out.println("which one of the following opration would you like to do");
		do {
			book b = new book();
			intro();
			press = input.nextInt();
			if (press == 1)
				book.addbook();
			else if (press == 2)
				book.addmember();
			else if (press == 3)
				book.checkOut();
			else if (press == 4)
				book.returnbook();
			else if (press == 5)
				book.searchbooks();
			else if (press == 6)
				book.toshowallbooks();
			else if (press == 7)
				book.removebook();
			else if (press == 8)
				book.avilable();
			else if (press == 9)
				book.checkmember();
			else if (press == 10)
				book.removemember();
			else if (press == 11)
				book.toshowallmembers();
			else if (press == 12)
				book.showborrowedbook();

		} while (press != -1);

	}

	public static void intro() {
		System.out.println(" press 1 to add book ");
		System.out.println(" press 2 to add member ");
		System.out.println(" press 3 to borrow book");
		System.out.println(" press 4 to return book");
		System.out.println(" press 5 to search for book");
		System.out.println(" press 6 to show all books");
		System.out.println(" press 7 to remove book");
		System.out.println(" press 8 to check book");
		System.out.println(" press 9 to check member");
		System.out.println(" press 10 to remove member");
		System.out.println(" press 11 to show all members");
		System.out.println(" press 12 to show all borrowed books");
		System.out.println(" press -1 to exit");
	}

	int Mindex = 0;
	int numbook = 0;
	int Bindex = 0;
	int nummember = 0;
	int bsize = 0;
	int msize = 0;
	int i = 0;
	Scanner input = new Scanner(System.in);
	book[] booklist = new book[bsize = input.nextInt()];
	members[] member = new members[msize = input.nextInt()];

	public void addbook() {

		System.out.println("please enter number of book that you need to add");
		numbook = input.nextInt();
		for (int j = 0; j < numbook; j++) {
			book b = new book();
			if (booklist[j] == null) {
				if (Bindex == numbook) {
					System.out.println("the library reach its maximum capacity");
					break;
				}
				System.out.println("the title of the book");
				String title = input.next();
				b.Booktitle(title);
				System.out.println(" the name of author");
				String author = input.next();
				b.Bookauthor(author);
				System.out.println(" the date of publishing");
				String date = input.next();
				b.Dateofpublishing(date);
				System.out.println(" quantites of book");
				int quantity = input.nextInt();
				b.Quantity(quantity);
				booklist[Bindex] = b;
				Bindex++;
				System.out.println(" the addition of the book no" + (j + 1) + "  is done");
				System.out.println("title : " + booklist[j].booktitle + "\nauthor :" + booklist[j].bookauthor
						+ "\n date of publishing :  " + booklist[j].dateofpublishing + "\nquantity  :  "
						+ booklist[j].quantity);
			}
		}
	}

	public void addmember() {

		System.out.println("please enter number of members that you need to add");
		nummember = input.nextInt();
		for (int j = 0; j < nummember; j++) {
			members m = new members();
			if (member[j] == null) {
				System.out.println("please enter the name of member");
				String name = input.next();
				m.Name(name);
				member[Mindex] = m;
				System.out.println(" the additionis of the member  is done");
				Mindex++;
				System.out.println("\nname of member:" + member[j].name);
			}
		}
	}

	public void avilable() {
		System.out.println("enter the book name");
		String title = input.next();
		for (int j = 0; j < Bindex; j++) {

			if (title.equals(booklist[j].booktitle)) {
				if (booklist[j].quantity > 0) {

					System.out.println("Book is Available.");
					break;
				}
			}
		}
		System.out.println("Book is Unavailable");
	}

	public void checkOut() {

		int m;

		System.out.println("Enter your name");
		String name = input.next();
		for (int b = 0; b < Mindex; b++) {
			if (name.equals(member[b].name)) {
				System.out.println("Enter title of Book to be Checked Out.");
				String title = input.next();
				System.out.println("the duration you need to take this book");
				int duration = input.nextInt();
				for (m = 0; m < Bindex; m++) {
					if (duration < 14) {
						if (title.equals(booklist[m].booktitle)) {
							book c = booklist[m];
							booklist[m].Quantity(booklist[m].getQuantity() - 1);
							System.out.println(c);
							if (c != null && member[b].borrowedBooks[member[b].booksCount] == null) {
								member[b].borrowedBooks[member[b].booksCount] = c;
								member[b].booksCount++;
							}
						}

					} else
						System.out.println("this duration is not allawed, you must return only in 14 days");
				}
			}
		}
	}

	public void showborrowedbook() {
		String name;
		System.out.println("Enter the name of member");
		name = input.next();
		for (int h = 0; h < Mindex; h++) {

			if (name.equals(member[h].name)) {
				for (int t = 0; t < member[h].booksCount; t++) {
					System.out.println(member[h].borrowedBooks[t]);
				}
				break;
			}
		}
	}

	public void checkmember() {
		String name;
		System.out.println("Enter the name of member");
		name = input.next();

		for (int h = 0; h < Mindex; h++) {

			if (name.equals(member[h].name)) {

				System.out.println("member is Available.");
				break;
			}
			System.out.println("member is Unavailable");
		}
	}

	public void returnbook() {
		System.out.println("Enter your name");
		String name = input.next();
		for (int b = 0; b < Mindex; b++) {
			if (name.equals(member[b].name)) {
				System.out.println("Enter title of Book to be returned.");
				String title = input.next();
				for (int m = 0; m < Bindex; m++) {
					if (title.equals(booklist[m].booktitle)) {
						if (booklist[m].quantity > 0) {

							booklist[m].Quantity(booklist[m].getQuantity() + 1);
							System.out.println("title : " + booklist[m].booktitle + "\nauthor :"
									+ booklist[m].bookauthor + "\n date of publishing :  "
									+ booklist[m].dateofpublishing + "\nquantity  :  " + booklist[m].quantity);
							System.out.println("\nname of member: " + member[b].name);
							for (int x = 0; x < member[b].booksCount; x++)
								if (booklist[m].equals(member[b].borrowedBooks[x]))
									member[b].borrowedBooks[x] = null;
							break;

						} else {
							System.out.println("this book is out of stock");
						}
					}
				}
			}
		}
	}

	public void searchbooks() {
		System.out.println("what would you want to search ?");
		System.out.println("press 1 if you want to search by book title");
		System.out.println("press 2 if you want to search by book author");
		System.out.println("press 3 if you want to search by date of publishing");
		int press = 0;
		press = input.nextInt();
		if (press == 1) {
			System.out.println("enter the book name");
			String title = input.next();
			int m;
			for (m = 0; m < Bindex; m++) {
				if (title.equals(booklist[m].booktitle)) {
					System.out.println("These are the books we have:");
					System.out.print(booklist[m]);
					break;

				}
			}
			System.out.println("this book is not avilable");

		}

		else if (press == 2) {
			System.out.println("Enter Author Name:");
			String authorName = input.next();
			for (int m = 0; m < Bindex; m++) {

				if (authorName.equals(booklist[m].bookauthor)) {
					System.out.println("title : " + booklist[m].booktitle + "\nauthor :" + booklist[m].bookauthor
							+ "\n date of publishing :  " + booklist[m].dateofpublishing + "\nquantity : "
							+ booklist[m].quantity);
					break;
				} else
					System.out.println("No Books of " + authorName + " Found.");
				break;
			}

		} else if (press == 3) {
			System.out.println("Enterthe date of publishing:");
			String date = input.next();
			for (int m = 0; m < Bindex; m++) {

				if (date.equals(booklist[m].dateofpublishing)) {
					System.out.println("title : " + booklist[m].booktitle + "\nauthor :" + booklist[m].bookauthor
							+ "\n date of publishing :  " + booklist[m].dateofpublishing + "\nquantity : "
							+ booklist[m].quantity);
					break;
				} else
					System.out.println("No Books of   " + date + " Found.");
				break;
			}
		}
	}

	public void toshowallbooks() {
		for (int j = 0; j < Bindex; j++) {
			System.out.println("title : " + booklist[j].booktitle + "\nauthor :" + booklist[j].bookauthor
					+ "\n date of publishing :  " + booklist[j].dateofpublishing + "\nquantity : "
					+ booklist[j].quantity);
		}
	}

	public void removebook() {
		System.out.println("enter the title of book that you want to remove");
		String title = input.next();
		for (int k = 0; k < Bindex; k++)
			if (title.equals(booklist[k].booktitle)) {
				booklist[k].Quantity(booklist[k].getQuantity() - 1);
				System.out.println(booklist[k]);
			}
	}

	public void removemember() {
		System.out.println("enter the name of member  that you want to remove");
		String name = input.next();
		for (int b = 0; b < Mindex; b++) {
			if (name.equals(member[b].name)) {
				member[b] = null;
			}
		}
	}

	public void toshowallmembers() {
		for (int j = 0; j < Mindex; j++) {
			if (member[j] == null) {
				continue;
			} else {
				System.out.println("name : " + member[j].name);
			}
		}
	}
}
