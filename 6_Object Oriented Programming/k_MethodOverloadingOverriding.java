// ✅ Method Overloading and Overriding in Java

// =============================================
// ✅ METHOD OVERLOADING
// =============================================
// Same method name with different parameters (compile-time polymorphism)
class K_MethodOverloadingOverriding {
  void greet() {
    System.out.println("Hello");
  }

  void greet(String name) {
    System.out.println("Hello, " + name);
  }

  public static void main(String[] args) {
    System.out.println("== Method Overloading ==");
    K_MethodOverloadingOverriding obj = new K_MethodOverloadingOverriding();
    obj.greet();            // Calls greet()
    obj.greet("Vivek");     // Calls greet(String)

    // Call overriding example
    System.out.println("\n== Method Overriding ==");
    Parent ref = new Child();  // Upcasting
    ref.show();                // Calls Child's overridden show()
  }
}

// =============================================
// ✅ METHOD OVERRIDING
// =============================================
// Subclass redefines a method from its parent class (runtime polymorphism)
class Parent {
  void show() {
    System.out.println("Parent show()");
  }
}

class Child extends Parent {
  @Override
  void show() {
    System.out.println("Child show()");
  }
}
