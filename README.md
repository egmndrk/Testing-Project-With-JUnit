# Testing Project With JUnit
 The project's JUnit test suite covers various aspects of functionality and ensures the correct behavior of methods in different scenarios.
 
 PROJECT OVERVİEW
The project consists of classes related to a library management system. Key classes include Book, Patron, and Library. The functionality allows for adding, removing, lending, and returning books, as well as managing patrons and their borrowed books.

BOOKTEST CLASS
•	testgetIsbn: confirms whether the returned ISBN matches the anticipated value using the getIsbn function of the Book class.
•	testgetTitle: Verifies that the getTitle method gives the accurate book title.
•	testgetBorrower: Tests the getBorrower method to confirm that it returns the correct borrower for a book.

LIBRARYTEST CLASS
•	testgetBorrower: Verifies that the getBorrower function returns the right borrower for a book by testing it.
•	testremoveBook: Verifies that the removeBook method is being used to remove books from the library correctly.
•	testaddPatron: This function evaluates the addPatron and removePatron methods for adding and removing library users.
•	testremovePatron: Confirms that library users have been removed while keeping the accurate number of patrons.
•	testNumbersOfBooks: Determines whether the library's count of books after additions and deletions is accurate.
•	testNumbersOfPatrons: Verifies the number of patrons in the library following the addition and deletion of patrons.
•	testContainingBooks: Verifies that a book's presence in the library is accurately determined by the containsBook function.
•	testContainingPatrons: Verifies the accuracy of the containsPatron method in identifying library patrons.
•	testLending: Verifies that previously borrowed books are handled correctly and tests the lending functionality for customers.
•	testReturning: Examines how the book return procedure is handled, including erroneous return attempts.

PATRONTEST CLASS
•	testGetName: Checks to see if the returned name matches the expected value in order to validate the getName function of the Patron class.
•	testBorrowedBookList: After books are borrowed and returned, this function verifies that the borrowed book list is accurate for patrons.
•	testBorrowedBook2: This test verifies the accuracy of the list of borrowed books following various borrowing and returning situations.
•	testborrowedCount: Verifies the accuracy of the getBorrowedCount method's count of the books a borrower has checked out.

TEST SUİTES
To properly organize and execute tests, the project includes multiple test suites:
•	TestSuiteOnlyForBooks: Concentrates exclusively on tests pertaining to the functionality of the Book class.
•	TestSuiteForPatronandLibrary: Focuses on testing the features of the testing system that are relevant to the Patron and Library classes.

![UML class (2) (1)](https://github.com/egmndrk/Testing-Project-With-JUnit/assets/161582959/23d27d3d-eaa2-4b1a-b017-8d70c2297290)

CONCLUSİON
All in all, the JUnit tests efficiently cover the functionality of the library management system, guaranteeing that the activities related to books, users, borrowing, and returning are performed as intended. Clear and simple testing for the various system components is made possible by the well-organized test suites.
The testing methodology and results of the Java project's JUnit tests are compiled in this paper, emphasizing how exhaustive and complete the testing processes were.

