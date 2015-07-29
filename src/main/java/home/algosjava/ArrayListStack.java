package home.algosjava;
//stack implementation using an ArrayList
//(so should auto-resize *up* as elements are added
//but won't auto-resize down as elements are removed
import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class ArrayListStack<T> {
	
	private ArrayList<T> array;
	private int top;

	public ArrayListStack() { 
		top=-1;
		array = new ArrayList<T>();
	}

	public boolean isEmpty() {
		if(top<0) return true;
		else return false;
	}
	
	public boolean push(T elem) {
		top++;
		return array.add(elem);
	}
	
	public T pop() {
		
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("Underflow - stack is empty");
		}
		else {
			top--;
			return array.remove(top+1);
		}
	}
}