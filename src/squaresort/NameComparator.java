package squaresort;

import java.util.Comparator;

public class NameComparator implements Comparator<Person>{

	@Override
	public int compare(Person arg0, Person arg1) {
		// TODO Auto-generated method stub
		String lastName1 = arg0.surname;
		String lastName2 = arg1.surname;
		
		int comp = lastName1.compareTo(lastName2);
		if (comp==0){
			String givenName1 = arg0.givenName;
			String givenName2 = arg0.givenName;
			return givenName1.compareTo(givenName2);
		}
		else {
			return comp;
		}
		
	}
	
}
