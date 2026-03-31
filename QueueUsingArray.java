// import java.util.*;

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
