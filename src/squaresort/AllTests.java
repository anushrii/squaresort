package squaresort;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmployeeIdComparatorTest.class, NameComparatorTest.class,
		PayGradeComparatorTest.class, SquaresortTest.class })
public class AllTests {

}
