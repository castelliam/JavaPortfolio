 /* 
 * Alex Castelli
 * January 17, 2013
 * Homework2 Part B
 */
public class OrderedTest
{
	public static void main(String [] args)
	{
	
		OrderedCollection x = new OrderedCollection(10);
	
		System.out.println("Should say true for empty test: " + x.isEmpty());
		
		System.out.println();
						
		x.insert(new Integer(100));
		x.insert(new Integer(90));
		x.insert(new Integer(80));
		x.insert(new Integer(102));
		x.insert(new Integer(82));
		x.insert(new Integer(74));
		x.insert(new Integer(106));
		
		System.out.println("Should show numbers in order for insert: ");
		x.toString();
		
		System.out.println();
		
		System.out.println("Should say false for empty test: " + x.isEmpty());
		
		System.out.println();
		
		System.out.println("Find min test: " + x.findMin());
		System.out.println("Find max test: " + x.findMax());
		
		System.out.println();
		
		System.out.println("Removed 100: ");
		x.remove(100);
		x.toString();
		
		System.out.println();
		
		System.out.println("Removed 74: ");
		x.remove(74);
		x.toString();
		
		System.out.println();
		
		System.out.println("Removed 102: ");
		x.remove(102);
		x.toString();
		
		System.out.println();

		
		System.out.println("Make empty test: ");
		x.makeEmpty();
		x.toString();
		System.out.println("Success");
		
	}
	
}
