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

		//move down rows
		for(int i = 0 ; i<layers; i++) {
			//top left of layer I will be at row and column 0+i
			//top right will be at row0+i and col n-1-i
			//bottom right will be at row and column n-1-i
			//bottom left will be at row n-1-i and column 0+i
			//90 deg rotation (clockwise) we move topleft->topright->bottomright-> bottomleft
			//so lets do corners first and go on from there

			//store top right in tmp and set it to top left:
			int temp =  img[i][n-1-i];
			img[i][n-1-1] = img[i][i];
			//store temp in moved pos (top left)
			img[i][i] = temp;
			//store  bottom right in temp
			temp = img[n-1-i][n-1-i];
			img[n-1-i][n-1-i] = img[i][i];		
			//put bottom left in top left
			img[i][i] = img[n-1-i][i];
			//set botom left from temp
			img[n-1-i][i] = temp;

			




			//now, for layer I we have row start = I, and col start = I
			//row end  n-1-i, col end = n-1-i
			for(int j=i; j< n-1-i; j++) {//move along cols initally			
				//store target index in temp – 1st target will be row j and column n-1-i
				temp = img[j][n-1-j];
				img[j][n-1-j] = img[i][j];
				//store next val in previous val
				img[i][j] = img[n-1-i][n-1-j];
				//set that to temp
				img[n-1-i][n-1-j] = temp;
				temp = img [n-1-j][j];
				img[n-1-j][j] = img[i][j];
				img[i][j] = temp;
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