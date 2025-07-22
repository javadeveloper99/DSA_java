// ✅ Copy Constructor
// Makes a new object with the same values as another

class StudentCopy {
  String name;
  int roll;

  StudentCopy(String name, int roll) {
    this.name = name;
    this.roll = roll;
  }

  // Copy Constructor
  StudentCopy(StudentCopy s) {
    this.name = s.name;
    this.roll = s.roll;
  }
}

public class e_CopyConstructor {
  public static void main(String[] args) {
    StudentCopy s1 = new StudentCopy("Amit", 101);
    StudentCopy s2 = new StudentCopy(s1);

    System.out.println(s2.name + ", " + s2.roll);
  }
}
