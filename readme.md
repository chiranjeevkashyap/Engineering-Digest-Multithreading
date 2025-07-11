# [Engineering Digest](https://www.youtube.com/@EngineeringDigest)

## [Java MultiThreading Zero to Hero Masterclass 2024](https://youtube.com/playlist?list=PLA3GkZPtsafYhmrZR_1nmQqfFSnkftOud&si=VQVyaNkit81vMNPY) 🚀

### 1. Multithreading Basics: CPU, Core, Program, Process, Thread & much more

- The CPU, often referred to as the brain of the computer, is a responsible for executing instructions from programs. It
  performs basic arithmetic, logic, control and input/output operations specified by the instructions.
- The core is an individual processing unit within a CPU. Modern CPUs can have multiple cores,allowing them to perform
  multiple tasks simultaneously.
- A quad-core processor has four cores, allowing it to perform four tasks simultaneously. For instance, one core could
  handle your web browser, another music player, another a download manager and another a background system update.
- A _**program**_ is a set of instructions written in a programming language that tells the computer how to perform a
  specific tasks.
- _**Microsoft Word**_ is a program that allows users to create and edit documents.
- A process is an instance of a program that is a being executed. When a program runs, the operating system creates a
  process to manage its execution.
- When we open _**Microsoft Word,**_ it becomes a process in the operating system.
- A _**thread**_ is the smallest unit of execution within a process. A process can have multiple threads, which share
  the same resources but can run independently.
- **Example:** A web browser like _**Google Chrome**_ might use multiple threads for different tabs, with each tab
  running as a separate thread.
- Multitasking allows an operating system to run multiple processes simultaneously. On single-core CPUs, this is done
  through time-sharing, rapidly switching between tasks. On multicore CPUs, true parallel execution occurs, with tasks
  distributed across cores. The OS scheduler balances the load, ensuring efficient and responsive system performance.
- Multitasking utilized the capabilities of a CPU and its cores. When an **operating system** performs multitasking, it
  can assign different tasks to different cores. This is more efficient than assigning all tasks to a single core.
- _**Example:**_ We are browsing the internet while listening to music and downloading the file.
- _**Multithreading**_ refers to the ability to execute multiple threads within a single process concurrently.
- _**Example:**_ A web browser can use multithreading by having separate threads for rendering the pages, running
  javascript and managing user inputs. This makes the browser more responsive and efficient.
- _**Multithreading**_ enhances the efficiency of multitasking by breaking down individual tasks into smaller sub-tasks
  or threads. These threads can be processed simultaneously, making better use of the CPUs capabilities.
- In a _**single-core system**_: Both threads and processes are managed by the OS scheduler through time slicing and
  context switching to create the illusion of simultaneous execution.
- In a _**multicore system**_: Both threads and processes can run in true parallel on different cores, with the OS
  scheduler distributing tasks across the cores to optimize performance.
- **Time Slicing -**
    - **Definition:** Time slicing divides CPU time into small intervals called time slices or quanta.
    - **Function:** The OS scheduler allocates these time slices to different processes and threads, ensuring each gets
      a fair share of CPU time.
    - **Purpose:** This prevents any single process or thread from monopolizing the CPU, improving responsiveness and
      enabling concurrent execution.
- **Context Switching -**
    - **Definition:** Context switching is the process of saving the state of a currently running process or thread and
      loading the states of the next on to be executed.
    - **Function:** When a process or threads time slice expires, the OS scheduler performs a context switch to move the
      CPUs focus to another process or thread.
    - **Purpose:** This allows multiple processes and threads to share the CPU, giving the appearance of simultaneous
      execution on a single-core CPU or improving parallelism on multicore CPUs.
- Multitasking -
    - Multitasking can be archived through multithreading where each task is divided into threads that are managed
      concurrently.
    - Multitasking operates at the level of processes, which are the operating system's primary units of execution.
    - Multitasking involves managing resources between completely separate programs, which may have independent memory
      spaces and system resources.
    - Multitasking allows us to run multiple applications simultaneously, improving productivity and system utilization.

