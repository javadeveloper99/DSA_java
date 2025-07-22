// ✅ Static and Super Keyword Example

// ----------- Static Keyword Example -----------
class Utils {
    // Static method — can be called without creating an object
    static int cube(int x) {
        return x * x * x;
    }
}

// ----------- Super Keyword Example -----------
class SuperParent {
    String name = "Parent";
}

class SuperChild extends SuperParent {
    String name = "Child";

    void printNames() {
        System.out.println("this.name: " + this.name);     // refers to Child's name
        System.out.println("super.name: " + super.name);   // refers to Parent's name
    }
}

// ----------- Main Class -----------
public class o_StaticAndSuper {
    public static void main(String[] args) {

        // ----- Using Static Method -----
        System.out.println("Cube of 3: " + Utils.cube(3)); // No object needed

        // ----- Using Super Keyword -----
        SuperChild obj = new SuperChild();
        obj.printNames();
    }
}
