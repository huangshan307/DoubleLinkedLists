/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


import son.util.EmptyListException;

/**
 *
 * @author SONPH
 * @param <E> Object
 */
public class LinkedList<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int size;
    
    /**
     * Get size of the list
     * @return Return number element in the list, 0 when the list is empty
     */
    public int size() {
        return size;
    }
    
    /**
     * Create an empty list
     */
    public LinkedList() {
        head = tail = null;
        size = 0;
    }
    
    /**
     * Check element is list
     * @return Return true if the list includes no element and false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Add to head of the list
     * @param info The object is added
     */
    public void addToHead(E info) {
        Node p = new Node(info);

        if (isEmpty()) {
            head = tail = p;
        } else {
            head.prev = p;
            p.next = head;
            head = p;
        }
        if (tail == null) {
            head = tail;
        }
        size++;
    }
    
    /**
     * Add to tail of the list
     * @param info The object is added
     */
    public void addToTail(E info) {
        if (!isEmpty()) {
            tail.next = new Node<>(info, tail, null);
            tail = tail.next;
        } else {
            head = tail = new Node<>(info);
        }
        size++;
    }
    
    /**
     * Delete element at head of the list
     * @return Remove element at the top of the list and return it, return null when the list is empty
     */
    public E deleteFromHead(){
        E info;
        
        if (!isEmpty()) {
            info = head.info;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        } else
            info = null;
        
        return info;
    }
    
    /**
     * Delete element at tail of the list
     * @return Remove last element of the list and return it, return null when the list is empty
     */
    public E deleteFromTail(){
        E info;
        
        if (!isEmpty()) {
            info = tail.info;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        } else
            info = null;
        
        return info;
    }
    
    /**
     * Add element to position of the list
     * @param info The object is added
     * @param pos  The position in the list you want to add
     */
    public void add(E info, int pos) {
        if (pos == 0) {
            addToHead(info);
        } else if (pos == size) {
            addToTail(info);
        } else if (pos > 0 && pos < size) {
            Node tmp = head;
            for (int i = 1; i <= pos; i++) {
                tmp = tmp.next;
            }
            Node prev = tmp.prev;
            prev.next = new Node<>(info, prev, tmp);
            size++;
        } else {
            throw new IndexOutOfBoundsException("Index >= 0 && Index <= size()");
        }
    }
    
    /**
     * Remove element at position of the list
     * @param pos The position in the list you want to delete
     * @return Remove element at position of the list and return it
     * @throws EmptyListException List is empty
     */
    public E delete(int pos) throws EmptyListException{
        E info = null;
        if (!isEmpty()) {
            if (pos == 0) {
                info = deleteFromHead();
            } else if (pos == size - 1) {
                info = deleteFromTail();
            } else if (pos > 0 && pos < size - 1) {
                Node<E> tmp = getNodeIndex(pos);
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
                info = tmp.info;
                size--;
            } else {
                throw new IndexOutOfBoundsException("Index >= 0 && Index <= size()");
            }   
        } else {
            throw new EmptyListException("The list is empty");
        }
        
        return info;
    }

    protected Node getNodeIndex(int pos) throws EmptyListException{
        Node tmp = null;
        if (!isEmpty()) {
            tmp = head;
            if(pos < 0 && pos >= size) {
                throw new IndexOutOfBoundsException("Index >= 0 && Index <= size()");
            } else {
                for (int i = 0; i < pos; i++) {
                    tmp = tmp.next;
                }
            }
        } else {
            throw new EmptyListException("The list is empty");
        }
        
        return tmp;
    }
    
    /**
     * Get element with position
     * @param pos The position in the list you want to get
     * @return Return the element with position in the list
     * @throws EmptyListException 
     */
    public E get(int pos) throws EmptyListException {
//        try {
//            return (E) getNodeIndex(pos).info;
//        } catch (Exception e) {
//            System.out.println(e);
//            return null;
//        }
        return (E) getNodeIndex(pos).info;
    }
    
    /**
     * Show all element in the list
     * @throws EmptyListException 
     */
    public void printAll() throws EmptyListException{
        if (!isEmpty()) {
            //int count = 0;
            for (Node tmp = head; tmp != null; tmp = tmp.next) {
                //System.out.print("#" + count + " ");
                System.out.println(tmp.info.toString());
                //count++;
            }
        } else {
            throw new EmptyListException("The list is empty");
        }
    }
    
    /**
     * Find element in the list
     * @param info Object
     * @return Return true when element has in the list, false otherwise
     */
    public boolean contains(E info){
        boolean result = false;
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.info.equals(info)) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    /**
     * Find element in list
     * @param info Object
     * @return Return position this object in list, return -1 when this object can not exist in this list
     */
    public int IndexOf(E info){
        int pos;
        int count;
        pos = count = -1;
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            count++;
            if (tmp.info.equals(info)) {
                pos = count;
                break;
            }
        }
        return pos;
    }
}
