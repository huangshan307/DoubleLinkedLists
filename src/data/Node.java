/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author SONPH
 * @param <E> Object
 */
public class Node<E> {
    protected E info;
    protected Node<E> prev;
    protected Node<E> next;

    public Node(E info, Node<E> prev, Node<E> next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public Node(E info) {
        this(info, null, null);
    }
    
    public Node() {
    }
    
}
