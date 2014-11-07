/**
 * @author a_mcastelli
 * Finds all the duplicates in an ArrayList<Integer>
 */

import java.util.ArrayList;

public class Duplicate {

	public ArrayList<Integer> findAllDuplicates(ArrayList<Integer> a){
		
		ArrayList<Integer> duplicates = new ArrayList<Integer>();
		ArrayList<Integer> eachIndex = new ArrayList<Integer>();
		
		for(int i = 0; i < a.size(); i++){
			if(!eachIndex.contains(a.get(i))) {
				eachIndex.add(a.get(i));
			}
			else{
				if(!duplicates.contains(a.get(i))) {
					duplicates.add(a.get(i));
				}
			}
		}
		
		return duplicates;
	}
	
	public static void main(String[] args){
		
		ArrayList<Integer> testArray = new ArrayList<Integer>();
		
		for(int i = 0; i < 20; i++){
			testArray.add(i);
		}
		
		testArray.add(2);
		testArray.add(4);
		testArray.add(18);
		testArray.add(18);
		
		Duplicate d = new Duplicate();
		System.out.println(d.findAllDuplicates(testArray));
		
		
	}
	
}
