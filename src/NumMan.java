/**
 * 
 * @author a_mcastelli
 * A Number Manipulation class, includes findMax, findMin, findSum, findAverage
 *
 */

public class NumMan {
	
	public static int findMax(int[] intList){
		int max = intList[0];
		for(int i = 0; i < intList.length; i++){
			if(intList[i] > max){
				max = intList[i];
			}
		}
		return max;
	}
	
	public static int findMin(int[] intList){
		int min = intList[0];
		for(int i = 0; i < intList.length; i++){
			if(intList[i] < min){
				min = intList[i];
			}
		}
		return min;
	}
	
	public static int findSum(int[] intList){
		
		int sum = 0;
		for(int i = 0; i < intList.length; i++){
			sum += intList[i];
		}
		return sum;
	}
	
	public static int findAverage(int[] intList){
		
		int sum = findSum(intList);
		return sum/intList.length;
	}
	
	public static void main(String[] args){
		
		NumMan n = new NumMan();
		int intList[] = {1,2,3,4,20,5,6,0,7,8,9,9,18};
		System.out.println("Max: " + NumMan.findMax(intList));
		System.out.println("Min: " + NumMan.findMin(intList));
		System.out.println("Sum: " + NumMan.findSum(intList));
		System.out.println("Average: " + NumMan.findAverage(intList));		
	}

}
