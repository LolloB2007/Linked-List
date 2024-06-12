package com.mycompany.linkedlistclass;

/**
 *
 * @author lorenzobarbagelata
 * COMPLETE class with Node within (single file)
 * Working methods:
    setHead
    getHead
    addNodeAfterHead
    add --> adds after Node given as param
    add --> adds at end
    toString
    backwardsToString
    size
    equals
    getNext
    resetNext
    remove
    set
    get
    indexOf
    find
 * @param <T>
 */
public class LinkedList<T>{
    
    public class Node<T>
    {
    
        private T data;
        private Node next;

        public Node(T data)
        {
            this.data = data;
            next = null;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public String toString()
        {
            return "" + data;
        }
        
    }
    
    private Node head;
    private Node current = null;
    
    public LinkedList()
    {
        head = null;
    }
    
    public LinkedList(Node head)
    {
        this.head = head;
    }
    
    public void setHead(Node head)
    {
        if(head==null)
        {
            this.head = head;
        }
        
        else
        {
            Node temp = head;
            head.setNext(this.head);
            this.head = temp;
        }
    }
    
    public void setHead(int data)
    {
        Node temp = new Node(data);
        
        if(head==null)
        {
            this.head = temp;
        }
        
        else
        {
            Node tempp = temp;
            temp.setNext(this.head);
            this.head = tempp;
        }
    }
    
    public Node getHead()
    {
        return head;
    }
    
    public void addNodeAfterHead(T data)
    {
        if(head==null){head=new Node(data);}
        
        else{
            Node temp = new Node(data);
            temp.setNext(head.getNext());
            head.setNext(temp);
        }
        
    }
    
    public void addNodeAfterHead(Node node)
    {
        if(head==null){head=node;}
        
        else{
            node.setNext(head.getNext());
            head.setNext(node);
        }
        
    }
    
    public void add(Node prev, T data)
    {
        if(head==null){head=new Node(data);}
        
        else
        {
            Node temp = new Node(data);
            temp.setNext(prev.getNext());
            prev.setNext(temp);
        }
    }
    
    
    public void add(int prevv, T data)
    {
        if(prevv>=size()){System.out.println("Error: index out of bounds"); return;}
        
        Node prev = get(prevv);
        
        if(head==null){head=new Node(data);}
        
        else
        {
            Node temp = new Node(data);
            temp.setNext(prev.getNext());
            prev.setNext(temp);
        }
    }
    
    
    public void add(Node prev, Node theNew)
    {
        if(head==null){head=theNew;}
        
        else
        {
            theNew.setNext(prev.getNext());
            prev.setNext(theNew);
        }
    }
    
    public void add(T data)
    {
        if(head==null)
        {
            head = new Node(data);
            return;
        }
        
        Node temp = new Node(data);
        Node current = head;
        
        boolean notEnd = true;
        
        while(notEnd)
        {
            if(current.getNext()==null){notEnd=false;}
            
            else
            {
                current = current.getNext();
            }
        }
        
        current.setNext(temp);
        
    }
    
    public void add(Node data)
    {
        if(head==null)
        {
            head = data;
            return;
        }
        
        Node temp = data;
        Node current = head;
        
        boolean notEnd = true;
        
        while(notEnd)
        {
            if(current.getNext()==null){notEnd=false;}
            
            else
            {
                current = current.getNext();
            }
        }
        
        current.setNext(temp);
        
    }
    
    public void addBefore(Node after, Node value)
    {
        if(head==null){head = value;}
        
        if(indexOf(after)==-1){System.out.println("Error: invalid position."); return;}
        
            int loc = indexOf(after);
            Node temp = get(loc-1);
            
            value.setNext(after);
            temp.setNext(value);
        
    }
    
    public void addBefore(Node after, T valu)
    {
        Node value = new Node(valu);
        
        if(head==null){head = value;}
        
        if(indexOf(after)==-1){System.out.println("Error: invalid position.");return;}

            int loc = indexOf(after);
            Node temp = get(loc-1);
            
            value.setNext(after);
            temp.setNext(value);

    }
    
    public void addBefore(int afte, Node value)
    {
        Node after = get(afte);
        
        if(head==null){head = value;}
        
        if(indexOf(after)==-1){System.out.println("Error: invalid position."); return;}
        
            int loc = indexOf(after);
            Node temp = get(loc-1);
            
            value.setNext(after);
            temp.setNext(value);
        
    }
    
