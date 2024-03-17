package JunitHW;

public class Library {
    private Book[] books;
    private Patron[] patrons;
    private int bookCount;
    private int patronCount;
    private final int INITIAL_CAPACITY = 10;

    public Library() {
        this.books = new Book[INITIAL_CAPACITY];
        this.patrons = new Patron[INITIAL_CAPACITY];
        this.bookCount = 0;
        this.patronCount = 0;
    }

    public void addBook(Book book) {
    	if (bookCount == books.length) {
            increaseBookCapacity();
        }
         else
        	 books[bookCount++] = book;
         
     }
    private void increaseBookCapacity() {
        Book[] newBooks = new Book[books.length * 2];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        books = newBooks;
    }


    public void removeBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equals(book)) {
                removeBookAtIndex(i);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void removeBookAtIndex(int index) {
        System.arraycopy(books, index + 1, books, index, bookCount - index - 1);
        books[--bookCount] = null;
    }

    public void addPatron(Patron patron) {
    	if (patronCount == patrons.length) {
            increasePatronCapacity();
        }
         else
        	 patrons[patronCount++] = patron;
    }
    
    private void increasePatronCapacity() {
        Patron[] newPatrons = new Patron[patrons.length * 2];
        System.arraycopy(patrons, 0, newPatrons, 0, patrons.length);
        patrons = newPatrons;
    }

    

    public void removePatron(Patron patron) {
        for (int i = 0; i < patronCount; i++) {
            if (patrons[i].equals(patron)) {
                removePatronAtIndex(i);
                return;
            }
        }
        System.out.println("Patron not found.");
    }

    private void removePatronAtIndex(int index) {
        System.arraycopy(patrons, index + 1, patrons, index, patronCount - index - 1);
        patrons[--patronCount] = null;
    }

    public void lendBook(Book book, Patron patron) {
        if (containsBook(book) && containsPatron(patron)) {
            if (book.getBorrower() == null) {
                book.setBorrower(patron);
                patron.borrowBook(book);
                System.out.println("Book " + book.getTitle() + " lent to " + patron.getName());
            } else {
            	throw new IllegalArgumentException("Dude you cannot");
            	//System.out.println("Book or patron not found.");
            }
        } else {
            System.out.println("Book or patron not found.");
        }
    }

    boolean containsBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equals(book)) {
                return true;
            }
        }
        return false;
    }

     boolean containsPatron(Patron patron) {
        for (int i = 0; i < patronCount; i++) {
            if (patrons[i].equals(patron)) {
                return true;
            }
        }
        return false;
    }

    public void returnBook(Book book, Patron patron) {
        if (containsBook(book) && book.getBorrower() == patron) {
            patron.returnBook(book);
            book.setBorrower(null);
            System.out.println("Book " + book.getTitle() + " returned by " + patron.getName());
        } else {
        	throw new IllegalArgumentException("Dude you cannot");
           //System.out.println("Book not found or not borrowed.");
        }
    }

	public Book[] getBooks() {
		return books;
	}

	public Patron[] getPatrons() {
		return patrons;
	}

	public int getBookCount() {
		return bookCount;
	}

	public int getPatronCount() {
		return patronCount;
	}

	public int getINITIAL_CAPACITY() {
		return INITIAL_CAPACITY;
	}
    
}