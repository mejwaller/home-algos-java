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
        
        //System.out.println("Node one data:" + curnode.data);
        assertEquals(curnode,one);
        //System.out.println("Node two data:" + curnode.next.data);
        assertEquals(curnode.next,three);//NOT two as first 2 twos will get deleted (1st found are deleted)
       //System.out.println("Node three data:" + curnode.next.next.data);
        assertEquals(curnode.next.next,four);
        //System.out.println("Node four data:" + curnode.next.next.next.data);
        assertEquals(curnode.next.next.next,two);
        assertEquals(curnode.next.next.next.next,null);
        
    }
    
    public final void testkthtolast() {
        SlinkedList ll = new SlinkedList();
        
        
        //7 nodes
        for(int i=1;i<=7;i++) {
            ll.append(new SNode(i));
        }
        
        SNode actual = Cci.kthtolast(ll,3);
        
        //1-2-3-4-5-6-7 - 3rd to last is 5
        SNode expected = new SNode(5);
        
        assertEquals(expected,actual);
        
        actual = Cci.kthtolast(ll,8);
        assertNull(actual);
        
        expected = new SNode(1);
        actual = Cci.kthtolast(ll,7);
        //check my indexing and counting is correct...
        assertEquals(expected,actual);
    }
    
    public final void testPartition() {
        
        SlinkedList llin = new SlinkedList();
        
        SlinkedList expected = new SlinkedList();
        
        //set up a llist as:
        //8-7-4-1-2-3-5
        llin.insert(new SNode(5));
        llin.insert(new SNode(3));
        llin.insert(new SNode(2));
        llin.insert(new SNode(1));
        llin.insert(new SNode(4));
        llin.insert(new SNode(7));
        llin.insert(new SNode(8));
        
        //partitioning around 4 should result in 
        //3-2-1-8-7-4-5 (that order - vals either side of partition are appended and inserted as we go)
        expected.insert(new SNode(5));
        expected.insert(new SNode(4));
        expected.insert(new SNode(7));
        expected.insert(new SNode(8));
        expected.insert(new SNode(1));
        expected.insert(new SNode(2));
        expected.insert(new SNode(3));
        
        SlinkedList actual = Cci.partition(llin,4);
        
        SNode ecurnode = expected.head;
        SNode acurnode = actual.head;
        
        while(ecurnode!=null) {
            //System.out.println("Expected: " + ecurnode.data + " Actual: " + acurnode.data);
            assertEquals(ecurnode,acurnode);
            ecurnode=ecurnode.next;
            acurnode=acurnode.next;
        }
    }
    
    public final void testAdd() {
        SlinkedList left = new SlinkedList();
        SlinkedList right = new SlinkedList();
        SlinkedList expected = new SlinkedList();
        
        //left = 9969
        //right 345
        //expected=10314
        left.insert(new SNode(9));
        left.insert(new SNode(9));
        left.insert(new SNode(6));
        left.insert(new SNode(9));
        
        right.insert(new SNode(3));
        right.insert(new SNode(4));
        right.insert(new SNode(5));
        
        expected.insert(new SNode(1));
        expected.insert(new SNode(0));
        expected.insert(new SNode(3));
        expected.insert(new SNode(1));
        expected.insert(new SNode(4));
        
        SlinkedList actual = Cci.add(left,right);
        
        SNode ecurnode = expected.head;
        SNode acurnode = actual.head;
        
        while(ecurnode!=null) { 
            //System.out.println("Expected: " + ecurnode.data + " Actual: " + acurnode.data);
            assertEquals(ecurnode,acurnode);
            ecurnode=ecurnode.next;
            acurnode=acurnode.next;
        }
    }
    
    public final void testAddV2() {
        SlinkedList left = new SlinkedList();
        SlinkedList right = new SlinkedList();
        SlinkedList expected = new SlinkedList();
        
        //left = 9969
        //right 345
        //expected=10314
        left.append(new SNode(9));
        left.append(new SNode(9));
        left.append(new SNode(6));
        left.append(new SNode(9));
        
        right.append(new SNode(3));
        right.append(new SNode(4));
        right.append(new SNode(5));
        
        expected.append(new SNode(1));
        expected.append(new SNode(0));
        expected.append(new SNode(3));
        expected.append(new SNode(1));
        expected.append(new SNode(4));
        
        SlinkedList actual = Cci.addV2(left,right);
        
        SNode ecurnode = expected.head;
        SNode acurnode = actual.head;
        
        while(ecurnode!=null) { 
            //System.out.println("Expected: " + ecurnode.data + " Actual: " + acurnode.data);
            assertEquals(ecurnode,acurnode);
            ecurnode=ecurnode.next;
            acurnode=acurnode.next;
        }
    }
    
    public final void testGetRepeat() {
        
        SlinkedList circ = new SlinkedList();
        
        SNode n1 = new SNode(1);
        SNode n2 = new SNode(2);
        SNode n3 = new SNode(3);
        SNode n4 = new SNode(4);
        SNode n5 = new SNode(5);
        
        circ.append(n1);
        circ.append(n2);
        circ.append(n3);
        circ.append(n4);
        circ.append(n5);
        n5.next = n3;
        
        assertEquals(n3,Cci.getRepeated(circ));
        
        SlinkedList empty = new SlinkedList();
        
        assertNull(Cci.getRepeated(empty));
        
        SlinkedList ok = new SlinkedList();
        
        for(int i=1;i<5;i++) {
            ok.append(new SNode(i));
        }
        
        assertNull(Cci.getRepeated(ok));
    }
}