    public String toString()
    {
        if(head==null){return "Linked List is empty";}
        if(head.getNext()==null){return "" + head.getData();}
        
        Node temp = head;
        
        String answer = "" + temp.getData();
        
        while(temp.getNext() != null)
        {
            temp = temp.getNext();
            
            answer += " " + temp.getData();
        }
        
        return answer;
    }
    
    public String backwardsToString()
    {
        if(head == null){return "Linked List is empty";}
        
        if(head.getNext()==null){return "" + head.getData();}
        
        return (backwardsToString(head.getNext())) + " " + head.getData();
    }
    
    private String backwardsToString(Node node) //aids backwards toString
    {
        if(node.getNext()==null){return "" + node.getData();}
        
        return (backwardsToString(node.getNext())) + " " + node.getData();
    }
 
    public int size()
    {
        if(head==null){return 0;}
        
        if(head.getNext()==null){return 1;}
        
        return 1 + size(head.getNext());
    }
    
    private int size(Node node) //aids size w/ no param
    {
        if(node.getNext()==null){return 1;}
        
        return 1 + size(node.getNext());
    }
    
    public boolean equals(LinkedList other)
    {
        if(size()!=other.size()){return false;}
        
        if(head.getData()==other.getHead().getData() && equals(head.getNext(), other.getHead().getNext())){return true;}
        
        return false;
    }
    
    private boolean equals(Node theThis, Node theOther)//completes .equals
    {
        if(theThis.getData()==theOther.getData() && theThis.getNext()==null && theOther.getNext()==null)
        {
            return true;
        }
        
        if(theThis.getData()==theOther.getData() && equals(theThis.getNext(), theOther.getNext()))
        {
            return true;
        }
        
        return false;
    }
    
    public Node getNext()
    {
        if(current == null){current = head; return current;}
        
        current = current.getNext();
        return current;
    }
    
    public void resetNext()
    {
        current = null;
    }
    
    public Node get(int i)
    {
        resetNext();
        
        Node temp = null;
        
        for(int j = -1; j<i; j++)
        {
            temp = getNext();
        }
        
        return temp;
    }
    
    public void remove(int i)
    {
        if(i == 0)
        {
            head = get(1);
            return;
        }
        
        Node toRem = get(i);
        Node prev = get(i-1);
        Node after = get(i+1);
        
        prev.setNext(after);
    }
    
    public void set(int i, T data)
    {
        get(i).setData(data);
    }
    
    /*
    public void sort()
    {
        for(int j = 1; j<size(); j++)//sorts everything except first
        {
            T min = get(j).getData();
            String total = min + " " + j;
            
            for(int i = 1; i<size()-j; i++)
            {
                int temp = get(j+i).getData();
                if(min>temp)
                {
                    min = get(j+i).getData();
                    total = min + " " + (j+i);
                }
            }
            
            if(get(j).getData()==min)
            {
                
            }
            
            else
            {
                int indexOfMin = Integer.parseInt(total.substring(total.indexOf(" ")+1));
                int smaller = min;
                int bigger = get(j).getData();
                set(j, smaller);
                set(indexOfMin, bigger);//previous min value, so here
            }
        }
        
        resetNext();
        
        Node current = head;
        
        for(int i = 0; i<size(); i++)
        {
            while(current.getNext()!=null)//sorting first number
            {
                current = current.getNext();
                if(get(i).getData()>current.getData())
                {
                    add(current, get(i).getData());
                    remove(i);
                }
            }
        }
        
    }
    
    */
    
    public boolean find(T x)
    {
        resetNext();
        
        Node current = head;
        boolean isFound = false;
        
        while(current.getNext()!=null && !isFound)
        {
            if(current.getData()==x)
            {
                isFound = true;
            }
            
            current = current.getNext();
        }
        
        return isFound;
    }
    
    public int indexOf(T x)
    {
        resetNext();
        
        Node current = head;
        boolean isFound = false;
        int i = -1;
        
        while(current.getNext()!=null && !isFound)
        {
            i++;
            if(current.getData()==x)
            {
                isFound = true;
            }
            
            current = current.getNext();
        }
        
        if(!isFound)
        {
            return -1;
        }
        
        return i;
        
    }
    
    public int indexOf(Node x)
    {
        resetNext();
        
        Node current = head;
        boolean isFound = false;
        int i = -1;
        
        while(current.getNext()!=null && !isFound)
        {
            i++;
            if(current.getData()==x.getData())
            {
                isFound = true;
            }
            
            current = current.getNext();
        }
        
        if(!isFound)
        {
            return -1;
        }
        
        return i;
    }     

}
