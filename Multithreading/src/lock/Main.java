package lock;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdrawUsingLock(50);
            }
        };
        Thread thread1 = new Thread(task, "T1");
        Thread thread2 = new Thread(task, "T2");
        thread1.start();
        thread2.start();
    }
}
