package home.algosjava;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
//import java.util.LinkedList;

class googleplay {
			
	//euclids gcd algo from http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=math_for_topcoders
	 static public int gcd(int a, int b) {
		
		if(b == 0) return a;
		return gcd(b,a%b);
	}
	 
	//lowest common multiplier using gcd (see above)
	 static public int lcm(int a, int b) {
		 return b*a/(gcd(a,b));
	 }
	 
	 //converts number n, in base b, to decimal:
	 static public int toDecimal(int n, int b) {
		 int result=0;
		 int multiplier=1;
		 
		 while(n>0)
		 {
			 result+=n%10*multiplier;
			 multiplier*=b;
			 n/=10;			 
		 }
		 
		 return result;
	 }
	 
	 //converts string n, in base b, to decimal number
	 static public int baseToDecimal(String n, int b)
	 {
		 int result = 0;
		 int multiplier =1;
		 String chars = "0123456789ABCDEFGHIJ";
		 
		 while(n.length() > 0)
		 {
			 result = result + chars.indexOf(n.charAt(n.length()-1)) * multiplier;
			 multiplier*=b;
			 n = n.substring(0,n.length()-1);
		 }
		 
		 return result;
	 }
	 
	 //convert number n from decimal to base b (upto 20)
	 static public String fromDecimal(long n, int b)
	 {
		 String chars="0123456789ABCDEFGHIJ";
		 String res="";
		 
		 while(n>0)
		 {
			 res = chars.charAt((int)n%b) + res;
			 n/=b;
		 }
		 
		 return res;
	 }
	 
	 //miltiply two fractions (numertor in [0], denom in [1])
	 static public int[] multFrac(int[] a, int[] b) {

		 int[] c = {a[0]*b[0],a[1]*b[1]};
		 return c;		 
	 }
	 
	 //simplify a fraction, using GCD above
	 static public void simplifyFrac(int[] a)
	 {
		 int b = gcd(a[0],a[1]);
		 a[0]/=b;
		 a[1]/=b;		 
	 }
	 
	 
	 //add two fractions - uses lcm above to make denoms equiv
	 static public int[] addFrac(int[] a, int[] b) {
		 
		 int denom=lcm(a[1],b[1]);
		 int[] c = {denom/a[1]*a[0] + denom/b[1]*b[0],denom};
		 return c ;		 
		 
	 }
	 
	 //subtract two fractions
	 static public int[] subFrac(int[] a, int[] b) {
		 
		 int denom=lcm(a[1],b[1]);
		 int[] c = {denom/a[1]*a[0] - denom/b[1]*b[0],denom};
		 return c ;
	 }
	 
	 static public boolean validateRow(int row, int[][] grid)
	 {
		 List<Integer> found = new ArrayList<Integer>();		 
		 
		 for(int c=0; c <9; c++)
		 {
			Integer num = grid[row][c];
			if(found.contains(num))
			{
				return false;
			}
			
			found.add(num);			 
		 }
		 
		 return true;
	 }
	 
	 static boolean validateCol(int col, int[][] grid)
	 {
		 List<Integer> found = new ArrayList<Integer>();
		 
		 for(int r=0; r < 9; r++)
		 {
			 Integer num = grid[r][col];
			 if(found.contains(num))
			 {
				 return false;
			 }
			 
			 found.add(num);		 
			 
		 }
		 
		 return true;
	 }
	 
	 static int[] arrIncrementer(int[] arr)
	 {	
		 
		 int[] retval = new int[arr.length+1];
		 int val = 1;
		 
		 for(int i = arr.length-1;i>=0;i--)
		 {
			int curval = arr[i] + val;
			retval[i+1] = curval%10;
			val = curval/10;	
			
		 }
		 
		 retval[0] = val;
		 
		 return retval;
		 
	 }
	 
	 public class Node {
		 
		 int weight;
		 List<Node> adjNodes;
		 
		 public List<Node> getAdjNodes() {
			 return adjNodes;
		 }
	 
	 }
	 
	 public class Graph {
		 List<Node> nodes;
		 
		 List<Node> getNodes(){return nodes;}
		 
		 
		 
	 }
	 
	 public int getNumSegs(Graph g)
	 {
		 int nsegs = 0;
		 
		 if(g.getNodes().isEmpty()) {
			 return 0;
		 }
		 
		 Set<Node> unvisited = new HashSet<Node>(g.getNodes()) ;
		 
		 dfs_visit(g.getNodes().get(0), unvisited, nsegs);
		 
		 return nsegs;		 
		 
		 
	 }
	 
	 public void dfs_visit(Node n, Set<Node> unvisited, int nsegs)
	 {
		 unvisited.remove(n);
		 
		 for(Node v : n.getAdjNodes()) {
			 
			 dfs_visit(v, unvisited, nsegs);
			 
		 }
		 
		 nsegs++;
		 
		 if(!unvisited.isEmpty())
		 {
			 dfs_visit(unvisited.iterator().next(),unvisited, nsegs);
		 }
	 }
	 
	 public void qsort(int[] arr, int a, int b)
	 {
		 if(a<b)
		 {
			 int c = partition(arr,a,b);
			 qsort(arr, a, c-1);
			 qsort(arr,c+1,b);
		 }
	 }
	 
	 public int partition(int[] arr, int a, int b) {
		 
		 int x = arr[b];
		 int tmp;
		 
		 int i = a-1;
		 
		 for(int j = a; j< b; j++) {
			 if(arr[j] <= x) {
				 i++;
				 tmp = arr[i];
				 arr[i] = arr[j];
				 arr[j] = tmp;				 
			 }			 
			 
		 }
		 
		 tmp = arr[b];
		 arr[b] = arr[i+1];
		 arr[i+1] = tmp;
		 
		 return i+1;
	 }
	 
	 
	 public void insertionSort(int[] arr) {
		 
		 for(int j = 1; j< arr.length; j++) {
			 int key = arr[j];
			 
			 //insert into right part
			 int i = j-1;
			 while(i >= 0 && arr[i] > key){
				 	arr[i+1] = arr[i];
				 	i--;
				 
			 }
			 arr[i+1] = key;
			 
		 }
		 
	 }
	 
	 
	 
}