// ✅ Shallow Copy
// ➤ Definition: A shallow copy copies the object reference, not the actual data.
// ➤ So both original and copied objects point to the same memory (array here).
class F_ShallowCopy {
  int[] marks = new int[3]; // Marks array is stored in heap (reference type)

  // ➤ Default constructor initializes the marks array
  F_ShallowCopy() {
    marks[0] = 80;
    marks[1] = 90;
    marks[2] = 100;
  }

  // ➤ Shallow copy constructor: copies the reference of the array
  F_ShallowCopy(F_ShallowCopy other) {
    this.marks = other.marks; // Now both objects share the same array
  }

  // ➤ Setter method to update array values
  public void setMark(int index, int value) {
    marks[index] = value;
  }

  // ➤ Prints all marks
  public void printMarks() {
    for (int mark : marks) {
      System.out.print(mark + " ");
    }
    System.out.println();
  }
}

// ✅ Deep Copy
// ➤ Definition: A deep copy creates a new object and also copies the actual
// data.
// ➤ So both objects have their own separate copies of the array.
class F_DeepCopy {
  int[] marks = new int[3]; // New array for storing marks

  // ➤ Default constructor initializes the array
  F_DeepCopy() {
    marks[0] = 80;
    marks[1] = 90;
    marks[2] = 100;
  }

  // ➤ Deep copy constructor: creates a new array and copies values manually
  F_DeepCopy(F_DeepCopy other) {
    for (int i = 0; i < 3; i++) {
      this.marks[i] = other.marks[i]; // Copies each element (not reference)
    }
  }

  // ➤ Setter to update marks
  public void setMark(int index, int value) {
    marks[index] = value;
  }

  // ➤ Prints the array
  public void printMarks() {
    for (int mark : marks) {
      System.out.print(mark + " ");
    }
    System.out.println();
  }
}

// ✅ Main class to test both Shallow and Deep Copy
public class f_ShallowAndDeepCopy {
  public static void main(String[] args) {

    // 🔁 Testing Shallow Copy
    System.out.println("🔁 Shallow Copy:");
    F_ShallowCopy original1 = new F_ShallowCopy(); // Original object
    F_ShallowCopy copy1 = new F_ShallowCopy(original1); // Shallow copy

    copy1.setMark(0, 50); // Modifying copy affects original (shared reference)

    System.out.print("Original marks: ");
    original1.printMarks(); // Output will show modified data
    System.out.print("Copied marks:   ");
    copy1.printMarks();

    // 🧬 Testing Deep Copy
    System.out.println("\n🧬 Deep Copy:");
    F_DeepCopy original2 = new F_DeepCopy(); // Original object
    F_DeepCopy copy2 = new F_DeepCopy(original2); // Deep copy

    copy2.setMark(0, 50); // Modifying copy does NOT affect original

    System.out.print("Original marks: ");
    original2.printMarks(); // Original data is preserved
    System.out.print("Copied marks:   ");
    copy2.printMarks();
  }
}
