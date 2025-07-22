// ✅ Inheritance Types

class Animal {
  void eat() {
    System.out.println("Eats...");
  }
}

// Single level
class Dog extends Animal {
  void bark() {
    System.out.println("Barks...");
  }
}

// Multi-level
class Puppy extends Dog {
  void weep() {
    System.out.println("Weeps...");
  }
}

// Hierarchical
class Cat extends Animal {
  void meow() {
    System.out.println("Meows...");
  }
}

public class h_Inheritance {
  public static void main(String[] args) {
    Puppy p = new Puppy();
    p.eat();
    p.bark();
    p.weep();

    Cat c = new Cat();
    c.meow();
  }
}
