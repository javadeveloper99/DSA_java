// ✅ Encapsulation in Java
// ------------------------------------------
// Encapsulation is a principle of OOP that binds data (variables) and methods into a single unit (class).
// It restricts direct access to some of the object's components for better security and control.
// We achieve encapsulation by:
//   → Making class variables 'private'
//   → Providing public 'getter' and 'setter' methods to read/write data
// Benefits: Data hiding, code maintainability, flexibility, and reusability.

class Student {
  // Private field → not accessible directly from outside the class
  private String name;

  // Public getter method → allows controlled access to 'name'
  public String getName() {
    return name;
  }

  // Public setter method → allows controlled modification of 'name'
  public void setName(String newName) {
    this.name = newName;
  }
}

public class c_Encapsulation {
  public static void main(String[] args) {
    // Creating object of Student
    Student s = new Student();

    // Setting the value of 'name' using setter method
    s.setName("Vivek");

    // Getting the value of 'name' using getter method
    System.out.println("Student Name: " + s.getName());
  }
}
