
public class Queue<T extends Comparable<? super T>> implements QueueInterface<T>{
	
    private static class Node<T> {
        
        public Node(T x) {
            data = x;
            next = null;
            prev = null;
        }
        
        public T data;
        public Queue.Node<T> next;
        public Queue.Node<T> prev;
    }
    
    private Queue.Node<T> front; // front marker
    private Queue.Node<T> back;
    /**
     * Constructor sets front and back to null on empty linkedlist
     */
    public Queue () {
        front = null;  // When list is empty, front is null
        back = null;
    }
	
    /**
     * deletes first element in array
     * throws EmptyQueueException if it's on an empty list
     */
	public T dequeue() throws EmptyQueueException {
		if(front == null){throw new EmptyQueueException();}
		else{
			T retValue = front.data;
			front = front.next;
			return retValue;
		}
	}
	
    /**
     * adds to the back of the list
     * @param an object T
     */
	public void enqueue(T x) {
        Queue.Node newNode = new Queue.Node<T>(x);
         

        if (front == null){ // if nothing in the list yet
            newNode.next = front;
            newNode.prev = null;
            front = newNode;
        }
        else{ //if there's more than 1 in the queue
            Queue.Node<T> current = front.next; // place being considered
            Queue.Node<T> previous = front;  // one position behind
            while (current != null){
               previous = current;
               current = current.next;
            }
            previous.next = newNode;
            newNode.next = current;
        }
        back = newNode;
  	}
	
    /**
     * make the list empty
     */
	public void makeEmpty()
	{
		front = null;
	}
	
    /**
     * return true if list is empty or false if list has elements
     */
	public boolean isEmpty()
	{
		System.out.println(front == null);
		return front == null;
	}
	
	public Integer size()
	{
		int count = 0;
		Queue.Node walker = front;
		while(walker != null)
		{
			walker = walker.next;
			count++;
		}
		return count;
	}
	
	public String toString()
	{
		Queue.Node temp = front;
		Queue.Node walker = front;
		while(front != null){
			System.out.println(front.data);
			front = front.next;
		}
		front = temp;
		return "";
	}
	
	public static void main(String[]args) throws EmptyQueueException
	{
		Queue<String> q = new Queue<String>();
		q.enqueue("hello");
		q.enqueue("goodbye");
		q.enqueue("world");
		q.enqueue("last element");
				
		q.toString();
		
		System.out.println("Should return size 4: " + q.size());
		
		q.dequeue();
		System.out.println("Dequeue should have deleted 'hello'");
		q.toString();
		
		System.out.print("Should return false on isEmpty: ");
		q.isEmpty();
		
		System.out.println("Should have deleted 'goodbye'");
		q.dequeue();
		q.toString();
		
		System.out.println("Should have deleted 'world'");
		q.dequeue();
		q.toString();
		
		System.out.println("Should have deleted 'last element'");
		q.dequeue();
		q.toString();
		System.out.println("Should return size 0: " + q.size());
		
		System.out.print("isEmpty: ");
		q.isEmpty();
		
		System.out.println("Should be an empty list: ");
		q.makeEmpty();
		q.toString();
		
		System.out.print("Should return true on isEmpty: ");
		q.isEmpty();
		
		//commented out to see if EmptyQueueException works
		//System.out.println("Try to dequeue on an empty list");
		//q.dequeue();
		
		System.out.println("Add 'computer science' onto the empty list");
		q.enqueue("computer science");
		q.toString();
		System.out.print("Should return false on isEmpty: ");
		q.isEmpty();
		System.out.println("Should return size 1: " + q.size());
	}
}
