package home.algosjava;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {
	
	@Test
	public void testIsEmoty() {
		ArrayQueue<Integer> intQu1 = new ArrayQueue<>();
		
		assertTrue(intQu1.isEmpty());
		
		ArrayQueue<Integer> intQu2 = new ArrayQueue<>(15);
		
		assertTrue(intQu2.isEmpty());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testEmptyDequeue1() {
		
		ArrayQueue<Integer> intQu1 = new ArrayQueue<>();
		
		Integer nosuch = intQu1.dequeue();
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testEmptyDequeue2() {
		
		ArrayQueue<Integer> intQu2 = new ArrayQueue<>(15);
		
		Integer nosuch = intQu2.dequeue();
		
	}
	
	@Test
	public void testEnqueueDequeue() {
		ArrayQueue<String> test = new ArrayQueue<>();
		
		assertTrue(test.isEmpty());
		
		test.enqueue("a1");
		assertFalse(test.isEmpty());
		test.enqueue("a2");
		assertFalse(test.isEmpty());
		test.enqueue("a3");
		assertFalse(test.isEmpty());
		
		assertEquals("a1",test.dequeue());
		assertFalse(test.isEmpty());
		assertEquals("a2",test.dequeue());
		assertFalse(test.isEmpty());
		assertEquals("a3",test.dequeue());
		assertTrue(test.isEmpty());
			
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testOverflow1() {
		
		ArrayQueue<Integer> intq = new ArrayQueue<>();
		
		for(int i = 0; i<=10; i++) {
			intq.enqueue(i);
		}		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testOverFlow2() {
		
		ArrayQueue<Integer> intq = new ArrayQueue<>(14);
		
		for(int i = 0; i<=14;i++) {
			intq.enqueue(i);
		}
	}
	
	
}