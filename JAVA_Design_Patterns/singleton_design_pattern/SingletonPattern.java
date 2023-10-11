//SingletonEagar class implements the Singleton pattern using eager initialization.
class SingletonEagar {
  private static SingletonEagar instance = new SingletonEagar(); // Eagerly create a single instance.
  private SingletonEagar() {
    //Private constructor to prevent external instantiation.
  }
  public static SingletonEagar getInstance() {
    return instance;
  }
}

//Singleton class implements the Singleton pattern using lazy initialization.
class Singleton {
  private static Singleton instance; //Instance is not created until requested.
  private Singleton() {
    //Private constructor to prevent external instantiation.
  }
  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton(); //Lazy initialization when getInstance() is called.
    }
    return instance;
  }
}

//SingletonSynchronizedMethod class implements the Singleton pattern using lazy initialization with synchronized method.
class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod instance;
  private SingletonSynchronizedMethod() {
    //Private constructor to prevent external instantiation.
  }
  public static synchronized SingletonSynchronizedMethod getInstance() {
    if (instance == null) {
      instance = new SingletonSynchronizedMethod(); //Lazy initialization with synchronization.
    }
    return instance;
  }
}

//SingletonSynchronized class implements the Singleton pattern using lazy initialization
class SingletonSynchronized {
  private static SingletonSynchronized instance;
  private SingletonSynchronized() {
    //Private constructor to prevent external instantiation.
  }
  public static SingletonSynchronized getInstance() {
    if (instance == null) {
      synchronized (SingletonSynchronized.class) {
        if (instance == null) {
          instance = new SingletonSynchronized(); //Lazy initialization with double-checked locking.
        }
      }
    }
    return instance;
  }
}

public class SingletonPattern {
  public static void main(String[] args) {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
