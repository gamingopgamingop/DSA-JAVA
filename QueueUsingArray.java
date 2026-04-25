import java.text.MessageFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.EnumSet;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Hashtable;
import java.util.SortedMap;
import java.util.NavigableMap;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.Book;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoublePredicate;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.LongPredicate;
import java.util.function.LongConsumer;
import java.io.StreamTokenizer;
import java.util.Date;
import java.util.Random;

// class QueueUsingArray {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int a[] = new int[10];
//         int front = -1, rear = -1;
//         int item, ch;

//         while (true) {
//             System.out.println("\n1. Insert");
//             System.out.println("2. Delete");
//             System.out.println("3. Display");
//             System.out.println("4. Exit");
//             System.out.print("Enter your choice: ");

//             ch = sc.nextInt();

//             switch (ch) {
//                 case 1: 
//                     if (rear == 9) {
//                         System.out.println("Queue is full ");
//                     } else {
//                         System.out.print("Enter element: ");
//                         item = sc.nextInt();

//                         if (front == -1) {
//                             front = 0;
//                         }

//                         rear++;
//                         a[rear] = item;

//                         System.out.println("Inserted successfully ");
//                     }
//                     break;

//                 case 2: 
//                     if (front == -1 || front > rear) {
//                         System.out.println("Queue is empty ");
//                     } else {
//                         System.out.println("Deleted element: " + a[front]);
//                         front++;

//                         // Reset queue if empty
//                         if (front > rear) {
//                             front = rear = -1;
//                         }
//                     }
//                     break;

//                 case 3: 
//                     if (front == -1 || front > rear) {
//                         System.out.println("Queue is empty ");
//                     } else {
//                         System.out.print("Queue elements: ");
//                         for (int i = front; i <= rear; i++) {
//                             System.out.print(a[i] + " ");
//                         }
//                         System.out.println();
//                     }
//                     break;

//                 case 4: 
//                     System.out.println("Exiting... ");
//                     System.exit(0);

//                 default:
//                     System.out.println("Invalid choice");
//             }
//         }
//         sc.close();
//     }
// }

import java.util.*;

class QueueUsingArray {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

        int a[] = new int[10];
        int front = -1, rear = -1;

        while (true) {
            System.out.println("\n1.Insert 2.Delete 3.Display 4.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    if ((rear + 1) % 10 == front) {
                        System.out.println("Queue Full");
                    } else {
                        int item = sc.nextInt();
                        if (front == -1) front = 0;
                        rear = (rear + 1) % 10;
                        a[rear] = item;
                    }
                    break;

                case 2:
                    if (front == -1) {
                        System.out.println("Queue Empty");
                    } else {
                        System.out.println("Deleted: " + a[front]);
                        if (front == rear) {
                            front = rear = -1;
                        } else {
                            front = (front + 1) % 10;
                        }
                    }
                    break;

                case 3:
                    if (front == -1) {
                        System.out.println("Queue Empty");
                    } else {
                        int i = front;
                        while (true) {
                            System.out.print(a[i] + " ");
                            if (i == rear) break;
                            i = (i + 1) % 10;
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    return;
            }
        }
    }
    }
}
