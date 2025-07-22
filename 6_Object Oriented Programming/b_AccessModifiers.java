// Access Modifier Demo

class B_AccessModifiers {
  // public: accessible from anywhere
  public String name = "Vivek";

  // private: accessible only within this class
  private int age = 22;

  // protected: accessible within the package and subclasses
  protected String college = "SIT Lonavala";

  // default (no modifier): accessible only within the same package
  String city = "Pune";

  // public method: accessible from anywhere
  public void showName() {
    System.out.println("Name (public): " + name);
  }

  // private method: only accessible inside this class
  private void showAge() {
    System.out.println("Age (private): " + age);
  }

  // public method that internally calls private method
  public void callPrivateShowAge() {
    showAge(); // ✅ allowed
  }
}

public class b_AccessModifiers {
  public static void main(String[] args) {
    B_AccessModifiers obj = new B_AccessModifiers();

    // ✅ Accessing public variable
    System.out.println("Public name: " + obj.name);

    // ✅ Accessing default variable (same package)
    System.out.println("Default city: " + obj.city);

    // ✅ Accessing protected variable (same package)
    System.out.println("Protected college: " + obj.college);

    // ❌ Accessing private variable — Not allowed
    // System.out.println(obj.age); // ❌ Compile-time error

    // ✅ Calling public method
    obj.showName();

    // ✅ Indirect access to private method via public method
    obj.callPrivateShowAge();

    // ❌ Direct access to private method — Not allowed
    // obj.showAge(); // ❌ Compile-time error
  }
}
