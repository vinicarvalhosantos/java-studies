package br.com.santos.vinicius.multithreading.exercises;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MultithreadCalculation {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(calculateResult(new BigInteger("10"), new BigInteger("2"), new BigInteger("10"), new BigInteger("2")));
    }

    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result = BigInteger.ZERO;
        List<PowerCalculatingThread> threads = new ArrayList<>();

        threads.add(new PowerCalculatingThread(base1, power1));
        threads.add(new PowerCalculatingThread(base2, power2));

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (int i = 0; i < 2; i++) {
            PowerCalculatingThread calculatingThread = threads.get(i);
            if (calculatingThread.isFinished()) {

                System.out.println("Result is " + calculatingThread.getResult());
                result = result.add(calculatingThread.getResult());
            }
        }

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private final BigInteger base;
        private final BigInteger power;
        private boolean isFinished = false;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            pow(this.base, this.power);
            this.isFinished = true;
        }

        private void pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }

            this.result = result;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}
