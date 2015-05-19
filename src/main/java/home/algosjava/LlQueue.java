//Stack implementation using a singly-linked list
package home.algosjava;

public class LlQueue<T extends Comparable<T>> {
	SNode<T> head, tail = null;
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		
		return false;
	}
	
	public void enqueue(T item) {
		
		SNode<T> node = new SNode<>(item);
		
		if(head==null) {
			
			head = tail = node;			
		}
		else {
			tail.next = node;
			tail = node;
		}		
	}
	
	public T dequeue() throws IndexOutOfBoundsException {
		
		if(isEmpty()) throw new IndexOutOfBoundsException("Empty queue.");
		
		T retval = head.data;
		
		head = head.next;
		
		return retval;
		
	}
}