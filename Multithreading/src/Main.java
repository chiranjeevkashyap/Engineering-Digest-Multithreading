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
