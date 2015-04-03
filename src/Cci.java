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
	
}