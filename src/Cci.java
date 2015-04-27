//code answers (Java) to 'Cracking the Code Interview'

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.lang.Character;

class Cci {
	
	static public boolean hasUniqueChars(String str) {
		Set<Character> chars = new HashSet<Character>();

		for(int i=0; i<str.length(); i++) {
			Character ch = str.charAt(i); //use autoboxing rather than constructor
			if(chars.contains(ch)) return false;
			chars.add(ch);
		}

		return true;
	}
	
	static public boolean isPermutation(String str1, String str2) {
		if(str1.length() != str2.length()) return false;

		if(str1.equals(str2)) return true;

		//naive:

		Map<Character, Integer> str1chars = new HashMap<Character, Integer>();
		Map<Character, Integer> str2chars = new HashMap<Character, Integer>();
		for(int i = 0; i <str1.length(); i++) {
			Character ch = str1.charAt(i);
			if(str1chars.containsKey(ch)) {			
				Integer count = str1chars.get(ch);
				count++;
				str1chars.put(ch, count);
			}
			else {
				str1chars.put(ch, 1);
			}
			ch = str2.charAt(i);
			if(str2chars.containsKey(ch)) {			
				Integer count = str2chars.get(ch);
				count++;
				str2chars.put(ch, count);
			}
			else {
				str2chars.put(ch, 1);
			}
		
		}		

		if(str1chars.equals(str2chars)) {
			return true;
		}
		else return false;
		
	}
	
	static public void spaceReplace(char[] str, int len) {

		//increment this by 2 as we insert '%20'
		int newlen = len;

		for(int i = 0; i<newlen; i++) {
			if(str[i] == ' ')  {
				newlen+=2;
				//shunt the remainder of the string along by 2
				for(int j = newlen-1; j>i;j--) {
					str[j] = str[j-2];
				}
				str[i]='%';
				str[i+1]='2';
				str[i+2]='0';
				i+=2;
			}
		}
	
	}
	
	static public String compressString(String in) {
		//we are given assumption that string only contains upper or lower case a-z
		//ignoring that assumption for now:

		if(in.length() <=1 )
		{
			return in;
		}

		StringBuffer temp = new StringBuffer();

		int curCount = 1;
		char curChar = in.charAt(0);
		for(int i =1; i < in.length(); i++) {
			if(in.charAt(i) == curChar) {
				curCount++;
			}
			else {
				temp.append(curChar);
				temp.append(curCount);
				curChar = in.charAt(i);
				curCount = 1;
			}
		}
		
		//end of string
		temp.append(curChar);
		temp.append(curCount);

		String retval = temp.toString();
		if(retval.length() >= in.length()) {
			return in;
		}

		return retval;
	}
	
	static public void rotMatrix(int[][] img, int n) {

	    int layers = n/2;
	    int temp;
	    
	    for(int layer = 0; layer < layers; layer++) {  
	       int first = layer;//starting index of layer
	       int last = n-1-layer;//end index of layer
	       
	       for(int i = first; i < last; i++) {//for each layer index
	           int offset = i -first;
	           
	           //store top row in temp
	           temp = img[first][i];
	           
	           //set top row to left column
	           img[first][i] = img[last-offset][first];
	           
	           //set left column to bottom row
	           img[last-offset][first] = img[last][last-offset];
	           
	           //set bottom row to right column
	           img[last][last-offset]=img[i][last];
	           
	           //set right column to top row (stored in temp)
	           img[i][last] = temp;
	        }
	    }  
	}
	
	static public void printMatrix(int[][] mat, int n) {
		
		StringBuffer line = new StringBuffer();
		
		for(int i=0; i< n; i++) {
			line.append(" ");
			for(int j=0;j<n;j++) {
				line.append(mat[i][j]);
				line.append(" ");				
			}
			System.out.println(line.toString());
			line.delete(0,line.length()-1);
		}
	}
	
	//assume int matrix
	static public void zeroRCs(int[][] m, int rows, int cols) {
	    
	    Set<Integer> orows = new HashSet<Integer>();
	    Set<Integer> ocols = new HashSet<Integer>();
	    
	     for(int i=0; i< rows; i++) {
	        for(int j =0; j<cols;j++) {
	            if(m[i][j]==0) {
	                orows.add(i);
			        ocols.add(j);
	            }
	        }
	    }
	    
	    for(Integer row: orows) {
	        for(int i = 0; i < cols; i++) {
	            m[row][i]=0;
	        }
	    }

	    for(Integer col: ocols) {
	        for(int i=0; i < rows; i++) {
	            m[i][col]=0; 
	        }	          
	    }
	  }
	
	
	//true if s2 is a substring of s1
	static public boolean isSubstring(String s1, String s2) {
	  	    
	    if(s1.contains(new StringBuffer(s2))) {
	        return true;
	    }
	    
	    return false;
	    
	}
	
