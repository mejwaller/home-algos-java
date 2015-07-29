package home.algosjava;

import java.util.Arrays;
import java.lang.IndexOutOfBoundsException;

public class ArrayStack<E> {
	
	private static final int DEF_SIZE = 10;
	
	private Object[] elems;
	private int top = -1;
		
	public ArrayStack() {
		elems = new Object[DEF_SIZE];
	}
	
	public ArrayStack(int size) {
		elems = new Object[size];
	}
	
	public boolean isEmpty() {
		
		if(top<0) return true;
		
		return false;
	}
	
	public void push(E e) {
		if(top == elems.length-1) {
			throw new IndexOutOfBoundsException("Stack overflow");			
		}
		elems[++top] = e;
	}
	
	public E pop() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("Stack underflow");
		}
		E e = (E) elems[top];
		elems[top] = null;
		top--;
		return e;
	}

}