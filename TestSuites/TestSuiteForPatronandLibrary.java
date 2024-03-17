package JunitHW;


import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Testing Library and Patron Tests")
@SelectClasses({
    LibraryTest.class,
    PatronTest.class
})
@ExcludeTags("Books")

class TestSuiteForPatronandLibrary {

}
