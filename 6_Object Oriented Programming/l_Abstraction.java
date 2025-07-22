// ✅ Abstraction using Interface
interface Animal {
    void sound();     // abstract method
    void eat();       // abstract method
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }
}

public class l_Abstraction {
    public static void main(String[] args) {
        Animal dog = new Dog(); // Interface reference
        dog.sound();
        dog.eat();
    }
}
