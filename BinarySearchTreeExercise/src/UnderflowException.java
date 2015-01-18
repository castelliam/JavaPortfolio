
public class UnderflowException extends Exception { 
	public UnderflowException(String message) {
			super(message); 
		}
	
	public UnderflowException() {
		super("Attempt to remove data from an empty BST.");
	}
}