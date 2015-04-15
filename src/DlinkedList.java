//doubly-linked list

//7 ops on collections:
//1. search
//2. insert//append
//3. delete
//4. max
//5. min
//6. next
//7. prev

class DlinkedList {
    
    DNode head;
    
    public DlinkedList(){head = null;}
    
    public void insert(DNode newNode) {
        
        if(head==null) {            
            newNode.next=null;
            newNode.prev=null;
            head=newNode;
            return;                            
        }
        
        newNode.next= head;
        newNode.prev=null;
        head.prev = newNode;
        head=newNode;
    }
    
    public void append(DNode newNode) {
        
        if(head == null) {
            newNode.next=null;
            newNode.prev=null;
            head=newNode;
            return; 
        }
        
        DNode curnode = head;
        
        while(curnode.next!=null) {
            curnode=curnode.next;
        }
        
        newNode.next=null;
        newNode.prev=curnode;
        curnode.next=newNode;        
    }
    
    public DNode find(int n) {
        if(head==null) return null;
        if(head.data == n) return head;
        
        DNode curnode = head;
        while(curnode.next!=null) {
            if(curnode.next.data==n) return curnode.next;
            curnode = curnode.next;
        }
        
        return null;
        
    }
    
    public DNode delete(int n) {
        
        DNode retval = null;
        
        if(head==null) return retval;
        
        DNode curnode = head;
        
        while(curnode!=null) {
            if(curnode.data==n) {
                retval = curnode;
                if(curnode.prev!=null){
                    curnode.prev.next = curnode.next;
                }
                if(curnode.next!=null){
                    curnode.next.prev = curnode.prev;
                }
                
                //remove and return first found only
                return retval;
            }
            curnode = curnode.next;
        }
                
        return retval;        
    }
    
    public DNode max() {
    	
    	if(head == null) return null;
    	
    	DNode curnode=head;
    	DNode retnode = head;
    	
    	int max = head.data;
    	
    	curnode = head.next;
    	while(curnode!=null) {
    		if(curnode.data>max) {
    			max = curnode.data;
    			retnode = curnode;
    		}
    		curnode=curnode.next;
    	}
    	
    	return retnode;
    	
    }
    
    public DNode min() {
    	
    	if(head == null) return null;
    	
    	DNode curnode=head;
    	DNode retnode = head;
    	
    	int min = head.data;
    	
    	curnode = head.next;
    	while(curnode!=null) {
    		if(curnode.data<min) {
    			min = curnode.data;
    			retnode = curnode;
    		}
    		curnode=curnode.next;
    	}
    	
    	return retnode;
    	
    }
}

class DNode {
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
        DNode other = (DNode) obj;
        if (data != other.data)
            return false;
        return true;
    }

    int data;
   
    public DNode(int data){this.data = data;}
    
    DNode next = null;
    DNode prev = null;
    
}