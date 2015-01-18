/**
 * OrderedCollection stores a collection of Comparables (in an array), along with 
 * the current size of the collection.
 * 
 * Elements ordered in ascending order according to the Comparable stored
 * 
 * Alex Castelli
 * January 17, 2013
 * Homework2 Part B
 */
public class OrderedCollection<T extends Comparable<? super T>> {
    private T collection[]; // the collection
    private int size; // how many elements currently stored
    private int i = 0;
    
    /**
     * Constructor allocates array and initializes size
     * @param size the number of elements stored
     */
    public OrderedCollection (int capacity) {
        
        collection = (T[]) new Comparable[capacity];
        size = 0;       
    }
 
    
    /**
     * isEmpty determines if collection has no elements
     * @return true if collection empty, false otherwise
     */
    public boolean isEmpty(){
    	if(size == 0) return true;
    	else return false;
    }
    
    /**
     * makeEmpty resets the collection to be empty, and sets size to 0
     */
    public void makeEmpty()
    {	
    	for(int i = 0; i < size; i++)
    	{
    		remove(collection[i]);
    	}
    	    	
    	size = 0;
    }
    
    /**
     * insert value x in collection, maintaining ascending order of elements. 
     *    size incremented; duplicates may be inserted
     * @param x the element to add to the collection
     */
    public void insert(T x)
    {
    	if(collection[0] == null){collection[0] = x;}
    	else
    	{
	    	int i = 0;
	    	while(i < size && collection[i].compareTo(x)<0)
	    	{
	    		i++;
	    	}
	    	
	    	for(int y = size; y >= i; y--)
	    	{
	    		collection[y+1] = collection[y];
	    	}
	    	
	    	collection[i] = x;
    	}
    	size += 1;
    }
    
    /**
     * remove the first occurrence of the specified element from the collection; 
     * the element may not actually be in the list
     * @param the element to remove
     */
    public void remove (T x){
    	boolean found = false;
    	int i = 0;
    	
    	while(!found && i < size)
    	{
    		if(collection[i].compareTo(x) == 0)
    		{
    			found = true;
    			for(int y = i; y <= size; y++)
    			{
    				collection[y] = collection[y+1];
    			}
    		}
    		else
    		{
    			i++;
    		}
    	}
    	
    	if(found == true)
    	{
	    	size -= 1;
	    	collection[size] = null;
    	}
    }
    
    /**
     * findMin returns a reference the minimum element in the collection, should only be
     * called if the collection is not empty
     * 
     * @return the reference of the minimum element or 
     * null if the collection is empty
     *
     */
    public T findMin()
    {
    	return collection[0];
    }
    
    /**
     * findMax returns a reference to the maximum element in the collection, should
     * only be called if the collection is non-empty
     * 
     * @return the reference the the maximum element in the collection or 
     * null if the collection is empty
     */
    public T findMax( )
    {
    	return collection[size-1];
    }
    
    /**
     * 
     * @return returns the entire collection of the contents, each item separated by a newline
     * null if the collection is empty
     */

    public String toString()
    {
    	
    	for(int i = 0; i < size;i++)
    	{
    		System.out.println(collection[i]);
    	}
    	return "";
    }

}// end class OrderedCollection
