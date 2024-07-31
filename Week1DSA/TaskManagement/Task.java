package Week1DSA.TaskManagement;

import java.util.Scanner;

public class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task " + taskId + ": " + taskName + " (" + status + ")";
    }
}
class Node {
    private Task task;
    private Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    public Task getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class TaskLinkedList {
    private Node head;
    private Scanner scanner;

    public TaskLinkedList() {
        this.head = null;
        this.scanner = new Scanner(System.in);
    }

    public void addTask() {
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt();
        System.out.print("Enter task name: ");
        String taskName = scanner.next();
        System.out.print("Enter task status: ");
        String status = scanner.next();

        Task task = new Task(taskId, taskName, status);
        Node node = new Node(task);

        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }

        System.out.println("Task added successfully!");
    }

    public void searchTask() {
        System.out.print("Enter task ID to search: ");
        int taskId = scanner.nextInt();

        Node current = head;
        while (current != null) {
            if (current.getTask().getTaskId() == taskId) {
                System.out.println("Task found: " + current.getTask());
                return;
            }
            current = current.getNext();
        }

        System.out.println("Task not found!");
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getTask());
            current = current.getNext();
        }
    }

    public void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int taskId = scanner.nextInt();

        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }

        if (head.getTask().getTaskId() == taskId) {
            head = head.getNext();
            System.out.println("Task deleted successfully!");
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getTask().getTaskId() == taskId) {
                current.setNext(current.getNext().getNext());
                System.out.println("Task deleted successfully!");
                return;
            }
            current = current.getNext();
        }

        System.out.println("Task not found!");
    }

    public void run() {
        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Search task");
            System.out.println("3. Traverse tasks");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    searchTask();
                    break;
                case 3:
                    traverseTasks();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
