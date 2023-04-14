package br.com.santos.vinicius.multithreading.examples;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsingThreadJoiningExample {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(10000000000L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);
        //We want to calculate the !0, !3435, !35435, !4656, !23, !2435, !5566

        List<FactorialThread> threads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (Thread thread : threads) {
            /* It is possible to use thread.setDeamon(true) here as well instead of the thread.interrupt() in line 28,
             but I wanted to show a message when the thread is interrupted by the joining limit time.
             */
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join(2000);
            thread.interrupt();
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {

                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else if (factorialThread.isInterrupted()) {

                System.out.println("Factorial of " + inputNumbers.get(i) + " was interrupted because it took more than 2 seconds to calculate!");
            } else {

                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }

    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for (long i = n; i > 0; i--) {
                if (currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation.");
                    return BigInteger.ONE;
                }
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }

            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}
