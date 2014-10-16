import java.util.Random;

/**
 * The HelloWorldApp class implements an application that
 * simply prints "Hello World!" to standard output.
 */
class SortersApp {
	
	private final static int minsize=4;
    
    
    public static void insertionSort(int[] A)
    {
    	//loop through set
    	for(int j = 1; j< A.length; j++)
    	{
    		//index of previous set member
    		int i = j-1;
    		//value of current member
    		int val = A[j];
    		
    		//move any larger values on the left to the right
    		//i starts at j-1, gets decreased each time larger value located on the left
    		while( (i >= 0) && (A[i] > val))//while i > start, and the current item is larger than the one we are comparing...
    		{
    			//move current item up one
    			A[i+1] = A[i];
    			//move to next item on the left
    			i--;
    		}
    		
    		//all done - remaining value of i is where to put our jth element (val) 
    		A[i+1] = val;
    		
    	}
    }
    
    public static void invertInsertionSort(int[] A) {
    	
    	//loop through set
    	for(int j = 1; j< A.length; j++)
    	{
    		//index of previous set member
    		int i = j-1;
    		//value of current member
    		int val = A[j];
    		
    		//move any larger values on the left to the right
    		//i starts at j-1, gets decreased each time larger value located on the left
    		while( (i >= 0) && (A[i] < val))//while i > start, and the current item is larger than the one we are comparing...
    		{
    			//move current item up one
    			A[i+1] = A[i];
    			//move to next item on the left
    			i--;
    		}
    		
    		//all done - remaining value of i is where to put our jth element (val) 
    		A[i+1] = val;
    		
    	}
    }
    
    public static void insertionSort(int[] A, int left, int right)
    {    		
    	for (int j =left+1; j <= right; j++){
    		int i = j - 1;
    		int val = A[j];
    		
    		while ( (i >= left) && (A[i] > val)){
    			A[i+1] = A[i];
    			i--;
    		}
    		
    		A[i+1] = val;
    	}
    
    }
    
    public static void invertInsertionSort(int[] A, int left, int right) {
    	
    	for (int j =left; j <= right; j++){
    		int i = j - 1;
    		int val = A[j];
    		
    		while ( (i >= left) && (A[i] < val)){
    			A[i+1] = A[i];
    			i--;
    		}
    		
    		A[i+1] = val;
    	}
    }
    
    public static void selectionSort(int[] A) {
    	
    	int smallest = A[0];
    	
    	for(int i = 1; i < A.length; i++)
    	{
    		if(A[i] < smallest) {  
    			int tmp = smallest;
    			smallest = A[i];
    			A[i] = tmp;
    			
    		}
    		
    		
    	}
    }
    
    public static int partition(int[] A, int left, int right, int pivotIndex)
    {	   	
    	//System.out.println("START partition");
    	    	
    	int pivot = A[pivotIndex];
    	
    	//move pivot to the end of tharray
    	int tmp = A[right];
    	A[right] = A[pivotIndex];
    	A[pivotIndex] = tmp;
    	
    	int store = left;
    	
    	//all values <= pivot are moved to the front of the array...   	
    	for(int idx = left; idx < right; idx++)
    	{
    		//System.out.println("idx = " + idx);
    		
    		if(A[idx] < pivot)
    		{
    			tmp = A[idx];
    			A[idx] = A[store];
    			A[store] = tmp;
    			store++;
    		}
    		
    		/*for(int i=0;i<A.length;i++)
            {
            	System.out.print(A[i] + ",");
            }
            System.out.println();*/
    	}
    	
        //then the pivot moved after them
    	tmp = A[right];
    	A[right] = A[store];
    	A[store] = tmp;
    	
    	/*System.out.println("After partition, array is:");
    	for(int i=0;i<A.length;i++)
        {
        	System.out.print(A[i] + ",");
        }
        System.out.println();
    	
    	System.out.println("END partition - store (p) is " + store);
    	*/
    	return store;
    	
    }
    
    public static int getPivot(int left, int right)
    {
    	Random idxer = new Random();
    	
    	//System.out.println("right is " + right + " left is " + left + "right-left + 1 is " + (right-left+1));
    	
    	return left + idxer.nextInt(right-left+1);
    }
    
