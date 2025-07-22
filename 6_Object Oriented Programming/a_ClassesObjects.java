// ✅ Classes & Objects
// A class is a blueprint. An object is an instance of that class.
public class a_ClassesObjects {
  public static void main(String[] args) {
    Car myCar = new Car(); // object
    myCar.honk();
    System.out.println("Brand: " + myCar.brand);
  }
}

class Car {
  String brand = "Tata"; // property

  void honk() {
    System.out.println("Beep! Beep!");
  }
}