- Multithreading -
    - While multitasking typically refers to the running of multi applications, multithreading is more granular, dealing
      with multiple threads within the same application or process.
    - Multithreading operates at the level of threads, which are smaller units within a process.
    - Multithreading involves managing resources within a single program, where threads share the same memory and
      resources.
    - Multithreading allows a single application to perform multiple tasks at the same time, improving application
      performance and responsiveness.

### 2. How JVM handles multithreading?

- Java provides robust support for multithreading, allowing developers to create applications that can perform multiple
  task simultaneously, improving performance and responsiveness.
- In Java, multithreading is the concurrent execution of two or more threads to maximize the utilization of the CPU.
  Java's multithreading capabilities are part of the _**java.lang.package**_, making it easy to implement concurrent
  execution.
- In a single-core environment, Java's multithreading is managed by the JVM and the OS, which switch between threads to
  give the illusion of concurrency.
- The threads share the single core and time-slicing is used to manage thread execution.
- In multicore environment, Java's multithreading can take full advantage of the available cores.
- The JVM can distribute threads across multiple cores, allowing true parallel execution of threads.
- A thread is a lightweight process, the smallest unit of processing. Java supports multithreading through its
  _**java.lang.Thread**_ class and _**java.lang.Runnable**_ interface.
- When a Java program starts, one thread begins running immediately, which is called the main thread. This thread is
  responsible for executing the main method of a program.

    ```java
    public class Main {
        public static void main(String[] args) {
            System.out.println("Namaste! Java");
            System.out.println(Thread.currentThread().getName());
        }
    }
    ```

    ```shell
    Namaste! Java
    main
    
    Process finished with exit code 0
    ```

### 3. Java Threads Made SUPER EASY! 🔥 2 Ways to Create Threads

- To create a new thread in Java, you can either extend the Thread class or implement the Runnable interface.

    ```java
    public class Main {
        public static void main(String[] args) {
            World world = new World();
            world.start();
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
    
    class World extends Thread {
    @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        }            
    }
    ```

- A new class World is created that extends Thread.
- The run method is overridden to define the code that constitutes the new thread.
- start method is called to initiate the new thread.

    ```java
    public class Main {
        public static void main(String[] args) {
            World world = new World();
            Thread thread = new Thread(world);
            thread.start();
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
    
    class World implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
    ```

- To create a new thread in Java, you can either extend the Thread class or implement the Runnable interface.
- A new class World is created that implements Runnable.
- The run method is overridden to define the code that constitutes the new thread.
- A Thread object is created by passing an instance of MyRunnable.
- start method is called on the Thread object to initiate the new thread.

### 4. Java Thread Lifecycle EXPLAINED! 🚀

- The lifecycle of a thread in Java consists of several states, which a thread can move through during its execution.
    - **New:** A thread is in this state when it is created but not yet started.
    - **Runnable:** After the start method is called, the thread becomes runnable. It's ready to run and is waiting for
      CPU time.
    - **Running:** The thread is in this state when it is executing.
    - **Blocked/Waiting:** A thread is in this state when its is waiting for resources or for another thread to perform
      an action.
    - **Terminated:** A thread is in this state when it has finished executing.

  ```java
  public class MyThread extends Thread {
      @Override
      public void run() {
          System.out.println("RUNNING");
          try {
              Thread.sleep(200);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      }
  
      public static void main(String[] args) throws  InterruptedException {
          MyThread thread = new MyThread();
          System.out.println(thread.getState());
          thread.start();
          System.out.println(thread.getState());
          Thread.sleep(100);
          System.out.println(thread.getState());
          thread.join();
          System.out.println(thread.getState());
      }
  }
  ```

### 5. Java Thread vs Runnable: The SHOCKING Truth!