    public static int selectKth(int[] Ar, int k, int left, int right)
    {
    	//System.out.println("START selectkth");
    	
    	//System.out.println("left is " + left + ", right is " + right + ", right-left is " + (right-left));
    	    	
    	int idx = getPivot(left,right);
    	//int idx = left;
    	
    	//System.out.println("idx (randomly selected) is " + idx + ", Ar[idx] is " + Ar[idx]);
    	
    	int pivotIndex = partition(Ar, left, right, idx);
    	
    	//System.out.println("left is " + left + ", k is " + k + " and pivotIndex is " + pivotIndex);
    	
    	if(left+k-1 == pivotIndex)
    	{
    		return pivotIndex;
    	}
    	
    	/* continue the loop, narrowing the range as appropriate. If we are
    	 * within the left-hand side of the pivot, then k can stay the same
    	 */
    	if(left+k-1 < pivotIndex)
    	{
    		//System.out.println("END selectkth (left+k-1 < pivotIndex)");
    		return selectKth(Ar, k, left, pivotIndex-1);
    	}
    	else
    	{
    		//System.out.println("END selectkth (left+k-1 >= pivotIndex)");
    		return selectKth(Ar, k-(pivotIndex-left+1), pivotIndex+1, right);
    	}
    }
    
    public static void mediansort(int[] ar, int left , int right)
    {
    	//System.out.println("START mediansort");
    	//if the sub-array has 1 or fewer elements,we are done...
    	if(right<=left)
    	{
    		//System.out.println("END mediansort (right<=left)");
    		return;    		
    	}
    	
    	int mid = (right-left+1)/2;
    	//System.out.println("mid = " + "(" + right + " - " + left + " + 1)" + "/2" + " = " + mid);
    	//System.out.println("mid's val is " + ar[mid]);
    	
        int me = selectKth(ar,mid+1,left,right);
        
        //System.out.println("me = " + me);
        
    	
    	mediansort(ar,left,left+mid-1);
    	mediansort(ar,left+mid+1, right);
    	//System.out.println("END mediansort");
    }
    
    public static void qsort(int[] ar,int left, int right)
    {	
    	if(right<=left)//1 element sort - done, return
    	{
    		return;
    	}
    	
    	int pivotIndex = getPivot(left,right);
    	pivotIndex = partition(ar,left,right,pivotIndex);
    	
    	if(pivotIndex-1-left <= minsize){
    		insertionSort(ar,left,pivotIndex - 1);
    	}
    	else {
    		qsort(ar, left, pivotIndex-1);
    	}
    	
    	if(right-pivotIndex-1 <= minsize) {
    		insertionSort(ar, pivotIndex+1, right);
    	}
    	else {
    		qsort(ar, pivotIndex+1, right);
    	}   	
    	
    }
    
    public static void heapify(int[] A, int idx, int max)
    {
    	//for a binary tree, tyhe tow children of a node at i have positions in array as i*2+1 (left)and i*2+2 (right)
    	int left = 2*idx+1;
    	int right = idx*2+2;
    	int largest;
    	
    	//if left exists (i.e i < max (n elems in tree)
    	//and left entry is > current (parent entry)
    	if(left < max && A[left] > A[idx])
    	{
    		largest = left;//store index of current largest val    		
    	}
    	else
    	{
    		largest = idx;//parent node is > left node
    	}
    	//similarly for right node
    	if(right < max && A[right] > A[largest])
    	{
    		largest = right;
    	}
    	if(largest != idx)//if parent node is *not* largest node
    	{
    		//make it ;argest node
    		int temp = A[idx];
    		A[idx]=A[largest];
    		A[largest]=temp;
    		heapify(A, largest, max);
    	}
    }
    
    public static void buildHeap(int[] A)
    {
    	for(int i=(A.length/2)-1; i >= 0; i--)
    	{
    		heapify(A,i,A.length);
    	}    	
	}
    
    public static void heapSort(int[] A)
    {
    	buildHeap(A);
    	
    	for(int i = A.length-1; i>0; i--)
    	{
    		int temp = A[0];
    		A[0] = A[i];
    		A[i] = temp;
    		heapify(A,0,i);
    	}
    }  
    
    public static void add(int[] n1, int[] n2, int[] sum)
    {
    	int position = n1.length - 1;
    	int carry = 0;
    	
    	while(position >= 0)
    	{
    		int total = n1[position] + n2[position] + carry;
    		
    		sum[position+1] = total % 10;
    		
    		if(total > 9)
    		{
    			carry = 1;
    		}
    		else
    		{
    			carry = 0;
    		}
    		
    		position--;
    	}
    
    	sum[0] = carry;    
    }
    
    public static void last(int[] n1, int[] n2, int[] sum)
    {
    	int position = n1.length;
    	int carry = 0;
    	
    	while(--position >= 0)
    	{
    		int total = n1[position] + n2[position] + carry;
    		
    		if(total > 9)
    		{
    			sum[position+1] = total - 10;
    			carry = 1;
    		}
    		else
    		{
    			sum[position+1] = total;
    			carry = 0;
    		}
    	}
    	
    	sum[0] = carry;    	
    }
}

