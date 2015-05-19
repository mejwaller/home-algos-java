package home.algosjava;

import java.util.Arrays;
import java.lang.IndexOutOfBoundsException;

public class ArrayQueue<E> {
	
	private static final int DEF_SIZE = 10;
	
	private Object[] qarray;
	
	private int head=0;
	private int tail=0;
	
	public ArrayQueue() {
		qarray = new Object[DEF_SIZE];
	}
	
	public ArrayQueue(int size) {
		qarray = new Object[size];
	}
	
	public boolean isEmpty() {
		if(head==tail) {
			return true;
		}
		return false;
	}
	
	public E dequeue() throws IndexOutOfBoundsException {
		
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("Empty queue");
		}
		
		E e = (E) qarray[head];
		
		if(head==qarray.length-1) {
			head = 0;
		}
		else head++;
		
		return e;
		
	}
	
	public void enqueue(E e) throws IndexOutOfBoundsException {
		
		if((head==0 && tail==qarray.length-1) || (head == tail+1)) {
			throw new IndexOutOfBoundsException("Queue full.");
		}
		
		qarray[tail] = e;
		
		if(tail == qarray.length-1) {
			tail = 0;
		}
		else {
			tail++;
		}
		
	}
	
}