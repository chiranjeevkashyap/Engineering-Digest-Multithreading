package method;

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