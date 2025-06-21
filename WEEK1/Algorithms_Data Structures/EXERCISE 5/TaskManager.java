class Task {
    int id;
    String name;
    boolean done;
    Task next;
    
    Task(int i, String n) {
        id = i;
        name = n;
        done = false;
        next = null;
    }
}

public class TaskManager {
    Task head;
    
    void addTask(int id, String name) {
        Task newTask = new Task(id, name);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }
    
    Task findTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.id == id) return current;
            current = current.next;
        }
        return null;
    }
    
    void showTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }
    
    void deleteTask(int id) {
        if (head == null) return;
        
        if (head.id == id) {
            head = head.next;
            return;
        }
        
        Task current = head;
        while (current.next != null) {
            if (current.next.id == id) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.addTask(1, "Fix bug");
        tm.addTask(2, "Write docs");
        tm.showTasks();
        tm.deleteTask(1);
        tm.showTasks();
    }
}