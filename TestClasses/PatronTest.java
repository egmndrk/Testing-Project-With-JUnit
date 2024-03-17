package JunitHW;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PatronTest {
	 Patron patron1 = new Patron("Bob");
	 Patron patron2 = new Patron("Ege");
	 Book book1=new Book("12345", "SENG453");
	 Book book2=new Book("54321", "SENG442");
	 Book book3=new Book("98765", "OS382");

	@ParameterizedTest
	@ValueSource(strings= {"Irem","Ege"})
	@DisplayName("Testing Patron Name")
	void testGetName(String source) {
		assertFalse(source.equalsIgnoreCase(patron1.getName()));
	}
	
	@Test
	@DisplayName("Testing Borrowed Book List")
	void testBorrowedBookList() {
		patron1.borrowBook(book1);
		patron1.borrowBook(book2);
		patron1.borrowBook(book3);
		patron1.returnBook(book3);
		patron2.borrowBook(book1);
		patron2.borrowBook(book2);
		patron2.borrowBook(book3);
		patron2.returnBook(book3);
		
		assertArrayEquals(patron2.getBorrowedBooks(), (patron1.getBorrowedBooks()));
		
	}
	@Test
	@DisplayName("Testing Book List After Return")
	void testBorrowedBook2() {
		patron1.borrowBook(book1);
		patron1.borrowBook(book2);
		patron1.borrowBook(book3);
		patron1.returnBook(book3);
		patron2.borrowBook(book1);
		patron2.borrowBook(book2);
		patron2.borrowBook(book3);
		patron2.returnBook(book1);
		
		
		
		assertThat(patron2.getBorrowedBooks(), not(equalTo(patron1.getBorrowedBooks())));
		
	}@Test
	@DisplayName("Testing the Number of Books Patron Has")
	void testborrowedCount() {
		patron1.borrowBook(book1);
		patron1.borrowBook(book2);
		patron1.borrowBook(book3);
		patron1.returnBook(book3);
		
		
		
		assertEquals(2, (patron1.getBorrowedCount()));
		
	}
	

}
