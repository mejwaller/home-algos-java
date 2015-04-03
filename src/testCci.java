import junit.framework.TestCase;

public class testCci extends TestCase {
    
    public final void testhasUniqueChars() {
    	
    	String one = "abcdefghi";
    	String two = "abcdefgf";
    	
    	assertTrue(Cci.hasUniqueChars(one));
    	assertFalse(Cci.hasUniqueChars(two));
    	
    	
    }
    
    public final void testisPermutation() {
    	String a = "aabcdefg";
    	String b = "abc";
    	String c = "abcdefh";
    	String d = "gacbfade";
    	String e = "aabcdefg";
    	
    	assertTrue(Cci.isPermutation(a,d));
    	assertTrue(Cci.isPermutation(a, e));
    	assertFalse(Cci.isPermutation(a,b));
    	assertFalse(Cci.isPermutation(a,c));
    	
    }
    
}