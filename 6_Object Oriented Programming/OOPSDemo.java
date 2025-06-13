public class OOPSDemo {
  public static void main(String[] args) {

    // ======= Encapsulation =======
    CustomPen pen1 = new CustomPen();
    pen1.setColor("Black");
    pen1.setTip(25);
    System.out.println("Pen Color: " + pen1.getColor());
    System.out.println("Pen Tip: " + pen1.getTip());

    // ======= Private Field via Setter =======
    BankAccount account = new BankAccount();
    account.username = "vivek";
    account.setPassword("mySecret"); // Cannot access password directly

    // ======= Shallow Copy =======
    System.out.println("\n--- Shallow Copy ---");
    ShallowStudent s1 = new ShallowStudent();
    s1.name = "Vivek";
    s1.roll = 25;
    s1.marks[0] = 100;
    s1.marks[1] = 90;
    s1.marks[2] = 80;

    ShallowStudent s2 = new ShallowStudent(s1); // shallow copy
    s1.marks[2] = 50; // also changes s2's marks

    System.out.println("s2.marks[2] after s1 change: " + s2.marks[2]);

    // ======= Deep Copy =======
    System.out.println("\n--- Deep Copy ---");
    DeepStudent ds1 = new DeepStudent();
    ds1.name = "Vikas";
    ds1.roll = 30;
    ds1.marks[0] = 85;
    ds1.marks[1] = 95;
    ds1.marks[2] = 75;

    DeepStudent ds2 = new DeepStudent(ds1); // deep copy
    ds1.marks[0] = 20; // does NOT affect ds2

    System.out.println("ds2.marks[0] after ds1 change: " + ds2.marks[0]);

    // ======= Inheritance & Constructor =======
    System.out.println("\n--- Inheritance Example ---");
    Horse h = new Horse();
    System.out.println("Horse color: " + h.color);

    // ======= Multi-Level Inheritance =======
    System.out.println("\n--- Multi-Level Inheritance ---");
    RollsRoyce car = new RollsRoyce();
    car.speed();
    car.comfort();
    car.offRoad();
    car.safety();
    car.showType();

    // ======= Animal Hierarchy =======
    System.out.println("\n--- Animal Hierarchy ---");
    Dog d = new Dog();
    d.eat();
    d.breathe();
    d.walk();

    Fish f = new Fish();
    f.eat();
    f.breathe();
    f.swim();
  }
}

// ========== Encapsulation ==========
class CustomPen {
  private String color;
  private int tip;

  void setColor(String color) {
    this.color = color;
  }

  String getColor() {
    return this.color;
  }

  void setTip(int tip) {
    this.tip = tip;
  }

  int getTip() {
    return this.tip;
  }
}

// ========== Bank Account Example ==========
class BankAccount {
  public String username;
  private String password;

  public void setPassword(String pwd) {
    this.password = pwd;
  }
}

// ========== Shallow Copy Student ==========
class ShallowStudent {
  String name;
  int roll;
  int[] marks;

  ShallowStudent() {
    marks = new int[3];
  }

  ShallowStudent(ShallowStudent s) {
    this.name = s.name;
    this.roll = s.roll;
    this.marks = s.marks; // shallow copy (same reference)
  }
}

// ========== Deep Copy Student ==========
class DeepStudent {
  String name;
  int roll;
  int[] marks;

  DeepStudent() {
    marks = new int[3];
  }

  DeepStudent(DeepStudent s) {
    this.name = s.name;
    this.roll = s.roll;
    this.marks = new int[3];
    for (int i = 0; i < 3; i++) {
      this.marks[i] = s.marks[i];
    }
  }
}

// ========== Animal and Horse ==========
class Animal {
  String color;

  Animal() {
    System.out.println("Animal constructor called");
  }

  void eat() {
    System.out.println("Animal eats...");
  }

  void breathe() {
    System.out.println("Animal breathes...");
  }
}

class Horse extends Animal {
  Horse() {
    super();
    this.color = "Brown";
    System.out.println("Horse constructor called");
  }
}

// ========== Car Inheritance ==========
class Car {
  void speed() {
    System.out.println("Car speed: Fast");
  }

  void comfort() {
    System.out.println("Comfort level: High");
  }

  void offRoad() {
    System.out.println("Can go off-road");
  }
}

class SportsCar extends Car {
  void safety() {
    System.out.println("Equipped with race-track safety");
  }
}

class RollsRoyce extends SportsCar {
  void showType() {
    System.out.println("This is a luxury sedan");
  }
}

// ========== Other Animals ==========
class Dog extends Animal {
  void walk() {
    System.out.println("Dog walks...");
  }
}

class Fish extends Animal {
  void swim() {
    System.out.println("Fish swims...");
  }
}
