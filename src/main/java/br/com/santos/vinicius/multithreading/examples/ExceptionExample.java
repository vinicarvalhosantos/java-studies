package br.com.santos.vinicius.multithreading.examples;

public class ExceptionExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional Exception");
        });

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("A critical error happened in thread".concat(t.getName()).concat(" the error is ").concat(e.getMessage()));
        });
        thread.start();
    }
}
