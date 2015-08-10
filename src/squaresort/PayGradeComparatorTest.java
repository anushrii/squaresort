package squaresort;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class PayGradeComparatorTest {

	@Test
	public void testPayGradeComparator() {
		Person[] expected = new Person[5];
		Person[] actual = new Person[5];
		for(int i=0;i<5;i++){
			expected[i]=new Person();
			actual[i] = expected[i];
		}
		
		Comparator<Person> nc = new PayGradeComparator();
		
		Arrays.sort(expected,nc);
		Squaresort.linearSort(actual, nc);
		
		
		for(int i =0 ;i<5;i++)
			assertEquals(actual[i].toString(),expected[i].toString());
	}
	

}
