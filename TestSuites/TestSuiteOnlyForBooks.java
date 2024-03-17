package JunitHW;


import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Testing Al Tests Related to Books")
@SelectClasses({
	LibraryTest.class,
    BookTest.class
})
@IncludeTags("Books")

class TestSuiteOnlyForBooks {


}
