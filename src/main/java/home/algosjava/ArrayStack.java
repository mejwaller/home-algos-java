package home.algosjava;
//stack implementation using an ArrayList
import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class ArrayStack<T> {
	
	private ArrayList<T> array;
	public int top;

	public ArrayStack() { 
		top=0;
		array = new ArrayList<T>();
	}

	public boolean isEmpty() {
		if(top==0) return true;
		else return false;
	}
	
	public void push(T elem) {
		top++;
		array.add(top,elem);
	}
	
	public T pop() throws IndexOutOfBoundsException {
		
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow - stack is empty");
		}
		else {
			top--;
			return array.remove(top+1);
		}
	}
}