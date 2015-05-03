package home.algosjava;
import junit.framework.TestCase;

public class testSlinkedList extends TestCase {
    
    public final void testDefaultConstruction() {
        SlinkedList<Integer> list = new SlinkedList<>();
        
        assertEquals(list.head,null);       
        
    }
    
    public final void testInsert() {
        SlinkedList<Integer> list = new SlinkedList<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        SNode<Integer> node3 = new SNode<>(3);
        
        list.insert(node3);
        list.insert(node2);
        list.insert(node1);
        
        assertEquals(list.head,node1);
        
        SNode<Integer> test2 = list.head.next;
        
        assertEquals(node2,test2);
        
        SNode<Integer> test3 = test2.next;
        assertEquals(node3,test3);
       
    }
    
    public final void testAppend() {
        SlinkedList<Integer> list = new SlinkedList<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        SNode<Integer> node3 = new SNode<>(3);
        
        list.append(node1);
        list.append(node2);
        list.append(node3);
        
        assertEquals(list.head,node1);
        
        SNode<Integer> test2 = list.head.next;
        
        assertEquals(node2,test2);
        
        SNode<Integer> test3 = test2.next;
        assertEquals(node3,test3);
    }
    
    public final void testFind() {
        SlinkedList<Integer> list = new SlinkedList<>();
        
        for(int i=1; i<=6; i++) {
            list.insert(new SNode<Integer>(i));
        }
        
        SNode<Integer> expected = new SNode<>(4);
        
        SNode<Integer> actual = list.find(4);
        
        assertEquals(expected,actual);
        
        assertNull(list.find(42));
       
    }
    
    public final void testDelete() {
        
        SlinkedList<Integer> list = new SlinkedList<>();
        
        for(int i=1; i<=6; i++) {
            list.append(new SNode<Integer>(i));
        }
        
        //check our val is there
        SNode<Integer> toDelete = new SNode<>(4);
        
        assertEquals(toDelete,list.find(4));
        
        SNode<Integer> afterdelete = list.delete(4);
        
        assertNull(list.find(4));
        
        SNode<Integer> exp1 = new SNode<>(1);
        SNode<Integer> exp2 = new SNode<>(2);
        SNode<Integer> exp3 = new SNode<>(3);
        SNode<Integer> exp4 = new SNode<>(5);
        SNode<Integer> exp5 = new SNode<>(6);
        
        System.out.println("After data:" + afterdelete.data + "Deleted data:" + toDelete.data);
                
        assertEquals(afterdelete,toDelete);
        
        assertEquals(exp1,list.head);
        assertEquals(exp2,list.head.next);
        assertEquals(exp3,list.head.next.next);
        assertEquals(exp4,list.head.next.next.next);
        assertEquals(exp5,list.head.next.next.next.next);  
        
        toDelete = new SNode<Integer>(1);
        
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
        
        SNode<Integer> n1 = new SNode<>(2);
        SNode<Integer> n2 = new SNode<>(256);
        SNode<Integer> n3 = new SNode<>(4);
        SNode<Integer> n4 = new SNode<>(16);
        SNode<Integer> n5 = new SNode<>(32);
        
        SlinkedList<Integer> list = new SlinkedList<>();
        
        list.insert(n1);
        list.insert(n2);
        list.insert(n3);
        list.insert(n4);
        list.insert(n5);
        
        SNode<Integer> max = list.max();
        
        assertEquals(n2,max);
        
    }
    
    public final void testMin() {
        
        SNode<Integer> n1 = new SNode<>(2);
        SNode<Integer> n2 = new SNode<>(256);
        SNode<Integer> n3 = new SNode<>(4);
        SNode<Integer> n4 = new SNode<>(16);
        SNode<Integer> n5 = new SNode<>(32);
        
        SlinkedList<Integer> list = new SlinkedList<>();
        
        list.insert(n1);
        list.insert(n2);
        list.insert(n3);
        list.insert(n4);
        list.insert(n5);
        
        SNode<Integer> min = list.min();
        
        assertEquals(n1,min);
        
    }
    
    public final void testNext() {
        
        SNode<Integer> n1 = new SNode<>(2);
        SNode<Integer> n2 = new SNode<>(256);
        SNode<Integer> n3 = new SNode<>(4);
        SNode<Integer> n4 = new SNode<>(16);
        SNode<Integer> n5 = new SNode<>(32);
        
        SlinkedList<Integer> list = new SlinkedList<>();
        
        list.insert(n1);//2
        list.insert(n2);//256
        list.insert(n3);//4
        list.insert(n4);//16
        list.insert(n5);//32
        
        SNode<Integer> expected = n4;
        SNode<Integer> actual = list.getNext(32);//one after n5
        
        assertEquals(expected,actual);
        
    }
    
    public final void testPrev() {
        
        SNode<Integer> n1 = new SNode<>(2);
        SNode<Integer> n2 = new SNode<>(256);
        SNode<Integer> n3 = new SNode<>(4);
        SNode<Integer> n4 = new SNode<>(16);
        SNode<Integer> n5 = new SNode<>(32);
        
        SlinkedList<Integer> list = new SlinkedList<>();
        
        list.insert(n1);//2
        list.insert(n2);//256
        list.insert(n3);//4
        list.insert(n4);//16
        list.insert(n5);//32
        
        SNode<Integer> expected = n4;
        SNode<Integer> actual = list.getPrev(4);//one before n3
        
        assertEquals(expected,actual);
        
    }
        
        
    
    
}