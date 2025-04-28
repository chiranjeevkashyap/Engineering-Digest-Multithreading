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
- Example - 
  - ```java
    public class Main {
        public static void main(String[] args) {
            System.out.println("Namaste! Java");
            System.out.println(Thread.currentThread().getName());
        }
    }
    ```
  - ```shell
    Namaste! Java
    main
    
    Process finished with exit code 0
    ```
