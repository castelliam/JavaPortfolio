
public interface QueueInterface<T extends Comparable<? super T>>  {
	
	void enqueue(T x);
	T dequeue() throws EmptyQueueException;
	String toString();
}