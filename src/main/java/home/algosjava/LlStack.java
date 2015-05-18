//Stack implementation using a singly-linked list
package home.algosjava;

public class LlStack<T extends Comparable<T>> {
	SNode<T> top = null;
	
	public LlStack(){}
	
	public boolean isEmpty() {
		if(top==null) return true;
		return false;
	}
	
	public void push(T elem) {
		SNode<T> newNode = new SNode<>(elem);
		
		newNode.next=top;
				
		top=newNode;
		
	}
	
	public T pop() throws ArrayIndexOutOfBoundsException {
		if(top==null) {
			throw new ArrayIndexOutOfBoundsException("Stack underflow");
		}
		T retval = top.data;
		top = top.next;
		return retval;		
		
	}
	
	
	
}