	static public boolean isRotation(String s1, String s2) {
	    //S1 = "waterbottle"
	    //S2 = "erbottlewat"
	    //should return true 
	    
	    //S1 = "waterbottle"
	    //S2 = "erbottlewat"
	    //should return true 
	    
	    //use just *one* call to isSubstring

	    //trivial case - s1 == s2:
	    if(s1.equals(s2)) {
	        return true;
	    }
	    
	    //s2 will *always be a substring of s1 + s1 if s2 is a true rotation of s1...
	    //waterbottlewaterbottle contains string erbottlewat...
	    int len = s1.length();    
	    if(s2.length() == len && len > 0) {
	        String s1twice = s1+s1;
	        return isSubstring(s1twice,s2);
	    }
	    
	    return false;
	} 
	
	static public void llRemoveDupes(SlinkedList ll) {
	    
	    Set<Integer> nodes = new HashSet<Integer>();
	    
	    SNode curnode = ll.head;
	    
	    if(ll.head==null) return;//empty list
	    
	    nodes.add(ll.head.data);
	    
	    while(curnode.next!=null) {
	        if(nodes.contains(curnode.next.data)) {
	            ll.delete(curnode.next.data);
	        }
	        else {
	            nodes.add(curnode.next.data);	    
	        }
	        curnode = curnode.next;
	    }
	}
	
	static public SNode kthtolast(SlinkedList ll, int k) {
	    //simplest approach to me seems to be run along ll, count up the elements
	    //(so we have size n) then run along counting until we reach kth to last
	    //e.g.:
	    
	    //a->b->c->d->e->f
	    //3rd to last is d
	    //6 elements
	    //count along from 1 until we reach  6-3+1th element (n-k+1)
	    //test that n-k+1 is not <= 0!
	       int size=0;
	       
	       SNode curnode = ll.head;
	       
	       if(curnode==null) {
	           return null;
	       }
	       
	       while(curnode.next!=null) {
	           size++;
	           curnode=curnode.next;
	       }
	       size++;//account for last node
	       
	       if(size-k+1 <= 0) return null;//k goes back beyond front of list!
	       
	       
	       curnode=ll.head;
	       int counter=1;
	       while(counter < size-k+1) {
	           curnode=curnode.next;
	           counter++;
	       }
	       
	       return curnode;
	   }
	
	//first solution - generate a new linked list (question does not say in place) 
	static public SlinkedList partition(SlinkedList ll, int val) {
	    SlinkedList retlist = new SlinkedList();
	    
	    SNode curnode = ll.head;
	    if(curnode==null) return null;
	    
	    while(curnode!=null) {
	        //insert/append *copies* as 'next' pointer gets updated once put into new list 
	        if(curnode.data < val) {
	            retlist.insert(new SNode(curnode.data));
	        }
	        else {
	            retlist.append(new SNode(curnode.data));
	        }
	        curnode = curnode.next;
	    }
	        
	    return retlist;
	 }
	
	static public SlinkedList add(SlinkedList left, SlinkedList right) {
	    
	    int ileft, iright;
	    
	    //build ileft
	    int mult = 10;
	    
	    //if both are null, return null, else if one is null just return the other
	    if(left.head==null) {
	        if(right.head!=null){
	            return right;
	        }
	        else return null;
	    }
	    else if(right.head==null) {
	        return left;
	    }
	    
	    //build left number
	    ileft = left.head.data;
	    
	    SNode curnode = left.head.next;
	    
	    while(curnode!=null) {
	        ileft += mult * curnode.data;
	        mult*=10;
	        curnode=curnode.next;
	    }
	    
	    //build right number
	    iright = right.head.data;
	   
	    curnode = right.head.next;
	    mult=10;
	    while(curnode!=null){
	       iright += mult * curnode.data;
	       mult*=10;
	       curnode=curnode.next;
	    }   
	    
	    int iresult=ileft+iright;
	    
	    //System.out.println("Adding: " + ileft + " + " + iright + " = " + iresult);
	    
	    //no build up linkedlist
	    SlinkedList retval = new SlinkedList();
	       
	    while((iresult/10) != 0 || (iresult%10) !=0) {
	        
	        retval.append(new SNode(iresult%10));
	        iresult=iresult/10;
	        //System.out.println("iresult now: " + iresult + " so iresult/10 = " + iresult/10 + " and iresult%10 = " + iresult%10);
	    }
	    
	    return retval;
	}		
	
