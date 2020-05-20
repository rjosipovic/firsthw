package home.playground.first;

import home.playground.common.StringConcatenator;

import java.util.Arrays;

public class ExecuteOperation {

    public static String factorial(int number) {
        long res = 1;
        for(int i = 1; i <= number; i++) {
            res *= i;
        }
        return String.format("%d! = %d", number, res);
    }

    public static String primes(int number) {
        StringConcatenator concatenate = new StringConcatenator('*');
        int[] primes = primesArray(number/2);
        int devider = number;
        for(int i = 0; i < primes.length; i++) {
            while(devider % primes[i] == 0) {
                concatenate.add(Integer.toString(primes[i]));
                devider /= primes[i];
            }
        }
        if(concatenate.toString().isEmpty()) {
            concatenate.add(String.format("%d is prime", number));
        }
        return concatenate.toString();
    }

    public static int[] primesArray(int n) {
        int[] primeCandidates = new int[n];
        for(int i = 0, j=2; i < n - 1; i++,j++) {
            primeCandidates[i] = j;
        }
        int[] primes = new int[primeCandidates.length];
        for(int i = 0; i < primes.length; i++) {
            if(i == 0) {
                primes[0] = 2;
            } else if(i == 1) {
                primes[1] = 3;
            } else {
                primes[i] = 0;
            }
        }
        for(int i = 0, k=2; i < primeCandidates.length; i++) {
            if(primeCandidates[i] == 2 || primeCandidates[i] == 3) {continue;}
            boolean isDevisable = Boolean.FALSE;
            for(int j= 0; j < primes.length; j++) {
                if(primes[j] == 0) {break;}
                if(primeCandidates[i] % primes[j] == 0) {
                    isDevisable = Boolean.TRUE;
                    break;
                }
            }
            if(!isDevisable) {
                primes[k++]=primeCandidates[i];
            }
        }
        int primeCount = 0;
        for(int i=0; i < primes.length; i++) {
            if(primes[i] != 0) {primeCount++;}
        }
        int[] realPrime = new int[primeCount];
        for(int i = 0; i < realPrime.length; i++) {
            realPrime[i] = primes[i];
        }
        return realPrime;
    }

    public static String denominator(int n, int m) {
        int max = Math.max(n, m);
        for(int i = max; i <= n*m; i++) {
            if((i % n == 0) && (i % m == 0)) {
                return String.format("LCD(%d, %d) = %d", n, m, i);
            }
        }
        throw new RuntimeException("Unexpected error: could not find LCD");
    }
}
