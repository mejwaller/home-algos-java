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
            list.insert(new SNode(i));
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
        
    }
}