package home.algosjava;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListStackTest {
	
	@Test
	public void testEmpty() {
		ArrayListStack<Integer> intStack = new ArrayListStack<>();
				
		assertTrue(intStack.isEmpty());
				
	}
	
	@Test
	public void testPushandPop() {
		ArrayListStack<String> stringStack = new ArrayListStack<>();
		
		assertTrue(stringStack.isEmpty());
		
		assertTrue(stringStack.push("astring"));
		assertTrue(stringStack.push("bstring"));
		assertTrue(stringStack.push("cstring"));
		
		assertFalse(stringStack.isEmpty());
		
		assertEquals("cstring",stringStack.pop());
		
		assertFalse(stringStack.isEmpty());
		
		assertEquals("bstring",stringStack.pop());
		
		assertFalse(stringStack.isEmpty());
		
		assertEquals("astring",stringStack.pop());
		
		assertTrue(stringStack.isEmpty());
	}
	
}