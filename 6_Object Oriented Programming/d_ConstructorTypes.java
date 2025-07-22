// Class defining constructor types
public class d_ConstructorTypes {
  String name;
  int age;

  // ✅ Default Constructor
  public d_ConstructorTypes() {
    name = "Default";
    age = 0;
  }

  // ✅ Parameterized Constructor
  public d_ConstructorTypes(String n, int a) {
    name = n;
    age = a;
  }

  public void display() {
    System.out.println("Name: " + name + ", Age: " + age);
  }
}
