/**
 * OrderedCollection stores a collection of Comparables (in an array), along with 
 * the current size of the collection.
 * 
 * Elements ordered in ascending order according to the Comparable stored
 * 
 * Data stored in a singly-linked list with reference to first element, called head
 * 
 * @author Alex Castelli
 * Homework3
 * January 30, 2013
 * 
 */
public class OrderedCollection<T extends Comparable<? super T>> {
    
    /******** an inner class  **********************
     * The node type for a linked list OrderedCollection
     */
    private static class Node<T> {
        
        public Node(T x) {
            data = x; next = null;           
        }
        
        public T data;
        public OrderedCollection.Node<T> next;
    }
    /**********************************************************/
    
    // The OrderedCollection data - its instance variables
    
    private OrderedCollection.Node<T> front; // front marker
    private int actualSize; // how many elements currently stored
    private int maxSize;
    /**
     * Constructor allocates array and initializes size
     * @param size the number of elements stored
     */
    public OrderedCollection (int capacity) {
        
        maxSize = capacity;
        actualSize = 0; 
        front = null;  // When list is empty, front is null
    }
    
    /**
     * 
     * @return a String representation of the list
     */
    public String toString(){
        OrderedCollection.Node walker = front;
        String returnString = "";
        while (walker != null){
            returnString += walker.data + "\n";
            walker = walker.next;
        }  
        return returnString;
    }

    /**
     * isEmpty determines if collection has no elements
     * @return true if collection empty, false otherwise
     */
    /*
    public boolean isEmpty(){
        return size == 0; // will have to be completed
    }
    
    /**
     * makeEmpty resets the collection to be empty, and sets size to 0
     */ 
    public void makeEmpty(){
        actualSize = 0;
        front = null;
    }
       
    /**
     * insert value x in collection, maintaining ascending order of elements. 
     *    actualSize incremented
     * if collection already at capacity (maxSize), collection unchanged
     * @param x the element to add to the collection
     */
   
    public void insert(T x) {
        
        // For now, just put at front of list - fix later to insert in order

        if (actualSize < maxSize){
            // make a new Node
            OrderedCollection.Node newNode = new OrderedCollection.Node<T>(x);
             
            // Figure out where new node goes
            // Is list empty? If not, does it go first? 
            //    the actions are the same in either case
            if (front == null || (front.data).compareTo(x) > 0){ // yes, node goes first
                newNode.next = front;
                front = newNode;
            }
            else{ // must find location to place new node, and keep track of
                 // previous node as well - requires an extra "walker"
                OrderedCollection.Node<T> current = front.next; // place being considered
                OrderedCollection.Node<T> previous = front;  // one postion behind
                while (current != null && current.data.compareTo(x) < 0){
                   previous = current;
                   current = current.next;
                }
                // Place node after "previous"
                previous.next = newNode;
                newNode.next = current;
            }              
            actualSize++;
        }             
    }
    
    /**
     * remove the specified element from the collection
     *    if the element is not in the list, the method does
     *    nothing
     * @param the element to remove
     */
    public void remove (T x){
    	if(front == null){}
    	
    	else if(front.data.compareTo(x) == 0)	//first case works for apple
    	{
    		front = front.next;
    		actualSize--;
    	}
    	
    	else
    	{
    		OrderedCollection.Node<T> current = front.next;
    		OrderedCollection.Node<T> previous = front;
    		
    		boolean found = false;
    		
    		while (current != null && found == false){
    			 if(current.data.compareTo(x) == 0)
    			 {
    				found = true;
    				if(current.next == null){
    					previous.next = null;
    				}
    				else{
    					previous.next = current.next;
    				}
    	    		actualSize--;
    			 }
                previous = current;
                current = current.next;
             }
    	}
 
    }
    
    /**
     * findMin returns a reference the minimum element in the collection
     * 
     * @return the reference of the minimum element or 
     * null if the collection is empty
     *
     */
    
    public T findMin( ){
        return front.data;
    }
    
    /**
     * findMax returns a reference to the maximum element in the collection
     * 
     * @return the reference the the maximum element in the collection or 
     * null if the collection is empty
     */

    public T findMax( ){
		OrderedCollection.Node<T> current = front.next;
		OrderedCollection.Node<T> previous = front;
		
		while(current != null)
		{
			previous = current;
			current = current.next;
		}
		return previous.data; //should be current?
    }  

	public boolean isEmpty()
	{
		return actualSize == 0;
	}
    
     
    public static void main(String[] args){
   
        OrderedCollection<String> o = new OrderedCollection<String>(10);
        
      // System.out.println("The collection is now empty? "+ o.isEmpty());
      // System.out.println("min element is " + o.findMin()+ "\n");
      //  System.out.println("max element is " + o.findMax() + "\n");
        o.insert("hello");
        System.out.println("Insert into empty list\n--\n" + o + "---\n");
        o.insert("apple");
        System.out.println("Insert new first element\n--\n" + o + "---\n");
        o.insert("basket");
        System.out.println("Insert new middle element\n--\n" + o + "---\n");
        o.insert("zero");
        System.out.println("Insert new last element\n--\n" + o + "---\n");
        o.insert("to");
        o.insert("to");
        o.insert("insert");
        o.insert("method");
        o.insert("by adding");
        o.insert("too many elements");
        System.out.println("Insert too many elements\n--\n" + o + "---\n");
      // Commented out until further development of methods  
        System.out.println("min element is " + o.findMin()+ "\n");
        System.out.println("max element is " + o.findMax() + "\n");
        
        o.remove("apple"); // try to remove 1st element
        System.out.println("Is apple - first element- gone? \n--\n" + o + "---\n");  
        o.remove("insert");
        System.out.println("Is insert - middle element- gone? \n--\n" + o + "---\n"); 
        o.remove("to"); 
        System.out.println("Is to - duplicate element- gone? \n--\n" + o + "---\n"); 
        o.remove("zero"); 
        System.out.println("Is zero - last element- gone? \n--\n" + o + "---\n"); 
        o.remove("banana");
        System.out.println("Does request to remove something not there break anything? \n--\n" + o + "---\n");  
        o.remove("basket");
        o.remove("try");
        o.remove("method");
        o.remove("break");
        o.remove("to");
        o.remove("hello");
        System.out.println("Can list be emptied with generating an error? \n--\n" + o + "---\n");  
        o.remove("one more");
        System.out.println("Is remove robust enough to stand a call on empty list? \n--\n" + o + "---\n");  
        System.out.println("min element is " + o.findMin() + "\n");
        System.out.println("max element is " + o.findMax() + "\n");

	System.out.println("Is collection empty, should return false: " + o.isEmpty() + "\n");
	o.makeEmpty();
	System.out.println("Is collection empty, should return true: " + o.isEmpty() + "\n");
        
       // * */
        
        OrderedCollection<Integer> oI = new OrderedCollection<Integer>(3);
        oI.insert(25);
        System.out.println(oI);
 ///*       
        OrderedCollection<Employee> oE = new OrderedCollection<Employee>(5);
        oE.insert(new Employee("Harry", 101, 55000));
        oE.insert(new Employee("Renee", 220, 100111));
        System.out.println(oE);
 // */ 
   } 
}// end class OrderedCollection
