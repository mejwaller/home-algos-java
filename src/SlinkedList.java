//singly-linked list

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
    
    //return deleted node
    public SNode delete(int n) {
        if(head==null) return null;
        
        if(head.data==n) {
            head=head.next;
            return head;
        }
        
        SNode curnode = head;
        SNode retval = null;
        while(curnode.next!=null) {
            if(curnode.next.data == n) {
                retval = curnode.next;
                curnode.next = curnode.next.next;
                return retval;
            }
            curnode = curnode.next;
        }
        
        return retval;
        
    }
    
   //return node with max value
    public SNode max() {
        if(head==null) return null;
        
        SNode curmax = head;
        SNode curnode = head;
        while(curnode.next!=null) {
            if(curmax.data < curnode.next.data) {
                curmax = curnode.next;
            }
            curnode = curnode.next;
        }
        
        return curmax;
    }
    
   //return node with max value
    public SNode min() {
        if(head==null) return null;
        
        SNode curmin = head;
        SNode curnode = head;
        while(curnode.next!=null) {
            if(curmin.data > curnode.next.data) {
                curmin = curnode.next;
            }
            curnode = curnode.next;
        }
        
        return curmin;
    }
    
    public SNode getNext(int n) {
        SNode cur = find(n);
        
        if(cur==null) return null;
        
        return cur.next;        
        
    }
    
    public SNode getPrev(int n) {
        if(head==null) {
            return null;
        }
        
        SNode curnode = head;
        
        while(curnode.next!=null) {
            if(curnode.next.data == n) {
                return curnode;
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