	static public SlinkedList addV2(SlinkedList left, SlinkedList right) {
	     
	     //if both are null, return null, else if one is null just return the other
	    if(left.head==null) {
	        if(right.head!=null){
	            return right;
	        }
	        else return null;
	    }
	    else if(right.head==null) {
	        return left;
	    }
	    
	    //build left number
	    //123 stored as 1-2-3
	    int ileft = left.head.data;
	    
	    SNode curnode = left.head.next;
	    while(curnode!=null) {
	        //System.out.println("ileft is now: " + ileft + "(should be " + 9969 + ")");
	        ileft*=10;
	        ileft+=curnode.data;
	        curnode = curnode.next;
	    }
	    
	    //build right number
	    int iright = right.head.data;
	    
	    curnode = right.head.next;
	    while(curnode!=null) {
	        //System.out.println("iright is now: " + iright + "(should be " + 345 + ")");
	        iright*=10;
	        iright+=curnode.data;
	        curnode = curnode.next;
	    }
	    
	    int iresult=ileft+iright;
	    
	    //no build up linkedlist
	    SlinkedList retval = new SlinkedList();
	        
	    while(iresult/10 != 0 || iresult%10 !=0) {
	        
	        retval.insert(new SNode(iresult%10));
	        iresult=iresult/10;
	    }
	    
	    return retval;
	}
	
	static public SNode getRepeated(SlinkedList ll) {
	    Set<SNode> seen = new HashSet<SNode>();
	    
	    if(ll.head==null) return null;
	    
	    SNode curnode = ll.head;
	    
	    while(curnode!=null) {
	        //return curnode if it's already in the ll (same node as previous)
	        if(seen.contains(curnode)) {
	            return curnode;
	        }
	        else {//add curnode to the set to mark it as having been seen
	            seen.add(curnode);
	        }
	        curnode = curnode.next;
	    }
	    
	    //if we get here there is no circularity so return null
	    return null;
	}
	
	public static boolean isPalindrome(SlinkedList ll) {

	    if(ll.head==null) return false;
	    
	    if(ll.head.next==null) return true;//1 element ll
	    
	    //1-2-3-4-3-2-1 - palindrome -odd
	    //1-2-3-4-3-2-4 - not palindrome
	    //1-2-3-4-4-3-2-1 - even palindrome
	    
	    Stack<Integer> stack = new Stack<Integer>();
	    
	    SNode slow = ll.head;
	    SNode fast = ll.head.next.next;
	    
	    stack.push(slow.data);
	    
	    while(fast!=null && fast.next!=null) {    
	        slow = slow.next;
	        fast=fast.next.next;
	        stack.push(slow.data);
	    }
	    
	    //for odd palindrome:
	    //1-2-3-4-3-2-1
	    //slow set to 1
	    //fast set to 3
	    //we first push 1 to stack
	    //then slow set to 2
	    //fast set to (next) 3
	    //push 2 onto stack
	    //the slow set to 3
	    //fast set to (back) 1
	    //push 3 onto stack
	    //now fast.next ==null (but fast!=null)) 
	    //so we don't get to push 4 onto stack - but do we care as it;s the middle value?
	    
	    //for even palindroms:
	    //1-2-3-4-4-3-2-1
	    //slow set to 1
	    //fast set to 3
	    //push 1 onto stack
	    //slow set to 2
	    //fast set to (2nd) 4
	    //push 2 ont stack
	    //slow set to 3
	    //fast set to 2
	    //push 3 onto stack
	    //slow set to (1st) 4
	    //fast set to null
	    //push 4 onto stack
	    
	    if(fast!=null && fast.next==null) { //odd number 
	        slow=slow.next.next;//skip middle one - i.e. move to to 2nd 3 in first case
	    }
	    else slow=slow.next;//otherwise it's even so move 
	    
	    while(slow!=null) {  
	        Integer top = stack.pop();
	        if(top.intValue() != slow.data) {
	            return false;
	        }
	        slow=slow.next;
	    }
	    
	    return true;
	 }
}