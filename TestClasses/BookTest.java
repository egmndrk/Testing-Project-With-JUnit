package JunitHW;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BookTest {
	Book book1=new Book("12345", "SENG453");
	Patron patron1 = new Patron("Alice");

	@ParameterizedTest
	@ValueSource(strings= {"98765", "12389"})
	@DisplayName("Testing ISBN")
	@Tag("Books")
	void testgetIsbn(String strings) {
		assertFalse(strings.equals(book1.getIsbn()));
	}
	
	@Test
	@DisplayName("Testing Title")
	@Tag("Books")
	void testgetTitle() {
		assertEquals("SENG453", (book1.getTitle()));
	}
	@Test
	@DisplayName("Testing Borrower")
	@Tag("Books")
	void testgetBorrower() {
		book1.setBorrower(patron1);
		assertEquals("Alice", ((book1.getBorrower()).getName()));
	}

}
