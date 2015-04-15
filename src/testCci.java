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
    
    public final void testspaceReplace() {
    	String in = "Mr John Smith    ";
    	int len = 13;
    	String expected = "Mr%20John%20Smith";
    	
    	char[] input = in.toCharArray();
    	
    	Cci.spaceReplace(input,len);
    	
    	String result = new String(input);
    	
    	//System.out.println("Expected: " + result);
    	//System.out.println("Actual:   " + new String(input));
    	
    	assertEquals(expected,result);
    	
    }
    
    public final void testcompressString() {
    	String in = new String("aabcccccaaa");
    	String expected = new String("a2b1c5a3");
    	
    	String actual = Cci.compressString(in);
    	
    	assertEquals(expected,actual);
    	
    	in = "abcde";
    	expected = "abcde";
    	
    	actual = Cci.compressString(in);
    	
    	assertEquals(expected,actual);
    	
    }
    
    public final void testrotMatrix() {
    	int[][] test1 = new int[3][3];
    	int[][] exp1 = new int[3][3];
    	
    	//test1
    	//1 2 3
    	//4 5 6
    	//7 8 9
    	
    	//exp1
    	//7 4 1
    	//8 5 2
    	//9 6 3
    	
    	test1[0][0] = 1;
    	test1[0][1] = 2;
    	test1[0][2] = 3;
    	test1[1][0] = 4;
    	test1[1][1] = 5;
    	test1[1][2] = 6;
    	test1[2][0] = 7;
    	test1[2][1] = 8;
    	test1[2][2] = 9;
    	
    	exp1[0][0] = 7;
    	exp1[0][1] = 4;
    	exp1[0][2] = 1;
    	exp1[1][0] = 8;
    	exp1[1][1] = 5;
    	exp1[1][2] = 2;
    	exp1[2][0] = 9;
    	exp1[2][1] = 6;
    	exp1[2][2] = 3;
    	
    	int[][] test2 = new int[4][4];
    	int[][] exp2 = new int[4][4];

    	//test2
    	// 1, 2, 3, 4
    	// 5, 6, 7, 8
    	// 9,10,11,12
    	//13,14,15,16
    	
    	//exp2
    	//13, 9, 5, 1
    	//14,10, 6, 2
    	//15,11, 7, 3
    	//16,12, 8, 4    	
    	
    	test2[0][0] = 1;
    	test2[0][1] = 2;
    	test2[0][2] = 3;
    	test2[0][3] = 4;
    	test2[1][0] = 5;
    	test2[1][1] = 6;
    	test2[1][2] = 7;
    	test2[1][3] = 8;
    	test2[2][0] = 9;
    	test2[2][1] = 10;
    	test2[2][2] = 11;
    	test2[2][3] = 12;
    	test2[3][0] = 13;
    	test2[3][1] = 14;
    	test2[3][2] = 15;
    	test2[3][3] = 16;
    	
    	exp2[0][0] = 13;
    	exp2[0][1] = 9;
    	exp2[0][2] = 5;
    	exp2[0][3] = 1;
    	exp2[1][0] = 14;
    	exp2[1][1] = 10;
    	exp2[1][2] = 6;
    	exp2[1][3] = 2;
    	exp2[2][0] = 15;
    	exp2[2][1] = 11;
    	exp2[2][2] = 7;
    	exp2[2][3] = 3;
    	exp2[3][0] = 16;
    	exp2[3][1] = 12;
    	exp2[3][2] = 8;
    	exp2[3][3] = 4;
    	
    	Cci.rotMatrix(test1,3);
    	
    	//Cci.printMatrix(exp1,3);
    	//Cci.printMatrix(test1,3);
    	
    	for(int i = 0; i< 3; i++) {
    	    for(int j = 0; j<3; j++) {
    	        assertEquals(exp1[i][j],test1[i][j]);
    	    }
    	}
    	
    	
    	Cci.rotMatrix(test2,4);
    	
    	//Cci.printMatrix(exp2,4);
    	//Cci.printMatrix(test2,4);    	
    	
    	for(int i = 0; i< 4; i++) {
            for(int j = 0; j<4; j++) {
                assertEquals(exp2[i][j],test2[i][j]);
            }
        }    	
    }    
    
    public final void testzerorcs() {
        int[][] test1 = new int[4][4];
        int[][] exp1 = new int[4][4];
                
        //test1:
        //1 2 3 4
        //5 6 7 8
        //9 0 8 0
        //1 2 3 4
        test1[0][0]=1; test1[0][1]=2; test1[0][2] = 3; test1[0][3] = 4;
        test1[1][0] = 5; test1[1][1]=6; test1[1][2]=7; test1[1][3] = 8;
        test1[2][0] = 9; test1[2][1] = 0; test1[2][2]=8; test1[2][3]=0;
        test1[3][0] = 1; test1[3][1] = 2; test1[3][2]=3; test1[3][3]=4;
        
        //exp1:
        //1 0 3 0
        //5 0 7 0
        //0 0 0 0
        //1 0 3 0
        exp1[0][0] = 1; exp1[0][1] = 0; exp1[0][2]=3; exp1[0][3] = 0;
        exp1[1][0] = 5; exp1[1][1] = 0; exp1[1][2] = 7; exp1[1][3] = 0;
        exp1[2][0] = 0; exp1[2][1] = 0; exp1[2][2] = 0; exp1[2][3] = 0;
        exp1[3][0] = 1; exp1[3][1] = 0; exp1[3][2] = 3; exp1[3][3] = 0;
        
        Cci.zeroRCs(test1, 4, 4);
        
        //Cci.printMatrix(exp1,4);
        //Cci.printMatrix(test1,4);
        
        for(int i=0; i< 4; i++) {
        	for(int j=0;j<4; j++) {
        		assertEquals(exp1[i][j],test1[i][j]);
        	}
        }
        
    }
    
    public final void testisSubstring() {
        String s1 = "waterbottle";
        String s2 = "bottle";
        String s3 = "botel";
        
        assertTrue(Cci.isSubstring(s1,s2));
        assertFalse(Cci.isSubstring(s1,s3));
        assertTrue(Cci.isSubstring(s1,s1));
    }
    
    public final void testisRotation() {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        String s3 = "erbottlew";
        
        assertTrue(Cci.isRotation(s1,s2));
        assertTrue(Cci.isRotation(s1,s1));
        assertFalse(Cci.isRotation(s1,s3));
    }
    
    public final void testllDupRemove() {
        SlinkedList ll = new SlinkedList();
        
        SNode one = new SNode(1);
        SNode two = new SNode(2);
        SNode twoo = new SNode(2);
        SNode three = new SNode(3);
        SNode four = new SNode(4);
        SNode foour = new SNode(4);
        SNode fooour = new SNode(4);
        SNode twooo = new SNode(2);
        
        ll.insert(twooo);
        ll.insert(fooour);
        ll.insert(foour);
        ll.insert(four);
        ll.insert(three);
        ll.insert(twoo);
        ll.insert(two);
        ll.insert(one);
        
        Cci.llRemoveDupes(ll);
        
        SNode curnode = ll.head;
        
        System.out.println("Node one data:" + curnode.data);
        assertEquals(curnode,one);
        System.out.println("Node two data:" + curnode.next.data);
        assertEquals(curnode.next,two);
        System.out.println("Node three data:" + curnode.next.next.data);
        assertEquals(curnode.next.next,three);
        System.out.println("Node four data:" + curnode.next.next.next.data);
        assertEquals(curnode.next.next.next,four);
        assertEquals(curnode.next.next.next.next,null);
        
    }
}