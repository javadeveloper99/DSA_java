// ✅ Interface Example in Java

// Interface declaration
interface A_Device {
    void turnOn(); // abstract method

    void turnOff(); // abstract method
}

// Class implementing the interface
class Laptop implements A_Device {
    @Override
    public void turnOn() {
        System.out.println("Laptop is turning ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Laptop is shutting DOWN");
    }
}

// Another class implementing the same interface
class Mobile implements A_Device {
    @Override
    public void turnOn() {
        System.out.println("Mobile is booting UP");
    }

    @Override
    public void turnOff() {
        System.out.println("Mobile is powering OFF");
    }
}

public class n_Interface {
    public static void main(String[] args) {
        A_Device dev1 = new Laptop();
        dev1.turnOn();
        dev1.turnOff();

        A_Device dev2 = new Mobile();
        dev2.turnOn();
        dev2.turnOff();
    }
}
