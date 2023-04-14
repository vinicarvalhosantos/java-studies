package br.com.santos.vinicius.exercises;

import br.com.santos.vinicius.multithreading.exercises.MultithreadCalculation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class MultithreadCalculationTest {

    @Test
    public void testSuccess() throws InterruptedException {
        BigInteger base1 = new BigInteger("10");
        BigInteger pow1 = new BigInteger("2");
        BigInteger base2 = new BigInteger("10");
        BigInteger pow2 = new BigInteger("2");

        BigInteger result = MultithreadCalculation.calculateResult(base1, pow1, base2, pow2);

        Assertions.assertEquals(new BigInteger("200"), result);

        base1 = new BigInteger("50");
        pow1 = new BigInteger("4");
        base2 = new BigInteger("10");
        pow2 = new BigInteger("2");

        result = MultithreadCalculation.calculateResult(base1, pow1, base2, pow2);

        Assertions.assertEquals(new BigInteger("6250100"), result);

        base1 = new BigInteger("50");
        pow1 = new BigInteger("4");
        base2 = new BigInteger("50");
        pow2 = new BigInteger("4");

        result = MultithreadCalculation.calculateResult(base1, pow1, base2, pow2);

        Assertions.assertEquals(new BigInteger("12500000"), result);

        base1 = new BigInteger("5000");
        pow1 = new BigInteger("40");
        base2 = new BigInteger("50");
        pow2 = new BigInteger("4");

        result = MultithreadCalculation.calculateResult(base1, pow1, base2, pow2);

        BigInteger bigResult = new BigInteger("9094947017729282379150390625000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006250000");
        Assertions.assertEquals(bigResult, result);
    }

}
