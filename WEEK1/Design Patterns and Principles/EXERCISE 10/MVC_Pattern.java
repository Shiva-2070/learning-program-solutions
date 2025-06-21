// Model
class Student {
    String name;
    int id;
    
    Student(String n, int i) {
        this.name = n;
        this.id = i;
    }
    
    String getName() { return name; }
    int getId() { return id; }
}

// View
class StudentView {
    void printDetails(String name, int id) {
        System.out.println("Student: " + name + ", ID: " + id);
    }
}

// Controller
class StudentController {
    Student model;
    StudentView view;
    
    StudentController(Student s, StudentView v) {
        this.model = s;
        this.view = v;
    }
    
    void updateView() {
        view.printDetails(model.getName(), model.getId());
    }
}

// Test
class TestMVC {
    public static void main(String[] a) {
        Student s = new Student("John", 101);
        StudentView v = new StudentView();
        StudentController c = new StudentController(s, v);
        
        c.updateView();
    }
}