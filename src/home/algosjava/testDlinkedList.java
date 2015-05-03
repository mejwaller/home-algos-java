package home.algosjava;
import junit.framework.TestCase;

public class testDlinkedList extends TestCase {
    
    public final void testDefaultConstruction() {
        DlinkedList list = new DlinkedList();
        
        assertEquals(list.head,null);        
    }
    
    public final void testInsert() {
        DNode n1 = new DNode(1);
        DNode n2 = new DNode(2);
        DNode n3 = new DNode(3);
        
        DlinkedList list = new DlinkedList();
        
        list.insert(n3);
        list.insert(n2);
        list.insert(n1);
        
        assertEquals(list.head,n1);
        assertEquals(list.head.next,n2);
        assertEquals(list.head.prev,null);
        assertEquals(list.head.next.prev,n1);
        assertEquals(list.head.next.next,n3);
        assertEquals(list.head.next.next.prev,n2);
        assertEquals(list.head.next.next.next,null);       
        
    }
    
    public final void testAppend() {
        DNode n1 = new DNode(1);
        DNode n2 = new DNode(2);
        DNode n3 = new DNode(3);
        
        DlinkedList list = new DlinkedList();
        
        list.append(n1);
        list.append(n2);
        list.append(n3);
        
        assertEquals(list.head,n1);
        assertEquals(list.head.next,n2);
        assertEquals(list.head.prev,null);
        assertEquals(list.head.next.prev,n1);
        assertEquals(list.head.next.next,n3);
        assertEquals(list.head.next.next.prev,n2);
        assertEquals(list.head.next.next.next,null);  
        
    }
    
    public final void testFind() {
               
        DlinkedList list = new DlinkedList();
        
        for(int i = 6; i > 0; i--) {
            list.insert(new DNode(i));            
        }
        
        DNode expected = new DNode(4);
        
        assertEquals(expected,list.find(4));
        assertEquals(null,list.find(7));
        
    }
    
    public final void testDelete() {
        
        DlinkedList list = new DlinkedList();
        
        for(int i = 5; i > 0; i--) {
            list.insert(new DNode(i));
        }
        
        DNode expected = new DNode(4);
        DNode actual = list.delete(4);
        
        assertEquals(expected,actual);
        
        expected = new DNode(3);
        DNode prev = list.find(3);
        DNode next = list.find(5);
        
        //check it's found!
        assertEquals(expected,prev);
        assertEquals(next,prev.next); 
        assertEquals(prev,next.prev);
        
        //assertEquals(prev.next,list.find(5));
        //assertEquals(list.find(5).prev,list.find(3));
    
    }
    
    public final void testMax() {
        
        DNode n1 = new DNode(1);
        DNode n2 = new DNode(16);
        DNode n3 = new DNode(256);
        DNode n4 = new DNode(234);
        DNode n5 = new DNode(4);
        
        DlinkedList list = new DlinkedList();
        list.insert(n5);
        list.insert(n4);
        list.insert(n3);
        list.insert(n2);
        list.insert(n1);
        
        assertEquals(n3,list.max());
        
    }
    
    public final void testMin() {
        
        DNode n1 = new DNode(1);
        DNode n2 = new DNode(16);
        DNode n3 = new DNode(256);
        DNode n4 = new DNode(234);
        DNode n5 = new DNode(4);
        
        DlinkedList list = new DlinkedList();
        
        list.insert(n1);
        list.insert(n2);
        list.insert(n3);
        list.insert(n4);
        list.insert(n5);
        
        assertEquals(n1,list.min());
        
    }
    
    public final void testNext() {
        
        DNode n1 = new DNode(1);
        DNode n2 = new DNode(16);
        DNode n3 = new DNode(256);
        DNode n4 = new DNode(234);
        DNode n5 = new DNode(4);
        
        DlinkedList list = new DlinkedList();
        
        list.insert(n1);
        list.insert(n2);
        list.insert(n3);
        list.insert(n4);
        list.insert(n5);
        
        assertEquals(n2,n3.next);
        
    }
    
    public final void testPrev() {
        
        DNode n1 = new DNode(1);
        DNode n2 = new DNode(16);
        DNode n3 = new DNode(256);
        DNode n4 = new DNode(234);
        DNode n5 = new DNode(4);
        
        DlinkedList list = new DlinkedList();
        
        list.insert(n1);
        list.insert(n2);
        list.insert(n3);
        list.insert(n4);
        list.insert(n5);
        
        assertEquals(n4,n3.prev);
        
    }
    
    
}
