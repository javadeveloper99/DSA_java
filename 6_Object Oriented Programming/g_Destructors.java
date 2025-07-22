// ✅ Class with finalize() method (not public)
class G_Destructors {
  // finalize method (called before object is destroyed by GC)
  @Override
  protected void finalize() {
    System.out.println("Object destroyed (finalize called)");
  }
}

// ✅ Main class (public)
public class g_Destructors {
  public static void main(String[] args) {
    G_Destructors obj = new G_Destructors();

    // Make object eligible for garbage collection
    obj = null;

    // Suggest JVM to run Garbage Collector
    System.gc();

    // Delay to allow GC to complete
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("End of main method");
  }
}
