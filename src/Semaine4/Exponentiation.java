package Semaine4;

public class Exponentiation {

    public static long puissance(int a, int k) {
        if(k < 0){
            throw new IllegalArgumentException("k ne peut pas etre negatif");
        }

        long res = 1;
        long p = a;

        for (int i = k; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                res = res * p;
            }
            p = p * p;
        }
        return res;
    }
}
