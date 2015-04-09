import junit.framework.TestCase;

public class testSlinkedList extends TestCase {
    
    public final void testDefaultConstruction() {
        SlinkedList list = new SlinkedList();
        
        assertEquals(list.head,null);       
        
    }
    
    public final void testInsert() {
        SlinkedList list = new SlinkedList();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        
        list.insert(node3);
        list.insert(node2);
        list.insert(node1);
        
        assertEquals(list.head,node1);
        
        SNode test2 = list.head.next;
        
        assertEquals(node2,test2);
        
        SNode test3 = test2.next;
        assertEquals(node3,test3);
       
    }
    
    public final void testAppend() {
        SlinkedList list = new SlinkedList();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        
        list.append(node1);
        list.append(node2);
        list.append(node3);
        
        assertEquals(list.head,node1);
        
        SNode test2 = list.head.next;
        
        assertEquals(node2,test2);
        
        SNode test3 = test2.next;
        assertEquals(node3,test3);
    }
    
    public final void testFind() {
        SlinkedList list = new SlinkedList();
        
        for(int i=1; i<=6; i++) {
            list.insert(new SNode(i));
        }
        
        SNode expected = new SNode(4);
        
        SNode actual = list.find(4);
        
        assertEquals(expected,actual);
        
        assertNull(list.find(42));
       
    }
    
    public final void testDelete() {
        
        SlinkedList list = new SlinkedList();
        
        for(int i=1; i<=6; i++) {
            list.append(new SNode(i));
        }
        
        //check our val is there
        SNode toDelete = new SNode(4);
        
        assertEquals(toDelete,list.find(4));
        
        SNode afterdelete = list.delete(4);
        
        assertNull(list.find(4));
        
        SNode exp1 = new SNode(1);
        SNode exp2 = new SNode(2);
        SNode exp3 = new SNode(3);
        SNode exp4 = new SNode(5);
        SNode exp5 = new SNode(6);
                
        assertEquals(exp4,afterdelete);
        
        assertEquals(exp1,list.head);
        assertEquals(exp2,list.head.next);
        assertEquals(exp3,list.head.next.next);
        assertEquals(exp4,list.head.next.next.next);
        assertEquals(exp5,list.head.next.next.next.next);  
        
        toDelete = new SNode(1);
        
        assertEquals(list.head,toDelete);
        
        afterdelete = list.delete(toDelete.data);
        
        System.out.println("ToDelete:" + exp2.data);
        System.out.println("Afterdelete:" + afterdelete.data);
        
        assertEquals(exp2,afterdelete);
        
        assertEquals(exp2,list.head);
        assertEquals(exp3,list.head.next);
        assertEquals(exp4,list.head.next.next);
        assertEquals(exp5,list.head.next.next.next);
              
        
    }
    
    public final void testMax() {
        
        SNode n1 = new SNode(2);
        SNode n2 = new SNode(256);
        SNode n3 = new SNode(4);
        SNode n4 = new SNode(16);
        SNode n5 = new SNode(32);
        
        SlinkedList list = new SlinkedList();
        
        list.insert(n1);
        list.insert(n2);
        list.insert(n3);
        list.insert(n4);
        list.insert(n5);
        
        SNode max = list.max();
        
        assertEquals(n2,max);
        
    }
    
    public final void testMin() {
        
        SNode n1 = new SNode(2);
        SNode n2 = new SNode(256);
        SNode n3 = new SNode(4);
        SNode n4 = new SNode(16);
        SNode n5 = new SNode(32);
        
        SlinkedList list = new SlinkedList();
        
        list.insert(n1);
        list.insert(n2);
        list.insert(n3);
        list.insert(n4);
        list.insert(n5);
        
        SNode min = list.min();
        
        assertEquals(n1,min);
        
    }
    
    public final void testNext() {
        
        SNode n1 = new SNode(2);
        SNode n2 = new SNode(256);
        SNode n3 = new SNode(4);
        SNode n4 = new SNode(16);
        SNode n5 = new SNode(32);
        
        SlinkedList list = new SlinkedList();
        
        list.insert(n1);//2
        list.insert(n2);//256
        list.insert(n3);//4
        list.insert(n4);//16
        list.insert(n5);//32
        
        SNode expected = n4;
        SNode actual = list.getNext(32);//one after n5
        
        assertEquals(expected,actual);
        
    }
    
    public final void testPrev() {
        
        SNode n1 = new SNode(2);
        SNode n2 = new SNode(256);
        SNode n3 = new SNode(4);
        SNode n4 = new SNode(16);
        SNode n5 = new SNode(32);
        
        SlinkedList list = new SlinkedList();
        
        list.insert(n1);//2
        list.insert(n2);//256
        list.insert(n3);//4
        list.insert(n4);//16
        list.insert(n5);//32
        
        SNode expected = n4;
        SNode actual = list.getPrev(4);//one before n3
        
        assertEquals(expected,actual);
        
    }
        
        
    
    
}