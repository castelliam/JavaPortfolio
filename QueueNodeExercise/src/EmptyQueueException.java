
public class EmptyQueueException extends Exception { 
	public EmptyQueueException(String message) {
			super(message); 
		}
	
	public EmptyQueueException() {
		super("Attempt to remove data from an empty queue.");
	}
}