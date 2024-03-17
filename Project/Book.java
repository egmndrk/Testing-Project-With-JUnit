package JunitHW;

class Book {
    private String isbn;
    private String title;
    private Patron borrower;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Patron getBorrower() {
        return borrower;
    }

    public void setBorrower(Patron borrower) {
        this.borrower = borrower;
    }
}