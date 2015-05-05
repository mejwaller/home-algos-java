package home.algosjava;
import junit.framework.TestCase;

public class LinkedListTest extends TestCase {
    
    public final void testDefaultConstruction() {
        
        LinkedList ll = new LinkedList();
    
        assertTrue(ll.isEmpty());
        
    }
    
    public final void testInsertNodes() {
        Node anode = new Node("a");
        Node bnode = new Node("b");
        Node cnode = new Node("c");
        Node dnode = new Node("d");
    
        LinkedList ll = new LinkedList();
        
        ll.insertNode(anode);
        ll.insertNode(bnode);
        ll.insertNode(cnode);
        ll.insertNode(dnode);
        
        assertEquals("d",ll.getFirst().name);
        assertEquals("a",ll.getLast().name);
        
        Node n = ll.getFirst();
        String [] names = new String[4];
        String[]  expected = {"d","c","b","a"};
        int i = 0;
                
        while(n!=null) {
            names[i] = n.name;
            i++;
            n = n.next;
        }
        
        for(i=0; i< 4; i++) {           
            assertEquals(expected[i],names[i]);
        }        
        
    }
    
    final public void testAppendNodes() {
        
        Node anode = new Node("a");
        Node bnode = new Node("b");
        Node cnode = new Node("c");
        Node dnode = new Node("d");
    
        LinkedList ll = new LinkedList();
        
        ll.appendNode(anode);
        ll.appendNode(bnode);
        ll.appendNode(cnode);
        ll.appendNode(dnode);
        
        assertEquals("a",ll.getFirst().name);
        assertEquals("d",ll.getLast().name);
        
        Node n = ll.getFirst();
        String [] names = new String[4];
        String[]  expected = {"a","b","c","d"};
        int i = 0;
                
        while(n!=null) {
            names[i] = n.name;
            i++;
            n = n.next;
        }
        
        for(i=0; i< 4; i++) {           
            assertEquals(expected[i],names[i]);
        }        
        
    }
    
}