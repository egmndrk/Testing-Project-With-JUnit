package JunitHW;

class Patron {
    private String name;
    private Book[] borrowedBooks;
    private int borrowedCount;
    private final int INITIAL_CAPACITY = 5;

    public Patron(String name) {
        this.name = name;
        this.borrowedBooks = new Book[INITIAL_CAPACITY];
        this.borrowedCount = 0;
    }

    public String getName() {
        return name;
    }

    public Book[] getBorrowedBooks() {
		return borrowedBooks;
	}

	public void borrowBook(Book book) {
		if (borrowedCount == borrowedBooks.length) {
            increaseBorrowedCapacity();
        }
        else
        	borrowedBooks[borrowedCount++] = book;
        
    }
	
	 private void increaseBorrowedCapacity() {
	        Book[] newBorrowedBooks = new Book[borrowedBooks.length * 2];
	        System.arraycopy(borrowedBooks, 0, newBorrowedBooks, 0, borrowedBooks.length);
	        borrowedBooks = newBorrowedBooks;
	    }

    

    public void returnBook(Book book) {
    	
        for (int i = 0; i <= borrowedCount; i++) {
        	if(i==borrowedCount) {
        		System.out.println("You do not have this book");
        		return;
        	}
        		
        	
            if (borrowedBooks[i].equals(book)) {
                removeReturnedBookAtIndex(i);
                return;
            }
           
        }
    }

    private void removeReturnedBookAtIndex(int index) {
        System.arraycopy(borrowedBooks, index + 1, borrowedBooks, index, borrowedCount - index - 1);
        borrowedBooks[--borrowedCount] = null;
    }

	public int getBorrowedCount() {
		return borrowedCount;
	}

	public int getINITIAL_CAPACITY() {
		return INITIAL_CAPACITY;
	}
    
}