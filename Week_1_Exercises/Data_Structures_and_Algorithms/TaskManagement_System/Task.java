class Task {
    int taskId;
    String taskName;
    String status;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

class Node {
    Task data;
    Node next;

    Node(Task data) {
        this.data = data;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Node head;
    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    public Task searchTaskById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.data.taskId == taskId) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void displayTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data.taskId + ", " + current.data.taskName + ", " + current.data.status);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted");
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.taskId == taskId) {
                current.next = current.next.next;
                System.out.println("Task deleted");
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found");
    }


    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();

        system.addTask(new Task(1, "Task 1", "To do"));
        system.addTask(new Task(2, "Task 2", "In progress"));
        system.addTask(new Task(3, "Task 3", "Done"));

        system.displayTasks();

        Task foundTask = system.searchTaskById(2);
        if (foundTask != null) {
            System.out.println("Found task: " + foundTask.taskName);
        }

        system.deleteTask(2);
        system.displayTasks();
    }
}
