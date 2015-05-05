package home.algosjava;
import junit.framework.TestCase;


public class testSelectionSort extends TestCase {
	
	public final void testselectionSort() {
		
		int[] testArray = {15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
		int[] expected = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		
		SortersApp.selectionSort(testArray);
		
		for(int i = 0; i < 15; i++) {
			
			assertEquals(expected[i],testArray[i]);			
		}	
		
	}

}
