//code answers (Java) to 'Cracking the Code Interview'

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
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
				
				
				
}