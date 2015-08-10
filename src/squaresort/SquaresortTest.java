package squaresort;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class SquaresortTest {

	@Test
	public void testLinearSort() {
		int[] actual = {4, 6, 7, 9};
		int[] expected = {6, 9, 4, 7};
		Squaresort.linearSort(expected);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testSquaresort() {
		Person[][] expected = new Person[2][2];
		expected[0][0] = new Person();
		expected[0][1] = new Person();
		expected[1][0] = new Person();
		expected[1][1] = new Person();
		
		Person[][] actual = new Person[2][2];
		actual[0][0] = expected[0][1];
		actual[0][1] = expected[1][0];
		actual[1][0] = expected[1][1];
		actual[1][1] = expected[0][0];
		
		
		
		Comparator<Person> nc = new EmployeeIdComparator();
		Squaresort.squaresort(actual,nc );
		
//		System.out.println("Expected : ");
//		for(int i=0;i<2;i++){
//			for(int j=0;j<2;j++)
//				System.out.println(expected[i][j]);
//			System.out.println();
//		}
//		
//		System.out.println("Actual : ");
//		for(int i=0;i<2;i++){
//			for(int j=0;j<2;j++)
//				System.out.println(actual[i][j]);
//			System.out.println();
//		}
		assertArrayEquals(expected, actual);
	}
}
