
public class book {
	public String booktitle;
	public String bookauthor;
	public String dateofpublishing;
	public int quantity;

	public String getBooktitle() {
		return booktitle;
	}

	public void Booktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void Bookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getDateofpublishing() {
		return dateofpublishing;
	}

	public void Dateofpublishing(String dateofpublishing) {
		this.dateofpublishing = dateofpublishing;
	}

	public int getQuantity() {
		return quantity;
	}

	public void Quantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return "\ntitle:" + booktitle + "\nthe author:" + bookauthor + "\nthe date of publishing:" + dateofpublishing
				+ "\nthe quantity:" + quantity;

	}


	

}
