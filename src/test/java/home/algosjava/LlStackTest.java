package home.algosjava;

import org.junit.Test;

import static org.junit.Assert.*;

public class LlStackTest {
	
	@Test
	public void testEmpty() {
		LlStack<Integer> intStack = new LlStack<>();
		
		assertTrue(intStack.isEmpty());
	}
	
	@Test
	public void testPushandPop() {
	
		LlStack<String> strStack = new LlStack<>();
		
		assertTrue(strStack.isEmpty());
		
		strStack.push("a1");
		strStack.push("a2");
		strStack.push("a3");
		
		assertFalse(strStack.isEmpty());
		
		assertEquals("a3",strStack.pop());
		assertFalse(strStack.isEmpty());
		assertEquals("a2",strStack.pop());
		assertFalse(strStack.isEmpty());
		assertEquals("a1",strStack.pop());
		
		assertTrue(strStack.isEmpty());
		
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testEmptyPop() {
		
		LlStack<String> strStack = new LlStack<>();
		
		assertTrue(strStack.isEmpty());
		
		strStack.pop();
		
	}
}