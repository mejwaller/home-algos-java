//singly-linked list

//7 ops on collections:
//1. search
//2. insert
//3. delete
//4. max
//5. min
//6. next
//7. prev

class SlinkedList<T extends Comparable<T>> {
    
    SNode<T> head;
    
    public SlinkedList(){head = null;}
    
    public SNode<T> find(T n) {
        
        if(head==null) return null;
        
        SNode<T> curnode = head;
        
        while(curnode != null && !curnode.data.equals(n)) {
            curnode = curnode.next;
        }
        
        return curnode;//null if not found
    }
    
    public void insert(SNode<T> node) {
        node.next = head;
        head = node;
    }
    
    public void append(SNode<T> node) {
        
        if(head==null) {
            node.next=null;
            head = node;
            return;
        }
        
        SNode<T> curnode = head;        
        while(curnode.next != null) {
            curnode = curnode.next;
        }
        node.next=null;
        curnode.next = node;
    }
    
    //return deleted node
    public SNode<T> delete(T n) {
        if(head==null) return null;
        
        if(head.data==n) {
            head=head.next;
            return head;
        }
        
        SNode<T> curnode = head;
        SNode<T> retval = null;
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
    public SNode<T> max() {
        if(head==null) return null;
        
        SNode<T> curmax = head;
        SNode<T> curnode = head;
        while(curnode.next!=null) {
            if(curmax.data.compareTo(curnode.next.data) < 0) {
                curmax = curnode.next;
            }
            curnode = curnode.next;
        }
        
        return curmax;
    }
    
   //return node with max value
    public SNode<T> min() {
        if(head==null) return null;
        
        SNode<T> curmin = head;
        SNode<T> curnode = head;
        while(curnode.next!=null) {
            if(curmin.data.compareTo(curnode.next.data) > 0) {
                curmin = curnode.next;
            }
            curnode = curnode.next;
        }
        
        return curmin;
    }
    
    public SNode<T> getNext(T n) {
        SNode<T> cur = find(n);
        
        if(cur==null) return null;
        
        return cur.next;        
        
    }
    
    public SNode<T> getPrev(T n) {
        if(head==null) {
            return null;
        }
        
        SNode<T> curnode = head;
        
        while(curnode.next!=null) {
            if(curnode.next.data == n) {
                return curnode;
            }
            curnode = curnode.next;
        }
        
        return null;
        
    }

}

class SNode<T extends Comparable<T>>{
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((next == null) ? 0 : next.hashCode());
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
        SNode<T> other = (SNode<T>) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (next == null) {
            if (other.next != null)
                return false;
        } else if (!next.equals(other.next))
            return false;
        return true;
    }
    public SNode(T data) { this.data = data;}
    
    T data;
    SNode<T> next=null;
}