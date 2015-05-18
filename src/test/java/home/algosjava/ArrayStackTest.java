package home.algosjava;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {
	
	@Test
	public void testEmpty() {
		ArrayStack<Integer> intStack = new ArrayStack<>();
				
		assertTrue(intStack.isEmpty());
				
	}
	
	@Test
	public void testPushAndPop() {
		
		ArrayStack<String> stringStack = new ArrayStack<>(11);
		
		stringStack.push("a1");
		stringStack.push("a2");
		stringStack.push("a3");
		
		assertFalse(stringStack.isEmpty());
		
		assertEquals("a3",stringStack.pop());
		assertFalse(stringStack.isEmpty());
		
		assertEquals("a2",stringStack.pop());
		assertFalse(stringStack.isEmpty());
		
		assertEquals("a1",stringStack.pop());
		assertTrue(stringStack.isEmpty());
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testOverflow1() {
		ArrayStack<Integer> intStack = new ArrayStack<>();
		
		for(int i = 0; i <= 10; i++) {
			intStack.push(i);
		}
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testOverflow2() {
		ArrayStack<Integer> intStack = new ArrayStack<>(15);
		
		for(int i = 0; i<=15; i++) {
			intStack.push(i);
		}
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testUnderFlow() {
		ArrayStack<Character> charStack = new ArrayStack<>();
		
		charStack.pop();
		
	}
	
}