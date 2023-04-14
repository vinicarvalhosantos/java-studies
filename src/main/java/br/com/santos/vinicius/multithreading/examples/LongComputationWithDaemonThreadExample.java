package br.com.santos.vinicius.multithreading.examples;

import java.math.BigInteger;

public class LongComputationWithDaemonThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationWithDaemonThreadTask(new BigInteger("2000000"), new BigInteger("1000000")));

        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }

    private static class LongComputationWithDaemonThreadTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationWithDaemonThreadTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }

            return result;
        }
    }
}
