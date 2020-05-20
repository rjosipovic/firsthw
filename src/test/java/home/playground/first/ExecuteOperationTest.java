package home.playground.first;

import home.playground.first.ExecuteOperation;
import org.junit.Assert;
import org.junit.Test;

public class ExecuteOperationTest {

    @Test
    public void testFactorial() {
        String res = ExecuteOperation.factorial(10);
        Assert.assertEquals("10! = 3628800", res);
    }

    @Test
    public void testPrimes1() {
        Assert.assertEquals("1 is prime", ExecuteOperation.primes(1));
    }

    @Test
    public void testPrimes7() {
        Assert.assertEquals("7 is prime", ExecuteOperation.primes(7));
    }

    @Test
    public void testPrimes10() {
        Assert.assertEquals("2*5", ExecuteOperation.primes(10));
    }

    @Test
    public void testPrimes135() {
        Assert.assertEquals("3*3*3*5", ExecuteOperation.primes(135));
    }

    @Test
    public void testPrimes150() {
        Assert.assertEquals("2*3*5*5", ExecuteOperation.primes(150));
    }
}
