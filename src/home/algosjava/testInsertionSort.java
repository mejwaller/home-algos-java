package home.algosjava;
import junit.framework.TestCase;


public class testInsertionSort extends TestCase {

	public final void testInsertionSortIntArray() {
		
		int[] testArray = {5,2,4,6,1,3};
		int[] expected = {1,2,3,4,5,6};
		
		SortersApp.insertionSort(testArray);
		
		for(int i = 0; i < 6; i++ )
		{		
			assertEquals(expected[i],testArray[i]);
		}
		
	}

	public final void testInsertionSortIntArrayIntInt() {
		
		int[] testArray = {15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
		int[] expected = {/*4,11,7,12,13*/4,7,11,12,13};
		
		SortersApp.insertionSort(testArray, 4, 8);
		
		for(int i = 0; i < 5; i++)
		{
			assertEquals(expected[i],testArray[i+4]);
		}
		
		
	}
	
	public final void testInvertInsertionSortIntArray() {
		
		int[] testArray = {5,2,4,6,1,3};
		int[] expected = {6,5,4,3,2,1};
		
		SortersApp.invertInsertionSort(testArray);
		
		for(int i = 0; i < 6; i++)
		{
			assertEquals(expected[i],testArray[i]);
		}
			
	}
	
	public final void testInvertInsertionSortIntArrayIntInt() {
		
		int[] testArray = {15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
		int[] expected = {/*4,11,7,12,13*/13,12,11,7,4};
		
		SortersApp.invertInsertionSort(testArray,4,8);
		
		for(int i = 0; i < 5; i++)
		{
			assertEquals(expected[i],testArray[i+4]);
		}
		
		
	}

}
