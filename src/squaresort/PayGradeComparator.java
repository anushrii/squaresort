package squaresort;

import java.util.Comparator;

public class PayGradeComparator implements Comparator<Person> {
    
	@Override
	public int compare(Person p1, Person p2) {
		int payGrade1 = p1.payGrade;
		int payGrade2 = p2.payGrade;
		
		
		// TODO Auto-generated method stub
		return payGrade1 - payGrade2;
	}

}
