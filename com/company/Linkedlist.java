package com.company;
import java.util.*;
/**
 * Created by Hunter on 4/7/2016.
 */
public class Linkedlist {
    Node head ;
    Node tail;

//    public void insert (String name)
//    {
//        head = new Node();
//        head.name = name;
//        tail = head;
//    }

    public void add (String name)
    {
        Node n = new Node();

        if (tail != null) {
            n.name = name;
            tail.next = n;
            n.prev = tail;
            tail = n;
        }

        else
        {
            head = new Node();
            head.name = name;
            tail = head;
        }
    }

    public void delete (String name)
    {
        Node temp = head;

        while (temp != null)
        {
            if (temp.name.equals(name))
            {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }

    }

    public void Display ()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.println(temp.name);
//            System.out.println("Prev: " + temp.prev );
//            System.out.println("Current: " + temp);
//            System.out.println("Next: " + temp.next);
//            System.out.println();
            temp = temp.next;
        }
    }

    public void Search(String name)
    {
        Node temp = head;
        int count = 1;
        System.out.println("The location(s) of " + name + ": " );
        while (temp != null)
        {
            if(temp.name.equals(name)) {
                System.out.println(count + ". " + temp);
                ++count;
            }
            temp = temp.next;
        }

    }

    public void Insert (String name, String nameToBeInsertedAfter)
    {
        Node temp = head;
        Node n = new Node();

//################### Insert at the beginning of the list##########
        if (nameToBeInsertedAfter.equals("Begin"))
        {
            n.name = name;
            n.next = head;
            head.prev = n;
            head = n;
        }
//################### Insert at the end of the list##########
        else if (nameToBeInsertedAfter.equals("End"))
        {
            add(name);
        }

//################### Insert within of the list##########
        else {
            while (temp != null) {
                if (temp.name.equals(nameToBeInsertedAfter)) {
                    n.name = name;
                    n.next = temp.next;
                    n.prev = temp.next.prev;
                    temp.next = n;
                    temp.next.prev = n;

                }
                temp = temp.next;
            }
        }
    }

    public void ReversePrinter()
    {
        Node temp = head;

        while (temp !=null)
        {
            temp = temp.next;
            if (temp.next == null)
            {
                while (temp != null)
                {
                    System.out.println(temp.name);
                    temp = temp.prev;
                }
            }
        }

    }

    //############# Display reverse with recursive--Dont know how to use ##########
    public void displayReverse(Node node){
        if ( node == null)
            return;
        displayReverse(node.next);
        System.out.println(node.name);
    }

    public void sortingAscending () {
        Node temp = head;
        String swap;
        int count = 1;
        boolean condition = true;
        while (condition == true) {
            condition = false;
            if (count ==1) {
                while (temp.next != null) {
                    if (temp.name.toString().compareTo(temp.next.name.toString()) > 0) {
                        swap = temp.name.toString();
                        temp.name = temp.next.name;
                        temp.next.name = swap;
                        temp = temp.next;
                        condition = true;
                    } else
                        temp = temp.next;
                    count = 2;
                }
            }

            else if (count == 2)
            {
                while (temp.prev != null) {
                    if (temp.name.toString().compareTo(temp.prev.name.toString()) < 0) {
                        swap = temp.name.toString();
                        temp.name = temp.prev.name;
                        temp.prev.name = swap;
                        temp = temp.prev;
                        condition = true;
                    } else
                        temp = temp.prev;
                    count = 1;
                }
            }
        }
    }

    public void sortingDescending () {
        Node temp = head;
        String swap;
        int count = 1;
        boolean condition = true;
        while (condition == true) {
            condition = false;
            if (count ==1) {
                while (temp.next != null) {
                    if (temp.name.toString().compareTo(temp.next.name.toString()) < 0) {
                        swap = temp.name.toString();
                        temp.name = temp.next.name;
                        temp.next.name = swap;
                        temp = temp.next;
                        condition = true;
                    } else
                        temp = temp.next;;
                    count = 2;
                }
            }

            else if (count == 2)
            {
                while (temp.prev != null) {
                    if (temp.name.toString().compareTo(temp.prev.name.toString()) > 0) {
                        swap = temp.name.toString();
                        temp.name = temp.prev.name;
                        temp.prev.name = swap;
                        temp = temp.prev;
                        condition = true;
                    } else
                        temp = temp.prev;
                    count = 1;
                }
            }
        }
    }
}
