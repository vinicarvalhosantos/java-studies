package br.com.santos.vinicius.multithreading.examples;

public class RenameAndPriorityExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("We are in thread: ".concat(Thread.currentThread().getName()));
            System.out.println("Current thread priority is ".concat(String.valueOf(Thread.currentThread().getPriority())));
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: ".concat(Thread.currentThread().getName()).concat(" before starting a new thread"));
        thread.start();
        System.out.println("We are in thread: ".concat(Thread.currentThread().getName()).concat(" after starting a new thread"));

        Thread.sleep(10000);
    }
}
