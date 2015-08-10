package squaresort;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class EmployeeIdComparatorTest {

	@Test
	public void testEmployeeIdComparator() {
		Person[] expected = new Person[5];
		Person[] actual = new Person[5];
		for(int i=0;i<5;i++){
			expected[i]=new Person();
			actual[i] = expected[i];
		}
		
		Comparator<Person> nc = new EmployeeIdComparator();
		
		Arrays.sort(expected,nc);
		Squaresort.linearSort(actual, nc);
		
		for(int i =0 ;i<5;i++)
			assertEquals(actual[i].toString(),expected[i].toString());
	}
}
