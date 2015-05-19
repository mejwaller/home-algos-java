package home.algosjava;

import org.junit.Test;

import static org.junit.Assert.*;

public class LlQueueTest {
	
	@Test
	public void testIsEmpty() {
		
		LlQueue<Integer> intq = new LlQueue<>();
		
		assertTrue(intq.isEmpty());
	}
	
	@Test
	public void testEnqueuDequeue() {
		
		LlQueue<String> strq = new LlQueue<>();
		
		assertTrue(strq.isEmpty());
		
		strq.enqueue("a1");
		assertFalse(strq.isEmpty());
		strq.enqueue("a2");
		assertFalse(strq.isEmpty());
		strq.enqueue("a3");
		assertFalse(strq.isEmpty());
		
		assertEquals("a1",strq.dequeue());
		assertFalse(strq.isEmpty());
		assertEquals("a2",strq.dequeue());
		assertFalse(strq.isEmpty());
		assertEquals("a3",strq.dequeue());
		assertTrue(strq.isEmpty());		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testEmptyDequeue1() {
		LlQueue<Integer> intq = new LlQueue<>();
		
		intq.dequeue();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testEmptyDequeue2() {
		
		LlQueue<Integer> intq = new LlQueue<>();
		
		for(int i = 0; i < 4; i++) {
			intq.enqueue(i);			
		}
		
		intq.dequeue();//0
		intq.dequeue();//1
		intq.dequeue();//2
		intq.dequeue();//3
		intq.dequeue();//bang!
		
	}
}