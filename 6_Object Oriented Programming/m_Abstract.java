// ✅ Abstract Class Example
abstract class Vehicle {
  abstract void start(); // abstract method
}

class Bike extends Vehicle {
  void start() {
    System.out.println("Bike starts");
  }
}

// ✅ Interface Example
interface Animal {
  void sound(); // interface method
}

class Doggo implements Animal {
  public void sound() {
    System.out.println("Barks");
  }
}

// ✅ Main Class to Run Everything
public class m_Abstract {
  public static void main(String[] args) {
    // Using Abstract Class
    Vehicle myBike = new Bike();
    myBike.start();

    // Using Interface
    Animal myDog = new Doggo();
    myDog.sound();
  }
}
