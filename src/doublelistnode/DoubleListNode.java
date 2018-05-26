/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelistnode;

import data.*;

/**
 *
 * @author SONPH
 * @param <E>
 */
public class DoubleListNode<E> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Person> list = new LinkedList();

        Person n1 = new Person("Steve", "CEO", 56);
        Person n2 = new Person("Mark", "CEO", 35);

        list.addToHead(n2);

//        
        Person n3 = new Person("Chris", "Actor", 37);

        Person n4 = new Person("Bill Gate", "Good Person", 72);

        System.out.println("========");
        System.out.println("Total: " + list.size());

        System.out.println("Deleted: " + list.deleteFromHead());

        if (list.deleteFromTail() == null) {
            System.out.println("Can not delete!");
        } else {
            System.out.println("Deleted!");
        }

        delete(list, 0);

        System.out.println("========");
        System.out.println("Total: " + list.size());

        add(list, n1, 0);

        printList(list);
        System.out.println("Total: " + list.size());

        //delete(list, 0);
        get(list, 1);
        System.out.println("----");
        System.out.println("Add to head");
        System.out.println(n3);
        list.addToHead(n3);
        System.out.println("----");
        printList(list);
        System.out.println("Total: " + list.size());
        System.out.println("----");
        System.out.println("Add to tail");
        System.out.println(n4);
        list.addToTail(n4);
        System.out.println("----");
        printList(list);
        System.out.println("Total: " + list.size());
        System.out.println("----");
        int pos1 = 3;
        System.out.println("Add to position #" + pos1);
        System.out.println(n2);
        add(list, n2, pos1);
        System.out.println("----");
        printList(list);
        System.out.println("Total: " + list.size());
        System.out.println("----");
        int pos2 = 4;
        System.out.println("Get object in pos: " + pos2);
        get(list, pos2);
        System.out.println("----");
        System.out.println("Find obj in list");
        System.out.println(n1);
        if (list.contains(n1))
            System.out.println("Yeah we have this in the list");
        else
            System.out.println("No one in list");
        System.out.println("----");
        int pos4 = 1;
        System.out.println("Delete in pos: #" + pos4);
        delete(list, pos4);
        System.out.println("----");
        printList(list);
        System.out.println("Total: " + list.size());
        System.out.println("----");
        System.out.println("Find obj in list");
        Person n5 = new Person("SP", "Student", 20);
        System.out.println(n5);
        if (list.contains(n5))
            System.out.println("Yeah we have this in the list");
        else
            System.out.println("No one in list");
        System.out.println("----");
        System.out.println("Find position of object in list: " + n4.getName());
        if (list.IndexOf(n4) > -1) {
            System.out.println("Your object <" + n4.getName() + "> at position #" + list.IndexOf(n4));
        } else {
            System.out.println("Haven't in the list");
        }
        
        System.out.println("\n========");
        System.out.println("Total: " + list.size());
    }

    public static void printList(LinkedList list) {
        try {
            list.printAll();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void delete(LinkedList list, int pos) {
        try {
            System.out.println("Deleted: " + list.delete(pos));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void add(LinkedList list, Object obj, int pos) {
        try {
            list.add(obj, pos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void get(LinkedList list, int pos) {
        try {
            System.out.println(list.get(pos));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
