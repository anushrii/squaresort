package squaresort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Squaresort {
	public static void linearSort(int[] nums){
		int outer, inner, min;
	    for (outer = 0; outer < nums.length - 1; outer++) { 
	    	
	        min = outer;
	        for (inner = outer + 1; inner < nums.length; inner++) {
	        	
	            if (nums[inner] < nums[min]) {
	                min = inner;
	            }
	            for (int i=outer;i<=inner;i++) assert nums[min] <= nums[i]; // loop invariant
	            // Invariant: for all i, if outer <= i <= inner, then a[min] <= a[i] 
	        }
	        assert inner >= nums.length; // exit condition
	        
	            // a[min] is least among a[outer]..a[a.length - 1]
	        int temp = nums[outer];
	        nums[outer] = nums[min];
	        nums[min] = temp;
	        for (int i=0; i<=outer; i++) {
	        	for (int j=i+1;j<=outer;j++) assert nums[i]<=nums[j] ;
	        }
	        // Invariant: for all i <= outer, if i < j then a[i] <= a[j]
	    }
	    assert outer >= nums.length-1;
	    for (int i=0; i<nums.length; i++) {
        	for (int j=0;j<=i;j++) assert nums[i]>=nums[j] ;
        }// invariant + exit
	}
	
	public static void linearSort(Person[] people, Comparator<Person> comp){
		int outer, inner, min;
		if(comp==null)
			return;
	    for (outer = 0; outer < people.length - 1; outer++) { 
	    		    	
	        min = outer;
	        for (inner = outer + 1; inner < people.length; inner++) {
	        	
	            if (comp.compare(people[inner], people[min])<0) {
	                min = inner;
	            }
	            for (int i=outer;i<=inner;i++) assert comp.compare(people[min], people[i])<=0; // loop invariant
	            // Invariant: for all i, if outer <= i <= inner, then a[min] <= a[i] 
	        }
	        assert inner >= people.length; // exit condition
	        // a[min] is least among a[outer]..a[a.length - 1]
	        
	        Person temp = people[outer];
	        people[outer] = people[min];
	        people[min] = temp;
	        for (int i=0; i<=outer; i++) {
	        	for (int j=i+1;j<=outer;j++) assert comp.compare(people[i], people[j])<=0 ;
	        }
	        // Invariant: for all i <= outer, if i < j then a[i] <= a[j]
	    }
	    assert outer >= people.length-1; // Exit condition
        for (int i=0; i< people.length; i++) {
        	for (int j=0;j<i;j++) assert comp.compare(people[i], people[j])>=0 ;
        }//invariant + exit
	}

	public static void squaresort(Person[][] people, Comparator<Person> comp){
		if(comp==null)
			return;
		
		int  min,outer,inner;
		int maxrow = people.length;
		int maxcol = people[0].length;
        int numElements = maxrow*maxcol;
        for (outer = 0; outer<=numElements -1 ; outer++){
        	min = outer;
        	for (inner = outer + 1; inner <numElements ; inner++){
        		if(comp.compare(people[inner/maxcol][inner%maxcol],people[min/maxcol][min%maxcol])<0){
        			min = inner;
        		}
        	    for (int i=outer;i<=inner;i++) assert comp.compare(people[min/maxcol][min%maxcol], people[i/maxcol][i%maxcol])<=0; // loop invariant
	            // Invariant: for all i, if outer <= i <= inner, then a[min] <= a[i] 
        	}
        	
        		assert inner >= numElements; // exit condition
        		// a[min] is least among a[outer]..a[a.length - 1]
        	 
        		Person temp = people[outer/maxcol][outer%maxcol];
        		people[outer/maxcol][outer%maxcol] = people[min/maxcol][min%maxcol];
        		people[min/maxcol][min%maxcol] = temp;
        		
        		 for (int i=0; i<=outer; i++) {
     	        	for (int j=i+1;j<=outer;j++) assert comp.compare(people[i/maxcol][i%maxcol], people[j/maxcol][j%maxcol])<=0 ;
     	        }
     	        // Invariant: for all i <= outer, if i < j then a[i] <= a[j]
        	}
        	assert outer >= numElements-1; // Exit condition
        	 for (int i=0; i<numElements; i++) {
  	        	for (int j=0;j<i;j++) assert comp.compare(people[i/maxcol][i%maxcol], people[j/maxcol][j%maxcol])>=0 ;
        	 }//invariant + exit
        }
			
	
		public static void main(String arg[]){
			List<Person[][]> matList = new ArrayList<Person[][]>();
			for(int i=10;i<=100;i=i+10){
				matList.add(createMatrix(i,2*i));
			}
			Comparator<Person> c = new EmployeeIdComparator();
			int i=1;
			
			for(Person[][] mat : matList){
				doTimings(mat,c,i++);
			}
		}
		
		public static Person[][] createMatrix(int n,int m){
			Person[][] mat = new Person[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++)
					mat[i][j] = new Person();
			}
			return mat;
		}
		
		public static void doTimings(Person[][] mat,Comparator<Person> c,int id){
			System.gc();
			long start = System.nanoTime();
			for(int i=0;i<10;i++)
				squaresort(mat, c);
			long elapsed = System.nanoTime() - start;
			System.out.println("Time for sort "+id+" "+elapsed/10);
		}
	
}

