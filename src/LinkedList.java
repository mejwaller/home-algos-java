public class LinkedList {
    private Node first,last;
    
    public LinkedList() {
        first = last = null;
    }
    
    public void clear() {
        first=last=null;
    }
    
    public boolean isEmpty()
    {
        return first==null;
    }
    
    private void addFirst(Node node) 
    {
        first = last = node;
        first.next = null;
        first.prev=null;
        last.next=null;
        last.prev=null;        
    }
    
    //appends a node at the end
    public void appendNode(Node node) {
        if(isEmpty()) {
            addFirst(node);
        }
        else {            
            last.next = node;            
            node.prev=last;
            node.next=null;
            last = node;            
        }
        
    }
    
    //insert a node at the start
    public void insertNode(Node node) {
        if(isEmpty()) {
            addFirst(node);
        }
        else {
            first.prev = node;            
            node.prev = null;
            node.next = first;
            first = node;
        }
        
    }
    
    public Node getFirst() {
        return first;
    }
    
    public Node getLast() {
        return last;
    }
    
}

class Node {
    
    public String name = "";
    
    public Node(String name) {
        this.name = name;
    }
    
    public void print() {
        System.out.println(name);
    }
    
    public Node next=null;
    public Node prev=null;

}