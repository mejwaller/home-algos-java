//singly-linked lsit

//7 ops on collections:
//1. search
//2. insert
//3. delete
//4. max
//5. min
//6. next
//7. prev

class SlinkedList {
    
    SNode head;
    
    public SlinkedList(){head = null;}
    
    public SNode find(int n) {
        
        if(head==null) return null;
        
        SNode curnode = head;
        
        while(curnode != null && curnode.data != n) {
            curnode = curnode.next;
        }
        
        return curnode;//null if not found
    }
    
    public void insert(SNode node) {
        node.next = head;
        head = node;
    }
    
    public void append(SNode node) {
        
        if(head==null) {
            node.next=null;
            head = node;
            return;
        }
        
        SNode curnode = head;        
        while(curnode.next != null) {
            curnode = curnode.next;
        }
        node.next=null;
        curnode.next = node;
    }
    
    //return node after deleted node
    public SNode delete(int n) {
        if(head==null) return null;
        
        if(head.data==n) {
            head=head.next;
            return head;
        }
        
        SNode curnode = head;
        while(curnode.next!=null) {
            if(curnode.next.data == n) {
                curnode.next = curnode.next.next;
                return curnode.next;
            }
            curnode = curnode.next;
        }
        
        return null;
        
    }

}

class SNode{
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + data;
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SNode other = (SNode) obj;
        if (data != other.data)
            return false;
        return true;
    }
    
    public SNode(int data) { this.data = data;}
    
    int data;
    SNode next=null;
}