- extends Thread → Inherits the Thread class; your class is a thread.
- implements Runnable → Provides code for a thread; your class is not a thread, only a task.
- Using Runnable is preferred because Java allows only one class to be extended (single inheritance).

### 6. Master Java Threads: Essential Methods to Elevate Your Coding!

- run: Contains the code that defines the task to be executed by the thread.
```java
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("RUNNING");
        }
    }
}
```

- start: Begins a new thread by calling its `run()` method internally.
```java
public class MyThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("RUNNING");
        }
    }

}
```

- sleep: Temporarily pauses the current thread for a specified time.
```java
public class MyThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("RUNNING");
        }
    }
}
```

- join: Makes the current thread wait until the specified thread has finished execution.
```java
public class MyThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println("Exit.");
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("RUNNING");
        }
    }
}
```

- setPriority: Sets the priority level of a thread to influence the thread scheduling.
```java
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread("MyThread");
        myThread.setPriority(Thread.MAX_PRIORITY);
        myThread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Name: " + Thread.currentThread().getName() + ", Priority: " + Thread.currentThread().getPriority() + ", count: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```

- yield: Pauses the current thread to allow other threads of the same priority to execute.
```java
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread("T1");
        myThread1.start();
        MyThread myThread2 = new MyThread("T2");
        myThread2.start();
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + " is running.");
            Thread.yield();
        }
    }
}
```

- setDaemon: Marks a thread as a daemon thread, which automatically ends when all user threads finish.
```java
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread("T1");
        thread.setDaemon(true);
        thread.start();
        System.out.println("Main Done.");
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Namaste! Daemon.");
        }
    }
}
```
  
### 7. Master Synchronization & the synchronized Keyword

- synchronized method
```java
public class Counter {
    private int count;

    // synchronized method
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class MyThread extends Thread {
    final private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
        final Counter counter = new Counter();
        MyThread myThread1 = new MyThread(counter);
        MyThread myThread2 = new MyThread(counter);
        myThread1.start();
        myThread2.start();
        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter count is: " + counter.getCount());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
```

- synchronized block
```java
public class Counter {
    private int count;

    public void increment() {
        // synchronized block
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

class MyThread extends Thread {
    final private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
        final Counter counter = new Counter();
        MyThread myThread1 = new MyThread(counter);
        MyThread myThread2 = new MyThread(counter);
        myThread1.start();
        myThread2.start();
        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter count is: " + counter.getCount());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
```

- Mutual Exclusion - It's a concept in concurrent programming where only one thread or process can access a shared resource (like a variable, file, or critical section) at a time, to prevent data inconsistency or race conditions. 

### 8. 🔒 Java Locks Explained! Why Senior Developers LOVE ReentrantLock

- Lock - A lock is a synchronization mechanism used to control access to a shared resource in multithreaded programming. It allows only one thread to access the resource at a time, ensuring mutual exclusion. In Java, locks can be implemented using:
  - `synchronized` blocks/methods
  - `ReentrantLock` from `java.util.concurrent.locks`

- Locks are 2 types
  1. Intrinsic - These are build into every object in Java. You don't see them, but they're there. When you used a synchronized keyword, you're using these automatic locks.
  2. Explicit - These are more advanced locks you can control yourself using the Lock class from `java.util.concurrent.locks`. You explicitly say when to lock and unlock, giving you more control over how and when user can use the resources. 

- Lock methods -
  1. `lock()`: Acquires the lock, blocking the current thread indefinitely until it is available.
  2. `tryLock()`: Attempts to acquire the lock immediately; returns `true` if successful, otherwise `false`.
  3. `tryLock(long time, TimeUnit unit)`: Tries to acquire the lock within the specified waiting time; returns `true` if successful before timeout.
  4. `unlock()`: Releases the lock held by the current thread, allowing others to acquire it.
  5. `lockInterruptibly()`: Acquires the lock unless the current thread is interrupted while waiting, in which case it throws `InterruptedException`.
