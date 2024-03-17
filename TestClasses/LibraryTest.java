package JunitHW;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


class LibraryTest {
	Library library = new Library();
	Library library2 = new Library();
	Book book1 = new Book("123456", "Java Programming");
    Book book2 = new Book("789012", "Python Programming");
    Book book3=new Book("98765", "OS");

    Patron patron1 = new Patron("Alice");
    Patron patron2 = new Patron("Bob");

	@Test
	@Tag("Books")
	@DisplayName("Testing Adding Book to Library")
	void testaddBook() {
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.removeBook(book1);
		library2.addBook(book1);
		library2.addBook(book2);
		library2.addBook(book3);
		library2.removeBook(book1);
		
		assertArrayEquals(library.getBooks(), (library2.getBooks()));
	}
	
	@Test
	@Tag("Books")
	@DisplayName("Testing Removing Book From Library")
	void testremoveBook() {
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.removeBook(book1);
		library2.addBook(book1);
		library2.addBook(book2);
		library2.addBook(book3);
		library2.removeBook(book2);
		
		assertThat(library.getBooks(), not(equalTo((library2.getBooks()))));
	}
	
	@Test
	@DisplayName("Testing Adding Patron to Library")
	void testaddPatron() {
		library.addPatron(patron1);
		library.addPatron(patron2);
		library.removePatron(patron2);
		library2.addPatron(patron1);
		library2.addPatron(patron2);
		library2.removePatron(patron2);
		
		assertArrayEquals(library.getPatrons(), (library2.getPatrons()));
	}
	
	@Test
	@DisplayName("Testing Removing Patron From Library")
	void testremovePatron() {
		library.addPatron(patron1);
		library.addPatron(patron2);
		library.removePatron(patron2);
		library2.addPatron(patron1);
		library2.addPatron(patron2);
		library2.removePatron(patron1);
		
		assertThat(library.getPatrons(), not(equalTo((library2.getPatrons()))));
		
	}
	
	@Test
	@Tag("Books")
	@DisplayName("Testing Numbers of Books")
	void testNumbersOfBooks() {
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.removeBook(book1);

		
		
		assertEquals(2, library.getBookCount());
		
	}
	
	@Test
	@DisplayName("Testing Numbers of Patrons")
	void testNumbersOfPatrons() {

		library.addPatron(patron1);
		library.addPatron(patron2);
		library.removePatron(patron1);

		
		
		assertEquals(1,library.getPatronCount());
		
	}
	
	@Test
	@Tag("Books")
	@DisplayName("Testing If Contains Book Methods")
	void testContainingBooks() {
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.removeBook(book1);

		assertFalse(library.containsBook(book1));
		assertTrue(library.containsBook(book3));
		
	}
	
	@Test
	@DisplayName("Testing If Contains Patron Methods")
	void testContainingPatrons() {

		library.addPatron(patron1);
		library.addPatron(patron2);
		library.removePatron(patron1);
		
		assertTrue(library.containsPatron(patron2));
		assertFalse(library.containsPatron(patron1));
		
	}
	
	@Test
	@DisplayName("Testing Lending Book to Patrons")
	void testLending() {
		library.addBook(book1);
		library.addPatron(patron1);
		library.addPatron(patron2);
		library.lendBook(book1, patron1);
		assertThat(patron1, equalTo(book1.getBorrower()));
		assertThrows(IllegalArgumentException.class, () -> {library.lendBook(book1, patron2);});
		
	}
	
	@Test
	@DisplayName("Testing Returning Book to Library")
	void testReturning() {
		library.addBook(book1);
		library.addPatron(patron1);
		library.addPatron(patron2);
		library.lendBook(book1, patron1);
		library.returnBook(book1, patron1);
		assertThat(null, equalTo(book1.getBorrower()));
		
		library.lendBook(book1, patron1);
		
		assertThrows(IllegalArgumentException.class, () -> {library.returnBook(book1, patron2);});
		
	}
	

}
