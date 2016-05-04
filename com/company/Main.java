//provide a method to search in the linked list         -done
//provide a method to Add/Remove a user                 -done
//Allow a user to be inserted at any given location     -done
//A method to print all the list                        -done
//A method to print in reverse oder.                    -done
//Use one of the sorting algorithm to sort them ascending or descending  -Done
package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Main {
    public static void main(String args[]) throws IOException {

        Scanner input = new Scanner(System.in);

        Linkedlist name = new Linkedlist();

        FileReader fr = new FileReader("E:\\Linked\\src\\com\\company\\employee.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int count = 0;
            while (st.hasMoreTokens()) {
                if (count == 0) {
                    String tokenEmployee = st.nextToken();
                    name.add(tokenEmployee);
                } else if (count == 1) {
                    String tokenManager = st.nextToken();
                    name.add(tokenManager);
                }

                count++;
            }
        }

        for (int i = 0; i < 3; i++)
        {

            switch (menu())
            {
                case 1:
                {
                    System.out.println("Please the name you want to add");
                    String newName = input.nextLine();
                    name.add(newName);
                    System.out.println();
                    break;
                }

                case 2:
                {
                    System.out.println("Please the name you want to delete");
                    String deleteName = input.nextLine();
                    name.delete(deleteName);
                    break;
                }

                case 3:
                {
                    System.out.println("Please the name you want to insert");
                    String insertName = input.nextLine();
                    System.out.println();
                    System.out.println("Please also enter the name you want insert after "
                            +"Begin to insert at the beginning, End to add at the end.");
                    String afterName = input.nextLine();
                    name.Insert(insertName, afterName);
                    System.out.println();
                    break;
                }
                case 4:
                {
                    System.out.println("######### List of names ###########");
                    name.Display();
                    System.out.println();
                    break;
                }
                case 5:
                {
                    System.out.println("######### List of names in reverse ###########");
                    name.ReversePrinter();
                    System.out.println();
                    break;
                }
                case 6:
                {
                    System.out.println("Please enter the name you want to search");
                    String searchName = input.nextLine();
                    name.Search(searchName);
                    break;
                }

                case 7:
                {
                    System.out.println("Before Ascending Sorting");
                    name.Display();
                    System.out.println();
                    System.out.println("After Ascending Sorting");
                    name.sortingAscending();
                    name.Display();
                    break;
                }

                case 8:
                {
                    System.out.println("Before Descending Sorting");
                    name.Display();
                    System.out.println();
                    System.out.println("After Descending Sorting");
                    name.sortingDescending();
                    name.Display();
                    break;
                }
            }

        }
    }

    public static int menu ()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Here are your options:");
        System.out.println("1.  add");
        System.out.println("2.  delete");
        System.out.println("3.  insert");
        System.out.println("4.  print the entire list");
        System.out.println("5.  print the list in reverse order");
        System.out.println("6.  search");
        System.out.println("7.  Sort the list ascending");
        System.out.println("8.  Sort the list descending");
        int choice = input.nextInt();
        return choice;

    }
}
