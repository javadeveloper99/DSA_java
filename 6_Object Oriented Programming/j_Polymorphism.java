// ✅ Polymorphism Example in Java

// 1️⃣ Compile-time Polymorphism - Method Overloading
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    String add(String a, String b) {
        return a + b;
    }
}

// 2️⃣ Runtime Polymorphism - Method Overriding
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class j_Polymorphism {
    public static void main(String[] args) {
        // Method Overloading
        Calculator calc = new Calculator();
        System.out.println("Int add: " + calc.add(3, 4)); // 7
        System.out.println("Double add: " + calc.add(3.5, 4.2)); // 7.7
        System.out.println("String add: " + calc.add("Hello, ", "Java")); // Hello, Java

        System.out.println();

        // Method Overriding with runtime polymorphism
        Animal a1 = new Dog(); // upcasting
        Animal a2 = new Cat(); // upcasting

        a1.sound(); // Dog barks
        a2.sound(); // Cat meows
    }
}
